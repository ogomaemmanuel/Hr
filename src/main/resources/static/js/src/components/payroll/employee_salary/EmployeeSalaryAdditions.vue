<template>
    <div>
        <div class="flex justify-end">
            <button @click.stop="showSalaryAdditionForm=true"
                    class="button mr-1 is-rounded">
                <span class="icon">
                    <i class="fa fa-plus-circle mr-1"></i>
                </span>
                <span>
					 Add Addition
				</span>
            </button>
        </div>
        <EmployeeSalaryAdditionCreateForm
                :employee-id="employeeId"
                @modalClosed="showSalaryAdditionForm=false"
                v-if="showSalaryAdditionForm">
        </EmployeeSalaryAdditionCreateForm>
        <div class="mt-3">
            <div  class="flex  mb-2 pt-5 hover:shadow-lg pb-5 pl-5 pr-5 border-gray-100  border hover:border-width"
                  v-for="allowance in allowances">
                <div class="flex-1">
                    {{allowance.name}}
                </div>
                <div>
                  Kes  {{allowance.amount}}
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import EmployeeSalaryAdditionCreateForm from "./EmployeeSalaryAdditionCreateForm";

    export default {
        components: {
            EmployeeSalaryAdditionCreateForm
        },
        props: {
            employeeId: {
                required: true
            }
        },
        created() {
            this.getEmployeeSalaryAdditions();
        },
        data() {
            return {
                showSalaryAdditionForm: false,
                allowances: []
            }
        },
        methods: {
            getEmployeeSalaryAdditions() {
                axios.get(`/api/employee-payroll-addition/${this.employeeId}`)
                    .then(resp => {
                        this.allowances = resp.data;
                    })
            }
        }
    }
</script>