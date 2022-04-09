<template>
  <div class="notification-setting">
    <label>{{setting.name}}</label>
    <b-switch
        size="is-small"
        v-model="setting.notify"
        passive-type='is-danger'
        type='is-success'
        @input="submit"
    ></b-switch>
  </div>
</template>

<script>
import {Message} from "element-ui";

export default {
  name: "Notification",
  components: {
    // Switch
  },
  props: {
    setting: {
      required: true
    }
  },
  data(){
    return{
      value: true
    }
  },
  methods: {
    submit(){
      let vm = this;
      vm.isLoading = true;
      axios.post(`/api/settings/notifications/update`,
          vm.setting).then(resp => {
        vm.isLoading = false;
        if (resp.data.status === "00") {
          Message.success(resp.data.msg);
        } else {
          Message.error(resp.data.msg);
        }
        vm.getSettings();
      }, error => {
        if (error.response.status === 400) {
          vm.isLoading = false;
          this.errors = error.response.data;
        }else{
          vm.isLoading = false;
          Message.error("Something went wrong. Contact Admin");
        }
        vm.setting.notify = !vm.setting.notify;
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.notification-setting{
  border-bottom: 1px solid gray;
  padding: 10px;
  display: flex;
  justify-content: space-between;
}
</style>