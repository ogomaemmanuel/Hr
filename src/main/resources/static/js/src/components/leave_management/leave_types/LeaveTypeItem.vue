<template>
	<tr>
		<td data-label="Name">
			<div class="has-text-primary">
				{{leaveType.name}}
			</div>
		</td>
		<td data-label="Number of Days">
			{{leaveType.numberOfDays}}
		</td>
		<td data-label="Action">
			<div class="action-controls d-flex justify-end">
				<router-link
						:to="`/leave-type-edit/${leaveType.id}`" tag="button"
						class="button is-white is-small">
					<span class="icon">
						<i class="fa fa-pencil-square-o has-text-primary"></i>
					</span>
				</router-link>
				<button
						@click="confirmRemove"
						class="button is-white is-small">
					<span class="icon">
						<i class="fa fa-trash-o has-text-danger"></i>
					</span>
				</button>
			</div>
		</td>
	</tr>
</template>
<script>
    export default {
        props: {
            leaveType: {
                required: true,
            }
        },
        methods: {
            confirmRemove() {
                let vm = this;
                this.$buefy.dialog.confirm({
                    title: 'Delete Leave Type',
                    message: `Are you sure want to delete <b> ${vm.leaveType.name}</b> leave type`,
                    onConfirm: () => this.removeLeaveType()
                });
            },
            removeLeaveType() {
                axios.delete(`/api/leave-types/${this.leaveType.id}`).then(resp => {
                    this.$swal(
                        {
                            text: "Leave type successfully removed",
                            type: "success"
                        }
                    )
                    this.$emit("leaveTypeRemoveSuccessful")
                })
            },

        }
    }
</script>
<style lang="scss" scoped>
	i{
		&:hover{
			transform: scale(1.8);
		}
	}
</style>