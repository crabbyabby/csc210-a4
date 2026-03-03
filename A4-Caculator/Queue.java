public class Queue<T> implements QueueADT<T>{

    private NodeSL<T> head;
    private NodeSL<T> tail;
    private int size;


    Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /** Add item onto tail of queue
     * @param value element to add */
    public void enqueue(T value) {
        if (isEmpty()) {
            NodeSL<T> newNode = new NodeSL<T>(value, null);
            this.head = newNode;
            this.tail = newNode;
            this.size++;
        } else {
            NodeSL<T> newNode = new NodeSL<T>(value, null);
            this.tail.setNext(newNode);
            this.tail = newNode;
            this.size++;
        }
    }

    /** Remove head item from the queue
     * @return element at head of queue 
     * @throws IndexOutOfBoundsException if queue is empty
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot dequeue empty queue.");
        } else {
            T data = this.head.getData();
            this.head = this.head.getNext();
            this.size--;
            return data;
        }
    }

    /** Returns head item from the queue without removing
     * @return element at head of queue 
     * @throws IndexOutOfBoundsException if queue is empty
     */
    public T peek(){
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot dequeue empty queue.");
        } else {
            return this.head.getData();
        }
    }

    /** Returns true if there are no elements to remove
     * @return true if queue is empty, false otherwise */
    public boolean isEmpty(){
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    /** Returns number of elements in the queue
     * @return number of elements */
    public int size(){
        return this.size;
    }
}
