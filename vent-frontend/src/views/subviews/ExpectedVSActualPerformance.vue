<template>
  <div v-if=this.categories>
    <spider-chart :title="'Expected vs. Actual performance'" :categories=this.categories :expected=this.expected :actual=this.actual></spider-chart>
  </div>
</template>

<script>

  import SpiderChart from '../../components/charts/SpiderChart';

  export default {
    name: 'ExpectedVSActual',
    components: { SpiderChart },
    props: {
      units: {
        type: Array,
        default: () => [],
        required: true,
      },
    },
    computed: {
      parsedUnits() {
        return this.parseUnitsForRendering(this.units);
      },
      categories() {
        return this.parseUnitsForRendering(this.units).map(unit => unit.topic);
      },
      expected() {
        return this.parseUnitsForRendering(this.units).map(unit => unit.expectedPerformance);
      },
      actual() {
        return this.parseUnitsForRendering(this.units).map(unit => unit.performance);
      },
    },
    methods: {
      parseUnitsForRendering: (input) => {
        const performances = {};
        const expectedPerformances = {};
        const counts = {};
        const results = [];
        let topic;
        input.forEach((unit) => {
          topic = unit.topic;
          if (!(topic in performances)) {
            performances[topic] = 0;
            expectedPerformances[topic] = 0;
            counts[topic] = 0;
          }
          performances[topic] += unit.performance;
          expectedPerformances[topic] += unit.expectedPerformance;
          counts[topic] += 1;
        });
        Object.keys(performances).forEach((key) => {
          if (Object.prototype.hasOwnProperty.call(performances, key)) {
            results.push(
              {
                topic: key,
                performance: performances[key] / counts[key],
                expectedPerformance: expectedPerformances[key] / counts[key],
              });
          }
        });
        return results;
      },
    },
  };

</script>

<style scoped>

</style>
