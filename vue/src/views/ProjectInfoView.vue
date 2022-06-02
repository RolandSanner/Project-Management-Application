<template>
  <div>
      <h1>Project Info</h1>
    <project-info-component v-bind:project-id="$route.params.id"/>
  </div>
</template>

<script>
import ProjectInfoComponent from '../components/ProjectInfoComponent.vue';
export default {
name:'ProjectInfoView',
components:{
    ProjectInfoComponent
}
}
</script>

<style>

</style>