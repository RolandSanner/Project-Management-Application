<template>
  <div id="new-contact-form">
    <NewContactComponentVue/>
  </div>
</template>

<script>

  import NewContactComponentVue from './../components/new-contact-component/NewContactComponent.vue'
  export default {
  name: "new-contact",
  components: {
    NewContactComponentVue
  },
  data() {
      return {

    }
  }
  }
</script>
