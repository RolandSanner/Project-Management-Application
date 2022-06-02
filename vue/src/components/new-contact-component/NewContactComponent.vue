<script src="./new-contact-component.js"></script>
<style src="./new-contact-component.css" scoped></style>

<template>
    <div id="new-contact-component">
     <div id="new-contact">   
    <form class="new-contact">
      <h1 class="h3 mb-3 font-weight-normal">New Contact</h1>
      <input
      type="text"
      id="First Name"
      class="form-control"
      placeholder="First Name"
      required
      autofocus
      v-model="contact.firstName"
    />
    <input
      type="text"
      id="Last Name"
      class="form-control"
      placeholder="Last Name"
      required
      autofocus
      v-model="contact.lastName"
    />
    <input
      type="email"
      id="email"
      class="form-control"
      placeholder="Email Address"
      required
      autofocus
      v-model="contact.email"
    />
    <input
      type="tel"
      id="phoneNumber"
      class="form-control"
      placeholder="Phone Number"
      required
      autofocus
      v-model="contact.phone"
    />
    <input
      type="text"
      id="role"
      class="form-control"
      placeholder="User Role"
      required
      autofocus
      v-model="contact.role"
    />
    <input
      type="text"
      id="Company Name"
      class="form-control"
      placeholder="Company Name"
      required
      autofocus
      v-model="contact.companyName"
    />
    <input
      type="text"
      id="contact-street-address"
      class="form-control"
      placeholder="Street Address"
      required
      autofocus
      v-model="contact.street"
    />
    <input
      type="text"
      id="contact-street-address-2"
      class="form-control"
      placeholder="Street Address 2"
      autofocus
      v-model="contact.street2"

    />
    <input
      type="text"
      id="contact-city"
      class="form-control"
      placeholder="City"
      required
      autofocus
      v-model="contact.city"

    />
    <select
      id="contact-state"
      class="form-control form-control-dropper"
      name="state"
      required
      autofocus
      v-model="contact.state"
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
      id="contact-street-Zip"
      class="form-control"
      placeholder="Zip "
      required
      autofocus
      v-model="contact.zip"
    />
    <select
      id="contact-industry"
      class="form-control-dropper"
      name="contact-industry"
      required
      autofocus
      v-model="contact.industry">
      <option value ="" disabled selected>Contact Industry</option>
      <option value="design">Design</option>
      <option value="construction">Construction</option>
      <option value="general-engineering">General Engineering Consultant</option>
      <option value="right-of-way-consultant">Right-Of-Way Consultant</option>
      <option value="program-management-consultant">Program Management Consultant</option>
      <option value="other">Other</option>
    </select>

     <button type="submit" v-on:click="saveDocument()">Submit</button>
     <button type="cancel" class="cancel" v-on:click="cancel()">Cancel</button>
    </form>
    </div>
    </div>
</template>