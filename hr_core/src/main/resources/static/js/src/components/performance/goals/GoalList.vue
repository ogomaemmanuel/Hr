<template>
  <div>
    <div class="pb-2 flex justify-end">
      <button
          @click="showCreateForm=true"
          to="/goal-type-create"
          tag="button"
          class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Add New
				</span>
      </button>
    </div>
    <div class="columns">
      <div class="column is-12">
        <div class="card" ref="leaveRequests">
          <div class="card-content">
            <div class="content b-table is-relative">
              <h4>Goal Tracking</h4>
              <table class="table has-mobile-cards w-full is-hoverable">
                <thead class="font-thin">
                <tr>
                  <th>
                    Name
                  </th>
                  <th>
                    Subject
                  </th>
                  <th>
                    Description
                  </th>
                  <th>
                    Target Achievement
                  </th>
                  <th>
                    Start Date
                  </th>
                  <th>
                    End Date
                  </th>
                  <th>
                    Action
                  </th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="goal in goalTrackingList">
                  <td data-label="Name">{{ goal.type }}</td>
                  <td data-label="Description">{{ goal.subject }}</td>
                  <td data-label="Description">{{ goal.description }}</td>
                  <td data-label="Description">{{ goal.targetAchievement }}</td>
                  <td data-label="Description">{{ goal.startDate }}</td>
                  <td data-label="Description">{{ goal.endDate }}</td>
                  <td data-label="Action">
                    <div class="action-controls d-flex justify-end">
                      <button
                          :to="`/goal-type-edit/${goal.id}`" tag="button"
                          @click="setGoalTrackingToEdit(goal)" class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                      </button>
                      <button
                          @click="confirmRemoveGoal(goal)"
                          class="button is-white is-small">
										           <span class="icon">
						                            <i class="fa fa-trash-o has-text-danger"></i>
					                               </span>
                      </button>
                    </div>
                  </td>
                </tr>
                </tbody>
                <tfoot>
                <tr>
                  <td colspan="8">
                    <Paginator
                        @previousPage="goToPrevious"
                        @nextPage="goToNext"
                        @paginationChanged="onPaginationChanged"
                        :paginationData="pageable"
                    ></Paginator>
                  </td>
                </tr>
                </tfoot>
              </table>
              <b-loading :is-full-page="false" :active.sync="loading" :can-cancel="true"></b-loading>
            </div>
          </div>
        </div>
      </div>
    </div>
    <GoalTrackingCreateForm
        @modalClosed="showCreateForm=false"
        @createSuccessful="createSuccessfulHandler"
        v-if="showCreateForm"></GoalTrackingCreateForm>
    <GoalTrackingEditForm
        :id="goalTrackingToEdit.id"
        @updateSuccessful="updateSuccessfulHandler"
        @modalClosed="showEditForm=false"
        v-if="showEditForm">
    </GoalTrackingEditForm>
  </div>
</template>
<script>
import data_table_mixin from "../../../mixins/data_table_mixin";
import Paginator from "../../common/paginator/Paginator";
import GoalTrackingEditForm from "./GoalEditForm";
import GoalTrackingCreateForm from "./GoalCreateForm";

export default {
  components: {
    Paginator,
    GoalTrackingEditForm,
    GoalTrackingCreateForm
  },
  mixins: [data_table_mixin],
  data() {
    return {
      goalTrackingList: [],
      showCreateForm: false,
      goalTrackingToEdit: null,
      loading: false,
      showEditForm: false
    }
  },
  created() {
    this.getGoalList();
  },
  methods: {
    setGoalTrackingToEdit(goal) {
      this.goalTrackingToEdit = goal;
      this.$nextTick(() => {
        this.showEditForm = true;
      })
    },
    createSuccessfulHandler() {
      this.showCreateForm = false;
      this.getGoalList();
    },
    updateSuccessfulHandler() {
      this.showEditForm = false;
      this.getGoalList();
    },
    getGoalList() {
      axios.get("/api/goals", {
        params: {
          page: this.page,
          pageSize: this.pageSize
        }
      }).then(resp => {
        this.goalTrackingList = resp.data.content;
        this.pageable = resp.data;
      })
    },
    removeGoal({id}) {
      axios.delete(`/api/goals/${id}`).then(resp => {
        this.getGoalList();
      })
    },
    confirmRemoveGoal(goal) {
      this.$buefy.dialog.confirm({
        title: 'Delete Goal',
        message: `Are you sure want to delete <b> ${goal.description}</b> goal`,
        onConfirm: () => this.removeGoal(goal)
      })
    },
  }
}
</script>