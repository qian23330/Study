import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home,
    meta: {
      keepAlive: false
    }
  },
  {
    path: '/committee',
    name: 'committee',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/Committee.vue')
  },
  {
    path: '/speakers',
    name: 'speakers',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/Speakers.vue')
  },
  {
    path: '/schedule',
    name: 'schedule',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/Schedule.vue')
  },
  {
    path: '/submission',
    name: 'submission',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/Submission.vue')
  },
  {
    path: '/traffic',
    name: 'traffic',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/Traffic.vue')
  },
  {
    path: '/history',
    name: 'history',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/History.vue')
  },
]

const router = new VueRouter({
  scrollBehavior(to, from, savedPosition) {
    // 如果有指定的滚动位置，则直接滚动到指定位置
    if (to.hash) {
      return {
        selector: to.hash
      }
    }
    // 否则滚动到顶部
    return { x: 0, y: 0 }
  },
  routes
})

export default router
