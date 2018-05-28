<template>
  <div id="app">
    <div class="pure-g">
      <div class="pure-u-lg-4-24 pure-u-xl-3-24">
        <div class="pure-menu custom-restricted-width">
          <span class="pure-menu-heading">Dashboard views</span>

          <ul class="pure-menu-list">
            <li class="pure-menu-item"><router-link class="pure-menu-link" :to="{ name: 'root'}">Default</router-link></li>
            <li class="pure-menu-item"><router-link class="pure-menu-link" :to="{ name: 'TopicView'}">TopicView</router-link></li>
            <li class="pure-menu-item"><router-link class="pure-menu-link" :to="{ name: 'TypeView'}">TypeView</router-link></li>
            <li class="pure-menu-item"><router-link class="pure-menu-link" :to="{ name: 'TestView'}">TestView1</router-link></li>
            <li class="pure-menu-heading">Related Sites</li>
            <li class="pure-menu-item"><a href="http://protus.idi.ntnu.no" target="_blank" class="pure-menu-link">Protus</a></li>
          </ul>
        </div>
      </div>
      <div class="pure-u-lg-20-24 pure-u-xl-21-24">
        <button id="show-modal" @click="showModal = true">Load data</button>
        <modal :show.sync="showModal">
          <h3 slot="header">Load VSON data</h3>
          <div slot="body">
            <p>
              Example urls:
            </p>
            <ul>
              <li>http://localhost:8080/course/TDT4100</li>
            </ul>
            <input :value="url" @input="url = $event.target.value" style="width: 400px;"/>
            <button class="modal-default-button"
                    @click="fetchData()">
              Load
            </button>
          </div>
          <div slot="footer">
            <button class="" @click="showModal = false">Close</button>
          </div>

        </modal>
        <div v-if="this.store.course != null">
          <router-view/>
        </div>
        <div v-else>
          <p>Please load data </p>
        </div>
      </div>
    </div>


    <!--<img src="./assets/logo.png">-->
  </div>
</template>

<script>
  import axios from 'axios';
  import { store } from './main';

  import Modal from './components/tools/Modal';

  export default {
    name: 'app',
    components: {
      Modal,
    },
    data() {
      return {
        errors: [],
        showModal: true,
        url: store.defaults.defaultVSONUrl,
        store,
      };
    },
    computed: {
      units() {
        return this.store.course.units;
      },
    },
    methods: {
      fetchData() {
        // Ugly hack because soludGauge will not update on value change
        this.store.course = null;
        axios.get(this.url).then((response) => {
          this.store.course = response.data;
          this.showModal = !this.showModal;
        })
          .catch((e) => {
            this.errors.push(e);
          });
      },
    },
  };
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
.custom-restricted-width {
  /* To limit the menu width to the course of the menu: */
  display: inline-block;
  text-align: left;
  /* Or set the width explicitly: */
  /* width: 10em; */
}
</style>
