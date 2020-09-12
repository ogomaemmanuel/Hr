<template>
    <div class="h-full">
        <div class="pb-2 flex justify-end">
            <portal to="page-controls">
                <router-link
                        to="/employees-create"
                        tag="button"
                        class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
                    <span>
					 Add Salary
				</span>
                </router-link>
                <a
                        href="/api/holidays/excel-report"
                        class="button is-rounded">
				<span class="icon">
					<i class="fa fa-download mr-1"></i>
				</span>
                    <span>
					 Export
				</span>
                </a>
            </portal>
        </div>
        <div class="columns h-full">
            <div class="column is-12">


                <div class="card">
                    <div class="card-content">
                        <div class="content b-table is-relative">
                            <h4>Employees</h4>
                            <table class="table has-mobile-cards w-full is-hoverable">
                                <thead class="font-thin">
                                <tr>
                                    <th>
                                        Name
                                    </th>
                                    <th>
                                        Employee Id
                                    </th>
                                    <th>
                                        Email
                                    </th>
                                    <th>
                                        Mobile
                                    </th>
                                    <th>
                                        Join Date
                                    </th>
                                    <th>
                                        Designation
                                    </th>
                                    <th>
                                        Salary
                                    </th>
                                    <th>

                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr v-for="employee in employees">
                                    <td data-label="Name">{{employee.fullName}}</td>
                                    <td data-label="Description">{{employee.employeeId}}</td>
                                    <td data-label="Description">{{employee.email}}</td>
                                    <td data-label="Description">{{employee.phone}}</td>
                                    <td data-label="Description">{{employee.joiningDate|formatDate}}</td>
                                    <td data-label="Description">{{employee.designation}}</td>
                                    <td data-label="Description">{{employee.salaryAmount}}</td>
                                    <td data-label="Action">
                                        <div class="action-controls d-flex justify-end">
                                            <router-link
                                                    tag="button"
                                                    :to="`/salary-view/${employee.id}`"
                                                    class="button is-white is-small">
										           <span class="icon">
						                            <i class="fa fa-money has-text-link"></i>
					                               </span>
                                            </router-link>
                                            <router-link
                                                    tag="button"
                                                    :to="`/salary/${employee.id}`"
                                                    class="button is-white is-small">
										           <span class="icon">
						                            <i class="fa fa-eye has-text-success"></i>
					                               </span>
                                            </router-link>
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
                            <b-loading :is-full-page="false" :active.sync="loading" :can-cancel="true"></b-loading>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</template>
<script>
    import Paginator from "../../common/paginator/Paginator";


    export default {
        components: {
            Paginator
        },
        data() {
            return {
                employees: [],
                pageable: false,
                pageSize: 10,
                page: 0,
                loading: false,
                totalPages: 0,
            }
        },
        methods: {
            getEmployees() {
                let vm = this;
                vm.loading = true;
                axios.get("/api/employee-salary", {
                    params: {
                        pageSize: vm.pageSize,
                        page: vm.page
                    }
                }).then(resp => {
                    vm.loading = false;
                    this.employees = resp.data.content;
                    this.pageable = resp.data;
                }, error => {
                    vm.loading = false;
                })
            },
            goToPrevious() {
                this.page--;
                this.getEmployees();
            },
            goToNext() {
                this.page++;
                this.getEmployees();
            },
            onPaginationChanged(pageSize) {
                this.page = 0;
                this.pageSize = pageSize;
                this.getEmployees();
            }
        },
        created() {
            this.getEmployees();
        },
        filters: {
            formatDate(val) {
                if (val) {
                    return moment(val).format("DD-MMM-YYYY");
                }
                return null;
            }
        }
    }
</script>
<style lang="scss" scoped></style>