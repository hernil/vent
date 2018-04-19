<template>
  <div>
    <pre>{{ course.id }}</pre>
    <expected-v-s-actual :units=course.units></expected-v-s-actual>
    <h2>Content usage by type:</h2>
    <c-usage-type :units=course.units></c-usage-type>
    <h2>Content usage by topic:</h2>
    <c-usage-topic :units=course.units></c-usage-topic>
    <h2>Content completion by type:</h2>
    <c-completion-type :units=course.units></c-completion-type>
    <h2>Content completion by topic:</h2>
    <c-completion-topic :units=course.units></c-completion-topic>
    <h2>Content recommended-rate by type:</h2>
    <c-recommended-rate-type :units=course.units></c-recommended-rate-type>
    <h2>Content recommended-rate by topic:</h2>
    <c-recommended-rate-topic :units=course.units></c-recommended-rate-topic>
  </div>
</template>

<script>

  import axios from 'axios';
  import ExpectedVSActual from './subviews/ExpectedVSActualPerformance';
  import ContentUsageByType from './subviews/ContentUsageByType';
  import ContentUsageByTopic from './subviews/ContentUsageByTopic';
  import ContentCompletionByType from './subviews/ContentCompletionByType';
  import ContentCompletionByTopic from './subviews/ContentCompletionByTopic';
  import ContentRecommendedRateByType from './subviews/ContentRecommendedRateByType';
  import ContentRecommendedRateByTopic from './subviews/ContentRecommendedRateByTopic';

  export default {
    components: {
      ExpectedVSActual,
      CUsageType: ContentUsageByType,
      CUsageTopic: ContentUsageByTopic,
      CCompletionType: ContentCompletionByType,
      CCompletionTopic: ContentCompletionByTopic,
      CRecommendedRateType: ContentRecommendedRateByType,
      CRecommendedRateTopic: ContentRecommendedRateByTopic,
    },
    data() {
      return {
        course: [],
        errors: [],
      };
    },
    mounted() {
      const url = 'http://localhost:8080/course/TDT4100';
      axios.get(url).then((response) => {
        this.course = response.data;
      })
      .catch((e) => {
        this.errors.push(e);
      });
    },
  };

</script>

<style scoped>
  pre {

  }
</style>
