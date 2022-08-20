<template>
  <ModalTemplate @modalClosed="$emit('modalClosed')">
    <div slot="modal-content">
      <form>
        <div class="has-text-centered m-3">
          <h1 class="has-text-weight-bold modal-heading"><b>Update Training Type</b></h1>
        </div>
        <div class="field">
          <label class="label">Name<span><sup>*</sup></span></label>
          <div class="control">
            <input
                v-model="trainingType.type"
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
            <textarea
                v-model="trainingType.description"
                @input="clearFieldError('description')"
                class="textarea"
                type="text"></textarea>
            <span class="mb-2 has-text-danger" v-if="errors['description']">
						{{ errors['description'][0] }}
					</span>
          </div>
        </div>
        <div class="field">
          <label class="label">Status<span><sup>*</sup></span></label>
          <div class="control">
            <input
                v-model="trainingType.status"
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
              @click.prevent.stop="updateTrainingType"
              class="button  is-rounded"
              type="submit">Submit
          </button>
        </div>
      </form>
    </div>
  </ModalTemplate>
</template>
<script>
import common_mixin from "../../../mixins/common_mixin";
import ModalTemplate from "../../common/ModalTemplate";
import {Message} from "element-ui"

export default {
  components: {
    ModalTemplate
  },
  mixins: [common_mixin],
  props: {
    id: {
      required: true
    }
  },
  data() {
    return {
      trainingType: {}
    }
  },
  created() {
    this.getTrainingTypeById();
  },
  methods: {
    getTrainingTypeById() {
      axios.get(`/api/training-types/${this.id}`).then(resp => {
        this.trainingType = resp.data;
      })
    },

    updateTrainingType() {
      axios.put(`/api/training-types/${this.id}`,
          this.trainingType).then(resp => {
        Message.success("Training type update successful");
        this.$emit("updateSuccessful")
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