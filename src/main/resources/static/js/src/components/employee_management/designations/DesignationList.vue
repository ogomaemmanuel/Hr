<template>
    <div>
        <div class="pb-2 flex justify-end">
            <router-link
                    to="/designations-create"
                    tag="button"
                    class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
                <span>
					 Add Designation
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
                            <h4>Designations</h4>
                            <table class="table has-mobile-cards w-full is-hoverable">
                                <thead class="font-thin">
                                <tr>
                                    <th>
                                        Name
                                    </th>
                                    <th>
                                        Department
                                    </th>
                                    <th>
                                        Action
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr v-for="designation in designations">
                                    <td data-label="Name">{{designation.name}}</td>
                                    <td data-label="Description">{{designation.department.name}}</td>
                                    <td data-label="Action">
                                        <div class="action-controls d-flex justify-end">
                                            <router-link
                                                    :to="`/designations-edit/${designation.id}`" tag="button"
                                                    class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                                            </router-link>
                                            <button
                                                    @click="confirmRemoveDesignation(designation)"
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
            </div>
        </div>
        <router-view
                @designationCreated="onDesignationCreated"
                @designationUpdated="onDesignationUpdated"
        >
        </router-view>
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
                showCreateDialog: false,
                designations: [],
                pageable: false,
                pageSize: 10,
                page: 0,
                loading: false
            }
        },
        created() {
            this.getDesignations();
        },
        methods: {
            confirmRemoveDesignation(designation) {
                this.$buefy.dialog.confirm({
                    title: 'Remove Department',
                    message: `Are you sure want to remove <b> ${designation.name}</b> from designations`,
                    onConfirm: () => this.removeDesignation(designation)
                })
            },
            removeDesignation(designation) {
                axios.delete(`/api/designations/${designation.id}`).then(resp => {
                    this.$swal({
                        type: "success",
                        title: "Success",
                        message: "Designation successfully removed",
                    })
                    this.getDesignations();
                })
            },

            getDesignations() {
                let vm = this;
                axios.get("/api/designations", {
                    params: {
                        pageSize: vm.pageSize,
                        page: vm.page

                    }
                }).then(resp => {
                    vm.loading = false;
                    this.designations = resp.data.content;
                    this.pageable = resp.data;
                }, error => {
                    vm.loading = false;
                })
            },
            goToPrevious() {
                this.page--;
                this.getDesignations();
            },
            goToNext() {
                this.page++;
                this.getDesignations();
            },
            onPaginationChanged(pageSize) {
                this.page = 0;
                this.pageSize = pageSize;
                this.getDesignations();
            },
            onDesignationUpdated() {
                this.getDesignations();
            },
            onDesignationCreated() {
                this.getDesignations();
            }
        }

    }
</script>
<style lang="scss" scoped>

</style>