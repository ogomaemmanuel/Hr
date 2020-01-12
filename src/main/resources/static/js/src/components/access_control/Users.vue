<template>
	<div class="container" >
		<div @click="exportReport" class="flex pb-2 justify-end">
			<button class="button is-rounded is-small">
				<span class="icon">
					<i class="fa fa-download"></i>
				</span>
				<span> Export</span>
			</button>
		</div>
		<b-table class="is-size-7" :loading="isLoading" :data="users" :columns="columns"></b-table>
	</div>
</template>
<script>
    export default {
        data() {
            return {
                isLoading: false,
                users: [],
                columns: [
                    {
                        field: 'id',
                        label: 'ID',
                        width: '40',
                        numeric: true
                    },
                    {
                        field: 'firstName',
                        label: 'First Name',
                    },
                    {
                        field: 'lastName',
                        label: 'Last Name',
                    },
					{
                        field: 'email',
                        label: 'Email',
                    },
                ]
            }
        },
        created() {
            this.getUsers();
        },
        methods: {
            getUsers() {
                let vm = this;
                this.isLoading = true;
                axios.get("/api/users").then(resp => {
                    vm.isLoading = false
                    vm.users = resp.data;
                }, error => {
                    vm.isLoading = false
                })
            },
            exportReport() {
                this.$downLoadFile({
                    requestMethod:"Get",
                    endPoint:"/api/users/reports"
				});
            }
        }

    }
</script>