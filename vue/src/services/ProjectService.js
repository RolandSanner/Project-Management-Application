import axios from "axios";

const http=axios.create({
    baseURL: "http://localhost:8080"
});

export default{
    listProjects(){
        return http.get('/projects')
    },

    getProjectById(id){
        return http.get(`/project/${id}`)
    },

    create(project) {
        return http.post('/project/new', project)
    },

    getProjectsByGroupId(id){
        return http.get(`/groups/${id}/projects`)
    },
    updateProject(project){
        return http.put('/project/update', project)
    },
    getProjectsByContractorId(id){
        return http.get(`/contractor/${id}/projects`)
    }
}