package javaBasic;


public class AbstractTest extends AbStractDome {

    public void make() {
        System.out.println("2");
    }

    public static void main(String[] a) {
        System.out.println("1");
        new AbstractTest().make();
    }
}
