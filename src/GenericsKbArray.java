import java.util.*;

public class GenericsKbArray
{
    GenericsKb[] data = new GenericsKb[100000];
    int size = 0;
    
    public void add(GenericsKb gen)
    {
        if (size < data.length) {
            data[size] = gen;
            size++;
        }
    }
    
  public void updateSize() {
    this.size = 0; // Reset size count
    for (GenericsKb kb : data) {
        if (kb != null) {
            this.size++; // Count only non-null elements
        }
    }
}

  /** public GenericsKb find(GenericsKb term) {
        for (GenericsKb statement : data) {
            if (statement != null && statement.contains(term)) {
                return statement;
            }
        }
        return null;
    }
    
    public void updateSize() {
        size = data.length;
    }*/
    
    public GenericsKb find(GenericsKb term) {
       String searchTerm = term.getTerm().toLowerCase(); // Case-insensitive search
       for (GenericsKb statement : data) {
          if (statement != null && statement.getTerm().toLowerCase().equals(searchTerm)) {
            return statement;
          }
       }
      return null;
    }
}	