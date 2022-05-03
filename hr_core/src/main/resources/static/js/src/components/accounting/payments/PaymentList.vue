<template>
  <div>
    <div class="pb-2 flex justify-end">
      <router-link
          to="/payments-create"
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
            <tr v-for="payment in payments">
              <td>
                {{ payment.id }}
              </td>
              <td>
                {{ payment.id }}
              </td>
              <td>
                {{ payment.paymentDate  }}
              </td>
              <td>
                {{ payment.expiryDate|formatDate }}
              </td>
              <td>
                {{ payment.amount }}
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
  mixins: [data_table_mixin],
  components: {
    Paginator
  },
  data() {
    return {
      payments: [],
      loading: false,
    }
  },
  created() {
    this.getPayments();
  },
  methods: {
    fetchRecords() {
      this.getInvoices()
    },
    getPayments() {
      this.loading = true;
      axios.get("api/payments", {
        params: {
          page: this.page,
          pageSize: this.pageSize

        }
      }).then(resp => {
        this.payments = resp.data.contents;
        this.pageable = resp.data;
        this.loading = false
      }, error => {
        this.loading = false;
      })
    }
  }
}
</script>