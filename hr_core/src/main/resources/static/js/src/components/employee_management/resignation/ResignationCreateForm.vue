<template>
    <ModalTemplate @modalClosed="$emit('modalClosed')">
        <div slot="modal-content">
            <form>
                <div class="has-text-centered m-3">
                    <h1 class="has-text-black"><b>Add Resignation</b></h1>
                </div>
                <EmployeeSelectInput
                        :required="false"
                        label="Employee"
                        v-model="employeeResignation.employeeId"
                        @input="clearFieldError('employeeId')">
                </EmployeeSelectInput>

                <div class="field">
                    <label class="label ">Notice Date<span><sup>*</sup></span></label>
                    <div class="control">
                        <DatePicker
                                class="datepicker"
                                v-model="employeeResignation.noticeDate"
                                @input="clearFieldError('noticeDate')"
                        >
                        </DatePicker>

                        <span class="mb-2 has-text-danger"
                              v-if="errors['noticeDate']">
						{{errors['noticeDate'][0]}}
					</span>
                    </div>
                </div>
                <div class="field">
                    <label class="label ">Resignation Date<span><sup>*</sup></span></label>
                    <div class="control">
                        <DatePicker
                                class="datepicker"
                                v-model="employeeResignation.resignationDate"
                                @input="clearFieldError('resignationDate')"
                        >
                        </DatePicker>

                        <span class="mb-2 has-text-danger"
                              v-if="errors['resignationDate']">
						{{errors['resignationDate'][0]}}
					</span>
                    </div>
                </div>

                <div class="field">
                    <label class="label ">Reason <span><sup>*</sup></span></label>
                    <div class="control">
                        <textarea
                                @input="clearFieldError('reason')"
                                class="textarea is-primary"
                                v-model="employeeResignation.reason"
                                placeholder="Primary textarea"></textarea>
                        <span class="mb-2 has-text-danger" v-if="errors['reason']">
						{{errors['reason'][0]}}
					</span>
                    </div>
                </div>
                <div class="flex justify-center m-3">
                    <button

                            :class="{'is-loading':loading}"
                            @click.prevent.stop="saveResignation"
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
                employeeResignation: {},
                loading: false
            }
        },
        methods: {
            saveResignation() {
                let vm = this;
                axios.post("/api/employee-resignations",
                    this.employeeResignation).then(resp => {
                    vm.$swal({
                        type: "success",
                        title: "Success",
                        text: "Resignation successfully saved"
                    })
                    this.$emit("resignationSaved")
                }, error => {
                    if (error.response.status == 400) {
                        this.errors = error.response.data;
                    }
                })

            }
        }
    }
</script>
<style scoped lang="scss">
    .datepicker {
        min-width: 100%;
    }
</style>