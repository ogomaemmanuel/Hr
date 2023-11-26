<template>
  <div class="bg-white card p-4">
    <portal to="page-controls">
      <div class="py-1 pr-2 flex justify-end">
        <p class="buttons">
          <router-link
              class="button  is-rounded"
              tag="button"
              to="leave-create">
				<span class="icon">

				<i class="fa fa-plus-circle"></i>
				</span>
            <span>New Request</span>
          </router-link>
        </p>
      </div>
    </portal>
    <div class="tabs">
      <ul>
        <li :class="{'is-active':MyLeaveRequest===true}" @click="MyLeaveRequest=true;showLeaveBalances=false;showLeaveApproval=false"><a>My Leave
          Requests</a></li>
        <li :class="{'is-active':showLeaveBalances===true}" @click="showLeaveBalances=true;MyLeaveRequest=false;showLeaveApproval=false"><a>My Leave
          Balances</a>
        </li>
        <li :class="{'is-active':showLeaveApproval===true}" @click="showLeaveApproval=true;showLeaveBalances=false;MyLeaveRequest=false"><a> Leave
          Approval</a>
        </li>
      </ul>
    </div>
    <div class="columns px-4 pb-4 pt-2">
      <div v-if="MyLeaveRequest===true" class="column is-12 ">
        <EmptyState v-if="showEmptyState">
          <h4 class="ml-3">Leave requests not found</h4>
          <div class="flex justify-center">
            <p class="buttons mt-5">
              <router-link
                  class="button  is-rounded"
                  tag="button"
                  to="leave-create">
                <span class="icon">

                <i class="fa fa-plus-circle"></i>
                </span>
                <span>New Requests</span>
              </router-link>
            </p>
          </div>

        </EmptyState>
        <div v-else ref="leaveRequests" >
          <div v-if="loaded">
            <div class="content b-table">
              <table class="table has-mobile-cards is-hoverable">
                <thead class="font-thin">
                <tr>
                  <th>
                    Type
                  </th>
                  <th>
                    Days
                  </th>
                  <th>
                    Start Date
                  </th>
                  <th>
                    End Date
                  </th>
                  <th>
                    Status
                  </th>
                  <th>
                    Date Requested
                  </th>
                  <th>
                    Action
                  </th>
                </tr>
                </thead>
                <tbody>
                <tr is="UserLeaveRequestItem" v-for="leaveRequest in leaveRequests"
                    :key="leaveRequest.id" :leave-request="leaveRequest">
                </tr>
                </tbody>
                <tfoot>
                <tr>
                  <td colspan="7">
                    <Paginator
                        :paginationData="pageable"
                        @nextPage="goToNext"
                        @paginationChanged="onPaginationChanged"
                        @previousPage="goToPrevious">
                    </Paginator>
                  </td>
                </tr>
                </tfoot>
              </table>
            </div>
          </div>
        </div>
      </div>
      <div v-if="showLeaveBalances===true" class="column is-12 ">
        <LeaveBalanceCard></LeaveBalanceCard>
      </div>
      <div v-if="showLeaveApproval===true" class="column is-12 ">
        <LeaveApprovalCard></LeaveApprovalCard>
      </div>
    </div>
    <router-view
        @leaveRequestSuccessful="getUserLeaveRequests"
        @leaveUpdateSuccessful="getUserLeaveRequests">
    </router-view>
  </div>
</template>
<script>
import LeaveBalanceCard from "./LeaveBalanceCard.vue"
import LeaveApprovalCard from "./leave_approval/LeaveApprovalList.vue"
import Paginator from "../common/paginator/Paginator"
import UserLeaveRequestItem from "./UserLeaveRequestItem"
import EmptyState from "../common/EmptyState"

export default {
  components: {
    LeaveBalanceCard,
    LeaveApprovalCard,
    Paginator,
    UserLeaveRequestItem,
    EmptyState
  },
  data() {
    return {
      loading: false,
      leaveRequests: [],
      pageable: false,
      pageSize: 10,
      page: 0,
      loaded: false,
      MyLeaveRequest: true,
      showLeaveBalances: false,
      showLeaveApproval:false
    }
  },
  created() {
    this.getUserLeaveRequests();
  },
  methods: {
    getUserLeaveRequests() {
      let vm = this;
      const loadingComponent = this.$buefy.loading.open({
        container: this.isFullPage ? null : vm.$refs.leaveRequests
      })
      axios.get("/api/user/leave-requests", {
        params: {
          pageSize: vm.pageSize,
          page: vm.page

        }
      }).then(resp => {
        loadingComponent.close();
        vm.leaveRequests = [];
        this.$nextTick().then(function () {
          vm.leaveRequests.push(...resp.data.content);
          vm.pageable = resp.data;
          vm.loaded = true;
        })
      }, error => {
        loadingComponent.close();
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
  computed: {
    showEmptyState() {
      return this.loaded && this.leaveRequests.length <= 0;
    }
  },
  filters: {
    dateFormat(date) {
      return moment(date).format("LL")
    }
  }
}
</script>
<style lang="scss" scoped>
</style>