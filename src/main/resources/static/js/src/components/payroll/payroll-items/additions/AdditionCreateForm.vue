<template>
    <ModalTemplate>
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
                                <b-radio v-model="addition.percentage"
                                         name="name"
                                         native-value="Jack">
                                    Percentage
                                </b-radio>
                                <b-radio v-model="addition.flatRate"
                                         name="name"
                                         native-value="Vane">
                                    Flat Rate
                                </b-radio>
                            </div>

                        </div>
                    </div>
                    <div class="field">
                        <label class="label"> Amount <span><sup>*</sup></span></label>
                        <div class="control">
                            <input
                                    v-model="addition.amount"
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
                                @click.prevent.stop=""
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
        mixins: [
            common_mixin
        ],
        components: {
            ModalTemplate
        },
        data() {
            return {
                addition: {},
                loading:false,
            }
        }
    }
</script>
<style scoped lang="scss">

</style>