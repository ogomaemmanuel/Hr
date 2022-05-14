<template>
  <div class="card animated preFadeInUp fadeInUp">
    <div class="card-content">
      <h1 class="has-text-weight-bold flex justify-center is-size-4 pb-4">Notifications Settings</h1>
      <div class="main-div">
      <Notification v-for="setting in settings" :key="setting.id" :setting="setting"></Notification>
    </div>
    </div>
  </div>
</template>

<script>
import CommonMixin from "../../../mixins/common_mixin"
import {Select, Option, Message} from "element-ui"
import Notification from "./Notification";

export default {
  name: "NotificationSettingsForm",
  components: {
    Select,
    Option,
    Notification
  },
  mixins: [CommonMixin],
  data() {
    return {
      setting: {
        id: "",
        name: "",
        notify: ""
      },
      settings: [
        {
          id: 1,
          name: "Leave",
          notify: true
        },
        {
          id: 2,
          name: "Employee",
          notify: true
        },
        {
          id: 3,
          name: "Holidays",
          notify: false
        }
      ],
      isLoading: false
    }
  },
  created() {
    this.getSettings();
  },
  methods: {
    getSettings(){
      let vm = this;
      axios.get(`/api/settings/notifications`).then(resp => {
        vm.settings = resp.data;
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.card-content{
  padding: 1.5rem 20rem;
}
.main-div{
  border: 1px solid gray;
  border-bottom: none;
}
</style>