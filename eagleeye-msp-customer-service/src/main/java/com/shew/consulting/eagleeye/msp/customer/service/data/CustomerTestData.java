package com.shew.consulting.eagleeye.msp.customer.service.data;

import com.shew.consulting.eagleeye.msp.customer.service.controllers.CustomerController;
import com.shew.consulting.eagleeye.msp.customer.service.model.Customer;
import com.shew.consulting.eagleeye.msp.customer.service.model.Representative;
import com.shew.consulting.eagleeye.msp.customer.service.model.USState;
import com.shew.consulting.eagleeye.msp.customer.service.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Add test data on service startup.
 */
@Slf4j
@Component
@Profile("testData")
@RequiredArgsConstructor
public class CustomerTestData {

    private final CustomerController customerController;
    private final Validator validator;

    @EventListener
    public void applicationReady(ApplicationReadyEvent event) {
        List<Customer> customers = new ArrayList<>();
        customers.add(customer1());
        customers.add(customer2());
        customers.add(customer3());
        customers.add(customer4());
        customers.add(customer5());
        customers.add(customer6());
        customers.add(customer7());
        customers.add(customer8());
        customers.add(customer9());
        customers.add(customer10());
        customers.forEach(customer -> {
            Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            customerController.saveCustomer(customer);
        });
        log.info(event.toString());
    }

    private Customer customer1() {
        Customer customer = new Customer();
        customer.setName("Savvy Action");
        customer.setTelephone("(752) 920-6450");
        customer.setEmail("contact@SavvyAction.com");
        customer.setAddress1("9219 Wood Lane");
        customer.setCity("Minneapolis");
        customer.setState(USState.MN);
        customer.setZipcode("55111");
        Representative representative = new Representative();
        representative.setFirstName("Maegan");
        representative.setLastName("Talley");
        representative.setEmail("Maegan.C.Talley@SavvyAction.com");
        representative.setTelephone("(804) 326-8065");
        customer.setRepresentative(representative);
        return customer;
    }

    private Customer customer2() {
        Customer customer = new Customer();
        customer.setName("Opert");
        customer.setTelephone("(783) 765-8311");
        customer.setEmail("contact@Opert.com");
        customer.setAddress1("823 Gates Lane");
        customer.setCity("Mocksville");
        customer.setState(USState.WI);
        customer.setZipcode("55412");
        Representative representative = new Representative();
        representative.setFirstName("Joanne");
        representative.setLastName("O'Sullivan");
        representative.setEmail("Joanne.A.OSullivan@Opert.com");
        representative.setTelephone("(285) 753-2949");
        customer.setRepresentative(representative);
        return customer;
    }

    private Customer customer3() {
        Customer customer = new Customer();
        customer.setName("Pland");
        customer.setTelephone("(994) 981-2644");
        customer.setEmail("contact@Pland.com");
        customer.setAddress1("665 S. Studebaker St.");
        customer.setAddress2("Apt 62");
        customer.setCity("Lincoln Park");
        customer.setState(USState.MN);
        customer.setZipcode("48146");
        Representative representative = new Representative();
        representative.setFirstName("Yusra");
        representative.setLastName("Zuniga");
        representative.setEmail("Yusra.B.Zuniga@Pland.com");
        representative.setTelephone("(730) 951-6947");
        customer.setRepresentative(representative);
        return customer;
    }

    private Customer customer4() {
        Customer customer = new Customer();
        customer.setName("Adminess");
        customer.setTelephone("(944) 564-7918");
        customer.setEmail("contact@Adminess.com");
        customer.setAddress1("78 Greenrose Lane");
        customer.setCity("Sylvania");
        customer.setState(USState.MN);
        customer.setZipcode("43560");
        Representative representative = new Representative();
        representative.setFirstName("Holly");
        representative.setLastName("Jensen");
        representative.setEmail("Holly.N.Jensen@Adminess.com");
        representative.setTelephone("(915) 989-5419");
        customer.setRepresentative(representative);
        return customer;
    }

