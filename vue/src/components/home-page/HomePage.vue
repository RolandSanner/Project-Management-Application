<script src="./home-page.js"></script>
<style src="./home-page.css"></style>

<template>
    <div id="home-page">
        <div class="header">
           <h1 v-if="$store.state.token == ''">Must Be Logged In To View Page</h1>   
           <router-link v-if="$store.state.token == ''" :to="{ name: 'login' }" class="routerLinks login">Log In</router-link>
        </div>

        <div id="home-main" v-if="$store.state.token != ''">
            <router-link :to="{ name: 'allprojects' }" class="routerLinks">View All Projects</router-link>
            <router-link :to="{ name: 'userlist' }" class="routerLinks">View All Users</router-link>
        </div>
    </div>
</template>