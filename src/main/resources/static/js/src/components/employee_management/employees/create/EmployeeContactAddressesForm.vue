<template>
    <div>
        <div>
            <div class="steps-body pt-4 pb-4 pl-0 pr-0">
                <div class="steps-content">
                    <div class="step-content has-text-left is-active animated preFadeInUp fadeInUp">

                        <template v-for="(index,contactAddress) in contactAddresses">
                            <div class="flex is-hidden-desktop justify-end">
                                        <i class="fa fa-trash has-text-danger"></i>
                            </div>
                            <div class="columns">
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
                                <div class="column is-relative">
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
                                    <i v-if="contactAddresses.length > 0"

                                       @click="removeRow(index)"
                                       class="fa fa-trash has-text-danger delete-contact is-hidden-mobile"></i>
                                </div>
                            </div>
                        </template>

                        <div class="flex justify-end">
                            <div>
                                <button class="button" @click="addRow()">
                                    <i class="fa fa-plus"></i>
                                </button>
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
            addRow() {
                this.contactAddresses.push({})
            },
            removeRow() {

            }

        }
    }
</script>
<style lang="scss" scoped>
    .delete-contact {
        position: absolute;
        top: 3rem;
        right: -0.2rem;
    }
</style>
