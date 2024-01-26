package tw.com.ispan.midtermproject1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tw.com.jdbc.conn.ConnUtil;

public class FileInput {
	
	private Connection conn;

	public void FileInputAction() throws Exception {
		ConnUtil util = new ConnUtil();
		conn = util.createConn();
		
		BufferedFileInput();
		
		util.closeConn();
	}

	public void BufferedFileInput() throws SQLException, IOException {
	
	BufferedReader bis = new BufferedReader (new FileReader("c:\\midtermproject\\source\\VeterinaryHospital.csv"));
//	BufferedReader bis = new BufferedReader (new FileReader("c:\\midtermproject\\source\\test.csv"));
	
	String fileLine = null;
	while ((fileLine = bis.readLine()) != null) {
		
		String [] array = fileLine.split(",");
//		System.out.println(fileLine);
		for(int i = 0; i < array.length; i++) {
//			System.out.println(array[i]);
		}
		String sqlstr = "insert VeterinaryHospital (Country ,VeterinarianPracticeLicense, LicenseCategory, LicenseStatus, Name, Veterinarian, Phone, LicenseDate, Address) values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		
		state.setString(1,array[0]);
		state.setString(2,array[1]);
		state.setString(3,array[2]);
		state.setString(4,array[3]);
		state.setString(5,array[4]);
		state.setString(6,array[5]);
		state.setString(7,array[6]);
		state.setString(8,array[7]);
		state.setString(9,array[8]);
		
		state.execute();
		state.close();
		
	}

	}
	
	public static void main(String[] args) throws Exception {
		FileInput test = new FileInput();
		test.FileInputAction();
	}
	
	
	

}
