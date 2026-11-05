package br.com.gabriel.basicsyntax;

public class Program02PrimitiveTypes {
    public static void main(String[] args) {
        // 1 Byte integer (from -128 to 127)
        byte byteVariable = 10;
        // 2 Bytes integer (from -32,768 to 32,767)
        short shortVariable = 32_767;
        // 4 Bytes integer (from -2,147,483,648 to 2,147,483,647)
        int intVariable = 2_000_000_000;
        // 8 Bytes integer (from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807)
        long longVariable = 9_000_000_000_000_000_000L;
        // 4 Bytes floating point (approx. 7 decimal digits precision)
        float floatVariable = 1.1234567F;
        // 8 Bytes floating point (approx. 15–16 decimal digits precision)
        double doubleVariable = 2.1234567890123456;
        // 2 Bytes character (Unicode)
        char charVariable = 'a';
        // Boolean (true or false, stored as 1 byte in JVM)
        boolean booleanVariable = true;

        // Printing
        System.out.println("byte: "+byteVariable);
        System.out.println("short: "+shortVariable);
        System.out.println("int: "+intVariable);
        System.out.println("long: "+longVariable);
        System.out.println("float: "+floatVariable);
        System.out.println("double: "+doubleVariable);
        System.out.println("char: "+charVariable);
        System.out.println("boolean: "+booleanVariable);
    }
}
