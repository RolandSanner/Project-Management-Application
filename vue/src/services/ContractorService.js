import axios from "axios";

const http=axios.create({
    baseURL: "http://localhost:8080"
});

export default{
    getContractors(){
        return http.get('/contractor');
    },

    addContractor(contractor){
        return http.get(`/contractor/${contractor}`);
    }
}