import javax.swing.*;
import java.awt.event.*;
class JVacationRental extends JFrame implements ActionListener {
    // constants
    private final int PARKSIDE = 600, POOLSIDE = 750, LAKESIDE = 825, BEDROOM2 = 75, BEDROOM3= 150, MEALS = 200;

    // attributes
    private JLabel locationLbl = new JLabel("Location: "), bedroomsLbl = new JLabel("Bedrooms: "),
            mealsLbl = new JLabel("Meals: "), totalLbl = new JLabel("Total Rent: $ 0.0");

    private JRadioButton parksideBtn = new JRadioButton("Parkside"), poolsideBtn = new JRadioButton("Poolside"),
            lakesideBtn = new JRadioButton("Lakeside"), oneBtn = new JRadioButton("1"),
            twoBtn = new JRadioButton("2"), threeBtn = new JRadioButton("3"),
            yesBtn = new JRadioButton("Yes"), noBtn = new JRadioButton("No");

    private ButtonGroup locationGroup = new ButtonGroup(), bedroomGroup = new ButtonGroup(), mealGroup = new ButtonGroup();
    private JButton calcBtn = new JButton("Calculate");
    private JPanel locationPanel = new JPanel(), bedroomPanel = new JPanel(), mealPanel = new JPanel(),
            buttonPanel = new JPanel(), labelPanel = new JPanel(), mainPanel = new JPanel();

    private int locationRent = 0, bedroomsRent = 0, mealsCost = 0;

    // constructor
    public JVacationRental() {
        super("Lambert's Vacation Rental Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        locationPanel.add(locationLbl);
        JRadioButton[] locationBtns = {parksideBtn, poolsideBtn, lakesideBtn};
        for (JRadioButton locationBtn : locationBtns) {
            locationGroup.add(locationBtn);
            locationPanel.add(locationBtn);
            locationBtn.addItemListener(new LocationsListener());
        }

        bedroomPanel.add(bedroomsLbl);
        JRadioButton[] bedroomBtns = {oneBtn, twoBtn, threeBtn};
        for (JRadioButton bedroomBtn : bedroomBtns) {
            bedroomGroup.add(bedroomBtn);
            bedroomPanel.add(bedroomBtn);
            bedroomBtn.addItemListener(new BedroomsListener());
        }

        mealPanel.add(mealsLbl);
        JRadioButton[] mealBtns = {yesBtn, noBtn};
        for (JRadioButton mealBtn : mealBtns) {
            mealGroup.add(mealBtn);
            mealPanel.add(mealBtn);
            mealBtn.addItemListener(new MealsListener());
        }

        buttonPanel.add(calcBtn);
        calcBtn.addActionListener(this);
        labelPanel.add(totalLbl);

        JPanel[] panels = {locationPanel, bedroomPanel, mealPanel, buttonPanel, labelPanel};
        for (JPanel panel : panels) mainPanel.add(panel);
        add(mainPanel);
    }

    public static void main(String[] args) {
        JVacationRental frame = new JVacationRental();
        frame.setSize(370, 250);
        frame.setVisible(true);
    }

    // calculate button
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == calcBtn) {
            double totalRent1 = locationRent + bedroomsRent + mealsCost;
            totalLbl.setText("Total Rent: $ " + totalRent1);
        }
    }

    // location radiobuttons
    private class LocationsListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getItem();
            if(source == parksideBtn) locationRent = PARKSIDE;
            else if (source == poolsideBtn) locationRent = POOLSIDE;
            else if (source == lakesideBtn) locationRent = LAKESIDE;
            else locationRent = 0;
        }
    }

    // bedroom radiobuttons
    private class BedroomsListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getItem();
            if (source == twoBtn) bedroomsRent = BEDROOM2;
            else if (source == threeBtn) bedroomsRent = BEDROOM3;
            else bedroomsRent = 0;
        }
    }

    // meal radiobuttons
    private class MealsListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getItem();
            mealsCost = (source == yesBtn)? MEALS : 0;
        }
    }
}
