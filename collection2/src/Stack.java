public class Stack<T> {
    private Node<T> current =null;
    public T pop(){
        T result = current.value;
        current = current.next;
        return result;
    }
    public boolean hasNext(){
        return current!=null;
    }
    public void push(T v){
        Node node = new Node(v,current);
        this.current=node;
    }
}
