package spring.oyuncakci.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "oyuncaklar")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Oyuncak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date alisTarihi;

    @Column( name = "alisFiyati", precision = 10, scale = 2)
    private Double alisFiyati;

    @Column(name = "ad")
    private String ad;

    @Column(name = "tur")
    private String tur;

    @Column(name = "desi")
    private Integer desi;

    @Column(name = "notlar")
    private String notlar;

}
