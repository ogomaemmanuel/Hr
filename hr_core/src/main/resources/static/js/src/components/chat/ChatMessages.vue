<template>
  <div class="conversions-messages-wrapper flex-1 p-3" ref="messages">
    <div v-for="(message,index) in sortedMessages" :key="index">
      <SentMessage v-if="isSender(message)" :message="message"></SentMessage>
      <ReceivedMessage v-else :message="message"></ReceivedMessage>
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
    ...mapGetters(["authenticatedUser","chatMessage"]),
    sortedMessages(){
    return   this.messages.sort(function (messageA, messageB) {
        return messageA.createdAt == messageB.createdAt
            ? 0
            : +(messageA.createdAt > messageB.createdAt) || -1
      })
    }
  },
  watch: {
    chatMessage(message,oldMessage) {
      if(message) {
        if((message.senderId==this.authenticatedUser.id
            && message.recipientId==this.recipient.userId) ||
            (message.recipientId==this.authenticatedUser.id
            && message.senderId==this.recipient.userId)) {
          this.messages = [...this.messages, message]
          let vm=this;
        }
      }
    },
    messages(){
      let vm = this
      vm.$nextTick(function () {
        vm.scrollMessagesToBottom()
      })
    }
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
    return   message.senderId == this.authenticatedUser.id;
    },
    scrollMessagesToBottom() {
      this.$refs.messages.scrollTop =
          this.$refs.messages.scrollHeight + this.$refs.messages.clientHeight
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