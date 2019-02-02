/**
 * @Description: 自定义实现数组队列
 * @author: wuleshen
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue() {
        this.array = new Array<>();
    }

    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: [");
        for (int i=0; i<array.getSize(); i++) {
            sb.append(array.get(i));
            if ( i != array.getSize()-1 ) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        for ( int i = 0; i < 5; i ++ ) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        for  ( int i = 0; i < 2; i ++ ) {
            queue.dequeue();
            System.out.println(queue);
        }
        queue.enqueue(100);
        System.out.println(queue);
    }
}
