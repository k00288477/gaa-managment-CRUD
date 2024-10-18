

<template>
  <div>
    <h2>Members List</h2>
    <table class="table table-hover">
      <thead>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email Address</th>
        <th>Address</th>
        <th>Contact Number</th>
        <th>Membership Type</th>
        <th>Action</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="member in members" :key="member.member_id">
        <td>{{ member.first_name }}</td>
        <td>{{ member.last_name }}</td>
        <td>{{ member.email }}</td>
        <td>{{ member.address1 + ", " + member.address2 + ", " + member.address3}}</td>
        <td>0{{ member.contact_no }}</td>
        <td>{{ member.membership_type }}</td>
        <td>
          <div class="d-flex justify-content-center align-content-center">
            <button type="button" class="btn btn-warning" style="margin-right: 0.5em"><router-link :to="{path: '/update-member/' + member.member_id}" class="link">Edit</router-link></button>
            <button type="button" class="btn btn-danger" @click="deleteMember(member.member_id)">Delete</button>
          </div>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>
.link {
  text-decoration: none;
  color: #1a1a1a;
}
</style>

<script>
import {ref, onMounted} from "vue";
import axios from 'axios';
import router from "@/router.js";

async function deleteMember(member_id) {
  try {
    const response = await axios.delete(`http://localhost:8080/api/gaaManagementSystem/delete-member/${member_id}`);

    if (response.status === 200) {
      console.log("Member deleted successfully");
    } else {
      console.log("Failed to delete member");
    }
  } catch (error) {
    console.error("Error deleting member:", error);
  }

  window.location.reload();
}

export default {
  setup() {
    const members = ref([]);

    onMounted(()=> {
      axios.get('http://localhost:8080/api/gaaManagementSystem/member-list')
          .then(response => {
            members.value = response.data;
          })
          .catch(error => {
            console.error("Error loading data: ", error);
          })

    });
    return { members, deleteMember };
  }

}
</script>
