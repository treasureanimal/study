package sheji.proxy.dongtai.cglib.eg1;

public class Cicada implements BaseService{
    @Override
    public void mainService() {
        System.out.println("主要业务，以蝉为例，当蝉出现业务调用时，螳螂监听到");
    }
}
