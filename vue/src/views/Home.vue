<template>
  <div class="home">
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

<style scoped>
  h1 {
    text-decoration: none;
    display: flex;
    justify-content: center;
    color: #073763;
  }

  p {
    display: flex;
    justify-content: center;
  }
</style>