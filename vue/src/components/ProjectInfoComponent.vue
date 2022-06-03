<template>
  <div class='project-info'>
      <h2>Project ID: {{project.projectID}}</h2>
      <h2>Project Name: {{project.projectName}}</h2>
      <h2>Description: {{project.description}}</h2>
      <h2>Location: {{project.location}}</h2>
      <h2>Precinct: {{project.precinct}}</h2>
      <h2>Municipality: {{project.municipality}}</h2>
      <h2>Project Manager: {{project.projectManagerID}}</h2>
      <h2>Group: {{project.groupID}}</h2>
      <h2>Contractor: </h2>
  </div>
</template>

<script>
 import ProjectService from '../services/ProjectService'
export default {
 name:'project-info-component',
 props:{
     'projectId': NaN
 },
 data(){
     return{
     project:{
         projectId:0,
         project_name:'',
        project_description:'',
        project_location:'',
        precinct:'',
        municipality:'',
        project_manager_id:0,
        group_id:0
    }
     }
 },
 created(){
     ProjectService.getProjectById(this.$route.params.id).then(response=>{
         this.project=response.data;
     })
 }
}
</script>

<style>

.project-info {
    display: flex;
}

</style>