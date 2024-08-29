public class Actor {
    protected String name;
    protected boolean isInMarket;
    protected boolean isMakeOrder;
    protected boolean isTakeOrder;
    protected static Integer defaultName = 1;

    public Actor(String name) {
        this.name = name;
    }

    public Actor() {
        this(String.format("Person %d", defaultName++));
    }

    public void setMakeOrder(boolean order) {
        this.isMakeOrder = order;
    }

    public void setTakeOrder(boolean order) {
        if (isMakeOrder()) this.isTakeOrder = order;
    }

    public boolean isMakeOrder() {
        return this.isMakeOrder;
    }

    public boolean isTakeOrder() {
        return this.isTakeOrder;
    }

    String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }
}
