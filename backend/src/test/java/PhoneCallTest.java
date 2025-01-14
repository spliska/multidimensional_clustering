import models.PhoneCall;
import org.junit.jupiter.api.Test;
import services.db.PhoneCallService;

public class PhoneCallTest {
    @Test
    public void testGetAllPhoneCalls() {
        PhoneCall[] phoneCalls= new PhoneCallService().getAllPhoneCalls();
        for(int i=0;i<phoneCalls.length;i++){
            System.out.println(phoneCalls[i].getDate());
            System.out.println(phoneCalls[i].getDuration());
            System.out.println(phoneCalls[i].getTime());
            System.out.println(phoneCalls[i].getCaller());
            System.out.println(phoneCalls[i].getReceiver());

        }
    }

    @Test
    public void testGetPhoneCallsByCallerId() {
        PhoneCall[] phoneCalls=new PhoneCallService().getAllPhoneCallsByCallerId("Caller1");
        for(int i=0;i<phoneCalls.length;i++){
            System.out.println(phoneCalls[i].getDate());
            System.out.println(phoneCalls[i].getDuration());
            System.out.println(phoneCalls[i].getTime());
            System.out.println(phoneCalls[i].getCaller());
            System.out.println(phoneCalls[i].getReceiver());
        }
    }

    @Test
    public void testGetPhoneCallsByReceiverId() {
        PhoneCall[] phoneCalls=new PhoneCallService().getAllPhoneCallsByReceiverId("Receiver1");
        for(int i=0;i<phoneCalls.length;i++){
            System.out.println(phoneCalls[i].getDate());
            System.out.println(phoneCalls[i].getDuration());
            System.out.println(phoneCalls[i].getTime());
            System.out.println(phoneCalls[i].getCaller());
            System.out.println(phoneCalls[i].getReceiver());
        }
    }

    @Test
    public void testGetPhoneCallsOfTwoParties(){
        PhoneCall[] phoneCalls=new PhoneCallService().getAllPhoneCallsBetweenTwoParties("Caller1", "Receiver1");
        for(int i=0;i<phoneCalls.length;i++){
            System.out.println(phoneCalls[i].getDate());
            System.out.println(phoneCalls[i].getDuration());
            System.out.println(phoneCalls[i].getTime());
            System.out.println(phoneCalls[i].getCaller());
            System.out.println(phoneCalls[i].getReceiver());
        }
    }



}
