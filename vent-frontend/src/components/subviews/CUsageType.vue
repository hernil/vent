<template>
  <div class="pure-g">
    <div v-for="unit in typedUnits" class="pure-u-1 pure-u-lg-1-4">
      <solid-gauge :title=unit.type :value=unit.opened></solid-gauge>
    </div>
  </div>
</template>

<script>
  /* eslint-disable no-prototype-builtins,no-param-reassign,
  prefer-const,one-var,no-console,func-names */

  import SolidGauge from '../charts/SolidGauge';

  export default {
    name: 'CUsageType',
    components: { SolidGauge },
    props: {
      units: {
        type: Array,
        default: () => [],
        required: true,
      },
    },
    computed: {
      typedUnits() {
        return this.pfr2(this.units);
      },
    },
    methods: {
      prepareForRender: (input) => {
        let sums = {},
          averages = Object.keys(input.reduce((previous, element) => {
            if (previous.hasOwnProperty(element.type)) {
              previous[element.type].opened += element.opened;
              previous[element.type].count += 1;
            } else {
              previous[element.type] = {
                opened: element.opened,
                count: 1,
              };
            }
            return previous;
          }, sums)).map(function (type) {
            return {
              type,
              opened: this[type].opened / this[type].count,
            };
          }, sums);

        return (averages);
      },
      pfr2: (input) => {
        let sums = {};
        let counts = {};
        let results = [];
        let type;
        input.forEach((unit) => {
          type = unit.type;
          if (!(type in sums)) {
            sums[type] = 0;
            counts[type] = 0;
          }
          sums[type] += unit.opened;
          counts[type] += 1;
        });
// eslint-disable-next-line guard-for-in,no-restricted-syntax
        for (type in sums) {
          results.push(
            {
              type,
              opened: sums[type] / counts[type],
            });
        }
        return results;
      },
    },
  };

</script>

<style scoped>

</style>
