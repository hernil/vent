<template>
  <div>
    <vue-highcharts :options="options" ref="barCharts"></vue-highcharts>
    <!--<button @click="load">load</button>-->
  </div>
</template>

<script>
  /* eslint-disable no-console,prefer-const,spaced-comment */

  import axios from 'axios';
  import VueHighcharts from 'vue2-highcharts';

  export default {
    components: {
      VueHighcharts,
    },
    data() {
      return {
        options: {
          chart: {
            type: 'bar',
          },
          title: {
            text: 'Monthly Average Temperature',
          },
          subtitle: {
            text: 'Source: WorldClimate.com',
          },
          xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
              'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
          },
          yAxis: {
            title: {
              text: 'Temperature',
            },
            labels: {
              formatter() {
                return `${this.value}°`;
              },
            },
          },
          tooltip: {
            crosshairs: true,
            shared: true,
          },
          credits: {
            enabled: false,
          },
          plotOptions: {
            spline: {
              marker: {
                radius: 4,
                lineColor: '#666666',
                lineWidth: 1,
              },
            },
          },
          series: [],
        },
      };
    },
    mounted() {
      /*const barCharts = this.$refs.barCharts;
      const url = 'http://localhost:8080/data/20';
      barCharts.delegateMethod('showLoading', 'Loading...');
      setTimeout(() => {
        let asyncData = {};
        axios.get(url)
          .then((response) => {
            // JSON responses are automatically parsed.
            // console.log(response.data);
            asyncData = response.data;
            console.log(asyncData);
            barCharts.addSeries(asyncData);
            barCharts.hideLoading();
          })
          .catch((e) => {
            console.log(e);
          });
      }, 50);*/
      const barCharts = this.$refs.barCharts;
      const url = 'http://localhost:8080/data/1';
      axios.get(url).then((response) => {
        barCharts.addSeries(response.data);
      });
    },
  };
</script>
