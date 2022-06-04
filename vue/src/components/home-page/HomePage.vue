<script src="./home-page.js"></script>
<style src="./home-page.css"></style>

<template>
    <div id="home-page">
        <div>
        <div class="header">
           <h1 v-if="$store.state.token == ''">Must Be Logged In To View Page</h1>   
        </div>
        <div class="headerRoute">
           <router-link v-if="$store.state.token == ''" :to="{ name: 'login' }" class="routerLinks login">Log In</router-link>
        </div>
        </div>

        <div id="home-main" v-if="$store.state.token != ''">
            <router-link :to="{ name: 'allProjects' }" class="routerLinks">View All Projects</router-link>
            <router-link :to="{ name: 'newproject' }" class="routerLinks">Add New Project</router-link>
            <router-link :to="{ name: 'allContacts' }" class="routerLinks">View All Contacts</router-link>
            <router-link :to="{ name: 'newcontact' }" class="routerLinks">Add Contact</router-link>
            <router-link :to="{ name: 'userlist' }" class="routerLinks">View All Users</router-link>
            <router-link :to="{ name: 'group-list' }" class="routerLinks">View All Project Groups</router-link>
        </div>

    </div>
</template>