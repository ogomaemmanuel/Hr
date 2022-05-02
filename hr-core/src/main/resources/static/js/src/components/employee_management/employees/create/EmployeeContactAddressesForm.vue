<template>
  <div>
    <div>
      <div class="steps-body pt-4 pb-4 pl-0 pr-0">
        <div class="steps-content">
          <div class="step-content has-text-left is-active animated preFadeInUp fadeInUp">

<!--            <div v-for="(contactAddress,index)  in contactAddresses">-->
<!--              <div v-if="contactAddresses.length>1"-->
<!--                   class="flex is-hidden-desktop justify-end contact-header">-->
<!--                <i @click="removeRow(index)" class="fa fa-trash has-text-danger"></i>-->
<!--              </div>-->
<!--              <div class="columns">-->
<!--                <div class="column">-->
<!--                  <div class="field">-->
<!--                    <label class="label ">Contact Name <span><sup>*</sup></span></label>-->
<!--                    <div class="control">-->
<!--                      <input-->
<!--                          v-model="contactAddress.name"-->
<!--                          @input="clearFieldError(`contactAddresses[${index}].name`)"-->
<!--                          class="input"-->
<!--                          type="text">-->
<!--                      <span class="mb-2 has-text-danger"-->
<!--                            v-if="errors[`contactAddresses[${index}].name`]">-->
<!--                        {{ errors[`contactAddresses[${index}].name`][0] }}-->
<!--                      </span>-->
<!--                    </div>-->
<!--                  </div>-->

<!--                </div>-->
<!--                <div class="column">-->
<!--                  <div class="field">-->
<!--                    <label class="label ">Contact Phone <span><sup>*</sup></span></label>-->
<!--                    <div class="control">-->
<!--                      <input-->
<!--                          v-model="contactAddress.phoneNumber"-->
<!--                          @input="clearFieldError(`contactAddresses[${index}].phoneNumber`)"-->
<!--                          class="input"-->
<!--                          type="text">-->
<!--                      <span class="mb-2 has-text-danger" v-if="errors[`contactAddresses[${index}].phoneNumber`]">-->
<!--                                                {{ errors[`contactAddresses[${index}].phoneNumber`][0] }}-->
<!--					                      </span>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--                <div class="column is-relative">-->
<!--                  <div class="field">-->
<!--                    <label class="label ">Relationship <span><sup>*</sup></span></label>-->
<!--                    <div class="control">-->
<!--                      <input-->
<!--                          v-model="contactAddress.relationshipId"-->
<!--                          @input="clearFieldError(`contactAddresses[${index}].relationshipId`)"-->

<!--                          class="input"-->
<!--                          type="text">-->
<!--                      <span class="mb-2 has-text-danger" v-if="errors[`contactAddresses[${index}].relationshipId`]">-->
<!--                                                {{ errors[`contactAddresses[${index}].relationshipId`][0] }}-->
<!--					            </span>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                  <i v-if="contactAddresses.length > 1"-->
<!--                     @click="removeRow(index)"-->
<!--                     class="fa fa-trash has-text-danger delete-contact is-hidden-mobile"></i>-->
<!--                </div>-->
<!--              </div>-->
<!--            </div>-->
            <div>
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
<!--              </div>-->
<!--              <div class="columns">-->
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
<!--              </div>-->
<!--              <div class="columns">-->
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

<!--            <div class="flex justify-end pt-2">-->
<!--              <div>-->
<!--                <button class="button" @click="addRow()">-->
<!--                  <i class="fa fa-plus"></i>-->
<!--                </button>-->
<!--              </div>-->
<!--            </div>-->
          </div>
        </div>
      </div>
      <slot :isLoading="isLoading" :canMoveNext="canMoveNext" :onNext="onNext">
      </slot>
    </div>
  </div>
</template>
<script>
import CommonMixin from "../../../../mixins/common_mixin"
import {Select,Option} from "element-ui";

