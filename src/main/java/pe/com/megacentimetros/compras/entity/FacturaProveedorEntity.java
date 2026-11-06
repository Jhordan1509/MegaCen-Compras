package pe.com.megacentimetros.compras.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "FacturaProveedorEntity")
@Table(name = "facturaproveedor")
public class FacturaProveedorEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codfacprov")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "numfac", length = 40, nullable = false)
    private String numero;

    @Column(name = "fecemi", nullable = false)
    private LocalDate fechaEmision;

    @Column(name = "fecven")
    private LocalDate fechaVencimiento;

    @Column(name = "subtotal", nullable = false, precision = 12, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "igv", nullable = false, precision = 12, scale = 2)
    private BigDecimal igv;

    @Column(name = "total", nullable = false, precision = 12, scale = 2)
    private BigDecimal total;

    @Column(name = "sitfac", length = 30, nullable = false)
    private String situacion;

    @Column(name = "codprov", nullable = false)
    private Long codprov;

    @Column(name = "codordcom")
    private Long codordcom;

    @Column(name = "estfacprov", nullable = false)
    private Boolean estado;

    @Transient
    private Object proveedor;
}
