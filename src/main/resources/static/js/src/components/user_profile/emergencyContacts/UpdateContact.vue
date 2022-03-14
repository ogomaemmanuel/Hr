<template>
  <div class="form-class">
    <h1 class="has-text-weight-bold modal-heading">Emergency Contacts</h1>
    <div class="single-contact">
      <div class="forms">
        <h1 class="sub-heading">
          Primary Contact
        </h1>
        <div class="columns">
          <div class="column">
            <div class="field">
              <label class="label ">Name <span><sup>*</sup></span></label>
              <div class="control">
                <input
                    v-model="emergencyContact.primaryName"
                    @input="clearFieldError('primaryName')"
                    class="input"
                    type="text">
                <span class="mb-2 has-text-danger" v-if="errors['primaryName']">
						{{ errors['primaryName'][0] }}
					</span>
              </div>
            </div>
          </div>
          <div class="column">
            <div class="field">
              <label class="label ">Relationship <span><sup>*</sup></span></label>
              <div class="control">
                <Select
                    class="form-control is-large w-full"
                    v-model="emergencyContact.primaryRelationship"
                    required
                >
                  <Option v-for="relationship in relationships"
                          :value="relationship.name"
                          :label="relationship.name"
                          :key="relationship.id" class="form-control">
                  </Option>
                </Select>
                <span class="mb-2 has-text-danger" v-if="errors['primaryRelationship']">
						{{ errors['primaryRelationship'][0] }}
					</span>
              </div>
            </div>
          </div>
        </div>
        <div class="columns">
          <div class="column">
            <div class="field">
              <label class="label ">Mobile One <span><sup>*</sup></span></label>
              <div class="control">
                <input
                    v-model="emergencyContact.primaryPhoneOne"
                    @input="clearFieldError('primaryPhoneOne')"
                    class="input"
                    type="text">
                <span class="mb-2 has-text-danger" v-if="errors['primaryPhoneOne']">
						{{ errors['primaryPhoneOne'][0] }}
					</span>
              </div>
            </div>
          </div>
          <div class="column">
            <div class="field">
              <label class="label ">Mobile Two</label>
              <div class="control">
                <input
                    v-model="emergencyContact.primaryPhoneTwo"
                    @input="clearFieldError('phoneTwo')"
                    class="input"
                    type="text">
                <span class="mb-2 has-text-danger" v-if="errors['phoneTwo']">
						{{ errors['phoneTwo'][0] }}
					</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="single-contact">
      <div class="forms">
        <h1 class="sub-heading">
          Secondary Contact
        </h1>
        <div class="columns">
          <div class="column">
            <div class="field">
              <label class="label ">Name</label>
              <div class="control">
                <input
                    v-model="emergencyContact.secondaryName"
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
              <label class="label ">Relationship</label>
              <div class="control">
                <Select
                    class="form-control is-large w-full"
                    v-model="emergencyContact.secondaryRelationship"
                    required
                >
                  <Option v-for="relationship in relationships"
                          :value="relationship.name"
                          :label="relationship.name"
                          :key="relationship.id" class="form-control">
                  </Option>
                </Select>
                <span class="mb-2 has-text-danger" v-if="errors['relationship']">
						{{ errors['relationship'][0] }}
					</span>
              </div>
            </div>
          </div>
        </div>
        <div class="columns">
          <div class="column">
            <div class="field">
              <label class="label ">Mobile One</label>
              <div class="control">
                <input
                    v-model="emergencyContact.secondaryPhoneOne"
                    @input="clearFieldError('phoneOne')"
                    class="input"
                    type="text">
                <span class="mb-2 has-text-danger" v-if="errors['phoneOne']">
						{{ errors['phoneOne'][0] }}
					</span>
              </div>
            </div>
          </div>
          <div class="column">
            <div class="field">
              <label class="label ">Mobile Two</label>
              <div class="control">
                <input
                    v-model="emergencyContact.secondaryPhoneTwo"
                    @input="clearFieldError('phoneTwo')"
                    class="input"
                    type="text">
                <span class="mb-2 has-text-danger" v-if="errors['phoneTwo']">
						{{ errors['phoneTwo'][0] }}
					</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="flex justify-center">
      <button
          :disabled="disableSubmitButton"
          @click.prevent="submit"
          :class="{'is-loading':isLoading}"
          class="button is-primary is-rounded p-2">
        Submit
      </button>
    </div>
  </div>
</template>

<script>
import common_mixin from "../../../mixins/common_mixin";
import {Message,Select,Option} from "element-ui";

export default {
  name: "UpdateContact",
  mixins: [common_mixin],
  props: {
    employeeId: {
      required: true
    },
    emergencyContact: {
      required: true
    }
  },
  components:{
    Select,
    Option
  },
  data(){
    return{
      errors:[],
      isLoading: false,
      relationships:[]
    }
  },
  computed: {
    disableSubmitButton() {
      let vm = this.emergencyContact;
      return vm.primaryName.length <= 0 || vm.primaryRelationship.length <= 0
          || vm.primaryPhoneOne.length <= 0 || this.isLoading;
    }
  },
  created() {
    this.getFamilyRelations();
  },
  methods: {
    getFamilyRelations() {
      let vm = this;
      axios.get(`/api/users/family-relationships`).then(resp => {
          vm.relationships = resp.data;
      })
    },
    submit(){
      let vm = this;
      vm.isLoading = true;
      vm.emergencyContact.userId = vm.employeeId;
      axios.post(`/api/update-emergency-contact`,
          vm.emergencyContact).then(resp => {
        vm.isLoading = false;
        if (resp.data.status === "00") {
          this.$emit("updatedContact");
          Message.success(resp.data.msg);
        } else {
          Message.error(resp.data.msg);
        }
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
.single-contact{
  padding: 20px;
}
.forms{
  padding: 20px;
  border-radius: 10px;
  border: 1px solid #b6b6b6;
}

.modal-heading{
  font-size: 30px;
  display: flex;
  justify-content: center;
}
.sub-heading{
  font-size: 20px;
}

</style>