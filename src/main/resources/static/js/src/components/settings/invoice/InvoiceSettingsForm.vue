<template>
  <div class="card animated preFadeInUp fadeInUp">
    <div class="card-content">
      <h1 class="has-text-weight-bold flex justify-center is-size-4 pb-4">Invoice Settings</h1>
      <div class="field">
        <div class="columns">
        <div class="column">
        <label class="label ">Invoice Prefix <span><sup>*</sup></span></label>
          </div>
        <div class="column">
        <div class="control">
          <input
              v-model="setting.prefix"
              @input="clearFieldError('prefix')"
              class="input"
              type="text">
          <span class="mb-2 has-text-danger" v-if="errors['prefix']">
						        {{ errors['prefix'][0] }}
					        </span>
        </div>
        </div>
          </div>
        <div class="columns">
        <div class="column">
        <label class="label ">Invoice Logo <span><sup>*</sup></span></label>
          </div>
        <div class="column">
        <div class="control">
          <input type="file"
                 ref="logoInput"
                 class="hidden"
                 @input="clearFieldError('logoUrl')"
                 @change="onFileSelected">
          <img class="logo-input border-2"
               :src="logoPreview"
               @click.prevent="$refs.logoInput.click()">
          <span class="has-text-danger" v-if="errors['logoUrl']">
                                            {{ errors['logoUrl'][0] }}</span>
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
import {Message, Option, Select} from "element-ui"

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
        prefix: "",
        logoUrl: null
      },
      logoPreview: "/images/placeholder.jpg",
      isLoading: false
    }
  },
  created() {
    this.getSettings();
  },
  computed: {
    disableSubmitButton(){
      let vm = this.setting;
      return vm.prefix.length <= 0 || vm.logoUrl === null || this.isLoading;
    }
  },
  methods: {
    getSettings(){
      let vm = this;
      axios.get(`/api/settings/invoice`).then(resp => {
        if(resp.data.length > 0){
          vm.setting = resp.data;
        }
      })
    },
    submit(){
      let vm = this;
      let setting = new FormData();
      setting.append("id",vm.setting.id);
      setting.append("prefix",vm.setting.prefix);
      setting.append("logoUrl",vm.setting.logoUrl);
      vm.isLoading = true;
      axios.post(`/api/settings/invoice/update`,
          setting).then(resp => {
        vm.isLoading = false;
        if (resp.data.status === "00") {
          Message.success(resp.data.msg);
        } else {
          Message.error(resp.data.msg);
        }
        vm.getSettings();
      }, error => {
        if (error.response.status === 400) {
          this.errors = error.response.data;
        }else{
          Message.error("Something went wrong. Contact Admin");
        }
        vm.isLoading = false;
      })
    },
    onFileSelected(event) {
      // console.log(event);
      this.setting.logoUrl = event.target.files[0];
      this.updatePreview(event);
    },
    updatePreview(event) {
      let vm = this;
      let reader, files = event.target.files;
      reader = new FileReader();
      reader.onload = (event) => {
        vm.logoPreview = event.target.result;
      }
      reader.readAsDataURL(files[0]);
    }
  }
}
</script>

<style lang="scss" scoped>
.card-content{
  padding: 1.5rem 15rem;
}
.logo-input {
   min-height: 50px;
 }
</style>