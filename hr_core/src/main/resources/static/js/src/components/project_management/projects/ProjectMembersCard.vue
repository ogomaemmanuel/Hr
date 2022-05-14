<template>
    <div class="card mt-4">
        <div class="card-content">
            <div class="flex">
                <h4 class="font-black flex-1">
                    Assigned users
                </h4>
                <div>
                    <button @click="showAddMemberModal=true"
                            class="button is-small is-primary">
                        <i class="fa fa-plus"></i>
                    </button>
                </div>
            </div>
            <div v-for="member in projectMembers" class="mt-3">
                <div class="flex content-center">
                    <div class="flex items-center">
                        <figure class="image is-32x32">
                            <img class="is-rounded"
                                 src="https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-02.jpg"
                                 alt="">
                        </figure>
                    </div>
                    <div class="pl-1">
                        <div class="font-semibold">
                            {{member.fullName}}
                        </div>
                        <div class="font-medium">
                            {{member.designation}}
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <ProjectAddMemberModal
                :project-id="projectId"
                @modalClosed="showAddMemberModal=false"
                v-if="showAddMemberModal">
        </ProjectAddMemberModal>
    </div>
</template>
<script>
    import ProjectAddMemberModal from "./ProjectAddMemberModal";

    export default {
        components: {
            ProjectAddMemberModal
        },
        props: {
            projectId: {
                required: true
            }
        },
        data() {
            return {
                projectMembers: [],
                showAddMemberModal: false
            }
        },
        created() {
            this.getProjectMembers();
        },
        methods: {
            getProjectMembers() {
                axios.get(`/api/projects/team-members/${this.projectId}`, {
                    params: {
                        page: 0,
                        pageSize: 5,
                    }
                }).then(resp => {
                    this.projectMembers = resp.data.content;
                }, error => {
                })
            }
        }
    }
</script>