<template>
  <div class="pure-g">
    <div v-for="unit in parsedUnits" class="pure-u-sm-1-2 pure-u-lg-1-4">
      <solid-gauge :title=unit.type :value=unit.completed></solid-gauge>
    </div>
  </div>
</template>

<script>

  import SolidGauge from '../../components/charts/SolidGauge';

  export default {
    name: 'ContentCompletionByType',
    components: { SolidGauge },
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
    },
    methods: {
      parseUnitsForRendering: (input) => {
        const sums = {};
        const counts = {};
        const results = [];
        let type;
        input.forEach((unit) => {
          type = unit.type;
          if (!(type in sums)) {
            sums[type] = 0;
            counts[type] = 0;
          }
          sums[type] += unit.completed;
          counts[type] += 1;
        });
        Object.keys(sums).forEach((key) => {
          if (Object.prototype.hasOwnProperty.call(sums, key)) {
            results.push(
              {
                type: key,
                completed: sums[key] / counts[key],
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
