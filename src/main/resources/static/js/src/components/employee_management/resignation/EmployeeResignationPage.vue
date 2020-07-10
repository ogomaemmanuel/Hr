<template>
    <div>
        <div class="pb-2 flex justify-end">
            <button
                    @click=""
                    to="/departments-create"
                    tag="button"
                    class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
                <span>
					 Add Resignation
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
<!--        <OvertimeRequestCreateForm-->
<!--                @modalClosed="showOvertimeRequestForm=false"-->
<!--                v-if="showOvertimeRequestForm">-->
<!--        </OvertimeRequestCreateForm>-->
        <router-view></router-view>
    </div>
</template>
<script>
    export default {}
</script>
<style lang="scss" scoped>

</style>