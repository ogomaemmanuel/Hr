<template>
    <div class="card">
        <div class="card-content">
            <h4 class="payslip-title mb">Payslip for the month of Feb 2019</h4>
            <div class="columns">
                <div class="column m-b-20">
                    <img src="assets/img/logo2.png" class="inv-logo" alt="">
                    <ul class="list-unstyled mb-0">
                        <li>Dreamguy's Technologies</li>
                        <li>3864 Quiet Valley Lane,</li>
                        <li>Sherman Oaks, CA, 91403</li>
                    </ul>
                </div>
                <div class="column m-b-20">
                    <div class="flex sm:items-start lg:items-end flex-col">
                        <div class="text-left">
                            <h3 class="uppercase">Payslip #49029</h3>
                            <ul class="list-unstyled">
                                <li>Salary Month: <span>March, 2019</span></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="columns">
                <div class="column m-b-20">
                    <ul class="list-unstyled">
                        <li><h5 class="mb-0"><strong>John Doe</strong></h5></li>
                        <li><span>Web Designer</span></li>
                        <li>Employee ID: FT-0009</li>
                        <li>Joining Date: 1 Jan 2013</li>
                    </ul>
                </div>
            </div>
            <div class="columns">
                <div class="column is-6">
                    <div>
                        <h4 class="mb-4"><strong>Earnings</strong></h4>
                        <table class="table min-w-full is-bordered">
                            <tbody>
                            <tr>
                                <td><strong>Basic Salary</strong> <span class="float-right">$6500</span></td>
                            </tr>
                            <tr>
                                <td><strong>House Rent Allowance (H.R.A.)</strong> <span class="float-right">$55</span>
                                </td>
                            </tr>
                            <tr>
                                <td><strong>Conveyance</strong> <span class="float-right">$55</span></td>
                            </tr>
                            <tr>
                                <td><strong>Other Allowance</strong> <span class="float-right">$55</span></td>
                            </tr>
                            <tr>
                                <td><strong>Total Earnings</strong> <span
                                        class="float-right"><strong>$55</strong></span></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="column is-6">
                    <div>
                        <h4 class="mb-4"><strong>Deductions</strong></h4>
                        <table class="table min-w-full is-bordered">
                            <tbody>
                            <tr>
                                <td><strong>Tax Deducted at Source (T.D.S.)</strong> <span class="float-right">$0</span>
                                </td>
                            </tr>
                            <tr>
                                <td><strong>Provident Fund</strong> <span class="float-right">$0</span></td>
                            </tr>
                            <tr>
                                <td><strong>ESI</strong> <span class="float-right">$0</span></td>
                            </tr>
                            <tr>
                                <td><strong>Loan</strong> <span class="float-right">$300</span></td>
                            </tr>
                            <tr>
                                <td><strong>Total Deductions</strong> <span class="float-right"><strong>$59698</strong></span>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
            <div class="columns">
                <div class="column is-12">
                    <p><strong>Net Salary: $59698</strong> (Fifty nine thousand six hundred and ninety eight only.)</p>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    export default {}
</script>
<style lang="scss" scoped>
    .payslip-title {
        margin-bottom: 20px;
        text-align: center;
        text-decoration: underline;
        text-transform: uppercase;
    }
</style>