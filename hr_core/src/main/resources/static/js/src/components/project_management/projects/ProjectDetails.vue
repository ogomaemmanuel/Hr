<template>
    <div>
        <div class="columns">
            <div class="column is-9">
                <div class="card">
                    <div class="card-content">
                        <h4 class="font-black">{{project.name}}</h4>
                        <p> {{project.openTasks||0}} open tasks, {{project.completedTasks||0}} tasks completed</p>
                        <div ref="projectDescription">
                            <!--                            {{project.description}}-->
                        </div>
                    </div>
                </div>

                <div class="card mt-4">
                    <div class="card-content">
                        <h4 class="title is-4">Uploaded image files</h4>

                        <div class="columns">
                            <div v-for="n in 4" class="column">
                                <div class="card">
                                    <div class="card-image">
                                        <figure class="image m-1 is-4by3">
                                            <img src="https://bulma.io/images/placeholders/1280x960.png"
                                                 alt="Placeholder image">
                                        </figure>
                                    </div>
                                    <div class="card-content">
                                        <div class="media">
                                            <div class="media-content">
                                                <p class="title is-6">demo.png</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card mt-4">
                    <div class="card-content">
                        <h4 class="title is-4">Uploaded files</h4>
                        <article v-for="n in 2" class="media">
                            <figure class="media-left">
                                <p class="image is-64x64">
                                    <img src="https://bulma.io/images/placeholders/128x128.png">
                                </p>
                            </figure>
                            <div class="media-content">
                                <div class="content">
                                    <p>
                                        <strong>John Smith</strong> <small>@johnsmith</small> <small>31m</small>
                                        <br>
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ornare magna
                                        eros, eu pellentesque tortor vestibulum ut. Maecenas non massa sem. Etiam
                                        finibus odio quis feugiat facilisis.
                                    </p>
                                </div>
                            </div>
                            <div class="media-right">
                                <button class="delete"></button>
                            </div>
                        </article>
                    </div>
                </div>

                <div class="tabs is-fullwidth mt-3">
                    <ul>
                        <li class="is-active"><a>All Tasks</a></li>
                        <li><a>Pending Tasks</a></li>
                        <li><a>Completed Tasks</a></li>
                    </ul>
                </div>

                <div class="mt-3">
                    <div v-for="n in 6" class="card">
                        <div class="card-content pt-2 pb-2">

                            <article class="media">
                                <div class="media-left">
                                    <i class="fa fa-check-circle"></i>
                                </div>
                                <div class="media-content">
                                    <div class="content">
                                        Patient appointment booking
                                    </div>
                                </div>
                                <div class="media-right">
                                    <i class="fa fa-user-plus"></i>
                                    <i class="fa fa-trash"></i>
                                </div>
                            </article>
                        </div>
                    </div>
                </div>
            </div>
            <div class="column is-3">
                <div class="card">
                    <div class="card-content">
                        <h2 class="font-black">Project details</h2>
                        <table class="table is-striped is-hoverable is-fullwidth">
                            <tbody>
                            <tr>
                                <td>
                                    Cost:
                                </td>
                                <td class="text-right">
                                    $1200
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Total Hours:
                                </td>
                                <td>
                                    {{project.totalHours}} Hours
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Created:
                                </td>
                                <td>
                                    {{project.createdAt|formatDate}}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Deadline:
                                </td>
                                <td>
                                    {{project.endDate|formatDate}}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Priority:
                                </td>
                                <td>
                                    <span class="tag is-danger is-light">Danger</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Created By:
                                </td>
                                <td>
                                    Emmanuel Ogoma
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Status:
                                </td>
                                <td>
                                    Working
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <div>
                            <div class="mt-2">
                                <h4 class="text-black font-medium text-lg font-semibold">Progress:</h4>
                                <progress class="progress is-small is-success" value="15" max="100">15%</progress>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="card mt-4">
                    <div class="card-content">
                        <h4 class="font-black">
                            Assigned Leader
                        </h4>
                        <div class="mt-3">
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
                                        {{project.leadFullName}}
                                    </div>
                                    <div class="font-medium">
                                        {{project.leadDesignation}}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <ProjectMembersCard  :project-id="$route.params.id"></ProjectMembersCard>
                <div class="card mt-4">
                    <div class="card-content">
                        <div class="flex">
                            <h4 class="font-black flex-1">
                                About Client
                            </h4>
                        </div>

                        <div class="flex mt-3 justify-center">
                            <figure class="image is-128x128">
                                <img class="is-rounded"
                                     src="https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-02.jpg"
                                     alt="Placeholder image">
                            </figure>
                        </div>

                        <div class="flex justify-center">
                            <h4 class="title is-4">{{project.clientFullName}}</h4>
                        </div>
                        <div class="flex justify-center">
                            <h4 class="subtitle is-7">Washington, d.c.</h4>
                        </div>

                        <div class="flex mt-2 justify-center">
                            <div class="">
                                <button class="button is-size-7 mr-1 text-black text-sm font-semibold">Message</button>
                            </div>
                            <div class="">
                                <button class="button is-size-7 ml-1 text-black text-sm font-semibold">View Profile
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</template>
<script>
    import Viewer from "@toast-ui/editor/dist/toastui-editor-viewer";
    import ProjectMembersCard from "./ProjectMembersCard";


    export default {
        components: {
            ProjectMembersCard
        },
        data() {
            return {
                project: {},
                loaded: false,
                showAddMemberModal: false,
            }
        },
        mounted() {
            let vm = this;
            this.getProjectDetails();
        },
        methods: {
            getProjectDetails() {
                let vm = this;
                let projectId = this.$route.params.id;
                axios.get(`/api/projects/details/${projectId}`).then(resp => {
                    this.project = resp.data;
                    this.loaded = true;
                    const viewer = new Viewer({
                        el: vm.$refs.projectDescription,
                        height: '600px',
                        initialValue: vm.project.description
                    });
                }, error => {

                })
            }
        },
        filters: {
            formatDate(val) {
                if (val) {
                    return moment(val).format("DD MMM YYYY")
                }
            }
        }
    }
</script>
<style lang="scss" scoped>

</style>