package org.container;

/**
 * Класс {@code Container} представляет собой универсальный контейнер для хранения элементов.
 * Этот контейнер поддерживает динамическое изменение емкости и позволяет добавлять, удалять
 * и получать элементы по индексу.
 *
 * @param <T> тип элементов, хранимых в контейнере
 */
public class Container<T> {
    /**
     * Максимальная вместимость контейнера. Это значение показывает, сколько элементов
     * может храниться в контейнере без необходимости увеличения емкости.
     */
    private int capacity;

    /**
     * Текущий размер контейнера, то есть количество фактически добавленных элементов.
     * Это значение всегда меньше или равно {@code capacity}.
     */
    private int size;

    /**
     * Массив, используемый для хранения элементов контейнера.
     * Массив имеет начальную емкость, заданную параметром {@code capacity}.
     */
    private T[] arr;

    /* -------------------------------- */

    /**
     * Увеличивает емкость контейнера в два раза, если он переполнен.
     * Этот метод вызывается автоматически при добавлении элементов, если контейнер заполнен.
     */
    private void resize() {
        capacity *= 2;
        T[] tempArr = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            tempArr[i] = arr[i];
        }
        arr = tempArr;
    }

    /**
     * Создает новый контейнер с указанной начальной емкостью.
     *
     * @param capacity начальная максимальная емкость контейнера
     * @throws IllegalArgumentException если указанная емкость меньше или равна нулю
     */
    public Container(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть больше нуля");
        }
        this.capacity = capacity;
        this.size = 0;
        this.arr = (T[]) new Object[capacity];
    }

    /**
     * Создает контейнер с максимальной начальной емкостью по умолчанию (10 элементов).
     */
    public Container() {
        this(10);
    }

    /**
     * Возвращает текущее количество элементов в контейнере.
     *
     * @return текущее количество элементов
     */
    public int getSize() {
        return size;
    }

    /**
     * Добавляет элемент в контейнер на заданную позицию.
     * Если на указанной позиции уже есть элемент, он сдвигается вместе с остальными элементами.
     * Если контейнер заполнен, его емкость увеличивается в два раза.
     *
     * @param element элемент, который нужно добавить
     * @param number  индекс, по которому нужно добавить элемент (от 0 до текущего размера)
     * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
     */
    public void add(T element, int number) {
        if (number > size || number < 0) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона: " + number);
        }

        if (size == capacity) {
            this.resize();
        }
        for (int i = size; i > number; i--) {
            arr[i] = arr[i - 1];
        }
        arr[number] = element;
        size++;
    }

    /**
     * Возвращает элемент, находящийся по указанному индексу.
     *
     * @param number индекс элемента, который нужно получить (от 0 до текущего размера - 1)
     * @return элемент, находящийся по заданному индексу
     * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
     */
    public T get(int number) {
        if (number >= size || number < 0) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона: " + number);
        }
        return arr[number];
    }

    /**
     * Удаляет элемент по заданному индексу и сдвигает оставшиеся элементы влево.
     *
     * @param number индекс элемента, который нужно удалить (от 0 до текущего размера - 1)
     * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
     */
    public void remove(int number) {
        if (number >= size || number < 0) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона: " + number);
        }

        for (int i = number; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }
}
