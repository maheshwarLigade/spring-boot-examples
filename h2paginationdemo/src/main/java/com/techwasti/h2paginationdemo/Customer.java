package com.techwasti.h2paginationdemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="customer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer{

    @Id
    @GeneratedValue()
    private UUID id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String mobileno;

    private Date createdDate;

    @Column(nullable = false)
    private String createdBy;

    private Date updatedDate;

}