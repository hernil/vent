<template>
  <div>
    <vue-highcharts :options="options" ref="lineCharts"></vue-highcharts>
    <!--<button @click="load">load</button>-->
  </div>
</template>

<script>
  /* eslint-disable no-console,prefer-const,spaced-comment */

  import axios from 'axios';
  import VueHighcharts from 'vue2-highcharts';

  // eslint-disable-next-line prefer-const
  /*let asyncData = {
    name: 'Tokyo',
    marker: {
      symbol: 'square',
    },
    data: [],
  };*/
  export default {
    components: {
      VueHighcharts,
    },
    data() {
      return {
        options: {
          chart: {
            type: 'spline',
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
      const lineCharts = this.$refs.lineCharts;
      const url = 'http://localhost:8080/data/20';
      lineCharts.delegateMethod('showLoading', 'Loading...');
      setTimeout(() => {
        let asyncData = {};
        axios.get(url)
          .then((response) => {
            // JSON responses are automatically parsed.
            // console.log(response.data);
            asyncData = response.data;
            console.log(asyncData);
            lineCharts.addSeries(asyncData);
            lineCharts.hideLoading();
          })
          .catch((e) => {
            console.log(e);
          });
      }, 50);
    },
  };
</script>
