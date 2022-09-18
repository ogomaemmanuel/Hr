<template>
  <div class="columns">
    <div class="column">
      <div class="card h-full w-full">

      </div>
    </div>
    <div class="column is-4">
      <div class="card h-40">
        <div class="card-content">

        </div>
      </div>
      <div class="mt-5">
        <h2>YOUR LEAVE</h2>
        <div class="card h-40 mt-3">
          <div class="card-content">
            <div class="columns">
              <div class="column p-0">
                <div class="has-text-centered">
                  <p class="title is-4">5.0</p>
                  <p class="subtitle is-4">Leave Taken</p>
                </div>
              </div>
              <div class="column p-0">
                <div class="has-text-centered">
                  <p class="title is-4">5.0</p>
                  <h2 class="subtitle is-4">Remaining</h2>
                </div>
              </div>
            </div>
            <div class="flex justify-center">
              <button @click="showLeaveForm=true" class="button is-primary">Apply Leave</button>
            </div>
          </div>
        </div>
      </div>
      <div class="mt-5">
        <h2 class="is-bold">YOUR TIME OFF ALLOWANCE</h2>
        <div class="card h-40 mt-3">
          <div class="card-content">

            <div class="columns">
              <div class="column p-0">
                <div class="has-text-centered">
                  <p class="title is-4">5.0 Hours</p>
                  <p class="subtitle is-4">Approved</p>
                </div>
              </div>
              <div class="column p-0">
                <div class="has-text-centered">
                  <p class="title is-4">5.0 Hours</p>
                  <h2 class="subtitle is-4">Remaining</h2>
                </div>
              </div>
            </div>
            <div class="flex justify-center">
              <button class="button is-primary">Apply Time Off</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <LeaveForm v-if="showLeaveForm"></LeaveForm>
  </div>
</template>
<script>
const LeaveForm = () => import("../leave_management/LeaveRequestFormModal")
export default {
  components: {
    LeaveForm
  },

  data() {
    return {
      showLeaveForm: false
    }
  }


}
</script>