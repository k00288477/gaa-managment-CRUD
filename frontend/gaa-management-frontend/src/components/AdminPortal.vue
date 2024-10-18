<script setup>

import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import LogOut from "@/components/LogOut.vue";
import AllMembers from "@/components/staff-components/AllMembers.vue";
import AllTeams from "@/components/staff-components/AllTeams.vue";
import AllPlayers from "@/components/staff-components/AllPlayers.vue";
import AllStaff from "@/components/staff-components/AllStaff.vue";
import AllEventsStaff from "@/components/staff-components/AllEventsStaff.vue";
import StaffAccount from "@/components/staff-components/StaffAccount.vue";
import UpdateAboutPage from "@/components/staff-components/UpdateAboutPage.vue";
import ContactList from "@/components/staff-components/ContactList.vue";

</script>
<template>
  <Header/>
  <!--  side bar for navigation-->
  <div class="dashboard">

    <div class="container-fluid">
      <div class="row">
        <!-- Sidebar -->
        <nav class="col-md-3 col-lg-2 d-md-block sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item1">
                <router-link to="/" class="nav-link">Home</router-link>
              </li>
              <li class="nav-item1">
                <a class="nav-link sidebar-item" href="#" id="account-link" @click="showDashboardContent('account-dashboard')">My Account</a>
              </li>
              <li class="nav-item1">
                <a class="nav-link sidebar-item" href="#" id="members-link" @click="showDashboardContent('members-dashboard')">Club Members</a>
              </li>
              <li class="nav-item1">
                <a class="nav-link sidebar-item" href="#" id="teams-link" @click="showDashboardContent('teams-dashboard')">Club Teams</a>
              </li>
              <li class="nav-item1">
                <a class="nav-link sidebar-item" href="#" id="players-link" @click="showDashboardContent('players-dashboard')">Players</a>
              </li>
              <li class="nav-item1">
                <a class="nav-link sidebar-item" href="#" id="staff-link" @click="showDashboardContent('staff-dashboard')">Club Staff</a>
              </li>

              <li class="nav-item1">
                <a class="nav-link sidebar-item" href="#" id="events-link" @click="showDashboardContent('eventsStaff-dashboard')">Events</a>
              </li>

              <li class="nav-item1">
                <a class="nav-link sidebar-item" href="#" id="about-page-link" @click="showDashboardContent('about-page-dashboard')">About Page</a>
              </li>

              <li class="nav-item1">
                <a class="nav-link sidebar-item" href="#" id="contact-list-link" @click="showDashboardContent('contact-list-dashboard')">Contact List</a>
              </li>

              <li class="nav-item1">
                <a class="nav-link sidebar-item" href="#" id="logout-link" @click="showDashboardContent('logout-dashboard')">Log Out</a>
              </li>
            </ul>
          </div>
        </nav>

        <!-- Page Content -->
        <div role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 dash-content">
          <!-- Your content goes here -->
          <div id="main">
            <h1>Welcome to The Members dashboard</h1>
            <p>From here you can View your account</p>
            <p>View all events and matches</p>
            <p>View Match Details</p>
          </div>

          <div id="account-dashboard" class="dashboardContent"><StaffAccount /></div>
          <div id="members-dashboard" class="dashboardContent"><AllMembers /></div>
          <div id="teams-dashboard" class="dashboardContent"><AllTeams /></div>
          <div id="players-dashboard" class="dashboardContent"><AllPlayers /></div>
          <div id="staff-dashboard" class="dashboardContent"><AllStaff /></div>
          <div id="eventsStaff-dashboard" class="dashboardContent"><AllEventsStaff /></div>
          <div id="about-page-dashboard" class="dashboardContent"><UpdateAboutPage /></div>
          <div id="contact-list-dashboard" class="dashboardContent"><ContactList /></div>
          <div id="logout-dashboard" class="dashboardContent"><LogOut /></div>
        </div>


      </div>
    </div>



  </div>
  <Footer />

</template>


<script>
import {dashboardManager} from "@/assets/script/dashboardManager.js";

export default {
  methods: {
    // Method to show the account dashboard content
    showDashboardContent(id){
      dashboardManager.showDashboardContent(id);
    }
  }
};
</script>

<style scoped>


.sidebar {
  background-color: #226642;
}

.nav-item1 a {
  color: #ebeff1;
}
.nav-item1 {
  margin-top: 0.5em;
  margin-bottom: 0.5em;
  border-radius: 2em;
}
.nav-item1:hover {
  background-color: #7EC19D;
}
.nav {
  padding-bottom: 20em;
}
.dash-content {
  text-align: center;
  padding-top: 1em;
  color: #ebeff1;
  background-color: #1a1a1a;
}
.dashboardContent {
  display: none;
}

@media screen and (max-width: 770px){
  .dashboardContent {
    overflow-x: scroll;
  }

  .nav {
    padding-bottom: 1em;
  }
}
</style>


