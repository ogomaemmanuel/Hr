<template>
    <div ref="imagePreview" class="modal is-clipped is-active">
        <div ref="modalBackground" class="modal-background"></div>
        <div class="modal-card">
            <header class="modal-card-head">
                <p class="modal-card-title">Preview</p>
                <button @click="closeImagePreview" class="delete" aria-label="close"></button>
            </header>
            <section ref="imagePreviewWrapper" class="image-preview-wrapper modal-card-body">
                <img ref="newImageUrl" class="image-preview" :src="imageCrop" alt="">
            </section>
            <footer class="modal-card-foot">
                <button @click="updateUserPhoto" class="button is-success">Save</button>
                <button @click="closeImagePreview" class="button">Cancel</button>
            </footer>
        </div>
    </div>
</template>
<script>
    import Croppie from 'croppie';
    import CommonMixin from '../../mixins/common_mixin'
    import {mapActions} from "vuex"
    export default {
        mixins: [CommonMixin],
        props: ["imageUrl"],
        data() {
            return {
                croppie: null,
                imageCrop: "",
                formData: ""
            }
        },
        methods: {
            ...mapActions(["setUserAvatar"]),
            closeImagePreview() {
                $(this.$refs.imagePreview).toggleClass('is-active');
                this.imageUrl = ""
                this.$emit("closepreview");
            },
            updateUserPhoto() {
                let vm = this;
                let image = this.croppie.result("blob").then(function (result) {
                    let formData = new FormData();
                    formData.append('image', result, "profilePhoto.png");
                    axios.post("/update-picture", formData).then(resp => {
                        $(vm.$refs.imagePreview).toggleClass('is-active');
                        vm.imageUrl = ""
                        vm.setUserAvatar(resp.data);
                        vm.$emit("closepreview", true);
                    })
                })


            }
        },
        created() {
            this.imageCrop = this.imageUrl;

        },
        mounted() {
            let vm = this;
            let image = vm.$refs.newImageUrl;
            if (vm.croppie) {
                vm.croppie.destroy();
            }
            vm.croppie = new Croppie(image, {
                enableResize: true,
                viewport: {width: 200, height: 200, type: 'circle'}
            });

            this.$refs.imagePreviewWrapper.scrollTop =
                this.$refs.imagePreviewWrapper.scrollHeight + this.$refs.imagePreviewWrapper.clientHeight

        },
        beforeDestroy() {
            this.croppie.destroy();
        }
    }
</script>
<style scoped lang="scss">
    .modal {
        .modal-card {
            background-color: #FFFFFF;
        }

        .image-preview-wrapper {
            height: 300px;
            max-width: 100%;
            margin-top: 5px;
            padding-top: 5px;
            box-sizing: content-box;
            overflow: hidden;

            .image-preview {
                width: 100%;
                /*object-fit: cover;*/
                height: auto;
                /*height: auto;*/
            }
        }
    }

</style>
