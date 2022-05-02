export default {
    data() {
        return {
            pageable: false,
            pageSize: 10,
            page: 0,
        }
    },
    methods: {
        goToPrevious() {
            this.page--;
            this.fetchRecords();
        },
        goToNext() {
            this.page++;
            this.fetchRecords();
        },
        onPaginationChanged(pageSize) {
            this.page = 0;
            this.pageSize = pageSize;
            this.fetchRecords();
        }
    }
}