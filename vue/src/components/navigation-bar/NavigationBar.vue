<script src="./navigation-bar.js"></script>
<style src="./navigation-bar.css" scoped></style>

<template>

    <div class="nav">

        <div class="logo">
          <router-link :to="{ name: 'home'}">
            <img src="./../../assests/logoBlue.png" alt="blue logo" height=55 width=auto>
          </router-link>
        </div>
        <div class="navLinks">
            <router-link :to="{ name: 'home' }" class="link">Home</router-link>
            <router-link :to="{name: 'AboutUs'}" class="link"> | About Us</router-link>
            <router-link :to="{ name: 'logout' }" v-if="$store.state.token != ''"
                            class="link" >&nbsp;|&nbsp;Logout</router-link>
        </div>
    </div>

</template>
