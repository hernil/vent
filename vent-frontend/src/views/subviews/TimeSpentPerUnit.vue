<template>
  <div v-if=this.categories>
    <column-chart :title="'Total time spent per unit'" :subtitle="'On avarage'" :categories=this.categories :yAxis="'Minutes'" :series=this.series></column-chart>
  </div>
</template>

<script>

  import ColumnChart from '../../components/charts/ColumnChart';

  export default {
    name: 'TimeSpentPerUnit',
    components: { ColumnChart },
    props: {
      units: {
        type: Array,
        default: () => [],
        required: true,
      },
    },
    computed: {
      series() {
        const data = [];
        this.units.forEach((unit) => {
          const serie = {};
          serie.data = unit.timeSpent;
          data.push(unit.timeSpent / 60);
        });
        return data;
      },
      categories() {
        const categories = [];
        this.units.forEach((unit) => {
          categories.push(unit.name);
        });
        return categories;
      },
    },
  };

</script>

<style scoped>

</style>
