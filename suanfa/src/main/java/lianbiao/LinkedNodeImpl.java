package lianbiao;

public class LinkedNodeImpl implements LinkedNodeInter {
    private static LinkedNode<String> head = new LinkedNode<>(0, "");
    @Override
    public void addLinkedNode(LinkedNode<String> node) {

        //因为head节点是不能动，所以我们需要辅助节点temp
        LinkedNode<String> temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;

    }

    @Override
    public void showLinkedNode() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        LinkedNode<String> temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    @Override
    public void updateLinkedNode(LinkedNode<String> node) {
        if (node.next == null) {
            System.out.println("链表为空");
            return;
        }
        LinkedNode<String> temp = node.next;
        boolean flag = false;
        while (true) {
            if (temp.id == node.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        temp.date = temp.date;
    }

    @Override
    public void deleteLinkedNode(int id) {
        LinkedNode<String> temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next ==null) {
                break;
            }
            if(temp.next.id == id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("没有找到id"+id);
        }
    }

    @Override
    public void revseLinkedNode(LinkedNode<String> node) {
        if(node.date == null) {
            return;
        }
        LinkedNode<String> prev = null;
        while (node.next != null) {
            LinkedNode<String> next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
    }
}
