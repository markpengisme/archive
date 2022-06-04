/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw6;

/**
 *
 * @author MarkPeng
 */
import java.io.*;

/**
 *
 * @author MarkPeng
 */
public class ID {

    /**
    *   id : ID card number
    *   numberArray : The city value represented by the first letter
    *   cityArray : The city name represented by the first letter.
    */
    
    String id;
    static int[] numberArray = {10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 33};    //A~Z
    static String[] cityArray = {
        //A~Z
        "Taipei City",  
        "Taichung City",
        "Keelung City",
        "Tainan City",
        "Kaohsiung City",
        "New Taipei City",
        "Yilan County",
        "Taoyuan City",
        "Chiayi City",
        "Hsinchu County",
        "Miaoli County",
        "Taichung County",
        "Nantou County",
        "Changhua County",
        "Hsinchu City",
        "Yunlin County",
        "Chiayi County",
        "Tainan County",
        "Kaohsiung County",
        "Pingtung County",
        "Hualien County",
        "Taitung County",
        "Kinmen County",
        "Penghu County",
        "Yangmingshan Management Bureau Taipei City",
        "Lienchiang County"
    };

    /**
     *
     * @param fileName
     * @return return file contents
     */
    public String readFile(String fileName){
        try{
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String line = null;
            StringBuilder data = new StringBuilder();
            while((line = br.readLine()) != null){
               data.append(line + "@");
            }
            br.close();
            fr.close();
            return data.toString();
            
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     *
     * @param correctFile   correct.txt
     * @param errorFile     error.txt
     * @param str           input.txt content
     */
    public void writeFile(String correctFile, String errorFile, String str){
        try{
            BufferedWriter bwCorrect = new BufferedWriter(new FileWriter(new File(correctFile)));
            BufferedWriter bwError = new BufferedWriter(new FileWriter(new File(errorFile)));
            
            String IDs[] = str.split("@");
            for (String ID : IDs ){
                this.id = ID;
                String result = checkID();
                switch (result){
                    case "case1":
                        bwCorrect.write(String.format("%s,\t%s\t%s\n",id,cityArray[id.charAt(0) - 65],
                       id.charAt(1)=='1'?"male":"female"));
                        break;
                        
                    case "case2":
                        bwError.write(String.format("%s,\t[Error]   Validation error\n",id));
                        break;
                    
                    case "case3":
                        bwError.write(String.format("%s,\t[Error]   Format error\n",id));
                        break;
                }
               
            }
            bwCorrect.close();
            bwError.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    /**
     *  Check ID is legal or not.
     * @return case
     */
    public String checkID(){
        if ( id.matches("[A-Z][1-2][0-9]{8}$")) {
            int sum = 0;
            int c = numberArray[id.charAt(0) - 65];

            // Start caculating the special value
            sum += c / 10 % 10 * 1;
            sum += c % 10 * 9;
            for (int i = 1; i < 9; i++) {
                sum += Character.getNumericValue(id.charAt(i)) * (9 - i);
            }
            sum += Character.getNumericValue(id.charAt(9));
            // End of the caculating

            if (sum % 10 == 0) {
               return "case1"; // Correct
            } else {
                return "case2"; // Validation error
            }
        } else {
            return "case3"; // Format error
        }
    }

}
