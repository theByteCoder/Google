package datastructures.arraylist;

public class ArrayListImpl {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int limit = 22;

        // add
        for (int i = 1; i < limit; i++) {
            arrayList.add(i);
        }

        // get
        System.out.println(arrayList.get(0));

        // size
        System.out.println(arrayList.size());

        // insert
        arrayList.insert(0, 0);
        arrayList.insert(10, 10);
        arrayList.insert(20, 20);

        // get
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.size());
    }
}
