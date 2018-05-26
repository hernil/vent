<template>
  <div>
    <h2>Content usage by type:</h2>
    <c-usage-type :units=units></c-usage-type>
    <h2>Content completion by type:</h2>
    <c-completion-type :units=units></c-completion-type>
    <h2>Content recommended-rate by type:</h2>
    <c-recommended-rate-type :units=units></c-recommended-rate-type>
  </div>
</template>

<script>

  import ContentUsageByType from './subviews/ContentUsageByType';
  import ContentCompletionByType from './subviews/ContentCompletionByType';
  import ContentRecommendedRateByType from './subviews/ContentRecommendedRateByType';

  import { store } from '../main';

  export default {
    components: {
      CUsageType: ContentUsageByType,
      CCompletionType: ContentCompletionByType,
      CRecommendedRateType: ContentRecommendedRateByType,
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
