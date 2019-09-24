package javaBasic;

public class overWriteAndOverLoad {

    public static void test() {
        System.out.println("OverLoad 1");

    }

    public static void test(String test) {
        System.out.println("OverLoad 2" + test);
    }

    public void write() {
        System.out.println("OverWrite 1");
    }

}

class overWriteZi extends overWriteAndOverLoad {
    public void  write() {
        System.out.println("OverWrite 2");
    }
}
