<template>
    <div>
        <div>
            <div class="steps-body pt-4 pb-4 pl-0 pr-0">
                <div class="steps-content">
                    <div class="step-content has-text-left is-active animated preFadeInUp fadeInUp">
                        <div class="columns">
                            <div class="column">
                                <!--                                <div class="field">-->
                                <!--                                    <label class="label is-size-7">Department<span><sup>*</sup></span></label>-->
                                <!--                                    <div class="control">-->
                                <!--                                        <input-->
                                <!--                                                v-model="employementDetail.departmentId"-->
                                <!--                                                @input="clearFieldError('departmentId')"-->
                                <!--                                                class="input"-->
                                <!--                                                type="text">-->
                                <!--                                        <span class="mb-2 has-text-danger" v-if="errors['departmentId']">-->
                                <!--						{{errors['name'][0]}}-->
                                <!--					</span>-->
                                <!--                                    </div>-->
                                <!--                                </div>-->
                                <DepartmentSelectInput
                                        v-model="employementDetail.departmentId"
                                ></DepartmentSelectInput>
                            </div>
                            <div class="column">

                                <DesignationSelectInput
                                        v-model="employementDetail.designationId"
                                        @input="clearFieldError('designationId')"
                                ></DesignationSelectInput>
                                <span class="mb-2 has-text-danger" v-if="errors['designationId']">
						{{errors['name'][0]}}
					</span>
                            </div>
                            <div class="column">
                                <div class="field">
                                    <label class="label">Salary Amount<span><sup>*</sup></span></label>
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
                                    <label class="label ">Joining Date<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <DatePicker
                                                class="datepicker"
                                                v-model="employementDetail.joiningDate"
                                                @input="clearFieldError('joiningDate')"
                                        >

                                        </DatePicker>

                                        <span class="mb-2 has-text-danger" v-if="errors['joiningDate']">
						{{errors['joiningDate'][0]}}
					</span>
                                    </div>
                                </div>
                            </div>
                            <div class="column">
                                <EmployeeSelectInput
                                        label="Supervisor"
                                        v-model="employementDetail.supervisorId"
                                        @input="clearFieldError('supervisorId')"
                                ></EmployeeSelectInput>
                                <span class="mb-2 has-text-danger" v-if="errors['supervisorId']">
						{{errors['supervisorId'][0]}}
					</span>
                            </div>
                            <div class="column">
                                <div class="field">
                                    <label class="label ">Gender<span><sup>*</sup></span></label>
                                    <div class="control">
<!--                                        <input-->
<!--                                                v-model="employementDetail.gender"-->
<!--                                                @input="clearFieldError('gender')"-->
<!--                                                class="input"-->
<!--                                                type="text">-->
                                        <div class="select is-fullwidth">
                                            <select v-model="employementDetail.gender">
                                                <option value="">Select</option>
                                                <option value="M">Male</option>
                                                <option value="F">Female</option>
                                            </select>
                                        </div>
                                        <span class="mb-2 has-text-danger" v-if="errors['gender']">
						{{errors['gender'][0]}}
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
                                    <label class="label ">NSSF No<span><sup>*</sup></span></label>
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
                                    <label class="label ">KRA Pin<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.kraPinNumber"
                                                @input="clearFieldError('kraPinNumber')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger" v-if="errors['kraPinNumber']">
						{{errors['kraPinNumber'][0]}}
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
    import {DatePicker} from "element-ui"
    import DepartmentSelectInput from "../../../common/DepartmentSelectInput";
    import DesignationSelectInput from "../../../common/DesignationSelectInput";
    import EmployeeSelectInput from "../../../common/EmployeeSelectInput"

    export default {
        components: {
            DatePicker,
            DepartmentSelectInput,
            DesignationSelectInput,
            EmployeeSelectInput
        },
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
    .datepicker {
        min-width: 100%;
    }
</style>