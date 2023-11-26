<template>
  <div class="modal-wrapper">
    <div ref="modal" class="modal">
      <!--        <div ref="modalBackground" class="modal-background"></div>-->
      <div ref="modalContent" :style="{'max-width': width + 'px','overflow':overflow}" class="modal-content">
        <div :class="hasPadding?'':'p-0'" class="box">
          <template v-if="showCloseButton">
            <button @click.stop="closeModal" class="modal-close is-large" aria-label="close"></button>
          </template>
          <slot name="modal-content">

          </slot>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import ModalMixin from "../../mixins/modal_mixin"

export default {
  mixins: [
    ModalMixin
  ],
  props: {
    overflow: {
      required: false,
      default: 'initial'
    },
    width: {
      required: false,
      default: 640
    },
    showCloseButton: {
      type: Boolean,
      default: true
    },
    hasPadding:{
      type: Boolean,
      default: true
    }
  },
  created() {
  },
  mounted() {
    this.openModal();
    document.body.classList.add("modal-open");

  },
  beforeDestroy() {
    document.body.classList.remove('modal-open')
  }
}
</script>
<style lang="scss" scoped>
.modal {
  overflow-y: auto;
  position: fixed;
  left: 0;
  right: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(10, 10, 10, 0.86);

  .modal-background {

  }

  .modal-content {
    overflow: visible;
  }
}

</style>