package sheji.proxy.jingtai;

public class Test {

    public static void main(String[] args) {
        TicketSell sell = new ProxyStation();
        sell.buyTicket();
        sell.buyTicket();
    }
}
