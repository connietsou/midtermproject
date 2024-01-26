package tw.com.ispan.midtermproject1;

public class VeterinaryHospitalDaoFactory {
	
	public static IVeterinaryHospitalDao createVeterinaryHospitalDaoFactory() {
		return new VeterinaryHospitalDaoImpl();
	}

}
