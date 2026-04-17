import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java. awt.*;
import java.awt. event.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


class Exercise {
    String name;
    String disease;
    String facts;
    String[] steps;  // Changed to array for individual steps
    String reps;
    String sets;
    String imageUrl;

    Exercise(String name, String disease, String facts, String[] steps, String reps, String sets, String imageUrl) {
        this.name = name;
        this. disease = disease;
        this.facts = facts;
        this. steps = steps;
        this.reps = reps;
        this.sets = sets;
        this.imageUrl = imageUrl;
    }
}

public class DrugstoreExerciseStackGUI extends JFrame {
    private JTextField nameField;
    private JTextField diseaseField;
    private JPanel contentPanel;
    private JLabel stepLabel;
    private Exercise currentExercise;
    private String userName;
    private int currentStep = 1;
    private JButton prevButton;
    private JButton nextButton;
    private JButton goBackButton;
    private JPanel buttonPanel;
    private int currentExerciseStep = 0;  // Track which exercise step we're on

    static Exercise[] exercises = {
        // --- Neck Pain Examples ---
        new Exercise(
            "Neck Stretch",
            "Neck Pain",
            "This exercise gently stretches the side muscles of your neck.  It is highly effective in relieving daily muscle stiffness and tension. Reduces chronic neck tension and stiffness.  Significantly improves neck flexibility and range of motion.   Can help prevent tension headaches caused by tight neck muscles.",
            new String[]{
                "Sit up straight.",
                "Slowly tilt your head to the left, holding for 10 counts/seconds.",
                "Repeat the tilt to the right side, holding for 10 counts/seconds."
            },
            "10 counts each side",
            "5 sets",
            "https://innovationphysio.com/wp-content/uploads/2025/03/innovation_blog_7-Best-Stretching-Exercises-for-Neck-Pain-Relief3.jpg"
        ),
        new Exercise(
            "Shoulder Shrugs",
            "Neck Pain",
            "Shoulder shrugs are a simple, low-impact movement that targets the upper trapezius muscle. This helps in loosening tight muscles that run from the shoulders up to the neck. Relieves tension specifically in the upper back and neck region. Increases blood circulation to the shoulder and neck muscles.  Aids in reducing muscular fatigue from prolonged sitting.",
            new String[]{
                "Lift your shoulders straight up toward your ears.",
                "Hold this tight position for 5 counts/seconds.",
                "Then relax and drop them down."
            },
            "10 repetitions",
            "3 sets",
            "https://www.saraholiverosteopathy.com/wp-content/uploads/2017/01/shoulder-shrugs. jpg"
        ),
        // --- Shoulder Pain Examples ---
        new Exercise(
            "Arm Raise",
            "Shoulder Pain",
            "The arm raise is a basic range-of-motion exercise that helps to keep the shoulder joint loose and functional. It is performed slowly to avoid any sudden jarring of the painful joint. Works to safely improve shoulder mobility and range of motion. Increases circulation to the muscles and ligaments around the shoulder.   Helps prevent the onset of stiffness (e.g., frozen shoulder).",
            new String[]{
                "Start with arms down by your sides.",
                "Slowly lift your arms straight out in front of you until they are overhead (or as high as comfortable).",
                "Slowly lower them back down."
            },
            "10 repetitions",
            "2 sets",
            "https://thumbs.dreamstime.com/b/arm-raise-exercise-man-sport-clothes-doing-warm-up-arm-raise-exercise-man-sport-clothes-doing-warm-up-workout-idea-155128603.jpg"
        ),
        new Exercise(
            "Shoulder Circles",
            "Shoulder Pain",
            "This is a dynamic stretch that gently warms up and activates the rotator cuff and surrounding shoulder muscles. It is essential for loosening any tightness built up in the upper body. Effectively reduces stiffness in the shoulder girdle. Promotes a greater and smoother range of movement. Serves as an excellent warm-up before performing more intense shoulder exercises.",
            new String[]{
                "Rotate your shoulders in small, smooth circles forward for 10 complete counts.",
                "Then reverse direction and rotate them backward for 10 complete counts."
            },
            "10 counts in each direction",
            "2 sets",
            "https://kettlebellsworkouts.com/wp-content/uploads/2019/02/24-Rolling_Shoulder_Circles.png"
        ),
        // --- Back Pain Examples ---
        new Exercise(
            "Cat-Cow Stretch",
            "Back Pain",
            "The Cat-Cow is a foundational yoga pose that gently stretches and mobilizes the entire spine from the tailbone to the neck. This movement lubricates the spinal discs and is excellent for warming up the back.  Reduces chronic back tension and pressure on spinal nerves. Dramatically improves overall spine flexibility and mobility. Strengthens abdominal muscles which support the lower back.",
            new String[]{
                "Start on your hands and knees.",
                "Slowly arch your back upward (Cat Pose) while tucking your chin.",
                "Then slowly move to the opposite position by dropping your stomach and lifting your head (Cow Pose).",
                "Repeat this cycle smoothly."
            },
            "10 full cycles",
            "3 sets",
            "https://www.verywellfit.com/thmb/fs76ElRyXEifvR6wLcdmKS6MEgs=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/About-A3-CatCow-019-570d44f83df78c7d9e3c571e.jpg"
        ),
        new Exercise(
            "Lower Back Stretch",
            "Back Pain",
            "This stretch is performed lying down and is highly effective at releasing tight muscles in the lumbar region (lower back). It gently decompresses the spine and is often recommended for immediate pain relief. Provides immediate and effective relief for lower back pain. Gently stretches the gluteal muscles which connect to the lower back. A good exercise for releasing tension before sleep.",
            new String[]{
                "Lie on your back.",
                "Slowly pull both knees toward your chest.",
                "Hold the stretch tightly for 10 counts/seconds."
            },
            "5 full repetitions",
            "2 sets",
            "https://media.post.rvohealth.io/wp-content/uploads/2024/05/young-woman-stretching-childs-pose-yoga-mat-indoors-732x549-thumbnail.jpg"
        ),
        // --- Leg Pain Examples ---
        new Exercise(
            "Leg Stretch",
            "Leg Pain",
            "This stretch specifically targets the hamstrings, which are the large muscles running down the back of the thighs. Tight hamstrings are a common cause of pain that can radiate down the leg. Dramatically enhances the flexibility of the hamstrings.   Improves overall blood circulation throughout the entire leg. Reduces the risk of muscle strain during physical activity.",
            new String[]{
                "Sit on the floor with legs straight.",
                "Reach toward your toes.",
                "Hold the deepest point of the stretch for 15 counts/seconds."
            },
            "3 repetitions, holding for 15 counts/seconds",
            "1 set",
            "https://thumbs.dreamstime.com/b/home-workout-sporty-mature-man-stretching-her-leg-yoga-mat-living-room-free-space-positive-man-doing-flexibility-exercises-224102339.jpg"
        ),
        new Exercise(
            "Heel Raises",
            "Leg Pain",
            "Heel raises are a primary way to strengthen the calf muscles (gastrocnemius and soleus) in the lower leg. Strong calf muscles help support your weight and reduce strain on other leg joints. Strengthens the calf muscles in the lower legs. Significant help in improving overall balance and stability. Increases the strength needed for walking and running.",
            new String[]{
                "Stand while holding onto a chair for balance.",
                "Slowly lift your heels as high as possible, standing on the balls of your feet.",
                "Then slowly lower back down.",
                "Repeat in slow, controlled motions."
            },
            "15 slow, controlled repetitions",
            "2 sets",
            "https://justfit.app/wp-content/uploads/2024/04/heel-raises.png"
        ),
        // --- Asthma / Difficulty Breathing Examples ---
        new Exercise(
            "Pursed-Lip Breathing",
            "Asthma / Difficulty Breathing",
            "This technique controls the rate of exhalation, forcing the airways to stay open longer, which allows trapped air to be released. This helps the lungs work more efficiently and reduces the feeling of shortness of breath. Reduces shortness of breath and helps regain breathing control during flare-ups. Keeps airways open longer, ensuring more complete oxygen exchange.  Promotes overall relaxation by slowing down the breathing rate.",
            new String[]{
                "Inhale slowly through your nose for a count of 2.",
                "Then exhale slowly through puckered lips (like blowing out a candle) for a count of 4 or longer."
            },
            "10 complete cycles",
            "2 sets",
            "https://media.istockphoto.com/id/1489423202/vector/side-view-of-relaxed-woman-deep-breathing-exercise-at-home-mental-health-concept-flat-vector.jpg?s=612x612&w=0&k=20&c=SPllTTzP2vgDTxbGua3ZhSt57phQ4VI0RVB8J2DHujY="
        ),
        new Exercise(
            "Diaphragmatic Breathing",
            "Asthma / Difficulty Breathing",
            "Also known as belly breathing, this technique focuses on using the diaphragm, the primary muscle for breathing, instead of shallow chest breathing.  Strengthening the diaphragm improves overall lung capacity and oxygen intake. Strengthens the diaphragm, the most important breathing muscle. Significantly improves lung efficiency and capacity over time. Helps to conserve energy by making breathing less strenuous.",
            new String[]{
                "Place one hand on your chest and one on your stomach.",
                "Breathe slowly and deeply through your nose, making sure only the hand on your stomach rises.",
                "Then exhale gently."
            },
            "10 full breaths",
            "2 sets",
            "https://physicaltherapyprescott.com/wp-content/uploads/2016/02/diaphragmatic-breathing-exercise-while-sitting.jpg"
        )
    };

