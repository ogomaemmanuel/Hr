<template>
    <ModalTemplate @modalClosed="$emit('modalClosed')">
        <div slot="modal-content">
            <div>
                <form>
                    <div class="has-text-centered m-3">
                        <h1 class="has-text-black"><b>Update Deduction</b></h1>
                    </div>
                    <div class="field">
                        <label class="label">Name<span><sup>*</sup></span></label>
                        <div class="control">
                            <input
                                    v-model="deduction.name"
                                    @input="clearFieldError('name')"
                                    class="input"
                                    type="text">
                            <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Calculation <span><sup>*</sup></span></label>
                        <div class="control">
                            <div class="block">
                                <b-radio v-model="deduction.calculation"
                                         name="name"
                                         native-value="PERCENTAGE">
                                    Percentage
                                </b-radio>
                                <b-radio v-model="deduction.calculation"
                                         name="name"
                                         native-value="FLAT_RATE">
                                    Flat Rate
                                </b-radio>
                            </div>

                        </div>
                    </div>
                    <div class="field">
                        <label class="label"> Amount <span><sup>*</sup></span></label>
                        <div class="control">
                            <input
                                    v-model="deduction.amount"
                                    @input="clearFieldError('amount')"
                                    class="input"
                                    type="text">
                            <span class="mb-2 has-text-danger" v-if="errors['amount']">
						{{errors['amount'][0]}}
					</span>
                        </div>
                    </div>
                    <div class="flex justify-center m-3">
                        <button
                                :class="{'is-loading':loading}"
                                :disabled="false"
                                @click.prevent.stop="updateDeduction()"
                                class="button  is-rounded"
                                type="submit">Submit
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </ModalTemplate>
</template>
<script>
    import ModalTemplate from "../../../common/ModalTemplate";
    import common_mixin from "../../../../mixins/common_mixin";

    export default {
        components: {
            ModalTemplate
        },
        mixins: [
            common_mixin
        ],
        props:
            {
                id: {
                    required: true
                }
            },
        data() {
            return {
                deduction: {},
                loading: false,
            }
        },
        created() {
            this.getDeductionById();
        },
        methods: {
            getDeductionById() {
                axios.get(`/api/payroll-deductions/${this.id}`).then(resp => {
                    this.deduction = resp.data;
                })
            },
            updateDeduction() {
                this.loading = true
                axios.put(`/api/payroll-deductions/${this.id}`,
                    this.deduction).then(resp => {
                    this.loading = false
                    this.$swal({
                        type: "success",
                        title: "Success",
                        text: "Payroll deduction successfully updated"
                    })
                    this.$emit("payrollDeductionUpdated");
                }, error => {
                    this.loading = false
                    if (error.response.status == 400) {
                        this.errors = error.response.data;
                    }
                })
            }
        }
    }
</script>
<style scoped lang="scss">

</style>