/**
 * @Description: 链表实现的队列
 * @author: wuleshen
 */
public class LinkedListQueue<E> implements Queue<E> {

    class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return  e.toString();
        }
    }

    private Node head, tail;    // 头节点，尾节点
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        //判断链表尾是否为空
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        Node retNode = head;
        head = head.next;
        retNode.next = null;
        //这里要判断链表头是否为空
        if (head == null)
            tail = null;
        size --;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue front ");

        Node cur = head;
        while( cur != null) {
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("null tail");
        return sb.toString();
    }

    public static void main(String[] args){

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
