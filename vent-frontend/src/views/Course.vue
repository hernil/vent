<template>
  <div class="pure-g">
    <div class="pure-u-sm-1-2 pure-u-lg-1-4">
      <expected-v-s-actual :units=units></expected-v-s-actual>
    </div>
    <div class="pure-u-sm-1-2 pure-u-lg-1-4">
      <total-content-completion :units=units></total-content-completion>
    </div>
    <div class="pure-u-sm-1-2 pure-u-lg-1-4">
      <time-spent-per-unit :units=units></time-spent-per-unit>
    </div>
  </div>
</template>

<script>

  import ExpectedVSActual from './subviews/ExpectedVSActualPerformance';
  import TotalContentCompletion from './subviews/TotalContentCompletion';
  import TimeSpentPerUnit from './subviews/TimeSpentPerUnit';

  import { store } from '../main';

  export default {
    components: {
      ExpectedVSActual,
      TotalContentCompletion,
      TimeSpentPerUnit,
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
