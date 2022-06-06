<template>
<div id="main">
    <div id="projects-list"> 
    <h2>Projects</h2>
      <table id='project-table'>
<thead>
    <tr>
        <th>Project Name</th>
        <th>Project ID</th>
    </tr>
</thead>
<tbody>
    <tr v-for="project in projects" v-bind:key="project.id" class="project">
        <td>
            <router-link v-bind:to="{name:'projectinfoview',params:{id:project.projectID}}">
      {{project.projectName}}
      </router-link>
      </td>
        <td>{{project.projectID}}</td>
    </tr>
</tbody>
  </table>
  </div>
  <div id="contacts-list">
  <h2>Contacts</h2>
  <table id='contact-table'>
<thead>
    <tr>
        <th>Contact</th>
        <th>Role</th>
    </tr>
</thead>
<tbody>
    <tr v-for="contact in contacts" v-bind:key="contact.contactID" class="contact">
        <td>{{contact.firstName}} {{contact.lastName}}</td>
        <td>{{contact.contactRole}}</td>
    </tr>
</tbody>
  </table>
  </div>
  <div id="data">
  <div id="project-manager-data">
      <h2>Projects By Manager</h2>
  <table id="project-manager-table">
      <thead>
          <tr>
              <th>Project Manager</th>
              <th>Number of Projects</th>
          </tr>
      </thead>
      <tbody>
          <tr v-for="[key,value] in projectManagers" v-bind:key="key" class="manager-list">
              <td>{{key}}</td>
              <td>{{value}}</td>
          </tr>
      </tbody>
  </table>
  <div id="manager-chart-container">
  <canvas id="managerChart" chart.canvas.parentNode.style.height='128px'></canvas>
  </div>
  </div>
  <div id="precinct-data">
      <h2>Projects By Precinct</h2>
    <table id="precinct-table">
      <thead>
          <tr>
              <th>Precinct</th>
              <th>Number of Projects</th>
          </tr>
      </thead>
      <tbody>
          <tr v-for="[key,value] in precincts" v-bind:key="key" class="precinct-list">
              <td>{{key}}</td>
              <td>{{value}}</td>
          </tr>
      </tbody>
  </table>
  <div id="precinct-chart-container">
  <canvas id="precinctChart"></canvas>
  </div>
  </div>
  <div id="funding-data">
      <h2>Projects By Funding Type</h2>
  <table id="funding-table">
      <thead>
          <tr>
              <th>Funding Types</th>
              <th>Number of Projects</th>
          </tr>
      </thead>
      <tbody>
          <tr v-for="[key,value] in fundingTypes" v-bind:key="key" class="funding-list">
              <td>{{key}}</td>
              <td>{{value}}</td>
          </tr>
      </tbody>
  </table>
  <div id="funding-chart-container">
  <canvas id="fundingChart"></canvas>
  </div>
  </div>
  </div>
  </div>
</template>

