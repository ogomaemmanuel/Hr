<template>
    <div>
        <div class="steps" id="stepsDemo3">
            <!-- Indicator -->
            <div @click.prevent="setStem(0)" :class="{'is-active':step>=0}"
                 class="step-item">
                <div class="step-marker">1</div>
                <div class="step-details">
                    <p class="step-title">Basic Info</p>
                </div>
            </div>
            <!-- Indicator -->
            <div @click.prevent="setStem(1)" :class="{'is-active':step>=1}"
                 class="step-item">
                <div class="step-marker">2</div>
                <div class="step-details">
                    <p class="step-title">Employement Details</p>
                </div>
            </div>
            <!-- Indicator -->
            <div @click.prevent="setStem(2)" :class="{'is-active':step>=2}"
                 class="step-item">
                <div class="step-marker">3</div>
                <div class="step-details">
                    <p class="step-title">Statutory Numbers</p>
                </div>
            </div>
            <!-- Indicator -->
            <div @click.prevent="setStem(3)" :class="{'is-active':step>=3}"
                 class="step-item">
                <div class="step-marker">4</div>
                <div class="step-details">
                    <p class="step-title">Employee Contact Address</p>
                </div>
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
              step:0
            }
        },
        methods:{
            setStep(step){

            }
        }
    }
</script>
<style lang="scss" scoped>
    .steps {
        display: -ms-flexbox;
        display: flex;
        -ms-flex-wrap: wrap;
        flex-wrap: wrap;
        font-size: 1rem;
        min-height: 2rem;
        flex-wrap: nowrap !important;
        &:not(:last-child) {
            margin-bottom: 1.5rem;
        }
        .step-item {
            margin-top: 0;
            position: relative;
            -ms-flex-positive: 1;
            flex-grow: 1;
            -ms-flex-preferred-size: 0;
            flex-basis: 0;
            background: #f2f5f9;
            padding-top: 20px;
            &:before {
                background: linear-gradient(to left, #dbdbdb 50%, #00d1b2 50%);
                background-position-x: 0%;
                background-position-y: 0%;
                background-size: auto;
                background-size: 200% 100%;
                background-position: right bottom;
            }
           &:not(:first-child){
               &:before{
                   height: .2em;
                   width: 100%;
                   bottom: 0;
                   left: -50%;
                   top: 2.2rem;
                   content: " ";
                   display: block;
                   position: absolute;
               }
           }
            .step-marker {
                -ms-flex-align: center;
                align-items: center;
                display: -ms-flexbox;
                display: flex;
                border-radius: 50%;
                font-weight: 700;
                -ms-flex-pack: center;
                justify-content: center;
                background-color: rgb(181, 181, 181);
                color: #fff;
                border: 0.2em solid rgb(255, 255, 255);
                z-index: 1;
                height: 2rem;
                width: 2rem;
                position: absolute;
                left: calc(50% - 1rem);
            }
            .step-details {
                margin-top: 2rem;
                margin-left: .5em;
                margin-right: .5em;
                padding-top: .2em;
                text-align: center;
                .step-title {
                    font-size: 0.9rem;
                    font-weight: 500;
                }
            }
            &.is-active{
                .step-marker {
                    background-color: #fff;
                    border-color: #00d1b2;
                    color: #00d1b2;
                }
            }
        }
    }
</style>