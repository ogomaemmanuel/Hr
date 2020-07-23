<template>
    <form ref="terminationForm" slot="modal-content" action="">
        <div class="has-text-centered m-3">
            <h1 class="has-text-black"><b>Update Termination</b></h1>
        </div>
        <!--            <div class="field">-->
        <!--                <EmployeeSelectInput-->
        <!--                        :required="true"-->
        <!--                        label="Terminated Employee "-->
        <!--                        v-model="employeeTermination.employeeId"-->
        <!--                        @input="clearFieldError('employeeId')">-->
        <!--                     <span slot="errors" class="mb-2 has-text-danger" v-if="errors['employeeId']">-->
        <!--						{{errors['employeeId'][0]}}-->
        <!--					</span>-->
        <!--                </EmployeeSelectInput>-->
        <!--            </div>-->
        <div class="field">
            <label class="label">Termination Date <span><sup>*</sup></span></label>
            <div class="control is-expanded">
                <div class="select is-fullwidth is-empty">
                    <select v-model="employeeTermination.terminationReasonCode">
                        <option v-for="terminationReason in terminationReasons" :value="terminationReason.code">
                            {{terminationReason.name}}
                        </option>
                        <!--                            <option>With options</option>-->
                    </select>
                </div>
            </div>
        </div>
        <div class="field ">
            <label class="label">Termination Date <span><sup>*</sup></span></label>
            <DatePicker
                    v-model="employeeTermination.terminationDate"
                    class="datepicker">
            </DatePicker>
            <span class="mb-2 has-text-danger" v-if="errors['terminationDate']">
						{{errors['terminationDate'][0]}}
					</span>
        </div>
        <div class="field">
            <label class="label ">Reason <span><sup>*</sup></span></label>
            <div class="control">
                    <textarea
                            required
                            v-model="employeeTermination.reason"
                            class="textarea">
                    </textarea>
                <span class="mb-2 has-text-danger" v-if="errors['reason']">
						{{errors['reason'][0]}}
					</span>
            </div>
        </div>
        <div class="field">
            <label class="label ">Notice Date <span><sup>*</sup></span></label>
            <DatePicker
                    v-model="employeeTermination.noticeDate"
                    class="datepicker"></DatePicker>
            <span class="mb-2 has-text-danger" v-if="errors['noticeDate']">
						{{errors['noticeDate'][0]}}
					</span>
        </div>
        <div class="flex justify-center m-3">
            <button

                    :class="{'is-loading':loading}"
                    @click.prevent.stop="saveTermination"
                    class="button  is-rounded"
                    type="submit">Submit
            </button>
        </div>
    </form>
</template>
<script>
    import EmployeeSelectInput from "../../common/EmployeeSelectInput";
    import common_mixin from "../../../mixins/common_mixin";
    import {DatePicker} from "element-ui"

    export default {
        components: {
            EmployeeSelectInput,
            DatePicker
        },
        mixins: [common_mixin],
        props: {
            id: {
                required: true
            }
        },
        data() {
            return {
                selectedTerminationReason: null,
                terminationReason: "",
                loading: false,
                employeeTermination: {},
                terminationReasons: []
            }
        },
        computed: {
            filteredDataArray() {
                return this.terminationReasons.filter((option) => {
                    return option
                        .toString()
                        .toLowerCase()
                        .indexOf(this.terminationReason.toLowerCase()) >= 0
                })
            }
        },
        created() {
            this.intialize();
        },
        methods: {
            getTerminationReasons() {
                return axios.get("/api/employee-terminations-reasons");
                //     .then(resp => {
                //     this.terminationReasons = resp.data;
                // })
            },
            getTerminationById() {
                return axios.get(`/api/employee-terminations`);
            },

            intialize() {
                axios.all([this.getTerminationReasons(), this.getTerminationById()])
                    .then(axios.spread((...responses) => {
                        this.terminationReasons = responses[0].data;
                        this.employeeTermination = responses[1].data;
                    }), error => {

                    });
            },

            saveTermination() {
                let vm = this;
                axios.put(`/api/employee-terminations`,
                    this.employeeTermination).then(resp => {
                    vm.$swal({
                        type: "success",
                        title: "Success",
                        text: "Resignation successfully saved"
                    })
                    this.$emit("terminationSaved")
                }, error => {
                    if (error.response.status == 400) {
                        this.errors = error.response.data;
                    }
                })

            }
        }
    }
</script>