
package persistencia;

import java.util.List;


public interface VeiculoDAO <ObjectGeneric> {
    
    public  void insert(ObjectGeneric objt) throws Exception;
    
    public  void update(ObjectGeneric objt) throws Exception;
    
    public  void delete(ObjectGeneric objt) throws Exception;
    
    public  List<ObjectGeneric> consult() throws Exception;
    
   
}
