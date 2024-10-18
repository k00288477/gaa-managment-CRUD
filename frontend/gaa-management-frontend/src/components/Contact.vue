<script setup>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import {onMounted, ref} from "vue";
import axios from "axios";

const contacts = ref([])
// get about page info from backend
onMounted(()=> {
  try {
    axios.get('http://localhost:8080/api/member-portal/get-contact-list')
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
  <Header />
  <div class="d-flex flex-row container-fluid main-container">

    <div class="contact-container">
      <h2>Contact Us</h2>

      <p>We welcome your inquiries, feedback, and suggestions.
        Our team is here to assist you with any questions you may have about our products,
        services, or website.</p>
      <p>Feel free to reach out to us via the contact information
        provided below. Whether you're a potential customer, partner, or simply want to connect,
        we value your communication and look forward to hearing from you.</p>
    </div>

    <div class="contact-list">
      <h2>Contact List</h2>

        <ul style="list-style-type: none;" v-for="contact in contacts">
          <li style="display: none">{{ contact.id }}</li>
          <li>Name: {{ contact.name }}</li>
          <li>Number: 0{{ contact.contact_number }}</li>
          <li>Email: {{ contact.email }}</li>
        </ul>

      </div>

    </div>


  <Footer />
</template>

<script>


</script>

<style scoped>
.contact-container {
  color: #ebeff1;
  width: 100%;
  margin: auto;
  margin-bottom: 2em;
  padding-right: 1em;
}
.main-container {
  flex-direction: row!important;
  color: #ebeff1;
  margin-bottom: 3em;
  margin-top: 3em;
  width: 80%;
}
.contact-list {
  border-left: 2px solid #004411;
  width: 100%;
  padding-left: 1em;
}
.contact-list ul {
  border-bottom: 1px solid #ebeff1;
  padding-bottom: 1em;
}
hr {
  height: 4px;
  background-color: #7EC19D;
}

</style>