<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }" class="link">Home</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" class="link" &nbsp;|&nbsp;>Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style scoped>

  #nav {
    background-color: #3c99dc;
    padding: 5px;
  }

  .link {
    text-decoration: none;
    color: black;
    background-color: #3c99dc;
    font-size: 1.4rem;
    padding: 5px;
    transition: .2s;
  }
  
  .link:hover {
    transform: scale(1.5);
}

  .link:active {
    color: white;
  }

</style>
