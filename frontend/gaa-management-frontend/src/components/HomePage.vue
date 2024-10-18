<script setup>
import Header from "@/components/Header.vue";
</script>

<template>
<Header />

  <main>
    <div class="hero-img">
      <img src="/imgs/hero-img.png">
      <div class="hero-text">
        <h1>BallyBrown GAA</h1>
        <h2>est. 1890</h2>
        <button class="btn btn-primary"><router-link to="/all-events-home" class="router-link">View All Events</router-link></button>
      </div>
    </div>

    <div class="content">
    <div class="container-sm">
      <h2>Join to get news of new events</h2>
      <button class="btn btn-primary"><router-link to="/member-signup" class="router-link">Member Sign-up</router-link></button>
    </div>
    <div class="container-sm">
      <h2>Apply to become a player</h2>
      <button class="btn btn-primary"><router-link to="/player-signup" class="router-link">Player Registration</router-link></button>
    </div>
    </div>

  </main>



  <router-view></router-view>
</template>

<style scoped>


  main {
    background-color: #1a1a1a;
    color: #ebeff1;
    padding-bottom: 2em;
    height: 100%
  }
  main img {
    min-width: 100%;
    min-height: 100%;
    border-bottom: 3px solid #004411;
  }
  .hero-text {
    position: absolute;
    top: 35%;
    left: 15%;
    transform: translate(-50%, -50%);
  }
  .router-link {
    color: #ebeff1;
    text-decoration: none;
  }
  .content {
    display: flex;
    flex-direction: row;
    margin: 3em;
  }
  .container-sm {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    width: 18em;
    text-align: center;
    background-color: #303030;
    padding: 3em;
  }
  .container-sm h2 {
    font-size: 1em;
  }
  .container-sm .btn {
    font-size: 1em;
    margin: 1em;
  }
  .btn {
    background-color: #172161;
    border: 0;
  }
  .btn:hover {
    opacity: 75%;
  }

  @media screen and (max-width: 770px){
    main {
      background-color: #1a1a1a;
      color: #ebeff1;
      padding-bottom: 2em;
      height: 100%
    }
    main img {
      width: 50%;
      height: 100%;
      border-bottom: 3px solid #004411;
    }
    .hero-text {
      position: absolute;
      top: 22%;
      left: 20%;
      transform: translate(-50%, -50%);
    }
    .hero-text h1 {
      font-size: 1.5em;
    }
    .hero-text h2 {
      font-size: 1em;
    }
    .content {
      flex-direction: column;
    }
    .container-sm {
      margin-bottom: 1em;
    }

  }

</style>

<script>
import { RouterLink } from "vue-router";


export default {
  components: {
    RouterLink
  }

};


</script>