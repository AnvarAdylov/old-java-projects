/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworkseapplication;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



/**
 *
 * @author Anvar Adylov
 */
public class FirstProblem implements Callable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future result = service.submit(new FirstProblem());
        System.out.println(result.get());
        }

    @Override
    public Object call() throws Exception {
        Thread.sleep(100);
        return "String";
    }
}
