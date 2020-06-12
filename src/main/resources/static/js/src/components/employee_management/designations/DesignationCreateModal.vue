<template>
    <ModalTemplate overflow="visible" ref="modalTemplate" @modalClosed="$router.back()">
        <slot name="modal-content">
            <DesignationCreateForm slot="modal-content"></DesignationCreateForm>
        </slot>
    </ModalTemplate>
</template>
<script>
    import ModalTemplate from "../../common/ModalTemplate";
    import DesignationCreateForm from "./DesignationCreateForm";

    export default {
        components: {
            ModalTemplate,
            DesignationCreateForm
        },
        methods: {

        }
    }
</script>