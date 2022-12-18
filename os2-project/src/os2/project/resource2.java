/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package os2.project;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class resource2 implements Runnable {
    Semaphore mutex=new Semaphore(1);
//    Semaphore l=new Semaphore(1);
//    Semaphore in_mutex=new Semaphore(1);
//    AtomicInteger count=new AtomicInteger(0);
    
    public int x=0;
    
    @Override 
    public void run(){
        String name=Thread.currentThread().getName();
        if(name=="w")//we will write now
        {

            try {
                mutex.acquire(); //lock 
            } catch (InterruptedException ex) {
                Logger.getLogger(resource2.class.getName()).log(Level.SEVERE, null, ex);
            }
            x++;
            System.out.println("this thread is writting now x :"+x);
                mutex.release(); //unlock 

        
        }
        else{
            try {
                //we will read
                
                mutex.acquire(); //lock 
            } catch (InterruptedException ex) {
                Logger.getLogger(resource2.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("this thread is reading now x: "+x);
                 mutex.release();
        }
       
    }
    
    
}
