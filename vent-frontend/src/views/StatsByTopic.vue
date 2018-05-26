<template>
  <div>
    <h2>Content usage by topic:</h2>
    <c-usage-topic :units=units></c-usage-topic>
    <h2>Content completion by topic:</h2>
    <c-completion-topic :units=units></c-completion-topic>
    <h2>Content recommended-rate by topic:</h2>
    <c-recommended-rate-topic :units=units></c-recommended-rate-topic>
  </div>
</template>

<script>

  import ContentUsageByTopic from './subviews/ContentUsageByTopic';
  import ContentCompletionByTopic from './subviews/ContentCompletionByTopic';
  import ContentRecommendedRateByTopic from './subviews/ContentRecommendedRateByTopic';

  import { store } from '../main';

  export default {
    components: {
      CUsageTopic: ContentUsageByTopic,
      CCompletionTopic: ContentCompletionByTopic,
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
