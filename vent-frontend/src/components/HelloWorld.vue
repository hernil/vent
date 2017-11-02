<template>
  <div class="hello">
    <h1>{{ msg.content }}</h1>
    <DataView/>
  </div>
</template>

<script>
  import axios from 'axios';
  import DataView from './Data';

  export default {
    name: 'HelloWorld',
    components: {
      DataView,
    },
    data() {
      return {
        msg: { content: 'Hei verden!' },
        errors: [],
      };
    },
    created() {
      axios.get('http://localhost:8080/greeting?name=Nils')
        .then((response) => {
          // JSON responses are automatically parsed.
          this.msg = response.data;
        })
        .catch((e) => {
          this.errors.push(e);
        });
    },
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
