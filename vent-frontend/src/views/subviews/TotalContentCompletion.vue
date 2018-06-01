<template>
  <div class="" v-if=this.value>
      <solid-gauge :title="'Total completion'" :value=value></solid-gauge>
  </div>
</template>

<script>

  import SolidGauge from '../../components/charts/SolidGauge';

  export default {
    name: 'TotalContentCompletion',
    components: { SolidGauge },
    props: {
      units: {
        type: Array,
        default: () => [],
        required: true,
      },
    },
    computed: {
      value() {
        let sum = 0;
        this.units.forEach((unit) => {
          sum += unit.completed;
        });
        return sum / this.units.length;
      },
    },
  };

</script>

<style scoped>

</style>
