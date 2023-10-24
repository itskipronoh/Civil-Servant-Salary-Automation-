import java.util.Scanner;

class CivilServant {
    private String name;
    private String jobTitle;
    private int yearsOfService;

    public CivilServant(String name, String jobTitle, int yearsOfService) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.yearsOfService = yearsOfService;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public double calculateSalary() {
        // Simple salary calculation based on years of service
        // Assuming an initial salary of 50,000 and an annual increment of 2,000 for each year of service
        double baseSalary = 50000;
        double annualIncrement = 2000;
        return baseSalary + (yearsOfService * annualIncrement);
    }
}

class SalaryAutomation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of civil servants: ");
        int numberOfCivilServants = scanner.nextInt();

        CivilServant[] civilServants = new CivilServant[numberOfCivilServants];

        for (int i = 0; i < numberOfCivilServants; i++) {
            scanner.nextLine(); // Consume the newline character
            System.out.println("Enter name of civil servant " + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.println("Enter job title of civil servant " + (i + 1) + ": ");
            String jobTitle = scanner.nextLine();

            System.out.println("Enter years of service of civil servant " + (i + 1) + ": ");
            int yearsOfService = scanner.nextInt();

            civilServants[i] = new CivilServant(name, jobTitle, yearsOfService);
        }

        // Display the salary details of each civil servant
        System.out.println("\nSalary Details for Civil Servants:");
        for (CivilServant civilServant : civilServants) {
            System.out.println("Name: " + civilServant.getName());
            System.out.println("Job Title: " + civilServant.getJobTitle());
            System.out.println("Years of Service: " + civilServant.getYearsOfService());
            System.out.println("Salary: $" + civilServant.calculateSalary()); // Display salary in dollars
            System.out.println();
        }
    }
}
