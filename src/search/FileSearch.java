package search;  
  
import java.util.List;  
  
public class FileSearch implements Search {  
  
    @Override  
    public List  search(String keyword) {  
        System.out.println("now use file system search. keyword:" + keyword);  
        return null;  
    }  
  
}