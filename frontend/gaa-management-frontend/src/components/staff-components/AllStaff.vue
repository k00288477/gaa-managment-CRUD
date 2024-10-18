

<template>
  <div>
    <div class="container-fluid">
      <div class="row justify-content-center">
        <div class="col">
          <h2 class="text-center">All Staff</h2>
        </div>
        <div class="col-auto">
          <button type="button" class="btn btn-primary">
            <router-link to="/add-staff" style="color: #ebeff1; text-decoration: none">Add Staff</router-link>
          </button>
        </div>
      </div>
    </div>


    <table class="table table-hover">
      <thead>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email Address</th>
        <th>Address</th>
        <th>Contact Number</th>
        <th>Role</th>
        <th>Action</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="staff in staff" :key="staff.staff_id">
        <td>{{ staff.first_name }}</td>
        <td>{{ staff.last_name }}</td>
        <td>{{ staff.email }}</td>
        <td>{{ staff.address1 + ", " + staff.address2 + ", " + staff.address3}}</td>
        <td>0{{ staff.contact_no }}</td>
        <td>{{ staff.role }}</td>
        <td>
          <div class="d-flex justify-content-center align-content-center">
            <button type="button" class="btn btn-warning" style="margin-right: 0.5em"><router-link :to="{path: '/update-staff/' + staff.staff_id}" class="link">Edit</router-link></button>
            <button type="button" class="btn btn-danger" @click="deleteStaff(staff.staff_id)">Delete</button>
          </div>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>
<style scoped>
.btn-primary {
  float: right;
  background-color: #172161;
  border: 0;
}
.btn-primary:hover {
  opacity: 75%;
}
.link {
  text-decoration: none;
  color: #1a1a1a;
}

</style>
<script>

import {ref, onMounted} from "vue";
import axios from 'axios';
import router from "@/router.js";

async function deleteStaff(staff_id) {
  try {
    const response = await axios.delete(`http://localhost:8080/api/gaaManagementSystem/delete-staff/${staff_id}`);

    if (response.status === 200) {
      console.log("Staff member deleted successfully");
    } else {
      console.log("Failed to delete staff member");
    }
  } catch (error) {
    console.error("Error deleting staff member:", error);

  }

  await router.push({path: '/admin-portal'})
}

export default {

  setup() {
    const staff = ref([]);

    onMounted(()=> {
      axios.get('http://localhost:8080/api/gaaManagementSystem/staff-list')
          .then(response => {
            staff.value = response.data;
          })
          .catch(error => {
            console.error("Error loading data: ", error);
          })

    });
    return { staff, deleteStaff };
  },
  deleteStaff() {}
}


</script>
