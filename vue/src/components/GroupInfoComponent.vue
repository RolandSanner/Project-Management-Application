<template>
  <div class='group-info'>
      <table id='info-header'>
          <thead>
              <tr>
                  <th>Group ID: {{group.groupID}}</th>
                  <th>Group Name: {{group.groupName}}</th>
                  <th>Program Manager: {{group.program_manager_name}}</th>
              </tr>
          </thead>
      </table>
  </div>
</template>

<script>
import GroupService from '../services/GroupService'
export default {
name:'group-details-component',
props:{
    'groupId':Number
},
data(){
    return{
        group:{
            groupID:0,
            groupName:'',
            program_manager_id:0
        }
    }
},
created(){
    GroupService.getGroupsById(this.$route.params.id).then(response=>{
        this.group=response.data;
    })
}
}
</script>

<style>
#info-header{
    width: 100vw;
    padding: 10px;
    border: 0px;
}
</style>