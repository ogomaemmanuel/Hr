<template>
	<div class="container">
		<div @click="exportReport" class="mt-2">
			<i class="fa fa-download"></i> Export
		</div>
		<b-table :loading="isLoading" :data="users" :columns="columns"></b-table>
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