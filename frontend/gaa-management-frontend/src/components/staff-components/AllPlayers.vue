

<template>
  <div>
    <h2>Players List</h2>
    <table class="table table-hover">
      <thead>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email Address</th>
        <th>Address</th>
        <th>Contact Number</th>
        <th>Registered</th>
        <th>Team</th>
        <th>Action</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="player in players" :key="player.player_id">
        <td>{{ player.first_name }}</td>
        <td>{{ player.last_name }}</td>
        <td>{{ player.email }}</td>
        <td>{{ player.address1 + ", " + player.address2 + ", " + player.address3}}</td>
        <td>0{{ player.contact_no }}</td>
        <td>{{ player.registered }}</td>
        <td>{{ player.team.name }} {{ player.team.type }} {{ player.team.level }}</td>
        <td>
          <div class="d-flex justify-content-center align-content-center">
            <button type="button" class="btn btn-warning" style="margin-right: 0.5em">Edit</button>
            <button type="button" class="btn btn-danger">Delete</button>
          </div>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import {ref, onMounted} from "vue";
import axios from 'axios';

export default {


  setup() {
    const players = ref([]);

    onMounted(()=> {
      axios.get('http://localhost:8080/api/gaaManagementSystem/player-list')
          .then(response => {
            players.value = response.data;
          })
          .catch(error => {
            console.error("Error loading data: ", error);
          })

    });
    return { players };
  }

}
</script>
