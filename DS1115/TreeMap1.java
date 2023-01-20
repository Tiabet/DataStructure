package DS1115;
import java.util.*;  
class TreeMap1{  
 public static void main(String args[]){  
	 //TreeMap엔 자동으로 Key를 기준으로 Sorting됨
   TreeMap<Integer,String> map=new TreeMap<Integer,String>();    
      map.put(100,"Amit");    
      map.put(102,"Ravi");    
      map.put(101,"Vijay");    
      map.put(103,"Rahul");    
        
      for(Map.Entry m:map.entrySet()){    
       System.out.println(m.getKey()+" "+m.getValue());    
      }    
 }  
}  