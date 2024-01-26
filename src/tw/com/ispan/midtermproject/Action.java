package tw.com.ispan.midtermproject1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.Scanner;

public class Action {

	public static void main(String[] args) {
		
		IVeterinaryHospitalDao vhDao = VeterinaryHospitalDaoFactory.createVeterinaryHospitalDaoFactory();
		try {
			vhDao.createConn();
			
			Scanner scan = new Scanner(System.in);		
			while (true) {
				System.out.println("請選擇功能：");
				System.out.println("(0) 退出程式");
				System.out.println("(1) 根據 ID 查詢機構的詳細資訊");
				System.out.println("(2) 新增機構資料");
				System.out.println("(3) 更改機構的電話與地址");
				System.out.println("(4) 根據 ID 刪除機構的資訊");
				System.out.println("(5) 根據 關鍵字 刪除機構的資訊 \n (字號、機構名稱、電話、地址 請擇一輸入)");
				
				int userInput = scan.nextInt();
				
				
				if (userInput == 0) {
					break;
				}
				if (userInput == 1) {
					System.out.println("請輸入欲查詢的ID");
					int userInputId = scan.nextInt();
					VeterinaryHospital vhfind = vhDao.findById(userInputId);
					if (vhfind != null) {
						System.out.println(vhfind.getId() + " " + vhfind.getCountry()+ " " + vhfind.getVeterinarianPracticeLicense() + " " +
								vhfind.getLicenseCategory()+ " " + vhfind.getLicenseStatus() + " " + vhfind.getName() + " " + vhfind.getVeterinarian() + " " +
								vhfind.getPhone() + " " + vhfind.getLicenseDate() + " " + vhfind.getAddress());
						BufferedWriter out = new BufferedWriter(new FileWriter("c:\\midtermproject\\UserId"+  userInputId + ".txt"));
						out.write(vhfind.getId() + " " + vhfind.getCountry()+ " " + vhfind.getVeterinarianPracticeLicense() + " " +
								vhfind.getLicenseCategory()+ " " + vhfind.getLicenseStatus() + " " + vhfind.getName() + " " + vhfind.getVeterinarian() + " " +
								vhfind.getPhone() + " " + vhfind.getLicenseDate() + " " + vhfind.getAddress());
						out.close();
					}else {
						System.out.println("查無資料");
					}
					
					
				}
				if (userInput == 2) {
					System.out.println("請輸入縣市 :");
					String userInputCountry = scan.next();
					System.out.println("請輸入字號 :");
					String userInputVeterinarianPracticeLicense = scan.next();
					System.out.println("請輸入執照類別 :");
					String userInputLicenseCategory = scan.next();
					System.out.println("請輸入執照狀態 :");
					String userInputLicenseStatus = scan.next();
					System.out.println("請輸入機構名稱 :");
					String userInputName = scan.next();
					System.out.println("請輸入負責獸醫 :");
					String userInputVeterinarian = scan.next();
					System.out.println("請輸入機構電話 :");
					String userInputPhone = scan.next();
					System.out.println("請輸入發照日期 :");
					String userInputLicenseDate = scan.next();
					System.out.println("請輸入機構地址 :");
					String userInputAddress = scan.next();
					VeterinaryHospital vhAdd = new VeterinaryHospital(userInputCountry,userInputVeterinarianPracticeLicense,userInputLicenseCategory,userInputLicenseStatus,
							userInputName,userInputVeterinarian,userInputPhone,userInputLicenseDate,userInputAddress);
					vhDao.add(vhAdd);
					
				}
				if (userInput == 3) {
					System.out.println("請輸入Id :");
					int userInputId = scan.nextInt();
					System.out.println("請輸入字號 :");
					String userInputVeterinarianPracticeLicense = scan.next();
					System.out.println("請輸入機構名稱 :");
					String userInputName = scan.next();
					
					System.out.println("請輸入修改後的電話 :");
					String userInputPhone = scan.next();
					System.out.println("請輸入修改後的地址 :");
					String userInputAddress = scan.next();
					
					VeterinaryHospital vhUpdate = new VeterinaryHospital(userInputPhone,userInputAddress,userInputId,userInputVeterinarianPracticeLicense ,	userInputName);			
					vhDao.update(vhUpdate);
					
				}
				if (userInput == 4) {
					System.out.println("請輸入Id :");
					int userInputId = scan.nextInt();
					vhDao.delete(userInputId);
				}
				if (userInput == 5) {
					System.out.println("請輸入關鍵字 :");
					String userkeyword = scan.next();
//					System.out.println("userkeyword :" + userkeyword);
					
					vhDao.deleteByKeyword(userkeyword);
				}
			}
			
			scan.close();

			vhDao.closeConn();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
