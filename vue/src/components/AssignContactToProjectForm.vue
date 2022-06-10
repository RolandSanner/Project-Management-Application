<template>
    <div id="assign-to-project-comp">
      <form class="assign-project">
          <label id="projectIdLabel" for="projectId">Assign Contact to Project</label>
          <div id="input1">
          <input type="text"
          name="projectId"
           id="project_id" 
           placeholder="Project ID#" 
           required
           v-model="projectContact.project_id"
           />
           <button id="assignProjectButton" v-on:click="assignContact()">Submit</button>
           </div>
      </form>
    
  </div>
</template>

<script>
import ContactService from '../services/ContactService'
export default {
    name:'contact-project-assignment-form',
    data(){
        return{
            projectContact:{
                contractor_id:'',
                project_id:''
            }
        }
    },
    created(){
    
        this.projectContact.contractor_id=this.$route.params.id
    },
    methods:{
        assignContact(){
            ContactService.assignContactToProject(this.projectContact);
        }
    }
}
</script>

<style>
#input1{
    display: flex;
    justify-content: center;
}
#assignProjectButton{
    margin: 0px;
}
.assign-project{
    flex-basis: 100%;
}
#projectIdLabel{
    display: flex;
    justify-content: center;
}
</style>