<template>
	<div v-if="pageable" class="paginator">
		<div class="page-per-row">
			<label>Records per page:</label>
			<select @change="onPaginationChanged($event)" class="page-per-row-selector">
				<option value="10">10</option>
				<option value="25">25</option>
				<option value="50">50</option>
				<option value="100">100</option>
			</select>
		</div>
		
		<div class="paginator-controls">
			<label>{{numberOfElements}} of {{pageable.totalElements}}</label>
			<button @click="goToPrevious" :disabled="pageable.first" class="previous">
				<i class="fa fa-angle-left"></i>
			</button>
			<button @click="goToNext" :disabled="pageable.last" class="next">
				<i class="fa fa-angle-right"></i>
			</button>
		</div>
	</div>
</template>
<script>
    export default {
        props: {
            pageable: {
                default: false
            }
        },
        data() {
            return {
                // rowPerPage:10,
            }
        },
        methods: {
            goToNext() {
                this.$emit("nextPage")
            },
            goToPrevious() {
                this.$emit("previousPage")
            },
            onPaginationChanged(event){
                this.$emit("paginationChanged",Number(event.target.value))
            }
        },
        computed: {
            numberOfElements() {
                if (this.pageable) {
                    if (this.pageable.last) {
                        return this.pageable.totalElements;
                    }
                    if (this.pageable.first) {
                        return this.pageable.numberOfElements
                    }
                    return (this.pageable.number + 1) * this.pageable.size;
                }
            }
        }
    }

</script>
<style scoped lang="scss">
	.paginator {
		min-width: 100%;
		display: flex;
		align-items: center;
		justify-content: flex-end;
		
		.page-per-row {
			margin-right: 10px;
			
			.page-per-row-selector {
				height: 35px;
				border-style: none;
				outline: none;
			}
		}
		.paginator-controls {
			button {
				border-radius: 50px;
				display: inline-flex;
				width: 35px;
				align-items: center;
				justify-content: center;
				height: 35px;
				border-style: none;
				outline: none;
				/*background-color: #ffffff;*/
			}
		}
		
	}

</style>