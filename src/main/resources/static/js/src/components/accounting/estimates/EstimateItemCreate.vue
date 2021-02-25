<template>
  <tr>
    <td>
      {{ index + 1 }}
    </td>
    <td>
      <div class="field">
        <div class="control">
          <input
              class="input"
              v-model="estimateItem.name">
          </input>
          <span class="mb-2 has-text-danger"
                v-if="errors[`items[${index}].name`]">
             {{ errors[`items[${index}].name`][0] }}
          </span>
        </div>
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
          <span class="mb-2 has-text-danger"
                v-if="errors[`items[${index}].description`]">
             {{ errors[`items[${index}].description`][0] }}
          </span>
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
          <span class="mb-2 has-text-danger"
                v-if="errors[`items[${index}].unitCost`]">
             {{ errors[`items[${index}].unitCost`][0] }}
          </span>
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
          <span class="mb-2 has-text-danger"
                v-if="errors[`items[${index}].quantity`]">
             {{ errors[`items[${index}].quantity`][0] }}
          </span>
        </div>
      </div>
    </td>
    <td>
      <div class="field">
        <div class="control is-relative">
          <input
              class="input"
              placeholder="Textarea">
          </input>
          <div
              @click="removeEstimateItem(index)"
              class="estimate-remove-btn has-text-danger">
            <i class="fa fa-trash"></i>
          </div>
        </div>
      </div>
    </td>


  </tr>
</template>
<script>
import common_mixin from "../../../mixins/common_mixin";
import ClientSelectInput from "../../common/ClientSelectInput";
import {Message, DatePicker, InputNumber} from "element-ui"

export default {
  components: {
    ClientSelectInput,
    InputNumber,
    DatePicker
  },
  mixins: [common_mixin],
  props: {
    estimateItem: {
      required: true
    },
    index: {},
    errorMessages: {}
  },
  methods: {
    removeEstimateItem(index) {
     this.$emit("removedItem",index)
    },
  },
  watch: {
    errorMessages(val) {
      this.errors = val;
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