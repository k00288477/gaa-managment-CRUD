<script setup>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

</script>
<template>
  <Header />

    <h2>Create Account</h2>

    <form @submit.prevent="submitForm">

        <div class="mb-3" style="display: none">
          <input type="text" v-model="member.member_id">
        </div>
        <div class="mb-3">
          <label for="member_fname" class="form-label">First Name: </label>
          <span v-if="validationErrors.first_name" class="text-danger">{{ validationErrors.first_name }}</span>
          <input type="text" id="member_fname" class="form-control" v-model="member.first_name">
        </div>
        <div class="mb-3">
          <label for="member_lname" class="form-label">Last Name: </label>
          <span v-if="validationErrors.last_name" class="text-danger">{{ validationErrors.last_name }}</span>
          <input type="text" id="member_lname" class="form-control" v-model="member.last_name">
        </div>
        <div class="mb-3">
          <label for="member_email" class="form-label">Email: </label>
          <span v-if="validationErrors.email" class="text-danger">{{ validationErrors.email }}</span>
          <input type="text" id="member_email" class="form-control" v-model="member.email">
        </div>
        <div class="mb-3">
          <label for="member_dob" class="form-label">Date of Birth: </label>
          <span v-if="validationErrors.dob" class="text-danger">{{ validationErrors.dob }}</span>
          <input type="date" id="member_dob" class="form-control" v-model="member.dob">
        </div>
        <div class="mb-3">
          <label for="member_contact" class="form-label">Contact Number: </label>
          <span v-if="validationErrors.contact_no" class="text-danger">{{ validationErrors.contact_no }}</span>
          <input type="tel" id="member_contact" class="form-control" v-model="member.contact_no">
        </div>
      <hr>
      <span v-if="validationErrors.address" class="text-danger" style="text-align: center">{{ validationErrors.address }}</span>
        <div class="mb-3">
          <label for="member_add1" class="form-label">House Number: </label>
          <input type="text" id="member_add1" class="form-control" v-model="member.address1">
        </div>
      <div class="mb-3">
        <label for="member_add2" class="form-label">Street: </label>
        <input type="text" id="member_add2" class="form-control" v-model="member.address2">
      </div><div class="mb-3">
      <label for="member_add3" class="form-label">City: </label>
      <input type="text" id="member_add3" class="form-control" v-model="member.address3">
    </div>
      <!-- Select dropdown for membership type -->
      <div class="mb-3">
        <label for="membershipType" class="form-label">Membership Type:</label>
        <span v-if="validationErrors.membership_type" class="text-danger" style="text-align: center; display: block ruby">{{ validationErrors.membership_type }}</span>
        <select id="membershipType" class="form-control" v-model="member.membership_type">
          <option>FREE</option>
          <option>STANDARD</option>
          <option>LIFETIME</option>
        </select>
      </div>

      <hr>

      <div class="mb-3">
        <label for="member_password" class="form-label">Password: </label>
        <input type="password" id="member_password" class="form-control" v-model="member.password">
      </div>
      <div class="mb-3">
        <label for="member_passwordC" class="form-label">Confirm Password: </label>
        <input type="password" id="member_passwordC" class="form-control">
      </div>

      <div class="container-sm d-flex justify-content-center align-items-center">
        <button type="submit" class="btn btn-primary">Sign Up</button>
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
      member: {
        member_id: '',
        first_name: '',
        last_name: '',
        email: '',
        dob: '',
        contact_no: '',
        address1: '',
        address2: '',
        address3: '',
        club: '',
        membership_type: '',
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
      if(!this.member.first_name){
        this.validationErrors.first_name = "*First name is required";
        return;
      }
      // last name filled
      if(!this.member.last_name){
        this.validationErrors.last_name = "*Last name is required";
        return;
      }
      // email Regular expression
      function emailRegex(email) {
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailPattern.test(email);
      }
      // email filled & validate with regex
      if(!this.member.email || !emailRegex(this.member.email)){
        this.validationErrors.email = "*An email is required: example@example.com";
        return;
      }
      // dob filled
      if(!this.member.dob){
        this.validationErrors.dob = "*Date of Birth is required";
        return;
      }
      // irish phone number regular expression
      function contactNumberRegex(contact_no) {
        const numberPattern = /^08\d{8}$/;
        return numberPattern.test(contact_no);
      }
      // contact number filled and regular expression
      if(!this.member.contact_no || !contactNumberRegex(this.member.contact_no)){
        this.validationErrors.contact_no = "*You must enter and Irish phone number: 0871234567";
        return;
      }
      // address fields filled
      if(!this.member.address1 || !this.member.address2 || !this.member.address3){
        this.validationErrors.address = "*All address fields must be filled";
        return;
      }
      // membership type selected
      if(!this.member.membership_type){
        this.validationErrors.membership_type = "*Please select a membership type, select FREE if unsure, this can be changed later";
        return;
      }
      function passwordRegex(password) {
        const pattern = /^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$/;
        return pattern.test(password);
      }
      // validate password
      if (!this.member.password) {
        this.validationErrors.password = "*Please enter a password, 8 characters and 1 number";
        return;
      }
      if (!passwordRegex(this.member.password)) {
        this.validationErrors.password = "*Password must be 8 characters and a number";
        return;
      }
      // check that passwords match
      let confirmPassword = document.getElementById('member_passwordC').value;
      if(confirmPassword === ''){
        this.validationErrors.password = "*Please confirm your password";
        return;
      }
      if (confirmPassword !== this.member.password) {
        this.validationErrors.password = "*Passwords must match";
        return;
      }
      // POST request
      try {
        await axios.post('http://localhost:8080/api/member-portal/member-create-account', this.member);
        // Reset form fields after successful submission
        this.member = {
          first_name: '',
          last_name: '',
          email: '',
          dob: '',
          contact_no: '',
          address1: '',
          address2: '',
          address3: '',
          club: '',
          membership_type: '',
          password: ''
        }
        document.getElementById('member_passwordC').value = '';
      } catch (error) {
        console.error('Error adding member:', error);
      }
      // direct user to members portal
      await router.push({path: '/members-portal'})
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