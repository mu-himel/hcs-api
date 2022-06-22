package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.invoice.PatientInvoice;

import java.util.UUID;

@Repository
public interface PatientInvoiceRepository extends JpaRepository<PatientInvoice, UUID> {
}
