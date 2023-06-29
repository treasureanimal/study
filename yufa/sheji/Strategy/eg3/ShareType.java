package sheji.Strategy.eg3;

public enum ShareType {
    SINGLE("single", "单商品"),
    MULTI("multi", "多商品"),
    ORDER("order", "下单");

    private String  code;
    private String msessage;

    ShareType(String code, String msessage) {
        this.code = code;
        this.msessage = msessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsessage() {
        return msessage;
    }

    public void setMsessage(String msessage) {
        this.msessage = msessage;
    }
}
