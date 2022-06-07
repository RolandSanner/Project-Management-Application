<template>
  <div>
      <h1>Contact Info</h1>
      <contact-info-component v-bind:group-id="$route.params.id"/>
      <contact-projects v-bind:group-id="$route.params.id"/>
  </div>
</template>

<script>
import ContactInfoComponent from '../components/ContactInfo.vue'
import ContactProjects from '../components/ContactProjects.vue'
export default {
name:'ContactInfoView',

components:{
    ContactInfoComponent,
    ContactProjects
    
}
}
</script>

<style>

</style>