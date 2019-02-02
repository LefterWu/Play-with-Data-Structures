import java.util.Objects;

/**
 * @Description: 数组实现栈
 * @author: wuleshen
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayStack() {
        this.array = new Array<>();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
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
        sb.append("Stack: [");
        for (int i=0; i<array.getSize(); i++) {
            sb.append(array.get(i));
            if ( i != array.getSize()-1 ) {
                sb.append(", ");
            }
        }
        sb.append("] top");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayStack<?> that = (ArrayStack<?>) o;
        return Objects.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Objects.hash(array);
    }

    public static void main(String[] args) {
        Stack stack = new ArrayStack<Integer>();
        for (int i = 0; i < 5; i ++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
