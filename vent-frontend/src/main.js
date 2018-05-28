// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import VueHighcharts from 'vue-highcharts';
import Highcharts from 'highcharts';
// import Vuex from 'vuex';
import App from './App';
import router from './router';


Vue.config.productionTip = false;

const store = {
  defaults: {
    defaultVSONUrl: 'http://localhost:8080/course/TDT4100',
  },
  course: null,
};
// eslint-disable-next-line import/prefer-default-export
export { store };
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  data: store,
  template: '<App/>',
  components: { App },
});

Vue.use(VueHighcharts, { Highcharts });

