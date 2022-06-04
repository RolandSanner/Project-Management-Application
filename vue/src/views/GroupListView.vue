<template>
<div>
  <h1>Project Groups</h1>
<group-list-component/>
</div>
</template>

<script>
import GroupListComponent from '../components/GroupListComponent.vue';
export default {
name: 'GroupListView',
components:{
    GroupListComponent
}
}
</script>

<style>

</style>