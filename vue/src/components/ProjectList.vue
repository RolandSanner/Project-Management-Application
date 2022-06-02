<template>
  <div class="project-list">
      <div v-for="project in projects" v-bind:key="project.projectID" class="project">
          <router-link v-bind:to="{name:'projectinfoview',params:{id: project.projectID}}">
          {{project.projectName}}
          </router-link>
      </div>
  </div>
</template>

<script>
import ProjectService from './../services/ProjectService'
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
        console.log(this.projects)
    })
}
}
</script>

<style>
.project{
     margin-left: 50px;
    margin-bottom: 10px;
    margin-right: 50px;
    font-size: 24px;
    border-bottom: 1px solid #f2f2f2;
    padding: 10px 20px;
}
</style>