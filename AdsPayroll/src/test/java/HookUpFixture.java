
public class HookUpFixture  {


	public String firstName;
	public String lastName;

	public void setFirstName(String aString){
		firstName = aString;
	}
	
	public void setLastName(String aString){
		lastName = aString;
	}

	public String fullName() {
	
		NameMerger merger = new NameMerger();
		String result = merger.merge(firstName, lastName);
		return result;
	}

}

