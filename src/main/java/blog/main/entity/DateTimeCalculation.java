package blog.main.entity;

import java.time.LocalDateTime;

public class DateTimeCalculation {

	private LocalDateTime time;
	
	public DateTimeCalculation() {}
	  
	public DateTimeCalculation(LocalDateTime time) {
		super();
		this.time = time;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public int leapYear(LocalDateTime time)
	    {
		  int godina = time.getYear();
	        if ((godina%4==0 && godina%100!=0)||(godina%400==0)) {
	            return 1;
	        }
	        else
	        {
	            return 0;
	        }
	    }
	    
	    public int dayNumber(LocalDateTime time)
	    {
	    	int dan = time.getDayOfMonth();
	    	int mesec = time.getMonthValue();
	    	int godina = time.getYear();
	    			
	        int broj_dana = 0;
	        int broj_dana_u_godinama = 0;
	        int broj_prestupnih=0;
	        int broj_dana_u_mesecima = 0;
	        
	        
	        for (int i = 1900; i < godina; i++) 
	        {
	            if (leapYear(time)==1) {
	                broj_prestupnih++;
	            }
	            
	        }
	        int dani_u_mesecima[] = {0,31,28+leapYear(time),31,30,31,30,31,31,30,31,30,31};
	        for (int i = 1; i < mesec; i++) 
	        {
	            broj_dana_u_mesecima+=dani_u_mesecima[i];
	        }
	        
	        
	        
	        broj_dana_u_godinama = (godina - 1900)*365;
	        broj_dana = broj_dana_u_godinama+broj_prestupnih+broj_dana_u_mesecima+dan;
	        
	        return broj_dana;
	         
	    }
	    
	    public String getdateDiffDayFromNow(LocalDateTime time)
	    {
	    	String result ="";
	    	
	    	LocalDateTime now = LocalDateTime.now();
	    	int hoursNow= (dayNumber(now)-1)*24+now.getHour();
	    	int minutesNow = hoursNow*60+ now.getMinute();
	    	
	    	int hoursTime = (dayNumber(time)-1)*24+time.getHour();
	    	int minutesTime = hoursTime*60+time.getMinute();
	    	
	     
	        int pocetak, kraj,broj_dana, broj_sati, broj_minute;
	        pocetak=dayNumber(time);
	        kraj = dayNumber(now);
	        broj_dana = kraj - pocetak;
           broj_sati = hoursNow-hoursTime;
	        broj_minute = minutesNow-minutesTime;
	        
	        if(broj_dana>44) {
	        	result = (broj_dana/30) +"months ago ";
	        }
	        else if(broj_dana>=30 && broj_dana<44) {
	        	result = (broj_dana/30) +"month ago ";
	        }
	        
	        else if(broj_dana>1)
           {
               result = broj_dana+" days ago";
           }
	        else if(broj_dana>=1&&broj_dana<2)
	           {
	               result = broj_dana+" day ago";
	           }
            
           else if(broj_sati<=24 && broj_sati>1 || broj_minute>120) 
	        {
	        	
	        	result=broj_sati+" hours ago";
	        	
	        }
           else if(broj_sati<=1&&broj_minute<=120) 
	        {
	        	
	        	result=broj_sati+" hour ago";
	        	
	        }
	        
	        
           if(broj_minute<=60) 
	        {
	        	
	        	result=broj_minute+" minutes ago";
	        	
	        }
           
	        return result;
	        
	    }
	    
	    public String getStringDate(LocalDateTime dateTime) {
	    	
	    	String dateString = dateTime.getDayOfMonth()+" "+dateTime.getMonth().toString() + " |"+dateTime.getYear();
	    	return dateString;
	    }
}
