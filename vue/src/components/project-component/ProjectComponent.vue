<script src="./project-component.js"></script>
<style src="./project-component.css" scoped></style>

<template>
    
    <div id="project-component-main">
    <div id="project-component">
        <form class="new-project">
            <h1 class="h3 mb-3 font-weight-normal">New Project</h1>
            <h4>* Required</h4>
            <input
            type="text"
            id="project-id"
            class="form-control"
            placeholder="* Project Id"
            required
            autofocus
            v-model="project.projectID"
            />
            <input
            type="text"
            id="project-name"
            class="form-control"
            placeholder="* Project Name"
            required
            autofocus
            v-model="project.projectName"
            />
            <textarea
            id="project-description"
            class="form-control"
            placeholder="* Project Description"
            autofocus
            required
            rows="4"
            cols="23"
            v-model="project.description" 
            />
            <input
            type="text"
            id="primary-funding"
            class="form-control"
            placeholder="Primary Funding Source"
            autofocus
            v-model="project.fundingSource"
            />
            <!-- <input
                type="text"
                id="precinct"
                class="form-control"
                placeholder="* Precinct"
                required
                autofocus
                v-model="project.precinct"
            /> -->
            
          <select
            id="project-precinct"
            class="form-control form-control-dropper"
            name="state"
            autofocus
            v-model="project.Precinct"
          >
            <option value="" disabled selected>Precinct</option>
            <option value=1>1</option>
            <option value=2>2</option>
            <option value=3>3</option>
            <option value=4>4</option>
            <option value=5>5</option>
            <option value=6>6</option>
            <option value=7>7</option>
            <option value=8>8</option>
            <option value=9>9</option>
            <option value=10>10</option>
            <option value=11>11</option>
            <option value=12>12</option>
            <option value=13>13</option>
            <option value=14>14</option>
            <option value=15>15</option>
            <option value=16>16</option>
            <option value=17>17</option>
            <option value=18>18</option>
            <option value=19>19</option>
            <option value=20>20</option>
           
          </select>
            <input
                type="text"
                id="municipality"
                class="form-control"
                placeholder="* Municipality"
                autofocus
                required
                v-model="project.municipality"
            />
            <input
                type="text"
                id="location"
                class="form-control"
                placeholder="* Location"
                required
                autofocus
                v-model="project.location"
            />
            <input
                type="text"
                id="contract"
                class="form-control"
                placeholder="Contract Name"
                autofocus
                v-model="project.contractName"
            />
            <input
                type="text"
                id="projectManagerId"
                class="form-control"
                placeholder="Project Manager Id"
                autofocus
                v-model="project.projectManagerID"
            />


            <button type="submit" v-on:click="saveDocument()">Submit</button>
            <button type="cancel" class="cancel" v-on:click="cancel()">Cancel</button>
        </form>
    </div>
    </div>
</template>

