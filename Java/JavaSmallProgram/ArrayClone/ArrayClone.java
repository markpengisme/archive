/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.*;
/**
 *
 * @author wahaha
 */
public class ArrayClone
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int score[][]={{85,78,65},{75},{63,95},{12,34,96}};
        int ary[];
        ary=score[3].clone();
        for(int i=0;i<ary.length;i++)
        {
            System.out.println(ary[i]+"\t");
        }
          
    }
    
}
