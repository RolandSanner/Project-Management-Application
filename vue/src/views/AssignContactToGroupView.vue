<template>
  <div class="group-option-list">
<assign-contact-to-group-form/>
<assign-contact-to-project-form/>
  </div>
</template>

<script>
import AssignContactToGroupForm from '../components/AssignContactToGroupForm.vue'
import AssignContactToProjectForm from '../components/AssignContactToProjectForm.vue'
export default {
name:'AssignContactView',
components:{
    AssignContactToGroupForm,
    AssignContactToProjectForm
}
}
</script>

<style>

</style>