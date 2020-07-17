<template>
    <ModalTemplate width="900" @modalClosed="$emit('modalClosed')">
        <form slot="modal-content" action="">
            <div class="has-text-centered m-3">
                <h1 class="has-text-black"><b>Add Termination</b></h1>
            </div>
            <div class="field">
                <EmployeeSelectInput
                        :required="true"
                        label="Terminated Employee "
                        v-model="employeeTermination.employeeId"
                        @input="clearFieldError('employeeId')">
                     <span slot="errors" class="mb-2 has-text-danger" v-if="errors['employeeId']">
						{{errors['employeeId'][0]}}
					</span>
                </EmployeeSelectInput>
            </div>
            <div class="field">
                <label class="label">Termination Date <span><sup>*</sup></span></label>
                <div class="control is-expanded">
                    <div class="select is-fullwidth is-empty">
                        <select v-model="employeeTermination.terminationReasonCode">
                            <option v-for="terminationReason in terminationReasons" :value="terminationReason.code">{{terminationReason.name}}</option>
<!--                            <option>With options</option>-->
                        </select>
                    </div>
                </div>
            </div>
            <!--            <b-field :message="errors['terminationDate']?errors['terminationDate'][0]:''" label="Termination Type">-->
            <!--                <b-autocomplete-->
            <!--                        :keep-first="true"-->
            <!--                        :expanded="true"-->
            <!--                        field="name"-->
            <!--                        v-model="terminationReason"-->
            <!--                        :data="filteredDataArray"-->
            <!--                        clearable-->
            <!--                        @select="option => selectedTerminationReason = option">-->
            <!--                    <template slot="empty">No results found</template>-->
            <!--                </b-autocomplete>-->
            <!--            </b-field>-->
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
    </ModalTemplate>

</template>
<script>
    import ModalTemplate from "../../common/ModalTemplate";
    import EmployeeSelectInput from "../../common/EmployeeSelectInput";
    import common_mixin from "../../../mixins/common_mixin";
    import {DatePicker} from "element-ui"

    export default {
        mixins: [common_mixin],
        components: {
            ModalTemplate,
            EmployeeSelectInput,
            DatePicker
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
        created() {
            this.getTerminationReasons();
        },
        methods: {
            getTerminationReasons() {
                axios.get("/api/employee-terminations-reasons").then(resp => {
                    this.terminationReasons = resp.data;
                })
            },
            saveTermination() {
                axios.post(`/api/employee-terminations`,
                    this.employeeTermination).then(resp => {
                }, error => {
                    if (error.response.status == 400) {
                        this.errors = error.response.data;
                    }
                })
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
        }
    }
</script>