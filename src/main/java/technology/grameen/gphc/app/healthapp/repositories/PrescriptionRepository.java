package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.medicine.Medicine;
import technology.grameen.gphc.app.healthapp.entity.prescription.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, UUID> {

    interface Prescription{
       UUID getId();
       Patient getPatient();
       List<ChiefComplaint> getChiefComplaints();
       String getOtherChiefComplaint();
       List<Disease> getDiseases();
       List<PrescriptionMedicine> getMedicines();
       List<Advice> getAdvices();
       String getOtherAdvice();
       List<Hospital> getHospitals();
       String getDoctor();
       List<HService> getServices();
        BasicCheckup getBasicCheckup();
    }
    interface Medicine{
        UUID getId();
        String getName();
    }
    interface PrescriptionMedicine{
        UUID getId();
        Medicine getMedicine();
        Integer getDuration();
        String getDurationUnit();
        String getDose();
        String getMedicineType();

    }

    interface HService{
        UUID getId();
        String getName();
    }

    interface BasicCheckup{
        UUID getId();
    }

    interface Patient{
        UUID getId();
        String getFirstName();
        String getLastName();
    }
    @Query(value = "SELECT pr FROM Prescription pr " +
            "JOIN FETCH pr.patient p " +
            "LEFT JOIN FETCH pr.basicCheckup bc " +
            "where pr.id = :id")
    Optional<Prescription> findPrescriptionById(@Param("id") UUID id);
}
