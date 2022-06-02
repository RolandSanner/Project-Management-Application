<template>
  <div id="new-project-form">
    <project-component/>
  </div>
</template>

<script>
  import ProjectComponent from './../components/project-component/ProjectComponent.vue'

  export default {
  name: "new-project",
  components: {
    ProjectComponent, 
  }
  };
</script>
