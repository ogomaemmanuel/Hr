<template>
    <div class="columns is-multiline">

        <div v-for="i in 12" class="column is-12-mobile is-6-tablet  is-3-desktop">
            <ProjectCard>

            </ProjectCard>
        </div>
    </div>
</template>
<script>
    import ProjectCard from "./ProjectCard";
    export default {
        components: {
            ProjectCard
        },
        data() {
            return {
                projects: []
            }
        }
    }
</script>