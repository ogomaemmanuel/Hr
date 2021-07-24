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
                  @input="clearFieldError('date')"
                  class="input"
                  type="text"
                  v-model="asset.date">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['date']">
						{{ errors['date'][0] }}
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
            <label class="label">Purchase From<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  @input="clearFieldError('date')"
                  class="input"
                  type="text"
                  v-model="asset.date">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['date']">
						{{ errors['date'][0] }}
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
            <label class="label">Model<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  @input="clearFieldError('date')"
                  class="input"
                  type="text"
                  v-model="asset.date">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['date']">
						{{ errors['date'][0] }}
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
            <label class="label">Supplier<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  @input="clearFieldError('date')"
                  class="input"
                  type="text"
                  v-model="asset.date">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['date']">
						{{ errors['date'][0] }}
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
            <label class="label">Warranty<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  @input="clearFieldError('date')"
                  class="input"
                  type="text"
                  v-model="asset.date">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['date']">
						{{ errors['date'][0] }}
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
            <label class="label">Asset User<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  @input="clearFieldError('date')"
                  class="input"
                  type="text"
                  v-model="asset.date">
              </input>
              <span class="mb-2 has-text-danger" v-if="errors['date']">
						{{ errors['date'][0] }}
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
                  v-model="asset.name"
                  @input="clearFieldError('name')"
                  class="textarea"
                  type="text"></textarea>
              <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{ errors['name'][0] }}
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
export default {
  mixins: [common_mixin],
  data() {
    return {
      asset: {}
    }
  },
  methods: {
    createAsset() {

    },
    disableSubmitButton() {
      return false
    }
  }

}
</script>