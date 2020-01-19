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
			<a
					href="/api/holidays/excel-report"
					class="button is-rounded is-small">
				<span class="icon">
					<i class="fa fa-download mr-1"></i>
				</span>
				<span>
					 Export
				</span>
			</a>
		</div>
		<div class="columns is-size-7">
			<div class="column is-12">
				<div class="card" ref="leaveRequests">
					<div class="card-content">
						<div class="content b-table">
							<h4>Holidays</h4>
							<table class="table has-mobile-cards w-full is-hoverable">
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
											<router-link
													:to="`/holiday-edit/${holiday.id}`" tag="button"
													@click="setHolidayToEdit(holiday)" class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
											</router-link>
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
								<tfoot>
								<tr>
									<td colspan="8">
										<Paginator
												@previousPage="goToPrevious"
												@nextPage="goToNext"
												@paginationChanged="onPaginationChanged"
												:paginationData="pageable"
										></Paginator>
									</td>
								</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<router-view @holidayUpdateSuccessful="onHolidayUpdateSuccessful"></router-view>
		<ModalTemplate ref="modalTemplate" @modalClosed="showCreateDialog=false" v-if="showCreateDialog">
			<slot name="modal-content">
				<HolidayCreateForm @holidayCreateSuccessful="onHolidayCreateSuccessful"
								   slot="modal-content"></HolidayCreateForm>
			</slot>
		</ModalTemplate>
	</div>
</template>
<script>
    import ModalTemplate from "../common/ModalTemplate"
    import HolidayCreateForm from "./HolidayCreateForm.vue"
    import HolidayEditForm from "./HolidayEditForm";
    import Paginator from "../common/paginator/Paginator"

    export default {
        components: {
            ModalTemplate,
            Paginator,
            HolidayCreateForm,
            HolidayEditForm
        },
        data() {
            return {
                showCreateDialog: false,
                holidays: [],
                pageable: false,
                pageSize: 10,
                page: 0,
            }
        },
        created() {
            this.getHolidays();
        },
        methods: {
            getHolidays() {
                let vm = this;
                axios.get("/api/holidays", {
                    params: {
                        pageSize: vm.pageSize,
                        page: vm.page

                    }
                }).then(resp => {
                    this.holidays = resp.data.content;
                    this.pageable = resp.data;
                })
            },
            onHolidayCreateSuccessful() {
                this.$refs.modalTemplate.closeModal();
                this.getHolidays();
            },
            onHolidayUpdateSuccessful() {
                this.getHolidays();
            },
            confirmRemoveHoliday(holiday) {
                this.$buefy.dialog.confirm({
                    title: 'Delete Holiday',
                    message: `Are you sure want to delete <b> ${holiday.name}</b> holiday`,
                    onConfirm: () => this.removeHoliday(holiday)
                })
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
            },
            goToPrevious() {
                this.page--;
                this.getHolidays();
            },
            goToNext() {
                this.page++;
                this.getHolidays();
            },
            onPaginationChanged(pageSize) {
                this.page = 0;
                this.pageSize = pageSize;
                this.getHolidays();
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