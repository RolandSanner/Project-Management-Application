<template>
<div id="main">
    <div id="projects-list"> 
    <h2>Projects</h2>
      <table id='project-table'>
<thead>
    <tr>
        <th>Project Name</th>
        <th>Project ID</th>
    </tr>
</thead>
<tbody>
    <tr v-for="project in projects" v-bind:key="project.id" class="project">
        <td>
            <router-link v-bind:to="{name:'projectinfoview',params:{id:project.projectID}}">
      {{project.projectName}}
      </router-link>
      </td>
        <td>{{project.projectID}}</td>
    </tr>
</tbody>
  </table>
  </div>
</div>
</template>

<script>
import ProjectService from '../services/ProjectService'
export default {
name:'contact-projects',
props:{
    'contactId':Number
},
data(){
    return{
        projects:[]

    }
},
created(){
    ProjectService.getProjectsByContractorId(this.$route.params.id).then(response=>{
        this.projects=response.data;

    });   

},
methods:{

},
}
</script>

<style>
#main{
    display: grid;
    grid-template-columns: 1fr,3fr,;
    grid-template-rows: 40vh,40vh;
    grid-template-areas: 
    "project-list data";
    justify-items: center;
}
#data{
    grid-area: data;
    display: flex;
}
#projects-list{
    grid-area: project-list;
    margin: 10px;
    padding: 20%;
    justify-self: left;
}
table{
    border:2px solid black;
    width: 20vw;
}
td{
    border: 1px solid black;
}
thead,th{
     color: white;
     background-color: #073763;
}
th{
    padding: 8px;
}
</style>