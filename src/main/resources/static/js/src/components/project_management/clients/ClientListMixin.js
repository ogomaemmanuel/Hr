export default {
    methods: {
        confirmRemoveClient(client) {
            this.$buefy.dialog.confirm({
                title: 'Delete Employee',
                message: `Are you sure want to remove <b> ${client.companyName}</b>`,
                onConfirm: () => this.removeClient(client)
            })
        },
        removeClient(client) {
            axios.delete(`/api/clients/${client.id}`).then(resp => {
                this.$swal({
                    type: "success",
                    title: "Success",
                    message: "Client successfully removed",
                })
                this.getClients();
            })
        }
    }
}