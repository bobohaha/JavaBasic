package javaBasic;

public class danli {

    public static final danli dl = null;

    private danli(){}
    public danli getDanLi () {

        if (dl == null) {

            return new danli();
        }

        return dl;
    }
}
