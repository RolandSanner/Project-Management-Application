<template>
  <div class='userList'>
      <h1>List of Users</h1>
    <users-list/>
  </div>
</template>

<script>
import UsersList from '../components/UsersList.vue';
export default {
name: 'ListOfUsers',
components:{
    UsersList
}
}
</script>

<style>
h1 {
  margin: 50px;
  text-decoration: underline;
}
</style>