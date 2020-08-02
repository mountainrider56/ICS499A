<template>
  <v-container>
    <v-form>
      <!-- Device Monitoring -->
      <QuoteInputRow
        ref="DeviceMonitoringPC"
        :selection="quote.selections.DeviceMonitoringPC"
        :service="services.DeviceMonitoringPC"
        :cost-type="content.workstation"
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
        ref="PatchManagementWindowsUpdatesPC"
        :is-sub-row="true"
        :selection="quote.selections.PatchManagementWindowsUpdatesPC"
        :service="services.PatchManagementWindowsUpdatesPC"
        :cost-type="content.workstation"
        @onQuantityUpdate="setPcTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="PatchManagementOfficeUpdatesPC"
        :is-sub-row="true"
        :selection="quote.selections.PatchManagementOfficeUpdatesPC"
        :service="services.PatchManagementOfficeUpdatesPC"
        :cost-type="content.workstation"
        @onQuantityUpdate="setPcTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="PatchManagementOtherUpdatesPC"
        :is-sub-row="true"
        :selection="quote.selections.PatchManagementOtherUpdatesPC"
        :service="services.PatchManagementOtherUpdatesPC"
        :cost-type="content.workstation"
        @onQuantityUpdate="setPcTotal"
      ></QuoteInputRow>

      <!-- Help Desk -->
      <QuoteInputRow
        ref="HelpDeskPC"
        :selection="quote.selections.HelpDeskPC"
        :service="services.HelpDeskPC"
        :cost-type="content.workstation"
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
        ref="PeriodicSystemOptimizationPC"
        :selection="quote.selections.PeriodicSystemOptimizationPC"
        :service="services.PeriodicSystemOptimizationPC"
        :cost-type="content.workstation"
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
        ref="BackupManagementMonitoringPC"
        :is-sub-row="true"
        :selection="quote.selections.BackupManagementMonitoringPC"
        :service="services.BackupManagementMonitoringPC"
        :cost-type="content.workstation"
        @onQuantityUpdate="setPcTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementIntegratedBackupPC"
        :is-sub-row="true"
        :selection="quote.selections.BackupManagementIntegratedBackupPC"
        :service="services.BackupManagementIntegratedBackupPC"
        :cost-type="content.workstation"
        @onQuantityUpdate="setPcTotal"
      ></QuoteInputRow>

      <!-- AntiVirus Detection -->
      <QuoteInputRow
        ref="AntivirusDetectionPC"
        :selection="quote.selections.AntivirusDetectionPC"
        :service="services.AntivirusDetectionPC"
        :cost-type="content.workstation"
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
        ref="AntiMalwareAntiSpywareDetectionPC"
        :selection="quote.selections.AntiMalwareAntiSpywareDetectionPC"
        :service="services.AntiMalwareAntiSpywareDetectionPC"
        :cost-type="content.workstation"
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
        ref="BasicSpamServiceDomainLevelFilteringPC"
        :is-sub-row="true"
        :selection="quote.selections.BasicSpamServiceDomainLevelFilteringPC"
        :service="services.BasicSpamServiceDomainLevelFilteringPC"
        :cost-type="content.workstation"
        @onQuantityUpdate="setPcTotal"
      ></QuoteInputRow>
      <QuoteRow
        :is-sub-row="true"
        :service="services.BasicSpamServiceDefinitionManagementPC"
      ></QuoteRow>

      <!-- PC Management Total -->
      <v-row align="center" class="mt-10">
        <v-col :offset="9">
          <strong>PC Total: ${{ pc.total.toFixed(2) }}</strong>
        </v-col>
      </v-row>

      <h2 class="mt-8 mb-6">Server Management</h2>

      <!-- Device Monitoring -->
      <QuoteInputRow
        ref="DeviceMonitoringSERVER"
        :selection="quote.selections.DeviceMonitoringSERVER"
        :service="services.DeviceMonitoringSERVER"
        :cost-type="content.server"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteRow
        :is-sub-row="true"
        :service="services.DeviceMonitoringPerformanceSERVER"
      ></QuoteRow>
      <QuoteRow
        :is-sub-row="true"
        :service="services.DeviceMonitoringSystemLogsSERVER"
      ></QuoteRow>
      <QuoteRow
        :is-sub-row="true"
        :service="services.DeviceMonitoringRemoteControlSERVER"
      ></QuoteRow>

      <!-- Patch Management -->
      <QuoteRow :service="services.PatchManagementSERVER"></QuoteRow>
      <QuoteInputRow
        ref="PatchManagementWindowsUpdatesSERVER"
        :is-sub-row="true"
        :selection="quote.selections.PatchManagementWindowsUpdatesSERVER"
        :service="services.PatchManagementWindowsUpdatesSERVER"
        :cost-type="content.server"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="PatchManagementOfficeUpdatesSERVER"
        :is-sub-row="true"
        :selection="quote.selections.PatchManagementOfficeUpdatesSERVER"
        :service="services.PatchManagementOfficeUpdatesSERVER"
        :cost-type="content.server"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="PatchManagementOtherUpdatesSERVER"
        :is-sub-row="true"
        :selection="quote.selections.PatchManagementOtherUpdatesSERVER"
        :service="services.PatchManagementOtherUpdatesSERVER"
        :cost-type="content.server"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>

      <!-- Help Desk -->
      <QuoteInputRow
        ref="HelpDeskSERVER"
        :selection="quote.selections.HelpDeskSERVER"
        :service="services.HelpDeskSERVER"
        :cost-type="content.server"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteRow
        :is-sub-row="true"
        :service="services.HelpDeskTelephoneSupportSERVER"
      ></QuoteRow>
      <QuoteRow
        :is-sub-row="true"
        :service="services.HelpDeskRemoteControlSERVER"
      ></QuoteRow>

      <!-- Periodic System Optimization -->
      <QuoteInputRow
        ref="PeriodicSystemOptimizationSERVER"
        :selection="quote.selections.PeriodicSystemOptimizationSERVER"
        :service="services.PeriodicSystemOptimizationSERVER"
        :cost-type="content.server"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteRow
        :is-sub-row="true"
        :service="services.PeriodicSystemOptimizationScanDiskSERVER"
      ></QuoteRow>
      <QuoteRow
        :is-sub-row="true"
        :service="services.PeriodicSystemOptimizationDefragSERVER"
      ></QuoteRow>
      <QuoteRow
        :is-sub-row="true"
        :service="services.PeriodicSystemOptimizationRemoveTemporaryFilesSERVER"
      ></QuoteRow>

      <!-- Backup Management -->
      <QuoteRow :service="services.BackupManagementSERVER"></QuoteRow>
      <QuoteInputRow
        ref="BackupManagementMonitoringSERVER"
        :is-sub-row="true"
        :selection="quote.selections.BackupManagementMonitoringSERVER"
        :service="services.BackupManagementMonitoringSERVER"
        :cost-type="content.server"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementEagleEYEOnsiteBackupSERVER"
        :is-sub-row="true"
        :selection="quote.selections.BackupManagementEagleEYEOnsiteBackupSERVER"
        :service="services.BackupManagementEagleEYEOnsiteBackupSERVER"
        :cost-type="content.server"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteRow
        :is-list-row="true"
        :service="
          services.BackupManagementEagleEYEOnsiteBackupStandardRestoreSERVER
        "
      ></QuoteRow>
      <QuoteRow
        :is-list-row="true"
        :service="
          services.BackupManagementEagleEYEOnsiteBackupUniversalRestoreSERVER
        "
      ></QuoteRow>
      <QuoteInputRow
        ref="BackupManagementEagleEYECloudBackup15SERVER"
        :is-sub-row="true"
        :selection="
          quote.selections.BackupManagementEagleEYECloudBackup15SERVER
        "
        :service="services.BackupManagementEagleEYECloudBackup15SERVER"
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementEagleEYECloudBackup30SERVER"
        :is-sub-row="true"
        :selection="
          quote.selections.BackupManagementEagleEYECloudBackup30SERVER
        "
        :service="services.BackupManagementEagleEYECloudBackup30SERVER"
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementEagleEYECloudBackup50SERVER"
        :is-sub-row="true"
        :selection="
          quote.selections.BackupManagementEagleEYECloudBackup50SERVER
        "
        :service="services.BackupManagementEagleEYECloudBackup50SERVER"
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementEagleEYECloudBackup75SERVER"
        :is-sub-row="true"
        :selection="
          quote.selections.BackupManagementEagleEYECloudBackup75SERVER
        "
        :service="services.BackupManagementEagleEYECloudBackup75SERVER"
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementEagleEYECloudBackup100SERVER"
        :is-sub-row="true"
        :selection="
          quote.selections.BackupManagementEagleEYECloudBackup100SERVER
        "
        :service="services.BackupManagementEagleEYECloudBackup100SERVER"
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementEagleEYECloudBackup150SERVER"
        :is-sub-row="true"
        :selection="
          quote.selections.BackupManagementEagleEYECloudBackup150SERVER
        "
        :service="services.BackupManagementEagleEYECloudBackup150SERVER"
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementEagleEYECloudBackup200SERVER"
        :is-sub-row="true"
        :selection="
          quote.selections.BackupManagementEagleEYECloudBackup200SERVER
        "
        :service="services.BackupManagementEagleEYECloudBackup200SERVER"
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementEagleEYECloudBackup250SERVER"
        :is-sub-row="true"
        :selection="
          quote.selections.BackupManagementEagleEYECloudBackup250SERVER
        "
        :service="services.BackupManagementEagleEYECloudBackup250SERVER"
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementEagleEYECloudBackup500SERVER"
        :is-sub-row="true"
        :selection="
          quote.selections.BackupManagementEagleEYECloudBackup500SERVER
        "
        :service="services.BackupManagementEagleEYECloudBackup500SERVER"
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementEagleEYECloudBackup1000SERVER"
        :is-sub-row="true"
        :selection="
          quote.selections.BackupManagementEagleEYECloudBackup1000SERVER
        "
        :service="services.BackupManagementEagleEYECloudBackup1000SERVER"
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementEagleEYECloudBackup2000SERVER"
        :is-sub-row="true"
        :selection="
          quote.selections.BackupManagementEagleEYECloudBackup2000SERVER
        "
        :service="services.BackupManagementEagleEYECloudBackup2000SERVER"
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementEagleEYECloudBackup3000SERVER"
        :is-sub-row="true"
        :selection="
          quote.selections.BackupManagementEagleEYECloudBackup3000SERVER
        "
        :service="services.BackupManagementEagleEYECloudBackup3000SERVER"
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementEagleEYECloudBackupAddOnModulesSERVER"
        :is-list-row="true"
        :selection="
          quote.selections.BackupManagementEagleEYECloudBackupAddOnModulesSERVER
        "
        :service="
          services.BackupManagementEagleEYECloudBackupAddOnModulesSERVER
        "
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementEagleEYECloudBackupBrickLevelUsersSERVER"
        :is-list-row="true"
        :selection="
          quote.selections
            .BackupManagementEagleEYECloudBackupBrickLevelUsersSERVER
        "
        :service="
          services.BackupManagementEagleEYECloudBackupBrickLevelUsersSERVER
        "
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteRow
        :is-sub-row="true"
        :service="services.BackupManagementHardwareAssistedCloudBackupSERVER"
      ></QuoteRow>
      <QuoteInputRow
        ref="BackupManagementHardwareAssistedCloudBackup500SERVER"
        :is-list-row="true"
        :selection="
          quote.selections.BackupManagementHardwareAssistedCloudBackup500SERVER
        "
        :service="services.BackupManagementHardwareAssistedCloudBackup500SERVER"
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementHardwareAssistedCloudBackup1000SERVER"
        :is-list-row="true"
        :selection="
          quote.selections.BackupManagementHardwareAssistedCloudBackup1000SERVER
        "
        :service="
          services.BackupManagementHardwareAssistedCloudBackup1000SERVER
        "
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementHardwareAssistedCloudBackup2000SERVER"
        :is-list-row="true"
        :selection="
          quote.selections.BackupManagementHardwareAssistedCloudBackup2000SERVER
        "
        :service="
          services.BackupManagementHardwareAssistedCloudBackup2000SERVER
        "
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="BackupManagementHardwareAssistedCloudBackup4000SERVER"
        :is-list-row="true"
        :selection="
          quote.selections.BackupManagementHardwareAssistedCloudBackup4000SERVER
        "
        :service="
          services.BackupManagementHardwareAssistedCloudBackup4000SERVER
        "
        :cost-type="content.month"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>

      <!-- AntiVirus/Antispyware Detection -->
      <QuoteInputRow
        ref="AntiVirusAntiSpywareDetectionSERVER"
        :selection="quote.selections.AntiVirusAntiSpywareDetectionSERVER"
        :service="services.AntiVirusAntiSpywareDetectionSERVER"
        :cost-type="content.server"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>
      <QuoteRow
        :is-sub-row="true"
        :service="
          services.AntiVirusAntiSpywareDetectionProvideTrendMicroWFBSSLicenseSERVER
        "
      ></QuoteRow>
      <QuoteRow
        :is-sub-row="true"
        :service="
          services.AntiVirusAntiSpywareDetectionDefinitionManagementSERVER
        "
      ></QuoteRow>
      <QuoteRow
        :is-sub-row="true"
        :service="
          services.AntiVirusAntiSpywareDetectionApplicationUpdatesSERVER
        "
      ></QuoteRow>
      <QuoteRow
        :is-sub-row="true"
        :service="services.AntiVirusAntiSpywareDetectionScheduledScanningSERVER"
      ></QuoteRow>
      <QuoteRow
        :is-sub-row="true"
        :service="services.AntiVirusAntiSpywareDetectionHistoricReportsSERVER"
      ></QuoteRow>

      <!-- Advanced Spam Service -->
      <QuoteRow :service="services.AdvancedSpamServiceSERVER"></QuoteRow>
      <QuoteInputRow
        ref="AdvancedSpamServiceUserLevelFilteringSERVER"
        :is-sub-row="true"
        :selection="
          quote.selections.AdvancedSpamServiceUserLevelFilteringSERVER
        "
        :service="services.AdvancedSpamServiceUserLevelFilteringSERVER"
        :cost-type="content.server"
        @onQuantityUpdate="setServerTotal"
      ></QuoteInputRow>

      <!-- Server Management Total -->
      <v-row align="center" class="mt-10">
        <v-col :offset="9">
          <strong>Server Total: ${{ server.total.toFixed(2) }}</strong>
        </v-col>
      </v-row>

      <h2 class="mt-8 mb-6">Additional Services</h2>

      <!-- Darkweb Monitoring -->
      <QuoteRow :service="services.DarkwebMonitoringADDITIONAL"></QuoteRow>
      <QuoteInputRow
        ref="DarkwebMonitoringDomainsADDITIONAL"
        :is-sub-row="true"
        :selection="quote.selections.DarkwebMonitoringDomainsADDITIONAL"
        :service="services.DarkwebMonitoringDomainsADDITIONAL"
        :cost-type="content.domains"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="DarkwebMonitoringPersonalEmailAddressesADDITIONAL"
        :is-sub-row="true"
        :selection="
          quote.selections.DarkwebMonitoringPersonalEmailAddressesADDITIONAL
        "
        :service="services.DarkwebMonitoringPersonalEmailAddressesADDITIONAL"
        cost-type="10 Email Addresses"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>

      <!-- Reporting -->
      <QuoteRow :service="services.ReportingADDITIONAL"></QuoteRow>
      <QuoteInputRow
        ref="ReportingMonthlyADDITIONAL"
        :is-sub-row="true"
        :selection="quote.selections.ReportingMonthlyADDITIONAL"
        :service="services.ReportingMonthlyADDITIONAL"
        cost-type="?"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="ReportingQuarterlyADDITIONAL"
        :is-sub-row="true"
        :selection="quote.selections.ReportingQuarterlyADDITIONAL"
        :service="services.ReportingQuarterlyADDITIONAL"
        cost-type="?"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="ReportingAnnuallyADDITIONAL"
        :is-sub-row="true"
        :selection="quote.selections.ReportingAnnuallyADDITIONAL"
        :service="services.ReportingAnnuallyADDITIONAL"
        cost-type="?"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>

      <!-- UPS Testing -->
      <QuoteRow :service="services.UPSTestingADDITIONAL"></QuoteRow>
      <QuoteInputRow
        ref="UPSTestingMonthlyADDITIONAL"
        :is-sub-row="true"
        :selection="quote.selections.UPSTestingMonthlyADDITIONAL"
        :service="services.UPSTestingMonthlyADDITIONAL"
        cost-type="?"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="UPSTestingQuarterlyADDITIONAL"
        :is-sub-row="true"
        :selection="quote.selections.UPSTestingQuarterlyADDITIONAL"
        :service="services.UPSTestingQuarterlyADDITIONAL"
        cost-type="?"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="UPSTestingAnnuallyADDITIONAL"
        :is-sub-row="true"
        :selection="quote.selections.UPSTestingAnnuallyADDITIONAL"
        :service="services.UPSTestingAnnuallyADDITIONAL"
        cost-type="?"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>

      <!-- Network Device -->
      <QuoteRow :service="services.NetworkDeviceADDITIONAL"></QuoteRow>
      <QuoteInputRow
        ref="NetworkDeviceSNMPDevicesADDITIONAL"
        :is-sub-row="true"
        :selection="quote.selections.NetworkDeviceSNMPDevicesADDITIONAL"
        :service="services.NetworkDeviceSNMPDevicesADDITIONAL"
        :cost-type="content.device"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="NetworkDeviceEdgeDevicesADDITIONAL"
        :is-sub-row="true"
        :selection="quote.selections.NetworkDeviceEdgeDevicesADDITIONAL"
        :service="services.NetworkDeviceEdgeDevicesADDITIONAL"
        :cost-type="content.device"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>

      <!-- Asset/Warranty Management -->
      <QuoteRow
        :service="services.AssetWarrantyManagementADDITIONAL"
      ></QuoteRow>
      <QuoteInputRow
        ref="AssetWarrantyManagementHardwareInventoryADDITIONAL"
        :is-sub-row="true"
        :selection="
          quote.selections.AssetWarrantyManagementHardwareInventoryADDITIONAL
        "
        :service="services.AssetWarrantyManagementHardwareInventoryADDITIONAL"
        :cost-type="content.device"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="AssetWarrantyManagementWarrantyExpirationADDITIONAL"
        :is-sub-row="true"
        :selection="
          quote.selections.AssetWarrantyManagementWarrantyExpirationADDITIONAL
        "
        :service="services.AssetWarrantyManagementWarrantyExpirationADDITIONAL"
        :cost-type="content.device"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>

      <!-- Periodic Planning and Review -->
      <QuoteRow :service="services.PeriodicPlanningReviewADDITIONAL"></QuoteRow>
      <QuoteRow
        :is-sub-row="true"
        :service="services.PeriodicPlanningReviewDescriptionADDITIONAL"
      ></QuoteRow>
      <QuoteInputRow
        ref="PeriodicPlanningReviewMonthlyADDITIONAL"
        :is-sub-row="true"
        :selection="quote.selections.PeriodicPlanningReviewMonthlyADDITIONAL"
        :service="services.PeriodicPlanningReviewMonthlyADDITIONAL"
        cost-type="?"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="PeriodicPlanningReviewQuarterlyADDITIONAL"
        :is-sub-row="true"
        :selection="quote.selections.PeriodicPlanningReviewQuarterlyADDITIONAL"
        :service="services.PeriodicPlanningReviewQuarterlyADDITIONAL"
        cost-type="?"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="PeriodicPlanningReviewAnnuallyADDITIONAL"
        :is-sub-row="true"
        :selection="quote.selections.PeriodicPlanningReviewAnnuallyADDITIONAL"
        :service="services.PeriodicPlanningReviewAnnuallyADDITIONAL"
        cost-type="?"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>

      <!-- Hourly Rates -->
      <QuoteRow :service="services.HourlyRatesADDITIONAL"></QuoteRow>
      <QuoteInputRow
        ref="HourlyRatesOnSiteADDITIONAL"
        :is-sub-row="true"
        :selection="quote.selections.HourlyRatesOnSiteADDITIONAL"
        :service="services.HourlyRatesOnSiteADDITIONAL"
        cost-type="?"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="HourlyRatesRemoteSupportADDITIONAL"
        :is-sub-row="true"
        :selection="quote.selections.HourlyRatesRemoteSupportADDITIONAL"
        :service="services.HourlyRatesRemoteSupportADDITIONAL"
        cost-type="?"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>
      <QuoteInputRow
        ref="HourlyRatesEmergencyResponseADDITIONAL"
        :is-sub-row="true"
        :selection="quote.selections.HourlyRatesEmergencyResponseADDITIONAL"
        :service="services.HourlyRatesEmergencyResponseADDITIONAL"
        cost-type="?"
        @onQuantityUpdate="setAdditionalTotal"
      ></QuoteInputRow>

      <!-- Additional Management Total -->
      <v-row align="center" class="mt-10">
        <v-col :offset="9">
          <strong>Additional Total: ${{ additional.total.toFixed(2) }}</strong>
        </v-col>
      </v-row>

      <!-- Total -->
      <v-row align="center" class="mt-10">
        <v-col :offset="9">
          <strong>Total: ${{ total.toFixed(2) }}</strong>
        </v-col>
      </v-row>

      <slot />
    </v-form>
  </v-container>
