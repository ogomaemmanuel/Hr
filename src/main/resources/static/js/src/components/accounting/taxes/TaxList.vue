<template>
  <div>
    <div class="pb-2 flex justify-end">
      <router-link
          to="/holiday-create"
          tag="button"
          class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Add Tax
				</span>
      </router-link>
      <a
          href="/api/holidays/excel-report"
          class="button is-rounded">
				<span class="icon">
					<i class="fa fa-download mr-1"></i>
				</span>
        <span>
					 Export
				</span>
      </a>
    </div>
  </div>
</template>
<script>
export default {
  data(){
    return{}
  }
}
</script>