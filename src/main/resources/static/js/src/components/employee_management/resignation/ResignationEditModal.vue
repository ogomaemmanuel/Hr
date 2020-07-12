<template>
    <ModalTemplate @modalClosed="$router.back()">
        <ResignationEditForm
                @designationUpdated="onResignationUpdated"
                slot="modal-content"
                :id="$route.params.id">
        </ResignationEditForm>
    </ModalTemplate>
</template>
<script>
    import ResignationEditForm from "./ResignationEditForm";
    import ModalTemplate from "../../common/ModalTemplate";
    export default {
        components: {
            ModalTemplate,
            ResignationEditForm
        },
        data() {
            return {}
        },
        methods: {
            onResignationUpdated() {
                this.$emit("designationUpdated");
                this.$router.back();
            }
        }
    }
</script>