<template>
    <ModalTemplate ref="modalTemplate" @modalClosed="onModalClosed">
        <slot name="modal-content">
            <DepartmentCreateForm slot="modal-content"></DepartmentCreateForm>
        </slot>
    </ModalTemplate>
</template>
<script>
    import DepartmentCreateForm from "./DepartmentCreateForm";
    import ModalTemplate from "../../common/ModalTemplate";

    export default {
        components: {
            DepartmentCreateForm,
            ModalTemplate
        },
        props: {},
        data() {
            return {

            }
        },
        methods:{
            onModalClosed() {
                this.$router.go(-1);
            }
        }
    }
</script>
<style>

</style>