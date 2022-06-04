import axios from "axios";

const http=axios.create({
    baseURL: "http://localhost:8080"
});

export default{
    getGroups(){
        return http.get('/groups');
    },

    getGroupsById(id){
        return http.get(`/groups/${id}`);
    },

    addNewGroup(group){
        return http.post('/groups/new',group);
    }
}