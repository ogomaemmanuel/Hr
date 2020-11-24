<template>
    <ModalTemplate @modalClosed="$emit('modalClosed')">
        <div slot="modal-content">
            <h4 class="title is-4 text-center">Assign the user to this project</h4>
            <div>
                <form>
                    <ProjectMemberSelectInput
                            v-model="member"
                            :clear-on-select="true"
                            @input="addProjectMember"
                            :show-label="false">
                    </ProjectMemberSelectInput>
                    <div class="mt-3">
                        <div v-for="member in projectMembers" class="card divide-none">
                            <div class="card-content p-2">
                                <article class="media">
                                    <figure class="media-left">
                                        <p class="image is-32x32">
                                            <img class="is-rounded"
                                                 src="https://bulma.io/images/placeholders/128x128.png">
                                        </p>
                                    </figure>
                                    <div class="media-content">
                                        <div class="content">
                                            <p>
                                                <strong>{{member.fullName}}</strong> <small>@johnsmith</small> <small>31m</small>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="media-right">
                                        <button type="button" class="delete"></button>
                                    </div>
                                </article>
                            </div>
                        </div>
                    </div>
                    <div class="flex justify-center m-3">
                        <button
                                :class="{'is-loading':isLoading}"
                                :disabled="isLoading"
                                @click.prevent.stop="submitMembers()"
                                class="button  is-rounded"
                                type="submit">Add Members
                        </button>
                    </div>

                </form>
            </div>
        </div>
    </ModalTemplate>
</template>
<script>
    import ModalTemplate from "../../common/ModalTemplate";
    import ProjectMemberSelectInput from "../../common/ProjectMemberSelectInput";
    import {Message} from "element-ui"

    export default {
        props: {
            projectId: {
                required: true
            }
        },
        components: {
            ModalTemplate,
            ProjectMemberSelectInput
        },
        data() {
            return {
                isLoading: false,
                member: "",
                projectMembers: []
            }
        },
        methods: {
            addProjectMember(member) {
                if (member) {
                    let memberExists = this.projectMembers.find(x => x.id == member.id);
                    if (!memberExists) {
                        this.projectMembers.push(member);
                    }

                }
            },
            submitMembers() {
                let teamMembers = this.projectMembers.map(x->x.id);
                axios.post(`/api/projects/team-members`, {
                    teamMembers: teamMembers;
                }).then(resp => {
                    Message.success(resp.data);
                })
            }
        }
    }
</script>