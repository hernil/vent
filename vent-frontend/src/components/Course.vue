<template>
  <div>

    <button id="show-modal" @click="showModal = true">Load data</button>
    <!-- use the modal component, pass in the prop -->
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
      <div slot="footer"></div>

    </modal>

    <pre>{{ course.id }}</pre>
    <expected-v-s-actual :units=units></expected-v-s-actual>
    <h2>Content usage by type:</h2>
    <c-usage-type :units=units></c-usage-type>
    <h2>Content usage by topic:</h2>
    <c-usage-topic :units=units></c-usage-topic>
    <h2>Content completion by type:</h2>
    <c-completion-type :units=units></c-completion-type>
    <h2>Content completion by topic:</h2>
    <c-completion-topic :units=units></c-completion-topic>
    <h2>Content recommended-rate by type:</h2>
    <c-recommended-rate-type :units=units></c-recommended-rate-type>
    <h2>Content recommended-rate by topic:</h2>
    <c-recommended-rate-topic :units=units></c-recommended-rate-topic>
  </div>
</template>

<script>

  import axios from 'axios';
  import Modal from './tools/Modal';
  import ExpectedVSActual from './subviews/ExpectedVSActualPerformance';
  import ContentUsageByType from './subviews/ContentUsageByType';
  import ContentUsageByTopic from './subviews/ContentUsageByTopic';
  import ContentCompletionByType from './subviews/ContentCompletionByType';
  import ContentCompletionByTopic from './subviews/ContentCompletionByTopic';
  import ContentRecommendedRateByType from './subviews/ContentRecommendedRateByType';
  import ContentRecommendedRateByTopic from './subviews/ContentRecommendedRateByTopic';

  export default {
    components: {
      ExpectedVSActual,
      CUsageType: ContentUsageByType,
      CUsageTopic: ContentUsageByTopic,
      CCompletionType: ContentCompletionByType,
      CCompletionTopic: ContentCompletionByTopic,
      CRecommendedRateType: ContentRecommendedRateByType,
      CRecommendedRateTopic: ContentRecommendedRateByTopic,
      Modal,
    },
    data() {
      return {
        course: [],
        errors: [],
        showModal: true,
        url: 'http://localhost:8080/course/TDT4100',
      };
    },
    computed: {
      units() {
        return this.course.units;
      },
    },
    methods: {
      fetchData() {
        axios.get(this.url).then((response) => {
          this.course = response.data;
          this.showModal = !this.showModal;
        })
        .catch((e) => {
          this.errors.push(e);
        });
      },
    },
  };

</script>

<style scoped>
  pre {

  }
</style>
