<template>
  <div id="app">
    <div class="nav">
      <NavigationBar class="nav"/>
    </div>
      <router-view />
  </div>
</template>

<script>
  import NavigationBar from "./components/navigation-bar/NavigationBar.vue"

  export default {
    components: {
      NavigationBar
    }
  }
</script>

<style>
  .nav {
    z-index: 1; 
    position: relative;
  }
</style>
