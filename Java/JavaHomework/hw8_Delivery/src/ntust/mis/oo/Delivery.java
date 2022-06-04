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
public class Delivery{
    private Person sender;
    private Person receiver;
    private Goods goods;
    private static final double MAX_WEIGHT = 100;
    private static double currentWeight = 0;

    public Delivery(Person Sender,Person Receiver,Goods Goods){
        this.sender=Sender;
        this.receiver=Receiver;
        this.goods=Goods;
    }

    public static double getAvailableWeight(){
        return MAX_WEIGHT-currentWeight;
    }

    public void send(){
        System.out.println("Previous remaining weight:"+getAvailableWeight());
        
        if(this.goods.getWeight()>getAvailableWeight()){
            System.out.println("not enough weight");
            System.out.println("remain weight:"+getAvailableWeight());
        }else{
            currentWeight+=this.goods.getWeight();
            System.out.println("remain Weight:"+getAvailableWeight());
        }
    }

    public String toString(){
        return "Sender:\t"+this.sender.toString()+"\nReceiver:"+
        this.receiver.toString()+"\nGoods:\t"+this.goods.toString();
    }
    
}
