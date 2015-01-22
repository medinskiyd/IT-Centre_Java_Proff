package week6.Hibernate;

import javax.persistence.*;

/**
 * Created by Дмитрий on 28.02.14.
 */

@Entity
@Table(name = "REGIONS")
public class Region {   // Класс не должен быть final (если мы хотим что бы Hibernate его использовал).

    @Id // Для обозначения первичного ключа.
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence") // значение этого regionId нужно генерировать автоматически.
    @Column(name = "REGION_ID")
    private Long regionId;

    @Column(name = "REGION_NAME")
    private String regionName;

    public Region() { // требование обязательное для Hibernate

    }

    public Region(Long regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return "Region{" +
                "regionId=" + regionId +
                ", regionName='" + regionName +
                '}';
    }
}
