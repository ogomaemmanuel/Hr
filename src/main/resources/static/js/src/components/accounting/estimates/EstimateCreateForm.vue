<template>
  <div>
    <form action="">
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Client</label>
            <div class="control">
              <input class="input" type="text" placeholder="e.g Alex Smith">
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Project</label>
            <div class="control">
              <input class="input" type="text" placeholder="e.g Alex Smith">
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Email</label>
            <div class="control">
              <input class="input" type="text" placeholder="e.g Alex Smith">
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Tax</label>
            <div class="select">
              <select v-model="estimate.taxId">
                <option selected>Select Tax</option>
                <option v-for="tax in taxes">{{tax.name}}</option>
                <option>No tax</option>
              </select>
            </div>
          </div>
        </div>

      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Client Address</label>
            <div class="control">
              <textarea class="textarea" placeholder="Textarea"></textarea></div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Billing Address</label>
            <div class="control">
              <textarea class="textarea" placeholder="Textarea"></textarea></div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Estimate Date</label>
            <div class="control">
              <DatePicker
                  v-model="estimate.estimateDate">
              </DatePicker>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Expiry Date</label>
            <div class="control">
              <DatePicker
                  v-model="estimate.expiryDate">
              </DatePicker>
            </div>
          </div>
        </div>

      </div>
    </form>
    <div class="card mt-3 pr-0 pl-0">
      <div class="card-content">
        <table class="table is-hoverable is-fullwidth">
          <thead>
          <tr>
            <th>#</th>
            <th>Item</th>
            <th>Description</th>
            <th>Unit Cost</th>
            <th>Qty</th>
            <th>Amount</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(estimateItem ,index) in estimateItems" :key="index">
            <td>
              {{ index + 1 }}
            </td>
            <td>
              <div class="field">
                <div class="control">
                  <input
                      class="input"
                      v-model="estimateItem.name"
                      placeholder="Textarea">

                  </input></div>
              </div>
            </td>
            <td>
              <div class="field">
                <div class="control">
                  <input
                      class="input"
                      v-model="estimateItem.description"
                      placeholder="Textarea">
                  </input>
                </div>
              </div>
            </td>
            <td>
              <div class="field">
                <div class="control">
                  <InputNumber
                      :controls="false"
                      v-model="estimateItem.unitCost">
                  </InputNumber>
                </div>
              </div>
            </td>
            <td>
              <div class="field">
                <div class="control">
                  <InputNumber
                      :min="1"
                      v-model="estimateItem.qty">
                  </InputNumber>
                </div>
              </div>
            </td>
            <td>
              <div class="field">
                <div class="control">
                  <input
                      class="input"
                      placeholder="Textarea">
                  </input>
                  <div class="estimate-remove-btn has-text-danger">
                    <i class="fa fa-trash"></i>
                  </div>
                </div>
              </div>
            </td>


          </tr>
          </tbody>
        </table>
        <div class="flex justify-end">
          <button @click="addEstimateItemRow" class="button">
				<span class="icon">
          <i class="fa fa-plus-circle mr-1"></i>
				</span>
          </button>
        </div>
      </div>
    </div>
    <div class="card mt-3 p-8">
    </div>
    <div class="mt-3">
      <div class="field">
        <div class="control">
          <label class="label">Other Information</label>
          <textarea
              class="textarea"
              placeholder="Textarea">
          </textarea>
        </div>
      </div>
    </div>
    <div class="mt-3 pb-5 flex justify-center">
      <div class="mr-2">
        <button class="button is-primary is-rounded">Save and Send</button>
      </div>
      <div class="ml-2">
        <button class="button is-primary is-rounded">Save</button>
      </div>
    </div>
  </div>
</template>
<script>
import {Message, DatePicker, InputNumber} from "element-ui"
import common_mixin from "../../../mixins/common_mixin";

export default {
  components: {
    DatePicker,
    InputNumber
  },
  mixins: [common_mixin],
  data() {
    return {
      taxes: [],
      estimate: {
        estimateItems: [
          {}
        ]
      }
    }
  },
  computed: {
    estimateItems() {
      return this.estimate.estimateItems;
    }
  },
  created() {
    this.getTaxes();
  },
  methods: {
    addEstimateItemRow() {
      this.estimate.estimateItems.push({})
    },
    createEstimate() {
      axios.post("/api/estimates",
          this.estimate).then(resp => {
        Message.success("Estimate successfully created")
      }, error => {
        Message.error("There was problem estimate");
        if (error.response.status == 400) {
          this.errors = error.response.data;
        }
      })
    },
    getTaxes() {
      axios.get("/api/taxes/all").then(resp => {
        this.taxes = resp.data;
      }, error => {
        console.log("Error fetching taxes  data in EstimateCreateForm")
      })
    }
  }

}
</script>
<style scoped lang="scss">
.estimate-remove-btn {
  position: absolute;
  right: -1rem;
  top: 0.5rem;
}
</style>