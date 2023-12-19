public class Lab07 {
    public static void main(String[] args) {

        HashMapSet<String> Myset = new HashMapSet<>();

        Myset.add("Apple");
        Myset.add("Banana");

        System.out.println("Size of the set: " + Myset.size());


        System.out.println("Contains 'Banana': " + Myset.contains("Banana"));
        System.out.println("Contains 'Grapes': " + Myset.contains("Grapes"));


        System.out.println("Elements in the set:");
        for (String element : Myset) {
            System.out.println(element);
        }


        Myset.remove("Apple");
        System.out.println("After removing 'Apple':");
        for (String element : Myset) {
            System.out.println(element);
        }


        Myset.clear();
        System.out.println("After clearing the set, size: " + Myset.size());


        System.out.println(Myset.equals("Apple"));
    }
}
