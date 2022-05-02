<template>
    <form>
        <div class="has-text-centered m-3">
            <h1 class="has-text-black"><b>Update Resignation</b></h1>
        </div>
        <!--        <EmployeeSelectInput-->
        <!--                :required="false"-->
        <!--                label="Employee"-->
        <!--                v-model="employeeResignation.employeeId"-->
        <!--                @input="clearFieldError('employeeId')">-->
        <!--        </EmployeeSelectInput>-->

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
                    @click.prevent.stop="updateDesignation"
                    class="button  is-rounded"
                    type="submit">Submit
            </button>
        </div>
    </form>
</template>
<script>
    import CommonMixin from "../../../mixins/common_mixin"
    import EmployeeSelectInput from "../../common/EmployeeSelectInput";
    import {DatePicker} from "element-ui"

    export default {
        props: {
            id: {
                required: true
            }
        },
        mixins: [CommonMixin],
        components: {
            DatePicker,
            EmployeeSelectInput
        },
        created() {
            this.getDesignation();
        },
        data() {
            return {
                loading: false,
                employeeResignation: {}
            }
        },
        methods: {
            getDesignation() {
                let vm = this;
                axios.get(`/api/employee-resignations/${this.id}`).then(resp => {
                    this.employeeResignation = resp.data;
                })
            },
            updateDesignation() {
                let vm = this;
                axios.put(`/api/employee-resignations/${this.id}`,
                    this.employeeResignation).then(resp => {
                    vm.$swal({
                        type: "success",
                        title: "Success",
                        text: "Resignation  update successful "
                    })
                    this.$emit("designationUpdated");
                })
            }
        }
    }
</script>