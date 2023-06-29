package sheji.zerenlian;

public abstract class PostHandler {

    protected PostHandler successor;

    public void setSuccessor(PostHandler handler){
        this.successor = handler;
    }

    public abstract void handlerRequest(Post post);

    protected final void next(Post post){
        if(this.successor != null){
            this.successor.handlerRequest(post);
        }
    }
}
