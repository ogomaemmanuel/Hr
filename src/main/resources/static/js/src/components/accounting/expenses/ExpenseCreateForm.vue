<template>
  <div>
    <form>
      <div class="has-text-centered m-3">
        <h1 class="has-text-black"><b>Add Expense</b></h1>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Item Name <span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="expense.itemName"
                  @input="clearFieldError('itemName')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['itemName']">
						{{ errors['itemName'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Purchase From<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="expense.purchaseFrom"
                  @input="clearFieldError('purchaseFrom')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['purchaseFrom']">
						{{ errors['purchaseFrom'][0] }}
					</span>
            </div>
          </div>

        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Purchase Date<span><sup>*</sup></span></label>
            <div class="control">
              <DatePicker
                  class="datepicker"
                  v-model="expense.purchaseDate"
                  @input="clearFieldError('purchaseDate')">
              </DatePicker>
              <span class="mb-2 has-text-danger" v-if="errors['purchaseDate']">
						{{ errors['purchaseDate'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <EmployeeSelectInput
              label="Purchased By"
              @input="clearFieldError('purchasedById')"
              v-model="expense.purchasedById">
              <span slot="errors"
                    class="mb-2 has-text-danger"
                    v-if="errors['purchasedById']">
						{{ errors['purchasedById'][0] }}
					</span>
          </EmployeeSelectInput>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Amount<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="expense.amount"
                  @input="clearFieldError('amount')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['amount']">
						{{ errors['amount'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Paid By<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="expense.paidBy"
                  @input="clearFieldError('paidBy')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['paidBy']">
						{{ errors['paidBy'][0] }}
					</span>
            </div>
          </div>

        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Status<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="expense.status"
                  @input="clearFieldError('status')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['status']">
						{{ errors['status'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Attachments<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="expense.name"
                  @input="clearFieldError('name')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{ errors['name'][0] }}
					</span>
            </div>
          </div>

        </div>
      </div>
      <div class="flex justify-center m-3">
        <button
            ref="createButton"
            :class="{'is-loading':isLoading}"
            :disabled="disableSubmitButton"
            @click.prevent.stop="createExpense()"
            class="button  is-rounded"
            type="submit">Submit
        </button>
      </div>
    </form>
  </div>
</template>
<script>
import common_mixin from "../../../mixins/common_mixin";
import {DatePicker, Message} from "element-ui"
import EmployeeSelectInput from "../../common/EmployeeSelectInput";

export default {
  mixins: [common_mixin],
  components: {
    DatePicker,
    EmployeeSelectInput
  },
  data() {
    return {
      isLoading: false,
      expense: {}
    }
  },
  methods: {
    createExpense() {
      let request = this.createFormData(this.expense);
      this.isLoading = true
      axios.post("/api/expenses",
          request).then(resp => {
        this.isLoading = false
        Message.success("Expense successfully created")
        this.$emit("createSuccessful")
      }, error => {
        this.isLoading = false
        if (error.response.status == 400) {
          this.errors = error.response.data;
        }
      })
    }
  },
  computed: {
    disableSubmitButton() {
      return this.isLoading
    }
  }
}
</script>