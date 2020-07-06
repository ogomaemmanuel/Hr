<template>
    <div>
        <form>
            <div class="has-text-centered m-3">
                <h1 class="has-text-black"><b>Add Overtime</b></h1>
            </div>
            <EmployeeSelectInput
                    :required="false"
                    label="Supervisor"
                    v-model="overtimeRequest.employeeId"
                    @input="clearFieldError('employeeId')">
            </EmployeeSelectInput>

            <div class="field">
                <label class="label ">Overtime Date<span><sup>*</sup></span></label>
                <div class="control">
                    <DatePicker
                            class="datepicker"
                            v-model="overtimeRequest.overtimeDate"
                            @input="clearFieldError('overtimeDate')"
                    >
                    </DatePicker>

                    <span class="mb-2 has-text-danger"
                          v-if="errors['overtimeDate']">
						{{errors['overtimeDate'][0]}}
					</span>
                </div>
            </div>
            <div class="field">
                <label class="label ">Overtime Hours<span><sup>*</sup></span></label>
                <div class="control">
                    <input
                            v-model="overtimeRequest.overtimeHours"
                            @input="clearFieldError('overtimeHours')"
                            class="input"
                            type="text">
                    <span class="mb-2 has-text-danger" v-if="errors['overtimeHours']">
						{{errors['overtimeHours'][0]}}
					</span>
                </div>
            </div>
            <span slot="message" class="mb-2 has-text-danger" v-if="errors['departmentId']">
						{{errors['departmentId'][0]}}
					</span>
            <div class="flex justify-center m-3">
                <button

                        :class="{'is-loading':loading}"
                        @click.prevent.stop="createOvertimeRequest"
                        class="button  is-rounded"
                        type="submit">Submit
                </button>
            </div>
        </form>
    </div>
</template>

<script>
    import CommonMixin from "../../../mixins/common_mixin"
    import EmployeeSelectInput from "../../common/EmployeeSelectInput";
    import {DatePicker} from "element-ui"
    export default {
        mixins: [CommonMixin],
        components:{
            EmployeeSelectInput,
            DatePicker
        },
        data() {
            return {
                departments: [],
                overtimeRequest: {
                    employeeId: "",
                    overtimeHours: "",
                    description: "",
                    overtimeDate:""
                },
                loading: false,
            }
        },
        computed: {
            disableSubmitButton() {
                return this.designation.name.length <= 0;
            }
        },
        methods: {
            showAddDepartment() {

            },
            createOvertimeRequest() {
                let vm = this;
                axios.post("/api/overtime-requests", this.overtimeRequest).then(resp => {
                    vm.$swal({
                        type: "success",
                        title: "Success",
                        text: "Overtime request successfully saved"
                    })
                    this.$emit("overtimeRequestCreated")
                }, error => {
                    if (error.response.status == 400) {
                        this.errors = error.response.data;
                    }

                })
            },
        },

    }
</script>