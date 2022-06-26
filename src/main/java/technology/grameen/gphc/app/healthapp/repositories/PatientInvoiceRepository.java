package technology.grameen.gphc.app.healthapp.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.invoice.PatientInvoice;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientInvoiceRepository extends JpaRepository<PatientInvoice, UUID> {


    @Query(value = "SELECT pi FROM PatientInvoice pi " +
            "JOIN FETCH pi.details d " +
            "JOIN FETCH pi.patient p " +
            "JOIN FETCH d.service s",
    countQuery = "SELECT count(*) FROM PatientInvoice pi " +
            "JOIN pi.details d " +
            "JOIN pi.patient p " +
            "JOIN d.service s")
    Page<PatientInvoiceListItem> findAllPatientInvoice(Pageable pageable);

    @Query(value = "SELECT pi FROM PatientInvoice pi " +
            "JOIN FETCH pi.details d " +
            "JOIN FETCH pi.patient p " +
            "JOIN FETCH d.service s " +
            "WHERE pi.patient = :patient",
            countQuery = "SELECT count(*) FROM PatientInvoice pi " +
                    "JOIN pi.details d " +
                    "JOIN pi.patient p " +
                    "JOIN d.service s " +
                    "WHERE pi.patient = :patient")
    Page<PatientInvoiceListItem> findAllPatientInvoice(@Param("patient") Profile patient, Pageable pageable);


    @Query(value = "SELECT pi FROM PatientInvoice pi " +
            "JOIN FETCH pi.details d " +
            "JOIN FETCH pi.patient p " +
            "JOIN FETCH d.service s " +
            "WHERE pi.id = :id")
    Optional<PatientInvoiceDetail> findPatientInvoiceDetailById(@Param("id") UUID id);

    interface PatientInvoiceDetail extends PatientInvoiceListItem{
        List<InvoiceDetailInfo> getDetails();
    }

    interface InvoiceDetailInfo{
        BigDecimal getPaidAmount();
        BigDecimal getServiceAmount();
        BigDecimal getDiscountAmount();
        Boolean getRefunded();
        ServiceInfo getService();
    }

    interface ServiceInfo{
        UUID getId();
        String getName();
    }


    interface PatientInvoiceListItem{
        UUID getId();
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime getCreatedAt();
        BigDecimal getDiscountAmount();
        String getInvoiceNumber();
        Boolean getPosted();
        BigDecimal getServiceAmount();
        String getSubscriptionCode();
        ProfileInfo getPatient();
    }

    interface ProfileInfo{
        UUID getId();
        String getFirstName();
        String getLastName();
    }
}
