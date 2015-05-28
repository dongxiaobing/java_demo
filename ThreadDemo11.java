package io;

import java.util.ArrayList;
import java.util.List;

class hello implements Runnable {
	private static String s=null;
	private static String dxb[]=null;
	private static List<String> l=null;
    public void run() {
            synchronized (this) {
            	for(int i=0;i<100;i++){
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(l.get(i));
            	}
            }
            }
    public static void main(String[] args) {
      	
    	    l=new ArrayList<String>();
    	    for(int i=0;i<100;i++){
    	    		l.add(String.valueOf(i));
    	    }
    	    for(int y=0;y<5;y++){
    	    	hello he=new hello();
        Thread h1=new Thread(he);
        h1.start();
    	    }
    }
}