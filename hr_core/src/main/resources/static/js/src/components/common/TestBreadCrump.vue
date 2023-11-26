<template>
    <Breadcrumb class="app-breadcrumb text-black font-weight-bold" separator="/">
        <transition-group name="breadcrumb">
            <BreadcrumbItem v-for="(item,index) in levelList" :key="item.path">
                <span v-if="item.redirect==='noRedirect'||index==levelList.length-1" :class="levelList.length<=1?'level-one':''" class="no-redirect">{{ item.meta.title }}</span>
                <a v-else @click.prevent="handleLink(item)">{{ item.meta.title }}</a>
            </BreadcrumbItem>
        </transition-group>
    </Breadcrumb>
</template>

<script>
    // import * as pathToRegexp
    import * as pathToRegexp from 'path-to-regexp'
    import {Breadcrumb, BreadcrumbItem} from "element-ui"

    export default {
        components: {
            Breadcrumb,
            BreadcrumbItem
        },
        data() {
            return {
                levelList: null
            }
        },
        watch: {
            $route(route) {
                // if you go to the redirect page, do not update the breadcrumbs
                if (route.path.startsWith('/redirect/')) {
                    return
                }
                this.getBreadcrumb()
            }
        },
        created() {
            this.getBreadcrumb()
        },
        methods: {
            getBreadcrumb() {
                // only show routes with meta.title
                let matched = this.$route.matched.filter(item => item.meta && item.meta.title)
                const first = matched[0]
                if (!this.isHome(first)) {
                    matched = [{path: '/', meta: {title: 'Home',redirect: true}}].concat(matched)
                }

                this.levelList = matched.filter(item => item.meta && item.meta.title && item.meta.breadcrumb !== false)
            },
            isHome(route) {
                const name = route && route.name
                if (!name) {
                    return false
                }
                return name.trim().toLocaleLowerCase() === 'Home'.toLocaleLowerCase()
            },
            pathCompile(path) {
                // To solve this problem https://github.com/PanJiaChen/vue-element-admin/issues/561
                const {params} = this.$route
                var toPath = pathToRegexp.compile(path)
                return toPath(params)
            },
            handleLink(item) {
                const {redirect, path} = item
                if (redirect) {
                    this.$router.push(redirect)
                    return
                }
                this.$router.push(this.pathCompile(path))
            }
        }
    }
</script>

<style lang="scss" scoped>
    .app-breadcrumb.el-breadcrumb {
        display: inline-block;
        font-size: 14px;
        line-height: 50px;
        margin-left: 8px;
        .no-redirect {
            //color: #97a8be;
            cursor: text;
        }
    }
    .el-breadcrumb__item{
      align-items: center;
      color: #363636;
      display: flex;
      flex-grow: 1;
      font-weight: 700 !important;
      font-size: 16px !important;
    }

    .level-one{
      font-weight: 700 !important;
      font-size: 16px !important;
      color: #363636 !important;
    }

</style>