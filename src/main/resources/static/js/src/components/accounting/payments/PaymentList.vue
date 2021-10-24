<template>
  <div>
    <div class="pb-2 flex justify-end">
      <router-link
          to="/invoice-create"
          tag="button"
          class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 New Payment
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
                Invoice ID
              </th>
              <th>
                Client
              </th>
              <th>
                Invoice Date
              </th>
              <th>
                Payment Type
              </th>
              <th>
                Payment Date
              </th>
              <th>
                Paid Amount
              </th>
              <th>
              </th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="invoice in invoices">
              <td>
                {{ invoice.id }}
              </td>
              <td>
                {{ invoice.id }}
              </td>
              <td>
                {{ invoice.estimateDate |formatDate }}
              </td>
              <td>
                {{ invoice.expiryDate|formatDate }}
              </td>
              <td>
                {{ invoice.amount }}
              </td>
              <td data-label="Action">
                <div class="action-controls d-flex justify-end">
                  <router-link
                      :to="`/estimate-edit/${invoice.id}`" tag="button"
                      @click="" class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                  </router-link>
<!--                  <button-->
<!--                      @click="confirmRemoveInvoice(invoice)"-->
<!--                      class="button is-white is-small">-->
<!--										           <span class="icon">-->
<!--						                            <i class="fa fa-trash-o has-text-danger"></i>-->
<!--					                               </span>-->
<!--                  </button>-->
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
  </div>
</template>
<script>
import Paginator from "../../common/paginator/Paginator";
import data_table_mixin from "../../../mixins/data_table_mixin";
export default {
  mixins:[data_table_mixin],
  components: {
    Paginator
  }

  methods
}
</script>