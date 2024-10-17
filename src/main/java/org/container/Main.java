package org.container;

public class Main {
    public static void main(String[] args) {
        Container<String> container = new Container<>();

        container.add("Первый",0);
        container.add("Второй",1);
        container.add("Третий",2);

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