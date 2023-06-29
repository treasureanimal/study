package lianbiao;

/**
 * @author admin
 */
public class LinkedNode<T> {
    protected int id;
    protected LinkedNode<T> next;
    protected T date;

    public int size;

    public LinkedNode(int id, T date) {
        this.id = id;
        this.date = date;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "id=" + id +
                ", next=" + next +
                ", date=" + date +
                '}';
    }
}
