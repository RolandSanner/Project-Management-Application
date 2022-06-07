<template>
  <div id="container">
      <h1>Select Group to Assign Contact</h1>
      <div v-for="group in groups" v-bind:key="group.groupID" class="group-option">
          <button v-on:click="fuckthis=false">
          {{group.groupName}}
          </button>
      </div>
  </div>
</template>

<script>
import GroupService from '../services/GroupService'
import ContactService from '../services/ContactService'
export default {
name:'contact-group-assignment-page',
data(){
    return{
        groups:[],
        groupContact:{
            contact_id:0,
            group_id:0
            },
            fuckthis:true
    }
},
created(){
    GroupService.getGroups().then(response=>{
        this.groups=response.data;
        this.groupContact.contact_id=this.$route.params.id
    })
},
methods:{
    assignContact(){

        ContactService.assignContactToGroup(this.groupContact);
    },
    assignGroupId(id){
        this.groupContact.group_id=id;
    }
}
}
</script>

<style>

</style>