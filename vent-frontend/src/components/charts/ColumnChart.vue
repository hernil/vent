<template>
  <div>
    <highcharts :options="options" ref="barCharts"></highcharts>
    <!--<button @click="load">load</button>-->
  </div>
</template>

<script>

  import VueHighcharts from 'vue-highcharts';

  export default {
    components: {
      VueHighcharts,
    },
    props: {
      title: {
        type: String,
        default: 'ColumnChart',
        required: true,
      },
      subtitle: {
        type: String,
        default: '',
        required: true,
      },
      yAxis: {
        type: String,
        default: '',
        required: true,
      },
      categories: {
        type: Array,
        default: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
          'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
        required: true,
      },
      series: {
        type: Array,
        default: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4],
        required: true,
      },
    },
    watch: {
      categories(val) { this.options.xAxis.categories = val; },
      yAxis(val) { this.options.yAxis.title.text = val; },
      series(val) { this.options.series[0].data = val; },
    },
    data() {
      return {
        options: {
          chart: {
            type: 'column',
          },
          title: {
            text: this.title,
          },
          subtitle: {
            text: this.subtitle,
          },
          xAxis: {
            categories: this.categories,
          },
          yAxis: {
            title: {
              text: this.yAxis,
            },
            labels: {
              formatter() {
                return `${this.value}`;
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
          series: [{
            name: 'Data',
            data: this.series,

          },
          ],
        },
      };
    },
  };
</script>
