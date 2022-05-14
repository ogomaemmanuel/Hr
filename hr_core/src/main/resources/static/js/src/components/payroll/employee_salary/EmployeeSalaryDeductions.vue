<template>
    <div>
        <div class="flex justify-end">
            <button @click.stop="showSalaryDeductionCreateForm=true"
                    class="button mr-1 is-rounded">
                <span class="icon">
                    <i class="fa fa-plus-circle mr-1"></i>
                </span>
                <span>
					 Add Deduction
				</span>
            </button>
        </div>
        <EmployeeSalaryDeductionCreateForm
                :employee-id="employeeId"
                @modalClosed="showSalaryDeductionCreateForm=false"
                v-if="showSalaryDeductionCreateForm">
        </EmployeeSalaryDeductionCreateForm>
        <div class="mt-3">
            <div  class="flex  mb-2 pt-5 hover:shadow-lg pb-5 pl-5 pr-5 border-gray-100  border hover:border-width"
                  v-for="deduction in deductions">
                <div class="flex-1">
                    {{deduction.name}}
                </div>
                <div>
                    Kes  {{deduction.amount}}
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import EmployeeSalaryDeductionCreateForm from "./EmployeeSalaryDeductionCreateForm";

    export default {
        components: {
            EmployeeSalaryDeductionCreateForm
        },
        props: {
            employeeId: {
                required: true
            }
        },
        created() {
            this.getEmployeeSalaryDeductions();
        },
        data() {
            return {
                showSalaryDeductionCreateForm: false,
                deductions: []
            }
        },
        methods: {
            getEmployeeSalaryDeductions() {
                axios.get(`/api/employee-payroll-deductions/${this.employeeId}`)
                    .then(resp => {
                        this.deductions = resp.data;
                    })
            }
        }
    }
</script>