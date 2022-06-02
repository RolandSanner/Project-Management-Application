<script src="./new-contractor-component.js"></script>
<style src="./new-contractor-component.css" scoped></style>

<template>
    <div id="new-contractor-component">
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
        pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
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