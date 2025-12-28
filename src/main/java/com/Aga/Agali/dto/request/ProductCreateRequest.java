package com.Aga.Agali.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductCreateRequest (

        @NotBlank(message = "Product adı boş ola bilməz")
        @Size(min = 3, max = 100, message = "Product adı 3-100 simvol arası olmalıdır")
        String name,

        @Size(max = 500, message = "Açıqlama maksimum 500 simvol ola bilər")
        String description,

        @NotNull(message = "Qiymət boş ola bilməz")
        @DecimalMin(value = "0.1", message = "Qiymət 0-dan böyük olmalıdır")
        BigDecimal price,

        @NotNull(message = "Stok boş ola bilməz")
        @Min(value = 0, message = "Stok mənfi ola bilməz")
        Integer stock

) {}