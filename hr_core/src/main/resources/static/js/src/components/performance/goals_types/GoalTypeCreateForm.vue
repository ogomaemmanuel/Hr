<template>
  <ModalTemplate @modalClosed="$emit('modalClosed')">
    <div slot="modal-content">
      <form>
        <div class="has-text-centered m-3">
          <h1 class="has-text-black"><b>Add Goal Type</b></h1>
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
              @click.prevent.stop="createGoalType"
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
  components: {
    ModalTemplate
  },
  mixins: [common_mixin],
  data() {
    return {
      loading: false,
      goalType: {
        type: "",
        description: "",
        status: ""
      }
    }
  },
  methods: {
    createGoalType() {
      axios.post("/api/goal-types", this.goalType).then(resp => {
        Message.success("Goal Type Successfully created")
        this.$emit("createSuccess")
      }, error => {
        if (error.response.status == 400) {
          this.errors = error.response.data;
        }
      })
    }
  },
  computed: {
    disableSubmitButton() {
      return false;
    }
  }

}
</script>