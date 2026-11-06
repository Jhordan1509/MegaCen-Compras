package pe.com.megacentimetros.compras.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "DetalleRecepcionEntity")
@Table(name = "detallerecepcion")
public class DetalleRecepcionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "coddetrec")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "codrec", nullable = false)
    private Long codrec;

    @Column(name = "coddetoc", nullable = false)
    private Long coddetoc;

    @Column(name = "cantrec", nullable = false)
    private Integer cantidadRecibida;

    @Column(name = "obs", length = 250)
    private String observacion;

    @Column(name = "estdetrecep", nullable = false)
    private Boolean estado;
}
