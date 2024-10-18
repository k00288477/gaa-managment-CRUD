<script setup>

import { ref } from "vue";

// Define a prop named 'event' to receive the event details
const props = defineProps({
  event: Object
});
</script>

<template>

    <h2>Event Details</h2>

    <form>
      <fieldset disabled>
        <div class="mb-3" style="display: none">
          <input type="text" v-model="event.event_id">
        </div>
        <div class="mb-3">
          <label for="eventName" class="form-label">Name:</label>
          <input type="text" id="eventName" class="form-control" v-model="event.name">
        </div>
        <div class="mb-3">
          <label for="eventLocation" class="form-label">Location:</label>
          <input type="text" id="eventLocation" class="form-control" v-model="event.location">
        </div>
        <div class="mb-3">
          <label for="eventType" class="form-label">Type:</label>
          <input type="text" id="eventType" class="form-control" v-model="event.type">
        </div>
        <div class="mb-3">
          <label for="eventDate" class="form-label">Date:</label>
          <input type="text" id="eventDate" class="form-control" v-model="event.date">
        </div>
        <div class="mb-3">
          <label for="eventTime" class="form-label">Time:</label>
          <input type="text" id="eventTime" class="form-control" v-model="event.time">
        </div>
        <div class="mb-3">
          <label for="eventPrice" class="form-label">Ticket Price:</label>
          <input type="text" id="eventPrice" class="form-control" v-model="event.ticket_price">
        </div>

        <div class="mb-3">
          <label for="eventOrganiser" class="form-label">Organiser:</label>
          <input type="text" id="eventOrganiser" class="form-control" v-model="event.organiser">
        </div>
      </fieldset>
    </form>

</template>
<script>


</script>
<style scoped>
  .mb-3 {
    text-align: left;
  }
</style>