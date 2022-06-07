<template>
  <div class="contact-list">
    <table id="contactTable">
      <thead>
        <tr>
          <th>Contact ID</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Phone Number</th>
          <th>Email</th>
          <th>Municipality</th>
          <th>Contact Role</th>
          <th>Company Name</th>
          <th>Industry</th>
          <th>Contact Street</th>
          <th>Contact City</th>
          <th>Contact State</th>
          <th>Contact Zip</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td class="idFilter">
            <input type="text" id="contactIDFilter" v-model="filter.contactID"/>
          </td>
          <td class="firstNameFilter">
            <input type="text" id="contactFirstNameFilter" v-model="filter.firstName"/>
          </td>
          <td class="lastNameFilter">
            <input type="text" id="contactLastNameFilter" v-model="filter.lastName"/>
          </td>
          <td class="phoneNumberFilter">
            <input type="text" id="contactPhoneNumberFilter" v-model="filter.phoneNumber"/>
          </td>
          <td class="emailFilter">
            <input type="text" id="contactEmailFilter" v-model="filter.email"/>
          </td>
          <td class="municipalityFilter">
            <input type="text" id="contactMunicipalityFilter" v-model="filter.municipality"/>
          </td>
          <td class="contactRoleFilter">
            <input type="text" id="contactRoleFilter" v-model="filter.contactRole"/>
          </td>
          <td class="companyNameFilter">
            <input type="text" id="contactCompanyNameFilter" v-model="filter.companyName"/>
          </td>
          <td class="industryFilter">
            <input type="text" id="contactIndustryFilter" v-model="filter.contractName"/>
          </td>
          <td class="contactStreetFilter">
            <input type="text" id="contactStreetFilter" v-model="filter.contactStreet"/>
          </td>
           <td class="contactCityFilter">
            <input type="text" id="contactCityFilter" v-model="filter.contactCity"/>
          </td>
           <td class="contactStateFilter">
            <input type="text" id="contactStateFilter" v-model="filter.contactState"/>
          </td>
          <td class="contactZipFilter">
            <input type="text" id="contactZipFilter" v-model="filter.contactZip"/>
          </td>
          <td>&nbsp;</td>
        </tr>
        <tr v-for="contact in filteredList"
            v-bind:key="contact.id"
            class="contactList"
            >
          <td><router-link :to="{ name: 'ContactInfoView', params: {id:contact.contactID} }" class="routerLinks">
              {{ contact.contactID }}</router-link></td>
          <td>{{contact.firstName}}</td>
          <td>{{contact.lastName}}</td>
          <td>{{contact.phoneNumber}}</td>
          <td>{{contact.email}}</td>
          <td>{{contact.municipality}}</td>
          <td>{{contact.contactRole}}</td>
          <td>{{contact.companyName}}</td>
          <td>{{contact.Industry}}</td>
          <td>{{contact.contactStreet}}</td>
          <td>{{contact.contactCity}}</td>
          <td>{{contact.contactState}}</td>
          <td>{{contact.contactZip}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import ContactService from './../services/ContactService'
export default {
name:'contact-list',
data(){
    return{
        contacts:[],
        filter:{
          contactID:"",
          firstName:"",
          lastName:"",
          phoneNumber:"",
          email:"",
          municipality:"",
          contactRole:"",
          companyName:"",
          contractName:"",
          Industry:"",
          contactStreet:"",
          contactCity:"",
          contactState:"",
          contactZip:""
        },
        filteredContacts:[]
    }
},
created(){
    ContactService.listContacts().then(response=>{
        this.contacts=response.data;
        console.log(this.contacts)
    })
},
  methods: {

  },
  computed:{
    filteredList(){
      let filteredContacts = this.contacts;
      if(this.filter.contactID != ""){
        filteredContacts = filteredContacts.filter((contact) =>
        contact.contactID.includes(this.filter.contactID))
      }
      if(this.filter.firstName != ""){
        filteredContacts = filteredContacts.filter((contact) =>
        contact.firstName.toLowerCase().includes(this.filter.firstName.toLowerCase()));
      }
      if(this.filter.lastName != ""){
       filteredContacts = filteredContacts.filter((contact) =>
            contact.lastName.toLowerCase().includes(this.filter.lastName.toLowerCase()));
      }
      if(this.filter.phoneNumber != ""){
        filteredContacts = filteredContacts.filter((contact) =>
            contact.phoneNumber.toLowerCase().includes(this.filter.phoneNumber.toLowerCase()));
      }
      if(this.filter.email != ""){
        filteredContacts = filteredContacts.filter((contact) =>
            contact.email.toLowerCase().includes(this.filter.email.toLowerCase()));
      }
      if(this.filter.municipality != ""){
        filteredContacts = filteredContacts.filter((contact) =>
            contact.municipality.toLowerCase().includes(this.filter.municipality.toLowerCase()));
      }
      if(this.filter.contactRole != ""){
        filteredContacts = filteredContacts.filter((contact) =>
            contact.contactRole.toLowerCase().includes(this.filter.contactRole.toLowerCase()));
      }
      if(this.filter.companyName != ""){
        filteredContacts = filteredContacts.filter((contact) =>
            contact.companyName.toLowerCase().includes(this.filter.companyName.toLowerCase()));
      }
      if(this.filter.contractName != ""){
        filteredContacts = filteredContacts.filter((contact) =>
            contact.contractName.toLowerCase().includes(this.filter.contractName.toLowerCase()));
      }
      if(this.filter.Industry != ""){
        filteredContacts = filteredContacts.filter((contact) =>
            contact.Industry.toLowerCase().includes(this.filter.Industry.toLowerCase()));
      }
      if(this.filter.contactStreet != ""){
        filteredContacts = filteredContacts.filter((contact) =>
            contact.contactStreet.toLowerCase().includes(this.filter.contactStreet.toLowerCase()));
      }
      if(this.filter.contactCity != ""){
        filteredContacts = filteredContacts.filter((contact) =>
            contact.contactCity.toLowerCase().includes(this.filter.contactCity.toLowerCase()));
      }
      if(this.filter.contactState != ""){
        filteredContacts = filteredContacts.filter((contact) =>
            contact.contactState.toLowerCase().includes(this.filter.contactState.toLowerCase()));
      }
      if(this.filter.contactZip != ""){
        filteredContacts = filteredContacts.filter((contact) =>
            contact.contactZip.toLowerCase().includes(this.filter.contactZip.toLowerCase()));
      }
      return filteredContacts;
    }
  }
}
</script>

<style scoped>
table{
  color: #073763;
}

.contactList > td{
  padding: 3px 0 3px 3px;
}

tbody tr{
  border: 1px solid green;
}

.contactList tr {
  display: flex;
}
.routerLinks {
  font-size: rem;
  color: white;
  background-color: #073763;
  padding: 1px;
  margin: 1px;
}
</style>