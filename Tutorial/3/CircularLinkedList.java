public class CircularLinkedList<E> {
    private int _size;
    private ListNode<E> _head;
    private ListNode<E> _tail;

    public void addFirst(E element) {
        _size++;
        _head = new ListNode<E>(element, head);
        if (_tail == null) {
            _tail = _head;
        }
        _tail.setNext(_head);
    }

    public void swap(int index) {
        int position = index % _size;
        ListNode<E> toSwap = _head;
        for (int i = 1; i < position; i++) {
            //when i = 0, it's accessing the head
            toSwap = toSwap.getNext();
        }
        //at position to swap

