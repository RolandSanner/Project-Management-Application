<template>
  <div class='project-info'>
      <h2>Project ID: </h2>
      <h2>Project Name: </h2>
      <h2>Description: </h2>
      <h2>Location: </h2>
      <h2>Precinct: </h2>
      <h2>Municipality: </h2>
      <h2>Project Manager: </h2>
      <h2>Group: </h2>
      <h2>Contractor: </h2>
  </div>
</template>

<script>
import ProjectService from '../services/ProjectService'
export default {
name:'project-info-component',
props:{
    'projectId':Number
},
data(){
    project:{
        projectId:0
    }
}
}
</script>

<style>

</style>