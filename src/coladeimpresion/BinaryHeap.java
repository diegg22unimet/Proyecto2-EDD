/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coladeimpresion;

/**
 * Clase BinaryHeap, usada para representar una cola de prioridad, 
 * donde la prioridad viene dada de acuerdo a una variable tiempo
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
    
    //Inserta un elemento dentro del montículo
    public void insert(Register value) {
        if (getSize() == getCapacity()) {
            return;
        }
        
        size++;
        heap[getSize()] = value;
        int currentIndex = getSize();

        //Restaura la propiedad del montículo después de la inserción
        while (currentIndex > 1 && heap[currentIndex].getTime() < heap[currentIndex / 2].getTime()) {
            swap(currentIndex, currentIndex / 2);
            currentIndex = currentIndex / 2;
        }
    }
    
    //Elimina el mínimo elemento y lo retorna
    public Register extractMin() {
        if (isEmpty()) {
            System.out.println("Heap is empty. Cannot extract minimum.");
            return null; // Valor predeterminado si el montículo está vacío
        }

        Register min = heap[1];
        heap[1] = heap[getSize()];
        size--;

        //Restaura la propiedad del montículo después de la extracción
        heapify(1);

        return min;
    }
    
    //Encuentra el índice de un registro dado por parámetro
    public int findIndex(Register targetRegister) {
        for (int i = 1; i <= getSize(); i++) {
            if (heap[i] == targetRegister) {
                return i;
            }
        }
        return -1;
    }
    
    //Restaura las propiedades del montículo después de una operación
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
    
    //Actualiza la etiqueta de tiempo de un registro localizado en la posición dada por el índice
    public void updateRegisterValue(int index, int newTime) {
        if (index < 1 || index > getSize()) {
            System.out.println("Invalid index");
            return;
        }

        heap[index].setTime(newTime);

        //Comprueba si el valor modificado es menor que el valor de su padre
        while (index > 1 && heap[index].getTime() < heap[index / 2].getTime()) {
            swap(index, index / 2);
            index = index / 2;
        }

        //Después de la actualización, restaura las propiedades del montículo
        heapify(index);
    }
    
    private void swap(int i, int j) {
        Register temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    //Retorna un String con el contenido del montículo
    public String printHeap() {
        String result = "";
        for (int i = 1; i <= size; i++) {
            result += heap[i].getDocument().getName() + " (" + heap[i].getTime() + ") \n";
        }
        return result;
    }

}
