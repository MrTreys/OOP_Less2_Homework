import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Actor p1 = new Actor("Jake");
        Actor p2 = new Actor("Anne");
        Actor p3 = new Actor("Hank");
        Actor p4 = new Actor("Tony");
        List<Actor> potentialCustomers = new ArrayList<>(Arrays.asList(p1, p2, p3, p4));
        Market market = new Market();

        market.acceptToMarket(p1);
        market.acceptToMarket(p2);
        market.acceptToMarket(p3);
        market.acceptToMarket(p4);
        System.out.println(market.getCustomers());
        System.out.println();

        market.takeOrders(p1);
        System.out.printf("%s makes order: %b\n", p1.getName(), p1.isMakeOrder());
        System.out.printf("%s makes order: %b\n", p2.getName(), p2.isMakeOrder());
        market.takeOrders(p3);
        System.out.printf("%s makes order: %b\n", p3.getName(), p3.isMakeOrder());
        System.out.printf("%s makes order: %b\n", p4.getName(), p4.isMakeOrder());
        System.out.println();

        market.takeInQueue(p1);
        market.takeInQueue(p2);
        market.takeInQueue(p3);
        System.out.println(market.getQueue());
        System.out.println();

        market.giveOrders(p1);
        market.releaseFromQueue(p1);
        System.out.printf("%s gets order: %b\n", p1.getName(), p1.isTakeOrder());

        market.takeOrders(p2);
        market.giveOrders(p2);
        market.releaseFromQueue(p2);
        System.out.printf("%s gets order: %b\n", p2.getName(), p2.isTakeOrder());

        market.giveOrders(p3);
        market.releaseFromQueue(p3);
        System.out.printf("%s gets order: %b\n", p3.getName(), p3.isTakeOrder());

        System.out.printf("%s gets order: %b", p4.getName(), p4.isTakeOrder());
        
        market.releaseFromMarket(potentialCustomers);
        
    }
}
