<template>
  <div>
    <div class="pb-2 flex justify-end">
      <router-link
          to="/provident-fund-create"
          tag="button"
          class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Add Provident Fund
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
    <div class="card">
      <div class="card-content">
        <table class="table is-fullwidth">
          <thead>
          <tr>
            <th>
              Employee Name
            </th>
            <th>
              Provident Fund Type
            </th>
            <th>
              Employee Share
            </th>
            <th>
              Organisation Share
            </th>

            <th>
              Status
            </th>
            <th>
            </th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="providentFund in providentFunds">
            <td>
              {{ getEmployeeFullName(providentFund) }}
            </td>
            <td>
              {{ providentFund.providentFundTypeText }}
            </td>
            <td>
              {{ providentFund.employeeShare }}
            </td>

            <td>
              {{ providentFund.organisationShare }}
            </td>
            <td>
              {{ providentFund.paidBy }}
            </td>
            <td data-label="Action">
              <div class="action-controls d-flex justify-end">
                <router-link
                    :to="`/provident-fund-edit/${providentFund.id}`" tag="button"
                    @click="" class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                </router-link>
                <button
                    @click="confirmRemoveProvidentFund(providentFund)"
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
      </div>

    </div>
    <router-view>

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
      providentFunds: [],
      loading: false
    }
  },

  created() {
    this.getProvidentFunds();
  },
  methods: {
    fetchRecords() {
      this.getProvidentFunds();
    },
    confirmRemoveProvidentFund(providentFund) {

    },
    getEmployeeFullName(providentFund) {
      return providentFund.employee.user.fullName;
    },
    getProvidentFunds() {
      axios.get("/api/provident-funds", {
        params: {
          page: this.page,
          pageSize: this.pageSize
        }
      }).then(resp => {
        this.loading = false;
        this.providentFunds = resp.data.content;
        this.pageable = resp.data;
      })
    }

  }
}
</script>