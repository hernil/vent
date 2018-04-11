<template>
  <div>
    <highcharts :options="options" ref="solidGauge"></highcharts>
    <!--<button @click="load">load</button>-->
  </div>
</template>

<script>
  /* eslint-disable no-console,prefer-const,spaced-comment, prefer-template */

  import axios from 'axios';
  import VueHighcharts from 'vue-highcharts';
  import Highcharts from 'highcharts';

  import solidGauge from 'highcharts/modules/solid-gauge';

  solidGauge(Highcharts);

  export default {
    components: {
      VueHighcharts,
    },
    data() {
      return {
        options: {
          chart: {
            type: 'solidgauge',
          },

          title: 'Arraylist',

          pane: {
            center: ['50%', '85%'],
            size: '100%',
            startAngle: -90,
            endAngle: 90,
            background: {
              backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || '#EEE',
              innerRadius: '60%',
              outerRadius: '100%',
              shape: 'arc',
            },
          },

          tooltip: {
            enabled: false,
          },

          // the value axis
          yAxis: {
            min: 0,
            max: 100,
            stops: [
              [0.1, '#DF5353'], // red,
              [0.5, '#DDDF0D'], // yellow
              [0.9, '#55BF3B'], // green
            ],
            lineWidth: 0,
            minorTickInterval: null,
            tickAmount: 2,
            title: {
              text: 'Arraylist',
              y: -110,
            },
            labels: {
              y: 16,
            },
          },

          plotOptions: {
            solidgauge: {
              dataLabels: {
                y: 5,
                borderWidth: 0,
                useHTML: true,
              },
            },
          },
          credits: {
            enabled: false,
          },
          series: [{
            name: 'Percentage used',
            data: [80],
            dataLabels: {
              format: '<div style="text-align:center"><span style="font-size:25px;color:' +
              ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y}</span>' +
              '<span style="font-size:25px">%</span></div>',
            },
            tooltip: {
              valueSuffix: ' %',
            },
          }],
        },
      };
    },
    mounted() {
      //const pieCharts = this.$refs.pieCharts;
      const url = 'http://localhost:8080/data/1';
      axios.get(url).then((response) => {
        //pieCharts.addSeries(response.data);
        console.log(response.data);
      });
    },
  };
</script>
