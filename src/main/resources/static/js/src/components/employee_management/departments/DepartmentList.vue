<template>
    <div>
        <div>
            <div class="pb-2 flex justify-end">
                <router-link
                        to="/departments-create"
                        tag="button"
                        class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
                    <span>
					 Add Department
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
                                <h4>Departments</h4>
                                <table class="table has-mobile-cards w-full is-hoverable">
                                    <thead class="font-thin">
                                    <tr>
                                        <th>
                                            Name
                                        </th>
                                        <th>
                                            <div class="float-right">
                                                <!--                                                Action-->
                                            </div>
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr v-for="department in departments">
                                        <td data-label="Name">{{department.name}}</td>
                                        <td data-label="Action">
                                            <div class="action-controls d-flex float-right">
                                                <router-link
                                                        :to="`/departments-edit/${department.id}`" tag="button"
                                                        @click="" class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                                                </router-link>
                                                <button
                                                        @click="confirmRemoveDepartment(department)"
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
                    @departmentUpdated="onDepartmentUpdated"
                    @departmentCreated="onDepartmentCreated"
            >
            </router-view>
        </div>
    </div>
</template>
<script>
    import Paginator from "../../common/paginator/Paginator";
    import ModalTemplate from "../../common/ModalTemplate";
    import DepartmentCreateForm from "./DepartmentCreateForm";

    export default {

        components: {
            Paginator,
            ModalTemplate,
            DepartmentCreateForm
        },
        data() {
            return {
                departments: [],
                pageable: false,
                pageSize: 10,
                page: 0,
                loading: false
            }
        },
        methods: {
            confirmRemoveDepartment(department) {
                this.$buefy.dialog.confirm({
                    title: 'Remove Department',
                    message: `Are you sure want to remove <b> ${department.name}</b> from departments`,
                    onConfirm: () => this.removeDepartment(department)
                })
            },
            removeDepartment(department) {
                axios.delete(`/api/departments/${department.id}`).then(resp => {
                    this.$swal({
                        type: "success",
                        title: "Success",
                        message: "Department successfully removed",
                    })
                    this.getDepartments();
                })
            },
            onDepartmentCreated() {
                this.getDepartments();
            },
            getDepartments() {
                let vm = this;
                vm.loading = true;
                axios.get("/api/departments", {
                    params: {
                        pageSize: vm.pageSize,
                        page: vm.page
                    }
                }).then(resp => {
                    vm.loading = false;
                    this.departments = resp.data.content;
                    this.pageable = resp.data;
                }, error => {
                    vm.loading = false;
                })
            },
            goToPrevious() {
                this.page--;
                this.getDepartments();
            },
            goToNext() {
                this.page++;
                this.getDepartments();
            },
            onPaginationChanged(pageSize) {
                this.page = 0;
                this.pageSize = pageSize;
                this.getDepartments();
            },
            onDepartmentUpdated() {
                this.getDepartments();
            }
        },
        created() {
            this.getDepartments();
        }
    }
</script>