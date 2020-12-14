<template>
    <div class="h-full">
        <div class="h-full">
<!--            <router-view></router-view>-->
            <div class="columns h-full">
                <div class="column">
                    <div class="bg-white h-12 w-full">

                    </div>
                </div>
                <div class="column h-full bg-white"></div>
            </div>
        </div>
        <portal to="side-menu">
            <ul class="menu-list">
                <li>
                    <router-link to="/" class="">
                        <span class="icon"><i class="fa fa-home"></i></span> Back Home
                    </router-link>
                </li>
                <li @wheel="fetchMoreProjects">
                    <div  class="flex project-menu-head">
                        <span class="icon"><i class="fa fa-group"></i></span>
                        <div class="flex w-full">
                            <div class="flex-1 menu-header-text">Projects</div>
                            <i class="fa fa-plus mr-1"></i>
                        </div>
                    </div>

                    <ul class="mr-0 pr-0 border-l-0">
                        <li v-for="project in projects">
                            <router-link to="/users">
                                <span>{{project.name}}</span>
                            </router-link>
                        </li>
                    </ul>
                </li>
            </ul>
        </portal>
    </div>
</template>
<script>
    import _throttle from "lodash.throttle"

    export default {
        data() {
            return {
                page: 0,
                pageSize: 10,
                projects: [],
                loading: false,
                loaded: false,
            }
        },
        created() {
            this.getProjects();
        },
        methods: {

            getProjects() {
                let vm = this;
                let request = {
                    page: vm.page,
                    pageSize: vm.pageSize
                }
                vm.loading = true;
                axios.get("/api/projects",
                    {params: request}).then(resp => {
                    vm.loaded = true;
                    vm.loading = false;
                    vm.projects.push(...resp.data.content);
                    if (resp.data.totalPages > vm.page) {
                        vm.page++;
                    }
                }, error => {
                    vm.loading = false;
                })
            },
            fetchMoreProjects: _throttle(function (event) {
                    let vm = this;
                    if (event.deltaY > 0) {
                        vm.getProjects();
                    }
                },
                2000),
        }
    }
</script>
<style scoped lang="scss">
    .project-menu-head {
        .menu-header-text {
            padding-left: 0.5em;
        }

        border-radius: 2px;
        padding: 0.5em 0.2em;

        &:hover {
            border-left: 4px solid;
            background-color: #000000;
            border-left: 4px solid #1d8e72;
            color: #FFFFFF;
        }
    }
</style>