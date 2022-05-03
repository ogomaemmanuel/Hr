<template>
    <ModalTemplate @modalClosed="$emit('modalClosed')">
        <div slot="modal-content">
            <div>
                <form>
                    <div class="has-text-centered m-3">
                        <h1 class="has-text-black"><b>Add Addition</b></h1>
                    </div>
                    <div class="field">
                        <label class="label"> Name <span><sup>*</sup></span></label>
                        <div class="control">
                            <input
                                    v-model="addition.name"
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
                                <b-radio v-model="addition.calculation"
                                         name="name"
                                         native-value="PERCENTAGE">
                                    Percentage of Basic Salary
                                </b-radio>
                                <b-radio v-model="addition.calculation"
                                         name="name"
                                         native-value="FLAT_RATE">
                                    Fixed Amount
                                </b-radio>
                            </div>

                        </div>
                    </div>
<!--                    <b-field label="Amount">-->
<!--                        <b-numberinput-->
<!--                                :controls="false"-->
<!--                                expanded-->
<!--                                v-model="addition.amount"-->
<!--                                @input="clearFieldError('amount')"-->
<!--                                controls-position="compact"-->
<!--                                controls-rounded>-->
<!--                        </b-numberinput>-->
<!--                    </b-field>-->
                                        <div class="field">
                                            <label class="label"> Amount <span><sup>*</sup></span></label>
                                            <div class="control">
                                                <InputNumber
                                                        class="min-w-full"
                                                        v-model="addition.amount"
                                                        :controls="false"
                                                        :max="maxAmount"
                                                        :min="0"
                                                        @input="clearFieldError('amount')"
                                                        type="number">
                                                </InputNumber>
                                                <span class="mb-2 has-text-danger" v-if="errors['amount']">

                    						{{errors['amount'][0]}}
                    					</span>
                                            </div>
                                        </div>
                    <div class="flex justify-center m-3">
                        <button
                                :class="{'is-loading':loading}"
                                :disabled="false"
                                @click.prevent.stop="createAddition()"
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
    import {InputNumber} from "element-ui"

    export default {
        mixins: [
            common_mixin
        ],
        components: {
            ModalTemplate,
            InputNumber
        },
        data() {
            return {
                addition: {},
                loading: false,
            }
        },
        computed:{
            maxAmount(){
                if(this.addition.calculation=="PERCENTAGE"){
                    return 100;
                }else {
                    return Infinity
                }
            }
        },
        methods: {
            createAddition() {
                this.loading = true;
                axios.post(`/api/payroll-additions`,
                    this.addition).then(resp => {
                    this.loading = false;
                    this.$swal({
                        type: "success",
                        title: "Success",
                        text: "Payroll addition successfully saved"
                    })
                    this.$emit("payrollAdditionCreated");
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