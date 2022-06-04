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
public enum Type{
    PERSONAL,BUSSINESS,Nan;
    
    public static Type getType(String c){
        switch(c){
            case "1":
                return PERSONAL;
            case "2":
                return BUSSINESS;
            default:
                return Nan;
        }
    }
}
