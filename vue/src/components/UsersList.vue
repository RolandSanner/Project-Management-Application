<template>
  <div class="user-list">
      <div v-for="user in users" v-bind:key="user.id" class="user">
          {{user.username}}
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

</style>