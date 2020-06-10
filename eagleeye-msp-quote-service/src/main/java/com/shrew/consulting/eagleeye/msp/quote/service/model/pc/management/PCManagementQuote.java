package com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management;

import com.shrew.consulting.eagleeye.msp.quote.service.model.Item;
import com.shrew.consulting.eagleeye.msp.quote.service.model.Quote;
import com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.anti.malware.anti.spyware.detection.AnitMalwareAntiSpywareDetection;
import com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.antivirus.detection.AntivirusDetection;
import com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.backup.management.IntegratedBackup;
import com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.backup.management.Monitoring;
import com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.basic.spam.service.BasicSpamService;
import com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.device.monitoring.DeviceMonitoring;
import com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.help.desk.HelpDesk;
import com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.patch.managment.OfficeUpdates;
import com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.patch.managment.OtherUpdates;
import com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.patch.managment.WindowsUpdates;
import com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.periodic.system.optimization.PeriodicSystemOptimization;

import java.util.HashMap;
import java.util.Map;

public class PCManagementQuote extends Quote {

    public PCManagementQuote() {
        Map<String, Item> items = new HashMap<>();
        DeviceMonitoring deviceMonitoring = new DeviceMonitoring();
        WindowsUpdates windowsUpdates = new WindowsUpdates();
        OfficeUpdates officeUpdates = new OfficeUpdates();
        OtherUpdates otherUpdates = new OtherUpdates();
        HelpDesk helpDesk = new HelpDesk();
        PeriodicSystemOptimization periodicSystemOptimization = new PeriodicSystemOptimization();
        Monitoring monitoring = new Monitoring();
        IntegratedBackup integratedBacku = new IntegratedBackup();
        AntivirusDetection antivirusDetection = new AntivirusDetection();
        AnitMalwareAntiSpywareDetection anitMalwareAntiSpywareDetection = new AnitMalwareAntiSpywareDetection();
        BasicSpamService basicSpamService = new BasicSpamService();
        items.put(deviceMonitoring.getKey(), deviceMonitoring);
        items.put(windowsUpdates.getKey(), windowsUpdates);
        items.put(officeUpdates.getKey(), officeUpdates);
        items.put(otherUpdates.getKey(), otherUpdates);
        items.put(helpDesk.getKey(), helpDesk);
        items.put(periodicSystemOptimization.getKey(), periodicSystemOptimization);
        items.put(monitoring.getKey(), monitoring);
        items.put(integratedBacku.getKey(), integratedBacku);
        items.put(antivirusDetection.getKey(), antivirusDetection);
        items.put(anitMalwareAntiSpywareDetection.getKey(), anitMalwareAntiSpywareDetection);
        items.put(basicSpamService.getKey(), basicSpamService);
        setItems(items);
    }

}
