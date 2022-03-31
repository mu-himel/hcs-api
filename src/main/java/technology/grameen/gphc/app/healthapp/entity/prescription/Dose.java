package technology.grameen.gphc.app.healthapp.entity.prescription;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "doses")
public class Dose {

    @Id
    private UUID id;
    private String title;
}
