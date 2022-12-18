/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package os2.project;
import java.util.concurrent.locks.ReentrantLock ;
import java.util.concurrent.*;
import java.util.ArrayList;


public class resource implements Runnable{
    private String content;
    private ReentrantLock mutex; //lock
    private ArrayList<String> order=new ArrayList<String>();
    public int cont=0;   
//constructor
    public resource(){
      this.content="os2";
      mutex=new ReentrantLock();
  }  
  //excutable function 
  @Override
  public void run(){
    String r =Thread.currentThread().getName();
    order.add(r);   //queue that stores threads
 try { 
    while(!order.isEmpty()) {
    //[r,r,w,w]
    if(order.get(0)== "r" ){
        mutex.lock(); cont++;
        order.remove(0);
        System.out.println("reading now");
            while(!order.isEmpty() && order.get(0)=="r"){
                order.remove(0); cont++;
                System.out.println("reading now");
                }
         mutex.unlock();   
        if(order.isEmpty()){
            System.out.println("array is emptyy");
            break;}
            
            
            //that mean order(0) now is a writer !
            mutex.lock();
            order.remove(0);
            System.out.println("writting now");
//        System.out.println("the current content is: "+content);
//        Thread.sleep(1000); 
cont++;
        mutex.unlock();
       
    }


   else {
        mutex.lock();
        order.remove(0);
        System.out.println("writting now");
//      System.out.println("the current content is: "+content);
//        Thread.sleep(1000);
        mutex.unlock();
                
    
   }
    }
 }
    catch(Exception e){
            System.out.println(e.getMessage());
            }
    
  
  }
    public ArrayList get(){
    
    return this.order;
    }


}


