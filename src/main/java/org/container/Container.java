package org.container;

public class Container<T> {
    private int capacity; // Максимальная вместимость хранилища
    private int size; // Текущий размер контейнера (количичество фактически добавленных элементов)
    private T[] arr; //массив, используемый для хранения

    // Увеличение максимальной ёмкости хранилища в случае переполнения
    private void resize() {
        capacity *= 2;
        T[] tempArr = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            tempArr[i] = arr[i];
        }
        arr = tempArr;
    }

    public Container(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = (T[]) new Object[capacity];
    }

    //Конструктор по умолчанию устанавливает максимальную емкость в 10 элементов
    public Container() {
        this(10);
    }

    public int getSize() {
        return size;
    }

}