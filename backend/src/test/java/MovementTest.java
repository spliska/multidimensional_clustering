import backend.db.MovementDataService;
import backend.models.Movement;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MovementTest
{
    @Test
    public void testGetMovementOfPerson() throws SQLException {
        System.out.println(new Gson().toJson(new MovementDataService().getMovementDataOfPerson("100").get(0)));
    }

    @Test
    public void testGetMovementNearby() throws SQLException {
        Movement movement =new MovementDataService().getMovementDataOfPerson("100").get(0);

        System.out.println(new Gson().toJson(new MovementDataService().getMovementOfLocationAndTimestamp("99",movement.getLatitude(),movement.getLongitude(),movement.getTimestamp(),movement.getTimestamp())));
    }



}
