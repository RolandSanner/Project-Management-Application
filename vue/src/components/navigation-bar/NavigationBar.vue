<script src="./navigation-bar.js"></script>
<style src="./navigation-bar.css" scoped></style>

<template>

    <div class="nav">

        <div class="logo">
           <img src="./../../assests/logoBlue.png" alt="blue logo" height=55 width=auto>
        </div>
        <div class="navLinks">
            <router-link v-bind:to="{ name: 'home' }" class="link">Home</router-link>
            <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" 
                            class="link" >&nbsp;|&nbsp;Logout</router-link>
        </div>
    </div>

</template>
