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
    addEstimateItemRow() {

    },
    removeEstimateItem(index) {

    },
  },
  computed: {},
}
</script>
<style scoped lang="scss">
  .estimate-remove-btn {
     position: absolute;
      right: -1rem;
      top: 0.5rem;
}
</style>