package org.container;

public class ContainerRunner {
    public static void main(String[] args) {
        Container<String> container = new Container<>();

        container.add("Первый",1);
        container.add("Второй",2);
        container.add("Третий",3);

        System.out.println("Количество элементов в контейнере: " + container.getSize());

        for (int i = 0; i < container.getSize(); i++) {
            System.out.println("Элемент на позиции " + i + ": " + container.get(i));
        }

        container.remove(2);
        System.out.println("\nПосле удаления второго элемента:");

        System.out.println("Количество элементов в контейнере: " + container.getSize());
        for (int i = 0; i < container.getSize(); i++) {
            System.out.println("Элемент на позиции " + i + ": " + container.get(i));
        }
    }
}