

<template>
  <div>
    <h2>All Events</h2>
    <table class="table table-hover custom-bg-color">
      <thead>
      <tr>
        <th>Event Name</th>
        <th>Type</th>
        <th>Location</th>
        <th>Date</th>
        <th>Time</th>
        <th>Ticket Price</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="event in events" :key="event.event_id">
        <td style="display: none">{{ event.event_id}}</td>
        <td>{{ event.name }}</td>
        <td>{{ event.type }}</td>
        <td>{{ event.location }}</td>
        <td>{{ formatDate(event.date) }}</td>
        <td>{{ formatTime(event.time) }}</td>
        <td>€{{ event.ticket_price.toFixed(2) }}</td>

      </tr>
      </tbody>
    </table>
  </div>



</template>

<style scoped>

</style>

<script setup>
import {ref, onMounted} from "vue";
import axios from 'axios';

const events = ref([]);

onMounted(() => {
  axios.get('http://localhost:8080/api/gaaManagementSystem/events-list')
      .then(response => {
        events.value = response.data;
      })
      .catch(error => {
        console.error("Error loading data: ", error);
      });
  return {events, formatDate, formatTime};
});

// Function to format date
function formatDate(date) {
  return new Date(date).toLocaleDateString('en-GB', {
    day: 'numeric',
    month: 'short',
    year: 'numeric'
  });
}

// Function to format time
function formatTime(time) {
  const [hours, minutes] = time;
  return `${hours}:${minutes < 10 ? '0' : ''}${minutes}`;
}




</script>
