<template>
    <ModalTemplate width="900" ref="modalTemplate" @modalClosed="onModalClosed">
        <slot name="modal-content">
            <ProjectCreateForm
                    @createSuccessful="onCreateSuccessful"
                    slot="modal-content">
            </ProjectCreateForm>
        </slot>
    </ModalTemplate>
</template>
<script>
    import ProjectCreateForm from "./ProjectCreateForm";
    import ModalTemplate from "../../common/ModalTemplate"
    export default {
        components: {
            ModalTemplate,
            ProjectCreateForm
        },
        methods: {
            onCreateSuccessful() {
                this.$emit("createSuccessful");
                this.$router.back();
            },
            onModalClosed() {
                this.$router.back();
            }
        }

    }
</script>