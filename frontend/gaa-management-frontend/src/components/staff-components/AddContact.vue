<script setup>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";


</script>

<template>
  <Header />

  <h2>Add New Contact</h2>

  <form @submit.prevent="submitForm">

    <div class="mb-3" style="display: none">
      <input type="text" v-model="contact.id">
    </div>
    <div class="mb-3">
      <label for="c_name" class="form-label">Contact Name: </label>
      <span v-if="validationErrors.name" class="text-danger">{{ validationErrors.name }}</span>
      <input type="text" id="c_name" class="form-control" v-model="contact.name">
    </div>

    <div class="mb-3">
      <label for="c_num" class="form-label">Contact Number: </label>
      <span v-if="validationErrors.c_num" class="text-danger">{{ validationErrors.c_num }}</span>
      <input type="text" id="c_num" class="form-control" v-model="contact.contact_number">
    </div>

    <div class="mb-3">
      <label for="c_email" class="form-label">Contact Email: </label>
      <span v-if="validationErrors.email" class="text-danger">{{ validationErrors.email }}</span>
      <input type="text" id="c_email" class="form-control" v-model="contact.email">
    </div>


    <div class="container-sm d-flex justify-content-center align-items-center">
      <button type="submit" class="btn btn-primary">Add Contact</button>
      <button type="reset" class="btn btn-outline-light">Reset</button>
    </div>

  </form>

  <Footer />
</template>

<script>
import {onMounted, ref} from "vue";
import axios from "axios";
import router from "@/router.js";

export default {
  data() {
    return {
      contact: {
        id: '',
        name: '',
        contact_number: '',
        club: ''
      },
      validationErrors: {}
    };
  },

  methods: {
    async submitForm() {
      this.validationErrors = {};

      if(!this.contact.name){
        this.validationErrors.name = "*Name is required";
        return;
      }

      function contactNumberRegex(contact_no) {
        const numberPattern = /^08\d{8}$/;
        return numberPattern.test(contact_no);
      }
      if(!this.contact.contact_number || !contactNumberRegex(this.contact.contact_number)){
        this.validationErrors.c_num = "*An Irish Phone number starts with \"08\" followed by 8 digits";
        return;
      }

      function emailRegex(email) {
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailPattern.test(email);
      }
      if(!this.contact.email || !emailRegex(this.contact.email)){
        this.validationErrors.email = "*An email is required: example@example.com";
        return;
      }

      // POST request
      try {
        await axios.post('http://localhost:8080/api/gaaManagementSystem/add-contact', this.contact);
        // Reset form fields after successful submission
        this.contact = {
          id: '',
          name: '',
          contact_number: '',
          club: ''
        };

      } catch (error) {
        console.error('Error adding contact:', error);
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