</template>

<script>
export default {
  props: {
    quote: {
      type: Object,
      required: true
    },
    services: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      content: {
        workstation: 'Workstation',
        server: 'Server',
        month: 'Month',
        domains: 'Domains',
        device: 'Device'
      },
      total: 0,
      pc: {
        total: 0,
        services: [
          'DeviceMonitoringPC',
          'PatchManagementWindowsUpdatesPC',
          'PatchManagementOfficeUpdatesPC',
          'PatchManagementOtherUpdatesPC',
          'HelpDeskPC',
          'PeriodicSystemOptimizationPC',
          'BackupManagementMonitoringPC',
          'BackupManagementIntegratedBackupPC',
          'AntivirusDetectionPC',
          'AntiMalwareAntiSpywareDetectionPC',
          'BasicSpamServiceDomainLevelFilteringPC'
        ]
      },
      server: {
        total: 0,
        services: [
          'DeviceMonitoringSERVER',
          'PatchManagementWindowsUpdatesSERVER',
          'PatchManagementOfficeUpdatesSERVER',
          'PatchManagementOtherUpdatesSERVER',
          'HelpDeskSERVER',
          'PeriodicSystemOptimizationSERVER',
          'BackupManagementMonitoringSERVER',
          'BackupManagementEagleEYEOnsiteBackupSERVER',
          'BackupManagementEagleEYECloudBackup15SERVER',
          'BackupManagementEagleEYECloudBackup30SERVER',
          'BackupManagementEagleEYECloudBackup50SERVER',
          'BackupManagementEagleEYECloudBackup75SERVER',
          'BackupManagementEagleEYECloudBackup100SERVER',
          'BackupManagementEagleEYECloudBackup150SERVER',
          'BackupManagementEagleEYECloudBackup200SERVER',
          'BackupManagementEagleEYECloudBackup250SERVER',
          'BackupManagementEagleEYECloudBackup500SERVER',
          'BackupManagementEagleEYECloudBackup1000SERVER',
          'BackupManagementEagleEYECloudBackup2000SERVER',
          'BackupManagementEagleEYECloudBackup3000SERVER',
          'BackupManagementEagleEYECloudBackupAddOnModulesSERVER',
          'BackupManagementEagleEYECloudBackupBrickLevelUsersSERVER',
          'BackupManagementHardwareAssistedCloudBackup500SERVER',
          'BackupManagementHardwareAssistedCloudBackup1000SERVER',
          'BackupManagementHardwareAssistedCloudBackup2000SERVER',
          'BackupManagementHardwareAssistedCloudBackup4000SERVER',
          'AntiVirusAntiSpywareDetectionSERVER',
          'AdvancedSpamServiceUserLevelFilteringSERVER'
        ]
      },
      additional: {
        total: 0,
        services: [
          'DarkwebMonitoringDomainsADDITIONAL',
          'DarkwebMonitoringPersonalEmailAddressesADDITIONAL',
          'ReportingMonthlyADDITIONAL',
          'ReportingQuarterlyADDITIONAL',
          'ReportingAnnuallyADDITIONAL',
          'UPSTestingMonthlyADDITIONAL',
          'UPSTestingQuarterlyADDITIONAL',
          'UPSTestingAnnuallyADDITIONAL',
          'NetworkDeviceSNMPDevicesADDITIONAL',
          'NetworkDeviceEdgeDevicesADDITIONAL',
          'AssetWarrantyManagementHardwareInventoryADDITIONAL',
          'AssetWarrantyManagementWarrantyExpirationADDITIONAL',
          'PeriodicPlanningReviewMonthlyADDITIONAL',
          'PeriodicPlanningReviewQuarterlyADDITIONAL',
          'PeriodicPlanningReviewAnnuallyADDITIONAL',
          'HourlyRatesOnSiteADDITIONAL',
          'HourlyRatesRemoteSupportADDITIONAL',
          'HourlyRatesEmergencyResponseADDITIONAL'
        ]
      }
    }
  },
  created() {
    const $this = this
    this.pc.total = this.getTotals(0, this.pc.services, (element) => {
      return (
        $this.services[element].price * $this.quote.selections[element].quantity
      )
    })
    this.server.total = this.getTotals(0, this.server.services, (element) => {
      return (
        $this.services[element].price * $this.quote.selections[element].quantity
      )
    })
    this.additional.total = this.getTotals(
      0,
      this.additional.services,
      (element) => {
        return (
          $this.services[element].price *
          $this.quote.selections[element].quantity
        )
      }
    )
    this.setTotal()
  },
  methods: {
    async submit() {
      return await this.$quoteApi.saveQuote(this.quote)
    },
    async setPcTotal() {
      const refs = await this.$refs
      this.pc.total = this.getTotals(0, this.pc.services, (element) => {
        return refs[element].subTotal
      })
      this.setTotal()
    },
    async setServerTotal() {
      const refs = await this.$refs
      this.server.total = this.getTotals(0, this.server.services, (element) => {
        return refs[element].subTotal
      })
      this.setTotal()
    },
    async setAdditionalTotal() {
      const refs = await this.$refs
      this.additional.total = this.getTotals(
        0,
        this.additional.services,
        (element) => {
          return refs[element].subTotal
        }
      )
      this.setTotal()
    },
    setTotal() {
      this.total = this.getTotals(
        0,
        [this.pc, this.server, this.additional],
        (element) => {
          return element.total
        }
      )
    },
    getTotals(total, services, func) {
      services.forEach((element) => {
        total += func(element)
      })
      return total
    }
  }
}
</script>
