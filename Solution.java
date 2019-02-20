package aa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import java.util.concurrent.ExecutionException;


//Pregunta 2
public class Solution {
	
	public static void main(String[] args) {
		final char a = 'a';
		final String[] countries = {"United States", "England", "Germany",
		"Netherlands", "Slovenia"};
		
		ExecutorService executor = Executors.newFixedThreadPool(5);

		Future<String> futureTask1 = executor.submit(() -> {
			return "index of "+ countries[0]+ " is " + countries[0].indexOf(a);
        });
		
		Future<String> futureTask2 = executor.submit(() -> {
			return "index of "+ countries[1]+ " is " + countries[1].indexOf(a);
        });
		
		Future<String> futureTask3 = executor.submit(() -> {
			return "index of "+ countries[2]+ " is " + countries[2].indexOf(a);
        });
		
		Future<String> futureTask4 = executor.submit(() -> {
          
            return "index of "+ countries[3]+ " is " + countries[3].indexOf(a);  });
		
		Future<String> futureTask5 = executor.submit(() -> {
          
            return "index of "+ countries[4]+ " is " + countries[4].indexOf(a); });
       
		
		try {
		
		 String result = futureTask1.get(5, TimeUnit.SECONDS);	
		 String result1 = futureTask2.get(10, TimeUnit.SECONDS);	
		 String result2 = futureTask3.get(15, TimeUnit.SECONDS);	
		 String result3 = futureTask4.get(20, TimeUnit.SECONDS);	
		 String result4 = futureTask5.get(25, TimeUnit.SECONDS);
		 
		 System.out.println(result);
		 System.out.println(result1);
		 System.out.println(result2);
		 System.out.println(result3);
		 System.out.println(result4);
	
		 


		 } catch (InterruptedException e) {// thread was interrupted
	            e.printStackTrace();
	        } catch (ExecutionException e) {// thread threw an exception
	            e.printStackTrace();
	        } catch (TimeoutException e) {// timeout before the future task is complete
	            e.printStackTrace();
	        } finally {

	            // shut down the executor manually
	            executor.shutdown();

	        }

	
	
}

}
