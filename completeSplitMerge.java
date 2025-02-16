import java.util.ArrayList;
import java.util.LinkedList;

public class TwoLists {
    private LinkedList<Integer> linkedList;
    private ArrayList<Integer> arrayList;

    public TwoLists() {
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();
    }

    // LinkedList methods
    public void addElementToLinkedList(int element) {
        linkedList.add(element);
    }

    public int getElementFromLinkedList(int index) {
        if (index >= 0 && index < linkedList.size()) {
            return linkedList.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds for linked list");
        }
    }

    public static void main(String[] args) {
        TwoLists TwoLists = new TwoLists();

        // Test LinkedList methods
        TwoLists.addElementToLinkedList(10);
        TwoLists.addElementToLinkedList(20);
        System.out.println("Element at index 1 in LinkedList: " + TwoLists.getElementFromLinkedList(1));
    }
}