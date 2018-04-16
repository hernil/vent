<template>
  <div>
    <c-usage-type :units=course.units></c-usage-type>
    <pre>{{ course.id }}</pre>
  </div>
</template>

<script>
  /* eslint-disable no-console */

  import axios from 'axios';
  import CUsageType from './subviews/CUsageType';

  export default {
    components: { CUsageType },
    data() {
      return {
        course: ['test'],
        errors: [],
      };
    },
    beforeMount() {
      const url = 'http://localhost:8080/course/TDT4100';
      axios.get(url).then((response) => {
        this.course = response.data;
        console.log('fetched');
      })
      .catch((e) => {
        this.errors.push(e);
        console.log(e);
      });
    },
  };

</script>

<style scoped>
  pre {

  }
</style>
