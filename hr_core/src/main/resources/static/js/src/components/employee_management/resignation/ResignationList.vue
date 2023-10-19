<template>
  <div class="columns">
    <div class="column is-12">
      <div ref="leaveRequests" class="card">
        <div class="card-content">
          <div class="content b-table is-relative">
            <table class="table has-mobile-cards w-full is-hoverable">
              <thead class="font-thin">
              <tr>
                <th>
                  Resigning Employee
                </th>
                <th>
                  Department
                </th>
                <th>
                  Reason
                </th>
                <th>
                  Notice Date
                </th>
                <th>
                  Resignation Date
                </th>

                <th>
                  Action
                </th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="resignation in resignations">
                <td data-label="Name">{{ resignation.employeeFullName }}</td>
                <td data-label="Description">{{ resignation.employeeDepartment }}</td>
                <td data-label="Description">{{ resignation.reason }}</td>
                <td data-label="Description">{{ resignation.noticeDate|dateFormat }}</td>
                <td data-label="Description">{{ resignation.resignationDate|dateFormat }}</td>
                <td data-label="Action">
                  <div class="action-controls d-flex justify-end">
                    <router-link
                        :to="`/employee-resignation-edit/${resignation.id}`" class="button is-white is-small"
                        tag="button">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                    </router-link>
                    <button
                        class="button is-white is-small"
                        @click="confirmRemove(resignation)">
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
      resignations: []
    }
  },
  created() {
    this.getResignations();
  },
  filters: {
    dateFormat(val) {
      return moment(val).format("DD MMM YYYY ")
    }
  },
  methods: {
    fetchRecords() {
      this.getResignations();
    },
    getResignations() {
      this.loading = true;
      axios.get("/api/employee-resignations", {
        params: {
          page: this.page,
          pageSize: this.pageSize,
        }
      }).then(resp => {
        this.loading = false;
        this.resignations = resp.data.content;
        this.pageable = resp.data;
      }, error => {
        this.loading = false;
      })
    },

    confirmRemove(resignation) {
      this.$buefy.dialog.confirm({
        title: 'Remove Resignation',
        message: `Are you sure you want remove this record`,
        onConfirm: () => this.removeResignation(resignation)
      })
    },
    removeResignation(resignation) {
      axios.delete(`/api/employee-resignations/${resignation.id}`,
      ).then(resp => {
        this.getResignations();
      })
    }
  }
}

</script>
<style lang="scss" scoped>

</style>