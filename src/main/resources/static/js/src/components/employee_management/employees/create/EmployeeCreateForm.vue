<template>
    <div>
        <div class="card">
            <div class="card-content">
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
                            <p class="step-title">Employee Contact Address</p>
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
                <keep-alive>
                    <component :errorsData="errors" :employeeDetails="employeeDetails"
                               @goToNext="goToNextStep" :is="currentForm">
                        <div slot-scope="{isLoading,canMoveNext,onNext}"
                             class="nav-wrapper step-content has-text-left is-active animated preFadeInUp fadeInUp"
                             style="bottom: 30px;">
                            <div class="col-md-12">
                                <div class="steps-actions flex flex-row-reverse justify-between">
                                    <div class="steps-action pl-3 step-action-next-button-wrapper">
                                        <button :class="{'is-loading':isLoading}"
                                                :disabled="isLoading || canMoveNext==false"
                                                @click="onNext" type="button"
                                                data-nav="next"
                                                class="button btn success-btn btn-align ">
                                            Next
                                        </button>
                                    </div>
                                    <div v-if="step>0" class="steps-action step-action-prev-button-wrapper">
                                        <button @click="step--" type="button"
                                                data-nav="previous"
                                                class="button btn default-btn raised btn-align">
                                            Previous
                                        </button>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </component>
                </keep-alive>
            </div>
        </div>
    </div>
</template>
<script>
    import EmployeeBasicInfoStep from "./EmployeeBasicInfoStep";
    import EmployeeInfoStep from "./EmployeeEmployementInfoStep";
    import EmployeeContactAddressesForm from "./EmployeeContactAddressesForm";
    import EmployeeCreateComplete from "./EmployeeCreateComplete";
    import common_mixin from "../../../../mixins/common_mixin";

    export default {
        mixins: [common_mixin],
        components: {
            EmployeeBasicInfoStep,
            EmployeeInfoStep,
            EmployeeContactAddressesForm,
            EmployeeCreateComplete
        },
        data() {
            return {
                step: 0,
                employeeDetails: {},
                visitedSteps: new Set(),
            }
        },
        created() {
            this.setVisited(0);
        },
        computed: {
            currentForm() {
                if (this.step == 0) {
                    return EmployeeBasicInfoStep;
                }
                if (this.step == 1) {
                    return EmployeeInfoStep;
                }
                if (this.step == 2) {
                    return EmployeeContactAddressesForm;
                }
                if (this.step == 3) {
                    return EmployeeCreateComplete;
                }
            }
        },
        methods: {
            setStem(index) {
                let vm = this;
                if (this.visitedSteps.has(index) || index < this.step) {
                    this.step = index;

                }
                //this.step = index;
            },
            setVisited(index) {
                this.visitedSteps.add(index);
            },
            createEmployee() {
                axios.post("/api/employees",
                    this.employeeDetails).then(resp => {
                    this.step = 3
                }, error => {
                    if (error.response.status == 400) {
                        this.errors = error.response.data;
                    }
                })
            },
            goToNextStep(employeeDetails) {
                let vm = this;
                if (employeeDetails) {
                    this.employeeDetails = {
                        ...vm.employeeDetails,
                        // account: fundRaiserAccountDetails.account
                    };
                }
                if (vm.step == 2) {
                    vm.createEmployee();
                    return;
                }
                vm.step++;
                vm.setVisited(vm.step)
            },
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
            padding-bottom: 15px;

            &:before {
                background: linear-gradient(to left, #dbdbdb 50%, #00d1b2 50%);
                background-position-x: 0%;
                background-position-y: 0%;
                background-size: auto;
                background-size: 200% 100%;
                background-position: right bottom;
            }

            &:not(:first-child) {
                &:before {
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

            &.is-active {
                &:before {
                    background-position: left bottom;
                }

                .step-marker {
                    background-color: #fff;
                    border-color: #00d1b2;
                    color: #00d1b2;
                }
            }
        }
    }
</style>