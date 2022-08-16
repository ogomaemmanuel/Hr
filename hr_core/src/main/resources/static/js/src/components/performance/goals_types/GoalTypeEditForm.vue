<template>
  <ModalTemplate @modalClosed="$emit('modalClosed')">
    <div slot="modal-content">
      <form>
        <div class="has-text-centered m-3">
          <h1 class="has-text-black"><b>Update Goal Type</b></h1>
        </div>
        <div class="field">
          <label class="label">Name<span><sup>*</sup></span></label>
          <div class="control">
            <input
                v-model="goalType.type"
                @input="clearFieldError('type')"
                class="input"
                type="text">
            <span class="mb-2 has-text-danger" v-if="errors['type']">
						{{ errors['type'][0] }}
					</span>
          </div>
        </div>
        <div class="field">
          <label class="label">Description<span><sup>*</sup></span></label>
          <div class="control">
            <input
                v-model="goalType.description"
                @input="clearFieldError('description')"
                class="input"
                type="text">
            <span class="mb-2 has-text-danger" v-if="errors['description']">
						{{ errors['destination'][0] }}
					</span>
          </div>
        </div>
        <div class="field">
          <label class="label">Status<span><sup>*</sup></span></label>
          <div class="control">
            <input
                v-model="goalType.status"
                @input="clearFieldError('status')"
                class="input"
                type="text">
            <span class="mb-2 has-text-danger" v-if="errors['status']">
						{{ errors['status'][0] }}
					</span>
          </div>
        </div>
        <div class="flex justify-center m-3">
          <button

              :class="{'is-loading':loading}"
              :disabled="disableSubmitButton"
              @click.prevent.stop="updateGoalType"
              class="button  is-rounded"
              type="submit">Submit
          </button>
        </div>
      </form>
    </div>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../../common/ModalTemplate";
import common_mixin from "../../../mixins/common_mixin";
import {Message} from "element-ui"

export default {
  props: {
    id: {
      required: true
    }
  },
  mixins: [common_mixin],
  components: {
    ModalTemplate
  },
  data() {
    return {
      goalType: {
        type: "",
        description: ""
      }
    }
  },
  created() {
    this.getGoalTypeById();
  },
  methods: {
    getGoalTypeById() {
      let vm = this;
      axios.get(`/api/goal-types/${this.id}`).then(resp => {
        this.goalType = {...vm.goalType,...resp.data};
      })
    },
    updateGoalType() {
      axios.put(`/api/goal-types/${this.id}`, this.goalType)
          .then(resp => {
            Message.success("Goal Type successfully updated")
            this.$emit("updateSuccessful")
          })
    }
  }
}
</script>
<style lang="scss" scoped>

</style>