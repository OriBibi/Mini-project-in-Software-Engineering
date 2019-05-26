package primitives;

public class Material {

    // ***************** variables ************************* //

    private double kd; // Diffusion attenuation coefficient
    private double ks; // Specular attenuation coefficient
    private double nShininess;  // Refraction index

    // ***************** Constructors ********************** //

    public Material(double kd, double ks, double nShininess) {
        this.set_kd (kd);
        this.set_ks (ks);
        this.setnShininess(nShininess);
    }
    public Material() {
        this.setKd(0.2);
        this.setKs(0.2);
        this.setnShininess(0.2);
    }
    public Material(Material material) {
        this.setKd(material.getKd());
        this.setKs(material.getKd());
        this.setnShininess(material.getKd());
    }


    // ***************** Getters/Setters ******************* //

    public double get_kd() {
        return getKd();
    }
    public void set_kd(double kd) {
        this.setKd(kd);
    }
    public double get_ks() {
        return getKs();
    }
    public void set_ks(double ks) {
        this.setKs(ks);
    }
    public double get_nShininess() {
        return getnShininess();
    }
    public void set_nShininess(double nShininess) {
        this.setnShininess(nShininess);
    }

    public double getKd() {
        return kd;
    }

    public void setKd(double kd) {
        this.kd = kd;
    }

    public double getKs() {
        return ks;
    }

    public void setKs(double ks) {
        this.ks = ks;
    }

    public double getnShininess() {
        return nShininess;
    }

    public void setnShininess(double nShininess) {
        this.nShininess = nShininess;
    }
}
