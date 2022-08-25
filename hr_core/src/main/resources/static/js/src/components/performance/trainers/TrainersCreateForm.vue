<template>
  <ModalTemplate @modalClosed="$emit('modalClosed')">
    <div slot="modal-content">
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label">First Name <span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="trainer.firstName"

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
            <label class="label">Last Name <span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="trainer.lastName"
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
            <label class="label">Role<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="trainer.role"

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
            <label class="label">Email<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="trainer.email"
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
            <label class="label">Phone<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="trainer.phone"

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
            <label class="label">Status<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="trainer.email"
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
                  v-model="trainer.description"
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
      <div class="flex justify-center m-3">
        <button
            :class="{'is-loading':loading}"
            :disabled="disableSubmitButton"
            @click.prevent.stop="createTrainer"
            class="button  is-rounded"
            type="submit">Submit
        </button>
      </div>
    </div>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../../common/ModalTemplate";
import common_mixin from "../../../mixins/common_mixin";
import {Message} from "element-ui";

export default {
  mixins: [common_mixin],
  components: {
    ModalTemplate
  },
  data() {
    return {
      loading: false,
      trainer: {}
    }
  },
  methods: {
    createTrainer() {
      let vm = this;
      axios.post("/api/trainers", this.trainer).then(resp => {
        Message.success("Trainer successfully created");
        vm.$emit("createSuccessful")
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