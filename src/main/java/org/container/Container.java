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

    // Добавляем элемент в определённое место по номеру
    public void add(T element, int number) {
        if (number > size || number < 0) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона: " + number);
        }

        if (size == capacity) {
            this.resize();
        }
        for (int i = number + 1; i <= size; i++) {
            arr[i] = arr[i - 1];
        }
        arr[number] = element;
        size++;
    }

    // Считываем значение n-го элемента
    public T get(int number) {
        if (number >= size || number < 0) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона: " + number);
        }
        return arr[number];
    }

    // Удаление элемента по заданному номеру
    public void remove(int number) {
        if (number >= size || number < 0) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона: " + number);
        }

        // Сдвигаем элементы влево после удаления
        for (int i = number; i <= size - 2; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

}