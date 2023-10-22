<template>
  <div class="columns">
    <div class="column pt-0">
      <div class="columns">

        <div class="column">
          <div class="card">
            <div class="card-header">
              <p class="card-header-title">
                <i class="fa fa-map-pin mr-2"></i>
                Task Statistics
              </p>
            </div>
            <div class="card-content">
              <div class="columns">
                <div class="column">
                  <div class="card h-16">
                    <div class="card-content p-2">
                      <div class="level">
                        <div class="level-item has-text-centered">
                          <div>
                            <p class="heading">Total Tasks</p>
                            <p class="title is-7">385</p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="column">
                  <div class="card h-16">
                    <div class="card-content p-2">
                      <div class="level">
                        <div class="level-item has-text-centered">
                          <div>
                            <p class="heading is-6">Overdue Tasks</p>
                            <p class="title is-7">19</p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

              </div>

              <div class="progress mb-4">
                <div aria-valuemax="100" aria-valuemin="0" aria-valuenow="30"
                     class="progress-bar has-background-link-dark" role="progressbar" style="width: 30%">30%
                </div>
                <div aria-valuemax="100" aria-valuemin="0" aria-valuenow="18"
                     class="progress-bar has-background-warning"
                     role="progressbar" style="width: 22%">22%
                </div>
                <div aria-valuemax="100" aria-valuemin="0" aria-valuenow="12"
                     class="progress-bar has-background-success"
                     role="progressbar" style="width: 24%">24%
                </div>
                <div aria-valuemax="100" aria-valuemin="0" aria-valuenow="14" class="progress-bar has-background-danger"
                     role="progressbar" style="width: 26%">21%
                </div>
                <div aria-valuemax="100" aria-valuemin="0" aria-valuenow="14" class="progress-bar has-background-info"
                     role="progressbar" style="width: 10%">10%
                </div>
              </div>

              <p class="mb-4"><i class="fa fa-dot-circle-o has-text-link-dark	mr-2"></i>Completed Tasks <span
                  class="float-right">166</span></p>
              <p class="mb-4"><i class="fa fa-dot-circle-o has-text-warning mr-2"></i>Inprogress Tasks<span
                  class="float-right">166</span></p>
              <p class="mb-4"><i class="fa fa-dot-circle-o has-text-success mr-2"></i>On Hold Tasks<span
                  class="float-right">166</span></p>
              <p class="mb-4"><i class="fa fa-dot-circle-o has-text-danger mr-2"></i>Pending Tasks<span
                  class="float-right">166</span></p>
              <p class="mb-4"><i class="fa fa-dot-circle-o has-text-info mr-2"></i>Review Tasks<span
                  class="float-right">166</span>
              </p>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="card">
            <div class="card-header">
              <p class="card-header-title">
                <i class="fa fa-calendar-minus-o mr-2"></i>
                Upcoming Events
              </p>
            </div>
            <div class="card-content">

            </div>
          </div>
        </div>

      </div>
      <div class="columns">
        <div class="column">
          <div class="card has-table has-mobile-sort-spaced">
            <header class="card-header">
              <p class="card-header-title">
                <span class="icon">
                  <i class="fa fa-check-square-o"></i>
                </span>
                My Tasks
              </p>
              <a class="card-header-icon" href="#">
                <span class="icon">
                  <i class="fa fa-reload"></i>
                </span>
              </a>
            </header>
            <div class="card-content">
              <div class="b-table has-pagination">
                <div class="table-wrapper has-mobile-cards">
                  <table class="table is-fullwidth is-striped is-hoverable is-sortable is-fullwidth">

                    <tbody>
                    <tr>
                      <td class="is-image-cell">
                        <div class="image is-24x24">
                          <img
                              class="is-rounded"
                              src="https://www.gravatar.com/avatar/46f35f22abb304ff81d1eb5fb7d53cbd.jpg?s=200&d=identicon">
                        </div>
                      </td>
                      <td data-label="Name">Rebecca Bauch</td>
                      <td class="is-progress-cell" data-label="Progress">
                        <progress class="progress is-small is-primary" max="100" value="79">79</progress>
                      </td>
                      <td data-label="Created">
                        <small class="has-text-grey is-abbr-like" title="Oct 25, 2020">Oct 25, 2020</small>
                      </td>
                      <td class="is-actions-cell">
                        <div class="buttons is-right">
                          <button class="button is-small" type="button">
                            <span class="icon"><i class="fa fa-eye"></i></span>
                          </button>
                          <button class="button is-small jb-modal" data-target="sample-modal" type="button">
                            <span class="icon"><i class="fa fa-trash-o"></i></span>
                          </button>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td class="is-image-cell">
                        <div class="image is-24x24">
                          <img class="is-rounded" src="https://avatars.dicebear.com/v2/initials/felicita-yundt.svg">
                        </div>
                      </td>
                      <td data-label="Name">Felicita Yundt</td>
                      <td class="is-progress-cell" data-label="Progress">
                        <progress class="progress is-small is-primary" max="100" value="67">67</progress>
                      </td>
                      <td data-label="Created">
                        <small class="has-text-grey is-abbr-like" title="Jan 8, 2020">Jan 8, 2020</small>
                      </td>
                      <td class="is-actions-cell">
                        <div class="buttons is-right">
                          <button class="button is-small" type="button">
                            <span class="icon"><i class="fa fa-eye"></i></span>
                          </button>
                          <button class="button is-small jb-modal" data-target="sample-modal" type="button">
                            <span class="icon"><i class="fa fa-trash-o"></i></span>
                          </button>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td class="is-image-cell">
                        <div class="image is-24x24">
                          <img class="is-rounded"
                               src="https://avatars.dicebear.com/v2/initials/mr-larry-satterfield-v.svg">
                        </div>
                      </td>
                      <td data-label="Name">Mr. Larry Satterfield V</td>
                      <td class="is-progress-cell" data-label="Progress">
                        <progress class="progress is-small is-primary" max="100" value="16">16</progress>
                      </td>
                      <td data-label="Created">
                        <small class="has-text-grey is-abbr-like" title="Dec 18, 2020">Dec 18, 2020</small>
                      </td>
                      <td class="is-actions-cell">
                        <div class="buttons is-right">
                          <button class="button is-small" type="button">
                            <span class="icon"><i class="fa fa-eye"></i></span>
                          </button>
                          <button class="button is-small jb-modal" data-target="sample-modal" type="button">
                            <span class="icon"><i class="fa fa-trash-o"></i></span>
                          </button>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td class="is-image-cell">
                        <div class="image is-24x24">
                          <img class="is-rounded" src="https://avatars.dicebear.com/v2/initials/mr-broderick-kub.svg">
                        </div>
                      </td>
                      <td data-label="Name">Mr. Broderick Kub</td>
                      <td class="is-progress-cell" data-label="Progress">
                        <progress class="progress is-small is-primary" max="100" value="71">71</progress>
                      </td>
                      <td data-label="Created">
                        <small class="has-text-grey is-abbr-like" title="Sep 13, 2020">Sep 13, 2020</small>
                      </td>
                      <td class="is-actions-cell">
                        <div class="buttons is-right">
                          <button class="button is-small" type="button">
                            <span class="icon"><i class="fa fa-eye"></i></span>
                          </button>
                          <button class="button is-small jb-modal" data-target="sample-modal" type="button">
                            <span class="icon"><i class="fa fa-trash-o"></i></span>
                          </button>
                        </div>
                      </td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
    <div class="column pt-0 is-4">
      <PunchINPunchOutCard></PunchINPunchOutCard>

      <div class="mt-5 card">
        <div class="card-header">
          <p class="card-header-title">
            <i class="fa fa-check-circle-o mr-2"></i>
            My Leave
          </p>
        </div>
        <div class="card-content">
          <div class="columns">
            <div class="column">
              <div class="has-text-centered">
                <p class="title is-6">5.0</p>
                <p class="subtitle is-7">Leave Taken</p>
              </div>
            </div>
            <div class="column">
              <div class="has-text-centered">
                <p class="title is-6">5.0</p>
                <h2 class="subtitle is-7">Remaining</h2>
              </div>
            </div>
          </div>
          <div class="flex justify-center">
            <button class="button  btn-small" @click="showLeaveForm=true">Apply Leave</button>
          </div>
        </div>
      </div>

      <div class="card mt-5 ">
        <div class="card-header">
          <p class="card-header-title">
            <i class="fa fa-umbrella mr-2"></i>
            Today Absent
          </p>
        </div>
        <div class="card-content">
          <div class="card min-h-32 mb-4">
            <div class="card-content">
              <article class="media mb-2">
                <figure class="media-left">
                  <p class="image is-48x48">
                    <img alt=""
                         class="is-rounded"
                         src="https://www.gravatar.com/avatar/46f35f22abb304ff81d1eb5fb7d53cbd.jpg?s=200&d=identicon">
                  </p>
                </figure>
                <div class="media-content align-self-center">
                  <div class="content">
                    <p class="title is-6">
                      John Smith
                    </p>
                  </div>
                </div>
              </article>
              <div class="columns is-centered is-mobile">
                <div class="column is-6-mobile is-6-tablet">
                  <h6 class="title mb-0 is-7">4 Sep 2019</h6>
                  <span class="subtitle text-muted is-7">Leave Date</span>
                </div>
                <div class="column is-6-mobile is-6-tablet text-right">
                  <span class="tag is-success is-light">Pending</span>
                </div>
              </div>
            </div>
          </div>
          <div class="card min-h-32 mt-2">
            <div class="card-content">
              <article class="media mb-2">
                <figure class="media-left">
                  <p class="image is-48x48">
                    <img alt=""
                         class="is-rounded"
                         src="https://www.gravatar.com/avatar/46f35f22abb304ff81d1eb5fb7d53cbd.jpg?s=200&d=identicon">
                  </p>
                </figure>
                <div class="media-content align-self-center">
                  <div class="content">
                    <p class="title is-6">
                      Jane Smith
                    </p>
                  </div>
                </div>
              </article>
              <div class="columns is-mobile">
                <div class="column is-6">
                  <h6 class="title mb-0 is-7">4 Sep 2019</h6>
                  <span class="subtitle text-muted is-7">Leave Date</span>
                </div>
                <div class="column is-6 text-right">
                  <span class="tag is-success is-light">Pending</span>
                </div>
              </div>
            </div>
          </div>

          <div class="flex justify-center mt-4">
            <button class="button">Load More</button>
          </div>
        </div>
      </div>
    </div>
    <LeaveForm
        v-if="showLeaveForm"
        :use-router="false"
        @leaveRequestSuccessful="showLeaveForm=false"
        @modalClosed="showLeaveForm=false"></LeaveForm>
  </div>
</template>
<script>
const LeaveForm = () => import("../leave_management/LeaveRequestFormModal")
const PunchINPunchOutCard = () => import("../attendance/LastActivityCard")
export default {
  components: {
    LeaveForm,
    PunchINPunchOutCard
  },

  data() {
    return {
      showLeaveForm: false
    }
  }


}
</script>

<style lang="scss" scoped>
.heading {
  //font-size: 14px !important;
}

.progress {
  display: -ms-flexbox;
  display: flex;
  height: 1rem;
  overflow: hidden;
  font-size: .75rem;
  background-color: #e9ecef;
  border-radius: .25rem;
}

//.progress > .progress-bar {
//  background-color: #25628F;
//}

//.bg-purple, .badge-purple {
//  background-color: #7460ee !important;
//}
.progress-bar {
  display: -ms-flexbox;
  display: flex;
  -ms-flex-direction: column;
  flex-direction: column;
  -ms-flex-pack: center;
  justify-content: center;
  color: #fff;
  text-align: center;
  white-space: nowrap;
  background-color: #007bff;
  transition: width .6s ease;
}

.is-progress-cell {
  width: 25%;
}

</style>