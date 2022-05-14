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
					 Add Addition
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
                                <tr v-for="addition in additions">
                                    <td data-label="Name">{{addition.name}}</td>
                                    <td data-label="Description">{{addition.amount}}</td>
                                    <td data-label="Action">
                                        <div class="action-controls d-flex justify-end">
                                            <button
                                                    @click="setUpdateId(addition.id)" tag="button"
                                                    class="button is-white is-small">
                                												<span class="icon">
                                					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
                                					                       </span>
                                            </button>
                                            <button
                                                    @click="confirmRemoveAddition(addition)"
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
                                                :paginationData="pageable"
                                        ></Paginator>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                            <!--                            <b-loading :is-full-page="false" :active.sync="loading" :can-cancel="true"></b-loading>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <AdditionCreateForm
                @modalClosed="showCreateForm=false"
                @payrollAdditionCreated="onPayrollAdditionCreated()"
                v-if="showCreateForm"></AdditionCreateForm>
        <AdditionEditForm
                @modalClosed="showEditForm=false"
                @payrollAdditionUpdated="onPayrollAdditionUpdated"
                :id="updateId"
                v-if="showEditForm">
        </AdditionEditForm>
    </div>
</template>
<script>
    import AdditionCreateForm from "./AdditionCreateForm";
    import data_table_mixin from "../../../../mixins/data_table_mixin";
    import Paginator from "../../../common/paginator/Paginator";
    import AdditionEditForm from "./AdditionEditForm";

    export default {
        mixins: [data_table_mixin],
        components: {
            AdditionCreateForm,
            Paginator,
            AdditionEditForm
        },
        data() {
            return {
                showCreateForm: false,
                showEditForm: false,
                updateId: false,
                additions: []
            }
        },
        created() {
            this.getAdditions();
        },
        methods: {
            fetchRecords() {
                this.getAdditions();
            },
            onPayrollAdditionUpdated() {
                this.showEditForm = false;
                this.getAdditions();
            },
            onPayrollAdditionCreated() {
                this.showCreateForm = false;
                this.getAdditions();
            },
            setUpdateId(id) {
                this.updateId = id;
                this.showEditForm = true;
            },
            confirmRemoveAddition(addition) {
                this.$buefy.dialog.confirm({
                    title: 'Remove Payroll Addition',
                    message: `Are you sure you want remove this record`,
                    onConfirm: () => this.removeAddition(addition)
                })
            },
            removeAddition(addition) {
                axios.delete(`/api/payroll-additions/${addition.id}`,
                ).then(resp => {
                    this.getAdditions();
                })
            },
            getAdditions() {
                axios.get("/api/payroll-additions", {
                    params: {
                        page: this.page,
                        pageSize: this.pageSize,
                    }
                }).then(resp => {
                    this.additions = resp.data.content;
                    this.pageable = resp.data;
                })
            }
        }
    }
</script>