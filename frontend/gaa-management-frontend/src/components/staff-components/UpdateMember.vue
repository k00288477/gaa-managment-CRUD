<script setup>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import {onMounted, ref} from "vue";
import {useRoute} from "vue-router";
import axios from "axios";
import router from "@/router.js";

// get member by id
const member = ref({});
const validationErrors = ref({});
const id = useRoute().params.id;
onMounted(() => {
  // find the staff member
  axios.get(`http://localhost:8080/api/gaaManagementSystem/find-member/${id}`)
      .then(response => {
        member.value = response.data;
      })
      .catch(error => {
        console.error("Error loading data: ", error);
      });

  return {
    member: member.value,
    validationErrors: validationErrors.value
  }
});

async function submitForm() {
  // validate fields
  validationErrors.value = {};

// First name field filled
  if (!member.value.first_name) {
    validationErrors.value.first_name = "*First name is required";
    return;
  }

// Last name filled
  if (!member.value.last_name) {
    validationErrors.value.last_name = "*Last name is required";
    return;
  }

// Email Regular expression
  function emailRegex(email) {
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailPattern.test(email);
  }

// Email filled & validate with regex
  if (!member.value.email || !emailRegex(member.value.email)) {
    validationErrors.value.email = "*An email is required: example@example.com";
    return;
  }

// DOB filled
  if (!member.value.dob) {
    validationErrors.value.dob = "*Date of Birth is required";
    return;
  }

// Irish phone number regular expression
  function contactNumberRegex(contact_no) {
    const numberPattern = /^08\d{8}$/;
    return numberPattern.test(contact_no);
  }

// Contact number filled and regular expression
  if (!member.value.contact_no || !contactNumberRegex(member.value.contact_no)) {
    validationErrors.value.contact_no = "*You must enter an Irish phone number: 0871234567";
    return;
  }

// Address fields filled
  if (!member.value.address1 || !member.value.address2 || !member.value.address3) {
    validationErrors.value.address = "*All address fields must be filled";
    return;
  }

// Membership type selected
  if (!member.value.membership_type) {
    validationErrors.value.membership_type = "*Please select a membership type, select FREE if unsure, this can be changed later";
    return;
  }
  function passwordRegex(password) {
    const pattern = /^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$/;
    return pattern.test(password);
  }

  // validate password
  if (!member.value.password) {
    validationErrors.value.password = "*Please enter a password, 8 characters and 1 number";
    return;
  }
  if (!passwordRegex(member.value.password)) {
    validationErrors.value.password = "*Password must be 8 characters and a number";
    return;
  }
  // check that passwords match
  let confirmPassword = document.getElementById('member_passwordC').value;
  if(confirmPassword === ''){
    validationErrors.value.password = "*Please confirm your password";
    return;
  }
  if (confirmPassword !== member.value.password) {
    validationErrors.value.password = "*Passwords must match";
    return;
  }
  // PUT request
  try {
    await axios.put(`http://localhost:8080/api/gaaManagementSystem/update-member/${id}`, member.value);
    // reset fields
    member.value = {
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
    };
    document.getElementById('member_passwordC').value = '';
  } catch (error) {
    console.log("Error updating member: ", error);
  }
  // direct user to admin portal portal
  await router.push({path: '/admin-portal'})
}



</script>

<template>
  <Header />

  <h2>Update Member Details</h2>

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
      <span v-if="validationErrors.password" class="text-danger" style="text-align: center; display: block ruby">{{ validationErrors.password }}</span>
      <input type="password" id="member_password" class="form-control" v-model="member.password">
    </div>
    <div class="mb-3">
      <label for="member_passwordC" class="form-label">Confirm Password: </label>
      <input type="password" id="member_passwordC" class="form-control">
    </div>


    <div class="container-sm d-flex justify-content-center align-items-center">
      <button type="submit" class="btn btn-primary">Save Details</button>
      <button type="reset" class="btn btn-outline-light">Reset</button>
    </div>

  </form>
  <Footer />
</template>


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