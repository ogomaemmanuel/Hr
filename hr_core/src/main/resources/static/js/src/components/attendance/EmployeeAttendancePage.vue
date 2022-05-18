<template>
  <div>
    <div class="columns">
      <div class="column">
        <div class="card">
          <div class="card-content">
            <h2>Timesheet 11 Mar 2019</h2>

            <div class="flex mt-5 justify-center items-center">
              <div class="flex h-32 border-gray-200
              border-2
               w-32 rounded-full bg-gray-100 items-center justify-center">
                <h2>3.45 hrs</h2>
              </div>

            </div>

            <div class="flex justify-center mt-5">
              <button class="button primary">Punch Out</button>
            </div>
            <div class="flex justify-between mt-5">
              <div class="flex items-center justify-center h-8 bg-gray-200 p-10">
                <h2>Break</h2>
              </div>
              <div class="flex items-center justify-center h-8 bg-gray-200 p-10">
                <h2>Overtime</h2>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card h-64">
          <div class="card-content">
            <h2>Statistics</h2>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card h-60">
          <div class="card-content">
            <h2>Today Activity</h2>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {}
  }
}
</script>