<template>
  <div class="received-message mb-3">
    <div class="message-text">
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
      required: true,
      type: String
    }
  },
  data() {
    return {

    }
  }
}
</script>
<style lang="scss" scoped>
.received-message {
  display: flex;
  justify-content: start;

  .message-text{
    //padding: 10px;
    background-color: #FFFFFF;
    max-width: 60%;
    border-radius: 5px;
    padding: 8px 15px;
  }

}
</style>
