<script setup>
import {onMounted, ref} from "vue";
import axios from "axios";

const contacts = ref([])
// get about page info from backend
onMounted(()=> {
  try {
    axios.get('http://localhost:8080/api/gaaManagementSystem/get-contact-list')
        .then(
            response => {
              contacts.value = response.data;
            })
  } catch (Error) {
    console.log("Error getting contact list", Error);
  }
});


</script>

<template>
  <div>
    <div class="container-fluid">
      <div class="row justify-content-center">
        <div class="col">
          <h2 class="text-center">Contact List</h2>
          <p class="text-center">These contacts will appear on the contact page of this website.</p>
        </div>
        <div class="col-auto">
          <button type="button" class="btn btn-primary">
            <router-link to="/add-contact" style="color: #ebeff1; text-decoration: none">Add Contact</router-link>
          </button>
        </div>
      </div>
    </div>


    <table class="table table-hover custom-bg-color">
      <thead>
      <tr>
        <th>Contact Name</th>
        <th>Number</th>
        <th>Email</th>
        <th>Actions</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="contact in contacts" :key="contact.id">
        <td>{{ contact.name }}</td>
        <td>0{{ contact.contact_number }}</td>
        <td>{{ contact.email }}</td>
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

<style scoped>

</style>