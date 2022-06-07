<template>
  <div class="project-list">

    <div class="headerlink">
      <li class="header">View Project By:</li>
    </div>
    <div class="choice">
      <ol class="picker">

        <li>
          <button @click="isHiddenID = !isHiddenID"
                  :style="isHiddenID ? {'background-color': 'white', 'color': '#073763'} : null">Project ID
          </button>
        </li>
        <td class="idfilter">
          <input type="text" id="projectIDFilter" v-model="filter.projectID" class="form-control" placeholder="Search..."/>
        </td>
        <li>
          <button @click="isHiddenName = !isHiddenName"
                  :style="isHiddenName ? {'background-color': 'white', 'color': '#073763'} : null">Project Name
          </button>
        </li>
        <td class="nameFilter">
          <input type="text" id="projectNameFilter" v-model="filter.projectName" class="form-control" placeholder="Search..."/>
        </td>
        <li>
          <button @click="isHiddenDescription = !isHiddenDescription"
                  :style="isHiddenDescription ? {'background-color': 'white', 'color': '#073763'} : null">Project
            Description
          </button>
        </li>
        <td class="descriptionFilter">
          <input type="text" id="projectDescriptionFilter" v-model="filter.description" class="form-control" placeholder="Search..."/>
        </td>
        <li>
          <button @click="isHiddenLocation = !isHiddenLocation"
                  :style="isHiddenLocation ? {'background-color': 'white', 'color': '#073763'} : null">Project Location
          </button>
        </li>
        <td class="locationFilter">
          <input type="text" id="projectLocationFilter" v-model="filter.location" class="form-control" placeholder="Search..."/>
        </td>
        <li>
          <button @click="isHiddenPrecinct = !isHiddenPrecinct"
                  :style="isHiddenPrecinct ? {'background-color': 'white', 'color': '#073763'} : null">Project Precinct
          </button>
        </li>
        <td class="precinctFilter">
          <input type="text" id="projectPrecinctFilter" v-model="filter.precinct" class="form-control" placeholder="Search..."/>
        </td>
        <li>
          <button @click="isHiddenMunicipality = !isHiddenMunicipality"
                  :style="isHiddenMunicipality ? {'background-color': 'white', 'color': '#073763'} : null">Project
            Municipality
          </button>
        </li>
        <td class="municipalityFilter">
          <input type="text" id="projectMunicipalityFilter" v-model="filter.municipality" class="form-control" placeholder="Search..."/>
        </td>

        <li>
          <button @click="isHiddenMangerID = !isHiddenMangerID"
                  :style="isHiddenMangerID ? {'background-color': 'white', 'color': '#073763'} : null">Project MangerID
          </button>
        </li>
        <td class="managerIDFilter">
          <input type="text" id="projectManagerIDFilter" v-model="filter.projectManagerID" class="form-control" placeholder="Search..."/>
        </td>

        <li>
          <button @click="isHiddenGroupID = !isHiddenGroupID"
                  :style="isHiddenGroupID ? {'background-color': 'white', 'color': '#073763'} : null">Project GroupID
          </button>
        </li>
        <td class="GroupIDFilter">
          <input type="text" id="projectGroupIDFilter" v-model="filter.groupID" class="form-control" placeholder="Search..."/>
        </td>

        <li>
          <button @click="isHiddenContractName = !isHiddenContractName"
                  :style="isHiddenContractName ? {'background-color': 'white', 'color': '#073763'} : null">Project
            Contract Name
          </button>
        </li>
        <td class="contractNameFilter">
          <input type="text" id="projectContractNameFilter" v-model="filter.contractName" class="form-control" placeholder="Search..."/>
        </td>
        <li>
          <button @click="isHiddenFunding = !isHiddenFunding"
                  :style="isHiddenFunding ? {'color': '#073763', 'background-color': 'white'} : null">Project Funding
            Name
          </button>
        </li>
        <td>
          <input type="text" id="projectFundingSourceFilter" v-model="filter.fundingSource" class="form-control" placeholder="Search..."/>
        </td>
      </ol>
      <table>
        <tbody id="listOfProjects">
        <tr v-for="project in filteredList"
            v-bind:key="project.id"
            class="projectList"
        >
          <td v-if="isHiddenID===true">
            <router-link :to="{ name: 'projectinfoview', params: {id:project.projectID} }" class="routerLinks">
              {{ project.projectID }}
            </router-link>
          </td>
          <td v-if="isHiddenName===true">
            <router-link :to="{ name: 'projectinfoview', params: {id:project.projectID} }" class="routerLinks">
              {{ project.projectName }}
            </router-link>
          </td>
          <td v-if="isHiddenDescription===true">
            <router-link :to="{ name: 'projectinfoview', params: {id:project.projectID} }" class="routerLinks">
              {{ project.description }}
            </router-link>
          </td>
          <td v-if="isHiddenMangerID===true">
            <router-link :to="{ name: 'projectinfoview', params: {id:project.projectID} }" class="routerLinks">
              {{ project.location }}
            </router-link>
          </td>
          <td v-if="isHiddenPrecinct===true">
            <router-link :to="{ name: 'projectinfoview', params: {id:project.projectID} }" class="routerLinks">
              {{ project.precinct }}
            </router-link>
          </td>
          <td v-if="isHiddenMunicipality===true">
            <router-link :to="{ name: 'projectinfoview', params: {id:project.projectID} }" class="routerLinks">
              {{ project.municipality }}
            </router-link>
          </td>
          <td v-if="isHiddenContractName===true">
            <router-link :to="{ name: 'projectinfoview', params: {id:project.projectID} }" class="routerLinks">
              {{ project.projectManagerID }}
            </router-link>
          </td>
          <td v-if="isHiddenFunding===true">
            <router-link :to="{ name: 'projectinfoview', params: {id:project.projectID} }" class="routerLinks">
              {{ project.groupID }}
            </router-link>
          </td>
          <td v-if="isHiddenGroupID===true">
            <router-link :to="{ name: 'projectinfoview', params: {id:project.projectID} }" class="routerLinks">
              {{ project.contractName }}
            </router-link>
          </td>
          <td v-if="isHiddenLocation===true">
            <router-link :to="{ name: 'projectinfoview' , params: {id:project.projectID}}" class="routerLinks">
              {{ project.fundingSource }}
            </router-link>
          </td>

        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import ProjectService from './../services/ProjectService'

