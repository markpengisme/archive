/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.*;
import java.util.Scanner;
/**
 *
 * @author wahaha
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        control();
    }
    
    public static void control()
    {
        Scanner scanner= new Scanner(System.in);
        int sel;
        
        System.out.println("輸入0來算階層\n輸入1來算組合");
        sel=scanner.nextInt();
        
        if(sel==0)
        {
            
            factorial(inputN());
        }
        else if(sel==1)
        {
            inputNM();
        }
        else
        {
            System.out.println("輸入錯誤");
        }
    }
    
     public static int inputN()
    {
        int a;
        
        Scanner scanner= new Scanner(System.in);
        System.out.print("請輸入n:");
        a=scanner.nextInt();
       
        
        return a;
    }
     
    public static void inputNM()
    {
        int a[]=new int[2];
        
        Scanner scanner= new Scanner(System.in);
        System.out.print("請輸入n和m(空格隔開):");
        a[0]=scanner.nextInt();
        a[1]=scanner.nextInt();
        System.out.println("ans="+caculate(a[0],a[1]));
    }
    
    public static void factorial(int n)
    {
        int result=1;
        
        for(int count=1;count<=n;count++)
        {
            result*=count;
        }
        System.out.println(result);
    }

    public static int caculate(int n,int m)
    {
        if (m>n)
        {
            return 0;
        }
        else if(m==0)
        {
            return 1;
        }    
        else
        {
            return caculate(n-1,m-1)+caculate(n-1,m);
        }
            
    }
}