export default {
  mixins: [CommonMixin],
  components: {
    Select,
    Option
  },
  props: {
    employeeDetails: {
      required: true,
    },
    errorsData: {}
  },
  data() {
    return {
      isLoading: false,
      emergencyContact: {},
      relationships: []
    }
  },
  created() {
    this.initialize();
    this.getFamilyRelations();
  },
  watch: {
    errorsData: function (val) {
      this.errors = val;
    }
  },
  computed: {
    // contactAddressAreValid() {
    //   return this.contactAddresses.every(value =>
    //       this.validateContacts(value)
    //   )
    // },
    canMoveNext() {
      // return true;
      return this.validateContacts();
    }
  },
  methods: {
    getFamilyRelations() {
      let vm = this;
      axios.get(`/api/users/family-relationships`).then(resp => {
        vm.relationships = resp.data;
      })
    },
    onNext() {
      let vm = this;
      this.employeeDetails.emergencyContact
          = this.emergencyContact
      vm.$emit("goToNext", false)
    },
    // addRow() {
    //   this.contactAddresses.push({
    //     name: "",
    //     relationshipId: "",
    //     phoneNumber: "",
    //   })
    // },
    initialize() {
      // this.contactAddresses = [
      //   {
      //     name: "",
      //     relationshipId: "",
      //     phoneNumber: "",
      //   },
      //   {
      //     name: "",
      //     relationshipId: "",
      //     phoneNumber: "",
      //   },
      //   {
      //     name: "",
      //     relationshipId: "",
      //     phoneNumber: "",
      //   },
      //
      // ]

      this.emergencyContact = {
            primaryName: "",
            primaryRelationship: "",
            primaryPhoneOne: "",
            primaryPhoneTwo: "",
            secondaryName: "",
            secondaryRelationship: "",
            secondaryPhoneOne: "",
            secondaryPhoneTwo: ""
      }
    },
    validateContacts() {
      let vm = this.emergencyContact;
      return vm.primaryName.length > 0 && vm.primaryRelationship.length > 0
          && vm.primaryPhoneOne.length > 0;
    },
    // removeRow(index) {
    //   if (this.contactAddresses.length > 1) {
    //     this.contactAddresses.splice(index, 1);
    //   }
    //
    // }

  }
}
</script>
<style lang="scss" scoped>
.delete-contact {
  position: absolute;
  top: 3rem;
  right: -0.2rem;
}

.contact-header {
  padding: 10px 10px;
  background-color: #fafbfc;
  /*border-bottom: 1px solid #e1e4e8;*/
  border-top-left-radius: 3px;
  border-top-right-radius: 3px;
}
</style>
<!--<template>-->
<!--    <div>-->
<!--        <div>-->
<!--            <div class="steps-body pt-4 pb-4 pl-0 pr-0">-->
<!--                <div class="steps-content">-->
<!--                    <div class="step-content has-text-left is-active animated preFadeInUp fadeInUp">-->

<!--                        <div v-for="(contactAddress,index)  in contactAddresses">-->
<!--                            <div v-if="contactAddresses.length>1"-->
<!--                                 class="flex is-hidden-desktop justify-end contact-header">-->
<!--                                <i @click="removeRow(index)" class="fa fa-trash has-text-danger"></i>-->
<!--                            </div>-->
<!--                            <div class="columns">-->
<!--                                <div class="column">-->
<!--                                    <div class="field">-->
<!--                                        <label class="label ">Contact Name <span><sup>*</sup></span></label>-->
<!--                                        <div class="control">-->
<!--                                            <input-->
<!--                                                    v-model="contactAddress.name"-->
<!--                                                    @input="clearFieldError(`contactAddresses[${index}].name`)"-->
<!--                                                    class="input"-->
<!--                                                    type="text">-->
<!--                                            <span class="mb-2 has-text-danger"-->
<!--                                                  v-if="errors[`contactAddresses[${index}].name`]">-->
<!--						{{errors[`contactAddresses[${index}].name`][0]}}-->
<!--					</span>-->
<!--                                        </div>-->
<!--                                    </div>-->

<!--                                </div>-->
<!--                                <div class="column">-->
<!--                                    <div class="field">-->
<!--                                        <label class="label ">Contact Phone <span><sup>*</sup></span></label>-->
<!--                                        <div class="control">-->
<!--                                            <input-->
<!--                                                    v-model="contactAddress.phoneNumber"-->
<!--                                                    @input="clearFieldError(`contactAddresses[${index}].phoneNumber`)"-->
<!--                                                    class="input"-->
<!--                                                    type="text">-->
<!--                                            <span class="mb-2 has-text-danger" v-if="errors[`contactAddresses[${index}].phoneNumber`]">-->
<!--                                                {{errors[`contactAddresses[${index}].phoneNumber`][0]}}-->
<!--					                      </span>-->
<!--                                        </div>-->
<!--                                    </div>-->
<!--                                </div>-->
<!--                                <div class="column is-relative">-->
<!--                                    <div class="field">-->
<!--                                        <label class="label ">Relationship <span><sup>*</sup></span></label>-->
<!--                                        <div class="control">-->
<!--                                            <input-->
<!--                                                    v-model="contactAddress.relationshipId"-->
<!--                                                    @input="clearFieldError(`contactAddresses[${index}].relationshipId`)"-->

