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
  </div>
  
</template>

<script>
import ContactService from '../services/ContactService'
export default {
name:'contact-details-component',
props:{
    'contactID': Number
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