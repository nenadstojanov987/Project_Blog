package blog.main.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="message")
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id_message;
	@Column
	@NotBlank
	@Size(min=3,max=255)
	private String name;
	@Column
	@Email
	@NotBlank
	@Size(min=3,max=255)
	private String email;
	@Column
	@NotBlank
	@Size(min=20,max=1000)
	private String content;
	@Column
	private LocalDateTime message_date;
	@Column
	private boolean seen;
	
	public Message() {}
	
	
	public Message(String name, String email, String content, LocalDateTime message_date, boolean seen) {
		super();
		this.name = name;
		this.email = email;
		this.content = content;
		this.message_date = message_date;
		this.seen = seen;
	}
	
	public Message(String name, String email, String content) {
		super();
		this.name = name;
		this.email = email;
		this.content = content;

	}
	  
	public Message(int id_message, String name, String email, String content, LocalDateTime message_date, boolean seen) {
		super();
		this.id_message = id_message;
		this.name = name;
		this.email = email;
		this.content = content;
		this.message_date = message_date;
		this.seen = seen;
	}


 
	public int getId_message() {
		return id_message;
	}
	public void setId_message(int id_message) {
		this.id_message = id_message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getMessage_date() {
		return message_date;
	}
	public void setMessage_date(LocalDateTime LocalDateTime) {
		 
		this.message_date = LocalDateTime;
		
		
	}
	public boolean isSeen() {
		return seen;
	}
	public void setSeen(boolean seen) {
		this.seen = seen;
	}


	@Override
	public String toString() {
		return "Message [id_message=" + id_message + ", name=" + name + ", email=" + email + ", content=" + content
				+ ", message_date=" + message_date + ", seen=" + seen + "]";
	}
	
	public String getMessagePreview() 
	{
		String messagePrev=this.content.substring(0, 18)+"...";
		return messagePrev;
	}
	
	public String getMessageTimeLapse() 
	{
		
		String time= getdateDiffDay(this.message_date);
		return time;
	}
	
	 
	  public static int prestupna(LocalDateTime time)
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
	    
	    public static int broj_dana(LocalDateTime time)
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
	            if (prestupna(time)==1) {
	                broj_prestupnih++;
	            }
	            
	        }
	        int dani_u_mesecima[] = {0,31,28+prestupna(time),31,30,31,30,31,31,30,31,30,31};
	        for (int i = 1; i < mesec; i++) 
	        {
	            broj_dana_u_mesecima+=dani_u_mesecima[i];
	        }
	        
	        
	        
	        broj_dana_u_godinama = (godina - 1900)*365;
	        broj_dana = broj_dana_u_godinama+broj_prestupnih+broj_dana_u_mesecima+dan;
	        
	        return broj_dana;
	         
	    }
	    
	    public static String getdateDiffDay(LocalDateTime time)
	    {
	    	String result ="";
	    	
	    	LocalDateTime now = LocalDateTime.now();
	    	int hoursNow= broj_dana(now)*24+now.getHour();
	    	int minutesNow = hoursNow*60+ now.getMinute();
	    	
	    	int hoursTime = broj_dana(time)*24+time.getHour();
	    	int minutesTime = hoursTime*60+time.getMinute();
	    	
	     
	        int pocetak, kraj,broj_dana, broj_sati, broj_minute;
	        pocetak=broj_dana(time);
	        kraj = broj_dana(now);
	        broj_dana = kraj - pocetak;
              broj_sati = hoursNow-hoursTime;
	        broj_minute = minutesNow-minutesTime;
              if(broj_dana>1)
              {
                  result = broj_dana+" days ago";
              }
               
              else if(broj_sati<24) 
	        {
	        	
	        	result=broj_sati+" hours ago";
	        	
	        }
	        
              if(broj_minute<=60) 
	        {
	        	
	        	result=broj_sati+" minutes ago";
	        	
	        }
              
	        return result;
	        
	    }
	

}
