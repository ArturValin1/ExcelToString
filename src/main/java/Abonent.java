public class Abonent {
    private Integer nomer;
    private String station;
    private String fider10;
    private String tp;
    private String fider04;
    private String pointDelivery;
    private String dogovor;
    private String typeAbonent;
    private String address;
    private String district;
    private String numberCount;

    public Abonent(Integer nomer, String station, String fider10, String tp, String fider04, String pointDelivery, String dogovor, String typeAbonent, String address, String district, String numberCount) {
        this.nomer = nomer;
        this.station = station;
        this.fider10 = fider10;
        this.tp = tp;
        this.fider04 = fider04;
        this.pointDelivery = pointDelivery;
        this.dogovor = dogovor;
        this.typeAbonent = typeAbonent;
        this.address = address;
        this.district = district;
        this.numberCount = numberCount;
    }

    public Integer getNomer() {
        return nomer;
    }

    public String getStation() {
        return station;
    }

    public String getFider10() {
        return fider10;
    }

    public String getTp() {
        return tp;
    }

    public String getFider04() {
        return fider04;
    }

    public String getPointDelivery() {
        return pointDelivery;
    }

    public String getDogovor() {
        return dogovor;
    }

    public String getTypeAbonent() {
        return typeAbonent;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getNumberCount() {
        return numberCount;
    }

    @Override
    public String toString() {
        return "Abonent{" +
                "nomer='" + nomer + '\'' +
                ", station='" + station + '\'' +
                ", fider10='" + fider10 + '\'' +
                ", tp='" + tp + '\'' +
                ", fider04='" + fider04 + '\'' +
                ", pointDelivery='" + pointDelivery + '\'' +
                ", dogovor='" + dogovor + '\'' +
                ", typeAbonent='" + typeAbonent + '\'' +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", numberCount='" + numberCount + '\'' +
                '}';
    }
}
