<template>
    <ModalTemplate
            width="960"
            ref="modalTemplate"
            @modalClosed="$router.back()">
        <UserEditForm
                @userUpdated="onUserUpdated"
                slot="modal-content"
                :user-id="$route.params.id">
        </UserEditForm>

    </ModalTemplate>
</template>
<script>
    import ModalTemplate from "../../common/ModalTemplate";
    import UserEditForm from "./UserEditForm";

    export default {
        components: {
            ModalTemplate,
            UserEditForm
        },
        methods: {
            onUserUpdated() {
                this.$emit("userUpdated");
                this.$router.back();
            }
        }
    }
</script>

