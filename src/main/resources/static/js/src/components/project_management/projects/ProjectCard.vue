<template>
    <div class="card min-h-full">
        <div class="card-content">
            <div class="flex flex-col">
                <div class="relative">
                    <h4 class="text-black font-medium text-lg font-semibold"><a href="">{{project.name}}</a></h4>

                    <div class="text-xs font-normal">
                        <span class="font-bold">2</span> <span>open tasks</span> <span class="font-bold">5</span> <span>tasks completed</span>
                    </div>
                    <div class="profile-action">

                        <b-dropdown class="text-left" aria-role="list">
                            <i
                                    class="fa fa-ellipsis-v text-muted"
                                    slot="trigger"
                                    role="button">
                            </i>
                            <b-dropdown-item :disabled="false"
                                             value="withdraw"
                                             @click="confirmRemoveProject(project)"
                                             aria-role="listitem">
                                <span class="icon"><i class="fa fa-trash"></i></span>
                                Remove
                            </b-dropdown-item>
                            <b-dropdown-item
                                    :disabled="false" value="edit" aria-role="listitem">
                                <span class="icon"><i class="fa fa-pencil"></i></span>
                                Edit
                            </b-dropdown-item>
                        </b-dropdown>
                    </div>
                </div>
                <div>
                    <div ref="projectDescription"></div>
                </div>
                <div class="mt-2">
                    <h4 class="text-black font-medium text-lg font-semibold">Deadline:</h4>
                    <div>
                        <span>{{project.endDate}}</span>
                    </div>
                </div>
                <div class="mt-2">
                    <h4 class="text-black font-medium text-lg font-semibold">
                        Project Leader:</h4>
                    <div>
                        <Avatar size="small"
                                src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></Avatar>
                    </div>
                </div>
                <div class="mt-2">
                    <h4 class="text-black font-medium text-lg font-semibold">
                        Team:</h4>
                    <div>
                        <Avatar size="small"
                                src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></Avatar>
                        <Avatar size="small"
                                src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></Avatar>
                        <Avatar size="small"
                                src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></Avatar>
                        <Avatar size="small"
                                src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></Avatar>
                        <Avatar size="small"
                                src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></Avatar>
                    </div>
                </div>
                <div class="mt-2">
                    <h4 class="text-black font-medium text-lg font-semibold">Progress:</h4>
                    <progress class="progress is-small is-success" value="15" max="100">15%</progress>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import {Avatar} from "element-ui"
    import Viewer from "@toast-ui/editor/dist/toastui-editor-viewer"
    import {Message} from "element-ui"

    export default {
        components: {
            Avatar
        },
        props: {
            project: {
                required: true
            }
        },
        mounted() {
            let vm = this;
            const viewer = new Viewer({
                el: vm.$refs.projectDescription,
                height: '600px',
                initialValue: vm.project.description
            });

        },
        methods: {
            confirmRemoveProject(project) {
                this.$buefy.dialog.confirm({
                    title: 'Delete Project',
                    message: `Are you sure want to delete <b> ${project.name}</b>`,
                    onConfirm: () => this.removeProject(project)
                })
            },
            removeProject(project) {
                axios.delete(`/api/projects/${project.id}`)
                    .then(resp => {
                        Message.success("Project Successfully removed")
                        this.$emit("deleteSuccessful", project);
                    }, error => {
                    })
            }
        }
    }
</script>
<style scoped lang="scss">
    .profile-action {
        position: absolute;
        right: 5px;
        text-align: right;
        top: 10px;
        top: 0px;
        right: 5px;
    }
</style>