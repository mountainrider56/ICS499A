export default async (context) => {
  const session = {
    async isSessionActive() {
      return await context.$loginApi.pingSession()
    },
    async invalidateSession() {
      await context.$auth.logout()
    }
  }
  if (context.$auth && context.$auth.loggedIn) {
    const isActive = await session.isSessionActive()
    if (!isActive) {
      session.invalidateSession()
    }
  }
}
