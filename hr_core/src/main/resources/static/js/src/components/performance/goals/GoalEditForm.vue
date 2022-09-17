<template>
  <ModalTemplate @modalClosed="$emit(`modalClosed`)">
    <div slot="modal-content">
      <form>
        <div class="has-text-centered m-3">
          <h1 class="has-text-black"><b>Update Goal</b></h1>
        </div>
        <div class="field">
          <label class="label">Goal Type<span><sup>*</sup></span></label>
          <div class="control">
            <input
                v-model="goal.goalTypeId"
                @input="clearFieldError('goalTypeID')"
                class="input"
                type="text">
            <span class="mb-2 has-text-danger" v-if="errors['goalTypeID']">
						{{ errors['goalTypeID'][0] }}
					</span>
          </div>
        </div>

        <div class="columns">
          <div class="column">
            <div class="field">
              <label class="label">Subject<span><sup>*</sup></span></label>
              <div class="control">
                <input
                    v-model="goal.subject"
                    @input="clearFieldError('subject')"
                    class="input"
                    type="text">
                <span class="mb-2 has-text-danger" v-if="errors['subject']">
						{{ errors['subject'][0] }}
					</span>
              </div>
            </div>
          </div>
          <div class="column">
            <div class="field">
              <label class="label">Target Achievement<span><sup>*</sup></span></label>
              <div class="control">
                <input
                    v-model="goal.targetAchievement"
                    @input="clearFieldError('targetAchievement')"
                    class="input"
                    type="text">
                <span class="mb-2 has-text-danger" v-if="errors['targetAchievement']">
						{{ errors['targetAchievement'][0] }}
					</span>
              </div>
            </div>
          </div>
        </div>
        <div class="columns">
          <div class="column">
            <div class="field">
              <label class="label">Start Date<span><sup>*</sup></span></label>
              <div class="control">
                <input
                    v-model="goal.startDate"
                    @input="clearFieldError('startDate')"
                    class="input"
                    type="date">
                <span class="mb-2 has-text-danger" v-if="errors['startDate']">
						{{ errors['startDate'][0] }}
					</span>
              </div>
            </div>
          </div>
          <div class="column">
            <div class="field">
              <label class="label">End Date<span><sup>*</sup></span></label>
              <div class="control">
                <input
                    v-model="goal.endDate"
                    @input="clearFieldError('endDate')"
                    class="input"
                    type="date">
                <span class="mb-2 has-text-danger" v-if="errors['endDate']">
						{{ errors['endDate'][0] }}
					</span>
              </div>
            </div>
          </div>
        </div>
        <div class="field">
          <label class="label">Description<span><sup>*</sup></span></label>
          <div class="control">
            <textarea
                @input="clearFieldError('description')"
                v-model="goal.description"
                class="textarea"></textarea>
          </div>

        </div>
        <div class="field">
          <label class="label">Status<span><sup>*</sup></span></label>
          <div class="control">
            <input
                @input="clearFieldError('status')"
                v-model="goal.status"
                class="input"></input>
          </div>

        </div>

        <div class="flex justify-center m-3">
          <button
              :class="{'is-loading':loading}"
              :disabled="disableSubmitButton"
              @click.prevent.stop="updateGoalTracking"
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
      loading: false,
      goal: {}
    }
  },
  created() {
    this.getGoalByID();
  },
  methods: {
    getGoalByID() {
      axios.get(`/api/goals/${this.id}`).then(resp => {
        this.goal = resp.data;
      })
    },
    updateGoalTracking() {
      axios.put("/api/goals",
          this.goal).then(resp => {
        Message.success("Goal successfully created");
        this.$emit("updateSuccessful")
      }, error => {
        if (error.response.status == 400) {
          this.errors = error.response.data;
          return;
        }
        Message.error("Error updating goal")
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