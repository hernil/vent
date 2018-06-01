<template>
  <div>
    <h1>{{ data.course }}</h1>
    <div class="pure-g">
      <div class="pure-u-1 pure-u-lg-1-3">
        <LineChartView :title="'Avarage temperatures'" :subtitle="'Source: weather.com'" />
      </div>
      <div class="pure-u-1 pure-u-lg-1-3">
        <PieChartView/>
      </div>
      <div class="pure-u-1 pure-u-lg-1-3">
        <ColumnChartView/>
      </div>
    </div>
    <div class="pure-u-1 pure-u-lg-1-3">
      <SpiderChartView/>
    </div>
    <div class="pure-u-1 pure-u-lg-1-3">
      <SolidGaugeView/>
    </div>
  </div>
</template>

<script>
  import axios from 'axios';
  import LineChartView from '../components/charts/LineChart';
  import PieChartView from '../components/charts/PieChart';
  import ColumnChartView from '../components/charts/ColumnChart';
  import SpiderChartView from '../components/charts/SpiderChart';
  import SolidGaugeView from '../components/charts/SolidGauge';

  export default {
    name: 'Default',
    components: {
      LineChartView,
      PieChartView,
      ColumnChartView,
      SpiderChartView,
      SolidGaugeView,
    },
    data() {
      return {
        data: { course: 'Hei verden!' },
        errors: [],
      };
    },
    created() {
      axios.get('http://localhost:8080/greeting?name=Nils')
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
