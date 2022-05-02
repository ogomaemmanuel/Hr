<template>
  <div class="h-full">
    <div class="columns h-full is-multiline">
      <div v-for="client in clients" class="column  is-12-mobile is-6-tablet  is-3-desktop">
        <div class="card min-h-48">
          <div class="card-content">

            <div>
              <div class="flex justify-center">
                <figure class="image is-128x128">
                  <img class="is-rounded"
                       src="https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-02.jpg"
                       alt="Placeholder image">
                </figure>
              </div>
              <div class="text-center mt-1 text-truncate">
                <h4><a href="" class="text-black font-medium text-lg font-semibold">{{ client.companyName }}</a></h4>
              </div>
              <div class="text-center text-truncate">
                <h5><a href="" class="text-black text-sm font-semibold">{{ client.fullName }}</a></h5>
              </div>
              <div class="text-center text-truncate">
                <!--                                <a href="">Title</a>-->
                <h5 class="text-sm font-semibold"><a href="">{{ client.phone }}</a></h5>
              </div>
              <div class="flex justify-center">
                <div class="">
                  <button class="button is-size-7 mr-1 text-black text-sm font-semibold">Message</button>
                </div>
                <div class="">
                  <button class="button is-size-7 ml-1 text-black text-sm font-semibold">View Profile</button>
                </div>
              </div>

            </div>
          </div>
          <div class="profile-action">

            <b-dropdown class="text-left" aria-role="list">
              <i
                  class="fa fa-ellipsis-v text-muted"
                  slot="trigger"
                  role="button">
              </i>
              <b-dropdown-item :disabled="false"
                               value="withdraw"
                               @click="confirmRemoveClient(client)"
                               aria-role="listitem">
                <span class="icon"><i class="fa fa-trash"></i></span>
                Remove
              </b-dropdown-item>
              <b-dropdown-item
                  :disabled="false" value="edit" aria-role="listitem">
                <router-link :to="`/clients-edit/${client.id}`">
                  <span class="icon"><i class="fa fa-pencil"></i></span>
                  Edit
                </router-link>
              </b-dropdown-item>
            </b-dropdown>
          </div>
        </div>
      </div>

    </div>
  </div>
</template>
<script>
import data_table_mixin from "../../../mixins/data_table_mixin";
import ClientListMixin from "./ClientListMixin";

export default {
  props: {
    refreshData: {
      default: false
    }
  },
  mixins: [data_table_mixin, ClientListMixin],
  data() {
    return {
      clients: [],
      loading: false
    }
  },
  created() {
    this.getClients();
  },
  methods: {
    getClients() {
      let vm = this;
      axios.get(`/api/clients`, {
        params: {
          page: this.page,
          pageSize: this.pageSize,
        }
      }).then(resp => {
        vm.loading = false;
        this.clients = resp.data.content;
        this.pageable = resp.data;
      })
    }
  },
  watch: {
    refreshData(val) {
      if (val) {
        this.getClients();
      }

    }
  }
}
</script>
<style lang="scss" scoped>
.profile-action {
  position: absolute;
  right: 5px;
  text-align: right;
  top: 10px;
  top: 0px;
  right: 5px;
}

.text-truncate {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>