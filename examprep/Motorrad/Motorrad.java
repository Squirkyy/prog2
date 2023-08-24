public class Motorrad {
    private double Leistung;
    private int Gewicht;
    private String Typname;
    private double Leistungsgewicht;

    public double getLeistung() {
        return this.Leistung;
    }

    public int getGewicht() {
        return this.Gewicht;
    }

    public String getTypname() {
        return this.Typname;
    }

    public void setLeistung(double Leistung) {
        this.Leistung = Leistung;
    }

    public void setGewicht(int Gewicht) {
        this.Gewicht = Gewicht;
    }

    public void setTypname(String Typname) {
        this.Typname = Typname;
    }

    public double getLeistungsgewicht() {
        return this.Gewicht / this.Leistung;
    }

    public Motorrad(double Leistung, int Gewicht, String Typname) {
        this.Gewicht = Gewicht;
        this.Leistung = Leistung;
        this.Typname = Typname;
        this.Leistungsgewicht = this.Gewicht / this.Leistung;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Motorrad: " + this.Typname + " ");
        sb.append("mit " + getGewicht() + "kg und " + getLeistung() + " PS");
        return sb.toString();
    }
}