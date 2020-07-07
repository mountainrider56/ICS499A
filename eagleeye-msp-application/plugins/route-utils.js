export default (context, inject) => {
  const routeUtils = {
    removeQueryParam($this, param) {
      const query = Object.assign({}, $this.$route.query)
      delete query[param]
      $this.$router.replace({ query }).catch(() => {})
    }
  }
  inject('routeUtils', routeUtils)
  context.$routeUtils = routeUtils
}
