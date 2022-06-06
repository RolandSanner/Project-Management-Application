<template>
  <div class='group-list'>
      <div v-for="group in groups" v-bind:key="group.id" class="group">
          <router-link v-bind:to="{name:'groupinfoview',params:{id:group.groupID}}">
          {{group.groupName}}
          </router-link>
      </div>
  </div>
</template>

<script>
import GroupService from '../services/GroupService'
export default {
    name:'group-list-component',
    data(){
        return{
            groups:[]
        }
    },
    created(){
        GroupService.getGroups().then(response=>{
            this.groups=response.data;
        })
    }

}
</script>

<style>
.group{
    margin-left: 50px;
    margin-bottom: 10px;
    font-size: 24px;
    border-bottom: 1px solid #f2f2f2;
    padding: 10px 20px;
}
</style>