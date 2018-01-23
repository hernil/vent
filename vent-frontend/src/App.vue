<template>
  <div id="app">
    <div class="pure-g">
      <div class="pure-u-lg-4-24 pure-u-xl-3-24">
        <div class="pure-menu custom-restricted-width">
          <span class="pure-menu-heading">Dashboard views</span>

          <ul class="pure-menu-list">
            <li class="pure-menu-item"><router-link class="pure-menu-link" :to="{ name: 'root'}">Default</router-link></li>
            <li class="pure-menu-item"><router-link class="pure-menu-link" :to="{ name: 'TestView'}">TestView1</router-link></li>
            <li class="pure-menu-item"><router-link class="pure-menu-link" :to="{ name: 'LineChartView'}">LineChartView</router-link></li>
            <li class="pure-menu-heading">More Sites</li>
            <li class="pure-menu-item"><a href="http://protus.idi.ntnu.no" target="_blank" class="pure-menu-link">Protus</a></li>
          </ul>
        </div>
      </div>
      <div class="pure-u-lg-20-24 pure-u-xl-21-24">
        <router-view/>
      </div>
    </div>


    <!--<img src="./assets/logo.png">-->
  </div>
</template>

<script>
export default {
  name: 'app',
};
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.custom-restricted-width {
  /* To limit the menu width to the content of the menu: */
  display: inline-block;
  text-align: left;
  /* Or set the width explicitly: */
  /* width: 10em; */
}
</style>
