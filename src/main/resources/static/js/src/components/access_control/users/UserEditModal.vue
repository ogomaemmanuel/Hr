<template>
    <ModalTemplate
            width="960"
            ref="modalTemplate"
            @modalClosed="$router.back()">
            <UserEditForm
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
    }
</script>