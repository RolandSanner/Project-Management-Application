<template>
  <div class='project-info'>
      <div id="A">
          <h3>Project ID</h3>
          <p>{{project.projectID}}</p>
          </div>
      <div id="B">
          <h3>Project Name</h3>
          <p>{{project.projectName}}</p> 
          </div>
      <div id="C">
          <h3>Description</h3> 
          <p>{{project.description}}</p>
          </div>
      <div id="D">
          <h3>Location</h3>
          <p>{{project.location}}</p>
          </div>
      <div id="E">
          <h3>Precinct</h3>
          <p>{{project.precinct}}</p>
          </div>
      <div id="F">
          <h3>Municipality</h3>
          <p>{{project.municipality}}</p>
          </div>
      <div id="G">
          <h3>Project Manager</h3>
          <p>{{project.projectManagerID}}</p>
          </div>
      <div id="H">
          <h3>Group</h3>
          <p>{{project.groupID}}</p>
          </div>
      <div id="I"><h3>Contractor List</h3>
          </div>
      <div id="J">
          <GmapMap
            :center="{lat:30.2666, lng:-97.7333}"
            :zoom="15"
            map-type-id="terrain"
            style="width: 100%; height: 100%"
        >
        </GmapMap>
      </div>
      <div id="K">
          <bar-chart id="bar"></bar-chart>
      </div>
    <router-link :to="{ name: 'UpdateProject', params: {id:project.projectID} }" class="routerLinks">
      Update Project
    </router-link>
  </div>
</template>

<script>
 import ProjectService from '../services/ProjectService'
 import BarChart from '../components/BarChart.vue'
export default {
 name:'project-info-component',
 components: {
     BarChart
 },
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
    display: flex;
    width: 60%;
    height: auto;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-between;
    border: solid 10px #073763;
    padding: 20px;
    gap: 5px;
    margin-left: 20px;
    background-color: #B9D9EB;
}

h3 {
    background-color: #6CB4EE;
    
}

p {
    background-color: #6CB4EE;
    
}

#A {
    display: flex;
    flex-basis: 45%;
    /* border: dotted 2px #073763; */
    flex-direction: column;
    justify-content: space-evenly;
    height: 50px;
    text-align: center;
    background-color: #6CB4EE;
}
#B {
    display: flex;
    flex-basis: 45%;
    flex-direction: column;
    justify-content: space-evenly;
    height: 50px;
    text-align: center;
    background-color: #6CB4EE;
}
#C {
    display: flex;
    flex-basis: 100%;
    flex-direction: column;
    justify-content: flex-start;
    height: 150px;
    align-items: stretch;
    background-color: #6CB4EE;
}
#C h3 {
    margin-left: 20px;
    margin-top: 20px;
}
#C p {
    margin-left: 20px;
    margin-top: 20px;
}
#D {
    display: flex;
    flex-basis: 30%;
    flex-direction: column;
    justify-content: space-evenly;
    height: 50px;
    text-align: center;
    background-color: #6CB4EE;
}
#E {
    display: flex;
    flex-basis: 30%;
    flex-direction: column;
    justify-content: space-evenly;
    height: 50px;
    text-align: center;
    background-color: #6CB4EE;
}
#F {
    display: flex;
    flex-basis: 30%;
    flex-direction: column;
    justify-content: space-evenly;
    height: 50px;
    text-align: center;
    background-color: #6CB4EE;
}
#G {
    display: flex;
    flex-basis: 30%;
    flex-direction: column;
    justify-content: space-evenly;
    height: 50px;
    text-align: center;
    background-color: #6CB4EE;
    cursor: pointer;
}
#H {
    display: flex;
    flex-basis: 30%;
    flex-direction: column;
    justify-content: space-evenly;
    height: 50px;
    text-align: center;
    background-color: #6CB4EE;
}
#I {
    display: flex;
    flex-basis: 30%;
    flex-direction: column;
    justify-content: space-evenly;
    height: 50px;
    text-align: center;
    background-color: #6CB4EE;
    cursor: pointer;
}
#J {
    display: flex;
    flex-basis: 45%;
    justify-content: center;
    height: 300px;
    align-items: center;
    background-color: #6CB4EE;
}
#K {
    display: flex;
    flex-basis: 45%;
    justify-content: center;
    align-items: center;
    

}

#bar {
    width: 100%;
    height: 300px;
}


</style>