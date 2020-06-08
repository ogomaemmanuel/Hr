<template>
    <ModalTemplate ref="editModalTemplate"
                   @modalClosed="onModalClosed">
        <slot name="modal-content">
            <DepartmentEditForm :department-id="this.$route.params.id"
                                slot="modal-content">
            </DepartmentEditForm>
        </slot>
    </ModalTemplate>
</template>
<script>
    import DepartmentEditForm from "./DepartmentEditForm";
    import ModalTemplate from "../../common/ModalTemplate";
    export default {
        components: {
            DepartmentEditForm,
            ModalTemplate
        },
        methods: {
            onModalClosed() {
                this.$router.go(-1);
            }
        }
    }
</script>