import java.util.Arrays;

/**
 * @Description: 一个自定义的动态数组类
 * @author: wuleshen
 */
public class Array<E> {

    private E[] data;   //数据
    private int size;   //数组当前元素个数


    /**
     * 构造函数
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组当前元素个数
     * @return 数组当前元素个数
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 获取数组容量
     * @return 数组容量
     */
    public int getCapacity() {
        return this.data.length;
    }

    /**
     * 查看数组是否为空
     * @return 数组为空返回false
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 获取第一个元素
     * @return 第一个元素
     */
    public E getFirst() {
        return data[0];
    }

    /**
     * 获取最后一个元素
     * @return 最后一个元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 向数组中添加元素
     * @param index   元素位置
     * @param element 添加的元素
     */
    public void add(int index, E element) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index>=0 and index<=size.");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        //从最后一位开始，把每个元素往后移动一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    public void addFirst(E element) {
        add(0, element);
    }

    public void addLast(E element) {
        add(size, element);
    }

    /**
     * 从数组中查询元素
     * @param index 元素位置
     * @return 查询出的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Require index>=0 and index<size.");
        }
        return data[index];
    }

    /**
     * 设置数组元素
     * @param index
     * @param element
     */
    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Require index>=0 and index<size.");
        }
        data[index] = element;
    }

    /**
     * 数组是否包含某元素
     * @param element
     * @return
     */
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找某元素索引
     * @param element
     * @return 如果元素不存在，返回-1; 元素存在，返回该元素索引值
     */
    public int find(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从指定位置删除数组元素
     * @param index 指定位置
     * @return 删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size ) {
            throw new IllegalArgumentException("Remove failed. Require index>=0 and index<size.");
        }
        E ret = data[index];    //保存删除元素的值用于返回
        //从index+1开始，每一个值向前移动一位
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        /*移动完毕后，data[size]还存在一个值，这个值也叫做loitering objects（闲散对象）
          闲散对象的存在并不意味着memory leak（内存泄漏）
          可以用data[size] = null;来将该元素置空，但是没有必要，因为通过get是访问不到的
         */
//      data[size] = null;
        //采用lazy方式缩容，当容量变为原来的1/4时，就把容量缩减为1/2，可以有效避免复杂度震荡
        if (size == data.length / 4  && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size -1);
    }

    /**
     * 删除某元素
     * @param element 要删除的元素
     * @return 元素是否被删除
     */
    public boolean removeElement(E element) {
        int index = find(element);
        if (index != -1) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 重置数组容量（扩容或缩容）
     * @param newCapacity 新的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        return "Array: size = " + size + " , capacity = " + getCapacity() + "\n" +
                "data = " + Arrays.toString(data);
    }
}
