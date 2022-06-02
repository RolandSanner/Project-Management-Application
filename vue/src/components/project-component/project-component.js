import projectService from './../../services/ProjectService'


export default {
	name: "project-component",
	components: {
        
    },
	data() {
		return {
			project: {
				projectId: '',
				projectName: '',
				projectDescription: '',
				primaryFunding: '',
				secondaryFunding: '',
				precinct: '',
				contract: ''
			}
		}
	},
	created() {},
	computed: {},
	methods: {
		saveDocument() {
			projectService.create(this.project)
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
}


