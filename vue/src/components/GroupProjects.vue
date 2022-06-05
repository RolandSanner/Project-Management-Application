<template>
<div>
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
  <h2>Contacts</h2>
  <table id='contact-table'>
<thead>
    <tr>
        <th>Contact</th>
        <th>Role</th>
    </tr>
</thead>
<tbody>
    <tr v-for="contact in contacts" v-bind:key="contact.contactID" class="contact">
        <td>{{contact.firstName}} {{contact.lastName}}</td>
        <td>{{contact.contactRole}}</td>
    </tr>
</tbody>
  </table>
  <table id="project-manager-table">
      <thead>
          <tr>
              <th>Project Manager</th>
              <th>Number of Projects</th>
          </tr>
      </thead>
      <tbody>
          <tr v-for="[key,value] in projectManagers" v-bind:key="key" class="manager-list">
              <td>{{key}}</td>
              <td>{{value}}</td>
          </tr>
      </tbody>
  </table>
    <table id="precinct-table">
      <thead>
          <tr>
              <th>Precinct</th>
              <th>Number of Projects</th>
          </tr>
      </thead>
      <tbody>
          <tr v-for="[key,value] in precincts" v-bind:key="key" class="precinct-list">
              <td>{{key}}</td>
              <td>{{value}}</td>
          </tr>
      </tbody>
  </table>
  <table id="funding-table">
      <thead>
          <tr>
              <th>Funding Types</th>
              <th>Number of Projects</th>
          </tr>
      </thead>
      <tbody>
          <tr v-for="[key,value] in fundingTypes" v-bind:key="key" class="funding-list">
              <td>{{key}}</td>
              <td>{{value}}</td>
          </tr>
      </tbody>
  </table>
  </div>
</template>

<script>
import ProjectService from '../services/ProjectService'
import ContactService from '../services/ContactService'
export default {
name:'group-projects',
props:{
    'groupId':Number
},
data(){
    return{
        projects:[],
        projectManagers:[],
        precincts:[],
        fundingTypes:[],
        contacts:[]
    }
},
created(){
    ProjectService.getProjectsByGroupId(this.$route.params.id).then(response=>{
        this.projects=response.data;
        this.projectManagers=this.findUniqueManagers();
        this.precincts=this.findUniquePrecincts();
        this.fundingTypes=this.findUniqueFundingTypes();
    }),

    ContactService.listContactsByGroupId(this.$route.params.id).then(response=>{
        this.contacts=response.data;
    })
},
methods:{
    findUniqueManagers(){
        let managers= new Map;
    for(let i=0;i<this.projects.length;i++){
        if(!managers.has(this.projects[i].projectManagerName)){
            managers.set(this.projects[i].projectManagerName, 1)
        }else{
            managers.set(this.projects[i].projectManagerName,(managers.get(this.projects[i].projectManagerName)+1))
        }
    }
    return managers;
},
    findUniquePrecincts(){
        let precincts=new Map;
        for(let i=0;i<this.projects.length;i++){
        if(!precincts.has(this.projects[i].precinct)){
            precincts.set(this.projects[i].precinct,1)
        }else{
            precincts.set(this.projects[i].precinct,(precincts.get(this.projects[i].precinct)+1))
        }
    }
    return precincts;
    },
      findUniqueFundingTypes(){
        let funding=new Map;
        for(let i=0;i<this.projects.length;i++){
        if(!funding.has(this.projects[i].fundingSource)){
            funding.set(this.projects[i].fundingSource,1)
        }else{
            funding.set(this.projects[i].fundingSource,(funding.get(this.projects[i].fundingSource)+1))
        }
    }
    return funding;
    }

}
}
</script>

<style>
table{
    border:2px solid black;
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