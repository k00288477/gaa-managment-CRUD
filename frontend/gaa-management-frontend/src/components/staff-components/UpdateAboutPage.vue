<script setup>
import axios from 'axios';
import {onMounted, ref} from "vue";
import {useRoute} from "vue-router";
import router from "@/router.js";
//
const about = ref({});
const validationErrors = ref({});


onMounted(() => {
  const id = useRoute().params.id;
  console.log(id)
  // find the about page
  axios.get(`http://localhost:8080/api/gaaManagementSystem/get-about-page`)
      .then(response => {
        about.value = response.data;
      })
      .catch(error => {
        console.error("Error loading data: ", error);
      });

  return {
    about: about.value,
    validationErrors: validationErrors.value
  }
});


// PUT request to save user details
async function submitForm() {
  // validation logic
  // clear previous errors
  this.validationErrors = {};

  if (!this.about.heading) {
    this.validationErrors.heading = "*A heading is required";
    return;
  }
  if (!this.about.paragraph1) {
    this.validationErrors.p1 = "*Please fill out a first paragraph";
    return;
  }
  if (!this.about.paragraph2) {
    this.validationErrors.p2 = "*Please fill out a second paragraph";
    return;
  }

  // PUT request to update
  try {
    console.log("put method reached")
    await axios.put(`http://localhost:8080/api/gaaManagementSystem/update-about-page/1`, this.about);
    // direct user to the about page
    await router.push({path: '/about'})
  } catch (error) {
    console.error('Error adding info:', error);
  }

}

</script>

<template>
  <h2>Update About Page</h2>

  <form @submit.prevent="submitForm()">

    <div class="mb-3" style="display: none" id="update-staff-component">
      <input type="text" v-model="about.id">
    </div>
    <div class="mb-3">
      <label for="heading" class="form-label">Heading: </label>
      <span v-if="validationErrors.heading" class="text-danger">{{ validationErrors.heading }}</span>
      <input type="text" id="heading" class="form-control" v-model="about.heading">
    </div>
    <div class="mb3 form-floating">
      <span v-if="validationErrors.p1" class="text-danger">{{ validationErrors.p1 }}</span>
      <textarea id="p1" class="form-control" v-model="about.paragraph1" style="min-height: 100px"></textarea>
      <label for="p1" class="form-label">First Paragraph: </label>
    </div>
    <div class="mb-3 form-floating" style="margin-top: 1em">
      <span v-if="validationErrors.p2" class="text-danger">{{ validationErrors.p2 }}</span>
      <textarea id="p2" class="form-control" v-model="about.paragraph2" style="min-height: 100px"></textarea>
      <label for="p2" class="form-label">Second Paragraph: </label>
    </div>

    <div class="container-sm d-flex justify-content-center align-items-center">
      <button type="submit" class="btn btn-primary">Save & View Page</button>
      <button type="reset" class="btn btn-outline-light">Clear All</button>
    </div>

  </form>
</template>

<style scoped>
label {
  color: white;
}

h2 {
  color: #ebeff1;
  text-align: center;
}

form {
  width: 80%;
  margin: auto auto 3em;
}

hr {
  height: 4px;
  background-color: #7EC19D;
}

label, .btn-primary {
  margin-right: 1em;
}

</style>