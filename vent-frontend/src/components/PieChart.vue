<template>
  <div>
    <highcharts :options="options" ref="pieCharts"></highcharts>
    <!--<button @click="load">load</button>-->
  </div>
</template>

<script>
  /* eslint-disable no-console,prefer-const,spaced-comment */

  import axios from 'axios';
  import VueHighcharts from 'vue-highcharts';


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
              name: 'IE',
              y: 56.33,
              drilldown: 'IE',
            }, {
              name: 'Chrome',
              y: 24.03,
              drilldown: 'Chrome',
            }, {
              name: 'Firefox',
              y: 10.38,
              drilldown: 'Firefox',
            }, {
              name: 'Safari',
              y: 4.77,
              drilldown: 'Safari',
            }, {
              name: 'Opera',
              y: 0.91,
              drilldown: 'Opera',
            }, {
              name: 'Proprietary or Undetectable',
              y: 0.2,
              drilldown: null,
            }],
          }],
          drilldown: {
            series: [{
              name: 'IE',
              id: 'IE',
              data: [
                ['v11.0', 24.13],
                ['v8.0', 17.2],
                ['v9.0', 8.11],
                ['v10.0', 5.33],
                ['v6.0', 1.06],
                ['v7.0', 0.5],
              ],
            }, {
              name: 'Chrome',
              id: 'Chrome',
              data: [
                ['v40.0', 5],
                ['v41.0', 4.32],
                ['v42.0', 3.68],
                ['v39.0', 2.96],
                ['v36.0', 2.53],
                ['v43.0', 1.45],
                ['v31.0', 1.24],
                ['v35.0', 0.85],
                ['v38.0', 0.6],
                ['v32.0', 0.55],
                ['v37.0', 0.38],
                ['v33.0', 0.19],
                ['v34.0', 0.14],
                ['v30.0', 0.14],
              ],
            }, {
              name: 'Firefox',
              id: 'Firefox',
              data: [
                ['v35', 2.76],
                ['v36', 2.32],
                ['v37', 2.31],
                ['v34', 1.27],
                ['v38', 1.02],
                ['v31', 0.33],
                ['v33', 0.22],
                ['v32', 0.15],
              ],
            }, {
              name: 'Safari',
              id: 'Safari',
              data: [
                ['v8.0', 2.56],
                ['v7.1', 0.77],
                ['v5.1', 0.42],
                ['v5.0', 0.3],
                ['v6.1', 0.29],
                ['v7.0', 0.26],
                ['v6.2', 0.17],
              ],
            }, {
              name: 'Opera',
              id: 'Opera',
              data: [
                ['v12.x', 0.34],
                ['v28', 0.24],
                ['v27', 0.17],
                ['v29', 0.16],
              ],
            }],
          },
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
