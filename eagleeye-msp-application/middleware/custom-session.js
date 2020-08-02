export default async (context) => {
  const session = {
    async isSessionActive() {
      return await context.$loginApi.pingSession()
    },
    async invalidateSession() {
      await context.$auth.logout()
    }
  }
  const isActive = await session.isSessionActive()
  if (context.$auth && context.$auth.loggedIn && !isActive) {
    session.invalidateSession()
  }
}
