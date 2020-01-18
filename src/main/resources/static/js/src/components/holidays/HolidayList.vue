<template>
	<div>
		<div class="pb-2 flex justify-end">
			<button
					@click="showCreateDialog=true"
					class="button is-rounded is-small">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
				<span>
					 Add New
				</span>
			</button>
		</div>
		<div class="columns is-size-7">
			<div class="column is-12">
				<div class="card" ref="leaveRequests">
					<div class="card-content">
						<div class="content b-table">
							<h4>Holidays</h4>
							<table class="table has-mobile-cards w-full">
								<thead class="font-thin">
								<tr>
									<th>
										Name
									</th>
									<th>
										Date
									</th>
									<th>
										Description
									</th>
									<th>
										Action
									</th>
								</tr>
								</thead>
								<tbody>
								<tr v-for="holiday in holidays">
									<td data-label="Name">{{holiday.name}}</td>
									<td data-label="Date">{{holiday.date|dateFormat}}</td>
									<td data-label="Description">{{holiday.name}}</td>
									<td data-label="Action">
										<div class="action-controls d-flex justify-end">
											<button @click="setHolidayToEdit(holiday)" class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
											</button>
											<button
													@click="confirmRemoveHoliday(holiday)"
													class="button is-white is-small">
										           <span class="icon">
						                            <i class="fa fa-trash-o has-text-danger"></i>
					                               </span>
											</button>
										</div>
									</td>
								</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<ModalTemplate ref="modalTemplate" @modalClosed="showCreateDialog=false" v-if="showCreateDialog">
			<slot name="modal-content">
				<HolidayCreateForm @holidayCreateSuccessful="onHolidayCreateSuccessful"
								   slot="modal-content"></HolidayCreateForm>
			</slot>
		</ModalTemplate>
		<ModalTemplate ref="editModalTemplate" @modalClosed="showEditDialog=false" v-if="showEditDialog">
			<slot name="modal-content">
				<HolidayEditForm :id="holidayToEditId" @holidayUpdateSuccessful="onHolidayUpdateSuccessful"
								 slot="modal-content"></HolidayEditForm>
			</slot>
		</ModalTemplate>
	</div>
</template>
<script>
    import ModalTemplate from "../common/ModalTemplate"
    import HolidayCreateForm from "./HolidayCreateForm.vue"
    import HolidayEditForm from "./HolidayEditForm";

    export default {
        components: {
            ModalTemplate,
            HolidayCreateForm,
            HolidayEditForm
        },
        data() {
            return {
                showCreateDialog: false,
                showEditDialog: false,
                holidays: [],
                holidayToEditId: false
            }
        },
        created() {
            this.getHolidays();
        },
        methods: {
            getHolidays() {
                axios.get("/api/holidays").then(resp => {
                    this.holidays = resp.data;
                })
            },
            onHolidayCreateSuccessful() {
                this.$refs.modalTemplate.closeModal();
                this.getHolidays();
            },
            onHolidayUpdateSuccessful() {
                this.$refs.editModalTemplate.closeModal();
                this.getHolidays();
            },
            confirmRemoveHoliday(holiday) {
                this.$buefy.dialog.confirm({
                    title: 'Delete Holiday',
                    message: `Are you sure want to delete <b> ${holiday.name}</b> holiday`,
                    onConfirm: () => this.removeHoliday(holiday)
                })
            },
            setHolidayToEdit(holiday) {
                this.holidayToEditId = holiday.id;
                this.showEditDialog = true;
            },
            removeHoliday(holiday) {
                axios.delete(`api/holidays/${holiday.id}`).then(resp => {
                    this.$swal({
                        type: "success",
                        title: "Success",
                        message: "Holiday successfully removed",
                    })
                    this.getHolidays();
                })
            }
        },
        filters: {
            dateFormat(value) {
                return moment(value).format("DD-MM-YYYY");
            }
        }
    }
</script>
<style lang="scss" scoped>

</style>