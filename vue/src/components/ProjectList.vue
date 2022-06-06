<template>
  <div class="project-list">
<!--    <div class="header">-->
<!--      <h1>All Projects</h1>-->
<!--    </div>-->

    <div class="choice">

      <ol class="picker">
        <h1>View Projects By:</h1>
        <li><button @click="isHiddenID = !isHiddenID">Project ID</button></li>
        <li><button @click="isHiddenName = !isHiddenName">Project Name</button></li>
        <li><button @click="isHiddenDescription = !isHiddenDescription">Project Description</button></li>
        <li><button @click="isHiddenLocation = !isHiddenLocation">Project Location</button></li>
        <li><button @click="isHiddenPrecinct = !isHiddenPrecinct">Project Precinct</button></li>
        <li><button @click="isHiddenMunicipality = !isHiddenMunicipality">Project Municipality</button></li>
        <li><button @click="isHiddenMangerID = !isHiddenMangerID">Project MangerID</button></li>
        <li><button @click="isHiddenGroupID = !isHiddenGroupID">Project GroupID</button></li>
        <li><button @click="isHiddenContractName = !isHiddenContractName">Project Contract Name</button></li>
        <li><button @click="isHiddenFunding = !isHiddenFunding">Project Funding Name</button></li>
      </ol>
      <div v-for="project in filteredList"
          v-bind:key="project.id"
          class="projectList">
        <div v-if="isHiddenID===true">
          {{project.projectID}}
        </div>
        <div v-if="isHiddenName===true">
          {{project.projectName}}
        </div>
        <div v-if="isHiddenDescription===true">
          {{project.description}}
        </div>
        <div v-if="isHiddenLocation===true">
          {{project.location}}
        </div>
        <div v-if="isHiddenPrecinct===true">
          {{project.precinct}}
        </div>
        <div v-if="isHiddenMunicipality===true">
          {{project.municipality}}
        </div>
        <div v-if="isHiddenMangerID===true">
          {{project.projectManagerID}}
        </div>
        <div v-if="isHiddenGroupID===true">
          {{project.groupID}}
        </div>
        <div v-if="isHiddenContractName===true">
          {{project.contractName}}
        </div>
        <div v-if="isHiddenFunding===true">
          {{project.fundingSource}}
        </div>
      </div>
    </div>

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
        filteredProjects:[],
        isHiddenID: false,
        isHiddenName: false,
        isHiddenDescription: false,
        isHiddenPrecinct: false,
        isHiddenMunicipality: false,
        isHiddenContractName: false,
        isHiddenFunding: false,
        isHiddenGroupID: false,
        isHiddenLocation: false,
        isHiddenMangerID: false
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

<style scoped>

.picker {
  list-style: none;
  display: flex;
  flex-direction: column;
  justify-content: center;
  flex-grow: 1;
}

h1 {
  text-decoration: none;
}

.choice {
  display: flex;
  justify-content: center;
}

button:visited {
  background-color: red;
}

.projectList li {
  display: flex;
  flex-direction: column;
}

.choice .picker li button{
  text-decoration: none;
  display: flex;
  justify-content: center;
  padding: 5px;
  color: white;
  background-color: #073763;
  font-size: 1.5rem;
  border-radius: 5px;
  margin: 5px;
  flex-wrap: wrap;
}

.picker {
  max-width: 50%;
}
</style>


<!--    <table id="projectTable">-->
<!--      <thead>-->
<!--        <tr>-->
<!--          <th>Project ID</th>-->
<!--          <th>Project Name</th>-->
<!--          <th>Project Description</th>-->
<!--          <th>Project Location</th>-->
<!--          <th>Precinct</th>-->
<!--          <th>Municipality</th>-->
<!--          <th>Project Manager ID</th>-->
<!--          <th>Project Group ID</th>-->
<!--          <th>Contract Name</th>-->
<!--          <th>Funding Source</th>-->
<!--        </tr>-->
<!--      </thead>-->
<!--      <tbody>-->
<!--        <tr>-->
<!--          <td class="idfilter">-->
<!--            <input type="text" id="projectIDFilter" v-model="filter.projectID"/>-->
<!--          </td>-->
<!--          <td class="nameFilter">-->
<!--            <input type="text" id="projectNameFilter" v-model="filter.projectName"/>-->
<!--          </td>-->
<!--          <td class="descriptionFilter">-->
<!--            <input type="text" id="projectDescriptionFilter" v-model="filter.description"/>-->
<!--          </td>-->
<!--          <td class="locationFilter">-->
<!--            <input type="text" id="projectLocationFilter" v-model="filter.location"/>-->
<!--          </td>-->
<!--          <td class="precinctFilter">-->
<!--            <input type="text" id="projectPrecinctFilter" v-model="filter.precinct"/>-->
<!--          </td>-->
<!--          <td class="municipalityFilter">-->
<!--            <input type="text" id="projectMunicipalityFilter" v-model="filter.municipality"/>-->
<!--          </td>-->
<!--          <td class="managerIDFilter">-->
<!--            <input type="text" id="projectManagerIDFilter" v-model="filter.projectManagerID"/>-->
<!--          </td>-->
<!--          <td class="GroupIDFilter">-->
<!--            <input type="text" id="projectGroupIDFilter" v-model="filter.groupID"/>-->
<!--          </td>-->
<!--          <td class="contractNameFilter">-->
<!--            <input type="text" id="projectContractNameFilter" v-model="filter.contractName"/>-->
<!--          </td>-->
<!--          <td>-->
<!--            <input type="text" id="projectFundingSourceFilter" v-model="filter.fundingSource"/>-->
<!--          </td>-->
<!--&lt;!&ndash;          <td>&ndash;&gt;-->
<!--&lt;!&ndash;            <select id="statusFilter" v-model="filter.status">&ndash;&gt;-->
<!--&lt;!&ndash;              <option value>Show All</option>&ndash;&gt;-->
<!--&lt;!&ndash;              <option value="In Progress">In Progress</option>&ndash;&gt;-->
<!--&lt;!&ndash;              <option value="Completed">Completed</option>&ndash;&gt;-->
<!--&lt;!&ndash;              <option value="Other Status">Other Status</option>&ndash;&gt;-->
<!--&lt;!&ndash;            </select>&ndash;&gt;-->
<!--&lt;!&ndash;          </td>&ndash;&gt;-->
<!--          <td>&nbsp;</td>-->
<!--        </tr>-->
<!--        <tr v-for="project in filteredList"-->
<!--            v-bind:key="project.id"-->
<!--            class="projectList"-->
<!--            >-->
<!--          <td>{{project.projectID}}</td>-->
<!--          <td>{{project.projectName}}</td>-->
<!--          <td>{{project.description}}</td>-->
<!--          <td>{{project.location}}</td>-->
<!--          <td>{{project.precinct}}</td>-->
<!--          <td>{{project.municipality}}</td>-->
<!--          <td>{{project.projectManagerID}}</td>-->
<!--          <td>{{project.groupID}}</td>-->
<!--          <td>{{project.contractName}}</td>-->
<!--          <td>{{project.fundingSource}}</td>-->
<!--        </tr>-->
<!--      </tbody>-->
<!--    </table>-->