<template>
  <div>
    <form>
      <div class="has-text-centered m-3">
        <h1 class="has-text-black"><b>Add Provident Fund</b></h1>
      </div>
      <div class="columns">
        <div class="column">
          <EmployeeSelectInput
              v-model="providentFund.employeeId"
              label="Employee Name"></EmployeeSelectInput>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Provident Fund Type<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="providentFund.purchaseFrom"
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
            <label class="label">Employee Share (Amount)</label>
            <div class="control">
              <input
                  class="input"
                  v-model="providentFund.employeeShare"
                  @input="clearFieldError('employeeShare')">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['employeeShare']">
						{{ errors['employeeShare'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Organization Share (Amount)</label>
            <div class="control">
              <input
                  class="input"
                  v-model="providentFund.organisationShare"
                  @input="clearFieldError('organisationShare')">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['organisationShare']">
						{{ errors['organisationShare'][0] }}
					</span>
            </div>
          </div>
        </div>

      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Employee Share (%)</label>
            <div class="control">
              <input
                  class="input"
                  v-model="providentFund.percentageEmployeeShare"
                  @input="clearFieldError('percentageEmployeeShare')">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['percentageEmployeeShare']">
						{{ errors['percentageEmployeeShare'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Organization Share (%)</label>
            <div class="control">
              <input
                  class="input"
                  v-model="providentFund.percentageOrganisationShare"
                  @input="clearFieldError('percentageOrganisationShare')">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['percentageOrganisationShare']">
						{{ errors['percentageOrganisationShare'][0] }}
					</span>
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Description<span><sup>*</sup></span></label>
            <textarea
                class="textarea"
                @input="clearFieldError('description')"
                v-model="providentFund.description">
              </textarea>
            <span class="mb-2 has-text-danger" v-if="errors['description']">
						{{ errors['description'][0] }}
					</span>
          </div>
        </div>
      </div>
      <div class="flex justify-center m-3">
        <button
            ref="createButton"
            :class="{'is-loading':isLoading}"
            :disabled="disableSubmitButton"
            @click.prevent.stop="createProvidentFund()"
            class="button  is-rounded"
            type="submit">Submit
        </button>
      </div>
    </form>
  </div>
</template>
<script>
import common_mixin from "../../../mixins/common_mixin";
import EmployeeSelectInput from "../../common/EmployeeSelectInput";
import {DatePicker} from "element-ui"

export default {
  components: {
    DatePicker,
    EmployeeSelectInput

  },
  mixins: [common_mixin],
  data() {
    return {
      providentFund: {},
      isLoading: false
    }
  },

  methods: {
    createProvidentFund() {

    }
  },
  computed: {
    disableSubmitButton() {
      return this.isLoading;
    }
  }

}
</script>
<style scoped lang="scss">

</style>