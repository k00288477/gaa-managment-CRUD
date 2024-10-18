

<template>
  <div>
    <div class="container-fluid">
      <div class="row justify-content-center">
        <div class="col">
          <h2 class="text-center">All Events</h2>
        </div>
        <div class="col-auto">
          <button type="button" class="btn btn-primary">
            <router-link to="/add-event" style="color: #ebeff1; text-decoration: none">Add Event</router-link>
          </button>
        </div>
      </div>
    </div>


    <table class="table table-hover custom-bg-color">
      <thead>
      <tr>
        <th>Event Name</th>
        <th>Type</th>
        <th>Location</th>
        <th>Date</th>
        <th>Time</th>
        <th>Ticket Price</th>
        <th>Actions</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="event in events" :key="event.event_id">
        <td>{{ event.name }}</td>
        <td>{{ event.type }}</td>
        <td>{{ event.location }}</td>
        <td>{{ formatDate(event.date) }}</td>
        <td>{{ formatTime(event.time) }}</td>
        <td>€{{ event.ticket_price.toFixed(2) }}</td>
        <td>
          <div class="d-flex justify-content-center align-content-center">
            <button type="button" class="btn btn-warning" style="margin-right: 0.5em"><router-link :to="{path: '/update-event/' + event.event_id}" class="link">Edit</router-link></button>
            <button type="button" class="btn btn-danger" @click="deleteEvent(event.event_id)">Delete</button>
          </div>
        </td>

      </tr>
      </tbody>
    </table>
  </div>

</template>

<style scoped>
.btn-primary {
  background-color: #172161;
  border: 0;
}
.btn-primary:hover {
  opacity: 75%;
}
.link {
  text-decoration: none;
  color: #1a1a1a;
}
</style>

<script setup>
import {ref, onMounted} from "vue";
import axios from 'axios';
import router from "@/router.js";

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

    async function deleteEvent(id){
      try{
        await axios.delete(`http://localhost:8080/api/gaaManagementSystem/delete-event/${id}`);
        window.location.reload();
      } catch (error) {
        console.log("Event deleted successfully")
      }
    }
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
