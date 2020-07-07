<template>
    <ModalTemplate @modalClosed="$emit('modalClosed')">
        <div slot="modal-content">
            <form>
                <div class="has-text-centered m-3">
                    <h1 class="has-text-black"><b>Add Overtime</b></h1>
                </div>
                <EmployeeSelectInput
                        :required="false"
                        label="Employee"
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
                                type="number">
                        <span class="mb-2 has-text-danger" v-if="errors['overtimeHours']">
						{{errors['overtimeHours'][0]}}
					</span>
                    </div>
                </div>
                <div class="field">
                    <label class="label ">Description <span><sup>*</sup></span></label>
                    <div class="control">
                        <textarea
                                @input="clearFieldError('description')"
                                class="textarea is-primary"
                                v-model="overtimeRequest.description"
                                placeholder="Primary textarea"></textarea>
                        <span class="mb-2 has-text-danger" v-if="errors['description']">
						{{errors['description'][0]}}
					</span>
                    </div>
                </div>
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
    </ModalTemplate>

</template>

<script>
    import CommonMixin from "../../../mixins/common_mixin"
    import EmployeeSelectInput from "../../common/EmployeeSelectInput";
    import {DatePicker} from "element-ui"
    import ModalTemplate from "../../common/ModalTemplate";

    export default {
        mixins: [CommonMixin],
        components: {
            EmployeeSelectInput,
            ModalTemplate,
            DatePicker
        },
        data() {
            return {
                departments: [],
                overtimeRequest: {
                    employeeId: "",
                    overtimeHours: "",
                    description: "",
                    overtimeDate: ""
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
                axios.post("/api/overtime-requests",
                    this.overtimeRequest).then(resp => {
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
<style scoped lang="scss">
    .datepicker {
        min-width: 100%;
    }
</style>