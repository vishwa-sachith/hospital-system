/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasess;

import java.util.Random;

/**
 *
 * @author Asus
 */
public class Random_Password {
    public int get_Random_Password() {
        Random random = new Random();
        int number = 0;
        for (int counter = 1; counter <= 1; counter++) {
            number = random.nextInt(100000) + random.nextInt(100000) + random.nextInt(100000) + random.nextInt(100000) + random.nextInt(100000) + random.nextInt(100000);;
        }
        return number;
    }  
}
