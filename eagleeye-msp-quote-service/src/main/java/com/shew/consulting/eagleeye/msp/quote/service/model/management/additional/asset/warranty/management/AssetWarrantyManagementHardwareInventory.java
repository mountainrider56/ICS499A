package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.asset.warranty.management;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * Additional: Asset/Warranty Management: Hardware Inventory (per device)
 */
@Component
public class AssetWarrantyManagementHardwareInventory implements ServiceDefinition {

    public static final String TITLE = "Hardware Inventory";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.ADDITIONAL), TITLE, .5);
    }

}
