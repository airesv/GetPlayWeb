/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.ipj.grupoa.EJB;

import java.util.Random;
import javax.ejb.Stateless;

/**
 *
 * @author Alvaro/Vitor
 */
@Stateless
public class RandomName {

    public RandomName() {
    }
    
    /**
     *
     * @param numchars
     * @return a Random Name
     */
    public String getRandomName(int numchars) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }
}