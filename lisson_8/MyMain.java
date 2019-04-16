package lisson_8;



public class MyMain {
    public static void main(String[] args) {

        DoubleHashingTableHash<String, Double> myTableHash = new DoubleHashingTableHash<>();

        System.out.println(myTableHash.getSize());

        myTableHash.put("Батат", 1.99);
        myTableHash.put("Картофель", 2.99);
        myTableHash.put("Топинамбур", 3.99);
        myTableHash.put("Брюква", 4.99);
        myTableHash.put("Морковь", 5.99);
        myTableHash.put("Пастернак", 6.99);
        myTableHash.put("Петрушка", 7.99);
        myTableHash.put("Редис", 8.99);
        myTableHash.put("Редька", 9.99);
        myTableHash.put("Дайкон", 10.99);
        myTableHash.put("Лоба", 11.99);
        myTableHash.put("Репа", 12.99);
        myTableHash.put("Свёкла", 13.99);
        myTableHash.put("Сельдерей", 14.99);
        myTableHash.put("Хрен", 15.99);
        myTableHash.put("Брокколи", 16.99);
        myTableHash.put("Кольраби", 17.99);

        System.out.println(myTableHash.get("Батат"));
        System.out.println(myTableHash.get("Картофель"));
        System.out.println(myTableHash.get("Топинамбур"));
        System.out.println(myTableHash.get("Брюква"));
        System.out.println(myTableHash.get("Морковь"));
        System.out.println(myTableHash.get("Пастернак"));
        System.out.println(myTableHash.get("Петрушка"));
        System.out.println(myTableHash.get("Редис"));
        System.out.println(myTableHash.get("Редька"));
        System.out.println(myTableHash.get("Дайкон"));
        System.out.println(myTableHash.get("Лоба"));
        System.out.println(myTableHash.get("Репа"));
        System.out.println(myTableHash.get("Свёкла"));
        System.out.println(myTableHash.get("Сельдерей"));
        System.out.println(myTableHash.get("Хрен"));
        System.out.println(myTableHash.get("Брокколи"));
        System.out.println(myTableHash.get("Кольраби"));

        System.out.println(myTableHash.getSize());

//        myTableHash.delete("Свёкла");
//        myTableHash.delete("Сельдерей");
//        myTableHash.delete("Хрен");
//        myTableHash.delete("Брокколи");
//        myTableHash.delete("Кольраби");
//
//        System.out.println();
//        System.out.println(myTableHash.get("Батат"));
//        System.out.println(myTableHash.get("Картофель"));
//        System.out.println(myTableHash.get("Топинамбур"));
//        System.out.println(myTableHash.get("Морковь"));
//        System.out.println(myTableHash.get("Пастернак"));
//        System.out.println(myTableHash.get("Петрушка"));
//        System.out.println(myTableHash.get("Редис"));
//        System.out.println(myTableHash.get("Редька"));
//        System.out.println(myTableHash.get("Дайкон"));
//        System.out.println(myTableHash.get("Лоба"));
//        System.out.println(myTableHash.get("Репа"));
//        System.out.println(myTableHash.get("Свёкла"));
//        System.out.println(myTableHash.get("Сельдерей"));
//        System.out.println(myTableHash.get("Хрен"));
//        System.out.println(myTableHash.get("Брокколи"));
//        System.out.println(myTableHash.get("Кольраби"));
//        System.out.println(myTableHash.getSize());
    }
}
