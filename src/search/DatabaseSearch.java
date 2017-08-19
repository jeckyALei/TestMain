package search;  
  
import java.util.List;  
  
public class DatabaseSearch implements Search {  
  
    @Override  
    public List  search(String keyword) {  
        System.out.println("now use database search. keyword:" + keyword);  
        return null;  
    }  
  
}  