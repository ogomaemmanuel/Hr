<template>
  <div>
    <form>
      <div class="has-text-centered m-3">
        <h1 class="has-text-black"><b>Update Policy</b></h1>
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
            @click.prevent.stop="updatePolicy"
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
  components:{
    DepartmentSelectInput
  },
  mixins: [common_mixin],
  props: {
    id: {
      required: true
    }
  },
  data() {
    return {
      policy: {},
      loading: false,
      fileName:""
    }
  },
  created() {
    this.getPolicy();
  },
  computed: {
    disableSubmitButton() {
      return this.loading;
    }
  },
  methods: {
    onFileChange(e) {
      const file = e.target.files[0];
      this.policy.attachment = file;
      this.fileName = file.name;
    },
    updatePolicy() {
      let request = this.createFormData(this.policy);
      axios.put(`/api/policies/${this.id}`,
          request).then(resp => {
        Message.success("Policy successfully updated")
        this.$emit("updateSuccessful");
      }, error => {
        if (error.response.status == 400) {
          this.errors = error.response.data;
        } else {
          Message.error("There was an error updating policy")
        }
      })

    },
    getPolicy() {
      this.loading = true
      axios.get(`/api/policies/${this.id}`).then(resp => {
        this.loading = false
        this.policy = resp.data;
      }, error => {
        this.loading = false;
        if (error.response.status = 400) {
          this.errors = error.response.data;
        }
      })
    }
  }
}
</script>