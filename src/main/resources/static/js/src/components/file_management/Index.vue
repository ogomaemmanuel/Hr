<template>
  <div class="file-management">
    <div class="flex justify-end pb-2">
      <div class="columns">
        <div class="column">
          <button class="button is-small is-rounded">
					 <span class="icon">
                     <i class="fa fa-upload"></i>
                     </span>
            <span>Upload File</span>
          </button>
          <button @click="showCreateFolderForm=true" class="button is-small is-rounded">
					<span class="icon">
						<i class="fa fa-folder-open"></i>
					</span>
            <span>Create Folder</span>
          </button>
          <button class="button is-small is-rounded">
					<span class="icon">
						<i class="fa fa-trash"></i>
					</span>
            <span>
						Delete
					</span>

          </button>
        </div>
      </div>
    </div>
    <table class="table is-striped is-hoverable is-fullwidth">
      <thead>
      <th>Name</th>
      <th>Size</th>
      <th>Created By</th>
      <th>Created On</th>
      <th>Modified On</th>
      </thead>
      <tbody>
      <tr v-for="file in files">
        <td @click.stop="changeParentFolder(file)"><i :class="`fa-${getFileType(file)}-o`"
                                                      class="fa  mr-2"></i>{{ file.name }}
        </td>
        <td>{{ file.size }}</td>
        <td>{{ file.createBy }}</td>
        <td>{{ file.createdAt }}</td>
        <td>{{ file.updatedAt }}</td>
      </tr>
      </tbody>
    </table>
    <CreateFolderForm
        :parentId="currentFolderId"
        v-if="showCreateFolderForm">
    </CreateFolderForm>
  </div>
</template>
<script>
import CreateFolderForm from "./CreateFolderForm";

export default {
  components: {CreateFolderForm},
  data() {
    return {
      currentFolderId: null,
      showCreateFolderForm: false,
      files: []
    }
  },
  created() {
    this.getFiles();
  },
  methods: {
    getFiles() {
      let vm = this;
      return axios.get("/api/files/", {
        params: {
          parentId: vm.currentFolderId
        }
      }).then(resp => {
        this.files = resp.data;
      })
    },
    getFileType(file) {
      return file.type.toLowerCase();
    },
    changeParentFolder(file) {
      if(file.type=="FOLDER") {
        let vm = this;
        this.currentFolderId = file.id;
        this.$nextTick(() => {
          vm.getFiles();
        })
      }
    }
  },

}
</script>
<style scoped lang="scss">
.file-management {
  margin-top: 0.4rem;
}
</style>