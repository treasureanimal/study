package sheji.proxy.dongtai.eg1;


import sheji.proxy.jingtai.Station;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
        Station station = new Station();
        InvocationHandler stockHandler = new StockHandler(station);
        Class<?> aClass = station.getClass();
        TicketSell sell = (TicketSell) Proxy.newProxyInstance(aClass.getClassLoader(),
                                                              aClass.getInterfaces(), stockHandler);
        sell.buyTicket();
        sell.buyTicket();
    }
}
