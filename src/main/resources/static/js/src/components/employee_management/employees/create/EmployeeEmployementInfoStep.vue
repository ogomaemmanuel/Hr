<template>
    <div>
        <div>
            <div class="steps-body pt-4 pb-4 pl-0 pr-0">
                <div class="steps-content">
                    <div class="step-content has-text-left is-active animated preFadeInUp fadeInUp">
                        <div class="columns">
                            <div class="column">
                                <div class="field">
                                    <label class="label is-size-7">Department<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.name"
                                                @input="clearFieldError('name')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
                                    </div>
                                </div>
                            </div>
                            <div class="column">
                                <div class="field">
                                    <label class="label is-size-7">Designation<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.name"
                                                @input="clearFieldError('name')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
                                    </div>
                                </div>
                            </div>
                            <div class="column">
                                <div class="field">
                                    <label class="label is-size-7">Salary Amount<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.name"
                                                @input="clearFieldError('name')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="columns">
                            <div class="column">
                                <div class="field">
                                    <label class="label is-size-7">Joining Date<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.name"
                                                @input="clearFieldError('name')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
                                    </div>
                                </div>
                            </div>
                            <div class="column">
                                <div class="field">
                                    <label class="label is-size-7">Designation<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.name"
                                                @input="clearFieldError('name')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
                                    </div>
                                </div>
                            </div>
                            <div class="column">
                                <div class="field">
                                    <label class="label is-size-7">Salary Amount<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="employementDetail.name"
                                                @input="clearFieldError('name')"
                                                class="input"
                                                type="text">
                                        <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <slot :isLoading="isLoading" :onNext="onNext">
            </slot>
        </div>
    </div>
</template>
<script>
    import CommonMixin from "../../../../mixins/common_mixin"

    export default {
        mixins: [CommonMixin],
        data() {
            return {
                employementDetail: {}
                // step: 0
            }
        },
        methods: {
            onNext() {
                let vm = this;
                vm.$emit("goToNext", false)
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

        .step-item {
            margin-top: 0;
            position: relative;
            -ms-flex-positive: 1;
            flex-grow: 1;
            -ms-flex-preferred-size: 0;
            flex-basis: 0;
            background: #f2f5f9;
            padding-top: 20px;

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

            & .is-active {
                .step-marker {
                    background-color: #fff;
                    border-color: #00d1b2;
                    color: #00d1b2;
                }
            }

            .step-marker {
                height: 2rem;
                width: 2rem;
                position: absolute;
                left: calc(50% - 1rem);
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
                background: rgb(181, 181, 181);
                color: #fff;
                border: 0.2em solid rgb(255, 255, 255);
                z-index: 1;
            }
        }
    }


</style>