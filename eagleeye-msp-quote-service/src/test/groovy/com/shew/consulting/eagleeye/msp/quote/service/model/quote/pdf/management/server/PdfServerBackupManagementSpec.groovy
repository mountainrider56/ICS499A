package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.server

import com.itextpdf.text.Document
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PdfServerBackupManagementSpec extends Specification {

    def 'build'() {
        setup:
        Quote quote = Mock()
        Document document = Mock()
        Map<String, Service> services = Mock()
        PdfTableBuilder builder = Mock()
        List<Double> totals = Mock()

        when:
        new PdfServerBackupManagement(quote, document, services, builder, totals)

        then:
        1 * builder.withQuote(quote) >> builder
        1 * builder.withServices(services) >> builder
        1 * builder.withDocument(document) >> builder
        1 * builder.withHeaders('Server') >> builder
        1 * builder.withRow('BackupManagementSERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementMonitoringSERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementEagleEYEOnsiteBackupSERVER') >> builder
        1 * builder.withSubRow('BackupManagementEagleEYEOnsiteBackupStandardRestoreSERVER') >> builder
        1 * builder.withSubRow('BackupManagementEagleEYEOnsiteBackupUniversalRestoreSERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementEagleEYECloudBackup15SERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementEagleEYECloudBackup30SERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementEagleEYECloudBackup50SERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementEagleEYECloudBackup75SERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementEagleEYECloudBackup100SERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementEagleEYECloudBackup150SERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementEagleEYECloudBackup200SERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementEagleEYECloudBackup250SERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementEagleEYECloudBackup500SERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementEagleEYECloudBackup1000SERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementEagleEYECloudBackup2000SERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementEagleEYECloudBackup3000SERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementEagleEYECloudBackupAddOnModulesSERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementEagleEYECloudBackupBrickLevelUsersSERVER') >> builder
        1 * builder.withSubRow('BackupManagementHardwareAssistedCloudBackupSERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementHardwareAssistedCloudBackup500SERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementHardwareAssistedCloudBackup1000SERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementHardwareAssistedCloudBackup2000SERVER') >> builder
        1 * builder.withQuantitySubRow('BackupManagementHardwareAssistedCloudBackup4000SERVER') >> builder
        1 * builder.build(totals) >> builder
        0 * _
    }

}
