<template>
  <div>
    <div class="pb-2 flex justify-end">
      <router-link
          to="/job-create"
          tag="button"
          class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Add Job
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
              <h4>Jobs</h4>
              <table class="table has-mobile-cards w-full is-hoverable">
                <thead class="font-thin">
                <tr>
                  <th>
                    Job Title
                  </th>
                  <th>
                    Department
                  </th>
                  <th>
                    Start Date
                  </th>
                  <th>
                    Expire Date
                  </th>
                  <th>
                    Job Type
                  </th>
                  <th>
                    Status
                  </th>
                  <th>
                    Applicants
                  </th>
                  <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="job in jobs">
                  <td data-label="Name">{{ job.title }}</td>
                  <td data-label="Date">{{ getJobDepartment(job) }}</td>
                  <td data-label="Description">{{ job.startDate }}</td>
                  <td data-label="Description">{{ job.endDate }}</td>
                  <td data-label="Description">{{ job.type }}</td>
                  <td data-label="Description">{{ job.status }}</td>
                  <td data-label="Description">{{ job.name }}</td>
                  <td data-label="Action">
                    <div class="action-controls d-flex justify-end">
                      <router-link
                          :to="`/job-edit/${job.id}`" tag="button"
                          class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                      </router-link>
                      <button
                          @click="confirmRemoveJob(job)"
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
        @createSuccessful="onJobCreateSuccessful"
        @holidayUpdateSuccessful="onJobUpdateSuccessful">
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
      jobs: [],
      pageable: false
    }
  },
  created() {
    this.getJobs();
  },
  methods: {
    fetchRecords() {
      this.getJobs();
    },
    getJobs() {
      let vm = this;
      axios.get("/api/jobs", {
        params: {
          pageSize: this.pageSize,
          page: this.page
        }
      }).then(resp => {
        vm.loading = false;
        this.jobs = resp.data.content;
        this.pageable = resp.data;
      }, error => {

      })
    },
    getJobDepartment(job) {
      if (job.department) {
        return job.department.name;
      }
      return  "";
    },
    confirmRemoveJob() {
    },
    onJobCreateSuccessful() {
      this.getJobs();
    },
    onJobUpdateSuccessful() {
      this.getJobs();
    }
  }

}


</script>