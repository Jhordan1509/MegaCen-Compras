package pe.com.megacentimetros.compras.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
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
@Entity(name = "DetalleOrdenCompraEntity")
@Table(name = "detalleordencompra")
public class DetalleOrdenCompraEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "coddetoc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "codordcom", nullable = false)
    private Long codordcom;

    @Column(name = "codprod", nullable = false)
    private Long codprod;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "preuni", nullable = false, precision = 12, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "subtotal", nullable = false, precision = 12, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "estdetordcom", nullable = false)
    private Boolean estado;

    @Transient
    private Object producto;
}
