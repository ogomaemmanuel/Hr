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

                    <div class="flex pb-3 pt-3" v-for=" conversation in generateConversions " :key="conversation.id">
                      <figure class="image is-32x32">
                        <img src="/images/undraw_profile_pic_ic-5-t.svg"></img>
                      </figure>
                      <div>
                        {{ conversation.username }}
                      </div>
                    </div>
                  </div>
                </div>

              </div>
              <div class="column pl-0">
                <div class="message-title-bar pl-2 pr-2">
                  <div class="flex w-full">
                    <div class="flex-1">
                      Emmanuel Ogoma
                    </div>
                    <div class="flex">
                      <i class="fa fa-ellipsis-h text-danger"></i>
                      <i class="fa fa-video-camera pl-2"></i>
                    </div>
                  </div>
                </div>
                <div class="message-area flex flex-col h-full">

                  <div class="conversions flex-1"></div>

                  <div class="message-input-wrapper flex">
                    <input class="input flex-1" type="text">
                    <button class="button is-primary">
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
export default {
  data() {
    return {
      conversions: {
        username: "Emmanuel Ogoma",
        message: " Hey there, I am using Whatapp"
      }
    }
  },
  computed: {
    generateConversions() {
      let conversions = [];
      for (let i = 0; i < 1000; i++) {
        conversions.push({
          id: `${i}`,
          username: "Emmanuel Ogoma",
          message: `Hey there, I am using Whatapp, this is message ${i}`
        })
      }
      return conversions;
    }
  }
}
</script>
<style scoped lang="scss">
.chat-page {
  margin-top: 3.25rem;

  .conversations-body {
    overflow-x: hidden;
    overflow-y: scroll;

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
}

</style>