package technology.grameen.gphc.app.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "report_configurations")
public class ReportConfiguration {

    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY)
    private Site site;


    private Boolean isActive;

}
