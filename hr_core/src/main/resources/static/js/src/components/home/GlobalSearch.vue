<template>
  <div id="search-container" class="search-container">
    <div class="input-icon input-icon-left">
      <div class="relative lg:w-96 mt-2">
        <div class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
          <svg  class="w-5 h-5 text-gray-500 dark:text-gray-400 global-search-icon cursor-pointer" fill="currentColor" viewBox="0 0 20 20"
               xmlns="http://www.w3.org/2000/svg">
            <path clip-rule="evenodd"
                  d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
                  fill-rule="evenodd">
            </path>
          </svg>
        </div>
        <input id="global-search"
               class="global-search focus:ring-0 focus:ring-offset-0 py-1 bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm block w-full pl-10 p-2.5  "
               name="search"
               placeholder="Search"
               autocomplete="off"
               v-model="searchTerm"
               @focusin="globalSearchFocus(true)"
               type="search">
      </div>
    </div>
    <div id="globalSearchDropdown" class="dropdown-content w-full  shadow-xl" >
      <div class="drop-down-wrapper infinite-global-search-wrapper" style="overflow-y: scroll;scroll-behavior: smooth;">
        <div class="flex justify-center w-full h-full ">
          <h1 class="self-center text-gray-600">Result</h1>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      searchTerm: '',
      searchUrl: '/api/global-search',
      searchResults: [],
      title: "Search results",
      infiniteId: +new Date() + 'search',
      page: 2,
      selectedResultId: ''
    }
  },
  methods: {
    viewPage(id) {

      this.selectedResultId = id;

      return axios.get(`/admin/trips/trip/` + id, {}).then((response) => {

        $("#global-search").addClass("global-search").removeClass("active-global-search");

        $(".dropdown-content").hide();

        $(".main-container").css({
          "opacity": '',
        });
      });

    },
    doSearch(page = null) {
      let url = this.searchUrl + '?search_term=' + this.searchTerm;

      if (page) {
        url = url + '&page=' + page
      }

      return new Promise((resolve, reject) => {
        axios.get(url, {}).then((response) => {

          if (!page) {
            this.searchResults = [];
          }

          this.searchResults.push(...response.data.data);

          resolve(response.data);
        }).catch(error => {
          reject(error)
        });
      });

    },
    delay(callback, ms) {
      let timer = 0;
      return function () {
        let context = this, args = arguments;
        clearTimeout(timer);
        timer = setTimeout(function () {
          callback.apply(context, args);
        }, ms || 0);
      };
    },
    globalSearchFocus(val) {
      if (val) {
        // adding backdrop to the main container
        $(".main-container").css({
          // "opacity": "0.5"
          // "background":"rgba(0, 0, 0, 0.5)",
          // "z-index":2000,
        })

        $(".dropdown-content").css({
          "display": "block"
        })

        $("#global-search").removeClass("global-search").addClass("active-global-search");

      }
      console.log(val)
    }
  },
  mounted() {
    // global-search
    $(document).on('input', '#global-search', this.delay((event) => {
      event.preventDefault();

      this.page = 1;
      this.searchResults = [];

      // this.doSearch();
    }, 500))

    this.doSearch();

    // close modal on click outside at anywhere
    $(document).on('click', function (e) {

      if (!(($(e.target).closest("#search-container").length > 0))) {
        $(".dropdown-content").css({
          "display": ""
        })

        $(".main-container").css({
          // "opacity": '',
          // "background":"",
          // "z-index":"",
        });

        $("#global-search").addClass("global-search").removeClass("active-global-search");
      }
    });

  }
}
</script>


<style lang="scss" scoped>
.global-search-icon {
  //padding-left: 15px;
  //color: #fff
}

.selected-search-result {
//  background: #037aff !important;
//  color: #ffffff !important;
}

.active-global-search > .global-search-icon {
  color: rgb(69 38 38) !important;
}

.active-global-search {
  border-radius: 20px 20px 0 0;
  height: 40px;
  outline-width: 0;
}

.global-search {
  border-radius: 20px 20px 20px 20px;
  height: 40px;
  outline-width: 0;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #ffffff;
  z-index: 9999;
}

.infinite-global-search-wrapper {
  height: 420px;
}

.dropdown-content a:hover {
  background-color: #ddd
}

.search-container, #globalSearchDropdown {
  width: 550px;
}

.input-icon.input-icon-right > input {
  padding-left: 20px !important;
}
</style>