<script>
import ProjectService from '../services/ProjectService'
import ContactService from '../services/ContactService'
import Chart from 'chart.js/auto'
export default {
name:'group-projects',
props:{
    'groupId':Number
},
data(){
    return{
        projects:[],
        projectManagers:[],
        precincts:[],
        fundingTypes:[],
        contacts:[],
        managerLabels:null,
        managerValues:null,
        precinctLabels:null,
        precinctValues:null,
        fundingLabels:null,
        fundingValues:null
        

    }
},
created(){
    ProjectService.getProjectsByGroupId(this.$route.params.id).then(response=>{
        this.projects=response.data;
            this.projectManagers=this.findUniqueManagers();
        this.precincts=this.findUniquePrecincts();
        this.fundingTypes=this.findUniqueFundingTypes();
        this.managerLabels=this.createManagerLabels();
        this.managerValues=this.createManagerValues();
        this.precinctLabels=this.createPrecinctLabels();
        this.precinctValues=this.createPrecinctValues();
        this.fundingLabels=this.createFundingLabels();
        this.fundingValues=this.createFundingValues();
        

        const ctx = document.getElementById('managerChart');
     const data={
  labels: this.managerLabels,
  datasets: [{
    label: 'My First Dataset',
    data: this.managerValues,
    backgroundColor: [
      'rgb(255, 99, 132)',
      'rgb(54, 162, 235)',
      'rgb(255, 205, 86)',
      'rgb(60, 179, 113)',
      'rgb(238, 130, 238)',
      'rgb(255, 165, 0)',
      'rgb(106, 90, 205)'
    ],
    hoverOffset: 4
  }]
};
     const myChart= new Chart(ctx,{
    type: 'pie',
    data: data,
     });
     myChart;
        
     
     const ctx1 = document.getElementById('precinctChart');
     const data1={
  labels: this.precinctLabels,
  datasets: [{
    label: 'My Second Dataset',
    data: this.precinctValues,
    backgroundColor: [
      'rgb(255, 99, 132)',
      'rgb(54, 162, 235)',
      'rgb(255, 205, 86)',
      'rgb(60, 179, 113)',
      'rgb(238, 130, 238)',
      'rgb(255, 165, 0)',
      'rgb(106, 90, 205)'
    ],
    hoverOffset: 4
  }]
};
     const precinctChart= new Chart(ctx1,{
    type: 'pie',
    data: data1,
     });
     precinctChart;

     const ctx2 = document.getElementById('fundingChart');
     const data2={
  labels: this.fundingLabels,
  datasets: [{
    label: 'My Third Dataset',
    data: this.fundingValues,
    backgroundColor: [
      'rgb(255, 99, 132)',
      'rgb(54, 162, 235)',
      'rgb(255, 205, 86)',
      'rgb(60, 179, 113)',
      'rgb(238, 130, 238)',
      'rgb(255, 165, 0)',
      'rgb(106, 90, 205)'
    ],
    hoverOffset: 4
  }]
};
     const myChart2= new Chart(ctx2,{
    type: 'pie',
    data: data2,
     });
     myChart2;
        });
     

    ContactService.listContactsByGroupId(this.$route.params.id).then(response=>{
        this.contacts=response.data;
    })
    
},
methods:{
    findUniqueManagers(){
        let managers= new Map;
    for(let i=0;i<this.projects.length;i++){
        if(!managers.has(this.projects[i].projectManagerName)){
            managers.set(this.projects[i].projectManagerName, 1)
        }else{
            managers.set(this.projects[i].projectManagerName,(managers.get(this.projects[i].projectManagerName)+1))
        }
    }
    return managers;
},
    findUniquePrecincts(){
        let precincts=new Map;
        for(let i=0;i<this.projects.length;i++){
        if(!precincts.has(this.projects[i].precinct)){
            precincts.set(this.projects[i].precinct,1)
        }else{
            precincts.set(this.projects[i].precinct,(precincts.get(this.projects[i].precinct)+1))
        }
    }
    return precincts;
    },
      findUniqueFundingTypes(){
        let funding=new Map;
        for(let i=0;i<this.projects.length;i++){
        if(!funding.has(this.projects[i].fundingSource)){
            funding.set(this.projects[i].fundingSource,1)
        }else{
            funding.set(this.projects[i].fundingSource,(funding.get(this.projects[i].fundingSource)+1))
        }
    }
    return funding;
    },
        createManagerLabels(){
      let labels=[];
      for(const label of this.projectManagers.keys()){
        labels.push(label)
      }
      return labels;
    },
    createManagerValues(){
      let values=[];
      for(const value of this.projectManagers.values()){
        values.push(value)
      }
      return values;
    },
            createPrecinctLabels(){
      let labels=[];
      for(const label of this.precincts.keys()){
        labels.push(label)
      }
      return labels;
    },
    createPrecinctValues(){
      let values=[];
      for(const value of this.precincts.values()){
        values.push(value)
      }
      return values;
    },
         createFundingLabels(){
      let labels=[];
      for(const label of this.fundingTypes.keys()){
        labels.push(label)
      }
      return labels;
    },
    createFundingValues(){
      let values=[];
      for(const value of this.fundingTypes.values()){
        values.push(value)
      }
      return values;
    }

},

}
</script>

<style>
#main{
    display: grid;
    grid-template-columns: 1fr,3fr,;
    grid-template-rows: 40vh,40vh;
    grid-template-areas: 
    "project-list data"
    "contact-list .";
    justify-items: center;
}
#data{
    grid-area: data;
    display: flex;
}
#projects-list{
    grid-area: project-list;
    margin: 10px;
    
}
#contacts-list{
    grid-area: contact-list;
    margin: 10px;
}
#project-manager-data{
    grid-area: project-manager-table;
    justify-content: center;
}

#precinct-data{
    grid-area: precinct-table;
    justify-items: center;
    
}
#funding-data{
    grid-area: funding-table;
    
}
table{
    border:2px solid black;
    width: 20vw;
}
td{
    border: 1px solid black;
}
thead,th{
     color: white;
     background-color: #073763;
}
th{
    padding: 8px;
}
#project-manager-data,#precinct-data,#funding-data{
    height: 25vh;
    width: 20vw;
    margin: 10px;
}
#manager-chart-container,#precinct-chart-container,#funding-chart-container{
    height: 20vh;
}
#data table{
    width: 20vw;
}
</style>