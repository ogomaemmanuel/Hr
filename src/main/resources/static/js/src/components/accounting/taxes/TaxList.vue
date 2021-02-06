<template>
  <div>
    <div class="pb-2 flex justify-end">
      <router-link
          to="/tax-create"
          tag="button"
          class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Add Tax
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
              <h4>Taxes</h4>
              <table class="table has-mobile-cards w-full is-hoverable">
                <thead class="font-thin">
                <tr>
                  <th>
                    Tax Name
                  </th>
                  <th>
                    Tax Percentage (%)
                  </th>
                  <th>
                    Status
                  </th>
                  <th>
                    Action
                  </th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="tax in taxes">
                  <td data-label="Name">{{ tax.name }}</td>
                  <td data-label="Date">{{ tax.percentageAmount }}</td>
                  <td data-label="Description">{{ tax.name }}</td>
                  <td data-label="Action">
                    <div class="action-controls d-flex justify-end">
                      <router-link
                          :to="`/tax-edit/${tax.id}`" tag="button"
                          @click="" class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                      </router-link>
                      <button
                          @click="confirmRemoveTax(tax)"
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
    <router-view>

    </router-view>
  </div>
</template>
<script>
import Paginator from "../../common/paginator/Paginator";
import data_table_mixin from "../../../mixins/data_table_mixin";
import {Message} from "element-ui"

export default {
  mixins: [data_table_mixin],
  components: {
    Paginator
  },
  data() {
    return {
      loading: false,
      taxes: []
    }
  },
  created() {
    this.getTaxes();
  },
  methods: {
    confirmRemoveTax(tax) {
      this.$buefy.dialog.confirm({
        title: 'Remove Tax',
        message: `Are you sure want to remove <b> ${tax.name}</b>`,
        onConfirm: () => this.removeTax(tax)
      })
    },
    removeTax(tax) {
      axios.delete(`api/taxes/${tax.id}`).then(resp => {
        Message.success("Tax successfully removed");
        this.getTaxes();
      })
    },
    fetchRecords() {
      this.getTaxes();
    },

    getTaxes() {
      axios.get("api/taxes", {
        params: {
          page: this.page,
          pageSize: this.pageSize
        }
      }).then(resp => {
        this.loading = false;
        this.taxes = resp.data.content;
        this.pageable = resp.data;
      }, error => {
        this.loading = false

      })
    }
  }
}
</script>