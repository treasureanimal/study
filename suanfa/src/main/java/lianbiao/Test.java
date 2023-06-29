package lianbiao;

public class Test {
    public static void main(String[] args) {
        LinkedNodeInter linkedNodeInter = new LinkedNodeImpl();
        LinkedNode<String> node1 = new LinkedNode<>(1, "张飞");
        LinkedNode<String> node2 = new LinkedNode<>(1, "李四");
        LinkedNode<String> node3 = new LinkedNode<>(1, "王五");
        LinkedNode<String> node4 = new LinkedNode<>(1, "赵六");
        LinkedNode<String> node5 = new LinkedNode<>(1, "孙七");
        linkedNodeInter.addLinkedNode(node1);
        linkedNodeInter.addLinkedNode(node2);
        linkedNodeInter.addLinkedNode(node3);
        linkedNodeInter.addLinkedNode(node4);
        linkedNodeInter.addLinkedNode(node5);
        linkedNodeInter.showLinkedNode();
    }
}
