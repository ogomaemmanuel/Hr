<template>
  <div>
    <div class="pb-2 flex justify-end">
      <portal to="header">
        Projects
      </portal>

      <portal to="page-controls">
        <button>
          <p class="buttons">
            <button class="button" @click="showTableList=false">
              <span class="icon is-small">
                <i class="fa fa-bars"></i>
              </span>
            </button>
            <button class="button" @click="showTableList=true">
              <span class="icon is-small">
                <i class="fa fa-th"></i>
              </span>
            </button>

            <router-link
              class="button mr-1 is-rounded"
              tag="button"
              to="/projects-create">
                  <span class="icon">
                    <i class="fa fa-plus-circle mr-1"></i>
                  </span>
              <span>
                 Create Project
              </span>
            </router-link>
          </p>
        </button>
      </portal>
    </div>
    <ProjectsCardList></ProjectsCardList>
    <router-view></router-view>
  </div>
</template>
<script>
import ProjectsCardList from "./ProjectsCardList";

export default {
  components: {
    ProjectsCardList
  },
  data() {
    return {}
  }
}
</script>