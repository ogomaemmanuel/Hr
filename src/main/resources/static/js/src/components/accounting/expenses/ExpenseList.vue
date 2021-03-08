<template>
  <div>
    <div class="pb-2 flex justify-end">
      <router-link
          to="/estimate-create"
          tag="button"
          class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Add Expense
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
    <div>
      <div class="columns mt-4">
        <div class="column">
          <div class="field">
            <div class="control">
              <input
                  placeholder="Item Name"
                  class="input">
              </input>
            </div>
          </div>
        </div>
        <div class="column">
         <EmployeeSelectInput
             placeholder="Purchased By"
             :show-label="false">
         </EmployeeSelectInput>
        </div>
        <div class="column">
          <div class="field">
            <div class="control">
              <DatePicker
                  class="datepicker"
                  v-model="filterParams.startDate"
                  placeholder="From"
              ></DatePicker>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <div class="control">
              <DatePicker
                  class="datepicker"
                  v-model="filterParams.startDate"
                  placeholder="From"
              ></DatePicker>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="field">
            <div class="control">
              <DatePicker
                  class="datepicker"
                  v-model="filterParams.endDate"
                  placeholder="To">
              </DatePicker>
            </div>
          </div>
        </div>

        <div class="column">
          <div class="button is-fullwidth is-primary">
            Search
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import {DatePicker} from "element-ui"
import EmployeeSelectInput from "../../common/EmployeeSelectInput"

export default {
  components:{
    EmployeeSelectInput,
    DatePicker
  },
  data() {
    return {
      filterParams: {},
    }
  }
}
</script>