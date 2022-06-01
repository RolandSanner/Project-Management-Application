<template>
  <div id="new-project-form">
    <form class="new-project">
      <h1 class="h3 mb-3 font-weight-normal">New Project</h1>
    <input
      type="text"
      id="project-id"
      class="form-control"
      placeholder="Project ID"
      required
      autofocus
      v-model="project.ProjectId"
    />
    <input
      type="text"
      id="project-name"
      class="form-control"
      placeholder="Project Name"
      required
      autofocus
      v-model="project.projectName"
    />
    <textarea
      id="project-description"
      class="form-control"
      placeholder="Project Description"
      required
      autofocus
      rows="4"
      cols="23"
      v-model="project.projectDescription" 
    />
    <input
      type="text"
      id="primary-funding"
      class="form-control"
      placeholder="Primary Funding Source"
      required
      autofocus
      v-model="project.primaryFunding"
    />
    <input
      type="text"
      id="secondary-funding"
      class="form-control"
      placeholder="Secondary Funding Sources"
      autofocus
      v-model="project.secondaryFunding"
    />
    <input
      type="text"
      id="precinct"
      class="form-control"
      placeholder="Precinct"
      required
      autofocus
      v-model="project.precinct"
    />
    <input
      type="text"
      id="contract"
      class="form-control"
      placeholder="Contract"
      required
      autofocus
      v-model="project.contract"
    />
     <button type="submit" v-on:click="saveDocument()">Submit</button>
     <button type="cancel" class="cancel" v-on:click="cancel()">Cancel</button>
    </form>
  </div>
</template>

<script>
  import projectService from './../services/ProjectService'

  export default {
  name: "new-project",
  components: {
    
  },
  data() {
      return {
        project: {
          projectId: '',
          projectName: '',
          projectDescription: '',
          primaryFunding: '',
          secondaryFunding: '',
          precinct: '',
          contract: ''
        }
      }
    },
   methods: {
    saveDocument() {
      projectService.create(this.project)
                     .then(response => {
                       if(response.status === 201){
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
  };
</script>

<style>
* {
  font-family: Arial, Helvetica, sans-serif;
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  background-color: #ffffff;
}

#new-project-form{
  display: block;
  position: absolute;
  top: 50%;
  left: 50%;
  height: auto;
  color: #313131;
  transform: translate(-50%, -50%);
  padding: 30px;
  appearance: none;
  border:none;
  outline: none;
  background: none;
  border-radius: 5px;
  box-shadow: 0px 0px 4px #043464;
  margin-top: 5%;
}

#new-project-form  h1 {
  display: flex;
  justify-content: center;
  padding: 25px 25px 25px 25px;
  font-size: 2.3rem;
}

#new-project-form label {
  display: flex;
  justify-content: center;
  padding: 5px;
}

.form-control {
  display: flex;
  justify-content: center;
  box-shadow: 0px 0px 4px #043464;
  background-color: white;
  border-radius: 3px;
  font-size: 1.5rem;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 15px;
  cursor: text;
  padding-left: 5px;
  width: auto;
}

.form-control:focus{
  background: #04346435;
}

form button {
  background-color: #043464;
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
</style>