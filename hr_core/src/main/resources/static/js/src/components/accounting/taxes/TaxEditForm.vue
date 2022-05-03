<template>
  <div>
    <form>
      <div class="has-text-centered m-3">
        <h1 class="has-text-black"><b>Update Tax</b></h1>
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
            @click.prevent.stop="updateTax"
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
  components: {},
  mixins: [common_mixin],
  props: {
    id: {
      required: true
    }
  },
  data() {
    return {
      tax: {},
      loading: false
    }
  },
  computed: {
    disableSubmitButton() {
      return this.loading;
    }
  },
  created() {
    this.getTaxById();
  },
  methods: {
    getTaxById() {
      axios.get(`/api/taxes/${this.id}`)
          .then(resp => {
            this.tax = resp.data;
          }, error => {
            console.error("There was an error fetching tax")
          })
    },
    updateTax() {
      this.loading = true
      axios.put(`/api/taxes/${this.id}`,
          this.tax).then(resp => {
        this.loading = false
        Message.success("Tax successfully updated");
        this.$emit("updateSuccessful")
      }, error => {
        this.loading = false;
        if (error.response.status == 400) {
          this.errors = error.response.data;
        }
      })
    }
  }
}
</script>