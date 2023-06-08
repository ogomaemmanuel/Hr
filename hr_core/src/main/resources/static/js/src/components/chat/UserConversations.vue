<template>
  <div>
    <div @click="onConversationClick(conversation)" class="flex pb-3 pt-3" v-for=" conversation in conversations "
         :key="conversation.id">
      <figure class="image is-32x32">
        <img src="/images/undraw_profile_pic_ic-5-t.svg"></img>
      </figure>
      <div>
        {{ conversation.fullName }}
        <div>
          {{ conversation.lastMessage }}
        </div>
      </div>

    </div>
  </div>
</template>
<script>
import data_table_mixin from "../../mixins/data_table_mixin";
import {mapGetters} from "vuex";
import chatMessages from "./ChatMessages";

export default {
  mixins: [data_table_mixin],
  data() {
    return {
      conversations: []
    }
  },

  created() {
    this.getConversations();

  },
  computed: {
    ...mapGetters(["chatMessage"])
  },
  watch: {
    chatMessage() {
      this.getConversations();
    }
  },
  methods: {
    onConversationClick(conversation) {
      this.$emit("conversationChanged", conversation)
    },

    async getConversations() {
      let resp = await axios.get("/chats/conversations", {
        params: {
          pageSize: this.pageSize,
          page: this.page
        }
      })
      this.conversations = resp.data.content;
      if(this.conversations.length > 0){
        this.$emit("conversationChanged", this.conversations[0])
      }
    }
  }
}
</script>