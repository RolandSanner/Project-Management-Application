<template>
  <div class="user-list">
      <div v-for="user in users" v-bind:key="user.id" class="user">
          <router-link v-bind:to="{name:'userinfo',params:{id: user.id}}">
          {{user.username}}
          </router-link>
      </div>
  </div>
</template>

<script>
import UserService from '../services/UsersService'
export default {
name: 'user-list',
data(){
    return{
        users:[]
    }
    },
created(){
    UserService.getUsers().then(response=>{
        this.users=response.data;
    })
}
}
</script>

<style>
.user{
    margin-left: 50px;
    margin-bottom: 10px;
    font-size: 24=px;
    border-bottom: 1px solid #f2f2f2;
    padding: 10px 20px;
}
</style>