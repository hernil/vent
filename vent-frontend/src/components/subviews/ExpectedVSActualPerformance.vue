<template>
  <div v-if=this.categories>
    <spider-chart :categories=this.categories :expected=this.expected :actual=this.actual></spider-chart>
  </div>
</template>

<script>

  import SpiderChart from '../charts/SpiderChart';

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
      categories() { return this.parseUnitsForRendering(this.units).map(unit => unit.topic); },
      expected() {
        return this.parseUnitsForRendering(this.units).map(unit => unit.expectedPerformance);
      },
      actual() { return this.parseUnitsForRendering(this.units).map(unit => unit.performance); },
    },
    methods: {
      parseUnitsForRendering: (input) => {
        const performances = {};
        const expectedPerformances = {};
        const counts = {};
        const results = [];
        let type;
        input.forEach((unit) => {
          type = unit.topic;
          if (!(type in performances)) {
            performances[type] = 0;
            expectedPerformances[type] = 0;
            counts[type] = 0;
          }
          performances[type] += unit.performance;
          expectedPerformances[type] += unit.expectedPerformance;
          counts[type] += 1;
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
