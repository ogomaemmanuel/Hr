<template>
    <div>
        <div class="columns">
            <div class="column is-9">
                <div class="card">
                    <div class="card-content">
                        <h4 class="font-black">Hospital Administration</h4>
                        <p> 2 open tasks, 5 tasks completed</p>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel elit neque. Class aptent
                            taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum
                            sollicitudin libero vitae est consectetur, a molestie tortor consectetur. Aenean tincidunt
                            interdum ipsum, id pellentesque diam suscipit ut. Vivamus massa mi, fermentum eget neque
                            eget, imperdiet tristique lectus. Proin at purus ut sem pellentesque tempor sit amet ut
                            lectus. Sed orci augue, placerat et pretium ac, hendrerit in felis. Integer scelerisque
                            libero non metus commodo, et hendrerit diam aliquet. Proin tincidunt porttitor ligula, a
                            tincidunt orci pellentesque nec. Ut ultricies maximus nulla id consequat. Fusce eu consequat
                            mi, eu euismod ligula. Aliquam porttitor neque id massa porttitor, a pretium velit vehicula.
                            Morbi volutpat tincidunt urna, vel ullamcorper ligula fermentum at.

                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel elit neque. Class aptent
                            taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum
                            sollicitudin libero vitae est consectetur, a molestie tortor consectetur. Aenean tincidunt
                            interdum ipsum, id pellentesque diam suscipit ut. Vivamus massa mi, fermentum eget neque
                            eget, imperdiet tristique lectus. Proin at purus ut sem pellentesque tempor sit amet ut
                            lectus. Sed orci augue, placerat et pretium ac, hendrerit in felis. Integer scelerisque
                            libero non metus commodo, et hendrerit diam aliquet. Proin tincidunt porttitor ligula, a
                            tincidunt orci pellentesque nec. Ut ultricies maximus nulla id consequat. Fusce eu consequat
                            mi, eu euismod ligula. Aliquam porttitor neque id massa porttitor, a pretium velit vehicula.
                            Morbi volutpat tincidunt urna, vel ullamcorper ligula fermentum at.
                        </p>
                    </div>
                </div>

                <div class="card mt-4">
                    <div class="card-content">
                        <h4 class="title is-4">Uploaded image files</h4>

                        <div class="columns">
                            <div v-for="n in 4" class="column">
                                <div class="card">
                                    <div class="card-image">
                                        <figure class="image m-1 is-4by3">
                                            <img src="https://bulma.io/images/placeholders/1280x960.png"
                                                 alt="Placeholder image">
                                        </figure>
                                    </div>
                                    <div class="card-content">
                                        <div class="media">
                                            <div class="media-content">
                                                <p class="title is-6">demo.png</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card mt-4">
                    <div class="card-content">
                        <h4 class="title is-4">Uploaded files</h4>
                        <article v-for="n in 2" class="media">
                            <figure class="media-left">
                                <p class="image is-64x64">
                                    <img src="https://bulma.io/images/placeholders/128x128.png">
                                </p>
                            </figure>
                            <div class="media-content">
                                <div class="content">
                                    <p>
                                        <strong>John Smith</strong> <small>@johnsmith</small> <small>31m</small>
                                        <br>
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ornare magna
                                        eros, eu pellentesque tortor vestibulum ut. Maecenas non massa sem. Etiam
                                        finibus odio quis feugiat facilisis.
                                    </p>
                                </div>
                            </div>
                            <div class="media-right">
                                <button class="delete"></button>
                            </div>
                        </article>
                    </div>
                </div>

                <div class="tabs is-fullwidth mt-3">
                    <ul>
                        <li class="is-active"><a>All Tasks</a></li>
                        <li><a>Pending Tasks</a></li>
                        <li><a>Completed Tasks</a></li>
                    </ul>
                </div>

                <div class="mt-3">
                    <div v-for="n in 6" class="card">
                        <div class="card-content pt-2 pb-2">

                            <article class="media">
                                <div class="media-left">
                                    <i class="fa fa-check-circle"></i>
                                </div>
                                <div class="media-content">
                                    <div class="content">
                                        Patient appointment booking
                                    </div>
                                </div>
                                <div class="media-right">
                                    <i class="fa fa-user-plus"></i>
                                    <i class="fa fa-trash"></i>
                                </div>
                            </article>
                        </div>
                    </div>
                </div>
            </div>
            <div class="column is-3">
                <div class="card">
                    <div class="card-content">
                        <h2 class="font-black">Project details</h2>
                        <table class="table is-striped is-hoverable is-fullwidth">
                            <tbody>
                            <tr>
                                <td>
                                    Cost:
                                </td>
                                <td class="text-right">
                                    $1200
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Total Hours:
                                </td>
                                <td>
                                    100 Hours
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Created:
                                </td>
                                <td>
                                    25 Feb, 2019
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Deadline:
                                </td>
                                <td>
                                    12 Jun, 2019
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Priority:
                                </td>
                                <td>
                                    <span class="tag is-danger is-light">Danger</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Created By:
                                </td>
                                <td>
                                    Emmanuel Ogoma
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Status:
                                </td>
                                <td>
                                    Working
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <div>
                            <div class="mt-2">
                                <h4 class="text-black font-medium text-lg font-semibold">Progress:</h4>
                                <progress class="progress is-small is-success" value="15" max="100">15%</progress>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="card mt-4">
                    <div class="card-content">
                        <h4 class="font-black">
                            Assigned Leader
                        </h4>
                        <div class="mt-3">
                            <div class="flex content-center">
                                <div class="flex items-center">
                                    <figure class="image is-32x32">
                                        <img class="is-rounded"
                                             src="https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-02.jpg"
                                             alt="">
                                    </figure>
                                </div>
                                <div class="pl-1">
                                    <div class="font-semibold">
                                        John Doe
                                    </div>
                                    <div class="font-medium">
                                        Web Developer
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card mt-4">
                    <div class="card-content">
                        <div class="flex">
                            <h4 class="font-black flex-1">
                                Assigned users
                            </h4>
                            <div>
                                <button @click="showAddMemberModal=true"
                                        class="button is-small is-primary">
                                    <i class="fa fa-plus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="mt-3">
                            <div class="flex content-center">
                                <div class="flex items-center">
                                    <figure class="image is-32x32">
                                        <img class="is-rounded"
                                             src="https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-02.jpg"
                                             alt="">
                                    </figure>
                                </div>
                                <div class="pl-1">
                                    <div class="font-semibold">
                                        John Doe
                                    </div>
                                    <div class="font-medium">
                                        Web Developer
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="mt-3">
                            <div class="flex content-center">
                                <div class="flex items-center">
                                    <figure class="image is-32x32">
                                        <img class="is-rounded"
                                             src="https://dreamguys.co.in/smarthr/orange/assets/img/profiles/avatar-02.jpg"
                                             alt="">
                                    </figure>
                                </div>
                                <div class="pl-1">
                                    <div class="font-semibold">
                                        John Doe
                                    </div>
                                    <div class="font-medium">
                                        Web Developer
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <ProjectAddMemberModal
                @modalClosed="showAddMemberModal=false"
                v-if="showAddMemberModal">
        </ProjectAddMemberModal>
    </div>
</template>
<script>
    import ProjectAddMemberModal from "./ProjectAddMemberModal";

    export default {
        components: {
            ProjectAddMemberModal
        },
        data() {
            return {
                project: {},
                showAddMemberModal: false,
            }
        }
    }
</script>
<style lang="scss" scoped>

</style>