<template>
  <div class='project-list'>
      <h1>All Projects</h1>
      <project-list/>
  </div>
</template>

<script>
import ProjectList from '../components/ProjectList.vue'
export default {
name: 'ProjectList',
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