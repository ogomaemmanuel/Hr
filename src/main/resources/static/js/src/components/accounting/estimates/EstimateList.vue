<template>
  <div>
    <div class="pb-2 flex justify-end">
      <router-link
          to="/estimate-create"
          tag="button"
          class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Create Estimate
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
    <div>
      <div class="columns mt-4">
        <div class="column">
          <div class="field">
            <div class="control">
              <!--              <label class="label">From</label>-->
              <DatePicker
                  v-model="filterParams.startDate"
                  placeholder="From"
              ></DatePicker>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <div class="control">
              <DatePicker
                  v-model="filterParams.endDate"
                  placeholder="To">
              </DatePicker>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <div class="control">
              <input class="input"></input>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="button is-fullwidth is-primary">
            Search
          </div>
        </div>
      </div>

      <div class="card">
        <div class="card-content">
          <table class="table is-fullwidth">
            <thead>
            <tr>
              <th>
                Estimate Number
              </th>
              <th>
                Client
              </th>
              <th>
                Estimate Date
              </th>
              <th>
                Expiry Date
              </th>
              <th>
                Amount
              </th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="estimate in estimates">
              <td>
                {{ estimate.id }}
              </td>
              <td>
                {{ estimate.id }}
              </td>
              <td>
                {{ estimate.estimateDate }}
              </td>
              <td>
                {{ estimate.expiryDate }}
              </td>
              <td>
                {{ estimate.amount }}
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
    </div>
  </div>
</template>
<script>
import {DatePicker} from "element-ui"
import data_table_mixin from "../../../mixins/data_table_mixin";
import Paginator from "../../common/paginator/Paginator";

export default {
  mixins: [data_table_mixin],
  components: {
    DatePicker,
    Paginator
  },
  data() {
    return {
      filterParams: {},
      estimates: []
    }
  },
  created() {
    this.getEstimates();
  },
  methods: {
    getEstimates() {
      axios.get("/api/estimates", {
        params: {
          page: this.page,
          pageSize: this.pageSize,
          clientId: 1
        }
      }).then(resp => {
        this.loading = false;
        this.estimates = resp.data.content;
        this.pageable = resp.data;
      })
    }
  }
}
</script>