package DS1108;
import java.util.*;

public class  LinkedListExample2
{
 public static void main(String[] args) 
 {
      LinkedList<String> list=new LinkedList<String>(); 
  
      list.add("����");
      list.add("���ξ���");
      list.add("�ٳ���");
      Iterator<String> iterator=list.iterator();
      while(iterator.hasNext()){
           String str=iterator.next();
           System.out.println(str);
      }//while


 }//main
}//class
