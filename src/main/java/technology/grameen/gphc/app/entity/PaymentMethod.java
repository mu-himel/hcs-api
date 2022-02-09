package technology.grameen.gphc.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "payment_methods")
public class PaymentMethod {

    @Id
    private UUID id = UUID.randomUUID();
    private String methodName;
    private String description;
    private Boolean enabled;
}
