<template>
	<ModalTemplate ref="editModalTemplate" @modalClosed="onModalClosed">
		<slot name="modal-content">
			<HolidayEditForm :id="holidayToEditId" @holidayUpdateSuccessful="onHolidayUpdateSuccessful"
							 slot="modal-content"></HolidayEditForm>
		</slot>
	</ModalTemplate>
</template>
<script>
    import ModalTemplate from "../common/ModalTemplate"
    import HolidayEditForm from "./HolidayEditForm";

    export default {
        components: {
            ModalTemplate,
            HolidayEditForm
        },
        data() {
            return {
                holidayToEditId: false,
            }
        },
        created() {
            this.holidayToEditId = this.$route.params.id;
        },
        methods: {
            onHolidayUpdateSuccessful() {
                this.$emit("holidayUpdateSuccessful");
                this.$router.go(-1);
            },
            onModalClosed() {
                this.$router.go(-1);
            }
        }
    }
</script>