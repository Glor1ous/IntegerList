package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayListImplementation list = new ArrayListImplementation();

        System.out.println("Список пуст? " + list.isEmpty());

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Размер списка: " + list.size());
        System.out.println("Элементы в списке: " + Arrays.toString(list.toArray()));

        list.add(2, 25);
        System.out.println("Элементы в списке после добавления '25' с индексом 2: " + Arrays.toString(list.toArray()));

        Integer replacedElement = list.set(1, 15);
        System.out.println("Замененный элемент: " + replacedElement);
        System.out.println("Элементы в списке после замены '20' на '15': " + Arrays.toString(list.toArray()));

        Integer removedElement = list.remove(2);
        System.out.println("Удаленный элемент: " + removedElement);
        System.out.println("Элементы в списке после удаления элемента с индексом 2: " + Arrays.toString(list.toArray()));

        System.out.println("Содержит ли список число '40'? " + list.contains(40));
        System.out.println("Есть ли в списке число '50'? " + list.contains(50));

        System.out.println("Индекс '10': " + list.indexOf(10));
        System.out.println("Последний индекс '40': " + list.lastIndexOf(40));

        list.clear();
        System.out.println("Пуст ли список после очистки? " + list.isEmpty());
    }
}

