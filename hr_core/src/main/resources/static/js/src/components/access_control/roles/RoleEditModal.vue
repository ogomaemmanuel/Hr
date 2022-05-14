<template>
    <ModalTemplate ref="modalTemplate" @modalClosed="onModalClosed">
        <slot name="modal-content">
            <RoleEditForm
                    :role-id="$route.params.id"
                    @roleUpdated="onRoleUpdated"
                    slot="modal-content"></RoleEditForm>
        </slot>
    </ModalTemplate>
</template>
<script>
    import RoleEditForm from "./RoleEditForm";
    import ModalTemplate from "../../common/ModalTemplate"

    export default {
        components: {
            ModalTemplate,
            RoleEditForm
        },
        methods: {
            onRoleUpdated() {
                this.$emit("roleUpdated");
                this.$router.back();
            },
            onModalClosed() {
                this.$router.back();
            }
        }

    }
</script>