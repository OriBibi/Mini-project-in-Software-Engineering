package primitives;

public class Material {

    // ***************** variables ************************* //

    private double kd; // Diffusion attenuation coefficient
    private double ks; // Specular attenuation coefficient
    private int nShininess;  // Refraction index

    // ***************** Constructors ********************** //

    public Material(double kd, double ks, int nShininess) {
        this.setKd (kd);
        this.setKs (ks);
        this.setnShininess(nShininess);
    }
    public Material() {
        this.setKd(0.2);
        this.setKs(0.2);
        this.setnShininess(1);
    }
    public Material(Material material) {
        this.setKd(material.getKd());
        this.setKs(material.getKs());
        this.setnShininess(material.getnShininess());
    }


    // ***************** Getters/Setters ******************* //


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
