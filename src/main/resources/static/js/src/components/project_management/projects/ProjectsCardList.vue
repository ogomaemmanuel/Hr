<template>
    <div class="grid auto-rows-auto  gap-5 sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 projects-wrapper">
        <div class="min-h-full" v-for="project in projects">
            <ProjectCard @deleteSuccessful="getProjects" :project="project">
            </ProjectCard>
        </div>
    </div>
</template>
<script>
    import ProjectCard from "./ProjectCard";
    import data_table_mixin from "../../../mixins/data_table_mixin";

    export default {
        //mixins: [data_table_mixin],
        components: {
            ProjectCard
        },
        data() {
            return {
                projects: [],
                pageable: false,
                pageSize: 10,
                page: 0,
            }
        },
        created() {
            this.getProjects();
        },
        methods: {
            getProjects() {
                let vm = this;
                axios.get("/api/projects", {
                    params: {
                        page: this.page,
                        pageSize: this.pageSize,
                    }
                }).then(resp => {
                    vm.loading = false;
                    this.projects = resp.data.content;
                    this.pageable = resp.data;
                })
            }
        }

    }
</script>
<style scoped lang="scss">
    .projects-wrapper{
        grid-auto-rows: 1fr;
    }
</style>