<script setup>

import { ref } from 'vue';

function toggleMenu() {
 let navItems = document.querySelectorAll(".nav-item")

  navItems.forEach(item => {
    if (item.style.display === 'none' || item.style.display === '') {
      item.style.display = 'block';
    } else {
      item.style.display = 'none';
    }
  });
}
</script>

<template>
  <header>
    <!--    logo & nav bar-->
    <div class="container-fluid">
      <img src="/imgs/ballybrown-gaa-club.webp" alt="logo">
      <h1>BallyBrown GAA Club</h1>
    </div>
    <nav class="navbar justify-content-end" >
      <!--      home, about, contact, admin portal-->
      <div class="menu-icon" id="menu-icon" @click="toggleMenu()"><span class="navbar-toggler-icon icon" style="background-color: #ebeff1; border-radius: 0.1em; padding: 0.5em;"></span></div>
      <div class="nav-item"><router-link to="/" class="nav-link">Home</router-link></div>
      <div class="nav-item"><router-link to="/about" class="nav-link">About</router-link></div>
      <div class="nav-item"><router-link to="/staff-login" class="nav-link">AdminPortal</router-link></div>
      <div class="nav-item"><router-link to="/members-portal" class="nav-link">Members Portal</router-link></div>
      <div class="nav-item"><router-link to="/contact" class="nav-link">Contact</router-link></div>

    </nav>
  </header>
</template>

<style scoped>
header {
  display: grid;
  grid-template-columns: 50% 50%;
  border-bottom: 3px solid #004411;
  height: 6em;
}
header img {
  max-height: 100%;
}
header h1 {
  font-size: 1.25em;
}
.container-fluid {
  display: flex;
  flex-direction: row;
  align-items: center;
  height: 6em;
}
.container-fluid h1 {
  color: #ebeff1;
}
.nav-link {
  color: #ebeff1;
  font-size: 1em;
}
.nav-link:hover {
  color: #7EC19D;
  text-decoration: underline;
}
.nav-item {
  margin-right: 2em;
}
.menu-icon {
  display:none;
}

@media screen and (max-width: 770px){
.nav-item {
  z-index: 9999;
  display: none;
  width: 100%;
  top: 100%;
  left: 50%;
  transform: translate(50%, 155%);
  background-color: #004411;
  padding: 1em;
}
.menu-icon {
  display: block;
  margin-right: 2em;
  color: #ebeff1;
  z-index: 10000;
  position: absolute;
  top: 2em;
  right:1em;
}
.menu-icon:hover {
  cursor: pointer;
}
.icon {
  color: #ebeff1!important;
}

}
</style>