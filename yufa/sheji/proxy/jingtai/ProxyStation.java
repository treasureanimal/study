package sheji.proxy.jingtai;

public class ProxyStation implements TicketSell {

    private Station station;

    //库存
    private static Integer stock =1;

    public ProxyStation() {
        this.station = new Station();
    }

    @Override
    public void buyTicket() {
        if(stock > 0){
            station.buyTicket();
            stock--;
        }else{
            throw new RuntimeException("库存不足");
        }
    }
}
