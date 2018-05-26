import Vue from 'vue';
import Router from 'vue-router';
import Default from '@/views/Default';
import TestView1 from '@/views/TestView1';
import CourseView from '@/views/Course';
import StatsByTopicView from '@/views/StatsByTopic';
import StatsByTypeView from '@/views/StatsByType';

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
      path: '/course',
      name: 'CourseView',
      component: CourseView,
    },
    {
      path: '/topic',
      name: 'TopicView',
      component: StatsByTopicView,
    },
    {
      path: '/type',
      name: 'TypeView',
      component: StatsByTypeView,
    },
  ],
});
