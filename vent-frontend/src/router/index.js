import Vue from 'vue';
import Router from 'vue-router';
import Default from '@/components/Default';
import TestView1 from '@/components/TestView1';
import LineChartView from '@/components/charts/LineChart';
import CourseView from '@/components/Course';

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
    {
      path: '/course',
      name: 'CourseView',
      component: CourseView,
    },
  ],
});
