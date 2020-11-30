package rental;

import java.time.LocalDate;

public class Description {
	private LocalDate departDate;
	private String departPlace;
	private String arrivalPlace;
	private int duration;
	
    public Description(LocalDate lo, String st, String str, int in) {
    	departDate = lo;
    	departPlace = st;
    	arrivalPlace = str;
    	duration = in;
    }
    
    public LocalDate getDepartDate() {
    	return departDate;
    }
    
    public void setDepartDate(LocalDate date) {
    	departDate = date;
    }
    
    public String getDepartPlace() {
    	return departPlace;
    }
    
    public void setDepartPlace(String depart) {
    	departPlace = depart;
    }
    
    public String getArrivalPlace() {
    	return arrivalPlace;
    }
    
    public void setArrivalPlace(String arrival) {
    	arrivalPlace = arrival;
    }
    
    public int getDuration() {
    	return duration;
    }
    
    public void setDuration(int dur) {
    	duration = dur;
    }
    
    public boolean equals(Description desc) {
    	if (this.departDate == desc.getDepartDate() && this.departPlace == desc.getDepartPlace() && this.arrivalPlace == desc.getArrivalPlace() && this.duration == desc.getDuration()) {
    		return true;
    	}
    	
    	return false;
    }
    
}