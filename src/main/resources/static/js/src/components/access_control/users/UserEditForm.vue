<template>
    <div>
        <div class="steps-body pt-4 pb-4 pl-0 pr-0">
            <div class="steps-content">
                <div class="has-text-centered m-3">
                    <h1 class="has-text-black"><b>Add User</b></h1>
                </div>
                <div class="step-content has-text-left is-active animated preFadeInUp fadeInUp">
                    <div class="columns">
                        <div class="column">
                            <div class="field">
                                <label class="label ">First Name <span><sup>*</sup></span></label>
                                <div class="control">
                                    <input
                                            v-model="basicInfo.firstName"
                                            @input="clearFieldError('firstName')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['firstName']">
						{{errors['firstName'][0]}}
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
                                            @input="clearFieldError('lastName')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['lastName']">
						{{errors['lastName'][0]}}
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
                                            @input="clearFieldError('postalAddress')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['postalAddress']">
						{{errors['postalAddress'][0]}}
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
            <div class="flex justify-center m-3">
                <button
                        :class="{'is-loading':loading}"
                        @click.prevent.stop=""
                        class="button  is-rounded"
                        type="submit">Submit
                </button>
            </div>
        </div>
    </div>
</template>
<script>
    import common_mixin from "../../../mixins/common_mixin";
    import {DatePicker} from "element-ui"
    export default {
        components: {
            DatePicker
        },
        mixins: [common_mixin],
        props: {
            userId: {
                // required: true
            }
        },
        data() {
            return {
                basicInfo: {},
                loading: false,
            }
        }
    }
</script>
<style lang="scss" scoped>

</style>