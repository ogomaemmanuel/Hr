<template>
  <ModalTemplate @modalClosed="$emit('modalClosed')">
    <div slot="modal-content">
      <form>
        <div class="has-text-centered m-3">
          <h1 class="has-text-black"><b>New File</b></h1>
        </div>

        <b-field class="is-fullwidth">
          <b-upload class="file-upload is-fullwidth" v-model="dropFiles"
                    multiple
                    drag-drop>
            <section class="section">
              <div class="content has-text-centered">
                <p>
                  <b-icon
                      icon="upload"
                      size="is-large">
                  </b-icon>
                </p>
                <p>Drop your files here or click to upload</p>
              </div>
            </section>
          </b-upload>
        </b-field>
        <div class="field">
          <label class="label">Description</label>
          <div class="control">
            <input
                v-model="file.name"
                @input="clearFieldError('name')"
                class="input"
                type="text">
            <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{ errors['name'][0] }}
					</span>
          </div>
        </div>
        <div class="flex justify-center m-3">
          <button
              :class="{'is-loading':loading}"
              :disabled="disableSubmitButton"
              @click.prevent.stop="createFile"
              class="button  is-rounded"
              type="submit">Submit
          </button>
        </div>
      </form>
    </div>
  </ModalTemplate>
</template>
<script>
import common_mixin from "../../mixins/common_mixin";
import ModalTemplate from "../common/ModalTemplate";

export default {
  components: {
    ModalTemplate
  },
  mixins: [common_mixin],
  data() {
    return {
      loading: false,
      dropFiles: {},
      file: {
        name: "",
        description: ""
      }
    }
  },
  methods: {
    createFile() {
      let formData = this.createFormData(this.file);
      this.axios.post("/api/files", formData).then(resp => {

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
<style scoped lang="scss">
.is-fullwidth /deep/ .upload-draggable{
  min-width: 100%;
}
.is-fullwidth /deep/ label {
    min-width: 100%;
}
</style>