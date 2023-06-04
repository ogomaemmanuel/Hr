<template>
  <div class="conversions-messages-wrapper flex-1 p-3">
    <div v-for="(message,index) in messages" :key="index">
      <SentMessage v-if="isSender(message)" :message="message.message"></SentMessage>
      <ReceivedMessage v-else :message="message.message"></ReceivedMessage>
    </div>
  </div>
</template>

<script>
import {mapGetters} from "vuex"
import SentMessage from "./SentMessage";
import ReceivedMessage from "./ReceivedMessage";

export default {
  components: {
    SentMessage,
    ReceivedMessage
  },
  props: {
    recipient: {
      required: true,
      type: Object

    }
  },
  data() {
    return {
      messages: [],
    }
  },
  computed: {
    ...mapGetters(["authenticatedUser"])
  },
  created() {

    this.getChatMessages();

  },
  methods: {
    async getChatMessages() {
      try {
        let resp = await axios.get(`/chats/${this.recipient.userId}`);
        this.messages = resp.data.content
      } catch (error) {

      }
    },

    isSender(message) {
    return   message.sender.id == this.authenticatedUser.id;
    }
  }
}
</script>
<style lang="scss" scoped>
.conversions-messages-wrapper {
  background-color: #f7f7f7;
  overflow-y: auto;
}
</style>