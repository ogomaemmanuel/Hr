<template>
  <div class="w-full">
    <div class="flex  justify-start ">
      <div class=" columns w-full py-3 ml-0 bg-white">
        <div class="column is-5 is-inline-flex">
          <span class="">
						<button class="button is-small is-rounded">
              <span class="icon">
                <i class="fa fa-download"></i>
              </span>
                    <span>
                Export All
              </span>
						</button>
					</span>
          <input class="input flex-grow-0 is-small is-rounded ml-2" placeholder="Search ..." type="text">
        </div>
      </div>
    </div>

    <div class="b-table bg-white is-full">

      <table class="table has-mobile-cards  w-full">
        <thead>
        <tr>
          <th>Employee</th>
          <th>Start Date</th>
          <th>End Date</th>
          <th>Days</th>
          <th>Leave Type</th>
          <th>Status</th>
          <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <tr is="LeaveApprovalItem"
            v-for="leaveRequest in leaveRequests"
            :key="leaveRequest.id"
            :leaveRequest="leaveRequest">
        </tr>
        </tbody>
        <tfoot>
        <tr>
          <td colspan="8">
            <Paginator
                :paginationData="pageable"
                @nextPage="goToNext"
                @paginationChanged="onPaginationChanged"
                @previousPage="goToPrevious"
            ></Paginator>
          </td>
        </tr>
        </tfoot>
      </table>
    </div>
  </div>
</template>
<script>
import Paginator from "../../common/paginator/Paginator"
import LeaveApprovalItem from "./LeaveApprovalItem.vue"

export default {
  components: {
    Paginator,
    LeaveApprovalItem
  },
  data() {
    return {
      loading: false,
      leaveRequests: [],
      pageable: false,
      pageSize: 10,
      page: 0,
      showLeaveBalances: false
    }
  },
  created() {
    this.getLeaveRequestesToApprove();
  },
  methods: {
    getLeaveRequestesToApprove() {
      let vm = this;
      axios.get("/api/leave-request-approvals", {
        params: {
          pageSize: vm.pageSize,
          page: vm.page

        }
      }).then(resp => {
        vm.leaveRequests = resp.data.content;
        vm.pageable = resp.data;
      })
    },
    goToPrevious() {
      this.page--;
      this.getUserLeaveRequests();
    },
    goToNext() {
      this.page++;
      this.getUserLeaveRequests();
    },
    onPaginationChanged(pageSize) {
      this.page = 0;
      this.pageSize = pageSize;
      this.getUserLeaveRequests();
    }
  },

}
</script>