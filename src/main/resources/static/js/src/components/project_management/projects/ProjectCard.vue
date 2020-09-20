<template>
    <div class="card">
        <div class="card-content">
            <h4 class="text-black font-medium text-lg font-semibold"><a href="">Office Management</a></h4>
            <div>
                <p>
                    Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                    When an unknown printer took a galley of type and scrambled it..
                </p>
            </div>
            <div class="mt-2">
                <h4 class="text-black font-medium text-lg font-semibold">Deadline:</h4>
                <div>
                    <span>17 Apr 2019</span>
                </div>
            </div>
            <div class="mt-2">
                <h4 class="text-black font-medium text-lg font-semibold">
                    Project Leader:</h4>
                <div>
                    <Avatar  size="small" src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></Avatar>
                </div>
            </div>
            <div class="mt-2">
                <h4 class="text-black font-medium text-lg font-semibold">
                    Team:</h4>
                <div>
                    <Avatar  size="small" src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></Avatar>
                    <Avatar  size="small" src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></Avatar>
                    <Avatar  size="small" src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></Avatar>
                    <Avatar  size="small" src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></Avatar>
                    <Avatar  size="small" src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></Avatar>
                </div>
            </div>
            <div class="mt-2">
                <h4 class="text-black font-medium text-lg font-semibold">Progress:</h4>
                <progress class="progress is-small is-success" value="15" max="100">15%</progress>
            </div>
        </div>
    </div>
</template>
<script>
    import {Avatar} from "element-ui"

    export default {
        components: {
            Avatar
        },
        props: {
            project: {
                //required:true

            }
        }
    }
</script>