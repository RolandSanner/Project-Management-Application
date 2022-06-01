<template>
  <div id="app">
    <NavigationBar class="nav"/>
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
  /* .nav {
    z-index: -1; 
    position: relative;
  } */
</style>
