package com.techwasti.h2paginationdemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private UUID id;

    private String userId;

    @NotNull(message = "name cannot be empty")
    private String name;

   @NotNull(message="mobile number cannot be empty")
    private String mobileno;

    private Date createdDate;

    private Date updatedDate;

    private String createdBy;

}
