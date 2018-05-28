<template>
  <div>
    <highcharts :options="options" ref="solidGauge"></highcharts>
    <!--<button @click="load">load</button>-->
  </div>
</template>

<script>
  /* eslint-disable no-console,prefer-const,spaced-comment, prefer-template */

  import VueHighcharts from 'vue-highcharts';
  import Highcharts from 'highcharts';

  import solidGauge from 'highcharts/modules/solid-gauge';

  solidGauge(Highcharts);

  export default {
    components: {
      VueHighcharts,
    },
    props: {
      title: {
        type: String,
        default: '',
      },
      value: {
        type: Number,
        required: false,
        default: 0.42,
      },
    },
    data() {
      return {
        options: {
          chart: {
            type: 'solidgauge',
            height: '75%',
          },

          title: this.title,

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
            enabled: true,
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
              text: this.title,
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
            name: this.title,
            data: [Math.round(this.value * 1000) / 10],
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
  };
</script>
