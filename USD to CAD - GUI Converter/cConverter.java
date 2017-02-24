//Line 108 has the conversion rate set to 1.5 as the program specs stated on 2/28/2017. 
//Please check Google for the most current exchange rate.

public class cConverter extends javax.swing.JFrame {
    //Variables declaration                     
    private javax.swing.JButton clearButton;
    private javax.swing.JButton convertButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    
    //Creates new form cConverter  
    public cConverter() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")                       
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        convertButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("USD to CAD Converter");

        jLabel2.setText("US Dollars (USD)");

        jLabel3.setText("Canadian Dollars (CAD)");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        convertButton.setText("Convert");
        convertButton.addActionListener(this::convertButtonActionPerformed);

        clearButton.setText("Clear");
        clearButton.addActionListener(this::clearButtonActionPerformed);

        exitButton.setText("Exit");
        exitButton.addActionListener(this::exitButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(convertButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(exitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jTextField2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(convertButton)
                    .addComponent(clearButton)
                    .addComponent(exitButton))
                .addContainerGap())
        );
        pack();
    }                       

    private void convertButtonActionPerformed(java.awt.event.ActionEvent evt) {  
        //Calc conversion between USD to CAD and set to the corresponding text field for displaying CAD ammount
        String usdSt = jTextField1.getText();
            Double usd = Double.parseDouble(usdSt);
            Double cad = usd * 1.5;
            String cadSt = Double.toString(cad);
            jTextField2.setText(cadSt);                                 
    }                                             

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        System.exit(WIDTH);
    }                                          

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        jTextField1.setText(null);
        jTextField2.setText(null);
    }                                           

    public static void main(String args[]) {
        //Create and display form
        java.awt.EventQueue.invokeLater(() -> {
            new cConverter().setVisible(true);
        });
    }                     
}
