package sheji.proxy.jingtai;

public class Station implements TicketSell {
    @Override
    public void buyTicket() {
        System.out.println("火车站买了一张票");
    }
}
