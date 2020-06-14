<template>
    <div>
        <div>
            <div class="steps-body pt-4 pb-4 pl-0 pr-0">
                <div class="steps-content">
                    <div class="step-content has-text-left is-active animated preFadeInUp fadeInUp">
                        <div class="columns">
                            <template v-for="contactAddress in contactAddresses">
                                <div class="column">
                                    <div class="field">
                                        <label class="label is-size-7">Contact Name <span><sup>*</sup></span></label>
                                        <div class="control">
                                            <input
                                                    v-model="contactAddress.name"
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
                                        <label class="label is-size-7">Contact Phone <span><sup>*</sup></span></label>
                                        <div class="control">
                                            <input
                                                    v-model="contactAddress.name"
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
                                        <label class="label is-size-7">Relationship <span><sup>*</sup></span></label>
                                        <div class="control">
                                            <input
                                                    v-model="contactAddress.name"
                                                    @input="clearFieldError('name')"
                                                    class="input"
                                                    type="text">
                                            <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
                                        </div>
                                    </div>
                                </div>
                            </template>
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
                isLoading: false,
                contactAddresses: [
                    {}
                ]
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
