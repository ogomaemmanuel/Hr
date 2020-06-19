<template>
    <div>
        <div class="pb-2 flex justify-end">
            <router-link
                    to="/employees-create"
                    tag="button"
                    class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
                <span>
					 Add Employee
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
        </div>
        <div class="columns">
            <div class="column is-12">
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
                                    <td data-label="Name">{{employee.name}}</td>
                                    <td data-label="Description">{{employee.employeeId}}</td>
                                    <td data-label="Description">{{employee.email}}</td>
                                    <td data-label="Description">{{employee.mobile}}</td>
                                    <td data-label="Description">{{employee.joinDate}}</td>
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
<!--                                        <Paginator-->
<!--                                                @previousPage="goToPrevious"-->
<!--                                                @nextPage="goToNext"-->
<!--                                                @paginationChanged="onPaginationChanged"-->
<!--                                                :paginationData="pageable"-->
<!--                                        ></Paginator>-->
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
    export default {
        data() {
            return {
                loading:false,
                employees: []
            }
        }
    }
</script>