/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coladeimpresion;

/**
 *
 * @author manza
 */
public class List<T> {
    private Node<T> head;
    private int size;

    public List() {
        this.head = null;
        this.size = 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty() {
        return getHead() == null;
    }
    
    public void append(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            setHead(node);
        } else {
            Node<T> pointer = getHead();
            while (pointer.getNext() != null) {                
                pointer = pointer.getNext();
            }
            pointer.setNext(node);
        }
    }
    
    public T get(int index) {
        if (isEmpty()) {
            return null;
        } else {
            if (index == 0) {
                return getHead().getData();
            } else {
                Node<T> pointer = getHead();
                int i = 1;
                while (pointer.getNext() != null) {                    
                    if (i == index) {
                        return pointer.getNext().getData();
                    } else {
                        pointer = pointer.getNext();
                        i++;
                    }
                }
            }
        }
        return null;
    }

    public void delete(Node node) {
        if (node == null) {
            return;
        }

        if (head == node) {
            head = head.getNext();
            return;
        }

        Node current = getHead();
        Node prev = null;
        while (current != null && current != node) {
            prev = current;
            current = current.getNext();
        }

        if (current == null) {
            return;
        }
	
	prev.setNext(current.getNext());
    }

}
