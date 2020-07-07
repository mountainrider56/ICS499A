export default {
  mode: 'universal',
  /*
   ** Headers of the page
   */
  head: {
    title: process.env.npm_package_name || '',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      {
        hid: 'description',
        name: 'description',
        content: process.env.npm_package_description || ''
      }
    ],
    link: [{ rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }]
  },
  /*
   ** Customize the progress-bar color
   */
  loading: { color: '#fff' },
  /*
   ** Global CSS
   */
  css: [],
  /**
   ** Recognize components directory
   */
  components: true,
  /*
   ** Plugins to load before mounting the App
   */
  plugins: [
    { src: '@/plugins/customer-service.js' },
    { src: '@/plugins/employee-service.js' },
    { src: '@/plugins/route-utils.js' }
  ],
  /*
   ** Nuxt.js dev-modules
   */
  buildModules: [
    // Doc: https://github.com/nuxt-community/eslint-module
    '@nuxtjs/eslint-module',
    // Doc: https://github.com/nuxt-community/stylelint-module
    '@nuxtjs/stylelint-module',
    [
      '@nuxtjs/vuetify',
      {
        theme: {
          themes: {
            light: {
              primary: '#000',
              secondary: '#d31615',
              error: '#d1545c'
            }
          }
        }
      }
    ]
  ],
  /*
   ** Nuxt.js modules
   */
  modules: ['@nuxtjs/axios', '@nuxtjs/proxy'],
  axios: {
    proxy: true
  },
  env: {
    baseUrl: process.env.BASE_URL || 'http://localhost:3000'
  },
  proxy: {
    '/api/eagleeye-msp/v1/customers': {
      target: 'http://localhost:8080'
    },
    '/api/eagleeye-msp/v1/employees': {
      target: 'http://localhost:8081'
    },
    '/api/eagleeye-msp/v1/quotes': {
      target: 'http://localhost:8082'
    }
  },
  /*
   ** Build configuration
   */
  build: {
    /*
     ** You can extend webpack config here
     */
    extend(config, ctx) {}
  }
}
