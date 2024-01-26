package tw.com.ispan.midtermproject1;

public class VeterinaryHospital {
	
	private int Id;
	private String Country;
	private String VeterinarianPracticeLicense;
	private String LicenseCategory;
	private String LicenseStatus;
	private String Name;
	private String Veterinarian;
	private String Phone;
	private String LicenseDate;
	private String Address;
	
	public VeterinaryHospital() {
		
	}
	
	public VeterinaryHospital(String Country,String VeterinarianPracticeLicense,String LicenseCategory,String LicenseStatus,String Name,String Veterinarian,String Phone,String LicenseDate,String Address) {
		
		this.Country = Country;
		this.VeterinarianPracticeLicense = VeterinarianPracticeLicense;
		this.LicenseCategory = LicenseCategory;
		this.LicenseStatus = LicenseStatus;
		this.Name = Name;
		this.Veterinarian = Veterinarian;
		this.Phone = Phone;
		this.LicenseDate = LicenseDate;
		this.Address = Address;
		
	}
	
	public VeterinaryHospital(String Phone,String Address,int Id,String VeterinarianPracticeLicense,String Name) {
		
		this.Id = Id;
		this.VeterinarianPracticeLicense = VeterinarianPracticeLicense;
		this.Name = Name;
		this.Phone = Phone;
		this.Address = Address;
		
	}
	
	public VeterinaryHospital(String Name) {
		this.Name = Name;
	}


	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String Country) {
		this.Country = Country;
	}

	public String getVeterinarianPracticeLicense() {
		return VeterinarianPracticeLicense;
	}

	public void setVeterinarianPracticeLicense(String VeterinarianPracticeLicense) {
		this.VeterinarianPracticeLicense = VeterinarianPracticeLicense;
	}

	public String getLicenseCategory() {
		return LicenseCategory;
	}

	public void setLicenseCategory(String LicenseCategory) {
		this.LicenseCategory = LicenseCategory;
	}

	public String getLicenseStatus() {
		return LicenseStatus;
	}

	public void setLicenseStatus(String LicenseStatus) {
		this.LicenseStatus = LicenseStatus;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getVeterinarian() {
		return Veterinarian;
	}

	public void setVeterinarian(String Veterinarian) {
		this.Veterinarian = Veterinarian;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
	}

	public String getLicenseDate() {
		return LicenseDate;
	}

	public void setLicenseDate(String LicenseDate) {
		this.LicenseDate = LicenseDate;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}
	
	

}
