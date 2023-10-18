<template>
  <div>
    <div class="pb-2 flex justify-start">
      <button
          class="button mr-1 is-rounded"
          tag="button"
          to="/departments-create"
          @click="showOvertimeRequestForm=true">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Add Overtime
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
    <OvertimeRequestCreateForm
        v-if="showOvertimeRequestForm"
        @modalClosed="showOvertimeRequestForm=false">
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