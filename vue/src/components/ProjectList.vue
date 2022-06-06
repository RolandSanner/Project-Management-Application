<template>
  <div class="project-list">
    <div class="header">
      <h1>All Projects</h1>
    </div>
    <table id="projectTable">
      <thead>
        <tr>
          <th>Project ID</th>
          <th>Project Name</th>
          <th>Project Description</th>
          <th>Project Location</th>
          <th>Precinct</th>
          <th>Municipality</th>
          <th>Project Manager ID</th>
          <th>Project Group ID</th>
          <th>Contract Name</th>
          <th>Funding Source</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td class="idfilter">
            <input type="text" id="projectIDFilter" v-model="filter.projectID"/>
          </td>
          <td class="nameFilter">
            <input type="text" id="projectNameFilter" v-model="filter.projectName"/>
          </td>
          <td class="descriptionFilter">
            <input type="text" id="projectDescriptionFilter" v-model="filter.description"/>
          </td>
          <td class="locationFilter">
            <input type="text" id="projectLocationFilter" v-model="filter.location"/>
          </td>
          <td class="precinctFilter">
            <input type="text" id="projectPrecinctFilter" v-model="filter.precinct"/>
          </td>
          <td class="municipalityFilter">
            <input type="text" id="projectMunicipalityFilter" v-model="filter.municipality"/>
          </td>
          <td class="managerIDFilter">
            <input type="text" id="projectManagerIDFilter" v-model="filter.projectManagerID"/>
          </td>
          <td class="GroupIDFilter">
            <input type="text" id="projectGroupIDFilter" v-model="filter.groupID"/>
          </td>
          <td class="contractNameFilter">
            <input type="text" id="projectContractNameFilter" v-model="filter.contractName"/>
          </td>
          <td>
            <input type="text" id="projectFundingSourceFilter" v-model="filter.fundingSource"/>
          </td>
<!--          <td>-->
<!--            <select id="statusFilter" v-model="filter.status">-->
<!--              <option value>Show All</option>-->
<!--              <option value="In Progress">In Progress</option>-->
<!--              <option value="Completed">Completed</option>-->
<!--              <option value="Other Status">Other Status</option>-->
<!--            </select>-->
<!--          </td>-->
          <td>&nbsp;</td>
        </tr>
        <tr v-for="project in filteredList"
            v-bind:key="project.id"
            class="projectList"
            >
          <td>{{project.projectID}}</td>
          <td>{{project.projectName}}</td>
          <td>{{project.description}}</td>
          <td>{{project.location}}</td>
          <td>{{project.precinct}}</td>
          <td>{{project.municipality}}</td>
          <td>{{project.projectManagerID}}</td>
          <td>{{project.groupID}}</td>
          <td>{{project.contractName}}</td>
          <td>{{project.fundingSource}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import ProjectService from './../services/ProjectService'
export default {
name:'project-list',
data(){
    return{
        projects:[],
        filter:{
          projectID:"",
          projectName:"",
          description:"",
          location:"",
          precinct:"",
          municipality:"",
          projectManagerID:"",
          groupID:"",
          contractName:"",
          fundingSource:""
        },
        filteredProjects:[]
    }
},
created(){
    ProjectService.listProjects().then(response=>{
        this.projects=response.data;
        console.log(this.projects)
    })
},
  methods: {

  },
  computed:{
    filteredList(){
      let filteredProjects = this.projects;
      if(this.filter.projectID != ""){
        filteredProjects = filteredProjects.filter((project) =>
        project.projectID.includes(this.filter.projectID))
      }
      if(this.filter.projectName != ""){
        filteredProjects = filteredProjects.filter((project) =>
        project.projectName.toLowerCase().includes(this.filter.projectName.toLowerCase()));
      }
      if(this.filter.description != ""){
        filteredProjects = filteredProjects.filter((project) =>
            project.description.toLowerCase().includes(this.filter.description.toLowerCase()));
      }
      if(this.filter.location != ""){
        filteredProjects = filteredProjects.filter((project) =>
            project.location.toLowerCase().includes(this.filter.location.toLowerCase()));
      }
      if(this.filter.precinct != ""){
        filteredProjects = filteredProjects.filter((project) =>
            project.precinct.toLowerCase().includes(this.filter.precinct.toLowerCase()));
      }
      if(this.filter.municipality != ""){
        filteredProjects = filteredProjects.filter((project) =>
            project.municipality.toLowerCase().includes(this.filter.municipality.toLowerCase()));
      }
      if(this.filter.projectManagerID != ""){
        filteredProjects = filteredProjects.filter((project) =>
            project.projectManagerID.toLowerCase().includes(this.filter.projectManagerID.toLowerCase()));
      }
      if(this.filter.groupID != ""){
        filteredProjects = filteredProjects.filter((project) =>
            project.projectName.toLowerCase().includes(this.filter.projectName.toLowerCase()));
      }
      if(this.filter.contractName != ""){
        filteredProjects = filteredProjects.filter((project) =>
            project.contractName.toLowerCase().includes(this.filter.contractName.toLowerCase()));
      }
      if(this.filter.fundingSource != ""){
        filteredProjects = filteredProjects.filter((project) =>
            project.fundingSource.toLowerCase().includes(this.filter.fundingSource.toLowerCase()));
      }
      return filteredProjects;
    }
  }
}
</script>

<style>
table{
  color: #073763;
}

.projectList > td{
  padding: 3px 0 3px 3px;
}

/*.projectList tr {*/
/*  display: flex;*/
/*}*/

.header {
  display: flex;
  justify-content: center;
}

</style>