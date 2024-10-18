
<template>
  <Header/>
  <h2>Update Event Details</h2>

  <form @submit.prevent="submitForm">

    <div class="mb-3" style="display: none">
      <input type="text" v-model="event.event_id">
    </div>
    <div class="mb-3">
      <label for="event_name" class="form-label">Event Name:</label>
      <span v-if="validationErrors.name" class="text-danger">{{ validationErrors.name }}</span>
      <input type="text" id="event_name" class="form-control" v-model="event.name">
    </div>
    <div class="mb-3">
      <label for="event_location" class="form-label">Location:</label>
      <span v-if="validationErrors.location" class="text-danger">{{ validationErrors.location }}</span>
      <input type="text" id="event_location" class="form-control" v-model="event.location">
    </div>
    <div class="mb-3">
      <label for="event_type" class="form-label">Type:</label>
      <span v-if="validationErrors.type" class="text-danger">{{ validationErrors.type }}</span>
      <input type="text" id="event_type" class="form-control" v-model="event.type">
    </div>
    <div class="mb-3">
      <label for="event_date" class="form-label">Date:</label>
      <span v-if="validationErrors.date" class="text-danger">{{ validationErrors.date }}</span>
      <input type="date" id="event_date" class="form-control" v-model="event.date">
    </div>
    <div class="mb-3">
      <label for="event_time" class="form-label">Start Time:</label>
      <span v-if="validationErrors.time" class="text-danger">{{ validationErrors.time }}</span>
      <input type="text" id="event_time" class="form-control" v-model="event.time">
    </div>
    <hr>
    <div class="mb-3">
      <label for="event_price" class="form-label">Ticket Price: €</label>
      <span v-if="validationErrors.price" class="text-danger">{{ validationErrors.price.toFixed(2) }}</span>
      <input type="text" id="event_price" class="form-control" v-model="event.ticket_price">
    </div>

    <div class="container-sm d-flex justify-content-center align-items-center">
      <button type="submit" class="btn btn-primary">Save Details</button>
      <button type="reset" class="btn btn-outline-light">Reset</button>
    </div>

  </form>
  <Footer/>
</template>

<script setup>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

import axios from 'axios';
import {computed, onMounted, ref} from "vue";
import {useRoute} from "vue-router";
import router from "@/router.js";
//
const event = ref({});
const validationErrors = ref({});
function formatTime(time) {
  const [hours, minutes] = time;
  return `${hours}:${minutes < 10 ? '0' : ''}${minutes}`;
}

onMounted(() => {
  const id = useRoute().params.id;
  console.log(id)
  // find the event
  axios.get(`http://localhost:8080/api/gaaManagementSystem/find-event/${id}`)
      .then(response => {
        event.value = response.data;
      })
      .catch(error => {
        console.error("Error loading data: ", error);
      });
  //const formattedTime = computed(() => formatTime(this.event.value.time));
  return {
    event: event.value,
    validationErrors: validationErrors.value
    //formattedTime
  }
});
// PUT request to save user details
async function submitForm() {
  // validation logic
  // clear previous errors
  validationErrors.value = {};

  // first name field filled
  if (!event.value.name) {
    validationErrors.value.first_name = "*Event name is required";
    return;
  }
  // last name filled
  if (!event.value.location) {
    validationErrors.value.location = "*Location is required";
    return;
  }

  // dob filled
  if (!event.value.type) {
    validationErrors.value.type = "*Event type is required";
    return;
  }
  if (!event.value.date) {
    validationErrors.value.contact_no = "*Event date is required";
    return;
  }
  function timeRegex(time) {
    const pattern = /^([01]?[0-9]|2[0-3]):[0-5][0-9]$/;
    return pattern.test(time);
  }
  if (!event.value.time || !timeRegex(event.value.time)) {
    validationErrors.value.time = "*Event time must be in 24hr format e.g. 19:00";
    return;
  }
  function priceRegex(price) {
    const pattern = /^\d+(\.\d{1,2})?$/;
    return pattern.test(price);
  }
  if (!event.value.ticket_price || !priceRegex(event.value.ticket_price)) {
    validationErrors.value.price = "*Ticket Price must be in decimal format e.g. 4.99";
    return;
  }

  // method to update event
  try {
    console.log("put method reached")
    await axios.put(`http://localhost:8080/api/gaaManagementSystem/update-event/${event.value.event_id}`, event.value);
    // Reset form fields after successful submission
    event.value = {
      event_id: '',
      name: '',
      location: '',
      type: '',
      date: '',
      time: '',
      ticket_price: ''
    }
  } catch (error) {
    console.error('Error adding event:', error);
  }
  await router.push({path: '/admin-portal'})
}
</script>

<style scoped>
h2, label {
  color: white;
}

h2 {
  text-align: center;
  margin-top: 2em;
}

form {
  width: 40%;
  margin: auto auto 3em;
}

hr {
  height: 4px;
  background-color: #7EC19D;
}

label, .btn-primary {
  margin-right: 1em;
}



</style>