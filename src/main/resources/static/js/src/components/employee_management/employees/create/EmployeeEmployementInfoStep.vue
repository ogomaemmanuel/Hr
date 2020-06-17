<template>
    <div>
        <div>
            <div class="steps-body pt-4 pb-4 pl-0 pr-0">
                <div class="steps-content">
                    <div class="step-content has-text-left is-active animated preFadeInUp fadeInUp">
                        <div class="columns">
                            <div class="column">
                                <div class="field">
                                    <label class="label is-size-7">Department<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.name"
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
                                    <label class="label is-size-7">Designation<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.name"
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
                                    <label class="label is-size-7">Salary Amount<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.name"
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
                        <div class="columns">
                            <div class="column">
                                <div class="field">
                                    <label class="label is-size-7">Joining Date<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.name"
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
                                    <label class="label is-size-7">Supervisor<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.name"
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
                                    <label class="label is-size-7">Salary Amount<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.name"
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
                        <div class="columns">
                            <div class="column">
                                <div class="field">
                                    <label class="label is-size-7">NHIF No<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.name"
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
                                    <label class="label is-size-7">NSSF No<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.name"
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
                                    <label class="label is-size-7">KRA Pin<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.name"
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
    </div>
</template>
<script>
    import CommonMixin from "../../../../mixins/common_mixin"

    export default {
        mixins: [CommonMixin],
        data() {
            return {
                isLoading: false,
                canMoveNext: true,
                employementDetail: {}
                // step: 0
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

<style lang="scss" scoped>

</style>