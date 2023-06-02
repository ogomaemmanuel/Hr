<template>
  <div class="sent-message mb-3">
    <div class="message-text ">
      {{message}}
      <div class="chat-time">
        8:30 AM
      </div>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    message: {
      type: String,
      required: true
    }
  },
  data() {
    return {}
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
