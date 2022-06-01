import axios from "axios";

const http=axios.create({
    baseURL: "http://localhost:3000"
});

export default{
    listProjects(){
        return http.get('/projects')
    },

    getProjectById(id){
        return http.get(`/projects/${id}`)
    }
}