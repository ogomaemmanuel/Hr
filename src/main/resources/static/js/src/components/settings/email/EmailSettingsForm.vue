<template>
  <div class="card animated preFadeInUp fadeInUp">
    <div class="card-content">
      <h1 class="has-text-weight-bold flex justify-center is-size-4 pb-4">SMTP Settings</h1>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label ">Email From Address <span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="setting.address"
                  @input="clearFieldError('address')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['address']">
						        {{ errors['address'][0] }}
					        </span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label ">Email From Name <span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="setting.name"
                  @input="clearFieldError('name')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['name']">
						        {{ errors['name'][0] }}
					        </span>
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label ">SMTP Host <span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="setting.smtpHost"
                  @input="clearFieldError('smtpHost')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['smtpHost']">
						        {{ errors['smtpHost'][0] }}
					        </span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label ">SMTP Port <span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="setting.smtpPort"
                  @input="clearFieldError('smtpPort')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['smtpPort']">
						        {{ errors['smtpPort'][0] }}
					        </span>
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label ">SMTP User <span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="setting.smtpUser"
                  @input="clearFieldError('smtpUser')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['smtpUser']">
						        {{ errors['smtpUser'][0] }}
					        </span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label ">SMTP Password <span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="setting.smtpPassword"
                  @input="clearFieldError('smtpPassword')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['smtpPassword']">
						        {{ errors['smtpPassword'][0] }}
					        </span>
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label "><span>Business Entity Type<sup>*</sup></span></label>
            <div class="control">
              <Select
                  class="form-control is-large w-full"
                  @change="clearFieldError('smtpSecurity')"
                  v-model="setting.smtpSecurity"
                  required
                  placeholder="Select Security"
              >
                <Option value="" label="None" class="form-control"></Option>
                <Option value="SSL" label="SSL" class="form-control"></Option>
                <Option value="TLS" label="TLS" class="form-control"></Option>
              </Select>
              <span class="mb-2 has-text-danger" v-if="errors['smtpSecurity']">
						{{ errors['smtpSecurity'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label ">SMTP Domain Authentication <span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="setting.domainAuthentication"
                  @input="clearFieldError('domainAuthentication')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['domainAuthentication']">
						        {{ errors['domainAuthentication'][0] }}
					        </span>
            </div>
          </div>
        </div>
      </div>
      <div class="flex justify-end">
        <button
            :disabled="disableSubmitButton"
            @click.prevent="submit"
            :class="{'is-loading':isLoading}"
            class="button is-rounded p-2">
          Submit
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import CommonMixin from "../../../mixins/common_mixin"
import {DatePicker, Select, Option, Message} from "element-ui"

export default {
  name: "EmailSettingsForm",
  components: {
    Select,
    Option
  },
  mixins: [CommonMixin],
  data() {
    return {
      setting: {
        id: "",
        name: "",
        address: "",
        smtpHost: "",
        smtpPort: "",
        smtpUser: "",
        smtpPassword: "",
        smtpSecurity: "",
        domainAuthentication: "",
      },
      isLoading: false
    }
  },
  created() {
    this.getSettings();
  },
  computed: {
    disableSubmitButton(){
      let vm = this.setting;
      return vm.name.length <= 0 || vm.address.length <= 0 ||vm.smtpHost.length <= 0
          || vm.smtpPort.length <= 0 || vm.smtpUser.length <= 0 ||vm.smtpPassword.length <= 0
          || vm.domainAuthentication.length <= 0 || this.isLoading
    }
  },
  methods: {
    getSettings(){
      let vm = this;
      axios.get(`/api/settings/email`).then(resp => {
        if(resp.data.length > 0){
          vm.setting = resp.data;
        }
      })
    },
    submit(){
      let vm = this;
      vm.isLoading = true;
      axios.post(`/api/settings/email/update`,
          vm.setting).then(resp => {
        vm.isLoading = false;
        if (resp.data.status === "00") {
          Message.success(resp.data.msg);
        } else {
          Message.error(resp.data.msg);
        }
        vm.getSettings();
      }, error => {
        if (error.response.status === 400) {
          vm.isLoading = false;
          this.errors = error.response.data;
        }else{
          vm.isLoading = false;
          Message.error("Something went wrong. Contact Admin");
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.card-content{
  padding: 1.5rem 10rem;
}
</style>