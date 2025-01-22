package orm.DAI;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;
import orm.DAO.CompanyDO;

import java.util.List;

public interface CompanyDAI extends BaseQuery {
    @Select("SELECT rowid,name,email,address," +
            "telephone,accountNumber,description" +
            " FROM company "+
            "WHERE name = ?{1}")
    CompanyDO getCompanyByName(String name);

    @Select("SELECT rowid,name,email,address," +
            "telephone,accountNumber,description" +
            " FROM company "+
            "WHERE rowid = ?{1}")
    CompanyDO getCompanyById(int id);

    @Select("SELECT * FROM company")
    List<CompanyDO> getAllCompanies();
}
