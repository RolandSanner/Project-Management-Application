<template>
  <div class='contact-info'>
      <table id='info-header'>
          <thead>
              <tr>
                <th>Contact ID: {{contact.contactID}}</th>  
                <th>Contact First Name: {{contact.firstName}}</th>
                <th>Contact Last Name: {{contact.lastName}}</th>
                <th>Contact Role: {{contact.contactRole}}</th>
              </tr>
          </thead>
      </table>
    <div class="updates">
    <router-link :to="{ name: 'UpdateContact', params: {id:contact.contactID} }" class="routerLinks" v-if="$store.state.user.authorities[0].name==='ROLE_ADMIN'">
      Update Project
    </router-link>
    <assign-contact-to-project-form v-if="$store.state.user.authorities[0].name==='ROLE_ADMIN'"/>
    <assign-contact-to-group-form v-if="$store.state.user.authorities[0].name==='ROLE_ADMIN'"/>
  </div>
  </div>

  
</template>

<script>
import ContactService from '../services/ContactService'
import AssignContactToGroupForm from "@/components/AssignContactToGroupForm";
import AssignContactToProjectForm from "@/components/AssignContactToProjectForm";
export default {
name:'contact-details-component',
props:{
    'contactID': Number
},
  components:{
    AssignContactToGroupForm,
    AssignContactToProjectForm
  },
data(){
    return{
        contact:{
            contactID: '',
            firstName:'',
            lastName:'',
            contactRole:''
        }
    }
},
created(){
    ContactService.getContactByID(this.$route.params.id).then(response=>{
        this.contact=response.data;
    })
}
}
</script>

<style>
#info-header{
    width: 100vw;
    padding: 10px;
    border: 0px;
}


</style>