<template>
<div>
    <h1>User Info</h1>
<user-info v-bind:user-id="$route.params.id"/>
</div>
  
</template>

<script>
import UserInfo from '../components/UserInfo.vue';
export default {
name:'UserInfoView',
components:{
    UserInfo
}
}
</script>

<style>

</style>