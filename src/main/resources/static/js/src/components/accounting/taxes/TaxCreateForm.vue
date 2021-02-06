<template>
  <div>
    <form>
      <div class="has-text-centered m-3">
        <h1 class="has-text-black"><b>Add Tax</b></h1>
      </div>
      <div class="field">
        <label class="label is-size-7">Tax Name <span><sup>*</sup></span></label>
        <div class="control">
          <input
              v-model="tax.name"
              @input="clearFieldError('name')"
              class="input"
              type="text">
          <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{ errors['name'][0] }}
					</span>
        </div>
      </div>
      <div class="field">
        <label class="label is-size-7">Tax Percentage<span><sup>*</sup></span></label>
        <div class="control">
          <input
              v-model="tax.percentageAmount"
              @input="clearFieldError('percentageAmount')"
              class="input"
              type="text">
          <span class="mb-2 has-text-danger" v-if="errors['percentageAmount']">
						{{ errors['percentageAmount'][0] }}
					</span>
        </div>
      </div>
      <div class="flex justify-center m-3">
        <button

            :class="{'is-loading':loading}"
            :disabled="disableSubmitButton"
            @click.prevent.stop="createTax"
            class="button  is-rounded"
            type="submit">Submit
        </button>
      </div>
    </form>
  </div>
</template>
<script>
import common_mixin from "../../../mixins/common_mixin";
import {Message} from "element-ui"

export default {
  mixins: [common_mixin],
  data() {
    return {
      loading: false,
      tax: {}
    }
  },
  computed: {
    disableSubmitButton() {
      return this.loading;
    }
  },
  methods: {
    createTax() {
      this.loading = true
      axios.post(`api/taxes`,
          this.tax).then(resp => {
        this.loading = false;
        Message.success("Tax successfully created")
        this.$emit("createSuccessful")
      }, error => {
        this.loading = false;
        if (error.response.status = 400) {
          this.errors = error.response.data;
        }
      })
    }
  }
}
</script>