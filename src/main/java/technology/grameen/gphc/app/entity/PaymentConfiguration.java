package technology.grameen.gphc.app.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
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
    private Boolean enabled;
    private Boolean isActive;
    @ManyToOne(fetch = FetchType.LAZY)
    private Site site;
}
