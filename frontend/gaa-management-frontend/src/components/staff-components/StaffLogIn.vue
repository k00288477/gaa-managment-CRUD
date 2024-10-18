<script setup>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
</script>

<template>
<Header />
  <div class="container-fluid d-flex flex-column login">
  <h1>Staff Log-In</h1>

  <p>Please Complete Log In to view the admin dashboard</p>

    <form @submit.prevent="logIn">
      <div class="mb-3">
        <label for="staff_email" class="form-label">Email: </label>
        <span v-if="validationErrors.email" class="text-danger">{{ validationErrors.email }}</span>
        <input type="text" id="staff_email" class="form-control" v-model="staff.email">
      </div>

      <div class="mb-3">
        <label for="staff_password" class="form-label">Password: </label>
        <span v-if="validationErrors.password" class="text-danger">{{ validationErrors.password }}</span>
        <input type="password" id="staff_password" class="form-control" v-model="staff.password">
      </div>
      <div class="mb-3">
        <label for="staff_passwordC" class="form-label">Confirm Password: </label>
        <input type="password" id="staff_passwordC" class="form-control">
      </div>

      <div class="container-sm d-flex flex-column justify-content-center align-items-center">
        <button type="submit" class="btn btn-primary">Log In</button>
        <button type="reset" class="btn btn-outline-light">Reset</button>
      </div>

    </form>
  </div>
  <Footer />
</template>

<script>
import axios from 'axios';
import {useRouter} from "vue-router";
import router from "@/router.js";
export default {

  data() {
    return {
      staff: {
        email: '',
        password: ''
      },
      validationErrors: {} // stores validation errors
    };
  },
  methods: {
    async logIn() {

      this.validationErrors = {};

      function emailRegex(email) {
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailPattern.test(email);
      }

      // email filled & validate with regex
      if (!this.staff.email || !emailRegex(this.staff.email)) {
        this.validationErrors.email = "*An email is required: example@example.com";
        return;
      }
      // validate password
      if (!this.staff.password) {
        this.validationErrors.password = "*Please enter a password, 8 characters and 1 number";
        return;
      }

      function passwordRegex(password) {
        const pattern = /^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$/;
        return pattern.test(password);
      }

      if (!passwordRegex(this.staff.password)) {
        this.validationErrors.password = "*Password must be 8 characters and a number";
        return;
      }
      // check that passwords match
      let confirmPassword = document.getElementById('staff_passwordC').value;
      if (confirmPassword !== this.staff.password) {
        this.validationErrors.password = "*Passwords must match";
        return;
      }

      try {
        // post request to backend to log in method
        //await axios.post(`http://localhost:8080/api/gaaManagementSystem/staff-login/`, this.staff)

        this.staff = {
          email: '',
          password: ''
        }
        // resent confirm password field
        document.getElementById('staff_passwordC').value = '';

      } catch (error) {
        console.log("Error logging in:", error);
      }
      await router.push({path: '/admin-portal'})
    }
  }
}



</script>

<style scoped>
.login {
  color: white;
  width: 40%;
  margin: 3em auto;
  text-align: center;
  border:2px solid #004411;
  padding: 1em;
}
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
label {
  margin-right: 1em;
}
.btn-primary, .btn-outline-light {
  width: 100%;
  margin: auto;
  margin-bottom: 1em;
}

@media screen and (max-width: 770px){
  .login {
    width: 80%
  }
}
</style>