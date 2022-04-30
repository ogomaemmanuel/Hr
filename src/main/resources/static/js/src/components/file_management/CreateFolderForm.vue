<template>
  <ModalTemplate>
    <div slot="modal-content">
      <form>
        <div class="has-text-centered m-3">
          <h1 class="has-text-black"><b>New Folder</b></h1>
        </div>
        <div class="field">
          <label class="label">Name<span><sup>*</sup></span></label>
          <div class="control">
            <input
                v-model="folder.name"
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
              @click.prevent.stop="createFolder"
              class="button  is-rounded"
              type="submit">Submit
          </button>
        </div>
      </form>
    </div>
  </ModalTemplate>
</template>
<script>
import ModalTemplate from "../common/ModalTemplate";
import common_mixin from "../../mixins/common_mixin";
import {Message} from "element-ui";

export default {
  mixins: [common_mixin],
  components: {
    ModalTemplate
  },
  data() {
    return {
      isLoading: false,
      folder: {
        name: "",
        type: "FOLDER",
      }
    }
  },
  methods: {
    createFolder() {
      axios.post("/api/files", this.folder).then(resp => {
        Message.success("folder created")
      }, error => {

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