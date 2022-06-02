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
        return http.post('/projects/', project)
    }
}