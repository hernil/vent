# vent-frontend

> Visualized Education NTNU

Vent is a visualization tool for educational data. This is the frontend that handles actual visualization.
If you have an API endpoint serving [VSON](https://github.com/hernil/vson) data you can simply spin up the development environment and navigate your browser to [http://localhost:3000](http://localhost:3000)

## Build Setup

``` bash
# install dependencies
yarn install

# serve with hot reload at localhost:3000
yarn run dev

# build for production with minification
yarn run build

# build for production and view the bundle analyzer report
yarn run build --report
```

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).

The Vent frontend is a Vue.js app working with [Highcharts](http://highcharts.com) to create beautiful visualizations. Looking at the code it should be somewhat straight forward to understand its structure.
