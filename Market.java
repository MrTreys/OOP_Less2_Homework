import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Market extends Actor implements QueueBehaviour, MarketBehaviour {
    private static List<Actor> marketCustomers = new ArrayList<>();
    private static Queue<Actor> queue = new ArrayDeque<>();

    @Override
    public void acceptToMarket(Actor actor) {
        marketCustomers.add(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> people) {
        for (Actor customer : people) {
            if (marketCustomers.contains(customer)) marketCustomers.remove(customer);
        }
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void takeInQueue(Actor actor) {
        queue.add(actor);
    }

    @Override
    public void giveOrders(Actor actor) {
        if (queue.peek().getName() == actor.getName()) actor.setTakeOrder(true);
    }

    @Override
    public void takeOrders(Actor actor) {
        actor.setMakeOrder(true);
    }

    @Override
    public void releaseFromQueue(Actor actor) {
        if (queue.contains(actor)) queue.remove(actor);
    }
    
    public List<Actor> getCustomers() {
        return marketCustomers;
    }

    public Queue<Actor> getQueue() {
        return queue;
    }
}
