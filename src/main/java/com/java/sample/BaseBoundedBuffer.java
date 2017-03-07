package com.java.sample;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * FIFO queue
 * 
 * @author uthiresh
 *
 * @param <V>
 */
public class BaseBoundedBuffer<V> {
	
	private final V[] buf;
	private int putPos, takePos, count;
	
	public BaseBoundedBuffer(int capacity){
		buf = (V[])new Object[capacity];
	}
	
	public synchronized void put(V v){
		try {
			if((count+1) == buf.length){
				wait();
			}
			if((putPos) == buf.length){
				putPos=0;
			}
			buf[putPos]= v;
			putPos++;
			count++;
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}finally{
			notifyAll();
		}
		
	}
	
	public synchronized V take(){
		try{
			if(count == 0 ){
				wait();
			}
			if((takePos) == buf.length){
				takePos=0;
			}
			V v = buf[takePos];
			takePos++;
			count--;
			return v;
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}finally{
			notifyAll();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Executor prod = Executors.newSingleThreadExecutor();
		Executor cons = Executors.newSingleThreadExecutor();
		final BaseBoundedBuffer<String> buf = new BaseBoundedBuffer<String>(10);
		
		prod.execute(new Runnable() {
			public void run() {
				try {
					for(int i=0;i<40;i++){
//						System.out.println("Putting :Obj-"+i );
						buf.put("Obj-"+i);
						Thread.sleep(500);
					}
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		});
		
		cons.execute(new Runnable() {
			public void run() {
				try {
					while(true) {
						System.out.println("taken: " +buf.take());
						Thread.sleep(2000);
					}
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		});
	}
}