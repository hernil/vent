import Vue from 'vue';
import Router from 'vue-router';
import Default from '@/views/Default';
import CourseView from '@/views/Course';
import StatsByTopicView from '@/views/StatsByTopic';
import StatsByTypeView from '@/views/StatsByType';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'root',
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
    {
      path: '/test',
      name: 'TestView',
      component: Default,
    },
  ],
});
