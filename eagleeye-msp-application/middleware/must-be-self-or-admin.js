export default (context) => {
  const user = context.$auth.user
  const route = context.route
  const isSelf = user.id.toString() === route.query.id.toString()
  if (!context.$userFlags.isAdmin() && !isSelf) {
    context.error({
      statusCode: 401,
      message: 'You are not authorized for this page.'
    })
  }
}
