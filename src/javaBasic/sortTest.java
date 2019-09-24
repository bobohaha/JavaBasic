package javaBasic;

public class sortTest {

    public static void main(String[] args){
        int[] Number = {4,9,3,6,8,1,5};

        for(int k = 0; k < Number.length; k++) {
            System.out.print(Number[k] + ",");
        }
        System.out.println("============================");

        int[] sortNumber = sortNumber(Number);

        for(int i = 0; i < sortNumber.length; i++) {
            System.out.print(sortNumber[i]);
        }
    }

    private static int[] sortNumber(int[] number) {

        for (int i = 0; i < number.length -1; i++) {
            for (int j = 0; j < number.length -1 -i; j++) {
                if (number[j] > number[j+1]) {
                    int num = number[j];
                    number[j] = number[j+1];
                    number[j + 1] = num;
                }
            }

            for (int a = 0; a<number.length; a++) {
                System.out.print(number[a] + ",");
                if (a == number.length-1)  {
                    System.out.println("+++++++++++++++++++++++++++++++++");
                }
            }
        }

        return number;
    }
}
