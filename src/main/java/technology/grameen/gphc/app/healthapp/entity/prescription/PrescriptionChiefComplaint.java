package technology.grameen.gphc.app.healthapp.entity.prescription;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "prescription_chief_complaints")
public class PrescriptionChiefComplaint {

    @Id
    private UUID id;

    @ManyToOne(optional = false)
    private Prescription prescription;

    @ManyToOne(optional = false)
    private ChiefComplaint chiefComplaint;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    @JsonBackReference
    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public ChiefComplaint getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(ChiefComplaint chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }
}
