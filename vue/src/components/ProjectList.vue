<template>
  <div class="project-list">
    <!--    <div class="header">-->
    <!--      <h1>All Projects</h1>-->
    <!--    </div>-->

    <div class="choice">

      <ol class="picker">
        <li class="header">View Project By:</li>
        <li>
          <button @click="isHiddenID = !isHiddenID" :style="isHiddenID ? {'background-color': 'white', 'color': '#737363'} : null">Project ID</button>
        </li>
                  <td class="idfilter">
                    <input type="text" id="projectIDFilter" v-model="filter.projectID"/>
                  </td>
        <li>
          <button @click="isHiddenName = !isHiddenName" :style="isHiddenName ? {'background-color': 'white', 'color': '#737363'} : null">Project Name</button>
        </li>
                <td class="nameFilter">
                      <input type="text" id="projectNameFilter" v-model="filter.projectName"/>
                    </td>
        <li>
          <button @click="isHiddenDescription = !isHiddenDescription" :style="isHiddenDescription ? {'background-color': 'white', 'color': '#737363'} : null">Project Description</button>
        </li>
                  <td class="descriptionFilter">
                    <input type="text" id="projectDescriptionFilter" v-model="filter.description"/>
                  </td>
        <li>
          <button @click="isHiddenLocation = !isHiddenLocation" :style="isHiddenLocation ? {'background-color': 'white', 'color': '#737363'} : null">Project Location</button>
        </li>
                  <td class="locationFilter">
                    <input type="text" id="projectLocationFilter" v-model="filter.location"/>
                  </td>
        <li>
          <button @click="isHiddenPrecinct = !isHiddenPrecinct" :style="isHiddenPrecinct ? {'background-color': 'white', 'color': '#737363'} : null">Project Precinct</button>
        </li>
                  <td class="precinctFilter">
                    <input type="text" id="projectPrecinctFilter" v-model="filter.precinct"/>
                  </td>
        <li>
          <button @click="isHiddenMunicipality = !isHiddenMunicipality" :style="isHiddenMunicipality ? {'background-color': 'white', 'color': '#737363'} : null">Project Municipality</button>
        </li>
                  <td class="municipalityFilter">
                    <input type="text" id="projectMunicipalityFilter" v-model="filter.municipality"/>
                  </td>

        <li>
          <button @click="isHiddenMangerID = !isHiddenMangerID" :style="isHiddenMangerID ? {'background-color': 'white', 'color': '#737363'} : null">Project MangerID</button>
        </li>
                  <td class="managerIDFilter">
                    <input type="text" id="projectManagerIDFilter" v-model="filter.projectManagerID"/>
                  </td>

        <li>
          <button @click="isHiddenGroupID = !isHiddenGroupID" :style="isHiddenGroupID ? {'background-color': 'white', 'color': '#737363'} : null">Project GroupID</button>
        </li>
                  <td class="GroupIDFilter">
                    <input type="text" id="projectGroupIDFilter" v-model="filter.groupID"/>
                  </td>

        <li>
          <button @click="isHiddenContractName = !isHiddenContractName" :style="isHiddenContractName ? {'background-color': 'white', 'color': '#737363'} : null">Project Contract Name</button>
        </li>
                  <td class="contractNameFilter">
                    <input type="text" id="projectContractNameFilter" v-model="filter.contractName"/>
                  </td>
        <li>
          <button @click="isHiddenFunding = !isHiddenFunding" :style="isHiddenFunding ? {'background-color': 'white', 'color': '#737363'} : null">Project Funding Name</button>
        </li>
                  <td>
                    <input type="text" id="projectFundingSourceFilter" v-model="filter.fundingSource"/>
                  </td>
      </ol>
      <table>
            <tbody class="listOfProjects">
            <tr v-for="project in filteredList"
                v-bind:key="project.id"
                class="projectList"
            >
              <td v-if="isHiddenID===true"><router-link :to="{ name: 'projectinfoview' }" class="routerLinks">{{project.projectID}}</router-link></td>
              <td v-if="isHiddenName===true"><router-link :to="{ name: 'projectinfoview' }" class="routerLinks">{{project.projectID}}</router-link></td>
              <td v-if="isHiddenDescription===true"><router-link :to="{ name: 'projectinfoview' }" class="routerLinks">{{project.projectID}}</router-link></td>
              <td v-if="isHiddenLocation===true"><router-link :to="{ name: 'projectinfoview' }" class="routerLinks">{{project.projectID}}</router-link></td>
              <td v-if="isHiddenPrecinct===true"><router-link :to="{ name: 'projectinfoview' }" class="routerLinks">{{project.projectID}}</router-link></td>
              <td v-if="isHiddenMunicipality===true"><router-link :to="{ name: 'projectinfoview' }" class="routerLinks">{{project.projectID}}</router-link></td>
              <td v-if="isHiddenMangerID===true"><router-link :to="{ name: 'projectinfoview' }" class="routerLinks">{{project.projectID}}</router-link></td>
              <td v-if="isHiddenGroupID===true"><router-link :to="{ name: 'projectinfoview' }" class="routerLinks">{{project.projectID}}</router-link></td>
              <td v-if="isHiddenContractName===true"><router-link :to="{ name: 'projectinfoview' }" class="routerLinks">{{project.projectID}}</router-link></td>
              <td v-if="isHiddenFunding===true"><router-link :to="{ name: 'projectinfoview' }" class="routerLinks">{{project.projectID}}</router-link></td>
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
  justify-content: center;
  flex-grow: 1;
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
tbody {
  display: flex;
  align-content: center;
  justify-content: center;
  flex-direction: column;
}

.routerLinks {
  font-size: 1rem;
  color: #073763;
  background-color: white;
}
td {
  border: none;
  margin: 2px;
  padding: 2px;
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