package DoublyLists;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {12, 15, 45, 39, 164};
        ArrayList<Integer> collection = new ArrayList<>();
        collection.add(7);
        collection.add(8);
        collection.add(10);

        DoublyList doublyList = new DoublyList();
        doublyList.addArrayList(numbers);
        doublyList.printAll();
        doublyList.printArray(numbers);
        doublyList.addToBeginning(16);
        doublyList.printAll();
        System.out.println(doublyList.extractFromBeginning());
        System.out.println(doublyList.extractAndDeleteFromBeginning());
        doublyList.printAll();
        doublyList.addToEnd(148);
        doublyList.printAll();
        System.out.println(doublyList.extractFromEnd());
        System.out.println(doublyList.extractAndDeleteFromEnd());
        doublyList.printAll();
        System.out.println(doublyList.checkIfThereIsValue(148));
        doublyList.checkIfEmpty();
        doublyList.addToCollection(collection);
        doublyList.printAll();
        doublyList.addToEndCollection(collection);
        doublyList.printAll();
        doublyList.printBack();

    }
}
