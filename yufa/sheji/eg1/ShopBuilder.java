package sheji.eg1;

public abstract class ShopBuilder {
    private String name;
    private String location;
    private String type;

    public abstract void name (String name);
    public abstract void location(String location);
    public abstract void type(String type);

    public abstract Shop build();

}
