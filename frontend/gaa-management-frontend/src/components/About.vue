<script setup>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import {onMounted, ref} from "vue";
import axios from "axios";

const about = ref({})
// get about page info from backend
onMounted(()=> {
  try {
    axios.get('http://localhost:8080/api/member-portal/get-about-page')
        .then(
            response => {
              about.value = response.data;

              const myCarouselElement = document.querySelector('#myCarousel')

              const carousel = new bootstrap.Carousel(myCarouselElement, {
                interval: 2000,
                touch: false
              })
            }
        )
  } catch (Error) {
    console.log("Error getting about page", Error);
  }
});


</script>

<template>
  <Header />
<div class="d-flex align-content-center flex-wrap container-fluid flex-column main-container">

  <div class="about-container">

    <h1>About Us</h1>
    <span style="display: none">{{ about.id }}</span>

    <h2>{{ about.heading }}</h2>

    <p>{{ about.paragraph1 }}</p>

    <p>{{ about.paragraph2 }}</p>
  </div>

  <div class="gallery">
    <hr>
    <div id="carouselExampleDark" class="carousel carousel-dark slide">
      <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active" data-bs-interval="10000">
          <img src="/imgs/carousel1.jpg" class="d-block w-100" alt="test">
          <div class="carousel-caption d-none d-md-block">
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="2000">
          <img src="/imgs/carousel2.jpg" class="d-block w-100" alt="test">
          <div class="carousel-caption d-none d-md-block">
          </div>
        </div>
        <div class="carousel-item">
          <img src="/imgs/carousel3.jpg" class="d-block w-100" alt="test">
          <div class="carousel-caption d-none d-md-block">
          </div>
        </div>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </div>
</div>

  <Footer />
</template>

<script>


</script>

<style scoped>
.about-container {
  color: #ebeff1;
  width: 80%;
  margin: auto;
  margin-bottom: 2em;
}
.main-container {
  color: #ebeff1;
  margin-bottom: 3em;
  margin-top: 3em;
  width: 80%;
}
.gallery {
 width: 100%;
}
hr {
  height: 4px;
  background-color: #7EC19D;
}

</style>