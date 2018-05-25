<template>
  <div>
    <h1>{{ data.course }}</h1>
    <div class="pure-g">
      <div class="pure-u-1 pure-u-lg-1-3">
        <SpiderChartView/>
      </div>
      <div class="pure-u-1 pure-u-lg-1-3">
        <LineChartView/>
      </div>
      <div class="pure-u-1 pure-u-lg-1-3">
        <BarChartView/>
      </div>
      <div class="pure-u-1 pure-u-lg-1-3">
        <PieChartView/>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios';
  import LineChartView from './charts/LineChart';
  import PieChartView from './charts/PieChart';
  import BarChartView from './charts/BarChart';
  import SpiderChartView from './charts/SpiderChart';

  export default {
    name: 'TestView1',
    components: {
      LineChartView,
      PieChartView,
      BarChartView,
      SpiderChartView,
    },
    data() {
      return {
        data: { course: 'Hei verden!' },
        errors: [],
      };
    },
    created() {
      axios.get('http://localhost:8080/greeting?name=test')
        .then((response) => {
          // JSON responses are automatically parsed.
          this.data = response.data;
        })
        .catch((e) => {
          this.errors.push(e);
        });
    },
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
