package model;

public class Pelanggan extends Person {
    
    private String idCust;
    
    public Pelanggan(String nama, String alamat, String noTelp, String jenisKelamin,String idCust) {
        super(nama, alamat, noTelp, jenisKelamin);
        this.idCust = idCust;
    }

    public String getIdCust() {
        return idCust;
    }

    public void setIdCust(String idCust) {
        this.idCust = idCust;
    }
}