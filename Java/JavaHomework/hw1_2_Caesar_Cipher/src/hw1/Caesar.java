/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;
/**
 *
 * @author MarkPeng
 */
public class Caesar {

    private String plainText;
    private int key;
    private String cypherText="";

    
     /**
     * 
     * Set plaintext
     * @param plainText
     */
    public void setPlainText(String plainText) {

        this.plainText = plainText;
    }

    /**
     * Set key
     * @param key
     */
    public void setKey(int key) {

        this.key = key;
    }

    /**
     *
     * Use plainText and key to generate cypherText
     * @param plainText
     * @param key
     */
    public void generateCypher(String plainText, int key) {
        
        int index;
        char letter;
        String alphabet = "qwertyuiopasdfghjklzxcvbnm";
        
        // iterate and encrypt plainText
        for (int i = 0; i < plainText.length(); i++) {
            letter = plainText.charAt(i);
            index = alphabet.indexOf(Character.toLowerCase(letter));
            if (index != -1)
            {
                index = (index+key)%26;
                this.cypherText += alphabet.charAt(index);
            }
            else
            {
                System.out.printf("\"%s\" is not a letter,So it can not be encrypted\n",letter);
                this.cypherText += letter;
            }
           
        }
    }

    /**
     *  Display Caesar{key,plaintext,cypher text}
     */
    public void displayCypher() {
        
        System.out.printf("Caesar{key=%d,\tplainText=%s,\tcypherText=%s}\n",
                this.key, this.plainText, this.cypherText);
    }

}
