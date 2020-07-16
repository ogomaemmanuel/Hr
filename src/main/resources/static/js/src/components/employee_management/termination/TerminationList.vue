<template>
    <div>
        <div class="pb-2 flex justify-end">
            <button
                    @click="showResignationCreateForm=true"
                    to="/departments-create"
                    tag="button"
                    class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
                <span>
					 Add Termination
				</span>
            </button>
            <a
                    href="/api/overtime-requests/excel-reports"
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
                            <h4>Resignations</h4>
                            <table class="table has-mobile-cards w-full is-hoverable">
                                <thead class="font-thin">
                                <tr>
                                    <th>
                                        Terminated Employee
                                    </th>
                                    <th>
                                        Department
                                    </th>
                                    <th>
                                        Termination Type
                                    </th>
                                    <th>
                                        Termination Date
                                    </th>
                                    <th>
                                        Reason
                                    </th>

                                    <th>
                                        Notice Date
                                    </th>
                                    <th>
                                        Action
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr v-for="resignation in terminations">
                                    <td data-label="Name">{{terminations.employeeFullName}}</td>
                                    <td data-label="Description">{{terminations.employeeDepartment}}</td>
                                    <td data-label="Description">{{terminations.reason}}</td>
                                    <td data-label="Description">{{terminations.noticeDate|dateFormat}}</td>
                                    <td data-label="Description">{{terminations.resignationDate|dateFormat}}</td>
                                    <td data-label="Action">
                                        <div class="action-controls d-flex justify-end">
                                            <router-link
                                                    :to="`/employee-resignation-edit/${resignation.id}`" tag="button"
                                                    class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                                            </router-link>
                                            <button
                                                    @click="confirmRemove(resignation)"
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
                            <!--                        <b-loading :is-full-page="false" :active.sync="loading" :can-cancel="true"></b-loading>-->
                        </div>
                    </div>
                </div>
            </div>
            <router-view
                    @designationUpdated="getResignations()"
                    @overtimeRequestUpdated="getResignations()">
            </router-view>
        </div>
        <TerminationCreateForm></TerminationCreateForm>
    </div>
</template>
<script>
    import TerminationCreateForm from "./TerminationCreateForm";
    import data_table_mixin from "../../../mixins/data_table_mixin";
    export default {
        mixins: [data_table_mixin],
        components: {
            TerminationCreateForm
        },
        data() {
            return {
                terminations: []
            }
        }
    }
</script>