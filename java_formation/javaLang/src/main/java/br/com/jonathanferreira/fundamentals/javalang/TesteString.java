package br.com.jonathanferreira.fundamentals.javalang;

public class TesteString {
    public static void main(String[] args) {
        int a = 3;
        String name = "Jonathan";
        //var anotherWay = new String("Testing");

        var formattedName = name.replace("J", "j");
        var upperCaseName = name.toUpperCase();
        System.out.println("lowercase J: " + formattedName);
        System.out.println("uppercase: " + upperCaseName);

        var foundChar = name.charAt(4);
        System.out.println("char at index 4: " + foundChar);

        var subName = name.substring(1, 5);
        System.out.println("subString: " + subName);

        var nameLength = name.length();
        System.out.println("nameLength: " + nameLength);

        boolean emptyName = name.isEmpty();
        System.out.println("empty? " + emptyName);

        var trimmedName = name.trim();

        boolean containsA = name.contains("a");


    }
}
