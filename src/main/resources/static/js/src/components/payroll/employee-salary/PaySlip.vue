<template>
    <div>
        <div v-if="loaded" v-html="payslip"></div>
        <PayslipSkeleton v-else></PayslipSkeleton>
    </div>
</template>
<script>
    import PayslipSkeleton from "./PayslipSkeleton";

    export default {
        components: {PayslipSkeleton},
        data() {
            return {
                payslip: "",
                loading: false,
                loaded: false,
            }
        },
        created() {
            this.getPayslip();
        },
        methods: {
            getPayslip() {
                this.loading = true;
                axios.get("/api/payslip/me").then(resp => {
                    this.loading = false;
                    this.loaded = true;
                    this.payslip = resp.data;

                })
            }
        }
    }
</script>
<style lang="scss" scoped>
</style>