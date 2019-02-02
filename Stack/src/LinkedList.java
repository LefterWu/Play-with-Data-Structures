/**
 * @Description: 自定义链表
 * @author: wuleshen
 */
public class LinkedList<E> {

    //内部类定义节点
    class Node {
        //将node的属性定义为public为了让外部LinkedList直接访问
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

    private Node dummyHead; //虚拟头结点
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);  //虚拟头结点初始化时是一个空节点
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index位置添加新的元素e
     * 在链表中不是一个常用的操作，用作练习
     * @param index 索引
     * @param e 元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        //找到index的前一个节点
        Node prev = dummyHead;
        for (int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        //将新增节点添加到链表中
        prev.next = new Node(e, prev.next);
        size ++;
    }

    /**
     * 链表头添加元素
     * @param e 元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 链表尾添加元素
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得链表的第index个位置的元素
     * 在链表中不是一个常用的操作，用作练习
     * @param index 索引
     * @return 第index个位置的元素
     */
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        //找到index节点
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i ++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获得链表的第一个元素
     * @return 链表的第一个元素
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获得链表的最后一个元素
     * @return 链表的最后一个元素
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改链表的第index个元素
     * @param index 索引
     * @param e 元素
     */
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        //找到index节点
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i ++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否含有元素e
     * @param e 元素
     * @return 存在元素e则返回true
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (e.equals(cur)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }

    /**
     * 从链表中删除index位置的元素
     * 在链表中不是一个常用的操作，用作练习
     * @param index 索引
     * @return 删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        //找到index的前一个节点
        Node prev = dummyHead;
        for (int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        //待删除节点
        Node delNode = prev.next;
        //删除节点
        prev.next = delNode.next;
        delNode.next = null;

        size --;
        return delNode.e;
    }

    /**
     * 从链表中删除第一个元素
     * @return 删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素
     * @return 删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

}
