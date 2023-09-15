<template>
  <div>
    <h2>Task Board</h2>
    <div class="flex justify-start gap-5">
      <TaskBoardCard v-for="(boardStatus, index) in boardStatuses" :project-id="1" :key="index"
                     :status="boardStatus"></TaskBoardCard>
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
      boardStatuses: [
        {name: "TODO", id: 1},
        {name: "IN PROGRESS", id: 2},
        {name: "DONE", id: 3},
        {name: "COMPLETE", id: 4}]
    }
  }
}
</script>