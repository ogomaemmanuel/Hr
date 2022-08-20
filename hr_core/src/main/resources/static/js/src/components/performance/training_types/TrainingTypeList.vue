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
              <h4>Training Types</h4>
              <table class="table has-mobile-cards w-full is-hoverable">
                <thead class="font-thin">
                <tr>
                  <th>
                    Type
                  </th>
                  <th>
                    Description
                  </th>
                  <th>
                    Action
                  </th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="trainingType in trainingTypeList">
                  <td data-label="Name">{{ trainingType.type }}</td>
                  <td data-label="Description">{{ trainingType.description }}</td>
                  <td data-label="Action">
                    <div class="action-controls d-flex justify-end">
                      <button
                          :to="`/goal-type-edit/${trainingType.id}`" tag="button"
                          @click="setTrainingTypeToUpdate(trainingType)" class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                      </button>
                      <button
                          @click="confirmRemoveTrainingType(trainingType)"
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
                  <td colspan="4">
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
    <TrainingTypeCreateForm
        @modalClosed="showCreateForm=false"
        @createSuccessful="createSuccessfulHandler"
        v-if="showCreateForm"></TrainingTypeCreateForm>
    <TrainingTypeEditForm
        @updateSuccessful="updateSuccessfulHandler"
        :id="trainingTypeToUpdate.id"
        @modalClosed="showEditForm=false"
        v-if="showEditForm"></TrainingTypeEditForm>
  </div>
</template>
<script>
import data_table_mixin from "../../../mixins/data_table_mixin";
import Paginator from "../../common/paginator/Paginator";
import TrainingTypeCreateForm from "./TrainingTypeCreateForm";
import {Message} from "element-ui";
import TrainingTypeEditForm from "./TrainingTypeEditForm";

export default {
  components: {
    Paginator,
    TrainingTypeCreateForm,
    TrainingTypeEditForm
  },
  mixins: [
    data_table_mixin
  ],
  data() {
    return {
      loading: false,
      showCreateForm: false,
      showEditForm: false,
      trainingTypeToUpdate: null,
      trainingTypeList: []
    }
  },

  created() {
    this.getGoalTypes();
  },
  methods: {
    getGoalTypes() {
      let vm = this;
      axios.get("/api/training-types", {
        params: {
          page: vm.page,
          pageSize: vm.pageSize
        }
      }).then(resp => {
        vm.trainingTypeList = resp.data.content;
        vm.pageable = resp.data;
      })
    },
    setTrainingTypeEdit(trainingType) {

    },
    createSuccessfulHandler() {
      this.showCreateForm = false;
      this.getGoalTypes();
    },
    confirmRemoveTrainingType(trainingType) {
      this.$buefy.dialog.confirm({
        title: 'Delete Holiday',
        message: `Are you sure want to delete <b> ${trainingType.type}</b> training type`,
        onConfirm: () => this.removeTrainingType(trainingType)
      })
    },
    removeTrainingType(trainingType) {
      axios.delete(`/api/training-types/${trainingType.id}`).then(resp => {
        Message.success("Training type successfully deleted");
        this.getGoalTypes();
      })
    },
    updateSuccessfulHandler() {
      this.showEditForm = false
      this.getGoalTypes();
    },

    setTrainingTypeToUpdate(trainingType) {
      this.trainingTypeToUpdate = trainingType;
      let vm = this;
      this.$nextTick(() => {
        vm.showEditForm = true;
      })
    }

  }
}
</script>