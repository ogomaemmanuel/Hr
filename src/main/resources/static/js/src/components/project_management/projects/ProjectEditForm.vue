<template>
    <div>
        <template>
            <form>
                <div class="has-text-centered m-3">
                    <h1 class="has-text-black"><b>Edit Project</b></h1>
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
                        <ClientSelectInput
                                v-model="project.clientId"
                                @input="clearFieldError('clientId')"
                                label="Client">
                        <span slot="errors"
                              class="mb-2 has-text-danger"
                              v-if="errors['clientId']">
                            {{errors['clientId'][0]}}
                        </span>
                        </ClientSelectInput>
                    </div>
                </div>
                <div class="columns">
                    <div class="column">
                        <div class="field">
                            <label class="label">Start Date<span><sup>*</sup></span></label>
                            <div class="control">
                                <DatePicker
                                        value-format="yyyy-MM-dd"
                                        class="datepicker"
                                        @input="clearFieldError('startDate')"
                                        v-model="project.startDate">
                                </DatePicker>
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
                                <DatePicker
                                        value-format="yyyy-MM-dd"
                                        v-model="project.endDate"
                                        @input="clearFieldError('endDate')"
                                        class="datepicker">
                                </DatePicker>
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
                                    <div class="select is-fullwidth">
                                        <select
                                                @input="clearFieldError('rateType')"
                                                v-model="project.rateType">
                                            <option>Select</option>
                                            <option value="HOURLY">Hourly</option>
                                            <option value="FIXED">Fixed</option>
                                        </select>
                                    </div>
                                    <span class="mb-2 has-text-danger help" v-if="errors['rateType']">
                                    {{errors['rateType'][0]}}
                                </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="column">
                        <div class="field">
                            <label class="label">Priority<span><sup>*</sup></span></label>
                            <div class="select is-fullwidth">
                                <select
                                        @input="clearFieldError('priority')"
                                        v-model="project.priority">
                                    <option>Select</option>
                                    <option value="HIGH">High</option>
                                    <option value="MEDIUM">Medium</option>
                                    <option value="LOW">Low</option>
                                </select>
                            </div>
                            <span class="mb-2 has-text-danger" v-if="errors['priority']">
                            {{errors['priority'][0]}}
                        </span>
                        </div>
                    </div>
                </div>


                <div class="columns">
                    <div class="column">
                        <ProjectMemberSelectInput
                                label="Add Project Leader"
                                @input="clearFieldError('teamLeaderId')"
                                v-model="project.teamLeader">
                         <span slot="errors"
                               class="mb-2 has-text-danger"
                               v-if="errors['teamLeaderId']">
                            {{errors['teamLeaderId'][0]}}
                        </span>
                        </ProjectMemberSelectInput>
                    </div>
                    <div class="column">
                        <div class="field">
                            <label class="label">Team Leader<span><sup>*</sup></span></label>
                            <figure class="image is-32x32">
                                <img class="is-rounded"
                                     src="https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-16.jpg"
                                     alt="">
                            </figure>
                        </div>
                    </div>
                </div>
                <div class="columns">
                    <div class="column">
                        <ProjectMemberSelectInput
                                label="Add Team"
                                :clear-on-select="true"
                                v-model="projectMember"
                                @input="addProjectMember">
                          <span slot="errors"
                                class="mb-2 has-text-danger"
                                v-if="errors['projectMembersIds']">
                            {{errors['projectMembersIds'][0]}}
                        </span>
                        </ProjectMemberSelectInput>
                    </div>
                    <div class="column">
                        <div class="field">
                            <label class="label">Team Members<span><sup>*</sup></span></label>
                            <div class="flex">
                                <template v-for="(projectMember,index) in project.projectMembers">
                                    <figure v-if="index<5" class="image is-32x32">
                                        <img class="is-rounded"
                                             src="https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-16.jpg"
                                             alt="">
                                    </figure>
                                </template>
                                <div v-if="project.projectMembers.length>=5">
                                    +{{project.projectMembers.length-4}}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div>
                    <div class="field">
                        <label class="label">Description<span><sup>*</sup></span></label>
                        <MarkdownEditor v-model="project.description"></MarkdownEditor>
                        <span class="mb-2 has-text-danger" v-if="errors['description']">
                        {{errors['description'][0]}}
                    </span>
                    </div>
                </div>

                <div class="field">
                    <div class="control">
                        <label class="label">Upload File<span><sup>*</sup></span></label>
                        <div class="file has-name is-fullwidth">
                            <label class="file-label">
                                <input
                                        @change="onFileChange"
                                        class="file-input" type="file" name="resume">
                                <span class="file-cta">
      <span class="file-icon">
        <i class="fa fa-upload"></i>
      </span>
      <span class="file-label">
        Browse…
      </span>
    </span>
                                <span class="file-name">
      {{fileName}}
    </span>
                            </label>
                        </div>
                    </div>
                </div>

                <div class="flex justify-center m-3">
                    <button
                            :class="{'is-loading':isLoading}"
                            :disabled="isLoading"
                            @click.prevent.stop="updateProject()"
                            class="button  is-rounded"
                            type="submit">Submit
                    </button>
                </div>
            </form>
        </template>
    </div>
</template>
<script>
    import MarkdownEditor from "../../common/MarkdownEditor/index"
    import ClientSelectInput from "../../common/ClientSelectInput";
    import ProjectMemberSelectInput from "../../common/ProjectMemberSelectInput";
    import common_mixin from "../../../mixins/common_mixin";
    import {DatePicker} from "element-ui"

    export default {
        props: {
            projectId: {
                required: true
            }
        },
        mixins: [
            common_mixin
        ],
        components: {
            MarkdownEditor,
            ClientSelectInput,
            DatePicker,
            ProjectMemberSelectInput
        },
        data() {
            return {
                project: {
                    user: {},
                    teamLeader: {},
                    projectMembers: []
                },
                fileName: "",
                projectMember: "",
                isLoading: false,
                loaded: false,
                errors: {}
            }
        },
        created() {
            this.getProjectDetails();
        },
        methods: {
            getProjectDetails() {
                this.isLoading = true;
                axios.get(`/api/projects/${this.projectId}`).then(resp => {
                    this.project = resp.data;
                    this.isLoading = false;
                    this.loaded = true;
                }, error => {
                    this.isLoading = false;
                    this.loaded = true;
                })
            },
            addProjectMember(member) {
                if (member) {
                    let memberExists = this.project.projectMembers.find(x => x.id == member.id);
                    if (!memberExists) {
                        this.project.projectMembers.push(member);
                        this.clearFieldError("projectMembersIds");
                    }

                }
            },
            onFileChange(e) {
                const file = e.target.files[0];
                this.project.attachment = file;
                this.fileName = file.name;
            },
            updateProject() {
                this.isLoading = true
                this.project.teamLeaderId =
                    this.project.teamLeader.id;
                this.project.projectMembersIds = this.project.projectMembers.map(x => x.id);
                console.log(this.project);
                let request = this.createFormData(this.project);
                axios.put(`/api/projects/${this.project.id}`, request).then(resp => {
                    this.isLoading = false;
                    this.$emit("updateSuccessful");
                }, error => {
                    this.isLoading = false;
                    if (error.response.status == 400) {
                        this.errors = error.response.data;
                    }
                })
            },

        }
    }
</script>
