package technology.grameen.gphc.app.services.invoice;

import technology.grameen.gphc.app.healthapp.entity.invoice.PatientInvoice;

public interface PatientInvoiceService {

    void saveInvoice(PatientInvoice patientInvoice);
}
