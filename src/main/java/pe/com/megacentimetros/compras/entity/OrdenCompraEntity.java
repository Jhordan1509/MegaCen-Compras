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
@Entity(name = "OrdenCompraEntity")
@Table(name = "ordencompra")
public class OrdenCompraEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codordcom")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "numord", length = 30, nullable = false, unique = true)
    private String numero;

    @Column(name = "fecord", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "fecentest")
    private LocalDate fechaEntregaEstimada;

    @Column(name = "sitoc", length = 30, nullable = false)
    private String situacion;

    @Column(name = "subtotal", nullable = false, precision = 12, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "igv", nullable = false, precision = 12, scale = 2)
    private BigDecimal igv;

    @Column(name = "total", nullable = false, precision = 12, scale = 2)
    private BigDecimal total;

    @Column(name = "obs", length = 300)
    private String observacion;

    @Column(name = "codprov", nullable = false)
    private Long codprov;

    @Column(name = "estordcom", nullable = false)
    private Boolean estado;

    @Transient
    private Object proveedor;
}
