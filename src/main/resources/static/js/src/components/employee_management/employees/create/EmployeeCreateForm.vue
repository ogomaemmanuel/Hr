<template>
    <div>
        <div class="steps" id="stepsDemo3">
            <!-- Indicator -->
            <div @click.prevent="setStem(0)" :class="{'is-active':step>=0}"
                 class="step-item">
                <div class="step-marker">1</div>
                <div class="step-details">
                    <p class="step-title">Details</p>
                </div>
            </div>
            <!-- Indicator -->
            <div @click.prevent="setStem(1)" :class="{'is-active':step>=1}"
                 class="step-item">
                <div class="step-marker">2</div>
                <div class="step-details">
                    <p class="step-title">Set Rules</p>
                </div>
            </div>
            <!-- Indicator -->
            <div @click.prevent="setStem(2)" :class="{'is-active':step>=2}"
                 class="step-item">
                <div class="step-marker">3</div>
                <div class="step-details">
                    <p class="step-title">Add Members</p>
                </div>
            </div>
            <!-- Indicator -->
            <div @click.prevent="setStem(3)" :class="{'is-active':step>=3}"
                 class="step-item">
                <div class="step-marker">4</div>
                <div class="step-details">
                    <p class="step-title">Finish</p>
                </div>
            </div>

        </div>
</template>
<script>
    import EmployeeBasicInfoStep from "./EmployeeBasicInfoStep";
    export default {
        components:{},
        data() {
            return {
              step:0;
            }
        },
        methods:{
            setStep(step){

            }
        }
    }
</script>
<style lang="scss" scoped>

</style>