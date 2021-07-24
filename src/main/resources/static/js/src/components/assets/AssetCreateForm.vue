<template>
  <div>
    <form>
      <div class="has-text-centered m-3">
        <h1 class="has-text-black"><b>Add Asset</b></h1>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Asset Name<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="asset.name"
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
            <label class="label">Asset ID<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  @input="clearFieldError('assetId')"
                  class="input"
                  type="text"
                  v-model="asset.assetId">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['assetId']">
						{{ errors['assetId'][0] }}
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
                  v-model="asset.purchaseDate"
                  @input="clearFieldError('purchaseDate')"
                  class="datepicker">
              </DatePicker>
              <span class="mb-2 has-text-danger" v-if="errors['purchaseDate']">
						{{ errors['purchaseDate'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Purchase From<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  @input="clearFieldError('purchasedFrom')"
                  class="input"
                  type="text"
                  v-model="asset.purchasedFrom">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['purchasedFrom']">
						{{ errors['purchasedFrom'][0] }}
					</span>
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Manufacturer<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="asset.manufacturer"
                  @input="clearFieldError('manufacturer')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['manufacturer']">
						{{ errors['manufacturer'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Model<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  @input="clearFieldError('model')"
                  class="input"
                  type="text"
                  v-model="asset.model">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['model']">
						{{ errors['model'][0] }}
					</span>
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Serial Number<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="asset.serialNumber"
                  @input="clearFieldError('serialNumber')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['serialNumber']">
						{{ errors['serialNumber'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Supplier<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  @input="clearFieldError('supplier')"
                  class="input"
                  type="text"
                  v-model="asset.supplier">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['supplier']">
						{{ errors['supplier'][0] }}
					</span>
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Condition<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="asset.condition"
                  @input="clearFieldError('condition')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['condition']">
						{{ errors['condition'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Warranty<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  @input="clearFieldError('warrantyInMonths')"
                  class="input"
                  type="text"
                  v-model="asset.warrantyInMonths">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['warrantyInMonths']">
						{{ errors['warrantyInMonths'][0] }}
					</span>
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Value<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="asset.value"
                  @input="clearFieldError('value')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['value']">
						{{ errors['value'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Asset User<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  @input="clearFieldError('assetUserId')"
                  class="input"
                  type="text"
                  v-model="asset.assetUserId">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['assetUserId']">
						{{ errors['assetUserId'][0] }}
					</span>
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Description<span><sup>*</sup></span></label>
            <div class="control">
              <textarea
                  v-model="asset.description"
                  @input="clearFieldError('description')"
                  class="textarea"
                  type="text"></textarea>
              <span class="mb-2 has-text-danger" v-if="errors['description']">
						{{ errors['description'][0] }}
					</span>
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column is-6">
          <div class="field">
            <label class="label">Status<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="asset.status"
                  @input="clearFieldError('status')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['status']">
						{{ errors['status'][0] }}
					</span>
            </div>
          </div>
        </div>
      </div>


      <div class="flex justify-center m-3">
        <button

            :class="{'is-loading':loading}"
            :disabled="disableSubmitButton"
            @click.prevent.stop="createAsset"
            class="button is-rounded"
            type="submit">Submit
        </button>
      </div>
    </form>
  </div>
</template>
<script>
import common_mixin from "../../mixins/common_mixin";
import {DatePicker, Message} from "element-ui"

export default {
  components: {
    DatePicker
  },
  mixins: [common_mixin],
  data() {
    return {
      asset: {},
      loading: false
    }
  },
  methods: {
    createAsset() {
      this.loading = true
      axios.post("/api/assets",
          this.asset).then(resp => {
        this.loading = false;
        Message.success("Asset successfully created");
        this.$emit("createSuccessful")
      }, error => {
        this.loading = false;
        if (error.response.status == 400) {
          this.errors = error.response.data;
        }
      })

    }

  },
  computed: {
    disableSubmitButton() {
      return this.loading;
    }
  }

}
</script>