<template>
	<div>
	
	</div>
</template>
<script>
    import DataTableMixin from "../../../mixins/data_table_mixin"
    import Paginator from "../../common/paginator/Paginator";

    export default {
        mixins: [DataTableMixin],
        components: {
            Paginator
        },
        data() {
            return {
                roles: []

            }
        },
        methods: {
            getRoles() {
                axios.get("api/roles/paged").then(resp => {
                    this.roles = resp.data.content;
                    this.pageable = resp.data;
                })
            }
        }
    }
</script>
<style lang="scss" scoped></style>