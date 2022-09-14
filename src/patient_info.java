import java.util.ArrayList;

public class patient_info {

	private String appointmentDate;
	private int patientID;
	private String patientFirstName;
	private String gender;
	private String dateOfBirth;
	private int phoneNumber;
	private String address;
	private String patientHistory;
	
	protected static ArrayList <patient_info> patientList = new ArrayList<>();
	protected static ArrayList <patient_info> doctorPatientList = new ArrayList<>();
	

	
	public void setAppointmentDate(String appointmentDate)
	{
		this.appointmentDate = appointmentDate;
	}
	
	public void setPatientId(int patientID)
	{
		this.patientID = patientID;
	}
	
	public void setPatientFirstName(String patientFirstName)
	{
		this.patientFirstName = patientFirstName;
	}
	
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	
	public void setPhoneNumber(int phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public void setPatientHistory(String patientHistory)
	{
		this.patientHistory = patientHistory;
	}
	
	//get methods
	
	public String getAppointmentDate()
	{
		return this.appointmentDate;
	}
	
	public int getPatientId()
	{
		return this.patientID;
	}
	
	public String getPatientFirstName()
	{
		return this.patientFirstName;
	}
	
	
	public String getGender()
	{
		return this.gender;
	}
	
	public String getDateOfBirth()
	{
		return this.dateOfBirth;
	}
	
	public int getPhoneNumber()
	{
		return this.phoneNumber;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public String getPatientHistory()
	{
		return this.patientHistory;
	}

}