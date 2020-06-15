<template>
    <div>
        <div class="steps-body pt-4 pb-4 pl-0 pr-0">
            <div data-v-5d80c0af="" class="steps-content">
                <div data-v-5d80c0af="" class="step-content has-text-left is-active animated preFadeInUp fadeInUp">
                    <div class="columns">
                        <div class="column">
                            <div class="field">
                                <label class="label is-size-7">First Name <span><sup>*</sup></span></label>
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
                                <label class="label is-size-7">Last Name <span><sup>*</sup></span></label>
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
                                <label class="label is-size-7">Phone<span><sup>*</sup></span></label>
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
                                <label class="label is-size-7">Email<span><sup>*</sup></span></label>
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
                                <label class="label is-size-7">Date of Birth<span><sup>*</sup></span></label>
                                <div class="control">
                                    <input
                                            v-model="basicInfo.dateOfBirth"
                                            @input="clearFieldError('basicInfo.dateOfBirth')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['basicInfo.dateOfBirth']">
						{{errors['basicInfo.dateOfBirth'][0]}}
					</span>
                                </div>
                            </div>
                        </div>
                        <div class="column">
                            <div class="field">
                                <label class="label is-size-7">Id No<span><sup>*</sup></span></label>
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
                                <label class="label is-size-7">Residential Address<span><sup>*</sup></span></label>
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
                                <label class="label is-size-7">Postal Address<span><sup>*</sup></span></label>
                                <div class="control">
                                    <input
                                            v-model="basicInfo.name"
                                            @input="clearFieldError('name')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
                                </div>
                            </div>
                        </div>
                        <div class="column">
                            <div class="field">
                                <label class="label is-size-7">Marital Status<span><sup>*</sup></span></label>
                                <div class="control">
                                    <input
                                            v-model="basicInfo.name"
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
        <slot :isLoading="isLoading" :onNext="onNext">
        </slot>
    </div>
</template>
<script>
    import CommonMixin from "../../../../mixins/common_mixin"

    export default {
        mixins: [CommonMixin],
        props: {
            employeeDetails: {
                required: true,

            }
        },
        data() {
            return {
                basicInfo: {},
                isLoading: false,
            }
        },
        methods: {
            onNext() {
                let vm = this;
                vm.$emit("goToNext", false)
            },
        }
    }
</script>