<template>
  <div>
    <pre>{{ course.id }}</pre>
    <c-usage-type :units=course.units></c-usage-type>
  </div>
</template>

<script>

  import axios from 'axios';
  import ContentUsageByType from './subviews/ContentUsageByType';

  export default {
    components: { CUsageType: ContentUsageByType },
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
