/**
 * Appointment class
 */

public class Appointment {
    private String patientName;
    private String patientMobile;
    private String timeSlot;
    private HealthProfessional doctor;

    public Appointment() {
        this.patientName = "Unknown";
        this.patientMobile = "Unknown";
        this.timeSlot = "Not specified";
        this.doctor = null;
    }

    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.timeSlot = timeSlot;
        this.doctor = doctor;
    }

    public void printAppointmentDetails() {
        System.out.println("=== Appointment Details ===");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile: " + patientMobile);
        System.out.println("Time Slot: " + timeSlot);
        System.out.println("Appointed Doctor: ");
        if (doctor != null) {
            doctor.printDetails();
        } else {
            System.out.println("No doctor specified");
        }
        System.out.println("===========================");
    }

    // Getter and Setter methods
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public String getPatientMobile() { return patientMobile; }
    public void setPatientMobile(String patientMobile) { this.patientMobile = patientMobile; }
    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }
    public HealthProfessional getDoctor() { return doctor; }
    public void setDoctor(HealthProfessional doctor) { this.doctor = doctor; }
}