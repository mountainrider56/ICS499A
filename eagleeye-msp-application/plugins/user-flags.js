export default (context, inject) => {
  const userFlags = {
    isAdmin() {
      const user = context.$auth.user
      return user.securityRole === 'ADMIN'
    }
  }
  inject('userFlags', userFlags)
  context.$userFlags = userFlags
}
