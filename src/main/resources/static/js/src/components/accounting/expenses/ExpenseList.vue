<template>
  <div>
    <div class="pb-2 flex justify-end">
      <router-link
          to="/expense-create"
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
          <tr v-for="expense in expenses">
            <td>
              {{ expense.id }}
            </td>
            <td>
              {{ expense.purchaseFrom }}
            </td>
            <td>
              {{ expense.purchaseDate |formatDate }}
            </td>
            <td>
              {{ expense.purchasedBy }}
            </td>
            <td>
              {{ expense.amount }}
            </td>
            <td>
              {{ paidBy.amount }}
            </td>
            <td data-label="Action">
              <div class="action-controls d-flex justify-end">
                <router-link
                    :to="`/estimate-edit/${expense.id}`" tag="button"
                    @click="" class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                </router-link>
                <button
                    @click="confirmRemoveExpense(expense)"
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
import Paginator from "../../common/paginator/Paginator";

export default {
  mixins: [data_table_mixin],
  components: {
    EmployeeSelectInput,
    DatePicker,
    Paginator
  },
  data() {
    return {
      loading: false,
      filterParams: {},
      expenses: []
    }
  },
  created() {
    this.getExpenses();
  },
  methods: {
    confirmRemoveExpense(expense) {

    },
    fetchRecords() {
      this.getExpenses()
    },

    getExpenses() {
      axios.get("/api/expenses", {
        params: {
          page: this.page,
          pageSize: this.pageSize
        }
      }).then(resp => {
        this.loading = false;
        this.expenses = resp.data.content;
        this.pageable = resp.data;
      })
    }
  },
  filters: {
    formatDate(val) {
      if (val) {
        return moment(val).format("DD-MMMM-YYYY")
      }
    }
  },
}
</script>