    private Customer customer5() {
        Customer customer = new Customer();
        customer.setName("Introl");
        customer.setTelephone("(451) 503-5044");
        customer.setEmail("contact@Introl.com");
        customer.setAddress1("9219 Wood Lane");
        customer.setCity("New Lenox");
        customer.setState(USState.WI);
        customer.setZipcode("60451");
        Representative representative = new Representative();
        representative.setFirstName("Kodi");
        representative.setLastName("Jensen");
        representative.setEmail("Kodi.Y.Banks@Introl.com");
        representative.setTelephone("(869) 961-5128");
        customer.setRepresentative(representative);
        return customer;
    }

    private Customer customer6() {
        Customer customer = new Customer();
        customer.setName("PlanLine");
        customer.setTelephone("(271) 921-3999");
        customer.setEmail("contact@PlanLine.com");
        customer.setAddress1("697 S. Trenton St.");
        customer.setCity("Elgin");
        customer.setState(USState.MN);
        customer.setZipcode("60120");
        Representative representative = new Representative();
        representative.setFirstName("Wren");
        representative.setLastName("Sparks");
        representative.setEmail("Wren.W.Sparks@PlanLine.com");
        representative.setTelephone("(559) 462-8933");
        customer.setRepresentative(representative);
        return customer;
    }

    private Customer customer7() {
        Customer customer = new Customer();
        customer.setName("Topment");
        customer.setTelephone("(271) 921-3999");
        customer.setEmail("contact@Topment.com");
        customer.setAddress1("54 Mill St");
        customer.setCity("Hollywood");
        customer.setState(USState.WI);
        customer.setZipcode("33020");
        Representative representative = new Representative();
        representative.setFirstName("Eduard");
        representative.setLastName("Morrow");
        representative.setEmail("Eduard.M.Morrow@Topment.com");
        representative.setTelephone("(559) 462-8933");
        customer.setRepresentative(representative);
        return customer;
    }

    private Customer customer8() {
        Customer customer = new Customer();
        customer.setName("Jopling");
        customer.setTelephone("(371) 631-8139");
        customer.setEmail("contact@Jopling.com");
        customer.setAddress1("7942 Boston Rd.");
        customer.setCity("Cornelius");
        customer.setState(USState.MN);
        customer.setZipcode("28031");
        Representative representative = new Representative();
        representative.setFirstName("Simona");
        representative.setLastName("Bautista");
        representative.setEmail("Simona.M.Bautista@Jopling.com");
        representative.setTelephone("(734) 672-0191");
        customer.setRepresentative(representative);
        return customer;
    }

    private Customer customer9() {
        Customer customer = new Customer();
        customer.setName("Retrol");
        customer.setTelephone("(502) 309-7544");
        customer.setEmail("contact@Retrol.com");
        customer.setAddress1("791 Heritage Ave.");
        customer.setCity("Stockbridge");
        customer.setState(USState.MN);
        customer.setZipcode("30281");
        Representative representative = new Representative();
        representative.setFirstName("Lynn");
        representative.setLastName("Arroyo");
        representative.setEmail("Lynn.K.Arroyo@Retrol.com");
        representative.setTelephone("(525) 426-4812");
        customer.setRepresentative(representative);
        return customer;
    }

    private Customer customer10() {
        Customer customer = new Customer();
        customer.setName("Plance");
        customer.setTelephone("(547) 873-4545");
        customer.setEmail("contact@Plance.com");
        customer.setAddress1("927 White Drive");
        customer.setCity("Phillipsburg");
        customer.setState(USState.WI);
        customer.setZipcode("08865");
        Representative representative = new Representative();
        representative.setFirstName("Kourtney");
        representative.setLastName("Lozano");
        representative.setEmail("Kourtney.Z.Lozano@Plance.com");
        representative.setTelephone("(882) 821-5095");
        customer.setRepresentative(representative);
        return customer;
    }

}
