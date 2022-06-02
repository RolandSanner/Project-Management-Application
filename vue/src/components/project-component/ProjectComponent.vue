<script src="./project-component.js"></script>
<style src="./project-component.css" scoped></style>

<template>
    <div id="project-component">
      
        <form class="new-project">
            <h1 class="h3 mb-3 font-weight-normal">New Project</h1>
            <input
            type="text"
            id="project-id"
            class="form-control"
            placeholder="Project ID"
            required
            autofocus
            v-model="project.ProjectId"
            />
            <input
            type="text"
            id="project-name"
            class="form-control"
            placeholder="Project Name"
            required
            autofocus
            v-model="project.projectName"
            />
            <textarea
            id="project-description"
            class="form-control"
            placeholder="Project Description"
            required
            autofocus
            rows="4"
            cols="23"
            v-model="project.projectDescription" 
            />
            <input
            type="text"
            id="primary-funding"
            class="form-control"
            placeholder="Primary Funding Source"
            required
            autofocus
            v-model="project.primaryFunding"
            />
            <input
            type="text"
            id="secondary-funding"
            class="form-control"
            placeholder="Secondary Funding Sources"
            autofocus
            v-model="project.secondaryFunding"
            />
            <input
            type="text"
            id="precinct"
            class="form-control"
            placeholder="Precinct"
            required
            autofocus
            v-model="project.precinct"
            />
            <input
            type="text"
            id="contract"
            class="form-control"
            placeholder="Contract"
            required
            autofocus
            v-model="project.contract"
            />
            <button type="submit" v-on:click="saveDocument()">Submit</button>
            <button type="cancel" class="cancel" v-on:click="cancel()">Cancel</button>
        </form>
    </div>
</template>

