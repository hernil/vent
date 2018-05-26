<template>
  <div>
    <expected-v-s-actual :units=units></expected-v-s-actual>
    <h2>Content usage by type:</h2>
    <c-usage-type :units=units></c-usage-type>
    <h2>Content usage by topic:</h2>
    <c-usage-topic :units=units></c-usage-topic>
    <h2>Content completion by type:</h2>
    <c-completion-type :units=units></c-completion-type>
    <h2>Content completion by topic:</h2>
    <c-completion-topic :units=units></c-completion-topic>
    <h2>Content recommended-rate by type:</h2>
    <c-recommended-rate-type :units=units></c-recommended-rate-type>
    <h2>Content recommended-rate by topic:</h2>
    <c-recommended-rate-topic :units=units></c-recommended-rate-topic>
  </div>
</template>

<script>

  import ExpectedVSActual from './subviews/ExpectedVSActualPerformance';
  import ContentUsageByType from './subviews/ContentUsageByType';
  import ContentUsageByTopic from './subviews/ContentUsageByTopic';
  import ContentCompletionByType from './subviews/ContentCompletionByType';
  import ContentCompletionByTopic from './subviews/ContentCompletionByTopic';
  import ContentRecommendedRateByType from './subviews/ContentRecommendedRateByType';
  import ContentRecommendedRateByTopic from './subviews/ContentRecommendedRateByTopic';

  import { store } from '../main';

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
        store,
      };
    },
    computed: {
      units() {
        return this.store.course.units;
      },
    },
  };

</script>

<style scoped>
  pre {

  }
</style>
