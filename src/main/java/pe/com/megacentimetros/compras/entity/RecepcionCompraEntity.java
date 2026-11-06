package pe.com.megacentimetros.compras.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Entity(name = "RecepcionCompraEntity")
@Table(name = "recepcioncompra")
public class RecepcionCompraEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codrec")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "numrec", length = 40, nullable = false, unique = true)
    private String numero;

    @Column(name = "fecrec", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "obs", length = 300)
    private String observacion;

    @Column(name = "sitrec", length = 30, nullable = false)
    private String situacion;

    @Column(name = "codordcom", nullable = false)
    private Long codordcom;

    @Column(name = "codalm", nullable = false)
    private Long codalm;

    @Column(name = "estrecep", nullable = false)
    private Boolean estado;

    @Transient
    private Object almacen;
}
