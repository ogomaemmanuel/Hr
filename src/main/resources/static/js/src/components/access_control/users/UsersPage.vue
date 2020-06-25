<template>
    <div class="">
        <div  class="flex pb-2 justify-end">
            <router-link tag="button"
                         to="/users-create"
                         class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle"></i>
				</span>
                <span> Add Users</span>
            </router-link>
            <button @click="exportReport"
                    class="button is-rounded">
				<span class="icon">
					<i class="fa fa-download"></i>
				</span>
                <span> Export</span>
            </button>
        </div>
        <div class="columns">
            <div class="column is-12">
                <div class="card" ref="leaveRequests">
                    <div class="card-content">
                        <div class="content b-table is-relative" :class="{'is-loading':loading}">
                            <h4>Users</h4>
                            <table class="table has-mobile-cards w-full is-hoverable">
                                <thead class="font-thin">
                                <tr>
                                    <th>
                                        First Name
                                    </th>
                                    <th>
                                        Last Name
                                    </th>
                                    <th>
                                        Email
                                    </th>
                                    <th>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr v-for="user in users">
                                    <td data-label="Name">{{user.firstName}}</td>
                                    <td data-label="Date">{{user.lastName}}</td>
                                    <td data-label="Date">{{user.email}}</td>
                                    <td data-label="Action">
                                        <div class="action-controls d-flex justify-end">
                                            <router-link
                                                    :to="`/role-edit/${user.id}`" tag="button"
                                                    class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                                            </router-link>
                                            <button
                                                    class="button is-white is-small">
										           <span class="icon">
						                            <i class="fa fa-trash-o has-text-danger"></i>
					                               </span>
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <td colspan="8">
                                        <Paginator
                                                @previousPage="goToPrevious"
                                                @nextPage="goToNext"
                                                @paginationChanged="onPaginationChanged"
                                                :paginationData="pageable"
                                        ></Paginator>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <router-view></router-view>
    </div>
</template>
<script>
    import DataTableMixin from "../../../mixins/data_table_mixin"
    import Paginator from "../../common/paginator/Paginator";

    export default {
        mixins: [DataTableMixin],
        components: {
            Paginator
        },
        data() {
            return {
                isLoading: false,
                users: [],
                loading:false,
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
            this.fetchRecords();
        },
        methods: {
            fetchRecords() {
                return this.getUsers()
            },
            getUsers() {
                let vm = this;
                this.isLoading = true;
                axios.get("/api/users", {
                    params: {
                        pageSize: vm.pageSize,
                        page: vm.page

                    }
                }).then(resp => {
                    vm.isLoading = false
                    vm.users = resp.data.content;
                    this.pageable = resp.data;
                    vm.loading = false;
                }, error => {
                    vm.isLoading = false
                })
            },
            exportReport() {
                this.$downLoadFile({
                    requestMethod: "Get",
                    endPoint: "/api/users/reports"
                });
            }
        }

    }
</script>