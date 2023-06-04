<template>
  <div class="h-screen">
    <div class="chat-page h-full">
      <div class=" h-full pt-8 pr-16 pl-16">

        <div class="card overflow-hidden h-full rounded-t-lg">
          <div class="card-content pt-0  h-full pr-0">
            <div class="columns h-full">
              <div class="column is-3 border-r-2 h-full pr-0">
                <div class="conversation-header">
                  <div class="conversation-header-title">
                    <h2>Messaging</h2>
                  </div>
                  <div class="message-search-wrapper pt-2 pb-2">
                    <div class="control  has-icons-left has-icons-right">
                      <input class="input" type="text" placeholder="Search Messages">
                      <span class="icon is-small is-left">
      <i class="fa fa-search"></i>
    </span>
                      <span class="icon is-small is-right">
      <i class="fa fa-sliders"></i>
    </span>
                    </div>
                  </div>
                </div>
                <div class="relative w-full h-full overflow-hidden pb-3">
                  <div class="conversations-body w-full h-full absolute">
                    <UserConversations @conversationChanged="changeRecipient"></UserConversations>
                  </div>
                </div>

              </div>
              <div class="column pl-0">
                <div class="message-title-bar pl-2 pr-2">
                  <div class="flex w-full">
                    <div class="flex-1">
                      {{recipient.fullName}}
                    </div>
                    <div class="flex">
                      <i class="fa fa-ellipsis-h text-danger"></i>
                      <i class="fa fa-video-camera pl-2"></i>
                    </div>
                  </div>
                </div>
                <div class="message-area flex flex-col h-full">

<!--                  <div class="conversions-messages-wrapper flex-1 p-3">-->

<!--                    <ReceivedMessage message="Test"></ReceivedMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <SentMessage message="Test Sent message"></SentMessage>-->
<!--                    <ReceivedMessage message="Test"></ReceivedMessage>-->
<!--                  </div>-->

                  <ChatMessages :recipient="recipient" :key="recipient.userId"></ChatMessages>
                  <div class="message-input-wrapper flex p-4">
                    <div class="flex justify-center pr-3 items-center">
                     <span class="icon is-small">
      <i class="fa fa-paperclip fa-2x paper-clip"></i>
    </span>
                    </div>
                    <input v-model="message" placeholder="Type message..." class="input flex-1" type="text">
                    <button @click="sendChatMessage" class="button is-primary">
                      <span class="icon is-small">
                       <i class="fa fa-send"></i>
                      </span>
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import ReceivedMessage from "./ReceivedMessage";
import SentMessage from "./SentMessage";
import UserConversations from "./UserConversations";
import  ChatMessages from "./ChatMessages"
export default {
  components: {
    UserConversations,
    ReceivedMessage,
    ChatMessages,
    SentMessage
  },
  data() {
    return {
      message: "",
      recipient: {},
      conversions: {
        username: "Emmanuel Ogoma",
        message: " Hey there, I am using Whatapp",
        chatMessages: [],
      }
    }
  },

  methods: {
    getChatMessages(userId) {
      axios.get("")
    },
    changeRecipient(recipient) {
      console.log(recipient);
      this.recipient = {...recipient};
    },

    async sendChatMessage() {
      let message = {
        message: this.message,
        recipient: this.recipient.userId
      }
      try {
        await axios.post("/chats", message);
        this.message="";
      }catch (e){
        console.log("Error sending chat message");
      }
    }
  },
  computed: {}
}
</script>
<style scoped lang="scss">
.chat-page {
  margin-top: 3.25rem;

  .conversations-body {
    overflow-x: hidden;
    overflow-y: scroll;
  }

  .conversions-messages-wrapper {
    background-color: #f7f7f7;
    overflow-y: auto;

  }

  .conversation-header-title {
    height: 44px;
    border-bottom: 1px solid rgba(0, 0, 0, 0.08);
    display: flex;
    align-items: center;
  }

  .message-title-bar {
    height: 44px;
    border-bottom: 1px solid rgba(0, 0, 0, 0.08);
    display: flex;
    align-items: center;
  }

  .message-input-wrapper {
    border-top-style: solid;
    border-top-width: 1px;
    z-index: 8;

    .paper-clip {
      transform: rotate(90deg);
    }
  }
}

</style>