<template>
  <div>
    <h2>Task Board</h2>
    <div class="flex justify-start gap-5">
        <TaskBoardCard v-for="(boardStatus, index) in boardStatuses" :project-id="1" :status="boardStatus"></TaskBoardCard>
    </div>
  </div>
</template>
<script>

import TaskBoardCard from "./TaskBoardCard"

export default {
  components: {
    TaskBoardCard
  },
  data() {
    return {

      boardStatuses: ["TODO", "IN PROGRESS", "DONE", "COMPLETE"]

    }
  }
}
</script>