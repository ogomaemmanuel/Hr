<template>
	<div ref="modal" class="modal">
		<div ref="modalBackground" class="modal-background"></div>
		<div ref="modalContent" class="modal-content">
			<slot name="modal-content">
			
			</slot>
		</div>
		<template v-if="showCloseButton">
			<button @click="closeModal" class="modal-close is-large" aria-label="close"></button>
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