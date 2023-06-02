<template>
  <ModalTemplate @modalClosed="$emit('modalClosed')">
    <div slot="modal-content">
      <form>
        <div class="has-text-centered m-3">
          <h1 class="has-text-black"><b>New File</b></h1>
        </div>

        <b-field class="is-fullwidth">
          <b-upload class="file-upload is-fullwidth" v-model="dropFiles"
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
        <div class="tags">
      <span v-if="dropFiles.name"  class="tag is-primary">
        {{ dropFiles.name }}
        <button class="delete is-small" type="button"></button>
      </span>
        </div>
        <div class="field">
          <label class="label">Description</label>
          <div class="control">
            <input
                :native="true"
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
import {Message} from "element-ui";

export default {
  components: {
    ModalTemplate
  },
  props: {
    parentId: {
      default: null
    }
  },
  mixins: [common_mixin],
  data() {
    return {
      loading: false,
      dropFiles: {},
      file: {
        name: "",
        description: "",
        type: "FILE"
      }
    }
  },
  methods: {
    createFile() {
      this.file.name=this.dropFiles.name
      this.file.attachment = this.dropFiles;
      this.file.parentId = this.parentId;
      let formData = this.createFormData(this.file);
      axios.post("/api/files", formData).then(resp => {
        Message.success("folder created")
        this.$emit("createSuccess");
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
.is-fullwidth ::v-deep .upload-draggable {
  min-width: 100%;
}

.is-fullwidth ::v-deep label {
  min-width: 100%;
}
</style>