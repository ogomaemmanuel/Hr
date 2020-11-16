<template>
    <ModalTemplate width="900">
        <ProjectEditForm
                :project-id="id" slot="modal-content">
        </ProjectEditForm>
    </ModalTemplate>
</template>
<script>
    import ProjectEditForm from "./ProjectEditForm";
    import ModalTemplate from "../../common/ModalTemplate";
    export default {
        components: {
            ModalTemplate,
            ProjectEditForm
        },
        data() {
            return {
                id: ""
            }
        },
        created() {
            this.id = this.$route.params.id;
        }
    }
</script>
<style lang="scss" scoped>

</style>