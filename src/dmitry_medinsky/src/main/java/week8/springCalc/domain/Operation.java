package week8.springCalc.domain;

/**
 * Created by Дмитрий on 12.03.14.
 */
public class Operation {

    private Integer id = 0;
    private String nameOper = null;
    private String codeOper = null;

    public Operation() {

    }

    public Operation(Integer id, String nameOper, String codeOper) {
        this.id = id;
        this.nameOper = nameOper;
        this.codeOper = codeOper;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOper() {
        return nameOper;
    }

    public void setNameOper(String nameOper) {
        this.nameOper = nameOper;
    }

    public String getCodeOper() {
        return codeOper;
    }

    public void setCodeOper(String codeOper) {
        this.codeOper = codeOper;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", nameOper='" + nameOper + '\'' +
                ", codeOper='" + codeOper + '\'' +
                '}';
    }
}
