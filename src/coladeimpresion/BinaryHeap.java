/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coladeimpresion;

/**
 *
 * @author manza
 */
public class BinaryHeap {
    private Register[] heap;
    private int size;
    private int capacity;

    public BinaryHeap(int capacity) {
        this.heap = new Register[capacity + 1];
        this.size = 0;
        this.capacity = capacity;
    }

    public Register[] getHeap() {
        return heap;
    }

    public void setHeap(Register[] heap) {
        this.heap = heap;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void insert(Register value) {
        if (getSize() == getCapacity()) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }
        
        size++;
        heap[getSize()] = value;
        int currentIndex = getSize();

        // Restaurar la propiedad del montículo después de la inserción
        while (currentIndex > 1 && heap[currentIndex].getTime() < heap[currentIndex / 2].getTime()) {
            swap(currentIndex, currentIndex / 2);
            currentIndex = currentIndex / 2;
        }
    }
    
    public Register extractMin() {
        if (isEmpty()) {
            System.out.println("Heap is empty. Cannot extract minimum.");
            return null; // Valor predeterminado si el montículo está vacío
        }

        Register min = heap[1];
        heap[1] = heap[size];
        size--;

        // Restaurar la propiedad del min-heap después de la extracción
        heapify(1);

        return min;
    }
    
    private void heapify(int index) {
        int smallest = index;
        int leftChild = 2 * index;
        int rightChild = 2 * index + 1;

        if (leftChild <= getSize() && heap[leftChild].getTime() < heap[smallest].getTime()) {
            smallest = leftChild;
        }

        if (rightChild <= getSize() && heap[rightChild].getTime() < heap[smallest].getTime()) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }
    
    private void swap(int i, int j) {
        Register temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}
