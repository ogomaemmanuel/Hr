<template>
  <div>
    <div>
      <div class="pb-2 flex justify-start">
        <router-link
            class="button mr-1 is-rounded"
            tag="button"
            to="/departments-create">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
          <span>
					 Add Department
				</span>
        </router-link>
        <a
            class="button is-rounded"
            href="/api/departments/excel-reports">
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
          <div ref="leaveRequests" class="card">
            <div class="card-content">
              <div class="content b-table is-relative">
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
                    <td data-label="Name">{{ department.name }}</td>
                    <td data-label="Action">
                      <div class="action-controls d-flex float-right">
                        <router-link
                            :to="`/departments-edit/${department.id}`" class="button is-white is-small"
                            tag="button" @click="">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                        </router-link>
                        <button
                            class="button is-white is-small"
                            @click="confirmRemoveDepartment(department)">
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
                          :paginationData="pageable"
                          @nextPage="goToNext"
                          @paginationChanged="onPaginationChanged"
                          @previousPage="goToPrevious"
                      ></Paginator>
                    </td>
                  </tr>
                  </tfoot>
                </table>
                <b-loading :active.sync="loading" :can-cancel="true" :is-full-page="false"></b-loading>
              </div>
            </div>
          </div>
        </div>
      </div>
      <router-view
          @departmentCreated="onDepartmentCreated"
          @departmentUpdated="onDepartmentUpdated"
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