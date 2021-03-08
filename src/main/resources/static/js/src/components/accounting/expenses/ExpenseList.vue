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
					 Add Expense
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
              <input
                  placeholder="Item Name"
                  class="input">
              </input>
            </div>
          </div>
        </div>
        <div class="column">
          <EmployeeSelectInput
              placeholder="Purchased By"
              :show-label="false">
          </EmployeeSelectInput>
        </div>
        <div class="column">
          <div class="field">
            <div class="control">
              <DatePicker
                  class="datepicker"
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
                  class="datepicker"
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
                  class="datepicker"
                  v-model="filterParams.endDate"
                  placeholder="To">
              </DatePicker>
            </div>
          </div>
        </div>

        <div class="column">
          <div class="button is-fullwidth is-primary">
            Search
          </div>
        </div>
      </div>
    </div>

    <div class="card">
      <div class="card-content">
        <table class="table is-fullwidth">
          <thead>
          <tr>
            <th>
              Item
            </th>
            <th>
              Purchase From
            </th>
            <th>
              Purchase Date
            </th>
            <th>
              Purchased By
            </th>
            <th>
              Amount
            </th>
            <th>
              Paid By
            </th>
            <th>
              Status
            </th>
            <th>
            </th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="estimate in expenses">
            <td>
              {{ estimate.id }}
            </td>
            <td>
              {{ estimate.id }}
            </td>
            <td>
              {{ estimate.estimateDate |formatDate }}
            </td>
            <td>
              {{ estimate.expiryDate|formatDate }}
            </td>
            <td>
              {{ estimate.amount }}
            </td>
            <td data-label="Action">
              <div class="action-controls d-flex justify-end">
                <router-link
                    :to="`/estimate-edit/${estimate.id}`" tag="button"
                    @click="" class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                </router-link>
                <button
                    @click="confirmRemoveExpense(estimate)"
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
  </div>
</template>
<script>
import {DatePicker} from "element-ui"
import EmployeeSelectInput from "../../common/EmployeeSelectInput"
import data_table_mixin from "../../../mixins/data_table_mixin";

export default {
  mixins: [data_table_mixin],
  components: {
    EmployeeSelectInput,
    DatePicker
  },
  data() {
    return {
      filterParams: {},
      expenses: []
    }
  },
  methods: {
    confirmRemoveExpense(expense) {

    }
  }
}
</script>