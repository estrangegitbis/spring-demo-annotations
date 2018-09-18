package com.luv2code.springdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;
    
    @Value("${email}")
    private String email;
       
    @Value("${team}")
    private String team;

    // define a default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }
    
    // define a setter method
//    @Autowired
//    public void setFortuneService( FortuneService fortuneService ) {
//        System.out.println(">> TennisCoach: inside setFortuneService method");        
//        this.fortuneService = fortuneService;
//    }
        
//    @Autowired    
//    public TennisCoach(FortuneService theFortuneService) {
//        fortuneService = theFortuneService;
//    }
    
    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
        
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }      
}
