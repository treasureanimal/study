package sheji.zerenlian;

public class AdHandler extends PostHandler{
    @Override
    public void handlerRequest(Post post) {
        //屏蔽广告内容
        String content = post.getContent();
        //.....
        content = content.replace("广告","**");
        post.setContent(content);

        System.out.println("过滤广告...");
        //传递给下一个处理器
        next(post);
    }
}
