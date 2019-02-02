public class Main {

    public static void main(String[] args) {
	    Array<Integer> arr = new Array<Integer>(10);
	    for (int i=0; i<10; i++) {
	        arr.addLast(i);
        }
        System.out.println(arr);
	    arr.add(1, 100);
        System.out.println(arr);

        arr.remove(1);
        System.out.println(arr);
        arr.remove(5);
        System.out.println(arr);
        System.out.println("------------------------------------------------------");
        for (int i=0; i<5; i++) {
            arr.removeLast();
            System.out.println(arr);
        }
        System.out.println("------------------------------------------------------");
    }

}
