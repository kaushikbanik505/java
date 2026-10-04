public class homeworkOfStringChapter {

    public static void main(String[] args) {
        // Raw data log provided in the scenario details
        String rawDataLog = "AVA,10,850.50;BEN,4,320.00;CHLOE,15,1200.75";

        System.out.println("=== TASK 1: PARSING AND EXTRACTION ===");

        // Step 1.1: Split Records using the semicolon (;) delimiter
        String[] records = rawDataLog.split(";");
        System.out.println("Total records parsed: " + records.length);

        // Step 1.2: Extract First Customer Data using the comma (,) delimiter
        String[] firstCustomerData = records[0].split(",");
        System.out.println("First Customer Details -> Name: " + firstCustomerData[0]
                + " | Time: " + firstCustomerData[1]
                + " | Price: " + firstCustomerData[2]);

        // Step 1.3: Data Verification and Substring
        boolean startsWithBen = records[1].startsWith("BEN");
        System.out.println("Does the second record start with 'BEN'? " + startsWithBen);

        // Extracting only the name ("CHLOE") from the third record via substring()
        // records[2] is "CHLOE,15,1200.75". "CHLOE" ends right before the first comma
        // (index 5)
        int commaIndex = records[2].indexOf(",");
        String thirdCustomerName = records[2].substring(0, commaIndex);
        System.out.println("Extracted third customer name: " + thirdCustomerName);

        System.out.println("\n=== TASK 2: DYNAMIC REPORT GENERATION ===");

        // Step 2.1: Initialize Builder
        java.lang.StringBuilder reportBuilder = new java.lang.StringBuilder();

        // Step 2.2: Loop and Append efficiently
        for (String record : records) {
            String[] details = record.split(",");
            String name = details[0];
            String time = details[1];

            // Appends directly to the active internal character array buffer
            reportBuilder.append(name)
                    .append(" flew for ")
                    .append(time)
                    .append(" hours.\n");
        }

        // Step 2.3: Final String Conversion
        String finalReport = reportBuilder.toString();
        System.out.print(finalReport);
        System.out.println("Total character length of the generated report: " + finalReport.length());

        System.out.println("\n=== TASK 3: PROFESSIONAL FORMATTING ===");

        // Step 3.1: Prepare Data
        String customerName = firstCustomerData[0];
        // Parse the price text sequence cleanly into a double type for
        // calculations/formatting
        double pricePaid = Double.parseDouble(firstCustomerData[2]);

        // Step 3.2: Format Currency Output using String.format() with exactly 2 decimal
        // places
        String summaryAlert = String.format("%s's trip cost: $%.2f", customerName, pricePaid);
        System.out.println(summaryAlert);
    }
}
