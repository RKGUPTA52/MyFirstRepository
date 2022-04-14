package com;

import java.time.temporal.ChronoUnit;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.time.Period;
/*
 * Period − It deals with date based amount of time.

    Duration − It deals with time based amount of time.
 */
public class Java8PeriodDuration {

   public static void main(String args[]) {
	   Java8PeriodDuration java8tester = new Java8PeriodDuration();
      java8tester.testPeriod();
      java8tester.testDuration();
   }
	
   public void testPeriod() {
      //Get the current date
      LocalDate date1 = LocalDate.now();
      System.out.println("Current date: " + date1);
		
      //add 1 month to the current date
      LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
      System.out.println("Next month: " + date2);
      
      Period period = Period.between(date2, date1);
      System.out.println("Period: " + period);
   }
	
   public void testDuration() {
      LocalTime time1 = LocalTime.now();
      Duration twoHours = Duration.ofHours(2);
		
      LocalTime time2 = time1.plus(twoHours);
      Duration duration = Duration.between(time1, time2);
		
      System.out.println("Duration: " + duration);
   }
}
