<template>
    <div ref="modal" class="modal">
        <div ref="modalBackground" class="modal-background"></div>
        <div ref="modalContent" :style="{'max-width': width + 'px','overflow':overflow}" class="modal-content">
            <div class="box">
                <slot name="modal-content">

                </slot>
            </div>
        </div>
        <template v-if="showCloseButton">
            <button @click.stop="closeModal" class="modal-close is-large" aria-label="close"></button>
        </template>
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
                default: 'auto'
            },
            width: {
                required: false,
                default: 640
            },
            showCloseButton: {
                type: Boolean,
                default: true
            }
        },
        created() {
        },
        mounted() {
            this.openModal();
        }
    }
</script>