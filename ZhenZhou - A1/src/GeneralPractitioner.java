/**
 * General Practitioner class
 */

public class GeneralPractitioner extends HealthProfessional {
    private boolean acceptingNewPatients;

    public GeneralPractitioner() {
        super();
        this.acceptingNewPatients = true;
    }

    public GeneralPractitioner(int id, String name, String specialization, boolean acceptingNewPatients) {
        super(id, name, specialization);
        this.acceptingNewPatients = acceptingNewPatients;
    }

    @Override
    public void printDetails() {
        System.out.println("=== General Practitioner Details ===");
        super.printDetails();
        System.out.println("Accepting New Patients: " + (acceptingNewPatients ? "Yes" : "No"));
        System.out.println("------------------------------------");
    }

    public boolean isAcceptingNewPatients() { return acceptingNewPatients; }
    public void setAcceptingNewPatients(boolean acceptingNewPatients) { this.acceptingNewPatients = acceptingNewPatients; }
}