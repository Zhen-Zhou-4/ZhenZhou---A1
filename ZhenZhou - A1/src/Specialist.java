/**
 * Specialist class
 */

public class Specialist extends HealthProfessional {
    private String certificationLevel;

    public Specialist() {
        super();
        this.certificationLevel = "Junior";
    }

    public Specialist(int id, String name, String specialization, String certificationLevel) {
        super(id, name, specialization);
        this.certificationLevel = certificationLevel;
    }

    @Override
    public void printDetails() {
        System.out.println("=== Specialist Details ===");
        super.printDetails();
        System.out.println("Certification Level: " + certificationLevel);
        System.out.println("--------------------------");
    }

    public String getCertificationLevel() { return certificationLevel; }
    public void setCertificationLevel(String certificationLevel) { this.certificationLevel = certificationLevel; }
}