<template>
  <div>
    <div class="pb-2 flex justify-start">
      <button
          class="button mr-1 is-rounded"
          @click="showCreateForm=true">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Add Deduction
				</span>
      </button>
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
                    Name
                  </th>
                  <!--                                    <th>-->
                  <!--                                        Category-->
                  <!--                                    </th>-->
                  <th>
                    Default/Unit Amount
                  </th>
                  <th>
                    Action
                  </th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="deduction in deductions">
                  <td data-label="Name">{{ deduction.name }}</td>
                  <td data-label="Description">{{ deduction.amount }}</td>
                  <td data-label="Action">
                    <div class="action-controls d-flex justify-end">
                      <button
                          class="button is-white is-small" tag="button"
                          @click="setUpdateId(deduction.id)">
                                												<span class="icon">
                                					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
                                					                       </span>
                      </button>
                      <button
                          class="button is-white is-small"
                          @click="confirmRemoveDeduction(deduction)">
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
                  <td colspan="3">
                    <Paginator
                        :paginationData="pageable"
                        @nextPage="goToNext"
                        @paginationChanged="onPaginationChanged"
                        @previousPage="goToPrevious">
                    </Paginator>
                  </td>
                </tr>
                </tfoot>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
    <DeductionCreateForm
        v-if="showCreateForm"
        @modalClosed="showCreateForm=false"
        @payrollDeductionCreated="onPayrollDeductionCreated">
    </DeductionCreateForm>
    <DeductionEditForm
        v-if="showEditForm"
        :id="updateId"
        @modalClosed="showEditForm=false"
        @payrollDeductionUpdated="onPayrollDeductionUpdated">
    </DeductionEditForm>
  </div>
</template>
<script>
import DeductionCreateForm from "./DeductionCreateForm";
import Paginator from "../../../common/paginator/Paginator";
import data_table_mixin from "../../../../mixins/data_table_mixin";
import DeductionEditForm from "./DeductionEditForm";

export default {
  mixins: [data_table_mixin],
  components: {
    DeductionCreateForm,
    Paginator,
    DeductionEditForm

  },
  data() {
    return {
      showCreateForm: false,
      deductions: [],
      updateId: false,
      showEditForm: false,
    }
  },
  created() {
    this.getDeductions();
  },
  methods: {
    fetchRecords() {
      this.getDeductions();
    },
    setUpdateId(id) {
      this.updateId = id;
      this.showEditForm = true;
    },
    onPayrollDeductionUpdated() {
      this.showEditForm = false;
      this.getDeductions();
    },
    onPayrollDeductionCreated() {
      this.showCreateForm = false;
      this.getDeductions();
    },
    confirmRemoveDeduction(deduction) {
      this.$buefy.dialog.confirm({
        title: 'Remove Payroll Deduction',
        message: `Are you sure you want remove this record`,
        onConfirm: () => this.removeDeduction(deduction)
      })
    },
    removeDeduction(deduction) {
      axios.delete(`/api/payroll-deductions/${deduction.id}`,
      ).then(resp => {
        this.getDeductions();
      })
    },
    getDeductions() {
      axios.get("/api/payroll-deductions", {
        params: {
          page: this.page,
          pageSize: this.pageSize,
        }
      }).then(resp => {
        this.deductions = resp.data.content;
        this.pageable = resp.data;
      }, error => {

      })
    }
  }

}
</script>