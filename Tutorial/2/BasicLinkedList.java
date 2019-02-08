class BasicLinkedList<E> implements LinkedListInterface<E> {
    public static BasicLinkedList<Integer> merge (\
            Basic LinkedList<Integer> firstList,\
            Basic LinkedList<Integer> secondList) {
        //do not assume same list size
        //only has addFirst(), so add in reverse order
        BasicLinkedList<Integer> combined = new BasicLinkedList<>();
        node1 = firstList.getFirst();
        node2 = secondList.getFirst();
        ListNode<E> smaller;

        if (node1.getElement(); < node2.getElement()) {
            combined.head = node1;
            node1 = node1.getNext();
        } else {
            combined.head = node2;
            node2 = node2.getNext();
        }
        
        while (node1 != null && node2 != null) {//to reach last element
            if (node2.getElement() > node1.getElement()) {
                smaller = node2;
            } else {
                smaller = node1;
            }

            combined.add(smaller);
            if (smaller == node1) {
                node1 = node1.getNext();
                firstList.logicalRemove(smaller);
            } else {
                node2 = node2.getNext();
                secondList.logicalRemove(smaller);
            }
        }

        if (!firstList.isEmpty()) {
            for (Integer i: firstList) {
                combined.addFirst(i);
            }
        } else if (!secondList.isEmpty()) {
            for (Integer i: secondList) {
                combined.addFirst(i);
            }
        }
    }
    public void logicalRemove(ListNode<E> target) {
        //ignoring his "no reference to other nodes except by calling getNext()"
        ListNode<E> node = this.head;
        while (node.getNext() != target) {
            node = node.getNext(); //traverse through linkedlist to get to target
        }
        //node is the one before target
        node.next = target.getNext(); //can set like this meh???????? isn't next a protected attribute
        //much confuse
    }
}
