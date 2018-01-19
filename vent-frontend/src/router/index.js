import Vue from 'vue';
import Router from 'vue-router';
import Default from '@/components/Default';
import TestView1 from '@/components/TestView1';
import LineChartView from '@/components/charts/LineChart';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'root',
      component: Default,
    },
    {
      path: '/test',
      name: 'TestView',
      component: TestView1,
    },
    {
      path: '/line',
      name: 'LineChartView',
      component: LineChartView,
    },
  ],
});
