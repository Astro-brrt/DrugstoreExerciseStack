import java.util. Scanner;
import java.io.FileWriter;
import java. io.IOException;

// Simple class to store info for an exercise
class Exercise {
    String name;
    String disease;
    String facts;
    String steps;
    String reps;      // e.g., "10 repetitions"
    String sets;      // e.g., "5 sets"
    String imageUrl;  // Image URL for the exercise

    // Constructor to initialize exercise data
    Exercise(String name, String disease, String facts, String steps, String reps, String sets, String imageUrl) {
        this.name = name;
        this.disease = disease;
        this.facts = facts;
        this.steps = steps;
        this.reps = reps;
        this.sets = sets;
        this.imageUrl = imageUrl;
    }
}

public class DrugstoreExerciseStack {
    // Array to store all exercises - can be expanded with more entries
    static Exercise[] exercises = {
        // --- Neck Pain Examples ---
        new Exercise(
            "Neck Stretch",
            "Neck Pain",
            "This exercise gently stretches the side muscles of your neck.  It is highly effective in relieving daily muscle stiffness and tension.  Reduces chronic neck tension and stiffness. Significantly improves neck flexibility and range of motion. Can help prevent tension headaches caused by tight neck muscles.",
            "Sit up straight.  Slowly tilt your head to the left, holding for 10 counts/seconds. Repeat the tilt to the right side, holding for 10 counts/seconds.",
            "10 counts each side",
            "5 sets",
            "https://images.unsplash.com/photo-1574680178050-55a44bdfb914?w=500&h=400&fit=crop"
        ),
        new Exercise(
            "Shoulder Shrugs",
            "Neck Pain",
            "Shoulder shrugs are a simple, low-impact movement that targets the upper trapezius muscle. This helps in loosening tight muscles that run from the shoulders up to the neck. Relieves tension specifically in the upper back and neck region. Increases blood circulation to the shoulder and neck muscles. Aids in reducing muscular fatigue from prolonged sitting.",
            "Lift your shoulders straight up toward your ears, hold this tight position for 5 counts/seconds. Then relax and drop them down.",
            "10 repetitions",
            "3 sets",
            "https://images.unsplash.com/photo-1599058917212-d750089bc07e?w=500&h=400&fit=crop"
        ),
        new Exercise(
            "Chin Tucks",
            "Neck Pain",
            "This is a key exercise for correcting forward head posture. It works by strengthening the deep neck flexor muscles at the front of your neck. Strengthens deep neck muscles for better spinal stability. Significantly improves overall cervical posture by pulling the head back over the shoulders.  Helps in the long-term reduction of chronic neck pain.",
            "Gently pull your chin straight back toward your throat without tilting your head up or down, holding the deep tuck for 5 counts/seconds.",
            "10 repetitions",
            "3 sets",
            "https://images.unsplash.com/photo-1603521914906-c3852e92fb5d?w=500&h=400&fit=crop"
        ),

        // --- Shoulder Pain Examples ---
        new Exercise(
            "Arm Raise",
            "Shoulder Pain",
            "The arm raise is a basic range-of-motion exercise that helps to keep the shoulder joint loose and functional. It is performed slowly to avoid any sudden jarring of the painful joint. Works to safely improve shoulder mobility and range of motion. Increases circulation to the muscles and ligaments around the shoulder.  Helps prevent the onset of stiffness (e.g., frozen shoulder).",
            "Start with arms down by your sides. Slowly lift your arms straight out in front of you until they are overhead (or as high as comfortable), then slowly lower them back down.",
            "10 repetitions",
            "2 sets",
            "https://images.unsplash.com/photo-1534438327276-14e5300c3a48?w=500&h=400&fit=crop"
        ),
        new Exercise(
            "Shoulder Circles",
            "Shoulder Pain",
            "This is a dynamic stretch that gently warms up and activates the rotator cuff and surrounding shoulder muscles. It is essential for loosening any tightness built up in the upper body. Effectively reduces stiffness in the shoulder girdle.  Promotes a greater and smoother range of movement.  Serves as an excellent warm-up before performing more intense shoulder exercises.",
            "Rotate your shoulders in small, smooth circles forward for 10 complete counts, then reverse direction and rotate them backward.",
            "10 counts in each direction",
            "2 sets",
            "https://images.unsplash.com/photo-1571019614242-c5c5dee9f50b?w=500&h=400&fit=crop"
        ),

        // --- Back Pain Examples ---
        new Exercise(
            "Cat-Cow Stretch",
            "Back Pain",
            "The Cat-Cow is a foundational yoga pose that gently stretches and mobilizes the entire spine from the tailbone to the neck. This movement lubricates the spinal discs and is excellent for warming up the back.  Reduces chronic back tension and pressure on spinal nerves. Dramatically improves overall spine flexibility and mobility.  Strengthens abdominal muscles which support the lower back.",
            "Start on your hands and knees.  Slowly arch your back upward (Cat Pose) while tucking your chin, then slowly move to the opposite position by dropping your stomach and lifting your head (Cow Pose).",
            "10 full cycles",
            "3 sets",
            "https://images.unsplash.com/photo-1506126613408-eca07ce68773?w=500&h=400&fit=crop"
        ),
        new Exercise(
            "Lower Back Stretch",
            "Back Pain",
            "This stretch is performed lying down and is highly effective at releasing tight muscles in the lumbar region (lower back). It gently decompresses the spine and is often recommended for immediate pain relief. Provides immediate and effective relief for lower back pain. Gently stretches the gluteal muscles which connect to the lower back.  A good exercise for releasing tension before sleep.",
            "Lie on your back and slowly pull both knees toward your chest, holding the stretch tightly for 10 counts/seconds.",
            "5 full repetitions",
            "2 sets",
            "https://images.unsplash.com/photo-1506126613408-eca07ce68773?w=500&h=400&fit=crop"
        ),

        // --- Leg Pain Examples ---
        new Exercise(
            "Leg Stretch",
            "Leg Pain",
            "This stretch specifically targets the hamstrings, which are the large muscles running down the back of the thighs.  Tight hamstrings are a common cause of pain that can radiate down the leg. Dramatically enhances the flexibility of the hamstrings. Improves overall blood circulation throughout the entire leg. Reduces the risk of muscle strain during physical activity.",
            "Sit on the floor with legs straight and reach toward your toes, holding the deepest point of the stretch for 15 counts/seconds.",
            "3 repetitions, holding for 15 counts/seconds",
            "1 set",
            "https://images.unsplash.com/photo-1506126613408-eca07ce68773?w=500&h=400&fit=crop"
        ),
        new Exercise(
            "Heel Raises",
            "Leg Pain",
            "Heel raises are a primary way to strengthen the calf muscles (gastrocnemius and soleus) in the lower leg. Strong calf muscles help support your weight and reduce strain on other leg joints. Strengthens the calf muscles in the lower legs. Significant help in improving overall balance and stability.  Increases the strength needed for walking and running.",
            "Stand while holding onto a chair for balance.  Slowly lift your heels as high as possible, standing on the balls of your feet, then slowly lower.",
            "15 slow, controlled repetitions",
            "2 sets",
            "https://images.unsplash.com/photo-1518611505868-48510c8cf237?w=500&h=400&fit=crop"
        ),

        // --- Asthma / Difficulty Breathing Examples ---
        new Exercise(
            "Pursed-Lip Breathing",
            "Asthma / Difficulty Breathing",
            "This technique controls the rate of exhalation, forcing the airways to stay open longer, which allows trapped air to be released. This helps the lungs work more efficiently and reduces the feeling of shortness of breath. Reduces shortness of breath and helps regain breathing control during flare-ups. Keeps airways open longer, ensuring more complete oxygen exchange.  Promotes overall relaxation by slowing down the breathing rate.",
            "Inhale slowly through your nose for a count of 2.  Then, exhale slowly through puckered lips (like blowing out a candle) for a count of 4 or longer.",
            "10 complete cycles",
            "2 sets",
            "https://images.unsplash.com/photo-1506126613408-eca07ce68773?w=500&h=400&fit=crop"
        ),
        new Exercise(
            "Diaphragmatic Breathing",
            "Asthma / Difficulty Breathing",
            "Also known as belly breathing, this technique focuses on using the diaphragm, the primary muscle for breathing, instead of shallow chest breathing. Strengthening the diaphragm improves overall lung capacity and oxygen intake. Strengthens the diaphragm, the most important breathing muscle. Significantly improves lung efficiency and capacity over time. Helps to conserve energy by making breathing less strenuous.",
            "Place one hand on your chest and one on your stomach. Breathe slowly and deeply through your nose, making sure only the hand on your stomach rises, then exhale gently.",
            "10 full breaths",
            "2 sets",
            "https://images.unsplash.com/photo-1506126613408-eca07ce68773?w=500&h=400&fit=crop"
        )
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String disease = "";

        try {
            // ===== USER INPUT SECTION =====
            System.out.println("========================================");
            System.out.println("Welcome to Drugstore Exercise Stack!");
            System.out.println("========================================\n");

            // Input validation for name
            System.out.print("Enter your name: ");
            name = scanner.nextLine();

            // Error handling:  Check if name is empty
            if (name.trim().isEmpty()) {
                System.out.println("Error: Name cannot be empty!  Please try again.");
                scanner.close();
                return;
            }

            // Input validation for disease
            System.out.print("Enter your disease or condition (e.g., Neck Pain, Shoulder Pain, Back Pain, Leg Pain, Asthma / Difficulty Breathing): ");
            disease = scanner.nextLine();

            // Error handling: Check if disease is empty
            if (disease. trim().isEmpty()) {
                System.out.println("Error: Disease cannot be empty! Please try again.");
                scanner.close();
                return;
            }

            // ===== SEARCH FOR MATCHING EXERCISES =====
            boolean found = false;
            for (Exercise ex : exercises) {
                // Case-insensitive disease matching
                if (ex.disease.equalsIgnoreCase(disease. trim())) {
                    found = true;

                    // Print console output
                    printConsoleOutput(name, disease, ex);

                    // Generate HTML file with exercise image
                    generateHTMLReport(name, disease, ex);

                    break; // Exit after finding first match
                }
            }

            // ERROR HANDLING: If no exercise found
            if (!found) {
                System.out.println("\n========================================");
                System.out. println("ERROR: NO EXERCISE FOUND");
                System.out.println("========================================");
                System.out.println("Sorry, " + name + ", no exercise suggestions found for \"" + disease + "\".");
                System.out.println("Please check your disease spelling or try another condition.");
                System.out.println("Available conditions: Neck Pain, Shoulder Pain, Back Pain, Leg Pain, Asthma / Difficulty Breathing");
                System.out. println("========================================\n");
            }

        } catch (Exception e) {
            // Catch any unexpected errors
            System. out.println("Error: An unexpected error occurred:  " + e.getMessage());
        } finally {
            // Always close the scanner to prevent resource leaks
            scanner. close();
        }
    }

