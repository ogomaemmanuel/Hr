<template>
  <ModalTemplate @modalClosed="$emit('modalClosed')">
    <div slot="modal-content">
      <form>
      <div class="has-text-centered m-3">
        <h1 class="has-text-black"><b>Add New Training</b></h1>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">Training Type<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="training.firstName"
                  @input="clearFieldError('firstName')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['firstName']">
						{{ errors['firstName'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Trainer<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="training.lastName"
                  @input="clearFieldError('lastName')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['lastName']">
						{{ errors['lastName'][0] }}
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
                  v-model="training.role"

                  @input="clearFieldError('role')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['role']">
						{{ errors['role'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">Training Cost<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="training.email"
                  @input="clearFieldError('email')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['email']">
						{{ errors['email'][0] }}
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
                  v-model="training.phone"

                  @input="clearFieldError('phone')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['phone']">
						{{ errors['phone'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label">End Date<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="training.email"
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
                    v-model="training.email"
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

export default {
  components: {
    ModalTemplate
  },
  mixins: [common_mixin],
  data() {
    return {
      training: {}
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