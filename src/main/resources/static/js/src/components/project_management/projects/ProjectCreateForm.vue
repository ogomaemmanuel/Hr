<template>
    <div>
        <form>
            <div class="has-text-centered m-3">
                <h1 class="has-text-black"><b>Create Project</b></h1>
            </div>
            <div class="columns">
                <div class="column">
                    <div class="field">
                        <label class="label">Project Name <span><sup>*</sup></span></label>
                        <div class="control">
                            <input
                                    v-model="project.name"

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
                        <label class="label">Client<span><sup>*</sup></span></label>
                        <div class="control">
                            <input
                                    v-model="project.clientId"
                                    @input="clearFieldError('clientId')"
                                    class="input"
                                    type="text">
                            <span class="mb-2 has-text-danger" v-if="errors['clientId']">
						{{errors['clientId'][0]}}
					</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="columns">
                <div class="column">
                    <div class="field">
                        <label class="label">Start Date<span><sup>*</sup></span></label>
                        <div class="control">
                            <input
                                    v-model="project.startDate"
                                    @input="clearFieldError('startDate')"
                                    class="input"
                                    type="text">
                            <span class="mb-2 has-text-danger" v-if="errors['startDate']">
						{{errors['startDate'][0]}}
					</span>
                        </div>
                    </div>
                </div>
                <div class="column">
                    <div class="field">
                        <label class="label">End Date<span><sup>*</sup></span></label>
                        <div class="control">
                            <input
                                    v-model="project.endDate"
                                    @input="clearFieldError('endDate')"
                                    class="input"
                                    type="text">
                            <span class="mb-2 has-text-danger" v-if="errors['endDate']">
						{{errors['endDate'][0]}}
					</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="columns">
                <div class="column">
                    <div class="columns flex">
                        <div class="column is-6-mobile">
                            <div class="field">
                                <label class="label">Rate<span><sup>*</sup></span></label>
                                <div class="control">
                                    <input
                                            v-model="project.rate"
                                            @input="clearFieldError('rate')"
                                            class="input"
                                            type="text">
                                    <span class="mb-2 has-text-danger" v-if="errors['rate']">
						{{errors['rate'][0]}}
					</span>
                                </div>
                            </div>
                        </div>
                        <div class="column mt-8 is-6-mobile">
                            <div class="control">
                                <input
                                        v-model="project.startDate"
                                        @input="clearFieldError('startDate')"
                                        class="input"
                                        type="text">
                                <span class="mb-2 has-text-danger" v-if="errors['startDate']">
						{{errors['startDate'][0]}}
					</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="column">
                    <div class="field">
                        <label class="label">Priority<span><sup>*</sup></span></label>
                        <div class="control">
                            <input
                                    v-model="project.priority"
                                    @input="clearFieldError('priority')"
                                    class="input"
                                    type="text">
                            <span class="mb-2 has-text-danger" v-if="errors['priority']">
						{{errors['priority'][0]}}
					</span>
                        </div>
                    </div>
                </div>
            </div>


            <div class="columns">
                <div class="column">
                    <div class="field">
                        <label class="label">Add Project Leader <span><sup>*</sup></span></label>
                        <div class="control">
                            <input
                                    v-model="project.name"

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
                        <label class="label">Team Leader<span><sup>*</sup></span></label>
                        <!--                        <div class="control">-->
                        <!--                            <input-->
                        <!--                                    v-model="project.clientId"-->
                        <!--                                    @input="clearFieldError('clientId')"-->
                        <!--                                    class="input"-->
                        <!--                                    type="text">-->
                        <!--                            <span class="mb-2 has-text-danger" v-if="errors['clientId']">-->
                        <!--						{{errors['clientId'][0]}}-->
                        <!--					</span>-->
                        <!--                        </div>-->
                    </div>
                </div>
            </div>
            <div class="columns">
                <div class="column">
                    <div class="field">
                        <label class="label">Add Team <span><sup>*</sup></span></label>
                        <div class="control">
                            <input
                                    v-model="project.name"

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
                        <label class="label">Team Members<span><sup>*</sup></span></label>
                    </div>
                </div>
            </div>
            <div>
                <div class="field">
                    <label class="label">Description<span><sup>*</sup></span></label>
                    <MarkdownEditor></MarkdownEditor>
                </div>
            </div>

            <div class="field">
                <div class="control">
                    <label class="label">Upload File<span><sup>*</sup></span></label>
                    <div class="file has-name is-fullwidth">
                        <label class="file-label">
                            <input class="file-input" type="file" name="resume">
                            <span class="file-cta">
      <span class="file-icon">
        <i class="fas fa-upload"></i>
      </span>
      <span class="file-label">
        Browse…
      </span>
    </span>
                            <span class="file-name">
      Screen Shot 2017-07-29 at 15.54.25.png
    </span>
                        </label>
                    </div>
                </div>
            </div>

            <div class="flex justify-center m-3">
                <button
                        :class="{'is-loading':isLoading}"
                        :disabled="isLoading"
                        @click.prevent.stop="createProject"
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
                project: {
                    user: {}
                },
                isLoading: false
            }
        },
        methods: {
            createProject() {
                this.isLoading = true
                axios.post("/api/projects",
                    this.project).then(resp => {
                    this.isLoading = false;
                    this.$emit("createSuccessful");
                }, error => {
                    this.isLoading = false;
                    if (error.response.status == 400) {
                        this.errors = error.response.data;
                    }
                })
            }
        }
    }
</script>