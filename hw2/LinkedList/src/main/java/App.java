import ru.miroshka.ArrayList.Array;
import ru.miroshka.ArrayList.MyArrayList;
import ru.miroshka.LinkedList.MyLinkedList;

public class App {
    public static void main(String[] args) {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.addLast("Первый элемент");
        stringMyLinkedList.addLast("Второй элемент");
        System.out.println("Размер двунаправленного списка - " + stringMyLinkedList.size());
        System.out.println("Запрашиваем первый элемент коллекции");
        System.out.println(stringMyLinkedList.getValueByIndex(0));
        stringMyLinkedList.addFirst("Теперь я первый элемент");
        System.out.println("Размер двунаправленного списка - " + stringMyLinkedList.size());
        System.out.println("Запрашиваем первый элемент коллекции");
        System.out.println(stringMyLinkedList.getValueByIndex(0));
        System.out.println();
        System.out.println("Распечатаем всю коллекцию:");
        for (String str:stringMyLinkedList) {
            System.out.println(str);
        }

        System.out.println();
        System.out.println("Найдем индекс элемента по значению - 'Второй элемент' ");
        System.out.println(stringMyLinkedList.getIndexByValue("Второй элемент"));
        System.out.println();
        System.out.println("Распечатаем всю коллекцию:");
        for (String str:stringMyLinkedList) {
            System.out.println(str);
        }
        System.out.println();
        System.out.println("Удалим первый элемент массива");
        stringMyLinkedList.remove(0);
        System.out.println();
        System.out.println("Распечатаем всю коллекцию:");
        for (String str:stringMyLinkedList) {
            System.out.println(str);
        }


        System.out.println();
        System.out.println();
        System.out.println("Проверяем MyArrayList");
        Array<String> stringArray = new MyArrayList<>();
        stringArray.add("Первый элемент");
        stringArray.add("Второй элемент");
        stringArray.add("Третий элемент");

        System.out.println();
        System.out.println("Получим значение массив по индексу 1");
        System.out.println(stringArray.get(1));
        System.out.println();
        System.out.println("Размер массива:");
        System.out.println(stringArray.size());
        System.out.println();
        System.out.println("Проверим метода update - заменим 2 элемент на '2':");
        stringArray.update(1,"2");
        System.out.println("Получим значение массив по индексу 1");
        System.out.println(stringArray.get(1));

        System.out.println();
        System.out.println("Распечатаем полностью массив");
        for (String s :stringArray){
            System.out.println(s);
        }
        System.out.println();
        System.out.println("Удалим элемент 2 с индексом 1:");
        stringArray.remove(1);
        System.out.println("Получим значение массив по индексу 1");
        System.out.println(stringArray.get(1));

        System.out.println();
        System.out.println("Распечатаем полностью массив");
        for (String s :stringArray){
            System.out.println(s);
        }

        System.out.println();
        System.out.println("Получим индекс массива по значению 'Третий элемент'");
        System.out.println(stringArray.getIndexFromValue("Третий элемент"));
    }
}
