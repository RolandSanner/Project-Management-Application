<template>
  <div class="project-list">
      <div v-for="project in projects" v-bind:key="project.id" class="project">
          {{project.project_name}}
      </div>
  </div>
</template>

<script>
import ProjectService from '../services/ProjectService'
export default {
name:'project-list',
data(){
    return{
        projects:[]
    }
},
created(){
    ProjectService.listProjects().then(response=>{
        this.projects=response.data;
    })
}
}
</script>

<style>

</style>