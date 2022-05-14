<template>
    <div class="columns">
        <div class="column is-12">
            <div class="card" ref="leaveRequests">
                <div class="card-content">
                    <div class="content b-table is-relative">
                        <h4>Overtime Requests</h4>
                        <table class="table has-mobile-cards w-full is-hoverable">
                            <thead class="font-thin">
                            <tr>
                                <th>
                                    Name
                                </th>
                                <th>
                                    OT Date
                                </th>
                                <th>
                                    OT Hours
                                </th>
                                <th>
                                    Description
                                </th>
                                <th>
                                    Status
                                </th>
                                <th>
                                    Approved By
                                </th>
                                <th>
                                    Action
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr v-for="overtimeRequest in overtimeRequests">
                                <td data-label="Name">{{overtimeRequest.employeeFullName}}</td>
                                <td data-label="Description">{{overtimeRequest.overtimeDate}}</td>
                                <td data-label="Description">{{overtimeRequest.overtimeHours}}</td>
                                <td data-label="Description">{{overtimeRequest.description}}</td>
                                <td data-label="Description"></td>
                                <td data-label="Description"></td>
                                <td data-label="Action">
                                    <div class="action-controls d-flex justify-end">
                                        <router-link
                                                :to="`/overtime-requests-edit/${overtimeRequest.id}`" tag="button"
                                                class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                                        </router-link>
                                        <button
                                                @click="confirmRemove(overtimeRequest)"
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
                @overtimeRequestUpdated="getOvertimeRequests()">
        </router-view>
    </div>
</template>
<script>
    import Paginator from "../../common/paginator/Paginator";
    import data_table_mixin from "../../../mixins/data_table_mixin";

    export default {
        mixins: [data_table_mixin],
        components: {
            Paginator
        },
        data() {
            return {
                loading: false,
                pageable: false,
                overtimeRequests: []
            }
        },
        created() {
            this.getOvertimeRequests();
        },
        methods: {
            fetchRecords() {
                this.getOvertimeRequests();
            },
            getOvertimeRequests() {
                this.loading = true;
                axios.get("/api/overtime-requests", {
                    params: {
                        page: this.page,
                        pageSize: this.pageSize,
                    }
                }).then(resp => {
                    this.loading = false;
                    this.overtimeRequests = resp.data.content;
                    this.pageable = resp.data;
                }, error => {
                    this.loading = false;
                })
            },

            confirmRemove(request) {
                this.$buefy.dialog.confirm({
                    title: 'Remove Overtime Requests',
                    message: `Are you sure you want remove this record`,
                    onConfirm: () => this.removeOvertimeRequest(request)
                })
            },
            removeOvertimeRequest(request) {
                axios.delete(`/api/overtime-requests/${request.id}`,
                ).then(resp => {
                    this.getOvertimeRequests();
                })
            }
        }
    }

</script>
<style lang="scss" scoped>

</style>