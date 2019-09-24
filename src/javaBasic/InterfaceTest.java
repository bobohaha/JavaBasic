package javaBasic;

public class InterfaceTest implements  InterfaceOne{
    @Override
    public void showInfo() {
        System.out.println("success");
    }

    public static void main(String[] args) {
        InterfaceTest ift = new InterfaceTest();
        ift.showInfo();
        System.out.println(InterfaceOne.name);
    }
}
