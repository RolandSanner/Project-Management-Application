<template>
  <div>
      <h2>Group Info</h2>
      <group-info-component v-bind:group-id="$route.params.id"/>
      <h2>Projects</h2>
      <group-projects v-bind:group-id="$route.params.id"/>
  </div>
</template>

<script>
import GroupInfoComponent from '../components/GroupInfoComponent.vue'
import GroupProjects from '../components/GroupProjects.vue'
export default {
name:'GroupInfoView',
components:{
    GroupInfoComponent,
    GroupProjects
}
}
</script>

<style>

</style>