export default {
  name: 'project-list',
  data() {
    return {
      projects: [],
      filter: {
        projectID: "",
        projectName: "",
        description: "",
        location: "",
        precinct: "",
        municipality: "",
        projectManagerID: "",
        groupID: "",
        contractName: "",
        fundingSource: ""
      },
      filteredProjects: [],
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
  created() {
    ProjectService.listProjects().then(response => {
      this.projects = response.data;
      console.log(this.projects)
    })
  },
  methods: {},
  computed: {
    filteredList() {
      let filteredProjects = this.projects;
      if (this.filter.projectID != "") {
        filteredProjects = filteredProjects.filter((project) =>
            project.projectID.toLowerCase().includes(this.filter.projectID.toLowerCase()))
      }
      if (this.filter.projectName != "") {
        filteredProjects = filteredProjects.filter((project) =>
            project.projectName.toLowerCase().includes(this.filter.projectName.toLowerCase()));
      }
      if (this.filter.description != "") {
        filteredProjects = filteredProjects.filter((project) =>
            project.description.toLowerCase().includes(this.filter.description.toLowerCase()));
      }
      if (this.filter.location != "") {
        filteredProjects = filteredProjects.filter((project) =>
            project.location.toLowerCase().includes(this.filter.location.toLowerCase()));
      }
      if (this.filter.precinct != "") {
        filteredProjects = filteredProjects.filter((project) =>
            project.precinct.toLowerCase().includes(this.filter.precinct.toLowerCase()));
      }
      if (this.filter.municipality != "") {
        filteredProjects = filteredProjects.filter((project) =>
            project.municipality.toLowerCase().includes(this.filter.municipality.toLowerCase()));
      }
      if (this.filter.projectManagerID != "") {
        filteredProjects = filteredProjects.filter((project) =>
            project.projectManagerID.toLowerCase().includes(this.filter.projectManagerID.toLowerCase()));
      }
      if (this.filter.groupID != "") {
        filteredProjects = filteredProjects.filter((project) =>
            project.projectName.toLowerCase().includes(this.filter.projectName.toLowerCase()));
      }
      if (this.filter.contractName != "") {
        filteredProjects = filteredProjects.filter((project) =>
            project.contractName.toLowerCase().includes(this.filter.contractName.toLowerCase()));
      }
      if (this.filter.fundingSource != "") {
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
  justify-content: flex-start;
  flex-grow: 1;
}

.headerlink {
  display: flex;
  justify-content: center;
}

.choice {
  display: flex;
  justify-content: center;
}

.choice .picker li button {
  text-decoration: none;
  display: flex;
  justify-content: center;
  padding: 2px;
  color: white;
  background-color: #073763;
  font-size: 1rem;
  border-radius: 5px;
  margin: 2px;
  flex-wrap: wrap;
}

.choice .picker li button:hover {
  color: #acaeaf;
  cursor: pointer;
}

.header {
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
  max-width: 50%;
}

.picker {
  max-width: 50%;
}

.projectList {
  list-style: none;
  display: flex;
  justify-content: center;
  flex-grow: 1;
  flex-direction: column;
  flex-wrap: wrap;
}

table {
  border: none;
  display: flex;
}

#listOfProjects {
  display: flex;
  justify-content: flex-start;
  flex-wrap: wrap;
  flex-direction: column;
}

.routerLinks {
  font-size: 1rem;
  color: #073763;
  background-color: white;
  padding: 1px;
  margin: 1px;
}

td {
  border: none;
  padding-top: 5px;
}

tbody tr {
  border-bottom: 2px solid black;
}

.picker input:focus {
  width: 250px
}

</style>
