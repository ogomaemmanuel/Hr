<template>
    <div>
        <form>
            <div class="has-text-centered m-3">
                <h1 class="has-text-black"><b>Update Overtime</b></h1>
            </div>
            <!--            <EmployeeSelectInput-->
            <!--                    :required="false"-->
            <!--                    label="Employee"-->
            <!--                    v-model="overtimeRequest.employeeId"-->
            <!--                    @input="clearFieldError('employeeId')">-->
            <!--            </EmployeeSelectInput>-->

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
                        @click.prevent.stop="updateOvertimeRequest()"
                        class="button  is-rounded"
                        type="submit">Update
                </button>
            </div>
        </form>
    </div>
</template>
<script>
    import common_mixin from "../../../mixins/common_mixin";
    import {DatePicker} from "element-ui"

    export default {
        mixins: [common_mixin],
        components: {
            DatePicker
        },
        props: {
            id: {
                required: true
            }
        },
        created() {
            this.getOvertimeRequest();
        },
        data() {
            return {
                loading: false,
                overtimeRequest: {}
            }
        },
        methods: {
            getOvertimeRequest() {
                axios.get(`/api/overtime-requests/${this.id}`).then(resp => {
                    this.overtimeRequest = resp.data;

                }, error => {

                })
            },
            updateOvertimeRequest() {
                let vm = this;
                axios.put(`/api/overtime-requests/${this.id}`,
                    this.overtimeRequest).then(resp => {
                    vm.$swal({
                        type: "success",
                        title: "Success",
                        text: "Overtime request update successful "
                    })
                    this.$emit("overtimeRequestUpdated")
                }, error => {

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