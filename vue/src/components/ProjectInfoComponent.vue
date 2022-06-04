<template>
  <div class='project-info'>
      <div id="A">Project ID: {{project.projectID}}</div>
      <div id="B">Project Name: {{project.projectName}}</div>
      <div id="C">Description: {{project.description}}</div>
      <div id="D">Location: {{project.location}}</div>
      <div id="E">Precinct: {{project.precinct}}</div>
      <div id="F">Municipality: {{project.municipality}}</div>
      <div id="G">Project Manager: {{project.projectManagerID}}</div>
      <div id="H">Group: {{project.groupID}}</div>
      <div id="I">Contractor List: </div>
      <div id="J">Map holder</div>
  </div>
</template>

<script>
 import ProjectService from '../services/ProjectService'
export default {
 name:'project-info-component',
 props:{
     'projectId': NaN
 },
 data(){
     return{
     project:{
         projectId:0,
         project_name:'',
        project_description:'',
        project_location:'',
        precinct:'',
        municipality:'',
        project_manager_id:0,
        group_id:0
    }
     }
 },
 created(){
     ProjectService.getProjectById(this.$route.params.id).then(response=>{
         this.project=response.data;
     })
 }
}
</script>

<style>

.project-info {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-template-areas:
                "A A B B"
                "C D E F"
                "H G J J"
                "I I J J";
    row-gap: 100px;
    column-gap: 50px;
    align-items: center;
    border-style:solid;

}

#A {
    grid-area: A;
    border-style: ridge;

}
#B {
    grid-area: B;
    border-style: ridge;
    margin: -40px;
    margin-right: 50px;
}
#C {
    grid-area: C;
}
#D {
    grid-area: D;
}
#E {
    grid-area: E;
}
#F {
    grid-area: F;
}
#G {
    grid-area: G;
}
#H {
    grid-area: H;
}
#I {
    grid-area: I;
}
#J {
    grid-area: J;
    text-align: center;
}


</style>