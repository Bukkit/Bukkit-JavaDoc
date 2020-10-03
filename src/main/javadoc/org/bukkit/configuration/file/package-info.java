/**
 * Classes dedicated facilitating {@link 
 * org.bukkit.configuration.Configuration configurations} to be read and
 * stored on the filesystem.
 * <p>
 *

import java.util.Scanner;

public class scannerUser {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        double y = sc.nextDouble();
//        System.out.println(x);

//        String hello= sc.nextLine();
//        System.out.println(hello);

        int principal =sc.nextInt();
        float rate=sc.nextFloat();
        int time=sc.nextInt();

        float simpleInterest=principal*rate*time/100;
        System.out.println("simple interst is "+simpleInterest);
    }

}


