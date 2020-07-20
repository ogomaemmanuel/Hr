export default {
    methods: {
        closeModal() {
            let vm = this;
            // $(this.$refs.modalBackground).toggleClass('scaleInCircle');
            $(this.$refs.modalContent).toggleClass('scaleIn');
            $(this.$refs.modalClose).toggleClass("is-hidden");
            $('.modal.is-active').removeClass('is-active');
            vm.$emit("modalClosed");
        },
        openModal() {
            $(this.$refs.modal).toggleClass('is-active');
            //document.body.style.overflowY="hidden"
        }
    }
}