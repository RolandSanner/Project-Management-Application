<template>
  <div class='contact-list'>
      <h1>Contacts</h1>
      <contact-list/>
  </div>
</template>

<script>
import ContactList from '../components/ContactList.vue'
export default {
  name: 'ContactListView',
  components: { ContactList },

}
</script>

<style>
h1 {
  margin: 50px;
  text-decoration: underline;
}
</style>