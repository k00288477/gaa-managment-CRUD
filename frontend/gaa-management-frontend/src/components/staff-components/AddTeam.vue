<script setup>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import {onMounted, ref} from "vue";
import axios from "axios";

//const validationErrors = ref({}); // Use ref for reactive validation errors
const clubs = ref([]); // Use ref for reactive clubs array

const getClubs = () => {
  axios.get('http://localhost:8080/api/gaaManagementSystem/all-clubs')
      .then(response => {
        clubs.value = response.data; // Assign to clubs.value
      })
      .catch(error => {
        // Handle errors if the request fails
        console.error('Error fetching clubs:', error);
      });
};


onMounted(() => {
  getClubs();
});
</script>
<template>
    <Header />

    <h2>Add New Team</h2>

    <form @submit.prevent="submitForm" class="form">

      <div class="mb-3" style="display: none">
        <input type="text" v-model="team.team_id">
      </div>
      <div class="mb-3">
        <label for="team_name" class="form-label">Team Name: </label>
        <span v-if="validationErrors.name" class="text-danger">{{ validationErrors.name }}</span>
        <input type="text" id="team_name" class="form-control" v-model="team.name">
      </div>


      <div class="mb-3">
        <label for="team_club" class="form-label">Club:</label>
<!--        <span v-if="validationErrors.club" class="text-danger">{{ validationErrors.club }}</span>-->
        <select id="team_club" class="form-control" v-model="team.club">
          <option v-for="club in clubs" :key="club.id" :value="club.id">{{ club.name }}</option>
        </select>
      </div>

      <div class="mb-3">
        <label for="team_type" class="form-label">Type:</label>
        <span v-if="validationErrors.type" class="text-danger">{{ validationErrors.type }}</span>
        <select id="team_type" class="form-control" v-model="team.type">
          <option>HURLING</option>
          <option>CAMOGIE</option>
          <option>MENS_FOOTBALL</option>
          <option>LADIES_FOOTBALL</option>
          <option>MENS_HANDBALL</option>
          <option>LADIES_HANDBALL</option>
        </select>
      </div>

      <div class="mb-3">
        <label for="team_level" class="form-label">Level:</label>
        <span v-if="validationErrors.level" class="text-danger">{{ validationErrors.level }}</span>
        <select id="team_level" class="form-control" v-model="team.level">
          <option>SENIOR</option>
          <option>INTERMEDIATE</option>
          <option>JUNIOR</option>
          <option>MINOR</option>
          <option>U16</option>
          <option>U14</option>
          <option>U12</option>
          <option>U10</option>
          <option>U8</option>
        </select>
      </div>

      <div class="container-sm d-flex justify-content-center align-items-center">
        <button type="submit" class="btn btn-primary">Add Team</button>
        <button type="reset" class="btn btn-outline-light">Reset</button>
      </div>

    </form>
    <Footer />
</template>


<script>
import axios from 'axios';
import router from "@/router.js";
import { onMounted, ref } from "vue";

export default {
  data() {
    return {
      team: {
        team_id: '',
        name: '',
        type: null,
        level: null,
        club: null
      },
      validationErrors: {}
    };
  },

    methods: {
        async submitForm() {
        this.validationErrors = {};

        if(!this.team.name){
          this.validationErrors.name = "*Team name is required";
          return;
        }

        if(!this.team.type){
          this.validationErrors.type = "*Type is required";
          return;
        }

        if(!this.team.level){
          this.validationErrors.level = "*Level is required";
          return;
        }
      // POST request
      try {
        await axios.post('http://localhost:8080/api/gaaManagementSystem/add-team', this.team);
        // Reset form fields after successful submission
        this.team = {
          team_id: '',
          name: '',
          type: '',
          level: '',
          club: ''
        };

      } catch (error) {
        console.error('Error adding team:', error);
      }
      // Direct user to admin portal
      await router.push({ path: '/admin-portal' });
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

.form {
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