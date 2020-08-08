export default (context) => {
  const user = context.$auth.user
  const route = context.route
  if (!context.$userFlags.isAdmin() && user.id.toString() !== route.query.id) {
    context.error({
      statusCode: 401,
      message: 'You are not authorized for this page.'
    })
  }
}
