import java.util.*;

public class BirthdayBook {
	public String name;
	public Date date;
	public HashMap birthdays = new HashMap<String, Date>();
	
	public void AddBirthday() {
		if( !birthdays.containsKey(name) ) {
			birthdays.put(name, date);
		}
	}
	
	public void FindBirthday(String name) {
		if(birthdays.containsKey(name)){
			birthdays.get(date);
		} else {
			;
		}
	}
	
	public void Remind() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Gebe einen Namen zum Hinzufuegen ein.");
		System.out.println("Gebe das Geburtsdatum im Format dd.mm ein.");
		
	}

}
