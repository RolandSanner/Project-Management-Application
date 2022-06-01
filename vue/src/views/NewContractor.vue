<template>
  <div id="new-contractor-form">
    <form class="new-contractor">
      <h1 class="h3 mb-3 font-weight-normal">New contractor</h1>
    <input
      type="text"
      id="Company Name"
      class="form-control"
      placeholder="Company Name"
      required
      autofocus
      v-model="contractor.companyName"
    />
    <input
      type="email"
      id="email"
      class="form-control"
      placeholder="Email Address"
      required
      autofocus
      v-model="contractor.email"
    />
    <input
        type="tel"
        id="phoneNumber"
        class="form-control"
        placeholder="Phone Number"
        required
        autofocus
        v-model="contractor.phone"
        pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}"
    />
    <input
      type="text"
      id="contractor-street-address"
      class="form-control"
      placeholder="Street Address"
      required
      autofocus
      v-model="contractor.street"
    />
    <input
      type="text"
      id="contractor-street-address-2"
      class="form-control"
      placeholder="Street Address 2"
      autofocus
      v-model="contractor.street2"

    />
    <input
      type="text"
      id="contractor-city"
      class="form-control"
      placeholder="City"
      required
      autofocus
      v-model="contractor.city"

    />
    <select
      id="contractor-state"
      class="form-control"
      name="state"
      required
      autofocus
      v-model="contractor.state"
      >
      <option value ="" disabled selected>State</option>
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
      id="contractor-street-Zip"
      class="form-control"
      placeholder="Zip "
      required
      autofocus
      v-model="contractor.zip"
    />
    <select
      id="contractor-industry"
      class="form-control-dropper"
      name="contractor-industry"
      required
      autofocus
      v-model="contractor.industry">
      <option value ="" disabled selected>Contractor Industry</option>
      <option value="design">Design</option>
      <option value="construction">Construction</option>
      <option value="general-engineering">General Engineering Consultant</option>
      <option value="right-of-way-consultant">Right-Of-Way Consultant</option>
      <option value="program-management-consultant">Program Management Consultant</option>
    </select>

     <button type="submit" v-on:click="saveDocument()">Submit</button>
     <button type="cancel" class="cancel" v-on:click="cancel()">Cancel</button>
    </form>
  </div>
</template>

<script>
  import ContractorService from './../services/ContractorService'

  export default {
  name: "new-contractor",
  components: {
    
  },
  data() {
      return {
        contractor: {
          companyName: '',
          email: '',
          phone: '',
          street: '',
          city: '',
          state: '',
          zip: '',
          industry: ''
        }
      }
    },
   methods: {
    saveDocument() {
      ContractorService.addContractor(this.Contractor)
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

#new-contractor-form{
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

#new-contractor-form  h1 {
  display: flex;
  justify-content: center;
  padding: 25px 25px 25px 25px;
  font-size: 2.3rem;
}

#new-contractor-form label {
  display: flex;
  justify-content: center;
  padding: 5px;
}

.form-control {
  display: flex;
  justify-content: center;
  border-radius: 5px;
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

.form-control-dropper {
  display: flex;
  justify-content: center;
  border-radius: 5px;
  box-shadow: 0px 0px 4px #043464;
  background-color: white;
  border-radius: 3px;
  font-size: 1.3rem;
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