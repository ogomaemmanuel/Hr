<template>
  <div>
    <div class="flex pb-3 pt-3" v-for=" conversation in conversations " :key="conversation.id">
      <figure class="image is-32x32">
        <img src="/images/undraw_profile_pic_ic-5-t.svg"></img>
      </figure>
      <div>
        {{ conversation.username }}
      </div>
    </div>
  </div>
</template>
<script>
import data_table_mixin from "../../mixins/data_table_mixin";

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

  methods: {
    async getConversations() {
      let resp = await axios.get("/chats/conversations", {
        params: {
          pageSize: this.pageSize,
          page: this.page
        }
      })
      this.conversations = resp.data.content;

    }
  }
}
</script>