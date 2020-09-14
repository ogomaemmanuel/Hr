<template>
    <div>
        <form>
            <div class="has-text-centered m-3">
                <h1 class="has-text-black"><b>Add Client</b></h1>
            </div>
            <div class="columns">
                <div class="column">
                    <div class="field">
                        <label class="label">First Name <span><sup>*</sup></span></label>
                        <div class="control">
                            <input
                                    v-model="client.name"
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
                        <label class="label">Last Name <span><sup>*</sup></span></label>
                        <div class="control">
                            <input
                                    v-model="client.name"
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
                        <label class="label">Email<span><sup>*</sup></span></label>
                        <div class="control">
                            <input
                                    v-model="client.name"
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
                        <label class="label">Phone<span><sup>*</sup></span></label>
                        <div class="control">
                            <input
                                    v-model="client.name"
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

            <div class="field">
                <label class="label">Company Name<span><sup>*</sup></span></label>
                <div class="control">
                    <input
                            v-model="client.name"
                            @input="clearFieldError('name')"
                            class="input"
                            type="text">
                    <span class="mb-2 has-text-danger" v-if="errors['name']">
						{{errors['name'][0]}}
					</span>
                </div>
            </div>
            <div class="field">
                <label class="label">Description <span><sup>*</sup></span></label>
                <div class="control">
                    <MarkdownEditor
                            v-model="client.description"
                            @input="clearFieldError('description')"
                    >
                    </MarkdownEditor>
                    <span class="mb-2 has-text-danger" v-if="errors['description']">
						{{errors['description'][0]}}
					</span>
                </div>
            </div>

            <div class="flex justify-center m-3">
                <button
                        :class="{'is-loading':isLoading}"
                        :disabled="isLoading"
                        @click.prevent.stop="createClient"
                        class="button  is-rounded"
                        type="submit">Submit
                </button>
            </div>
        </form>
    </div>
</template>
<script>
    import common_mixin from "../../../mixins/common_mixin";
    import MarkdownEditor from "../../common/MarkdownEditor/index"

    export default {
        components: {
            MarkdownEditor
        },
        mixins: [common_mixin],
        data() {
            return {
                client: {},
                isLoading: false
            }
        },
        methods: {
            createClient() {

            }
        }
    }
</script>