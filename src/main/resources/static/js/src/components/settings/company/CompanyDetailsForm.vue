<template>
  <div class="card animated preFadeInUp fadeInUp">
    <div class="card-content">
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label ">Company Name <span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="companyDetails.name"
                  @input="clearFieldError('name')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['name']">
						        {{ errors['name'][0] }}
					        </span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label ">Registration No<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="companyDetails.registrationNo"
                  @input="clearFieldError('registrationNo')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['registrationNo']">
                    {{ errors['registrationNo'][0] }}
                  </span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label ">State Of Incorporation<span><sup>*</sup></span></label>
            <div class="control">
              <Select
                  class="form-control is-large w-full"
                  v-model="companyDetails.stateOfIncorporation"
                  required
                  placeholder="Select State"
              >
                <Option value="SP" label="Sole Proprietorship" class="form-control"></Option>
                <Option value="P" label="Partnership" class="form-control"></Option>
                <Option value="PLC" label="Private Liability Company" class="form-control"></Option>
                <Option value="LLC" label="Limited Liability Company" class="form-control"></Option>
              </Select>
              <span class="mb-2 has-text-danger" v-if="errors['stateOfIncorporation']">
						{{ errors['stateOfIncorporation'][0] }}
					</span>
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label ">Company Email<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="companyDetails.email"
                  @input="clearFieldError('email')"
                  class="input"
                  type="email">
              <span class="mb-2 has-text-danger" v-if="errors['email']">
						{{ errors['email'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label ">Date Established<span><sup>*</sup></span></label>
            <div class="control">
              <DatePicker
                  class="datepicker"
                  v-model="companyDetails.dateEstablished"
                  @input="clearFieldError('dateEstablished')"
              >

              </DatePicker>
              <!--                                    <input-->
              <!--                                            v-model="basicInfo.dateOfBirth"-->
              <!--                                            @input="clearFieldError('basicInfo.dateOfBirth')"-->
              <!--                                            class="input"-->
              <!--                                            type="text">-->
              <span class="mb-2 has-text-danger" v-if="errors['dateEstablished']">
						{{ errors['dateEstablished'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label "><span>Business Entity Type<sup>*</sup></span></label>
            <div class="control">
              <Select
                  class="form-control is-large w-full"
                  v-model="companyDetails.businessEntityType"
                  required
                  placeholder="Select Type"
              >
                <Option value="1" label="Entity 1" class="form-control"></Option>
                <Option value="2" label="Entity 2" class="form-control"></Option>
                <Option value="3" label="Entity 3" class="form-control"></Option>
                <Option value="4" label="Entity 4" class="form-control"></Option>
                <Option value="5" label="Entity 5" class="form-control"></Option>
              </Select>
              <span class="mb-2 has-text-danger" v-if="errors['businessEntityType']">
						{{ errors['businessEntityType'][0] }}
					</span>
            </div>
          </div>
        </div>
      </div>
      <div class="columns">
        <div class="column">
          <div class="field">
            <label class="label ">Website URL<span><sup>*</sup></span></label>
            <div class="control">
              <input
                  v-model="companyDetails.websiteUrl"
                  @input="clearFieldError('websiteUrl')"
                  class="input"
                  type="text">
              <span class="mb-2 has-text-danger" v-if="errors['websiteUrl']">
						{{ errors['websiteUrl'][0] }}
					</span>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <label class="label ">Business Description<span><sup>*</sup></span></label>
            <div class="control">
              <textarea
                  v-model="companyDetails.businessDescription"
                  @input="clearFieldError('businessDescription')"
                  class="input"
                  type="text"></textarea>
              <span class="mb-2 has-text-danger" v-if="errors['businessDescription']">
						{{ errors['businessDescription'][0] }}
					</span>
            </div>
          </div>
        </div>
        <!--        <div class="column">-->
        <!--          <div class="field">-->
        <!--            <label class="label ">Marital Status<span><sup>*</sup></span></label>-->
        <!--            <div class="control">-->
        <!--              <Select-->
        <!--                  class="form-control is-large w-full"-->
        <!--                  v-model="companyDetails.maritalStatusId"-->
        <!--                  required-->
        <!--                  placeholder="Select Status"-->
        <!--              >-->
        <!--                <Option v-for="mStatus in maritalStatuses"-->
        <!--                        :value="mStatus.id"-->
        <!--                        :label="mStatus.name"-->
        <!--                        :key="mStatus.id" class="form-control">-->
        <!--                </Option>-->
        <!--              </Select>-->
        <!--              <span class="mb-2 has-text-danger" v-if="errors['name']">-->
        <!--                    {{ errors['name'][0] }}-->
        <!--                  </span>-->
        <!--            </div>-->
        <!--          </div>-->
        <!--        </div>-->
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
  name: "CompanyDetailsForm",
  components: {
    DatePicker,
    Select,
    Option
  },
  mixins: [CommonMixin],
  data() {
    return {
      companyDetails: {
        id: "",
        name: "",
        websiteUrl: "",
        registrationNo: "",
        dateEstablished: "",
        businessDescription: "",
        businessEntityType: "",
        stateOfIncorporation: "",
        email: "",
      },
      isLoading: false,
      maritalStatuses: []
    }
  },
  created() {
    this.getDetails();
  },
  computed: {
    disableSubmitButton() {
      // return false;
      let vm = this.companyDetails;
      return vm.name.length <= 0 || vm.websiteUrl.length <= 0 || vm.registrationNo.length <= 0
          || vm.dateEstablished.toString().length <= 0 || vm.businessDescription.length <= 0 || vm.businessEntityType.length <= 0
          || vm.stateOfIncorporation.length <= 0 || vm.email.length <= 0 || this.isLoading
    }
  },
  methods: {
    getDetails() {
      let vm = this;
      axios.get(`/api/company-details`).then(resp => {
        vm.companyDetails = {...vm.companyDetails, ...resp.data};
      })
    },
    submit() {
      let vm = this;
      vm.isLoading = true;
      axios.post(`/api/company-details/update`,
          vm.companyDetails).then(resp => {
        vm.isLoading = false;
        if (resp.data.status === "00") {
          this.$emit("updatedDetails");
          Message.success(resp.data.msg);
        } else {
          Message.error(resp.data.msg);
        }
        vm.getDetails();
      }, error => {
        if (error.response.status === 400) {
          vm.isLoading = false;
          this.errors = error.response.data;
        } else {
          vm.isLoading = false;
          Message.error("Something went wrong. Contact Admin");
        }
      })
    }
  }
}
</script>

<style scoped>

</style>