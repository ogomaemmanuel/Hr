<template>
    <ModalTemplate @modalClosed="$router.back()">
        <OvertimeRequestEditForm
                @overtimeRequestUpdated="onOvertimeRequestUpdated"
                slot="modal-content"
                :id="$route.params.id">
        </OvertimeRequestEditForm>
    </ModalTemplate>
</template>
<script>
    import OvertimeRequestEditForm from "./OvertimeRequestEditForm";
    import ModalTemplate from "../../common/ModalTemplate";

    export default {
        components: {
            ModalTemplate,
            OvertimeRequestEditForm
        },
        data() {
            return {}
        },
        methods: {
            onOvertimeRequestUpdated() {
                this.$emit("overtimeRequestUpdated");
                this.$router.back();
            }
        }
    }
</script>