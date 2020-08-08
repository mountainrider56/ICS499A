package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.server;

import com.itextpdf.text.Document;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import lombok.Getter;

import java.util.List;
import java.util.Map;

/**
 * Server Backup Management PDF table.
 */
@Getter
public class PdfServerBackupManagement {

    private final Quote quote;
    private final Document document;
    private final Map<String, Service> services;
    private final PdfTableBuilder builder;
    private final List<Double> totals;

    public PdfServerBackupManagement(Quote quote, Document document, Map<String, Service> services,
                                     PdfTableBuilder builder, List<Double> totals) throws Exception {
        this.quote = quote;
        this.document = document;
        this.services = services;
        this.builder = builder;
        this.totals = totals;
        init();
    }

    private void init() throws Exception {
        builder.withQuote(quote)
               .withServices(services)
               .withDocument(document)
               .withHeaders("Server")
               .withRow("BackupManagementSERVER")
               .withQuantitySubRow("BackupManagementMonitoringSERVER")
               .withQuantitySubRow("BackupManagementEagleEYEOnsiteBackupSERVER")
               .withSubRow("BackupManagementEagleEYEOnsiteBackupStandardRestoreSERVER")
               .withSubRow("BackupManagementEagleEYEOnsiteBackupUniversalRestoreSERVER")
               .withQuantitySubRow("BackupManagementEagleEYECloudBackup15SERVER")
               .withQuantitySubRow("BackupManagementEagleEYECloudBackup30SERVER")
               .withQuantitySubRow("BackupManagementEagleEYECloudBackup50SERVER")
               .withQuantitySubRow("BackupManagementEagleEYECloudBackup75SERVER")
               .withQuantitySubRow("BackupManagementEagleEYECloudBackup100SERVER")
               .withQuantitySubRow("BackupManagementEagleEYECloudBackup150SERVER")
               .withQuantitySubRow("BackupManagementEagleEYECloudBackup200SERVER")
               .withQuantitySubRow("BackupManagementEagleEYECloudBackup250SERVER")
               .withQuantitySubRow("BackupManagementEagleEYECloudBackup500SERVER")
               .withQuantitySubRow("BackupManagementEagleEYECloudBackup1000SERVER")
               .withQuantitySubRow("BackupManagementEagleEYECloudBackup2000SERVER")
               .withQuantitySubRow("BackupManagementEagleEYECloudBackup3000SERVER")
               .withQuantitySubRow("BackupManagementEagleEYECloudBackupAddOnModulesSERVER")
               .withQuantitySubRow("BackupManagementEagleEYECloudBackupBrickLevelUsersSERVER")
               .withSubRow("BackupManagementHardwareAssistedCloudBackupSERVER")
               .withQuantitySubRow("BackupManagementHardwareAssistedCloudBackup500SERVER")
               .withQuantitySubRow("BackupManagementHardwareAssistedCloudBackup1000SERVER")
               .withQuantitySubRow("BackupManagementHardwareAssistedCloudBackup2000SERVER")
               .withQuantitySubRow("BackupManagementHardwareAssistedCloudBackup4000SERVER")
               .build(totals);
    }

}
