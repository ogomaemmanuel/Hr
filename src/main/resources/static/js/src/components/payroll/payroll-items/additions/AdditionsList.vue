<template>
    <div>
        <div class="pb-2 flex justify-end">
            <button
                    to="/designations-create"
                    @click="showCreateForm=true"
                    tag="button"
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
                                    <th>
                                        Category
                                    </th>
                                    <th>
                                        Default/Unit Amount
                                    </th>
                                    <th>
                                        Action
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <!--                                <tr v-for="designation in designations">-->
                                <!--                                    <td data-label="Name">{{designation.name}}</td>-->
                                <!--                                    <td data-label="Description">{{designation.department.name}}</td>-->
                                <!--                                    <td data-label="Action">-->
                                <!--                                        <div class="action-controls d-flex justify-end">-->
                                <!--                                            <router-link-->
                                <!--                                                    :to="`/designations-edit/${designation.id}`" tag="button"-->
                                <!--                                                    class="button is-white is-small">-->
                                <!--												<span class="icon">-->
                                <!--					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>-->
                                <!--					                       </span>-->
                                <!--                                            </router-link>-->
                                <!--                                            <button-->
                                <!--                                                    @click=""-->
                                <!--                                                    class="button is-white is-small">-->
                                <!--										           <span class="icon">-->
                                <!--						                            <i class="fa fa-trash-o has-text-danger"></i>-->
                                <!--					                               </span>-->
                                <!--                                            </button>-->
                                <!--                                        </div>-->
                                <!--                                    </td>-->
                                <!--                                </tr>-->
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
                            <!--                            <b-loading :is-full-page="false" :active.sync="loading" :can-cancel="true"></b-loading>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--        <router-view-->
        <!--                @designationCreated="onDesignationCreated"-->
        <!--                @designationUpdated="onDesignationUpdated"-->
        <!--        >-->
        <!--        </router-view>-->
        <AdditionCreateForm
                @payrollAdditionCreated="showCreateForm=false"
                v-if="showCreateForm"></AdditionCreateForm>
    </div>
</template>
<script>
    import AdditionCreateForm from "./AdditionCreateForm";
    import data_table_mixin from "../../../../mixins/data_table_mixin";

    export default {
        mixins: [data_table_mixin],
        components: {
            AdditionCreateForm
        },
        data() {
            return {
                showCreateForm: false,
                additions: []
            }
        },
        methods: {
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