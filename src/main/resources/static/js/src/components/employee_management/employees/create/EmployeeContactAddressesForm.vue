<template>
    <div>
        <div>
            <div class="steps-body pt-4 pb-4 pl-0 pr-0">
                <div class="steps-content">
                    <div class="step-content has-text-left is-active animated preFadeInUp fadeInUp">

                        <div v-for="(contactAddress,index)  in contactAddresses">
                            <div v-if="contactAddresses.length>1"
                                 class="flex is-hidden-desktop justify-end contact-header">
                                <i @click="removeRow(index)" class="fa fa-trash has-text-danger"></i>
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
                                                    v-model="contactAddress.phone"
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
                                                    v-model="contactAddress.relationshipId"
                                                    @input="clearFieldError('name')"
                                                    class="input"
                                                    type="text">
                                            <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
                                        </div>
                                    </div>
                                    <i v-if="contactAddresses.length > 1"

                                       @click="removeRow(index)"
                                       class="fa fa-trash has-text-danger delete-contact is-hidden-mobile"></i>
                                </div>
                            </div>
                        </div>

                        <div class="flex justify-end pt-2">
                            <div>
                                <button class="button" @click="addRow()">
                                    <i class="fa fa-plus"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <slot :isLoading="isLoading" :canMoveNext="canMoveNext" :onNext="onNext">
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
                contactAddresses: []
            }
        },
        created() {
            this.initialize();
        },
        computed: {
            contactAddressAreValid() {
                return this.contactAddresses.every(value =>
                    this.validateContactAddress(value)
                )
            },
            canMoveNext() {
                return this.contactAddressAreValid;
            }
        },

        methods: {
            onNext() {
                let vm = this;
                vm.$emit("goToNext", false)
            },
            addRow() {
                this.contactAddresses.push({
                    name: "",
                    relationshipId: "",
                    phone: "",
                })
            },
            initialize() {
                this.contactAddresses = [
                    {
                        name: "",
                        relationshipId: "",
                        phone: "",
                    },
                    {
                        name: "",
                        relationshipId: "",
                        phone: "",
                    },
                    {
                        name: "",
                        relationshipId: "",
                        phone: "",
                    },

                ]
            },
            validateContactAddress(contactAddress) {
                return contactAddress.name.length > 0
                    && contactAddress.phone.length > 0
                    && contactAddress.relationshipId.length > 0;
            },
            removeRow(index) {
                if (this.contactAddresses.length > 1) {
                    this.contactAddresses.splice(index, 1);
                }

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

    .contact-header {
        padding: 10px 10px;
        background-color: #fafbfc;
        /*border-bottom: 1px solid #e1e4e8;*/
        border-top-left-radius: 3px;
        border-top-right-radius: 3px;
    }
</style>
