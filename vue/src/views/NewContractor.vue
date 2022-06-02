<template>
  <div id="new-contractor-form">
    <NewContractorComponentVue/>
  </div>
</template>

<script>

  import NewContractorComponentVue from '../components/new-contractor-component/NewContractorComponent.vue'
  export default {
  name: "new-contractor",
  components: {
    NewContractorComponentVue
  },
  data() {
      return {

    }
  }
  }
</script>
