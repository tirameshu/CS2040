class BasicLinkedList<E> implements LinkedListInterface<E> {
    public void logicalRemove(ListNode<E> target) {
        next = target.getNext(); //node is to point to this
        ListNode<E> node;
        while (this.getNext() != target) {
            node = this.getNext(); //traverse through linkedlist to get to target
        }
        node = this.getNext();
        //very confused: what's the purpose of a list if you can only access the next node
        //with no overview of all nodes.
        //
