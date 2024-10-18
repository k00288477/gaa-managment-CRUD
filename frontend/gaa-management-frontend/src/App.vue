<script setup>
import { RouterLink } from "vue-router";

</script>

<template>
<div id="app">
<router-link to="/"></router-link>


  <router-view></router-view>
</div>
</template>

<style scoped>
  #app {
    background-color: #1a1a1a;
  }


</style>
