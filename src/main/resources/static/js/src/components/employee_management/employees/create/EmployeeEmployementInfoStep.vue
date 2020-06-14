<template>
    <div>
        <div>
            <div  class="steps-body pt-4 pb-4 pl-0 pr-0">
                <div data-v-5d80c0af="" class="steps-content">
                    <div data-v-5d80c0af="" class="step-content has-text-left is-active animated preFadeInUp fadeInUp">
                        <div class="columns">
                            <div class="column">
                                <div class="field">
                                    <label class="label is-size-7">First Name <span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="basicInfo.name"
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
                                    <label class="label is-size-7">Second Name <span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="basicInfo.name"
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
                                    <label class="label is-size-7">Phone<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="basicInfo.name"
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
                                    <label class="label is-size-7">Email<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="basicInfo.name"
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
                                    <label class="label is-size-7">Date of Birth<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="basicInfo.name"
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
                                    <label class="label is-size-7">Id No<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="basicInfo.name"
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
                                    <label class="label is-size-7">Residential Address<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="basicInfo.name"
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
                                    <label class="label is-size-7">Postal Address<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="basicInfo.name"
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
                                    <label class="label is-size-7">Marital Status<span><sup>*</sup></span></label>
                                    <div class="control">
                                        <input
                                                v-model="basicInfo.name"
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
            <div class="nav-wrapper step-content has-text-left is-active animated preFadeInUp fadeInUp"
                 style="width: 95%; bottom: 30px;">
                <div  class="col-md-12">
                    <div  class="steps-actions "><!---->
                        <div class="steps-action pl-3 step-action-next-button-wrapper">
                            <button type="button" data-nav="next"
                                    class="button btn success-btn btn-align ">
                                Next
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                // step: 0
            }
        },
        methods: {

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