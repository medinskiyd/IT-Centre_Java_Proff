package week6.DAO;


/**
 * Created by Дмитрий on 26.02.14.
 */
public class Region {

    private Long regionId;
    private String regionName = null;

    public Region() {
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
                "region_id=" + regionId +
                ", regionName='" + regionName + '\'' +
                '}';

    }
}
