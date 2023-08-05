package com.dbs.movie_ticket_system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "customer",
        uniqueConstraints = @UniqueConstraint(columnNames = "customerMobileNumber")
)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @NotBlank(message = "Please Add Customer Name")
    @Column(nullable = false)
    private String customerName;
    @NotBlank(message = "Please Add Customer Mobile Number")
    @Column(nullable = false)
    private String customerMobileNumber;
    @NotBlank(message = "Please Add Customer Password")
    @Column(nullable = false)
    private String customerPassword;
}
