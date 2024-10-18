
<template>
  <footer>
  <div class="footer f1">
<!--    logo-->
    <img src="/imgs/ballybrown-gaa-club.webp">
    <h3>Bally Brown GAA</h3>
  </div>
  <div class="footer f2">
    <ul>
      <li><a href="mailto:K00288477@student.tus.ie">Site Administrator</a></li>
      <li><a href="https://maps.app.goo.gl/sBMPpattyrFaKuaQA">Location</a></li>
      <li><router-link to="/contact">Contact Us</router-link></li>
    </ul>
  </div>
  <div class="footer f3">
    <ul>
      <li><a href="https://www.facebook.com/"><i class="fab fa-facebook"></i></a></li>
      <li><a href="https://www.instagram.com"><i class="fab fa-twitter"></i></a></li>
      <li><a href="https://www.twitter.com"><i class="fab fa-instagram"></i></a></li>
    </ul>
  </div>
  </footer>
</template>

<style scoped>
  footer {
    color: #ebeff1;
    display: flex;
    flex-direction: row;
    align-items: center;
    text-align: center;
    background-color: #1a1a1a;
    padding-left: 15em;
    padding-right: 15em;
    padding-top: 3em;
    padding-bottom: 3em;
    border-top: 3px solid #226642;
  }
  footer img {
    max-width: 25%;
  }
  .footer {
    display: flex;
    flex-direction: column;
    flex: 33.33%;
  }
  .f1, .f3 {
    flex-direction: row;
    align-items: center;
  }
  ul {
    list-style-type: none;
  }
  footer a {
    color: #ebeff1;
    text-decoration: none;
  }
  footer a:hover {
    text-decoration: underline;
  }
  .f3 li {
    display: inline-block;
    margin: 1em;
  }

  @media screen and (max-width: 770px){
    footer {
      flex-direction: column;
      padding: 1em;
    }

    .footer {
      flex-direction: row;
      justify-content: center;
      margin-bottom: 1em;
    }



  }
</style>
<script setup lang="ts">
</script>