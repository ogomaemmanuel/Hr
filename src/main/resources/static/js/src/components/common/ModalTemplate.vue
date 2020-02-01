<template>
	<div ref="modal" class="modal">
		<div ref="modalBackground" class="modal-background"></div>
		<div ref="modalContent" :style="{'max-width': width + 'px'}" class="modal-content">
			<div class="box">
				<transition :duration="1000" name="custom-classes-transition"
							enter-active-class="animated tada"
							leave-active-class="animated bounceOutRight"
				>
					<slot name="modal-content">
					
					</slot>
				</transition>
				
				
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
            width:{
                required:false,
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