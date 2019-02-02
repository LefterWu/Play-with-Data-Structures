/**
 * @Description: TODO
 * @author: wuleshen
 */
public interface Queue<E> {

    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 得到队首元素
     * @return 队首元素
     */
    E getFront();

    /**
     * 得到队列大小
     * @return 队列大小
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return 队列为空，返回true
     */
    boolean isEmpty();
}
