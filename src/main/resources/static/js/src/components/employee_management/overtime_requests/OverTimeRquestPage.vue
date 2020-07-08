<template>
    <div>
        <div class="pb-2 flex justify-end">
            <button
                    @click="showOvertimeRequestForm=true"
                    to="/departments-create"
                    tag="button"
                    class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
                <span>
					 Add Overtime
				</span>
            </button>
            <a
                    href="/api/departments/excel-reports"
                    class="button is-rounded">
				<span class="icon">
					<i class="fa fa-download mr-1"></i>
				</span>
                <span>
					 Export
				</span>
            </a>
        </div>
        <OvertimeRequestCreateForm
                @modalClosed="showOvertimeRequestForm=false"
                v-if="showOvertimeRequestForm">
        </OvertimeRequestCreateForm>
        <router-view></router-view>
    </div>
</template>
<script>
    import OvertimeRequestCreateForm from "./OvertimeRequestCreateForm";

    export default {
        components: {
            OvertimeRequestCreateForm
        },
        data() {
            return {
                showOvertimeRequestForm: false
            }
        },
        methods: {
            getOvertimeRequests() {

            }
        }

    }
</script>