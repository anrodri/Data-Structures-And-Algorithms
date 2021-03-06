public class LinkedList<E> implements ListI<E>{

    // Inner Node class
    class Node<E> {
        E data;
        Node<E> next;

        public Node(E obj){
            data = obj;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    // Constructor
    public LinkedList(){
        head = tail = null;
        currentSize = 0;
    }

    // Add element at the beginning of the list -- Time Complexity: O(1)
    @Override
    public void addFirst(E obj){
        Node<E> node = new Node<E>(obj);
        // Check if empty
        if (head == null){
            head = tail = node;
            currentSize++;
            return;
        }
        node.next = head;
        head = node;
        currentSize++;
    }

    // Add element at the end of the list -- Time Complexity: O(1)
    @Override
    public void addLast(E obj){
        Node<E> node = new Node<E>(obj);
        //Check if empty
        if (head == null){
            head = tail = node;
            currentSize++;
            return;
        }
        tail.next = node;
        tail = node;
        currentSize++;
    }

    // Remove the first element of the list -- Time Complexity: O(1)
    @Override
    public E removeFirst(){
        // Check if empty
        if (head == null)
            return null;
        E tmp = head.data;
        // Check if only one element in the list
        if (head == tail)
            tail = head = null;
        else
            head = head.next;
        currentSize--;
        return tmp;
    }

    // Remove the last element of the list -- Time Complexity: O(n)
    @Override
    public E removeLast(){
        // Check if empty
        if (head == null){
            return null;
        // Check if only one element in the list
        }else if (head == tail){
            return removeFirst();
        }
        Node<E> current = head, previous = null;
        while (current != tail){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        currentSize--;
        return current.data;
    }

    // Find and remove element -- Time Complexity: O(n)
    @Override
    public E remove(E obj){
        Node<E> current = head, previous = null;
        while(current != null){
            if(((Comparable<E>)current.data).compareTo(obj) == 0){
                // Check if element is the first one in the list
                if(current == head)
                    return removeFirst();
                // Check if element is the last one in the list
                if(current == tail)
                    return removeLast();
                currentSize--;
                previous.next = current.next;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    // Find and return obj -- Time Complexity: O(n)
    @Override
    public E get(E obj) {
        Node<E> current = head;
        while(current != null){
            if(((Comparable<E>)current.data).compareTo(obj) == 0)
                return current.data;
            current = current.next;
        }
        return null;
    }

    // Return size of list -- Time Complexity: O(1)
    @Override
    public int size() {
        return currentSize;
    }

    // Check if LinkedList contains obj -- Time Complexity: O(n)
    public boolean contains(E obj){
        Node<E> current = head;
        while(current != null){
            if(((Comparable<E>)current.data).compareTo(obj) == 0)
                return true;
            current = current.next;
        }
        return false;
    }

    // Return first element -- Time Complexity: O(1)
    @Override
    public E peekFirst(){
        if(head == null)
            return null;
        return head.data;
    }

    // Return last element -- Time Complexity: O(1)
    @Override
    public E peekLast(){
        if(tail == null)
            return null;
        return tail.data;
    }

    // Print every element in the list -- Time Complexity: O(n)
    public void print(){
        // Check if list is empty
        if(head == null)
            return;
        Node<E> current = head;
        while(current != tail.next) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
    }

    // Reverse list in place -- Time Complexity O(n)
    public void reverse(){
        // Check if list is empty
        if (head == null){
            return;
        // Check if only one element in the list
        }else if (head == tail){
            return;
        }
        Node<E> curr = head;
        Node<E> previous = null;
        Node<E> after = null;
        tail = curr;
        while (curr != null){
            after = curr.next;
            curr.next = previous;
            previous = curr;
            curr = after;
        }
        head = previous;
    }
}

