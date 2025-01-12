package clustering;

import models.Person;

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
    }

    public double calculateNodeDistance(Person personOne, Person personTwo) {
        return  meetingWeight * countMeetings(this.minMeetingDuration, personOne, personTwo) *
                messageWeight * countMessages(personOne, personTwo) *
                phoneCallWeight * countPhoneCalls(this.minPhoneCallDuration, personOne, personTwo);
    }

    public double calculateNodeDistance(Person personOne,Person personTwo, Date date) {
        return meetingWeight* countMeetingsInMonth(this.minMeetingDuration,personOne,personTwo,date);
    }

    public double calculateNodeDistance(Person personOne,Person personTwo, Date startDate, Date endDate) {
      return meetingWeight* countMeetingInTimeFrame(this.minMeetingDuration,personOne,personTwo,startDate,endDate);
    }

    public int countMeetings(int minMeetingDuration, Person personOne, Person personTwo) {
        return 1;
    }

    public int countMeetingsInMonth(int minMeetingDuration,Person personOne, Person personTwo, Date date) {
        return 1;
    }

    public int countMeetingInTimeFrame(int minMeetingDuration,Person personOne, Person personTwo, Date startDate, Date endDate) {
        return 1;
    }

    public int countMessages(Person personOne, Person personTwo) {
        return 1;
    }

    public int countMessagesInMonth(Person personOne, Person personTwo, Date date) {
        return 1;
    }

    public int countMessagesInTimeFrame(Person personOne, Person personTwo, Date startDate, Date endDate) {
        return 1;
    }

    public int countPhoneCalls(int minPhoneCallDuration, Person personOne, Person personTwo) {
        return 1;
    }

    public int countPhoneCallsInMonth(int minPhoneCallDuration, Person personOne, Person personTwo, Date date) {
        return 1;
    }

    public int countPhoneCallsInMonth(int minPhoneCallDuration, Person personOne, Person personTwo, Date startDate, Date endDate) {
        return 1;
    }




}

