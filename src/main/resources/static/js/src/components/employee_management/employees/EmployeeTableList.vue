<template>
    <div class="card" ref="leaveRequests">
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
                <td data-label="Action">
                    <div class="action-controls d-flex justify-end">
                        <router-link
                                :to="`/designations-edit/${employee.id}`" tag="button"
                                class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                        </router-link>
                        <button
                                @click=""
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
        <b-loading :is-full-page="false" :active.sync="loading" :can-cancel="true"></b-loading>
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
                    loading: false
                }
            },
            methods: {
                getEmployees() {
                    let vm = this;
                    vm.loading = true;
                    axios.get("/api/employees", {
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