<template>
  <div id="new-contact-component">
    <div id="new-contact">
      <form class="new-contact" @submit.prevent>
        <h1 class="h3 mb-3 font-weight-normal">Update Contact</h1>


        <div class="name">
          <input
              type="text"
              id="First Name"
              class="form-control"
              required
              autofocus
              v-model="contact.firstName"
          />
          <input
              type="text"
              id="Last Name"
              class="form-control"
              required
              autofocus
              v-model="contact.lastName"
          />
        </div>
        <div class="demos">
          <input
              type="email"
              id="email"
              class="form-control"
              required
              autofocus
              v-model="contact.email"
          />
          <input
              type="tel"
              id="phoneNumber"
              class="form-control"
              required
              autofocus
              v-model="contact.phoneNumber"
          />
        </div>
        <div class="about">
          <input
              type="text"
              id="role"
              class="form-control"
              required
              autofocus
              v-model="contact.contactRole"
          />
          <input
              type="text"
              id="Company Name"
              class="form-control"
              autofocus
              v-model="contact.companyName"
          />
        </div>
        <div class="address">
          <input
              type="text"
              id="contact-street-address"
              class="form-control"
              autofocus
              v-model="contact.contactStreet"
          />
          <input
              type="text"
              id="contact-city"
              class="form-control"
              autofocus
              v-model="contact.contactCity"
          />
        </div>
        <div class="address2">
          <select
              id="contact-state"
              class="form-control form-control-dropper"
              name="state"
              autofocus
              v-model="contact.contactState"
          >
            <option value="AL">Alabama</option>
            <option value="AK">Alaska</option>
            <option value="AZ">Arizona</option>
            <option value="AR">Arkansas</option>
            <option value="CA">California</option>
            <option value="CO">Colorado</option>
            <option value="CT">Connecticut</option>
            <option value="DE">Delaware</option>
            <option value="DC">District Of Columbia</option>
            <option value="FL">Florida</option>
            <option value="GA">Georgia</option>
            <option value="HI">Hawaii</option>
            <option value="ID">Idaho</option>
            <option value="IL">Illinois</option>
            <option value="IN">Indiana</option>
            <option value="IA">Iowa</option>
            <option value="KS">Kansas</option>
            <option value="KY">Kentucky</option>
            <option value="LA">Louisiana</option>
            <option value="ME">Maine</option>
            <option value="MD">Maryland</option>
            <option value="MA">Massachusetts</option>
            <option value="MI">Michigan</option>
            <option value="MN">Minnesota</option>
            <option value="MS">Mississippi</option>
            <option value="MO">Missouri</option>
            <option value="MT">Montana</option>
            <option value="NE">Nebraska</option>
            <option value="NV">Nevada</option>
            <option value="NH">New Hampshire</option>
            <option value="NJ">New Jersey</option>
            <option value="NM">New Mexico</option>
            <option value="NY">New York</option>
            <option value="NC">North Carolina</option>
            <option value="ND">North Dakota</option>
            <option value="OH">Ohio</option>
            <option value="OK">Oklahoma</option>
            <option value="OR">Oregon</option>
            <option value="PA">Pennsylvania</option>
            <option value="RI">Rhode Island</option>
            <option value="SC">South Carolina</option>
            <option value="SD">South Dakota</option>
            <option value="TN">Tennessee</option>
            <option value="TX">Texas</option>
            <option value="UT">Utah</option>
            <option value="VT">Vermont</option>
            <option value="VA">Virginia</option>
            <option value="WA">Washington</option>
            <option value="WV">West Virginia</option>
            <option value="WI">Wisconsin</option>
            <option value="WY">Wyoming</option>
          </select>

          <input
              type="text"
              id="contact-street-Zip"
              class="form-control"
              autofocus
              v-model="contact.contactZip"
          />
        </div>
        <select
            id="contact-industry"
            class="form-control-dropper"
            name="contact-industry"
            autofocus
            v-model="contact.contactIndustry"
        >
          <option value="" disabled selected>Contact Industry</option>
          <option value="design">Design</option>
          <option value="construction">Construction</option>
          <option value="general-engineering"
          >General Engineering Consultant</option
          >
          <option value="right-of-way-consultant"
          >Right-Of-Way Consultant</option
          >
          <option value="program-management-consultant"
          >Program Management Consultant</option
          >
          <option value="other">Other</option>
        </select>

        <button type="submit" v-on:click="updateContact()">Submit</button>
        <button type="reset" class="cancel" v-on:click="cancel()">
          Cancel
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import ContactService from "@/services/ContactService";

export default {
  name: "UpdateContact",
  data() {
    return {
      contact: {
        contactID: '',
        firstName: '',
        lastName: '',
        email: '',
        phoneNumber: '',
        contactRole: '',
        companyName: '',
        contactStreet: '',
        contactCity: '',
        contactState: '',
        contactZip: '',
        contactIndustry: ''
      }
    }
  },
  created() {
    ContactService.getContactByID(this.$route.params.id).then(response=>{
      this.contact=response.data;
    })
  },
  computed: {},
  methods: {
    updateContact() {
      ContactService.updateContact(this.contact)
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

#new-contact-component{
  display: flex;
  justify-content: center;
}

#new-contact {
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

#new-contact h1 {
  display: flex;
  justify-content: center;
  padding: 25px;
  font-size: 2.3rem;
  text-decoration: none;

}

.name, .demos, .about, .address, .address2{
  display: flex;
  flex-wrap: wrap;
  column-gap: 10px;
}

.form-control {
  display: flex;
  justify-content: center;
  border-radius: 3px;
  box-shadow: 0 0 4px #073763;
  background-color: white;
  font-size: 1.5rem;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 15px;
  cursor: text;
  padding-left: 5px;
  width: 300px;
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
  border-radius: 5px;
  cursor: pointer;
}

.cancel {
  background-color: gray;
}

#new-contact select{
  border-radius: 5px;
  box-shadow: 0 0 4px #073763;
}

h4 {
  display: flex;
  justify-content: flex-end;
  margin-bottom: 5px;
  color: #31313183;
}
</style>