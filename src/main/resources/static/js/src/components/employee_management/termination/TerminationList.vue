<template>
    <div>
        <div class="pb-2 flex justify-end">
            <button
                    @click="showResignationCreateForm=true"
                    to="/departments-create"
                    tag="button"
                    class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
                <span>
					 Add Termination
				</span>
            </button>
            <a
                    href="/api/overtime-requests/excel-reports"
                    class="button is-rounded">
				<span class="icon">
					<i class="fa fa-download mr-1"></i>
				</span>
                <span>
					 Export
				</span>
            </a>
        </div>
        <TerminationCreateForm></TerminationCreateForm>
    </div>
</template>
<script>
    import TerminationCreateForm from "./TerminationCreateForm";

    export default {
        components: {
            TerminationCreateForm
        },
        data() {
            return {}
        }
    }
</script>