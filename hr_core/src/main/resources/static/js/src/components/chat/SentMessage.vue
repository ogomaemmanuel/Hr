<template>
  <div class="sent-message mb-3">
    <div class="message-text ">
      {{message.message}}
      <div class="chat-time">
        {{formatDate(message.createdAt)}}
      </div>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    message: {
      type: Object,
      required: true
    }
  },
  data() {
    return {}
  },
  methods: {
    isToday(date) {
      const today = new Date();
      return date.getFullYear() === today.getFullYear() &&
          date.getMonth() === today.getMonth() &&
          date.getDate() === today.getDate();
    },
    formatDate(date) {
      if (date) {
        if (this.isToday(new Date(date))) {
          return new Date(date).toLocaleTimeString()
        } else {
          return new Date(date).toLocaleDateString();
        }
      }
    }
  }
}
</script>
<style lang="scss" scoped>
.sent-message {
  display: flex;
  justify-content: end;
  .message-text{
    //padding: 10px;
    background-color: #f2f2f2;
    border: 1px solid #e3e3e3;
    max-width: 60%;
    color: #727272;
    padding: 8px 15px;
    border-radius: 5px;
    .chat-time{
      display: flex;
      justify-content: end;

    }
  }

}
</style>
