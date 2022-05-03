export default {
    data() {
        return {
            employees: [],
            pageable: false,
            pageSize: 10,
            page: 0,
            loading: false,
            totalPages: 0,
        }
    },
    methods: {
        getEmployees() {
            let vm = this;
            vm.loading = true;
            axios.get("/api/employees", {
                params: {
                    pageSize: vm.pageSize,
                    page: vm.page
                }
            }).then(resp => {
                vm.loading = false;
                this.employees = resp.data.content;
                this.pageable = resp.data;
            }, error => {
                vm.loading = false;
            })
        },

        confirmRemoveEmployee(employee) {
            this.$buefy.dialog.confirm({
                title: 'Delete Employee',
                message: `Are you sure want to delete <b> ${employee.fullName}</b> as an employee`,
                onConfirm: () => this.removeEmployee(employee)
            })
        },
        removeEmployee(employee) {
            axios.delete(`/api/employees/${employee.id}`).then(resp => {
                this.$swal({
                    type: "success",
                    title: "Success",
                    message: "Holiday successfully removed",
                })
                this.getEmployees();
            })
        },
        goToPrevious() {
            this.page--;
            this.getEmployees();
        },
        goToNext() {
            this.page++;
            this.getEmployees();
        },
        onPaginationChanged(pageSize) {
            this.page = 0;
            this.pageSize = pageSize;
            this.getEmployees();
        }
    },
    created() {
        this.getEmployees();
    },
    filters: {
        formatDate(val) {
            if (val) {
                return moment(val).format("DD-MMM-YYYY");
            }
            return null;
        }
    }
}