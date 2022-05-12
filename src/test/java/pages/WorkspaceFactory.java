package pages;

import com.celonis.base.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class WorkspaceFactory {

    private static final Function<WebDriver, BasePage> ORDER_TO_CASH = OrderToCashPage::new;
    private static final Function<WebDriver, BasePage> PURCHASE_TO_PAY = PurchaseToPayPage::new;
    private static final Function<WebDriver, BasePage> SERVICE_NOW_TICKETING = ServiceNowTicketingPage::new;

    private static final Map<String, Function<WebDriver, BasePage>> MAP = new HashMap<>();

    static {
        MAP.put("Order to Cash", ORDER_TO_CASH);
        MAP.put("Purchase to Pay", PURCHASE_TO_PAY);
        MAP.put("ServiceNow Ticketing", SERVICE_NOW_TICKETING);
    }

    public static BasePage get(String page, WebDriver driver){
        return MAP.get(page).apply(driver);
    }
}
