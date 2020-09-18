<template>
    <ModalTemplate width="900" overflow="visible"  @modalClosed="$router.back()">
        <slot name="modal-content">
            <ClientEditForm
                    @updated="onUpdated"
                    :client-id="$route.params.id"
                    slot="modal-content">
            </ClientEditForm>
        </slot>
    </ModalTemplate>
</template>
<script>
    import ModalTemplate from "../../common/ModalTemplate";
    import ClientEditForm from "./ClientEditForm";
    export default {
        components: {
            ModalTemplate,
            ClientEditForm
        },
        methods: {
            onUpdated() {
                this.$emit("updated");
                this.$router.back();
            }
        },
    }
</script>