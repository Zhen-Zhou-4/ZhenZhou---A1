import java.util.ArrayList;

/**
 * PROG2004 Assignment 1 - Healthcare Appointment System
 * English Version
 */

public class AssignmentOne {
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        // Part 3 – Using classes and objects
        System.out.println("=== Part 3: Using Classes and Objects ===");

        // Create three General Practitioner objects
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. Smith", "General Medicine", true);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Johnson", "Family Medicine", false);
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr. Williams", "Primary Care", true);

        // Create two Specialist objects
        Specialist sp1 = new Specialist(201, "Dr. Chen", "Cardiology", "Expert");
        Specialist sp2 = new Specialist(202, "Dr. Brown", "Neurology", "Senior");

        // Print all health professional details
        System.out.println("\n--- General Practitioners List ---");
        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();

        System.out.println("\n--- Specialists List ---");
        sp1.printDetails();
        sp2.printDetails();

        System.out.println("---");

        // Part 5 – Collection of appointments
        System.out.println("\n=== Part 5: Appointment Collection Management ===");

        // Create appointments
        System.out.println("\nCreating appointments...");

        // Create 2 appointments with General Practitioners
        createAppointment("John Doe", "13800138001", "09:00", gp1);
        createAppointment("Jane Smith", "13800138002", "10:30", gp2);

        // Create 2 appointments with Specialists
        createAppointment("Mike Wilson", "13800138003", "14:00", sp1);
        createAppointment("Sarah Brown", "13800138004", "15:30", sp2);

        // Print existing appointments
        System.out.println("\nCurrent Appointments:");
        printExistingAppointments();

        // Cancel one appointment
        System.out.println("\nCancelling appointment with mobile: 13800138003");
        cancelBooking("13800138003");

        // Print appointments again to show updated collection
        System.out.println("\nAppointments after cancellation:");
        printExistingAppointments();

        System.out.println("---");

        // Demonstrate additional feature: try to create invalid appointment
        System.out.println("\nAttempting to create invalid appointment (missing information):");
        createAppointment("", "13800138005", "16:00", gp3);

        System.out.println("\n=== Program Execution Completed ===");
    }

    /**
     * Create new appointment and add to ArrayList
     * Due to inheritance, this method can handle appointments with any health professional type
     */
    public static void createAppointment(String patientName, String patientMobile,
                                         String timeSlot, HealthProfessional doctor) {
        // Validate required information
        if (patientName == null || patientName.trim().isEmpty() ||
                patientMobile == null || patientMobile.trim().isEmpty() ||
                timeSlot == null || timeSlot.trim().isEmpty() ||
                doctor == null) {

            System.out.println("Error: Cannot create appointment - Missing required information");
            return;
        }

        // Create new appointment
        Appointment newAppointment = new Appointment(patientName, patientMobile, timeSlot, doctor);
        appointments.add(newAppointment);
        System.out.println("Appointment created successfully: " + patientName + " at " + timeSlot);
    }

    /**
     * Display existing appointments in ArrayList
     * If no existing appointments, print message to indicate this
     */
    public static void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments currently.");
            return;
        }

        System.out.println("Number of existing appointments: " + appointments.size());
        for (int i = 0; i < appointments.size(); i++) {
            System.out.println("\nAppointment #" + (i + 1) + ":");
            appointments.get(i).printAppointmentDetails();
        }
    }

    /**
     * Cancel booking using patient's mobile phone
     * If mobile phone not found in existing appointment, print error message
     */
    public static void cancelBooking(String patientMobile) {
        if (patientMobile == null || patientMobile.trim().isEmpty()) {
            System.out.println("Error: Mobile number cannot be empty");
            return;
        }

        boolean found = false;
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getPatientMobile().equals(patientMobile)) {
                Appointment cancelled = appointments.remove(i);
                System.out.println("Successfully cancelled appointment: Patient " +
                        cancelled.getPatientName() + " (" + patientMobile + ")");
                found = true;
                break; // Assume only one appointment per mobile number
            }
        }

        if (!found) {
            System.out.println("Error: No appointment found with mobile number " + patientMobile);
        }
    }
}