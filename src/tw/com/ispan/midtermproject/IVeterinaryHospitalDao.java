package tw.com.ispan.midtermproject1;

import java.sql.SQLException;

public interface IVeterinaryHospitalDao {
	public void add (VeterinaryHospital vh) throws SQLException;
	public void update (VeterinaryHospital vh) throws SQLException;
	public void delete (int id) throws SQLException;
	public VeterinaryHospital findById (int id) throws SQLException;
	
	public void createConn() throws Exception;
	public void closeConn() throws SQLException;
	
	public void deleteByKeyword(String key) throws SQLException;

}
