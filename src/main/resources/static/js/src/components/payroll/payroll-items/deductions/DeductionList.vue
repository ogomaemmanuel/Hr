<template>
    <div>
        <div class="pb-2 flex justify-end">
            <button
                    @click="showCreateForm=true"
                    class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
                <span>
					 Add Deduction
				</span>
            </button>
        </div>
        <div class="columns">
            <div class="column is-12">
                <div class="card" ref="leaveRequests">
                    <div class="card-content">
                        <div class="content b-table is-relative">
                            <table class="table has-mobile-cards w-full is-hoverable">
                                <thead class="font-thin">
                                <tr>
                                    <th>
                                        Name
                                    </th>
                                    <!--                                    <th>-->
                                    <!--                                        Category-->
                                    <!--                                    </th>-->
                                    <th>
                                        Default/Unit Amount
                                    </th>
                                    <th>
                                        Action
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr v-for="deduction in deductions">
                                    <td data-label="Name">{{deduction.name}}</td>
                                    <td data-label="Description">{{deduction.amount}}</td>
                                    <td data-label="Action">
                                        <div class="action-controls d-flex justify-end">
                                            <button
                                                    @click="setUpdateId(deduction.id)" tag="button"
                                                    class="button is-white is-small">
                                												<span class="icon">
                                					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
                                					                       </span>
                                            </button>
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
                                    <td colspan="3">
                                        <Paginator
                                                @previousPage="goToPrevious"
                                                @nextPage="goToNext"
                                                @paginationChanged="onPaginationChanged"
                                                :paginationData="pageable">
                                        </Paginator>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <DeductionCreateForm
                @modalClosed="showCreateForm=false"
                @payrollDeductionCreated="onPayrollDeductionCreated"
                v-if="showCreateForm"></DeductionCreateForm>
    </div>
</template>
<script>
    import DeductionCreateForm from "./DeductionCreateForm";
    import common_mixin from "../../../../mixins/common_mixin";
    import Paginator from "../../../common/paginator/Paginator";
    import data_table_mixin from "../../../../mixins/data_table_mixin";

    export default {
        mixins: [data_table_mixin],
        components: {
            DeductionCreateForm,
            Paginator
        },
        data() {
            return {
                showCreateForm: false,
                deductions: [],
                updateId: false,
            }
        },
        created() {
            this.getDeductions();
        },
        methods: {
            setUpdateId(id) {
                this.updateId = id;
                this.showEditForm = true;
            },
            onPayrollDeductionCreated() {
                this.showCreateForm = false;
                this.getDeductions();
            },
            getDeductions() {
                axios.get("/api/payroll-deductions", {
                    params: {
                        page: this.page,
                        pageSize: this.pageSize,
                    }
                }).then(resp => {
                    this.deductions = resp.data.content;
                    this.pageable = resp.data;
                }, error => {

                })
            }
        }

    }
</script>