<template>
    <div class="h-full">
        <div class="card min-h-48">
            <div class="card-content">
                <div class="content">
                    <div class="columns">
                        <div class="column is-2">
                            <figure class="image is-128x128">
                                <img class="is-rounded"
                                     src="https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-02.jpg"
                                     alt="">
                            </figure>
                        </div>
                        <div class="column is-10 pl-5">
                            <div class="pt-5">
                                <h2 class="font-semibold">{{employeeSalaryInfo.fullName}}</h2>
                            </div>
                            <div class="flex ">
                                <div class="mr-1">
                                    <span>
                                    <i class="fa fa-money"></i>
                                </span>
                                    <span>{{employeeSalaryInfo.salaryAmount}}</span>
                                </div>
                                <div class="mr-1">
                                     <span>
                                    <i class="fa fa-building"></i>
                                </span>
                                    <span>{{employeeSalaryInfo.departmentName}}</span>
                                </div>
                                <div>
                                     <span>
                                    <i class="fa fa-phone"></i>
                                </span>
                                    <span>{{employeeSalaryInfo.phone}}</span>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="card h-full mt-1">
            <div class="card-content">
                <!--                <div class="content">-->
                <div class="tabs">
                    <ul>
                        <li class="is-active"><a>Additions</a></li>
                        <li><a>Deductions</a></li>
                    </ul>
                    <!--                    </div>-->
                </div>

                <EmployeeSalaryAdditions :employee-id="employeeId"></EmployeeSalaryAdditions>
            </div>
        </div>
    </div>
</template>
<script>
    import EmployeeSalaryAdditions from "./EmployeeSalaryAdditions";

    export default {
        components: {
            EmployeeSalaryAdditions
        },
        data() {
            return {
                employeeId: null,
                employeeSalaryInfo: {}

            }
        },
        created() {
            this.employeeId = this.$route.params.id;
            this.getEmployeeSalaryInfo();

        },
        methods: {
            getEmployeeSalaryInfo() {
                axios.get(`/api/employee-salary/${this.employeeId}`).then(resp => {
                    this.employeeSalaryInfo = resp.data;
                })
            }
        }
    }
</script>
<style lang="scss" scoped>

</style>