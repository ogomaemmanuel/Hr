<template>
  <div>

    <div class="pb-2 flex justify-end">
      <router-link
          to="/policy-create"
          tag="button"
          class="button mr-1 is-rounded is-small">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Create Policy
				</span>
      </router-link>
      <a
          href="/api/holidays/excel-report"
          class="button is-rounded is-small">
				<span class="icon">
					<i class="fa fa-download mr-1"></i>
				</span>
        <span>
					 Export
				</span>
      </a>
    </div>
    <div class="columns is-size-7">
      <div class="column is-12">
        <div class="card" ref="leaveRequests">
          <div class="card-content">
            <div class="content b-table is-relative">
              <h4>Holidays</h4>
              <table class="table has-mobile-cards w-full is-hoverable">
                <thead class="font-thin">
                <tr>
                  <th>
                    Name
                  </th>

                  <th>
                    Description
                  </th>
<!--                  <th>-->
<!--                    Action-->
<!--                  </th>-->
                </tr>
                </thead>
                <tbody>
                <tr v-for="policy in policies">
                  <td data-label="Name">{{policy.name}}</td>
                  <td data-label="Description">{{policy.description}}</td>
<!--                  <td data-label="Action">-->
<!--                    <div class="action-controls d-flex justify-end">-->
<!--                      <router-link-->
<!--                          :to="`/holiday-edit/${policy.id}`" tag="button"-->
<!--                          @click="setHolidayToEdit(holiday)" class="button is-white is-small">-->
<!--												<span class="icon">-->
<!--					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>-->
<!--					                       </span>-->
<!--                      </router-link>-->
<!--                      <button-->
<!--                          @click="confirmRemoveHoliday(holiday)"-->
<!--                          class="button is-white is-small">-->
<!--										           <span class="icon">-->
<!--						                            <i class="fa fa-trash-o has-text-danger"></i>-->
<!--					                               </span>-->
<!--                      </button>-->
<!--                    </div>-->
<!--                  </td>-->
                </tr>
                </tbody>
                <tfoot>
                <tr>
                  <td colspan="4">
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
    <router-view></router-view>
  </div>
</template>
<script>
import data_table_mixin from "../../../mixins/data_table_mixin";
import Paginator from "../../common/paginator/Paginator";

export default {
  components:{
    Paginator
  },
  mixins: [data_table_mixin],
  data() {
    return {
      policies: [],
      loading: false,
    }
  },
  created() {
    this.getPolicies();
  },
  methods: {
    fetchRecords() {
      this.getPolicies()
    },
    getPolicies() {
      let request = {
        page: this.page,
        pageSize: this.pageSize
      }
      this.loading = true;
      axios.get("/api/policies", {
        params: request
      }).then(resp => {
        this.loading = false;
        this.policies = resp.data.content;
        this.pageable = resp.data;
      }, error => {
        this.loading = false
      })
    }
  }
}
</script>