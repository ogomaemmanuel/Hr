<template>
	<div class="file-management">
		<div class="columns">
			<div class="column">
				<button class="button">
					 <span class="icon">
                     <i class="fa fa-upload"></i>
                     </span>
					<span>Upload File</span>
				</button>
				<button class="button">
					<span>
						<i class="fa fa-folder-open"></i>
					</span>
					<span>Create Folder</span>
				</button>
				<button class="button">
					<span>
						<i class="fa fa-trash"></i>
					</span>
					<span>
						Delete
					</span>
					
				</button>
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
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			</tbody>
		</table>
	</div>
</template>
<script>
    export default {}
</script>
<style scoped lang="scss">
	.file-management {
		margin-top: 0.4rem;
	}
</style>