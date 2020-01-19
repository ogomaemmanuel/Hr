<template>
	<ModalTemplate ref="modalTemplate" @modalClosed="onModalClosed">
		<slot name="modal-content">
			<HolidayCreateForm @holidayCreateSuccessful="onHolidayCreateSuccessful"
							   slot="modal-content"></HolidayCreateForm>
		</slot>
	</ModalTemplate>
</template>
<script>
    import HolidayCreateForm from "./HolidayCreateForm.vue"
    import ModalTemplate from "../common/ModalTemplate"

    export default {
        components: {
            ModalTemplate,
            HolidayCreateForm
        },
        methods: {
            onHolidayCreateSuccessful() {
                this.$emit("holidayCreateSuccessful");
                this.$router.go(-1);
            },
            onModalClosed() {
                this.$router.go(-1);
            }
        }

    }
</script>