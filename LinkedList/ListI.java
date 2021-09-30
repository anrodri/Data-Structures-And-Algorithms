public interface ListI<E>
{
    int size();
    // Return the number of elements on the list.

    void addFirst(E element);
    // Adds an element to the beginning of the list.

    void addLast(E element);
    // Adds an element to the end of the list.

    boolean contains (E element);
    // Return true if the list contains an element e such that e.equals(element);
    // Otherwise, return false.

    E removeFirst ();
    // Remove first element of the list and returns data of removed element.
    // If list is empty, return null.

    E removeLast ();
    // Remove last element of the list and returns data of removed element.
    // If list is empty, return null.

    E remove (E element);
    // Remove an element e from the list such that e.equals (element) and returns data of removed element.
    // If no such element exists, return null.

    E get(E element);
    // Returns an element e from this list such that e.equals(element);
    // If no such element exists, return null.

    E peekLast();
    // Returns data of last element.

    E peekFirst();
    // Returns data of first element.

    String toString();
    // Returns a string representation of the list.
}