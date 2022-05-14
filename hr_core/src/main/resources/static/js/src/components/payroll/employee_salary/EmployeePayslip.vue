<template>
    <PaySlip :employeeId="id"></PaySlip>
</template>
<script>
    import PaySlip from "./PaySlip";

    export default {
        components: {
            PaySlip
        },
        data() {
            return {
                id: null
            }
        },
        created() {
            this.id = this.$route.params.id;
        }
    }
</script>
<style scoped lang="scss">

</style>