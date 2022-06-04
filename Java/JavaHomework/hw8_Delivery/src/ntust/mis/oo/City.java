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
public enum City {
    TAIPEI, TAICHUNG, KAOHSIUNG, HSINCHU, HUALIEN, Nan;

    public static City getCity(String c){
        switch(c){
            case "1":
                return TAIPEI;
            case "2":
                return TAICHUNG;
            case "3":
                return KAOHSIUNG;
            case "4":
                return HSINCHU;
            case "5":
                return HUALIEN;
            default:
                return Nan;
        }
    }
}
