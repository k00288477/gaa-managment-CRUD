<script setup>
import {onMounted, ref} from "vue";
import axios from "axios";
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

const events = ref([]);

onMounted(()=> {
  axios.get('http://localhost:8080/api/member-portal/events-list')
      .then(response => {
        events.value = response.data;
      })
      .catch(error => {
        console.error("Error loading data: ", error);
      });
})

// format date
const formatDate = (date) => {
  return new Date(date).toLocaleDateString('en-GB', {
    day: 'numeric',
    month: 'short',
    year: 'numeric'
  });
}

// format time
  const formatTime = (time) => {
  const [hours, minutes] = time;
  return `${hours}:${minutes < 10 ? '0' : ''}${minutes}`;
}

</script>

<template>
<Header />
<h1>Upcoming Events</h1>
  <div class="container-fluid event-container" v-for="event in events" :key="event.event_id">
    <span style="display: none">{{ event.event_id }}</span>
    <h2>{{ event.name }}</h2>
    <h3>{{event.type}}</h3>
    <div class="d-flex">
    <ul class="flex-row container-fluid">
      <li>Venue: {{event.location}}</li>
      <li>Date: {{formatDate(event.date)}}</li>
      <li>Start Time: {{formatTime(event.time)}}</li>
      <li>Ticket Price: €{{event.ticket_price.toFixed(2)}}</li>
    </ul>
    </div>


  </div>
<Footer />
</template>

<style scoped>
h1 {
  color: #ebeff1;
  text-align: center;
  margin-top: 1em;
  margin-bottom: 1em;
}
.event-container {
  color:white;
  width: 80%;
  background-color: #303030;
  border: 1px solid #004411;
  margin: auto auto 1em;
  padding: 1em;
}
.event-container:hover {
  opacity: 70%;
}
ul {
  list-style-type: none;
  width: 100%;
  margin: auto;
}
li {
  display: inline-block;
  margin: 1em;
}
</style>