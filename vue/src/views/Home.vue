<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <home-page></home-page>
  </div>
</template>

<script>
import HomePage from './../components/home-page/HomePage.vue'

export default {
  name: "home",
  components: {
    HomePage
  }
};
</script>
