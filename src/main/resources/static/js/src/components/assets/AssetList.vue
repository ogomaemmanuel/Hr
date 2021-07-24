<template>
  <div>
    <div class="pb-2 flex justify-end">
      <router-link
          to="/asset-create"
          tag="button"
          class="button mr-1 is-rounded">
				<span class="icon">
					<i class="fa fa-plus-circle mr-1"></i>
				</span>
        <span>
					 Add Asset
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
    <div class="columns">
      <div class="column is-12">
        <div class="card" ref="leaveRequests">
          <div class="card-content">
            <div class="content b-table is-relative">
              <h4>Assets</h4>
              <table class="table has-mobile-cards w-full is-hoverable">
                <thead class="font-thin">
                <tr>
                  <th>
                    Asset User
                  </th>
                  <th>
                    Asset Name
                  </th>
                  <th>
                   Asset ID
                  </th>
                  <th>
                    Purchase Date
                  </th>
                  <th>
                    Warranty
                  </th>
                  <th>
                    Warranty End Date
                  </th>
                  <th>
                    Amount
                  </th>
                  <th>
                    Status
                  </th>
                  <th>

                  </th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="asset in assets">
                  <td data-label="Name">{{asset.name}}</td>
                  <td data-label="Date">{{asset.date}}</td>
                  <td data-label="Description">{{asset.name}}</td>
                  <td data-label="Description">{{asset.name}}</td>
                  <td data-label="Description">{{asset.name}}</td>
                  <td data-label="Description">{{asset.name}}</td>
                  <td data-label="Description">{{asset.name}}</td>
                  <td data-label="Description">{{asset.name}}</td>
                  <td data-label="Action">
                    <div class="action-controls d-flex justify-end">
                      <router-link
                          :to="`/holiday-edit/${asset.id}`" tag="button"
                          @click="setHolidayToEdit(asset)" class="button is-white is-small">
												<span class="icon">
					                        	<i class="fa fa-pencil-square-o has-text-primary"></i>
					                       </span>
                      </router-link>
                      <button
                          @click="confirmRemoveAsset(asset)"
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
                  <td colspan="9">
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
    <router-view
        @holidayCreateSuccessful="onAssetCreateSuccessful"
        @holidayUpdateSuccessful="onAssetUpdateSuccessful">
    </router-view>
  </div>
</template>
<script>
import data_table_mixin from "../../mixins/data_table_mixin";
import Paginator from "../common/paginator/Paginator";

export default {
  components: {
    Paginator
  },
  mixins: [data_table_mixin],
  data() {
    return {
      assets: []
    }
  },
  created() {
    this.getAssets();
  },

  methods: {
    confirmRemoveAsset(asset){

    },
    fetchRecords() {
      this.getAssets();
    },
    getAssets() {
      axios.get(`api/assets/`, {
        params: {
          page: this.page,
          pageSize: this.pageSize
        }
      }).then(resp => {
        this.assets = resp.data.content;
        this.pageable = resp.data;
        this.loading = false
      })
    },
    onAssetCreateSuccessful(){},
    onAssetUpdateSuccessful(){}
  }
}
</script>