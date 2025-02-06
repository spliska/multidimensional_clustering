package clustering;

import models.Meeting;
import models.Message;
import models.Person;
import services.db.MeetingService;
import services.db.MessageService;
import services.db.PhoneCallService;

import java.sql.SQLException;
import java.util.Date;

public class ClusterCalculator {

    public double meetingWeight;
    public double messageWeight;
    public double phoneCallWeight;
    public int minMeetingDuration;
    public int minPhoneCallDuration;


    public ClusterCalculator(double meetingWeight, double messageWeight, double phoneCallWeight) {
        this.meetingWeight = meetingWeight;
        this.messageWeight = messageWeight;
        this.phoneCallWeight = phoneCallWeight;
    }

    public ClusterCalculator() {
        this.meetingWeight = 1.0;
        this.messageWeight = 1.0;
        this.phoneCallWeight = 1.0;
        this.minMeetingDuration = 0;
        this.minPhoneCallDuration = 0;
    }

    public double calculateNodeDistance(Person personOne, Person personTwo) {
        return    meetingWeight * 1/countMeetings(this.minMeetingDuration, personOne, personTwo)
                + messageWeight * 1/countMessages(personOne, personTwo)
                + phoneCallWeight * 1/countPhoneCalls(this.minPhoneCallDuration, personOne, personTwo);
    }

    public double calculateNodeDistance(Person personOne,Person personTwo, Date date) {
        return meetingWeight* countMeetingsInMonth(this.minMeetingDuration,personOne,personTwo,date);
    }

    public double calculateNodeDistance(Person personOne,Person personTwo, Date startDate, Date endDate) {
      return meetingWeight* countMeetingInTimeFrame(this.minMeetingDuration,personOne,personTwo,startDate,endDate);
    }

    public int countMeetings(int minMeetingDuration, Person personOne, Person personTwo) {
        Meeting[] meetings=  new MeetingService().getMeetingsBetween(personOne.getId(),personTwo.getId());
        int meetingCount=0;
        for(Meeting meeting:meetings){
            if(meeting.getDuration()>minMeetingDuration){
                meetingCount++;
            }
        }
        return meetingCount;
    }

    public int countMeetingsInMonth(int minMeetingDuration,Person personOne, Person personTwo, Date date) {
        Meeting[] meetings=  new MeetingService().getMeetingsBetweenInMonth(personOne.getId(),personTwo.getId(), (java.sql.Date) date, (java.sql.Date) date);
        int meetingCount=0;
        for(Meeting meeting:meetings){
            if(meeting.getDuration()>minMeetingDuration){
                meetingCount++;
            }
        }
        return meetingCount;
    }

    public int countMeetingInTimeFrame(int minMeetingDuration,Person personOne, Person personTwo, Date startDate, Date endDate) {
        Meeting[] meetings= new MeetingService().getMeetingsBetweenInMonth(personOne.getId(),personTwo.getId(),(java.sql.Date) startDate,(java.sql.Date) endDate);
        int meetingCount=0;
        for(Meeting meeting:meetings){
            if(meeting.getDuration()>minMeetingDuration){
                meetingCount++;
            }
        }
        return meetingCount;
    }

    public int countMessages(Person personOne, Person personTwo) {
        int messageCount=0;
        try {
            Message[] messages= new MessageService().getAllMessagesSentFromPersonToPerson(personOne.getId(),personTwo.getId());
            messageCount=messages.length;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return messageCount;
    }

    public int countMessagesInMonth(Person personOne, Person personTwo, Date date) {
        int messagesCount=0;
        try{
           messagesCount= new MessageService().getMessagesSentFromPersonToPersonWithinTimeFrame(personOne.getId(),personTwo.getId(),date,date).length;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return messagesCount;
    }

    public int countMessagesInTimeFrame(Person personOne, Person personTwo, Date startDate, Date endDate) {

        return 1;
    }

    public int countPhoneCalls(int minPhoneCallDuration, Person personOne, Person personTwo) {

        int phoneCallCount=0;
        try{
            phoneCallCount= new PhoneCallService().getAllPhoneCallsBetweenTwoParties(personOne.getId(),personTwo.getId()).length;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return phoneCallCount;
    }

    public int countPhoneCallsInMonth(int minPhoneCallDuration, Person personOne, Person personTwo, Date date) {
        int phoneCallsCount=0;
        try {
            phoneCallsCount = new PhoneCallService().getAllPhoneCallsBetweenTwoPartiesWithinATimeFrame(personOne.getId(),personTwo.getId(),date,date).length;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return phoneCallsCount;
    }

    public int countPhoneCallsInMonth(int minPhoneCallDuration, Person personOne, Person personTwo, Date startDate, Date endDate) {
        int phoneCallsCount=0;
        try {
            phoneCallsCount = new PhoneCallService().getAllPhoneCallsBetweenTwoPartiesWithinATimeFrame(personOne.getId(),personTwo.getId(),startDate,endDate).length;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return phoneCallsCount;
    }




}

