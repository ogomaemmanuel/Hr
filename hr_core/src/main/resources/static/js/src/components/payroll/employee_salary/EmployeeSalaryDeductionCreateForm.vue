<template>
    <ModalTemplate @modalClosed="$emit('modalClosed')">
        <div slot="modal-content">
            <form>
                <div class="has-text-centered m-3">
                    <h1 class="has-text-black"><b>Add Salary Deduction</b></h1>
                </div>

                <div class="field">
                    <label class="label ">Name <span><sup>*</sup></span></label>
                    <div class="control">
                        <input
                                @input="clearFieldError('name')"
                                class="input is-primary"
                                v-model="salaryDeduction.name"
                                placeholder="Primary textarea"></input>
                        <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
                    </div>
                </div>
                <div class="field">
                    <label class="label ">Amount <span><sup>*</sup></span></label>
                    <div class="control">
                        <input
                                type="number"
                                @input="clearFieldError('amount')"
                                class="input is-primary"
                                v-model="salaryDeduction.amount"
                                placeholder="Primary textarea"></input>
                        <span class="mb-2 has-text-danger" v-if="errors['amount']">
						{{errors['amount'][0]}}
					</span>
                    </div>
                </div>
                <div class="flex justify-center m-3">
                    <button

                            :class="{'is-loading':loading}"
                            @click.prevent.stop="createSalaryDeduction"
                            class="button  is-rounded"
                            type="submit">Submit
                    </button>
                </div>
            </form>
        </div>
    </ModalTemplate>
</template>
<script>
    import ModalTemplate from "../../common/ModalTemplate";
    import common_mixin from "../../../mixins/common_mixin";

    export default {
        props: {
            employeeId: {
                required: true
            }
        },
        mixins: [
            common_mixin
        ],
        components: {
            ModalTemplate
        },
        data() {
            return {
                salaryDeduction: {},
                loading: false,
            }
        },
        methods: {
            createSalaryDeduction() {
                this.loading = true
                this.salaryDeduction.employeeId = this.employeeId;
                axios.post("/api/employee-payroll-deductions",
                    this.salaryDeduction).then(resp => {
                    this.loading = false
                }, error => {
                    this.loading = false;
                    if (error.response.status == 400) {
                        this.errors = error.response.data;
                    }
                })
            }
        }
    }
</script>