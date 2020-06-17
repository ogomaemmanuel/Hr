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
                                                v-model="employementDetail.departmentId"
                                                @input="clearFieldError('departmentId')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger" v-if="errors['departmentId']">
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
                                                v-model="employementDetail.designationId"
                                                @input="clearFieldError('designationId')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger" v-if="errors['designationId']">
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
                                                v-model="employementDetail.salaryAmount"
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
                                                v-model="employementDetail.joinDate"
                                                @input="clearFieldError('joinDate')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger" v-if="errors['joinDate']">
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
                                                v-model="employementDetail.supervisorId"
                                                @input="clearFieldError('supervisorId')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger" v-if="errors['supervisorId']">
						{{errors['supervisorId'][0]}}
					</span>
                                    </div>
                                </div>
                            </div>
                            <div class="column">
                                <div class="field">
                                    <label class="label is-size-7">Shift<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.shiftId"
                                                @input="clearFieldError('salaryAmount')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger" v-if="errors['salaryAmount']">
						{{errors['salaryAmount'][0]}}
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
                                                v-model="employementDetail.nhifNo"
                                                @input="clearFieldError('nhifNo')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger" v-if="errors['nhifNo']">
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
                                                v-model="employementDetail.nssfNo"
                                                @input="clearFieldError('nssfNo')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger" v-if="errors['nssfNo']">
						{{errors['nssfNo'][0]}}
					</span>
                                    </div>
                                </div>
                            </div>
                            <div class="column">
                                <div class="field">
                                    <label class="label is-size-7">KRA Pin<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.kraPin"
                                                @input="clearFieldError('kraPin')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger" v-if="errors['kraPin']">
						{{errors['kraPin'][0]}}
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
        props: {
            employeeDetails: {
                required: true,
            }
        },
        data() {
            return {
                isLoading: false,
                canMoveNext: true,
                employementDetail: {}
                // step: 0
            }
        },
        created() {
            this.employeeDetails.employementDetail
                = this.employementDetail;
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