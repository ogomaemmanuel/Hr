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
        <ResignationCreateForm
                @resignationSaved="showResignationCreateForm=false"
                @modalClosed="showResignationCreateForm=false"
                v-if="showResignationCreateForm">
        </ResignationCreateForm>
        <router-view></router-view>
    </div>
</template>
<script>
    import ResignationCreateForm from "./ResignationCreateForm";

    export default {
        components: {
            ResignationCreateForm
        },
        data() {
            return {
                showResignationCreateForm: false,
            }
        }
    }
</script>
<style lang="scss" scoped>

</style>