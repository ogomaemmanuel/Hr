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
                                            @input="clearFieldError('phone')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['phone']">
						{{errors['phone'][0]}}
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
                                            @input="clearFieldError('email')"
                                            class="input"
                                            type="email">
                                    <span class="mb-2 has-text-danger" v-if="errors['email']">
						{{errors['email'][0]}}
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
                                            @input="clearFieldError('dateOfBirth')">

                                    </DatePicker>
                                    <span class="mb-2 has-text-danger" v-if="errors['dateOfBirth']">
						{{errors['dateOfBirth'][0]}}
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
                                            @input="clearFieldError('identityNo')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['identityNo']">
						{{errors['identityNo'][0]}}
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
                                            @input="clearFieldError('city')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['city']">
						{{errors['city'][0]}}
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
                        @click.prevent.stop="createUser()"
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
        data() {
            return {
                basicInfo: {},
                loading: false,
            }
        },
        methods: {
            createUser() {
                let vm = this;
                axios.post("/api/users", this.basicInfo).then(resp => {
                    vm.$swal({
                        type: "success",
                        title: "Success",
                        text: "User successfully  created "
                    })
                    this.$emit("userCreated");
                }, error => {
                    if (error.response.status == 400) {
                        this.errors = error.response.data;

                    }
                })
            }
        }
    }
</script>
<style lang="scss" scoped>
    .datepicker {
        min-width: 100%;
    }
</style>