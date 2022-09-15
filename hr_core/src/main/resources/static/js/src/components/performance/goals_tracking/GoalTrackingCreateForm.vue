<template>
  <ModalTemplate @modalClosed="$emit(`modalClosed`)">
    <div slot="modal-content">
      <form>
        <div class="has-text-centered m-3">
          <h1 class="has-text-black"><b>Add Goal Tracking</b></h1>
        </div>
        <div class="field">
          <label class="label">Name<span><sup>*</sup></span></label>
          <div class="control">
            <input
                v-model="goalTracking.goalTypeId"
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
                v-model="goalTracking.description"
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
                v-model="goalTracking.status"
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
              @click.prevent.stop="createGoalTracking"
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
  mixins: [common_mixin],
  components: {
    ModalTemplate
  },
  data() {
    return {
      loading: false,
      goalTracking: {}
    }
  },

  methods: {
    createGoalTracking() {
      axios.post("/api/goal-tracking",
          this.goalTracking).then(resp => {
        Message.success("Goal Tracking successfully created")
      }, error => {

      })
    }
  },

  computed: {
    disableSubmitButton() {
      return false
    }
  }

}
</script>