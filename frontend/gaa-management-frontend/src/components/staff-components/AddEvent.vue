<script setup>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

</script>
<template>
  <Header />

  <h2>New Event</h2>

  <form @submit.prevent="submitForm">

    <div class="mb-3" style="display: none">
      <input type="text" v-model="event.event_id">
    </div>
    <div class="mb-3">
      <label for="event_name" class="form-label">Event Name:</label>
      <input type="text" id="event_name" class="form-control" v-model="event.name">
    </div>
    <div class="mb-3">
      <label for="event_location" class="form-label">Location:</label>
      <input type="text" id="event_location" class="form-control" v-model="event.location">
    </div>
    <div class="mb-3">
      <label for="event_type" class="form-label">Type:</label>
      <input type="text" id="event_type" class="form-control" v-model="event.type">
    </div>
    <div class="mb-3">
      <label for="event_date" class="form-label">Date:</label>
      <input type="date" id="event_date" class="form-control" v-model="event.date">
    </div>
    <div class="mb-3">
      <label for="event_time" class="form-label">Start Time:</label>
      <input type="text" id="event_time" class="form-control" v-model="event.time">
    </div>
    <hr>
    <div class="mb-3">
      <label for="event_price" class="form-label">Ticket Price: €</label>
      <input type="text" id="event_price" class="form-control" v-model="event.ticket_price">
    </div>

    <<div class="container-sm d-flex justify-content-center align-items-center">
    <button type="submit" class="btn btn-primary">Add Event</button>
    <button type="reset" class="btn btn-outline-light">Reset</button>
  </div>

  </form>
  <Footer />
</template>

<script>
import axios from 'axios';
import router from "@/router.js";
export default {
  data() {
    return {
      event: {
        event_id: '',
        name: '',
        location: '',
        type: '',
        date: '',
        time: '',
        ticket_price: ''
        // organiser: ''
      }
    };
  },
  methods: {
    async submitForm() {
      try {
        await axios.post('http://localhost:8080/api/gaaManagementSystem/add-event', this.event);
        console.log('success')
        // Reset form fields after successful submission
        this.event = {
          event_id: '',
              name: '',
              location: '',
              type: '',
              date: '',
              time: '',
              ticket_price: ''
              // organiser: ''
        }
      } catch (error) {
        console.error('Error adding event:', error);
      }
      await router.push({path: '/admin-portal'})
    }
  }
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
  margin: auto;
  margin-bottom: 3em;
}

hr {
  height: 4px;
  background-color: #7EC19D;
}
label, .btn-primary {
  margin-right: 1em;
}


</style>