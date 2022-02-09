package technology.grameen.gphc.app.entity.configuration;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import technology.grameen.gphc.app.entity.Site;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payment_configurations")
public class PaymentConfiguration {

    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY)
    private PaymentMethod paymentMethod;
    private String paymentRequestUrl;
    private String transactionValidationUrl;
    private Boolean isPerformTransactionValidation;
    private String clientKey;
    private String clientSecret;
    private Boolean isEnabled;
    private Boolean isActive;
    @ManyToOne(fetch = FetchType.LAZY)
    private Site site;

    private UUID createdBy;
    private UUID updatedBy;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
