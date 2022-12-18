/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package os2.project;

import java.util.ArrayList;
public class Os2Project {

    
    public static void main(String[] args) {
        resource2 g=new resource2();
        
        Thread t1=new Thread(g,"r");
        Thread t2=new Thread(g,"r");
        Thread t3=new Thread(g,"w");
        Thread t4=new Thread(g,"r");
        Thread t5=new Thread(g,"w");
        Thread t6=new Thread(g,"r");
        Thread t7=new Thread(g,"r");
        Thread t8=new Thread(g,"w");
        Thread t9=new Thread(g,"r");
        Thread t10=new Thread(g,"r");

        //run threads 
        
        
        t1.start();  
        t2.start();
        t3.start();  
        t4.start(); 
        t5.start();
        t6.start();  
        t7.start();
        t8.start(); 
        t9.start();
        t10.start();
      
   
    }
    
}
