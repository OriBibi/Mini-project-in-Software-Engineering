package primitives;
//A class that defines for everything that wants to be a geometry that has to be made of a particular material.
public class Material {

    // ***************** variables ************************* //

    private double kd; // Diffusion attenuation coefficient
    private double ks; // Specular attenuation coefficient
    private int nShininess;  // Refraction index
    private double kr;
    private double kt;
    // ***************** Constructors ********************** //

    public Material(double kd, double ks, int nShininess,double kr, double kt) {
        this.setKd (kd);
        this.setKs (ks);
        this.setKr (kr);
        this.setKt (kt);
        this.setnShininess(nShininess);
    }
    public Material(double kd, double ks, int nShininess) {
        this.setKd (kd);
        this.setKs (ks);
        this.setnShininess(nShininess);
    }
    public Material() {
        this.setKd(1);
        this.setKs(1);
        this.setKr (0);
        this.setKt (0);
        this.setnShininess(25);
    }
    public Material(Material material) {
        this.setKd(material.getKd());
        this.setKs(material.getKs());
        this.setKr (material.getKr());
        this.setKt (material.getKt());
        this.setnShininess(material.getnShininess());
    }


    // ***************** Getters/Setters ******************* //


    public double getKr() {
        return kr;
    }

    public void setKr(double kr) {
        this.kr = kr;
    }

    public double getKt() {
        return kt;
    }

    public void setKt(double kt) {
        this.kt = kt;
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

    public int getnShininess() {
        return nShininess;
    }

    public void setnShininess(int nShininess) {
        this.nShininess = nShininess;
    }
}
