<template>
  <ModalTemplate @modalClosed="$emit('modalClosed')">
    <div slot="modal-content">
      <form>
        <div class="has-text-centered m-3">
          <h1 class="has-text-black"><b>Add New Training</b></h1>
        </div>
        <div class="columns">
          <div class="column">
<!--            <div class="field">-->
<!--              <label class="label">Training Type<span><sup>*</sup></span></label>-->
<!--              <div class="control">-->
<!--                <input-->
<!--                    v-model="training.trainingTypeId"-->
<!--                    @input="clearFieldError('trainingTypeId')"-->
<!--                    class="input"-->
<!--                    type="text">-->
<!--                <span class="mb-2 has-text-danger" v-if="errors['trainingTypeId']">-->
<!--						{{ errors['trainingTypeId'][0] }}-->
<!--					</span>-->
<!--              </div>-->
<!--            </div>-->

            <TrainingTypeSelectInput></TrainingTypeSelectInput>
          </div>
          <div class="column">
            <div class="field">
              <label class="label">Trainer<span><sup>*</sup></span></label>
              <div class="control">
                <input
                    v-model="training.trainerId"
                    @input="clearFieldError('trainerId')"
                    class="input"
                    type="text">
                <span class="mb-2 has-text-danger" v-if="errors['trainerId']">
						{{ errors['trainerId'][0] }}
					</span>
              </div>
            </div>
          </div>
        </div>
        <div class="columns">
          <div class="column">
            <div class="field">
              <label class="label">Employees<span><sup>*</sup></span></label>
              <div class="control">
                <input
                    v-model="training.employeeId"

                    @input="clearFieldError('employeeId')"
                    class="input"
                    type="text">
                <span class="mb-2 has-text-danger" v-if="errors['employeeId']">
						{{ errors['employeeId'][0] }}
					</span>
              </div>
            </div>
          </div>
          <div class="column">
            <div class="field">
              <label class="label">Training Cost<span><sup>*</sup></span></label>
              <div class="control">
                <input
                    v-model="training.cost"
                    @input="clearFieldError('cost')"
                    class="input"
                    type="text">
                <span class="mb-2 has-text-danger" v-if="errors['cost']">
						{{ errors['cost'][0] }}
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
                    v-model="training.startDate"

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
                    v-model="training.endDate"
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
        <div class="columns">
          <div class="column">
            <div class="field">
              <label class="label">Description<span><sup>*</sup></span></label>
              <div class="control">
              <textarea
                  v-model="training.description"
                  @input="clearFieldError('description')"
                  class="textarea"
                  type="text">
              </textarea>
                <span class="mb-2 has-text-danger" v-if="errors['description']">
						{{ errors['description'][0] }}
					</span>
              </div>
            </div>
          </div>
        </div>

        <div class="columns">
          <div class="column">
            <div class="field">
              <label class="label">Status<span><sup>*</sup></span></label>
              <div class="control">
                <input
                    v-model="training.status"
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
              @click.prevent.stop="createTraining"
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
import TrainingTypeSelectInput from "./TrainingTypeSelectInput";
export default {
  components: {
    ModalTemplate,
    TrainingTypeSelectInput
  },
  mixins: [common_mixin],
  data() {
    return {
      loading: false,
      training: {
        employeeId: "",
        cost: "",
        startDate: "",
        endDate: "",
        trainerId: "",
        trainingTypeId: "",
        description:""
      }
    }
  },
  methods: {
    createTraining() {
      axios.post("/api/training", this.training).then(resp => {
        Message.success("Training successfully created")
        this.$emit("createSuccessful")
      }, error => {

      })
    }
  }, computed: {
    disableSubmitButton() {
      return false;
    }
  }
}
</script>