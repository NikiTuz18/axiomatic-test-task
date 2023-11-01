package ru.nikituz.axiomatictesttask.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fio", length = 100, nullable = false)
    private String fio;

    @Column(name = "passport", length = 11, unique = true, nullable = false)
    private String passport;

    @Column(name = "marital_status")
    private boolean maritalStatus;

    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @Column(name = "phone", length = 12, unique = true, nullable = false)
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employment_id", nullable = false)
    private Employment employment;

    @Column(name = "credit_amount", nullable = false)
    private BigDecimal creditAmount;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Request> requests;
}
