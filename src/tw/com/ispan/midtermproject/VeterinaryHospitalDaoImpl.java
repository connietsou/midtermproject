package tw.com.ispan.midtermproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VeterinaryHospitalDaoImpl implements IVeterinaryHospitalDao{

	private Connection conn;
	private String sqlstr;

	@Override
	public void add(VeterinaryHospital vh) throws SQLException {
		
		sqlstr = "insert VeterinaryHospital (Country ,VeterinarianPracticeLicense, LicenseCategory, LicenseStatus, Name, Veterinarian, Phone, LicenseDate, Address) values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		
		state.setString(1,vh.getCountry());
		state.setString(2,vh.getVeterinarianPracticeLicense());
		state.setString(3,vh.getLicenseCategory());
		state.setString(4,vh.getLicenseStatus());
		state.setString(5,vh.getName());
		state.setString(6,vh.getVeterinarian());
		state.setString(7,vh.getPhone());
		state.setString(8,vh.getLicenseDate());
		state.setString(9,vh.getAddress());
		
		state.executeUpdate();
		state.close();

	}

	@Override
	public void update(VeterinaryHospital vh) throws SQLException {
		
		sqlstr = "update VeterinaryHospital set phone = ?,address = ? where id = ? and VeterinarianPracticeLicense = ? and name = ?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		
		state.setString(1, vh.getPhone());
		state.setString(2, vh.getAddress());
		state.setInt(3, vh.getId());
		state.setString(4, vh.getVeterinarianPracticeLicense());
		state.setString(5, vh.getName());
		
		state.executeUpdate();
		state.close();
	}

	@Override
	public void delete(int id) throws SQLException {
		
		sqlstr = "delete from VeterinaryHospital where id = ?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		
		state.setInt(1, id);
		
		state.executeUpdate();
		state.close();
		
	}

	@Override
	public VeterinaryHospital findById(int id) throws SQLException {
		
		sqlstr = "select * from VeterinaryHospital where id = ?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		
		state.setInt(1, id);
		
		ResultSet rs = state.executeQuery();
		VeterinaryHospital vh = null;
		if (rs.next()) {
			vh = new VeterinaryHospital(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));	
		}		
		

		rs.close();
		state.close();
		return vh;
	}

	@Override
	public void createConn() throws Exception {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String urlstr = "jdbc:sqlserver://localhost:1433;databaseName=Pets;user=watcher;password=p@ssw0rd;encrypt=true;trustServerCertificate=true";
		conn = DriverManager.getConnection(urlstr);
		System.out.println("Dao Connection Status:" + !conn.isClosed());
				
	}

	@Override
	public void closeConn() throws SQLException {
		
		if (conn != null) {
			conn.close();
		}
		System.out.println("Dao Connection Closed");
		
	}
	
	public void deleteByKeyword(String keyword) throws SQLException {
		
		Statement state = conn.createStatement();
		sqlstr = "delete from VeterinaryHospital where (name + VeterinarianPracticeLicense + Phone + Address) Like '%" + keyword +"%'";
		
//		System.out.println(sqlstr);
		
		state.execute(sqlstr);
		state.close();
	}

}
