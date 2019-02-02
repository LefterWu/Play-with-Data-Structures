import java.util.Arrays;

/**
 * @Description: 自定义实现循环队列
 * @author: wuleshen
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;  //指向队首元素
    private int tail;   //指向队尾后一个元素
    private int size;   //队列大小

    public LoopQueue(int capacity) {
        this.data = (E[]) new Object[capacity+1];   //由于循环队列的实际可使用长度比数组长度要少1，因此这里创建数组时要加1
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        //如果队列满了，进行扩容
        //由于是循环队列，判断队列是否满时需进行取余
        if ( (tail + 1) % data.length == front ) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;    //这里依旧注意循环要取余
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = getFront();
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        //缩容操作
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length - 1; //由于预留一个空位，队列的实际可用空间需要减1
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 队列扩容
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];    //扩容后的数组同样要预留一个位置
        for ( int i = 0; i < size; i ++ ) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();

    }

}
