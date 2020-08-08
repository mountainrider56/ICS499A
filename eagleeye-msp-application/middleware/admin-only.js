export default (context) => {
  if (!context.$userFlags.isAdmin()) {
    context.error({
      statusCode: 401,
      message: 'You are not authorized for this page.'
    })
  }
}
