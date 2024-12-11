import Vue from 'vue'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

ElementUI.Dialog.props.lockScroll.default = false;

Vue.use(ElementUI)
Vue.config.productionTip = false

import App from './App.vue'
import router from './router'

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
