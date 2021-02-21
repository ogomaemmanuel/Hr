<template>
  <div>
    <form>
      <div class="has-text-centered m-3">
        <h1 class="has-text-black"><b>Add Policy</b></h1>
      </div>
      <div class="field">
        <label class="label"> Name <span><sup>*</sup></span></label>
        <div class="control">
          <input
              v-model="policy.name"
              @input="clearFieldError('name')"
              class="input"
              type="text">
          <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{ errors['name'][0] }}
					</span>
        </div>
      </div>
      <div class="field">
        <label class="label"> Description <span><sup>*</sup></span></label>
        <div class="control">
          <textarea
              v-model="policy.description"
              @input="clearFieldError('description')"
              class="textarea"
              type="text">
          </textarea>
          <span class="mb-2 has-text-danger" v-if="errors['description']">
						{{ errors['description'][0] }}
					</span>
        </div>
      </div>
      <DepartmentSelectInput
          @input="clearFieldError('departmentId')"
          v-model="policy.departmentId">
        <span slot="errors" class="mb-2 has-text-danger" v-if="errors['departmentId']">
						{{ errors['departmentId'][0] }}
					</span>
      </DepartmentSelectInput>
      <div class="field">
        <div class="control">
          <label class="label">Upload File<span><sup>*</sup></span></label>
          <div class="file has-name is-fullwidth">
            <label class="file-label">
              <input
                  @change="onFileChange"
                  class="file-input" type="file" name="resume">
              <span class="file-cta">
      <span class="file-icon">
        <i class="fa fa-upload"></i>
      </span>
      <span class="file-label">
        Browse…
      </span>
    </span>
              <span class="file-name">
      {{ fileName }}
    </span>
            </label>
          </div>
        </div>
      </div>
      <div class="flex justify-center m-3">
        <button

            :class="{'is-loading':loading}"
            :disabled="disableSubmitButton"
            @click.prevent.stop="createPolicy"
            class="button  is-rounded"
            type="submit">Submit
        </button>
      </div>
    </form>
  </div>
</template>
<script>
import common_mixin from "../../../mixins/common_mixin";
import DepartmentSelectInput from "../../common/DepartmentSelectInput";
import {Message} from "element-ui"

export default {
  mixins: [common_mixin],
  components: {
    DepartmentSelectInput,

  },
  data() {
    return {
      policy: {},
      loading: false,
      fileName:""
    }
  },
  methods: {
    onFileChange(e) {
      const file = e.target.files[0];
      this.policy.attachment = file;
      this.fileName = file.name;
    },
    createPolicy() {
      this.loading = true;
      let request=this.createFormData(this.policy);
      axios.post("/api/policies", request).then(resp => {
        this.loading = false;
        Message.success("Policy successfully created");
      }, error => {
        this.loading = false;
        if (error.response.status == 400) {
          this.errors = error.response.data
        } else {
          Message.error("There was an error creating policy")
        }
      })
    }
  },
  computed: {
    disableSubmitButton() {
      return this.loading;
    }
  }
}
</script>