<!--                                                    class="input"-->
<!--                                                    type="text">-->
<!--                                            <span class="mb-2 has-text-danger" v-if="errors[`contactAddresses[${index}].relationshipId`]">-->
<!--                                                {{errors[`contactAddresses[${index}].relationshipId`][0]}}-->
<!--					</span>-->
<!--                                        </div>-->
<!--                                    </div>-->
<!--                                    <i v-if="contactAddresses.length > 1"-->
<!--                                       @click="removeRow(index)"-->
<!--                                       class="fa fa-trash has-text-danger delete-contact is-hidden-mobile"></i>-->
<!--                                </div>-->
<!--                            </div>-->
<!--                        </div>-->

<!--                        <div class="flex justify-end pt-2">-->
<!--                            <div>-->
<!--                                <button class="button" @click="addRow()">-->
<!--                                    <i class="fa fa-plus"></i>-->
<!--                                </button>-->
<!--                            </div>-->
<!--                        </div>-->
<!--                    </div>-->
<!--                </div>-->
<!--            </div>-->
<!--            <slot :isLoading="isLoading" :canMoveNext="canMoveNext" :onNext="onNext">-->
<!--            </slot>-->
<!--        </div>-->
<!--    </div>-->
<!--</template>-->
<!--<script>-->
<!--    import CommonMixin from "../../../../mixins/common_mixin"-->

<!--    export default {-->
<!--        mixins: [CommonMixin],-->
<!--        props: {-->
<!--            employeeDetails: {-->
<!--                required: true,-->
<!--            },-->
<!--            errorsData: {}-->
<!--        },-->
<!--        data() {-->
<!--            return {-->
<!--                isLoading: false,-->
<!--                contactAddresses: []-->
<!--            }-->
<!--        },-->
<!--        created() {-->
<!--            this.initialize();-->

<!--        },-->
<!--        watch: {-->
<!--            errorsData: function (val) {-->
<!--                this.errors = val;-->
<!--            }-->
<!--        },-->
<!--        computed: {-->
<!--            contactAddressAreValid() {-->
<!--                return this.contactAddresses.every(value =>-->
<!--                    this.validateContactAddress(value)-->
<!--                )-->
<!--            },-->
<!--            canMoveNext() {-->
<!--               // return true;-->
<!--                return this.contactAddressAreValid;-->
<!--            }-->
<!--        },-->

<!--        methods: {-->
<!--            onNext() {-->
<!--                let vm = this;-->
<!--                this.employeeDetails.contactAddresses-->
<!--                    = this.contactAddresses-->
<!--                vm.$emit("goToNext", false)-->
<!--            },-->
<!--            addRow() {-->
<!--                this.contactAddresses.push({-->
<!--                    name: "",-->
<!--                    relationshipId: "",-->
<!--                    phoneNumber: "",-->
<!--                })-->
<!--            },-->
<!--            initialize() {-->
<!--                this.contactAddresses = [-->
<!--                    {-->
<!--                        name: "",-->
<!--                        relationshipId: "",-->
<!--                        phoneNumber: "",-->
<!--                    },-->
<!--                    {-->
<!--                        name: "",-->
<!--                        relationshipId: "",-->
<!--                        phoneNumber: "",-->
<!--                    },-->
<!--                    {-->
<!--                        name: "",-->
<!--                        relationshipId: "",-->
<!--                        phoneNumber: "",-->
<!--                    },-->

<!--                ]-->
<!--            },-->
<!--            validateContactAddress(contactAddress) {-->
<!--                return contactAddress.name.length > 0-->
<!--                    && contactAddress.phoneNumber.length > 0-->
<!--                    && contactAddress.relationshipId.length > 0;-->
<!--            },-->
<!--            removeRow(index) {-->
<!--                if (this.contactAddresses.length > 1) {-->
<!--                    this.contactAddresses.splice(index, 1);-->
<!--                }-->

<!--            }-->

<!--        }-->
<!--    }-->
<!--</script>-->
<!--<style lang="scss" scoped>-->
<!--    .delete-contact {-->
<!--        position: absolute;-->
<!--        top: 3rem;-->
<!--        right: -0.2rem;-->
<!--    }-->

<!--    .contact-header {-->
<!--        padding: 10px 10px;-->
<!--        background-color: #fafbfc;-->
<!--        /*border-bottom: 1px solid #e1e4e8;*/-->
<!--        border-top-left-radius: 3px;-->
<!--        border-top-right-radius: 3px;-->
<!--    }-->
<!--</style>-->
