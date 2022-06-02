<script src="./home-page.js"></script>
<style src="./home-page.css" scoped></style>

<template>
    <div id="home-page">
        <div id="home-main">
            <router-link :to="{ name: 'projects' }" class="routerLinks">View All Projects</router-link>
        </div>
    </div>
</template>
