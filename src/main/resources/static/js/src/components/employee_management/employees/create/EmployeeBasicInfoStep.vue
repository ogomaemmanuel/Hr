<template>
    <div>
        <div class="steps-body pt-4 pb-4 pl-0 pr-0">
            <div class="steps-content">
                <div class="step-content has-text-left is-active animated preFadeInUp fadeInUp">
                    <div class="columns">
                        <div class="column">
                            <div class="field">
                                <label class="label ">First Name <span><sup>*</sup></span></label>
                                <div class="control">
                                    <input
                                            v-model="basicInfo.firstName"
                                            @input="clearFieldError('basicInfo.firstName')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['basicInfo.firstName']">
						{{errors['basicInfo.firstName'][0]}}
					</span>
                                </div>
                            </div>
                        </div>
                        <div class="column">
                            <div class="field">
                                <label class="label ">Last Name <span><sup>*</sup></span></label>
                                <div class="control">
                                    <input
                                            v-model="basicInfo.lastName"
                                            @input="clearFieldError('basicInfo.lastName')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['basicInfo.lastName']">
						{{errors['basicInfo.lastName'][0]}}
					</span>
                                </div>
                            </div>
                        </div>
                        <div class="column">
                            <div class="field">
                                <label class="label ">Phone<span><sup>*</sup></span></label>
                                <div class="control">
                                    <input
                                            v-model="basicInfo.phone"
                                            @input="clearFieldError('basicInfo.phone')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['basicInfo.phone']">
						{{errors['basicInfo.phone'][0]}}
					</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="columns">
                        <div class="column">
                            <div class="field">
                                <label class="label ">Email<span><sup>*</sup></span></label>
                                <div class="control">
                                    <input
                                            v-model="basicInfo.email"
                                            @input="clearFieldError('basicInfo.email')"
                                            class="input"
                                            type="email">
                                    <span class="mb-2 has-text-danger" v-if="errors['basicInfo.email']">
						{{errors['basicInfo.email'][0]}}
					</span>
                                </div>
                            </div>
                        </div>
                        <div class="column">
                            <div class="field">
                                <label class="label ">Date of Birth<span><sup>*</sup></span></label>
                                <div class="control">
                                    <DatePicker
                                            class="datepicker"
                                            v-model="basicInfo.dateOfBirth"
                                            @input="clearFieldError('basicInfo.dateOfBirth')"
                                    >

                                    </DatePicker>
                                    <!--                                    <input-->
                                    <!--                                            v-model="basicInfo.dateOfBirth"-->
                                    <!--                                            @input="clearFieldError('basicInfo.dateOfBirth')"-->
                                    <!--                                            class="input"-->
                                    <!--                                            type="text">-->
                                    <span class="mb-2 has-text-danger" v-if="errors['basicInfo.dateOfBirth']">
						{{errors['basicInfo.dateOfBirth'][0]}}
					</span>
                                </div>
                            </div>
                        </div>
                        <div class="column">
                            <div class="field">
                                <label class="label ">Id No<span><sup>*</sup></span></label>
                                <div class="control">
                                    <input
                                            v-model="basicInfo.identityNo"
                                            @input="clearFieldError('basicInfo.identityNo')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['basicInfo.identityNo']">
						{{errors['basicInfo.identityNo'][0]}}
					</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="columns">
                        <div class="column">
                            <div class="field">
                                <label class="label ">Residential Address<span><sup>*</sup></span></label>
                                <div class="control">
                                    <input
                                            v-model="basicInfo.city"
                                            @input="clearFieldError('basicInfo.city')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['basicInfo.city']">
						{{errors['basicInfo.city'][0]}}
					</span>
                                </div>
                            </div>
                        </div>
                        <div class="column">
                            <div class="field">
                                <label class="label ">Postal Address<span><sup>*</sup></span></label>
                                <div class="control">
                                    <input
                                            v-model="basicInfo.postalAddress"
                                            @input="clearFieldError('basicInfo.postalAddress')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['basicInfo.postalAddress']">
						{{errors['basicInfo.postalAddress'][0]}}
					</span>
                                </div>
                            </div>
                        </div>
                        <div class="column">
                            <div class="field">
                                <label class="label ">Marital Status<span><sup>*</sup></span></label>
                                <div class="control">
                                    <input
                                            v-model="basicInfo.maritalStatusId"
                                            @input="clearFieldError('name')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <slot :isLoading="isLoading" :canMoveNext="canMoveNext" :onNext="onNext">
        </slot>
    </div>
</template>
<script>
    import CommonMixin from "../../../../mixins/common_mixin"
    import {DatePicker} from "element-ui"

    export default {
        components: {
            DatePicker
        },
        mixins: [CommonMixin],
        props: {
            employeeDetails: {
                required: true,
            },
            errorsData: {}
        },
        data() {
            return {
                basicInfo: {
                    firstName: "",
                    lastName: "",
                    phone: "",
                    email: "",
                    dateOfBirth: "",
                    identityNo: "",
                    city: "",
                    postalAddress: "",
                    maritalStatusId: ""
                },
                isLoading: false,
            }
        },
        watch: {
            errorsData:function(val) {
                this.errors = val;
            }

        },
        computed: {
            canMoveNext() {
               // return true;
                 return this.validateBasicInfo();
            },
        },
        methods: {
            onNext() {
                let vm = this;
                this.employeeDetails.basicInfo = this.basicInfo;
                vm.$emit("goToNext", false)
            },
            validateBasicInfo() {
                return this.basicInfo.firstName.length > 0
                    && this.basicInfo.lastName.length > 0
                    && this.basicInfo.city.length > 0
                    && this.basicInfo.phone.length > 0
                    && this.basicInfo.identityNo.length > 0
                    && this.basicInfo.dateOfBirth.toString().length > 0
                    && this.basicInfo.postalAddress.length > 0
                    && this.basicInfo.maritalStatusId.length > 0;
            }
        }
    }
</script>
<style lang="scss" scoped>
    .datepicker {
        min-width: 100%;
    }
</style>