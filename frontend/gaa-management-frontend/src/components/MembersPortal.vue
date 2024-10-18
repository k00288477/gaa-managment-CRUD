<script setup>
import AllEvents from "@/components/member-components/AllEvents.vue";
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import LogOut from "@/components/LogOut.vue";
import MemberSignUp from "@/components/member-components/MemberSignUp.vue";
import MemberAccount from "@/components/member-components/MemberAccount.vue";

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
              <li class="nav-item">
                <router-link to="/" class="nav-link">Home</router-link>
              </li>
              <li class="nav-item">
                <a class="nav-link sidebar-item" href="#" id="account-link" @click="showDashboardContent('account-dashboard')">My Account</a>
              </li>
              <li class="nav-item">
                <a class="nav-link sidebar-item" href="#" id="events-link" @click="showDashboardContent('events-dashboard')">Events</a>
              </li>
              <li class="nav-item">
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

          <div id="account-dashboard" class="dashboardContent"><MemberAccount /></div>
          <div id="events-dashboard" class="dashboardContent"><AllEvents /></div>
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

.nav-item a {
  color: #ebeff1;
}
.nav-item {
  margin-top: 0.5em;
  margin-bottom: 0.5em;
  border-radius: 2em;
}
.nav-item:hover {
  background-color: #7EC19D;
}
.nav {
  padding-bottom: 30em;
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
  .nav {
    padding-bottom: 1em;
  }

  .dashboardContent {
    overflow-x: scroll;
  }

}


</style>


