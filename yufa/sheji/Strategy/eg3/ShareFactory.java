package sheji.Strategy.eg3;

public class ShareFactory {

    private ShareStrategy shareStrategy;

    public void setShareStrategy(ShareStrategy shareStrategy) {
        this.shareStrategy = shareStrategy;
    }

    public void doshareAlgorithm(String type){
        this.shareStrategy.shareAlgorithm(type);
    }
}
