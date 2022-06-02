<script src="./home-page.js"></script>
<style src="./home-page.css" scoped></style>

<template>
    <div id="home-page">
        <div id="home-main">
            <router-link :to="{ name: 'allProjects' }" class="routerLinks">View All Projects</router-link>
            <router-link :to="{ name: 'newproject' }" class="routerLinks">Add New Project</router-link>
            <router-link :to="{ name: 'userlist' }" class="routerLinks">View Users</router-link>
        </div>
    </div>
</template>
