<template>
  <div>
    <div class="pb-2 flex justify-start">
      <button
          class="button mr-1 is-rounded"
          tag="button"
          to="/departments-create"
          @click="showResignationCreateForm=true">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Add Resignation
				</span>
      </button>
      <a
          class="button is-rounded"
          href="/api/overtime-requests/excel-reports">
				<span class="icon">
					<i class="fa fa-download mr-1"></i>
				</span>
        <span>
					 Export
				</span>
      </a>
    </div>
    <ResignationCreateForm
        v-if="showResignationCreateForm"
        @modalClosed="showResignationCreateForm=false"
        @resignationSaved="showResignationCreateForm=false">
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