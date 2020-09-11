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
    </div>
</template>
<script>
    import EmployeeSalaryAdditionCreateForm from "./EmployeeSalaryAdditionCreateForm";
    export default {
        components: {
            EmployeeSalaryAdditionCreateForm
        },
        data() {
            return {
                showSalaryAdditionForm: false
            }
        },
        props: {
            employeeId: {
                required: true
            }
        }
    }
</script>