package org.container;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    @Test
    void testAddAndGet() {
        Container<String> container = new Container<>(5);
        container.add("First", 0);
        container.add("Second", 1);
        container.add("Third", 2);

        assertEquals(3, container.getSize(), "Размер контейнера должен быть 3");
        assertEquals("First", container.get(0));
        assertEquals("Second", container.get(1));
        assertEquals("Third", container.get(2));
    }

    @Test
    void testResize() {
        Container<Integer> container = new Container<>(2);
        container.add(1, 0);
        container.add(2, 1);
        container.add(3, 2); // Должен вызвать resize()

        assertEquals(3, container.getSize());
        assertEquals(1, container.get(0));
        assertEquals(2, container.get(1));
        assertEquals(3, container.get(2));
    }

    @Test
    void testRemove() {
        Container<String> container = new Container<>(5);
        container.add("First", 0);
        container.add("Second", 1);
        container.add("Third", 2);

        container.remove(1); // Удалим элемент с индексом 1 (Second)

        assertEquals(2, container.getSize());
        assertEquals("First", container.get(0));
        assertEquals("Third", container.get(1));
    }

    @Test
    void testAddWithIndexOutOfBounds() {
        Container<String> container = new Container<>(5);

        assertThrows(IndexOutOfBoundsException.class, () -> container.add("First", 1));
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(0));
    }

    @Test
    void testRemoveWithIndexOutOfBounds() {
        Container<String> container = new Container<>(5);

        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(0));
        container.add("First", 0);
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(1));
    }

    @Test
    void testDefaultConstructor() {
        Container<Integer> container = new Container<>();
        assertEquals(0, container.getSize());
        assertDoesNotThrow(() -> container.add(1, 0));
    }
}
