<template>
  <div class='user-info'>
      <h2>Username: {{user.username}}</h2>
      <h2>UserID: {{user.id}}</h2>
  </div>
</template>

<script>
import UsersService from '../services/UsersService'
export default {
name:'user-details',
props:{
    'userId':Number
},
data(){
    return{
        user:{
            id:0,
            username:''
        },
    }
},
created(){
    UsersService.getUserById(this.$route.params.id).then(response=>{
        this.user.id=response.data.id;
    })
}
}
</script>

<style>
h2 {
    margin-left: 50px;
}
</style>