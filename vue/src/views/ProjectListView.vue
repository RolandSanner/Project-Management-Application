<template>
  <div class='project-list'>

      <project-list/>
  </div>
</template>

<script>
import ProjectList from '../components/ProjectList.vue'
export default {
name: 'ProjectListView',
components:{
    ProjectList
}
}
</script>

<style>
h1 {
  margin: 50px;
  text-decoration: underline;
}
</style>