    public DrugstoreExerciseStackGUI() {
        setTitle(" ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(true);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(245, 245, 245));

        // ===== HEADER =====
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(102, 126, 234));
        headerPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        stepLabel = new JLabel("Enter Your Information");
        stepLabel.setFont(new Font("Arial", Font. BOLD, 20));
        stepLabel.setForeground(Color.WHITE);
        headerPanel.add(stepLabel);

        // ===== CONTENT PANEL =====
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel. setBorder(new EmptyBorder(20, 20, 20, 20));

        // ===== BUTTON PANEL =====
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(245, 245, 245));

        prevButton = new JButton("Previous");
        prevButton. setFont(new Font("Arial", Font.BOLD, 12));
        prevButton.setBackground(new Color(150, 150, 150));
        prevButton.setForeground(Color.WHITE);
        prevButton.setFocusPainted(false);
        prevButton.setEnabled(false);
        prevButton.addActionListener(e -> previousStep());

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font. BOLD, 12));
        nextButton.setBackground(new Color(255, 159, 64));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.addActionListener(e -> nextStep());

        goBackButton = new JButton("Go back to the information page");
        goBackButton.setFont(new Font("Arial", Font.BOLD, 12));
        goBackButton.setBackground(new Color(76, 175, 80));
        goBackButton.setForeground(Color.WHITE);
        goBackButton.setFocusPainted(false);
        goBackButton.addActionListener(e -> goBackToInfoPage());

        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(goBackButton);

        // Show Step 1
        showStep1();

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    // Helper method to show/hide buttons
    private void updateButtonVisibility(boolean showPrev, boolean showNext, boolean showGoBack) {
        prevButton.setVisible(showPrev);
        prevButton.setEnabled(showPrev);
        nextButton.setVisible(showNext);
        nextButton.setEnabled(showNext);
        goBackButton.setVisible(showGoBack);
        goBackButton.setEnabled(showGoBack);
        buttonPanel.revalidate();
        buttonPanel. repaint();
    }

    // ===== GO BACK TO INFORMATION PAGE =====
    private void goBackToInfoPage() {
        nameField.setText("");
        diseaseField.setText("");
        currentExerciseStep = 0;
        showStep1();
    }

    // ===== STEP 1: INPUT WITH ENTER BUTTON & SUGGESTION =====
    private void showStep1() {
        contentPanel.removeAll();
        contentPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints. HORIZONTAL;

        JLabel titleLabel = new JLabel("Enter Your Information");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPanel.add(titleLabel, gbc);

        JLabel nameLabel = new JLabel("Your Name:");
        nameLabel.setFont(new Font("Arial", Font. PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        contentPanel.add(nameLabel, gbc);

        nameField = new JTextField(30);
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        contentPanel.add(nameField, gbc);

        JLabel diseaseLabel = new JLabel("Disease/Condition:");
        diseaseLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPanel.add(diseaseLabel, gbc);

        diseaseField = new JTextField(30);
        diseaseField.setFont(new Font("Arial", Font. PLAIN, 14));
        gbc.gridx = 1;
        contentPanel.add(diseaseField, gbc);

        // Enter Button
        JButton enterButton = new JButton("Enter");
        enterButton.setFont(new Font("Arial", Font.BOLD, 12));
        enterButton.setBackground(new Color(76, 175, 80));
        enterButton.setForeground(Color.WHITE);
        enterButton.setFocusPainted(false);
        enterButton. addActionListener(e -> showSuggestions());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(30, 15, 15, 15);
        contentPanel.add(enterButton, gbc);

        contentPanel.revalidate();
        contentPanel. repaint();

        stepLabel.setText("Enter Your Information");
        currentStep = 1;
        updateButtonVisibility(false, false, false);

        // Allow Enter key to submit
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    showSuggestions();
                }
            }
        });

        diseaseField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    showSuggestions();
                }
            }
        });
    }

    // Find all exercises matching the disease/condition
    private List<Exercise> findExercises(String disease) {
        List<Exercise> matchingExercises = new ArrayList<>();
        for (Exercise ex : exercises) {
            if (ex.disease.toLowerCase().contains(disease.toLowerCase())) {
                matchingExercises.add(ex);
            }
        }
        return matchingExercises;
    }

    // ===== STEP 1.5: SHOW TWO EXERCISE SUGGESTIONS =====
    private void showSuggestions() {
        String name = nameField.getText().trim();
        String disease = diseaseField.getText().trim();

        if (name.isEmpty() || disease.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both name and disease/condition!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        userName = name;
        List<Exercise> matchingExercises = findExercises(disease);

        if (matchingExercises.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No exercise found for: " + disease, "Not Found", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Show up to 2 exercises
        contentPanel.removeAll();
        contentPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Your Information");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPanel.add(titleLabel, gbc);

        JLabel nameValueLabel = new JLabel("Name:      " + userName);
        nameValueLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        contentPanel.add(nameValueLabel, gbc);

        JLabel diseaseValueLabel = new JLabel("Condition: " + disease);
        diseaseValueLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 2;
        contentPanel.add(diseaseValueLabel, gbc);

        // Suggested Exercises Section
        JLabel suggestionTitle = new JLabel("Suggested Exercises");
        suggestionTitle.setFont(new Font("Arial", Font. BOLD, 16));
        gbc.gridy = 3;
        gbc.insets = new Insets(30, 15, 20, 15);
        contentPanel.add(suggestionTitle, gbc);

        // Display up to 2 exercise buttons
        int exerciseCount = Math.min(2, matchingExercises.size());
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.gridwidth = 1;

        for (int i = 0; i < exerciseCount; i++) {
            Exercise ex = matchingExercises.get(i);
            JButton exerciseButton = new JButton(ex.name);
            exerciseButton.setFont(new Font("Arial", Font.BOLD, 14));
            exerciseButton.setBackground(new Color(255, 159, 64));
            exerciseButton.setForeground(Color.WHITE);
            exerciseButton.setFocusPainted(false);
            exerciseButton.setPreferredSize(new Dimension(300, 50));
            exerciseButton.addActionListener(e -> {
                currentExercise = ex;
                currentExerciseStep = 0;
                showFacts();
            });

            gbc.gridx = i % 2;
            gbc. gridy = 4 + (i / 2);
            contentPanel.add(exerciseButton, gbc);
        }

        contentPanel.add(Box.createVerticalGlue());

        contentPanel.revalidate();
        contentPanel.repaint();

        stepLabel.setText("Choose Your Exercise");
        currentStep = 1;
        updateButtonVisibility(false, false, false);
    }

    // ===== STEP 2: FACTS & BENEFITS =====
    private void showFacts() {
        contentPanel.removeAll();
        contentPanel. setLayout(new BoxLayout(contentPanel, BoxLayout. Y_AXIS));

        JLabel suggestLabel = new JLabel(" " + currentExercise.name);
        suggestLabel.setFont(new Font("Arial", Font. BOLD, 20));
        contentPanel.add(suggestLabel);

        contentPanel.add(Box.createVerticalStrut(20));

        JLabel factsLabel = new JLabel("Exercise Facts and Benefits");
        factsLabel. setFont(new Font("Arial", Font.BOLD, 20));
        contentPanel.add(factsLabel);

        JTextArea factsArea = new JTextArea(currentExercise.facts);
        factsArea.setEditable(false);
        factsArea.setLineWrap(true);
        factsArea.setWrapStyleWord(true);
        factsArea.setFont(new Font("Arial", Font.PLAIN, 18));
        factsArea.setBackground(new Color(240, 240, 240));
        factsArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        JScrollPane scrollFacts = new JScrollPane(factsArea);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(scrollFacts);

        contentPanel.add(Box.createVerticalGlue());

        contentPanel.revalidate();
        contentPanel.repaint();

        stepLabel.setText("Exercise Facts & Benefits");
        currentStep = 2;
        updateButtonVisibility(true, true, false);
    }

    // ===== STEP 3: HOW TO PERFORM - ONE STEP PER PAGE =====
	private void showHowToPerform() {
		contentPanel.removeAll();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		// Total steps count
		int totalSteps = currentExercise.steps.length;
    
		JLabel stepsLabel = new JLabel("Step " + (currentExerciseStep + 1) + " of " + totalSteps);
		stepsLabel.setFont(new Font("Arial", Font. BOLD, 20));
		contentPanel.add(stepsLabel);

		contentPanel.add(Box.createVerticalStrut(20));

		// Current step content
		JLabel currentStepLabel = new JLabel("Exercise Step:");
		currentStepLabel.setFont(new Font("Arial", Font.BOLD, 18));
		contentPanel.add(currentStepLabel);

		JTextArea stepArea = new JTextArea(currentExercise.steps[currentExerciseStep]);
		stepArea.setEditable(false);
		stepArea.setLineWrap(true);
		stepArea.setWrapStyleWord(true);
		stepArea.setFont(new Font("Arial", Font.PLAIN, 20));
		stepArea.setBackground(new Color(240, 240, 240));
		stepArea.setBorder(new EmptyBorder(15, 15, 15, 15));
		contentPanel.add(Box.createVerticalStrut(10));
		contentPanel.add(stepArea);

		// Add Repetitions and Sets info
		contentPanel.add(Box.createVerticalStrut(30));
    
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(2, 2, 20, 20));
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setMaximumSize(new Dimension(400, 120));

		JLabel repsNameLabel = new JLabel("Repetitions:");
		repsNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
		infoPanel.add(repsNameLabel);

		JLabel repsValue = new JLabel(currentExercise.reps);
		repsValue.setFont(new Font("Arial", Font. BOLD, 16));
		repsValue.setForeground(new Color(255, 159, 64));
		infoPanel.add(repsValue);

		JLabel setsNameLabel = new JLabel("Sets:");
		setsNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
		infoPanel.add(setsNameLabel);

		JLabel setsValue = new JLabel(currentExercise.sets);
		setsValue.setFont(new Font("Arial", Font.BOLD, 16));
		setsValue.setForeground(new Color(255, 159, 64));
		infoPanel.add(setsValue);

		contentPanel.add(infoPanel);
		contentPanel.add(Box.createVerticalGlue());

		contentPanel.revalidate();
		contentPanel.repaint();

		stepLabel.setText("How to Perform - Step " + (currentExerciseStep + 1) + " of " + totalSteps);
		currentStep = 3;
    
		// Update button visibility based on current step
		// FIXED: Show Next button even on the last step to proceed to Exercise Details
		boolean showPrev = currentExerciseStep > 0;
		boolean showNext = true;  // Always show Next button to go to Exercise Details
		updateButtonVisibility(showPrev, showNext, false);
	}

    // ===== STEP 4: EXERCISE DETAILS SUMMARY PAGE =====
private void showExerciseDetails() {
    contentPanel.removeAll();
    contentPanel.setLayout(new BorderLayout(15, 15));

    // Left side - Exercise Details
    JPanel detailsPanel = new JPanel();
    detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
    detailsPanel.setBackground(Color.WHITE);

    JLabel exerciseTitle = new JLabel(currentExercise.name + " Exercise Details");
    exerciseTitle.setFont(new Font("Arial", Font.BOLD, 18));
    detailsPanel.add(exerciseTitle);
    detailsPanel.add(Box. createVerticalStrut(20));

    // Add all steps with step numbers
    StringBuilder stepsText = new StringBuilder();
    for (int i = 0; i < currentExercise.steps.length; i++) {
        stepsText.append("Step ").append(i + 1).append(": ").append(currentExercise. steps[i]).append("\n\n");
    }

    JTextArea stepsArea = new JTextArea(stepsText.toString());
    stepsArea.setEditable(false);
    stepsArea.setLineWrap(true);
    stepsArea.setWrapStyleWord(true);
    stepsArea.setFont(new Font("Arial", Font.PLAIN, 16));
    stepsArea.setBackground(new Color(240, 240, 240));
    stepsArea.setBorder(new EmptyBorder(10, 10, 10, 10));
    JScrollPane scrollSteps = new JScrollPane(stepsArea);
    detailsPanel.add(scrollSteps);

    detailsPanel.add(Box. createVerticalStrut(20));

    // Add user info and reps/sets
    StringBuilder infoText = new StringBuilder();
    infoText.append("Name: ").append(userName).append("\n\n");
    infoText.append("Exercise: ").append(currentExercise.name).append("\n\n");
    infoText.append("Repetitions: ").append(currentExercise.reps).append("\n\n");
    infoText.append("Sets: ").append(currentExercise.sets).append("\n\n");
    infoText.append("Total Work: Perform ").append(currentExercise. reps).append(" for ").append(currentExercise.sets);

    JTextArea infoArea = new JTextArea(infoText.toString());
    infoArea.setEditable(false);
    infoArea.setFont(new Font("Arial", Font. PLAIN, 16));
    infoArea.setBackground(Color.WHITE);
    infoArea.setBorder(BorderFactory.createEmptyBorder());
    infoArea.setLineWrap(true);
    infoArea.setWrapStyleWord(true);
    detailsPanel.add(infoArea);

    detailsPanel.add(Box. createVerticalGlue());

    // Right side - Image with exercise name
    JPanel imagePanel = new JPanel();
    imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
    imagePanel.setBackground(Color.WHITE);

    JLabel imageLabel = new JLabel(currentExercise.name);
    imageLabel.setFont(new Font("Arial", Font.BOLD, 18));
    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    imagePanel.add(imageLabel);
    imagePanel.add(Box.createVerticalStrut(15));

    JLabel imageDisplay = new JLabel();
    imageDisplay.setHorizontalAlignment(JLabel.CENTER);
    imageDisplay.setVerticalAlignment(JLabel.CENTER);
    imagePanel.add(imageDisplay);

    // Load image in background thread
    new Thread(() -> {
        try {
            URL url = new URL(currentExercise.imageUrl);
            ImageIcon icon = new ImageIcon(url);
            if (icon. getIconWidth() > 0) {
                Image scaledImage = icon.getImage().getScaledInstance(320, 260, Image.SCALE_SMOOTH);
                SwingUtilities.invokeLater(() -> imageDisplay.setIcon(new ImageIcon(scaledImage)));
            }
        } catch (Exception e) {
            SwingUtilities.invokeLater(() -> imageDisplay.setText("Could not load image"));
        }
    }).start();

    JPanel wrapperPanel = new JPanel(new BorderLayout(15, 15));
    wrapperPanel.setBackground(Color.WHITE);
    wrapperPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
    wrapperPanel.add(detailsPanel, BorderLayout.WEST);
    wrapperPanel.add(imagePanel, BorderLayout.CENTER);

    contentPanel.add(wrapperPanel, BorderLayout. CENTER);

    contentPanel.revalidate();
    contentPanel.repaint();

    stepLabel.setText("Exercise Details");
    currentStep = 4;
    // Show Previous and Go Back buttons, but no Next button
    updateButtonVisibility(true, false, true);
}

    // ===== STEP 5: FINAL SUMMARY & IMAGE =====
    private void showSummary() {
        contentPanel.removeAll();
        contentPanel.setLayout(new BorderLayout(15, 15));

        // Left side - Summary (no box, just text)
        JPanel summaryPanel = new JPanel();
        summaryPanel.setLayout(new BoxLayout(summaryPanel, BoxLayout.Y_AXIS));
        summaryPanel.setBackground(Color.WHITE);

        JLabel summaryLabel = new JLabel("Exercise Summary");
        summaryLabel.setFont(new Font("Arial", Font. BOLD, 20));
        summaryPanel.add(summaryLabel);
        summaryPanel.add(Box.createVerticalStrut(15));

        StringBuilder summaryText = new StringBuilder();
        summaryText.append("User Name: ").append(userName).append("\n\n");
        summaryText. append("Exercise: ").append(currentExercise.name).append("\n\n");
        summaryText.append("Condition: ").append(currentExercise.disease).append("\n\n");
        summaryText.append("Repetitions: ").append(currentExercise.reps).append("\n\n");
        summaryText.append("Sets: ").append(currentExercise.sets).append("\n\n");
        summaryText.append("Total Work: Perform ").append(currentExercise.reps).append(" for ").append(currentExercise.sets);

        JTextArea summaryArea = new JTextArea(summaryText.toString());
        summaryArea.setEditable(false);
        summaryArea.setFont(new Font("Arial", Font. PLAIN, 14));
        summaryArea.setBackground(Color.WHITE);
        summaryArea.setBorder(BorderFactory.createEmptyBorder());
        summaryArea.setLineWrap(true);
        summaryArea.setWrapStyleWord(true);
        summaryPanel.add(summaryArea);

        summaryPanel.add(Box.createVerticalGlue());

        // Right side - Image with exercise name
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
        imagePanel.setBackground(Color.WHITE);

        JLabel imageLabel = new JLabel(" " + currentExercise.name);
        imageLabel.setFont(new Font("Arial", Font. BOLD, 18));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imagePanel.add(imageLabel);
        imagePanel.add(Box.createVerticalStrut(15));

        JLabel imageDisplay = new JLabel();
        imageDisplay.setHorizontalAlignment(JLabel.CENTER);
        imageDisplay.setVerticalAlignment(JLabel.CENTER);
        imagePanel.add(imageDisplay);

        // Load image in background thread
        new Thread(() -> {
            try {
                URL url = new URL(currentExercise.imageUrl);
                ImageIcon icon = new ImageIcon(url);
                if (icon.getIconWidth() > 0) {
                    Image scaledImage = icon.getImage().getScaledInstance(320, 260, Image. SCALE_SMOOTH);
                    SwingUtilities.invokeLater(() -> imageDisplay.setIcon(new ImageIcon(scaledImage)));
                }
            } catch (Exception e) {
                SwingUtilities.invokeLater(() -> imageDisplay.setText("Could not load image"));
            }
        }).start();

        JPanel wrapperPanel = new JPanel(new BorderLayout(15, 15));
        wrapperPanel.setBackground(Color.WHITE);
        wrapperPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        wrapperPanel.add(summaryPanel, BorderLayout.WEST);
        wrapperPanel.add(imagePanel, BorderLayout.CENTER);

        contentPanel.add(wrapperPanel, BorderLayout.CENTER);

        contentPanel.revalidate();
        contentPanel.repaint();

        stepLabel.setText("EXERCISE DONE");
        currentStep = 5;
        updateButtonVisibility(false, false, true);
    }

    // ===== NEXT STEP =====
    private void nextStep() {
        if (currentStep == 2) {
            // Moving from Facts to Exercise Steps
            currentExerciseStep = 0;
            showHowToPerform();
        } else if (currentStep == 3) {
            // Moving between exercise steps
            if (currentExerciseStep < currentExercise.steps.length - 1) {
                currentExerciseStep++;
                showHowToPerform();
            } else {
                // All exercise steps done, show exercise details
                showExerciseDetails();
            }
        } else if (currentStep == 4) {
            // From exercise details to summary
            showSummary();
        }
    }

    // ===== PREVIOUS STEP =====
    private void previousStep() {
        if (currentStep == 2) {
            // Go back to suggestions
            showSuggestions();
        } else if (currentStep == 3) {
            if (currentExerciseStep > 0) {
                // Go to previous exercise step
                currentExerciseStep--;
                showHowToPerform();
            } else {
                // Go back to facts
                showFacts();
            }
        } else if (currentStep == 4) {
            // Go back to last exercise step
            currentExerciseStep = currentExercise.steps.length - 1;
            showHowToPerform();
        } else if (currentStep == 5) {
            // Go back to exercise details
            showExerciseDetails();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DrugstoreExerciseStackGUI());
    }
}