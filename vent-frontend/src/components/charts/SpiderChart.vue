<template>
  <div>
    <div v-if=this.categories>
      <highcharts :options="options" ref="spiderCharts"></highcharts>
    <!--<button @click="load">load</button>-->
    </div>
  </div>
</template>

<script>
  import Highcharts from 'highcharts';
  import loadHighchartsMore from 'highcharts/highcharts-more';
  import VueHighcharts from 'vue-highcharts';

  loadHighchartsMore(Highcharts);

  export default {
    components: {
      VueHighcharts,
    },
    props: {
      title: {
        type: String,
        default: 'Spiderchart',
        required: true,
      },
      categories: {
        type: Array,
        default: ['test'],
        required: true,
      },
      expected: {
        type: Array,
        default: [10],
        required: true,
      },
      actual: {
        type: Array,
        default: [9],
        required: true,
      },
    },
    watch: {
      categories(val) { this.options.xAxis.categories = val; },
      expected(val) { this.options.series[0].data = val; },
      actual(val) { this.options.series[1].data = val; },
    },
    data() {
      return {
        options: {
          chart: {
            polar: true,
            type: 'line',
          },

          title: {
            text: this.title,
            x: -80,
          },

          pane: {
            size: '80%',
          },

          xAxis: {
            categories: this.categories,
            tickmarkPlacement: 'on',
            lineWidth: 0,
          },

          yAxis: {
            gridLineInterpolation: 'polygon',
            lineWidth: 0,
            min: 0,
          },

          tooltip: {
            shared: true,
          },

          legend: {
            align: 'right',
            verticalAlign: 'top',
            y: 70,
            layout: 'vertical',
          },

          series: [{
            name: 'Actual',
            data: this.actual,
            pointPlacement: 'on',
          }, {
            name: 'Expected',
            data: this.expected,
            pointPlacement: 'on',
          }],
        },
      };
    },
  };
</script>