    // Method to print console output
    public static void printConsoleOutput(String name, String disease, Exercise ex) {
        // ===== SECTION 1:  SUGGESTED EXERCISE =====
        System.out.println("\n========================================");
        System.out.println("SUGGESTED EXERCISE FOR " + disease. toUpperCase());
        System.out.println("========================================");
        System.out.println("Suggested exercise for " + disease + " is " + ex.name);

        // ===== SECTION 2: DISEASE AND FACTS =====
        System.out. println("\n========================================");
        System.out.println("EXERCISE FACTS AND BENEFITS");
        System.out.println("========================================");
        System.out.println("Disease/Condition: " + ex.disease);
        System.out.println("Exercise Name: " + ex.name);
        System.out.println("Facts: " + ex.facts);

        // ===== SECTION 3: HOW TO PERFORM THE EXERCISE =====
        System.out.println("\n========================================");
        System.out.println("HOW TO PERFORM THE EXERCISE");
        System.out.println("========================================");
        System.out.println("Steps:  " + ex.steps);

        // ===== SECTION 4: REPETITIONS AND SETS =====
        System.out.println("\n========================================");
        System.out. println("REPETITIONS AND SETS");
        System.out.println("========================================");
        System.out.println("Repetitions: " + ex.reps);
        System.out.println("Sets: " + ex.sets);

        // ===== SECTION 5: SUMMARY =====
        System.out. println("\n========================================");
        System.out.println("EXERCISE SUMMARY");
        System.out.println("========================================");
        System.out.println("Name: " + name);
        System.out.println("Exercise: " + ex.name);
        System.out.println("Total Work:  Perform " + ex.reps + " for " + ex.sets + ".");
        System.out.println("========================================\n");
        System.out.println("HTML Report generated: exercise_report.html");
    }

