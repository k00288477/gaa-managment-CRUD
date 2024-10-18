<script setup>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

</script>
<template>
  <Header />

  <h2>Add New Staff</h2>

  <form @submit.prevent="submitForm">

    <div class="mb-3" style="display: none">
      <input type="text" v-model="staff.staff_id">
    </div>
    <div class="mb-3">
      <label for="staff_fname" class="form-label">First Name: </label>
      <span v-if="validationErrors.first_name" class="text-danger">{{ validationErrors.first_name }}</span>
      <input type="text" id="staff_fname" class="form-control" v-model="staff.first_name">
    </div>
    <div class="mb-3">
      <label for="staff_lname" class="form-label">Last Name: </label>
      <span v-if="validationErrors.last_name" class="text-danger">{{ validationErrors.last_name }}</span>
      <input type="text" id="staff_lname" class="form-control" v-model="staff.last_name">
    </div>
    <div class="mb-3">
      <label for="staff_email" class="form-label">Email: </label>
      <span v-if="validationErrors.email" class="text-danger">{{ validationErrors.email }}</span>
      <input type="text" id="staff_email" class="form-control" v-model="staff.email">
    </div>
    <div class="mb-3">
      <label for="staff_dob" class="form-label">Date of Birth: </label>
      <span v-if="validationErrors.dob" class="text-danger">{{ validationErrors.dob }}</span>
      <input type="date" id="staff_dob" class="form-control" v-model="staff.dob">
    </div>
    <div class="mb-3">
      <label for="staff_contact" class="form-label">Contact Number: </label>
      <span v-if="validationErrors.contact_no" class="text-danger">{{ validationErrors.contact_no }}</span>
      <input type="tel" id="staff_contact" class="form-control" v-model="staff.contact_no">
    </div>
    <!-- Select dropdown for staff role -->
    <div class="mb-3">
      <label for="staff_role" class="form-label">Role:</label>
      <span v-if="validationErrors.role" class="text-danger" style="text-align: center; display: block ruby">{{ validationErrors.role }}</span>
      <select id="staff_role" class="form-control" v-model="staff.role">
        <option>MANAGER</option>
      </select>
    </div>


    <hr>
    <span v-if="validationErrors.address" class="text-danger" style="text-align: center">{{ validationErrors.address }}</span>
    <div class="mb-3">
      <label for="staff_add1" class="form-label">House Number: </label>
      <input type="text" id="staff_add1" class="form-control" v-model="staff.address1">
    </div>
    <div class="mb-3">
      <label for="staff_add2" class="form-label">Street: </label>
      <input type="text" id="staff_add2" class="form-control" v-model="staff.address2">
    </div>

    <div class="mb-3">
    <label for="staff_add3" class="form-label">City: </label>
    <input type="text" id="staff_add3" class="form-control" v-model="staff.address3">
  </div>

    <hr>

    <span v-if="validationErrors.password" class="text-danger" style="text-align: center">{{ validationErrors.password }}</span>
    <div class="mb-3">
      <label for="staff_password" class="form-label">Password: </label>
      <input type="password" id="staff_password" class="form-control" v-model="staff.password">
    </div>
    <div class="mb-3">
      <label for="staff_passwordC" class="form-label">Confirm Password: </label>
      <input type="password" id="staff_passwordC" class="form-control">
    </div>


    <div class="container-sm d-flex justify-content-center align-items-center">
      <button type="submit" class="btn btn-primary">Add Staff</button>
      <button type="reset" class="btn btn-outline-light">Reset</button>
    </div>

  </form>
  <Footer />
</template>

<script>
import axios from 'axios';
import router from "@/router.js";
export default {

  data() {
    return {
      staff: {
        staff_id: '',
        first_name: '',
        last_name: '',
        email: '',
        dob: '',
        contact_no: '',
        address1: '',
        address2: '',
        address3: '',
        role: '',
        password: ''
      },
      validationErrors: {} // stores validation errors
    };
  },
  methods: {
    async submitForm() {
      // validation logic
      // clear previous errors
      this.validationErrors = {};

      // first name field filled
      if(!this.staff.first_name){
        this.validationErrors.first_name = "*First name is required";
        return;
      }
      // last name filled
      if(!this.staff.last_name){
        this.validationErrors.last_name = "*Last name is required";
        return;
      }
      // email Regular expression
      function emailRegex(email) {
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailPattern.test(email);
      }
      // email filled & validate with regex
      if(!this.staff.email || !emailRegex(this.staff.email)){
        this.validationErrors.email = "*An email is required: example@example.com";
        return;
      }
      // dob filled
      if(!this.staff.dob){
        this.validationErrors.dob = "*Date of Birth is required";
        return;
      }
      // irish phone number regular expression
      function contactNumberRegex(contact_no) {
        const numberPattern = /^08\d{8}$/;
        return numberPattern.test(contact_no);
      }
      // contact number filled and regular expression
      if(!this.staff.contact_no || !contactNumberRegex(this.staff.contact_no)){
        this.validationErrors.contact_no = "*You must enter and Irish phone number: 0871234567";
        return;
      }
      // address fields filled
      if(!this.staff.address1 || !this.staff.address2 || !this.staff.address3){
        this.validationErrors.address = "*All address fields must be filled";
        return;
      }
      // role type selected
      if(!this.staff.role){
        this.validationErrors.role = "*Please select a role, select MISCELLANEOUS if unsure";
        return;
      }
      // password regular expression (8 alphabetic characters and 1 number)
      function passwordRegex(password) {
        const pattern = /^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$/;
        return pattern.test(password);
      }
      // validate password
      if(!this.staff.password){
        this.validationErrors.password = "*Please enter a password, 8 characters and 1 number";
        return;
      }
      if(!passwordRegex(this.staff.password)){
        this.validationErrors.password = "*Password must be 8 characters and a number";
        return;
      }
      // check that passwords match
      let confirmPassword = document.getElementById('staff_passwordC').value;
      if(confirmPassword !== this.staff.password){
        this.validationErrors.password = "*Passwords must match";
        return;
      }
      // POST request
      try {
        await axios.post('http://localhost:8080/api/gaaManagementSystem/add-staff', this.staff);
        // Reset form fields after successful submission
        this.staff = {
              staff_id: '',
              first_name: '',
              last_name: '',
              email: '',
              dob: '',
              contact_no: '',
              address1: '',
              address2: '',
              address3: '',
              role: '',
              password: ''
        }
        // resent confirm password field
        document.getElementById('staff_passwordC').value = '';

      } catch (error) {
        console.error('Error adding staff:', error);
      }
      // direct user to admin portal portal
      await router.push({path: '/admin-portal'})
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