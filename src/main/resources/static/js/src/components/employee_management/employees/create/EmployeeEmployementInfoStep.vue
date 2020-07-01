<template>
    <div>
        <div>
            <div class="steps-body pt-4 pb-4 pl-0 pr-0">
                <div class="steps-content">
                    <div class="step-content has-text-left is-active animated preFadeInUp fadeInUp">
                        <div class="columns">
                            <div class="column">
                                <DepartmentSelectInput
                                        @input="clearFieldError('employementDetail.departmentId')"
                                        v-model="employementDetail.departmentId">
                                       <span slot="errors" class="mb-2 has-text-danger"
                                             v-if="errors['employementDetail.departmentId']">
						{{errors['employementDetail.departmentId'][0]}}
					</span>
                                </DepartmentSelectInput>
                            </div>
                            <div class="column">
                                <DesignationSelectInput
                                        v-model="employementDetail.designationId"
                                        @input="clearFieldError('employementDetail.designationId')">
                                     <span slot="errors" class="mb-2 has-text-danger"
                                           v-if="errors['employementDetail.designationId']">
						{{errors['employementDetail.designationId'][0]}}
					</span>
                                </DesignationSelectInput>

                            </div>
                            <div class="column">
                                <div class="field">
                                    <label class="label">Salary Amount<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.salaryAmount"
                                                @input="clearFieldError('employementDetail.salaryAmount')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger"
                                              v-if="errors['employementDetail.salaryAmount']">
						{{errors['employementDetail.salaryAmount'][0]}}
					</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="columns">
                            <div class="column">
                                <div class="field">
                                    <label class="label ">Joining Date<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <DatePicker
                                                class="datepicker"
                                                v-model="employementDetail.joiningDate"
                                                @input="clearFieldError('employementDetail.joiningDate')"
                                        >

                                        </DatePicker>

                                        <span class="mb-2 has-text-danger"
                                              v-if="errors['employementDetail.joiningDate']">
						{{errors['employementDetail.joiningDate'][0]}}
					</span>
                                    </div>
                                </div>
                            </div>
                            <div class="column">
                                <EmployeeSelectInput
                                        :required="false"
                                        label="Supervisor"
                                        v-model="employementDetail.supervisorId"
                                        @input="clearFieldError('employementDetail.supervisorId')">
                                     <span slot="errors" class="mb-2 has-text-danger"
                                           v-if="errors['employementDetail.supervisorId']">
						{{errors['employementDetail.supervisorId'][0]}}
					</span>
                                </EmployeeSelectInput>

                            </div>
                            <div class="column">
                                <div class="field">
                                    <label class="label ">Gender<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <div class="select is-fullwidth">
                                            <select @input="clearFieldError('employementDetail.gender')" v-model="employementDetail.gender">
                                                <option value="">Select</option>
                                                <option value="M">Male</option>
                                                <option value="F">Female</option>
                                            </select>
                                        </div>
                                        <span class="mb-2 has-text-danger" v-if="errors['employementDetail.gender']">
						{{errors['employementDetail.gender'][0]}}
					</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="columns">
                            <div class="column">
                                <div class="field">
                                    <label class="label ">NHIF No<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.nhifNo"
                                                @input="clearFieldError('employementDetail.nhifNumber')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger"
                                              v-if="errors['employementDetail.nhifNumber']">
						{{errors['employementDetail.nhifNumber'][0]}}
					</span>
                                    </div>
                                </div>
                            </div>
                            <div class="column">
                                <div class="field">
                                    <label class="label ">NSSF No<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.nssfNo"
                                                @input="clearFieldError('employementDetail.nssfNumber')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger"
                                              v-if="errors['employementDetail.nssfNumber']">
						{{errors['employementDetail.nssfNumber'][0]}}
					</span>
                                    </div>
                                </div>
                            </div>
                            <div class="column">
                                <div class="field">
                                    <label class="label ">KRA Pin<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.kraPinNumber"
                                                @input="clearFieldError('employementDetail.kraPinNumber')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger"
                                              v-if="errors['employementDetail.kraPinNumber']">
						{{errors['employementDetail.kraPinNumber'][0]}}
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
    import {DatePicker} from "element-ui"
    import DepartmentSelectInput from "../../../common/DepartmentSelectInput";
    import DesignationSelectInput from "../../../common/DesignationSelectInput";
    import EmployeeSelectInput from "../../../common/EmployeeSelectInput"
    import common_mixin from "../../../../mixins/common_mixin";

    export default {
        mixins: [common_mixin],
        components: {
            DatePicker,
            DepartmentSelectInput,
            DesignationSelectInput,
            EmployeeSelectInput
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
                canMoveNext: true,
                employementDetail: {}
                // step: 0
            }
        },
        created() {
            this.employeeDetails.employementDetail
                = this.employementDetail;
            this.errors = this.errorsData;
        },
        watch: {
            errorsData:function(val) {
                this.errors = val;
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
    .datepicker {
        min-width: 100%;
    }
</style>