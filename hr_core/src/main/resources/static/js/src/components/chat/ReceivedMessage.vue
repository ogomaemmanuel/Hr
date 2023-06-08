<template>
  <div class="received-message mb-3">
    <div class="message-text">
      {{ message.message }}
      <div class="chat-time">
        {{ formatDate(message.createdAt) }}
      </div>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    message: {
      required: true,
      type: Object
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
.received-message {
  display: flex;
  justify-content: start;

  .message-text {
    //padding: 10px;
    background-color: #FFFFFF;
    max-width: 60%;
    border-radius: 5px;
    padding: 8px 15px;
  }

}
</style>
