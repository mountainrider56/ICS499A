package com.shew.consulting.eagleeye.msp.quote.service.data;

import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.anti.malware.anti.spyware.detection.AnitMalwareAntiSpywareDetection;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection.AntivirusDetection;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.backup.management.breakdowns.IntegratedBackup;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.backup.management.breakdowns.Monitoring;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.basic.spam.service.breakdowns.DomainLevelFiltering;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.device.monitoring.DeviceMonitoring;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.help.desk.HelpDesk;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management.breakdowns.OfficeUpdates;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management.breakdowns.OtherUpdates;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management.breakdowns.WindowsUpdates;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.periodic.system.optimization.PeriodicSystemOptimization;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.PCManagementQuote;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Selection;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ServerManagementQuote;
import com.shew.consulting.eagleeye.msp.quote.service.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
@Profile("testData")
@RequiredArgsConstructor
public class QuoteTestData {

    private final QuoteRepository quoteRepository;

    @EventListener
    public void applicationReady(ApplicationReadyEvent event) {
        System.out.println(event);
        IntStream.range(0, 10).forEach(i -> {
            Quote quote = new Quote();
            PCManagementQuote pcManagementQuote = new PCManagementQuote();
            ServerManagementQuote serverManagementQuote = new ServerManagementQuote();
            List<Selection> selections = new ArrayList<>();
            selections.add(new Selection(null, new DeviceMonitoring(), getRandomInt()));
            selections.add(new Selection(null, new WindowsUpdates(), getRandomInt()));
            selections.add(new Selection(null, new OfficeUpdates(), getRandomInt()));
            selections.add(new Selection(null, new OtherUpdates(), getRandomInt()));
            selections.add(new Selection(null, new HelpDesk(), getRandomInt()));
            selections.add(new Selection(null, new PeriodicSystemOptimization(), getRandomInt()));
            selections.add(new Selection(null, new Monitoring(), getRandomInt()));
            selections.add(new Selection(null, new IntegratedBackup(), getRandomInt()));
            selections.add(new Selection(null, new AntivirusDetection(), getRandomInt()));
            selections.add(new Selection(null, new AnitMalwareAntiSpywareDetection(), getRandomInt()));
            selections.add(new Selection(null, new DomainLevelFiltering(), getRandomInt()));
            quote.setCustomerId(i + 1);
            quote.setPcManagementQuote(pcManagementQuote);
            quote.setServerManagementQuote(serverManagementQuote);
            quote.setInstant(Instant.now());
            selections.forEach(ii -> {
                double subtotal = ii.getBusinessService().getPrice() * ii.getQuantity();
                quote.setTotal(quote.getTotal() + subtotal);
            });
            quoteRepository.save(quote);
        });
    }

    private int getRandomInt() {
        return (int) (Math.random() * (100));
    }

}
