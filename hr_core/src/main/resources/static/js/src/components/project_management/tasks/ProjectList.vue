<template>
  <div>
    <ul>
      <li @click="onProjectClicked(project)" v-for="project in projects" class="project-details">
        <p>{{ project.name }}</p>
      </li>
    </ul>
  </div>
</template>
<script>
import data_table_mixin from "../../../mixins/data_table_mixin";

export default {
  mixins: [data_table_mixin],
  data() {
    return {
      projects: []
    }
  },
  created() {
    this.getProjects();
  },
  methods: {
    async getProjects() {
      let resp = await axios.get(`/api/projects`, {
        params: {
          page: this.page,
          pageSize: this.pageSize
        }
      });
      this.projects = resp.data.content;
    },
    onProjectClicked(project) {
      console.log("onProjectClicked")
      this.$emit("projectSelected", project);
    }
  }
}
</script>
<style scoped lang="scss">
.project-details {

  p {
    display: flex;
    justify-content: flex-start;
    position: relative;
    font-size: 15px;
    color: #b7c0cd;
    height: auto;
    transition: all 0.2s ease;
    padding: 8px 15px;

    &:hover {
      color: #FFFFFF;
    }

    &:active {
      background-color: rgba(0, 0, 0, 0.2);
    }
  }
}

</style>