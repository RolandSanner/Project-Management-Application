<template>
  <div id="project-component-main">
    <div id="project-component">
      <form class="new-project" @submit.prevent>
        <h1 class="h3 mb-3 font-weight-normal">Update Project</h1>
        <input
            type="text"
            id="project-id"
            class="form-control"
            required
            autofocus
            v-model="project.projectID"
        />
        <input
            type="text"
            id="project-name"
            class="form-control"
            required
            autofocus
            v-model="project.projectName"
        />
        <textarea
            id="project-description"
            class="form-control"
            autofocus
            required
            rows="4"
            cols="23"
            v-model="project.description"
        />
        <input
            type="text"
            id="primary-funding"
            class="form-control"
            autofocus
            v-model="project.fundingSource"
        />
        <!-- <input
            type="text"
            id="precinct"
            class="form-control"
            placeholder="* Precinct"
            required
            autofocus
            v-model="project.precinct"
        /> -->

        <select
            id="project-precinct"
            class="form-control form-control-dropper"
            name="state"
            autofocus
            v-model="project.precinct"
        >
          <option value="" disabled selected>Precinct</option>
          <option value=1>1</option>
          <option value=2>2</option>
          <option value=3>3</option>
          <option value=4>4</option>
          <option value=5>5</option>
          <option value=6>6</option>
          <option value=7>7</option>
          <option value=8>8</option>
          <option value=9>9</option>
          <option value=10>10</option>
          <option value=11>11</option>
          <option value=12>12</option>
          <option value=13>13</option>
          <option value=14>14</option>
          <option value=15>15</option>
          <option value=16>16</option>
          <option value=17>17</option>
          <option value=18>18</option>
          <option value=19>19</option>
          <option value=20>20</option>

        </select>
        <input
            type="text"
            id="municipality"
            class="form-control"
            autofocus
            required
            v-model="project.municipality"
        />
        <input
            type="text"
            id="location"
            class="form-control"
            required
            autofocus
            v-model="project.location"
        />
        <input
            type="text"
            id="contract"
            class="form-control"
            autofocus
            v-model="project.contractName"
        />
        <input
            type="text"
            id="projectManagerId"
            class="form-control"
            autofocus
            v-model="project.projectManagerID"
        />
        <input
            type="text"
            id="groupID"
            class="form-control"
            autofocus
            v-model="project.groupID"
        />


        <button type="submit" v-on:click="updateProject()">Submit</button>
        <button type="reset" class="cancel" v-on:click="cancel()">Cancel</button>
      </form>
    </div>
  </div>
</template>

<script>
import ProjectService from './../services/ProjectService'

export default {
  name: "UpdateProject",
  data(){
    return {
      project: {
        projectID: '',
        projectName: '',
        description: '',
        fundingSource: '',
        precinct: '',
        municipality: '',
        location: '',
        contractName: '',
        projectManagerID: '',
        groupID: ''
      },
    }
  },
  created(){
    ProjectService.getProjectById(this.$route.params.id).then(response=>{
      this.project=response.data;
    })
  },
  methods: {
    updateProject() {
      ProjectService.updateProject(this.project)
          .then(response => {
            if(response.status < 300){
              this.$router.push("/")
            }
          })
          .catch(error => {
            console.error(error)
          })
    },
    cancel() {
      this.$router.push('/')
    }
  }
}
</script>

<style scoped>
* {
  font-family: Arial, Helvetica, sans-serif;
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

#project-component-main {
  display: flex;
  justify-content: center;
}

#project-component {
  display: flex;
  justify-content: center;
  align-items: center;
  height: auto;
  padding: 30px;
  border-radius: 5px;
  box-shadow: 0 0 4px #073763;
  margin-top: 5%;
  min-width: 350px;
  max-width: 70%;
}

#project-component  h1 {
  display: flex;
  justify-content: center;
  padding: 25px;
  font-size: 2.3rem;
  text-decoration: none;

}

.form-control {
  display: flex;
  justify-content: center;
  box-shadow: 0 0 4px #073763;
  background-color: white;
  border-radius: 3px;
  font-size: 1.5rem;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 15px;
  cursor: text;
  padding-left: 5px;
  min-width: 300px;
}

.form-control-dropper {
  display: flex;
  color: #313131;
  background-color: white;
  border-radius: 5px;
  font-size: 1.5rem;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 15px;
  cursor: pointer;
  padding-left: 5px;
  width: 300px;
}

.form-control:focus{
  background: #07376335;
}
.form-control:focus{
  background: #07376335;
}

form button {
  background-color: #073763;
  color: white;
  display: flex;
  margin-left: auto;
  margin-right: auto;
  margin-top: 15px;
  font-size: 18px;
  padding: 3px;
  border-radius: 3px;
  cursor: pointer;
}

.cancel {
  background-color: gray;
}

h4 {
  display: flex;
  justify-content: flex-end;
  margin-bottom: 5px;
  color: #31313183;
}
</style>