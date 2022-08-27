<template>
  <ModalTemplate @modalClosed="$emit('modalClosed')">
    <div slot="modal-content">
      <form>
        <div class="has-text-centered m-3">
          <h1 class="has-text-black"><b>Add Training Type</b></h1>
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
              @click.prevent.stop="createTrainingType"
              class="button  is-rounded"
              type="submit">Submit
          </button>
        </div>
      </form>
    </div>
  </ModalTemplate>
</template>
<script>
import {Message} from "element-ui"
import ModalTemplate from "../../common/ModalTemplate";
import common_mixin from "../../../mixins/common_mixin";

export default {
  mixins: [common_mixin],
  components: {
    ModalTemplate
  },
  data() {
    return {
      loading: false,
      trainingType: {
        type: "",
        description: ""
      }
    }
  },
  methods: {
    createTrainingType() {
      axios.post("/api/training-types",
          this.trainingType).then(resp => {
        Message.success("Training Type Successfully Created");
        this.$emit("createSuccessful")
      }, error => {
        if (error.response.status == 400) {
          this.errors = error.response.data;
        }
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