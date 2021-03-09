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
        <div class="column">
          <div class="field">
            <label class="label">Purchase From<span><sup>*</sup></span></label>
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
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Purchase Date<span><sup>*</sup></span></label>
            <div class="control">
              <DatePicker
                  class="datepicker"
                  v-model="expense.purchaseDate"
                  @input="clearFieldError('name')">
              </DatePicker>
              <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{ errors['name'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <EmployeeSelectInput
              label="Purchased By"
              @input="clearFieldError('purchasedBy')"
              v-model="expense.purchasedBy">
              <span slot="errors"
                    class="mb-2 has-text-danger"
                    v-if="errors['name']">
						{{ errors['name'][0] }}
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
        <div class="column">
          <div class="field">
            <label class="label">Paid By<span><sup>*</sup></span></label>
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
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Status<span><sup>*</sup></span></label>
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
import {DatePicker} from "element-ui"
import EmployeeSelectInput from "../../common/EmployeeSelectInput";

export default {
  mixins: [common_mixin],
  components: {
    DatePicker,
    EmployeeSelectInput
  },
  data() {
    return {
      expense: {}
    }
  },
  methods: {
    createExpense() {
      let request = this.createFormData(this.expense);
      axios.post("/api/expenses",
          request).then(resp => {

      })
    }
  },
  computed: {
    disableSubmitButton() {

    }
  }
}
</script>