    // Method to generate HTML report with exercise image
    public static void generateHTMLReport(String name, String disease, Exercise ex) {
        // HTML content with styled design
        String htmlContent = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>Drugstore Exercise Stack - " + ex.name + "</title>\n" +
            "    <style>\n" +
            "        * {\n" +
            "            margin: 0;\n" +
            "            padding: 0;\n" +
            "            box-sizing: border-box;\n" +
            "        }\n" +
            "        body {\n" +
            "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
            "            background:  linear-gradient(135deg, #667eea 0%, #764ba2 100%);\n" +
            "            min-height: 100vh;\n" +
            "            padding: 20px;\n" +
            "        }\n" +
            "        .container {\n" +
            "            max-width: 900px;\n" +
            "            margin: 0 auto;\n" +
            "            background: white;\n" +
            "            border-radius: 10px;\n" +
            "            box-shadow: 0 10px 40px rgba(0, 0, 0, 0.2);\n" +
            "            padding: 30px;\n" +
            "        }\n" +
            "        h1 {\n" +
            "            text-align: center;\n" +
            "            color:  #333;\n" +
            "            margin-bottom: 30px;\n" +
            "            font-size: 2.5em;\n" +
            "        }\n" +
            "        .section {\n" +
            "            background: #f8f9fa;\n" +
            "            padding: 20px;\n" +
            "            margin-bottom: 20px;\n" +
            "            border-radius: 8px;\n" +
            "            border-left: 5px solid #667eea;\n" +
            "        }\n" +
            "        .section h2 {\n" +
            "            color: #667eea;\n" +
            "            margin-bottom: 15px;\n" +
            "            font-size: 1.5em;\n" +
            "        }\n" +
            "        .section p {\n" +
            "            color: #555;\n" +
            "            line-height: 1.8;\n" +
            "            font-size: 1.05em;\n" +
            "        }\n" +
            "        .exercise-image {\n" +
            "            text-align: center;\n" +
            "            margin: 20px 0;\n" +
            "        }\n" +
            "        .exercise-image img {\n" +
            "            max-width: 100%;\n" +
            "            height:  auto;\n" +
            "            border-radius: 8px;\n" +
            "            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);\n" +
            "        }\n" +
            "        .summary-box {\n" +
            "            background: #e7f3ff;\n" +
            "            border:  2px solid #667eea;\n" +
            "            padding: 15px;\n" +
            "            border-radius: 5px;\n" +
            "            margin-top: 15px;\n" +
            "        }\n" +
            "        .summary-box p {\n" +
            "            margin: 10px 0;\n" +
            "        }\n" +
            "        .summary-box strong {\n" +
            "            color: #667eea;\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <div class=\"container\">\n" +
            "        <h1>💪 Drugstore Exercise Stack</h1>\n" +
            "\n" +
            "        <!-- SECTION 1: SUGGESTED EXERCISE -->\n" +
            "        <div class=\"section\">\n" +
            "            <h2>✨ Suggested Exercise</h2>\n" +
            "            <p>Suggested exercise for <strong>" + disease + "</strong> is <strong>" + ex.name + "</strong></p>\n" +
            "        </div>\n" +
            "\n" +
            "        <!-- SECTION 2: DISEASE AND FACTS -->\n" +
            "        <div class=\"section\">\n" +
            "            <h2>📋 Exercise Facts and Benefits</h2>\n" +
            "            <p><strong>Disease/Condition:</strong> " + ex. disease + "</p>\n" +
            "            <p><strong>Exercise Name:</strong> " + ex.name + "</p>\n" +
            "            <p><strong>Facts:</strong> " + ex.facts + "</p>\n" +
            "        </div>\n" +
            "\n" +
            "        <!-- SECTION 3: HOW TO PERFORM -->\n" +
            "        <div class=\"section\">\n" +
            "            <h2>🎯 How to Perform the Exercise</h2>\n" +
            "            <p>" + ex.steps + "</p>\n" +
            "        </div>\n" +
            "\n" +
            "        <!-- SECTION 4: EXERCISE IMAGE -->\n" +
            "        <div class=\"section\">\n" +
            "            <h2>📸 Exercise Demonstration</h2>\n" +
            "            <div class=\"exercise-image\">\n" +
            "                <img src=\"" + ex.imageUrl + "\" alt=\"" + ex.name + " demonstration\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "        <!-- SECTION 5: REPETITIONS AND SETS -->\n" +
            "        <div class=\"section\">\n" +
            "            <h2>🔢 Repetitions and Sets</h2>\n" +
            "            <p><strong>Repetitions:</strong> " + ex.reps + "</p>\n" +
            "            <p><strong>Sets:</strong> " + ex.sets + "</p>\n" +
            "        </div>\n" +
            "\n" +
            "        <!-- SECTION 6: SUMMARY -->\n" +
            "        <div class=\"section\">\n" +
            "            <h2>📊 Exercise Summary</h2>\n" +
            "            <div class=\"summary-box\">\n" +
            "                <p><strong>User Name:</strong> " + name + "</p>\n" +
            "                <p><strong>Exercise: </strong> " + ex.name + "</p>\n" +
            "                <p><strong>Total Work:</strong> Perform " + ex.reps + " for " + ex.sets + ".</p>\n" +
            "                <p><strong>Condition:</strong> " + disease + "</p>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</body>\n" +
            "</html>";

        // Write HTML to file
        try {
            FileWriter fileWriter = new FileWriter("exercise_report.html");
            fileWriter.write(htmlContent);
            fileWriter.close();
            System.out.println("✅ HTML Report successfully generated: exercise_report.html");
        } catch (IOException e) {
            System.out.println("Error writing HTML file: " + e.getMessage());
        }
    }
}