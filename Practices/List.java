class List {
    private Node head;
    private Node tail;

    public List(Node head) {
        this.head = head;
    }

    public void insertBefore(Node node, int val) {
        //assume list in ascending order
        int node_val = node.getVal();
        if (node != null) {
            if (val < node_val) {
                node.setVal(val);
                Node newNode = new Node(node_val);
                newNode.setNext(node.getNext());
                node.setNext(newNode);
            } else {
                if (node.getNext() != null) {
                    insertBefore(node.getNext(), val);
                } else {
                    node.setNext(new Node(val));
                }
            }
        }
    }

    public String toString() {
        Node node = head;
        String result = "";
        while (node != null) {
            result += node.getVal() + " ";
            node = node.getNext();
        }
        return result;
    }

    public static void main(String[] args) {
        Node node = new Node(14);
        List lst = new List(node);
        lst.insertBefore(node, 8);
        System.out.println(lst.toString());
    }
}
