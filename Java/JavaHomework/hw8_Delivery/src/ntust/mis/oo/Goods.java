/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntust.mis.oo;

/**
 *
 * @author MarkPeng
 */
public class Goods{
    private String name;
    private double weight;
    private Type type;
    
    public Goods(String Name,double Weight,Type Type){
        this.name=Name;
        this.setWeight(Weight);
        this.type=Type;
    }

    private void setWeight(double Weight){
        if(Weight<=(double)50){
            this.weight=Weight;
        }else{
            System.out.println("Goods too heavy,will not add product");
            this.weight=0;
        }
    }

    public double getWeight(){
        return this.weight;
    }

    public String toString(){
        String output = String.format("%s-%.1f-%s", this.name, this.weight, this.type);
        return output;
    }
}