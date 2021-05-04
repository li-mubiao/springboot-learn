package com.lmb.hello.sort;

public class BoolTest {


    public static void main(String[] args) {

//        String[] arr ={"s-3341","ux331","kl72t"};
//        int add = add(arr);
//        System.out.println(add);

    //1,1,2,3,5,8,13,21,34,55,89,
//        int fibonacci = fibonacci(30);
//        System.out.println(fibonacci);
//        double a = (0.01*3)/(0.01*3+0.015*5);
//        System.out.println(a);
    }

    public static int add(String[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            String strings[] = arr[i].split("\\D+");
            if(strings.length==2){
                sum+=Integer.valueOf(strings[1]);
            }
        }
        return sum;
    }

    public static int fibonacci(int index){

        if(index == 1 || index ==2){

            return 1;
        }

        return fibonacci(index-1)+fibonacci(index-2);

    }


}
