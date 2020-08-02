package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.server;

import com.itextpdf.text.Document;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;

import java.util.Map;

public class PdfServerBackupManagement {

    private final Quote quote;
    private final Document document;
    private final Map<String, Service> services;
    private final PdfTableBuilder builder;

    public PdfServerBackupManagement(Quote quote, Document document, Map<String, Service> services) throws Exception {
        this.quote = quote;
        this.document = document;
        this.services = services;
        this.builder = new PdfTableBuilder(5);
        init();
    }

    private void init() throws Exception {
        builder.withQuote(quote)
               .withServices(services)
               .withDocument(document)
               .withHeaders("Workstation")
               .withRow("BackupManagementSERVER")
               .withQuantitySubRow("BackupManagementMonitoringSERVER")
               .withQuantitySubRow("BackupManagementEagleEYEOnsiteBackupSERVER")
               .withSubRow("BackupManagementEagleEYEOnsiteBackupStandardRestoreSERVER") //FIXME
               .withSubRow("BackupManagementEagleEYEOnsiteBackupUniversalRestoreSERVER") //FIXME
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
               .withSubRow("BackupManagementHardwareAssistedCloudBackupSERVER") //FIXME
               .withQuantitySubRow("BackupManagementHardwareAssistedCloudBackup500SERVER")
               .withQuantitySubRow("BackupManagementHardwareAssistedCloudBackup1000SERVER")
               .withQuantitySubRow("BackupManagementHardwareAssistedCloudBackup2000SERVER")
               .withQuantitySubRow("BackupManagementHardwareAssistedCloudBackup4000SERVER")
               .build();
    }

}
