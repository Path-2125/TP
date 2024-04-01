/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.blc.training.tp;

/**
 *
 * @author patrick.poaty
 */
public class Util {
    
    public static void out (String msg){
        
        // 
        System.out.print(msg);
        
    }
    
    public static void checkLength(String arg, int size, String msg){
        if (arg.length() !=size){
            Util.out(msg);
            System.exit( 1);
        }
    }
    
    public static void checkLength(String arg, String msg){
        checkLength(arg,1, msg);
    }

    static class out {

        public out() {
        }
    }
    
}