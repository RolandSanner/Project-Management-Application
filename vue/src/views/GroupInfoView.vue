<template>
  <div>
      <h1>Group Info</h1>
      <group-info-component v-bind:group-id="$route.params.id"/>
  </div>
</template>

<script>
import GroupInfoComponent from '../components/GroupInfoComponent.vue'
export default {
name:'GroupInfoView',
components:{
    GroupInfoComponent
}
}
</script>

<style>

</style>