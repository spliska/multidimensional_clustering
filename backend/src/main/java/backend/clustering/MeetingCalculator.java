package backend.clustering;

import backend.db.MovementDataService;
import backend.db.PersonService;
import backend.models.Meeting;
import backend.models.Movement;
import backend.models.Person;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class MeetingCalculator {
    double maxEncounterDistance;
    int  encounterTimeframe;
    int maxEncounterDuration;

    public MeetingCalculator(double maxEncounterDistance, int encounterTimeframe, int maxEncounterTimeframe) {
        this.maxEncounterDistance = maxEncounterDistance;
        this.encounterTimeframe = encounterTimeframe;
        this.maxEncounterDuration = maxEncounterTimeframe;
    }

    public Meeting[] calculateMeetingsForPersonInTimeFrame(String personId, Timestamp start_date_time, Timestamp end_date_time){
        ArrayList<Meeting> generatedMeetings = new ArrayList<Meeting>();
        ArrayList<Movement> movementsOfPerson = new ArrayList<>();
        MovementDataService movementDataService = new MovementDataService();
        System.out.println("movementDataService.getMovementDataOfPerson(personId)");
        try {
            movementsOfPerson = movementDataService.getMovementDataOfPerson(personId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for(Movement movement:movementsOfPerson){
            ArrayList<Movement> movementAtPointNearPerson;
            System.out.println("Movement movement:movementsOfPerson");
            try {
                movementAtPointNearPerson = movementDataService.getMovementOfLocationAndTimestamp(personId,movement.getLatitude(),movement.getLongitude(),movement.getTimestamp(),movement.getTimestamp());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ArrayList<Person> participants= new ArrayList<Person>();
            PersonService personService = new PersonService();
            Meeting generatedMeeting =new Meeting(1,movement.getLongitude(),movement.getLatitude(),0,null);
            if(!movementAtPointNearPerson.isEmpty()){
                for(Movement movement1:movementAtPointNearPerson){
                    System.out.println("Movement movement1:movementAtPointNearPerson");
                    if(movement1.getMeetingId()==null){
                       System.out.println("movement1.getMeetingId()==null");
                       System.out.println("Add participant");
                        participants.add(personService.getPersonById(movement1.getPersonId()));
                        System.out.println("Update  movement1");
                        try {
                            movementDataService.updateMovement(movement1.getId(), generatedMeeting.getMeeting_id());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                if(participants.size()>0){
                    System.out.println("participants.size()="+participants.size());
                    participants.add(personService.getPersonById(personId));
                    generatedMeeting.setPeople(participants);
                    generatedMeetings.add(generatedMeeting);
                }

            }

        }
        return generatedMeetings.toArray(new Meeting[0]);
    }

}
