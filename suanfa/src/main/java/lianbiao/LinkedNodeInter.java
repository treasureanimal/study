package lianbiao;

/**
 * 链表实现
 * @author admin
 */
public interface LinkedNodeInter {

    /**
     *获取链表
     * @return LinkedNode
     */
    default LinkedNode<String> getLinkedNode() {
        return new LinkedNode<>(0, "");
    }

    void addLinkedNode(LinkedNode<String> node);

    void showLinkedNode();

    void updateLinkedNode(LinkedNode<String> node);

    void deleteLinkedNode(int id);

    void revseLinkedNode(LinkedNode<String> node);
}
