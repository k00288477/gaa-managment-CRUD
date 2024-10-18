

<template>
  <div>
    <div class="container-fluid">
      <div class="row justify-content-center">
        <div class="col">
          <h2 class="text-center">All Teams</h2>
        </div>
        <div class="col-auto">
          <button type="button" class="btn btn-primary">
            <router-link to="/add-team" style="color: #ebeff1; text-decoration: none">Add Team</router-link>
          </button>
        </div>
      </div>
    </div>
    <table class="table table-hover">
      <thead>
      <tr>
        <th>Team Name</th>
        <th>Type</th>
        <th>Level</th>
        <th>Action</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="team in teams" :key="team.team_id">
        <td>{{ team.name }}</td>
        <td>{{ team.type }}</td>
        <td>{{ team.level }}</td>
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
    const teams = ref([]);

    onMounted(()=> {
      axios.get('http://localhost:8080/api/gaaManagementSystem/team-list')
          .then(response => {
            teams.value = response.data;
          })
          .catch(error => {
            console.error("Error loading data: ", error);
          })

    });
    return { teams };
  }

}
</script>

<style scoped>
.btn-primary {
  background-color: #172161;
  border: 0;
}
.btn-primary:hover {
  opacity: 75%;
}
router-link {
  color: #ebeff1;
  text-decoration: none;
}
</style>
