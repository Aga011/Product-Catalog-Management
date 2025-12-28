Product Catalog Management Service Spring Boot üzərində hazırlanmış bir backend servisi olub, məhsulların idarə olunmasını təmin edir. Rol əsaslı icazələr ilə işləyir: admin bütün CRUD əməliyyatlarını yerinə yetirə bilir, user isə yalnız məhsulları görə bilir.

🔹 Texnologiyalar

Java 21

Spring Boot 4.0.1

Spring Data JPA / Hibernate

Spring Security (rol əsaslı icazələr üçün)

MapStruct 1.6.2 (DTO mapping üçün)

Lombok 1.18.42 (getter/setter, builder və s.)

PostgreSQL (runtime database)

Maven 3.x (build management)

Test dependencies: Spring Boot test, security test, validation test, webmvc test

🔹 Funksionallıq və İcazələr

Admin: Məhsul əlavə etmək, yeniləmək, silmək (POST, PUT, DELETE)

User: Yalnız məhsulları oxuya bilir (GET)
