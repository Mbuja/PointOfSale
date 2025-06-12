package orm.DAI;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;
import orm.DAO.ProductDO;
import java.util.List;

public interface ProductDAI extends BaseQuery{


    @Select("SELECT id,name,company,price,"+
    "description,serial_no "+
    "FROM product "+ 
    " WHERE id = ?{1}")
    ProductDO getProductById(String id);

    @Select("SELECT id,name,company,price"+
    "description,serial_no "+
    "FROM product "+
    "WHERE serial_no = ?{1}")
    ProductDO getProductBySerial(String serialNo);

    @Select("SELECT * FROM product")
    List<ProductDO> getProductsByCompany(String company);
    
}
