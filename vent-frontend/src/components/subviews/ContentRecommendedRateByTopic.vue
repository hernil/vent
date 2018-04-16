<template>
  <div class="pure-g">
    <div v-for="unit in parsedUnits" class="pure-u-sm-1-2 pure-u-lg-1-4">
      <solid-gauge :title=unit.topic :value=unit.recommended></solid-gauge>
    </div>
  </div>
</template>

<script>

  import SolidGauge from '../charts/SolidGauge';

  export default {
    name: 'ContentRecommendedRateByTopic',
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
        let topic;
        input.forEach((unit) => {
          topic = unit.topic;
          if (!(topic in sums)) {
            sums[topic] = 0;
            counts[topic] = 0;
          }
          sums[topic] += unit.recommended;
          counts[topic] += 1;
        });
        Object.keys(sums).forEach((key) => {
          if (Object.prototype.hasOwnProperty.call(sums, key)) {
            results.push(
              {
                topic: key,
                recommended: sums[key] / counts[key],
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
