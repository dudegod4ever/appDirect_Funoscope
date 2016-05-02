package funoscope.web.adapter;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import funoscope.util.IdGeneratorUtil;
import funoscope.web.enumeration.EditionCode;
import funoscope.web.enumeration.EventType;
import funoscope.web.enumeration.ItemUnit;
import funoscope.web.generatedxml.event.Event;
import funoscope.web.generatedxml.event.Event.Creator;
import funoscope.web.generatedxml.event.Event.Marketplace;
import funoscope.web.generatedxml.event.Event.Payload;
import funoscope.web.generatedxml.event.Event.Payload.Company;
import funoscope.web.generatedxml.event.Event.Payload.Order;
import funoscope.web.generatedxml.event.Event.Payload.Order.Item;

@Service
public class SubscriptionAppDirectAdapter {

    private static final String BASE_URL = "http://localhost:8080";
    private static final String PARTNER = "funoscope";
    private static final String CREATOR_EMAIL = "admin@funoscope.com";
    private static final String CREATOR_FIRST_NAME = "Sebastien";
    private static final String CREATOR_LAST_NAME = "Laporte";
    private static final String COMPANY_EMAIL = "company@funoscope.com";
    private static final String COMPANY_NAME = "funoscope com";
    private static final String COMPANY_PHONE_NUMBER = "1-415-555-1212";
    private static final String COMPANY_WEBSITE = "funoscope.com";

    private static final String CREATOR_OPEN_ID = "https://www.acme-marketplace.com/openid/id/a11a7918-bb43-4429-a256-f6d729c71033";

    public Event createSubscriptionOrderEventFromInputParameters(String pVersion, String pToken) {
        Event event = new Event();

        event.setType(EventType.SUBSCRIPTION_ORDER.name());

        Marketplace marketPlace = new Marketplace();
        marketPlace.setBaseUrl(BASE_URL);
        marketPlace.setBaseUrl(PARTNER);
        event.setMarketplace(marketPlace);

        Creator creator = new Creator();
        creator.setEmail(CREATOR_EMAIL);
        creator.setFirstName(CREATOR_FIRST_NAME);
        creator.setLastName(CREATOR_LAST_NAME);
        creator.setOpenId(CREATOR_OPEN_ID);
        creator.setUuid(IdGeneratorUtil.getUserId());
        event.setCreator(creator);

        Payload payload = new Payload();
        Company company = new Company();
        company.setEmail(COMPANY_EMAIL);
        company.setName(COMPANY_NAME);
        company.setPhoneNumber(COMPANY_PHONE_NUMBER);
        company.setWebsite(COMPANY_WEBSITE);
        company.setUuid(IdGeneratorUtil.getCompanyId());
        payload.setCompany(company);

        Order order = new Order();
        order.setEditionCode(EditionCode.BASIC.name());
        Item item = new Item();
        item.setQuantity(BigInteger.TEN);
        item.setUnit(ItemUnit.USER.name());
        order.getItem().add(item);
        payload.setOrder(order);

        event.setPayload(payload);

        return event;
    }

}
