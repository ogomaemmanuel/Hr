<template>
    <ModalTemplate>
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
                </EmployeeSelectInput>
            </div>


                    <div class="field is-grouped">
                        <div class="control is-expanded ">
                            <label class="label">Termination Type <span><sup>*</sup></span></label>

                            <input class="input" type="text">
                        </div>

                        <div class="control">
                            <button type="button" class="button mt-8">Add</button>
                        </div>
                    </div>









            <div class="field">
                <label class="label ">Termination Date <span><sup>*</sup></span></label>
                <div class="control">
                    <input class="input" type="text">
                </div>
            </div>
            <div class="field">
                <label class="label ">Reason <span><sup>*</sup></span></label>
                <div class="control">
                    <textarea class="textarea"></textarea>
                </div>
            </div>
            <div class="field">
                <label class="label ">Notice Date <span><sup>*</sup></span></label>
                <div class="control">
                    <input class="input" type="text">
                </div>
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

    export default {
        mixins: [common_mixin],
        components: {
            ModalTemplate,
            EmployeeSelectInput
        },
        data() {
            return {
                loading: false,
                employeeTermination: {}
            }
        },
        methods: {
            saveTermination() {

            }
        }
    }
</script>