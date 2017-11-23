<template>
  <div>
    <vue-highcharts :options="options" ref="pieCharts"></vue-highcharts>
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
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie',
          },
          title: {
            text: 'Browser market shares January, 2015 to May, 2015',
          },
          tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>',
          },
          plotOptions: {
            pie: {
              allowPointSelect: true,
              cursor: 'pointer',
              dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                style: {
                  color: (VueHighcharts.theme && VueHighcharts.theme.contrastTextColor) || 'black',
                },
              },
            },
          },
          credits: {
            enabled: false,
          },
          series: [{
            name: 'Brands',
            colorByPoint: true,
            data: [{
              name: 'A',
              y: 4.77,
            }, {
              name: 'B',
              y: 24.03,
            }, {
              name: 'C',
              y: 56.33,
            }, {
              name: 'D',
              y: 10.38,
            }, {
              name: 'E',
              y: 0.91,
            }, {
              name: 'F',
              y: 0.2,
            }],
          }],
        },
      };
    },
    mounted() {
      //const pieCharts = this.$refs.pieCharts;
      const url = 'http://localhost:8080/data/20';
      axios.get(url).then((response) => {
        //pieCharts.addSeries(response.data);
        console.log(response.data);
      });
    },
  };
</script>
