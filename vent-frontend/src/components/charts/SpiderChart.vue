<template>
  <div>
    <highcharts :options="options" ref="spiderCharts"></highcharts>
    <!--<button @click="load">load</button>-->
  </div>
</template>

<script>
  /* eslint-disable no-console,prefer-const,spaced-comment,no-unused-vars,object-shorthand,no-undef */
  import axios from 'axios';
  import Highcharts from 'highcharts';
  import loadHighchartsMore from 'highcharts/highcharts-more';
  import VueHighcharts from 'vue-highcharts';

  loadHighchartsMore(Highcharts);

  export default {
    components: {
      VueHighcharts,
    },
    data() {
      return {
        options: {
          chart: {
            polar: true,
            type: 'line',
          },

          title: {
            text: 'Budget vs spending',
            x: -80,
          },

          pane: {
            size: '80%',
          },

          xAxis: {
            categories: ['Sales', 'Marketing', 'Development', 'Customer Support',
              'Information Technology', 'Administration'],
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
            //pointFormat: '<span style="color:{series.color}"
            // >{series.name}: <b>${point.y:,.0f}</b><br/>',
          },

          legend: {
            align: 'right',
            verticalAlign: 'top',
            y: 70,
            layout: 'vertical',
          },

          series: [{
            name: 'Allocated Budget',
            data: [43000, 19000, 60000, 35000, 17000, 10000],
            pointPlacement: 'on',
          }, {
            name: 'Actual Spending',
            data: [50000, 39000, 42000, 31000, 26000, 14000],
            pointPlacement: 'on',
          }],
        },
      };
    },
    mounted() {
      //HighchartsMore(VueHighcharts.Highcharts);
      const spiderCharts = this.$refs.spiderCharts;
      const url = 'http://localhost:8080/data/1';
      axios.get(url).then((response) => {
        //spiderCharts.chart.addSeries(response.data);
      });
    },
  };
</script>
