<template>
  <div class='group-info'>
<h2>Group ID: {{group.groupID}}</h2>
<h2>Group Name: {{group.groupName}}</h2>
<h2>Program Manager: {{group.program_manager_id}}</h2>
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

</style>