package fr.intech.echecs.model;

public class Timer {

	private int hour;
    private int minute;
    private int second;

    public Timer(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }    
    
   

    public Timer(String currentTime) {
        String[] time = currentTime.split(":");
        hour = Integer.parseInt(time[0]);
        minute = Integer.parseInt(time[1]);
        second = Integer.parseInt(time[2]);
    }

    public String getCurrentTime(){
        return hour + ":" + minute + ":" + second;
    }

    public void oneSecondPassed(){
        second--;
        if(second == -1){
            minute--;
            second = 59;
            if(minute == -1){
                hour--;
                minute = 59;
                second = 59;
               
            }
        }
    }
    
    
	
	
	
	
	
}
