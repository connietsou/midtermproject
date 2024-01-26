package tw.com.ispan.midtermimage;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import tw.com.jdbc.conn.ConnUtil;

public class Image {
	
	
	private Connection conn;
	private int Id;



	public void processAction() throws Exception {
		ConnUtil util = new ConnUtil();
		conn = util.createConn();
	
		imageStoreProcess();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("請輸入ID :");
			
		int userInput = scan.nextInt();
		
		imageRetrieveProcess(userInput);
			
		util.closeConn();
	}

	private void imageRetrieveProcess(int Id) throws SQLException, IOException {
		
		String sqlstr = "select * from Gallery where FileId=?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setInt(1, Id);
		ResultSet rs = state.executeQuery();
	
		if(rs.next()) {
			Blob blob = rs.getBlob(3);
			int length = (int)blob.length();
			System.out.println("length:" + length);
		
			BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream("c:/midtermproject/outputimage/ID_"+ Id +".jpg"));
			bos1.write(blob.getBytes(1, length));
			bos1.flush();
			bos1.close();
		
			rs.close();
			state.close();
		}
	}

	private void imageStoreProcess() throws SQLException, FileNotFoundException {
		
		FileInputStream fis1 = new FileInputStream("c:/midtermproject/image/images01.jpg");
	
		String sqlstr = "insert into Gallery(FileName, FileContent) values(?,?)";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setString(1, "images01");
		state.setBinaryStream(2, fis1);
		state.executeUpdate();
		state.close();
		System.out.println("File Stored");
	}



	public static void main(String[] args) {
		Image image = new Image();
		
		try {
			image.processAction();
					
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		}
	

}
