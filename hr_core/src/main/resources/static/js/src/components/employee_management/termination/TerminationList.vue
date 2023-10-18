<template>
  <div>
    <div class="pb-2 flex justify-start">
      <button
          class="button mr-1 is-rounded"
          tag="button"
          to="/departments-create"
          @click="showTerminationCreateForm=true">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Add Termination
				</span>
      </button>
      <a
          class="button is-rounded"
          href="/api/overtime-requests/excel-reports">
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
                <tr v-for="termination in terminations">
                  <td data-label="Name">{{ termination.employeeFullName }}</td>
                  <td data-label="Description">{{ termination.departmentName }}</td>
                  <td data-label="Description">{{ termination.terminationType }}</td>
                  <td data-label="Description">{{ termination.terminationDate }}</td>
                  <td data-label="Description">{{ termination.reason }}</td>
                  <td data-label="Description">{{ termination.noticeDate }}</td>
                  <td data-label="Action">
                    <div class="action-controls d-flex justify-end">
                      <router-link
                          :to="`/employee-termination-edit/${termination.id}`" class="button is-white is-small"
                          tag="button">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                      </router-link>
                      <button
                          class="button is-white is-small"
                          @click="confirmRemove(termination)">
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
          @terminationUpdated="getTerminations()">
      </router-view>
    </div>
    <TerminationCreateForm
        v-if="showTerminationCreateForm"
        @modalClosed="showTerminationCreateForm=false"
        @terminationSaved="onTerminationSaved"
    ></TerminationCreateForm>
  </div>
</template>
<script>
import TerminationCreateForm from "./TerminationCreateForm";
import data_table_mixin from "../../../mixins/data_table_mixin";
import Paginator from "../../common/paginator/Paginator";

export default {
  mixins: [data_table_mixin],
  components: {
    TerminationCreateForm,
    Paginator
  },
  data() {
    return {
      showTerminationCreateForm: false,
      terminations: [],
      loading: false
    }
  },
  created() {
    this.getTerminations();
  },
  methods: {
    fetchRecords() {
      this.getTerminations();
    },
    onTerminationSaved() {
      this.showTerminationCreateForm = false;
      this.getTerminations();
    },
    getTerminations() {
      this.loading = true;
      axios.get("/api/employee-terminations", {
        params: {
          page: this.page,
          pageSize: this.pageSize,
        }
      }).then(resp => {
        this.terminations = resp.data.content;
        this.pageable = resp.data;
        this.loading = false
      }, error => {
        this.loading = false
      })
    },
    confirmRemove(termination) {
      this.$buefy.dialog.confirm({
        title: 'Remove Resignation',
        message: `Are you sure you want remove this record`,
        onConfirm: () => this.removeTermination(termination)
      })
    },
    removeTermination(termination) {
      axios.delete(`/api/employee-terminations/${termination.id}`)
          .then(resp => {
            this.getTerminations();
          })
    }
  },

}
</script>