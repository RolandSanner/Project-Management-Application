import ContractorService from './../../services/ContractorService'

export default {
	name: "new-contractor-component",
	components: {},
	data() {
		return {
			contractor: {
				companyName: '',
				email: '',
				phone: '',
				street: '',
				city: '',
				state: '',
				zip: '',
				industry: ''
			}
		}
	},
	created() {},
	computed: {},
    methods: {
    saveDocument() {
      ContractorService.addContractor(this.Contractor)
                     .then(response => {
                       if(response.status === 201){
                         this.$router.push("/")
                       }
                     })
                     .catch(error => {
                       console.error(error)
                     })
    },
    cancel() {
      this.$router.push('/')
    }
   }
  };