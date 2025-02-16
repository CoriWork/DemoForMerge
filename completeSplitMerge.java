import java.util.ArrayList;
import java.util.LinkedList;

public class TwoLists {
    private LinkedList<Integer> linkedList;
    private ArrayList<Integer> arrayList;

    public TwoLists() {
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();
    }

    // ArrayList methods
    public void addElementToArrayList(int element) {
        arrayList.add(element);
    }

    public int getElementFromArrayList(int index) {
        if (index >= 0 && index < arrayList.size()) {
            return arrayList.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds for array list");
        }
    }

    public static void main(String[] args) {
        TwoLists TwoLists = new TwoLists();
        
        // Test ArrayList methods
        TwoLists.addElementToArrayList(30);
        TwoLists.addElementToArrayList(40);
        System.out.println("Element at index 1 in ArrayList: " + TwoLists.getElementFromArrayList(1));
    }
}