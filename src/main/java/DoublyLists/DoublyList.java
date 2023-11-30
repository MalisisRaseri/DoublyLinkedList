package DoublyLists;

import java.util.Collection;


public class DoublyList {
    private Node head;
    private Node tail;

    public Integer[] array (Integer[] list){
        Integer[] result = new Integer[list.length];
        for (int i =0, j = result.length-1; i<list.length; i++,j--){
            result[j] = list[i];
        }
        return result;
    }

    public void printArray(Integer[] variable){
        for(Integer i : array(variable)){
            System.out.println(i);
        }
    }

    // добавление значения в начало списка
    public void addArrayList (Integer [] variable){
        for (Integer i : array(variable)){
            addToBeginning(i);
        }
    }

    //Добавление всех значений заданного массива в конец списка с сохранением порядка
    public void addArrayListEnd (Integer [] variable){
        for (Integer i : variable){
            addToEnd(i);
        }
    }

    // добавление значения в начало списка
    public void addToBeginning (Integer variable){
        Node newNode = new Node(variable);
        newNode.date = variable;
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }
    //Извлечение значения из начала списка без его удаления из списка
    public int extractFromBeginning (){
        if (head != null)
            return head.date;
        else
            throw new IllegalArgumentException("Список пуст");
    }

    // Извлечение значения из начала списка с удалением из списка
    public int extractAndDeleteFromBeginning () {
        if (head != null && tail.previous != null) {
            Integer firstDate = head.date;
            head = head.next;
            head.previous = null;
            return firstDate;
        } else if (head != null && head.next == null){
            Integer firstDate = head.date;
            head = head.next;
            return firstDate;
        }
        else
            throw new IllegalArgumentException("Список пуст");
    }

    // Добавление значения в конец списка
    public void addToEnd (Integer variable){
        Node newNode = new Node(variable);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        Node temp1 = tail;
        while (temp.next != null){
            temp = temp.next;
            temp1 = temp1.previous;
        }
        temp.next = newNode;
        temp1.previous = newNode;
    }

    //Извлечение значения из конца списка без его удаления
    public int extractFromEnd(){
        if (head != null){
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;}
            return temp.date;
        }
        else
            throw new IllegalArgumentException("Список пуст");
    }

    //Извлечение значения из конца списка с удалением
    public int extractAndDeleteFromEnd (){
        if (head != null && tail.previous != null) {
            Integer firstDate = tail.date;
            tail = tail.previous;
            tail.next = null;
            return firstDate;
        }
        else if(head != null && head.next == null){
            Integer firstDate = head.date;
            head = head.next;
            return firstDate;
        }
        else
            throw new IllegalArgumentException("Список пуст");
    }

    // Определение, содержит ли список заданное значение, или нет
    public boolean checkIfThereIsValue(Integer variable){
        Node temp = head;
        Boolean result = false;
        if(head == null)
            return false;
        else if (temp.next == null){
            return variable.equals(temp.date);
        }
        else
            while (temp.next != null){
                if(variable.equals(temp.date)){
                    result = true;
                    temp = temp.next;
                }
                else
                    temp = temp.next;
            }
        return  result;
    }

    // Определение, является ли список пустым, или нет
    public boolean checkIfEmpty (){
        if (head == null)
            System.out.println("Список пуст");
        else
            System.out.println("Список не пустой");
        return head == null;

    }

    // Печать всех значений списка
    public void printAll() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.date);
            temp = temp.next;
        }
    }

    // Печать всех значений списка в обратном порядке
    public void printBack (){
        if (head == null) return;
        Node temp = tail;
        if(temp.previous == null){
            System.out.println(temp.date);
        }else {
            while (temp.previous != null){
                System.out.println(temp.date);
                temp = temp.previous;
                if(temp.previous == null){
                    System.out.println(temp.date);
                }
            }
        }
    }

    //Добавление всех значений заданной коллекции в начало списка с сохранением порядка

    public void addToCollection (Collection<Integer> collection){
        Integer[] temp = collection.toArray(new Integer[0]);
        addArrayList(temp);
    }

    // Добавление всех значений заданной коллекции в конец списка с сохранением порядка
    public void addToEndCollection (Collection<Integer> collection){
        Integer[] temp = collection.toArray(new Integer[0]);
        addArrayListEnd(temp);
    }

    //Возвращающий количество элементов списка.
    public int amount() {
        Node temp = head;
        if (head == null) {
            return 0;
        } else if (temp.next == null) {
            return 1;
        } else {
            int amo = 0;
            while (temp.next != null) {
                temp = temp.next;
                amo++;
                if (temp.next == null) {
                    amo++; }
            }
            return amo;
        }
    }
    //Удаление списка
    public void deleteList() {
        if (head != null) {
            head= null;
            tail = null;  }
    }

    // Поглощение списка другим списком с добавлением значений второго в начало первого списка, после поглощения второй список должен очищаться

    public void mergerListBeginning(DoublyList mergerList){
        if (mergerList.head != null){
            Integer[] temp = new Integer[mergerList.amount()];
            Node temp1 = mergerList.head;
            temp[0] = temp1.date;
            int i =1;
            while (temp1.next != mergerList.tail){
                temp[i] = temp1.next.date;
                temp1 = temp1.next;
                i++;
                if (temp1.next == mergerList.tail)
                    temp[temp.length - 1] = mergerList.tail.date;
            }
            addArrayList(temp);
            mergerList.deleteList();
        }
    }

    // Поглощение списка другим списком с добавлением значений второго в конец первого списка, после поглощения второй список должен очищаться

    public void mergerListEnd(DoublyList mergerList){
        if (mergerList.head != null){
            Integer[] temp = new Integer[mergerList.amount()];
            Node temp1 = mergerList.tail;
            temp[0] = temp1.date;
            int i =1;
            while (temp1.next != mergerList.tail){
                temp[i] = temp1.next.date;
                temp1 = temp1.next;
                i++;
                if (temp1.next == mergerList.tail)
                    temp[temp.length - 1] = mergerList.tail.date;
            }
            addArrayListEnd(temp);
            mergerList.deleteList();
        }
    }

    private class Node {
        Integer date;
        Node next;
        Node previous;

        Node(Integer variable){
            date = variable;
        }

    }
}