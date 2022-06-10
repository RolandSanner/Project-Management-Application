<template>
  <div id=contact-info-case>
      <h1>Contact Info</h1>
      <div id=update-and-table>
      <contact-info-component v-bind:group-id="$route.params.id"/>
      <contact-projects v-bind:group-id="$route.params.id"/>
      </div>
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
#update-and-table{
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-items: flex-start;
}
</style>