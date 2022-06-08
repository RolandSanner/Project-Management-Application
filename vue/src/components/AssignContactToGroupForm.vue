<template>
  <div id="assign-to-group-comp">
      <form class="assign-group">
          <label id="groupIdLabel" for="groupId">Assign Contact to Group</label>
          <div id="input">
          <input type="text"
          name="groupId"
           id="group_id" 
           placeholder="Group ID#" 
           required
           v-model="groupContact.group_id"
           />
           <button id="assignGroupButton" v-on:click="assignContact()">Submit</button>
           </div>
      </form>
    
  </div>
</template>

<script>
import ContactService from '../services/ContactService'
export default {
name:'contact-group-assignment-form',
data(){
    return{
        groupContact:{
            contact_id:0,
            group_id:''
            },
    }
},
created(){
    
        this.groupContact.contact_id=this.$route.params.id
    },
methods:{
    assignContact(){

        ContactService.assignContactToGroup(this.groupContact);
    },
}
}
</script>

<style>
#input{
    display: flex;
    justify-content: center;
}
#assignGroupButton{
    margin: 0px;
}
.assign-group{
    flex-basis: 100%;
}
#groupIdLabel{
    display: flex;
    justify-content: center;
}
</style>