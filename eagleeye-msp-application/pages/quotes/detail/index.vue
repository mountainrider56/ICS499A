<template>
  <v-container>
    <h1>{{ title }}</h1>
    <h2 class="mt-8">PC Management</h2>

    <!-- Device Monitoring -->
    <QuoteInputRow
      ref="deviceMonitoringPC"
      :selection="quote.selections.DeviceMonitoringPC"
      :service="services.DeviceMonitoringPC"
      @onQuantityUpdate="setPcTotal"
    ></QuoteInputRow>
    <QuoteRow
      :is-sub-row="true"
      :service="services.DeviceMonitoringPerformancePC"
    ></QuoteRow>
    <QuoteRow
      :is-sub-row="true"
      :service="services.DeviceMonitoringSystemLogsPC"
    ></QuoteRow>
    <QuoteRow
      :is-sub-row="true"
      :service="services.DeviceMonitoringRemoteControlPC"
    ></QuoteRow>

    <!-- Patch Management -->
    <QuoteRow :service="services.PatchManagementPC"></QuoteRow>
    <QuoteInputRow
      ref="patchManagementWindowsUpdatesPC"
      :is-sub-row="true"
      :selection="quote.selections.PatchManagementWindowsUpdatesPC"
      :service="services.PatchManagementWindowsUpdatesPC"
      @onQuantityUpdate="setPcTotal"
    ></QuoteInputRow>
    <QuoteInputRow
      ref="patchManagementOfficeUpdatesPC"
      :is-sub-row="true"
      :selection="quote.selections.PatchManagementOfficeUpdatesPC"
      :service="services.PatchManagementOfficeUpdatesPC"
      @onQuantityUpdate="setPcTotal"
    ></QuoteInputRow>
    <QuoteInputRow
      ref="patchManagementOtherUpdatesPC"
      :is-sub-row="true"
      :selection="quote.selections.PatchManagementOtherUpdatesPC"
      :service="services.PatchManagementOtherUpdatesPC"
      @onQuantityUpdate="setPcTotal"
    ></QuoteInputRow>

    <!-- Help Desk -->
    <QuoteInputRow
      ref="helpDeskPC"
      :selection="quote.selections.HelpDeskPC"
      :service="services.HelpDeskPC"
      @onQuantityUpdate="setPcTotal"
    ></QuoteInputRow>
    <QuoteRow
      :is-sub-row="true"
      :service="services.HelpDeskTelephoneSupportPC"
    ></QuoteRow>
    <QuoteRow
      :is-sub-row="true"
      :service="services.HelpDeskRemoteControlPC"
    ></QuoteRow>

    <!-- Periodic System Optimization -->
    <QuoteInputRow
      ref="periodicSystemOptimizationPC"
      :selection="quote.selections.PeriodicSystemOptimizationPC"
      :service="services.PeriodicSystemOptimizationPC"
      @onQuantityUpdate="setPcTotal"
    ></QuoteInputRow>
    <QuoteRow
      :is-sub-row="true"
      :service="services.PeriodicSystemOptimizationDefragPC"
    ></QuoteRow>
    <QuoteRow
      :is-sub-row="true"
      :service="services.PeriodicSystemOptimizationRemoveTemporaryFilesPC"
    ></QuoteRow>

    <!-- Backup Management -->
    <QuoteRow :service="services.BackupManagementPC"></QuoteRow>
    <QuoteInputRow
      ref="backupManagementMonitoringPC"
      :is-sub-row="true"
      :selection="quote.selections.BackupManagementMonitoringPC"
      :service="services.BackupManagementMonitoringPC"
      @onQuantityUpdate="setPcTotal"
    ></QuoteInputRow>
    <QuoteInputRow
      ref="backupManagementIntegratedBackupPC"
      :is-sub-row="true"
      :selection="quote.selections.BackupManagementIntegratedBackupPC"
      :service="services.BackupManagementIntegratedBackupPC"
      @onQuantityUpdate="setPcTotal"
    ></QuoteInputRow>

    <!-- AntiVirus Detection -->
    <QuoteInputRow
      ref="antivirusDetectionPC"
      :selection="quote.selections.AntivirusDetectionPC"
      :service="services.AntivirusDetectionPC"
      @onQuantityUpdate="setPcTotal"
    ></QuoteInputRow>
    <QuoteRow
      :is-sub-row="true"
      :service="services.AntivirusDetectionProvideTrendMicroWFBSSLicensePC"
    ></QuoteRow>
    <QuoteRow
      :is-sub-row="true"
      :service="services.AntivirusDetectionDefinitionManagementPC"
    ></QuoteRow>
    <QuoteRow
      :is-sub-row="true"
      :service="services.AntivirusDetectionScheduledScanningPC"
    ></QuoteRow>
    <QuoteRow
      :is-sub-row="true"
      :service="services.AntivirusDetectionHistoricReportsPC"
    ></QuoteRow>

    <!-- AntiMalware/Antispyware Detection -->
    <QuoteInputRow
      ref="antiMalwareAntiSpywareDetectionPC"
      :selection="quote.selections.AntiMalwareAntiSpywareDetectionPC"
      :service="services.AntiMalwareAntiSpywareDetectionPC"
      @onQuantityUpdate="setPcTotal"
    ></QuoteInputRow>
    <QuoteRow
      :is-sub-row="true"
      :service="
        services.AntiMalwareAntiSpywareDetectionProvideMalwareBytesLicensePC
      "
    ></QuoteRow>
    <QuoteRow
      :is-sub-row="true"
      :service="services.AntiMalwareAntiSpywareDetectionScheduledScanningPC"
    ></QuoteRow>

    <!-- Basic Spam Service -->
    <QuoteRow :service="services.BasicSpamServicePC"></QuoteRow>
    <QuoteInputRow
      ref="basicSpamServiceDomainLevelFilteringPC"
      :is-sub-row="true"
      :selection="quote.selections.BasicSpamServiceDomainLevelFilteringPC"
      :service="services.BasicSpamServiceDomainLevelFilteringPC"
      @onQuantityUpdate="setPcTotal"
    ></QuoteInputRow>
    <QuoteRow
      :is-sub-row="true"
      :service="services.BasicSpamServiceDefinitionManagementPC"
    ></QuoteRow>

    <!-- PC Management Total -->
    <v-row align="center" class="mt-10">
      <v-col :offset="7">
        <strong>PC Total: ${{ pc.total.toFixed(2) }}</strong>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  async asyncData({ $quoteApi, $customerApi, route }) {
    const services = await $quoteApi.getServices()
    const quote = await $quoteApi.getQuote(route.query.id)
    const customer = await $customerApi.getCustomer(route.query.id)
    return {
      quote,
      customer,
      services
    }
  },
  data() {
    return {
      title: 'Quote',
      pc: {
        total: 0,
        services: [
          'deviceMonitoringPC',
          'patchManagementWindowsUpdatesPC',
          'patchManagementOfficeUpdatesPC',
          'patchManagementOtherUpdatesPC',
          'helpDeskPC',
          'periodicSystemOptimizationPC',
          'backupManagementMonitoringPC',
          'backupManagementIntegratedBackupPC',
          'antivirusDetectionPC',
          'antiMalwareAntiSpywareDetectionPC',
          'basicSpamServiceDomainLevelFilteringPC'
        ]
      },
      server: {
        total: 0,
        services: []
      }
    }
  },
  computed: {
    total() {
      return this.pc.total + this.server.total
    }
  },
  beforeMount() {
    this.setPcTotal()
  },
  methods: {
    async setPcTotal() {
      let total = 0
      const refs = await this.$refs
      this.pc.services.forEach((element) => {
        total += refs[element].subTotal
      })
      this.pc.total = total
    },
    getPDF() {
      return this.$quoteApi.getQuotePDF('1')
    }
  },
  head() {
    return {
      title: this.title
    }
  }
}
</script>
