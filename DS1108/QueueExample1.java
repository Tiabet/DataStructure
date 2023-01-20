package DS1108;

import java.util.*;

public class  QueueExample1
{
 public static void main(String[] args) 
 {
  LinkedList<String> queue=new LinkedList<String>();
  queue.offer("≈‰±‚");
  queue.offer("ªÁΩø");
  queue.offer("»£∂˚¿Ã");
  while(!queue.isEmpty()){
    String str=queue.poll();   
    System.out.println(str);
  }//while
  
 }//main
}//class
