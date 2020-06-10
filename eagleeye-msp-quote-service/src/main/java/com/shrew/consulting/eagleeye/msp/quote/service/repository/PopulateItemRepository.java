package com.shrew.consulting.eagleeye.msp.quote.service.repository;

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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class PopulateItemRepository {

    private final ItemRespository itemRespository;

    @PostConstruct
    public void postConstruct() {
        itemRespository.save(new DeviceMonitoring());
        itemRespository.save(new WindowsUpdates());
        itemRespository.save(new OfficeUpdates());
        itemRespository.save(new OtherUpdates());
        itemRespository.save(new HelpDesk());
        itemRespository.save(new PeriodicSystemOptimization());
        itemRespository.save(new Monitoring());
        itemRespository.save(new IntegratedBackup());
        itemRespository.save(new AntivirusDetection());
        itemRespository.save(new AnitMalwareAntiSpywareDetection());
        itemRespository.save(new BasicSpamService());
    }

}
