//***************************************************************************
//	File:                       VendingMachine.Java
//
//	Student:                    Chris Stahle
//
//	Assignment:                 Program  # Extra Credit Week 2
//
//	Course Name:                Java Programming I
//
//	Course Number:              COSC 2050 - 01
//
//      Due:                        November 8, 2016
//
//      Description:                This program simulates a vending machine
//                                   
//***************************************************************************
package vendingmachine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author stahl
 */
public class VendingMachineFrame extends javax.swing.JFrame {

    VendingMachine vm = new VendingMachine();
    CashRegister cashRegister = new CashRegister();
    Validator v = new Validator();

    /**
     * Creates new form VendingMachineFrame
     */
    public VendingMachineFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        beverageButtonGroup = new javax.swing.ButtonGroup();
        dollarJButton = new javax.swing.JButton();
        creditsJLabel = new javax.swing.JLabel();
        amountJLabel = new javax.swing.JLabel();
        quarterJButton = new javax.swing.JButton();
        numDollarsJLabel = new javax.swing.JLabel();
        dollarsJLabel = new javax.swing.JLabel();
        numQuartersJLabel = new javax.swing.JLabel();
        quartersJLabel = new javax.swing.JLabel();
        pepsiJButton = new javax.swing.JButton();
        cokeJButton = new javax.swing.JButton();
        spriteJButton = new javax.swing.JButton();
        redbullJButton = new javax.swing.JButton();
        monsterRedJButton = new javax.swing.JButton();
        waterJButton = new javax.swing.JButton();
        propelJButton = new javax.swing.JButton();
        carrotJButton = new javax.swing.JButton();
        ojJButton = new javax.swing.JButton();
        pomegranateJButton = new javax.swing.JButton();
        refundJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vending Machine App");
        getContentPane().setLayout(null);

        dollarJButton.setFont(new java.awt.Font("Dialog", 1, 3)); // NOI18N
        dollarJButton.setText("1");
        //
        dollarJButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dollarJButton.setOpaque(false);
        dollarJButton.setContentAreaFilled(false);
        dollarJButton.setBorderPainted(false);
        dollarJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dollarJButtonMouseClicked(evt);
            }
        });
        dollarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dollarJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(dollarJButton);
        dollarJButton.setBounds(350, 520, 137, 50);

        creditsJLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        creditsJLabel.setText("Credits: $");
        getContentPane().add(creditsJLabel);
        creditsJLabel.setBounds(80, 500, 121, 100);

        amountJLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        amountJLabel.setText("0.00");
        getContentPane().add(amountJLabel);
        amountJLabel.setBounds(210, 535, 99, 33);

        quarterJButton.setFont(new java.awt.Font("Dialog", 1, 3)); // NOI18N
        quarterJButton.setOpaque(false);
        quarterJButton.setContentAreaFilled(false);
        quarterJButton.setBorderPainted(false);
        quarterJButton.setText(".25");
        quarterJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quarterJButtonMouseClicked(evt);
            }
        });
        quarterJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quarterJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(quarterJButton);
        quarterJButton.setBounds(460, 570, 75, 70);

        numDollarsJLabel.setText("0");
        getContentPane().add(numDollarsJLabel);
        numDollarsJLabel.setBounds(80, 600, 25, 16);

        dollarsJLabel.setFont(new java.awt.Font("Segoe WP Black", 1, 12)); // NOI18N
        dollarsJLabel.setText("Dollars");
        getContentPane().add(dollarsJLabel);
        dollarsJLabel.setBounds(110, 600, 50, 16);

        numQuartersJLabel.setText("0");
        getContentPane().add(numQuartersJLabel);
        numQuartersJLabel.setBounds(180, 600, 28, 16);

        quartersJLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        quartersJLabel.setText("Quarters");
        getContentPane().add(quartersJLabel);
        quartersJLabel.setBounds(210, 600, 60, 17);

        pepsiJButton.setText("$1");
        beverageButtonGroup.add(pepsiJButton);
        pepsiJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pepsiJButtonMouseClicked(evt);
            }
        });
        pepsiJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pepsiJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pepsiJButton);
        pepsiJButton.setBounds(112, 245, 67, 32);

        cokeJButton.setText("$1");
        beverageButtonGroup.add(cokeJButton);
        cokeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cokeJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cokeJButton);
        cokeJButton.setBounds(191, 245, 67, 32);

        spriteJButton.setText("$1");
        beverageButtonGroup.add(spriteJButton);
        spriteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spriteJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(spriteJButton);
        spriteJButton.setBounds(270, 245, 66, 32);

        redbullJButton.setText("$1");
        beverageButtonGroup.add(redbullJButton);
        redbullJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redbullJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(redbullJButton);
        redbullJButton.setBounds(348, 245, 66, 32);

        monsterRedJButton.setText("$1");
        beverageButtonGroup.add(monsterRedJButton);
        monsterRedJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monsterRedJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(monsterRedJButton);
        monsterRedJButton.setBounds(426, 245, 66, 32);

        waterJButton.setText("$1");
        beverageButtonGroup.add(waterJButton);
        waterJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waterJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(waterJButton);
        waterJButton.setBounds(426, 426, 67, 32);

        propelJButton.setText("$1");
        beverageButtonGroup.add(propelJButton);
        propelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propelJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(propelJButton);
        propelJButton.setBounds(348, 426, 66, 32);

        carrotJButton.setText("$1");
        beverageButtonGroup.add(carrotJButton);
        carrotJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carrotJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(carrotJButton);
        carrotJButton.setBounds(270, 426, 66, 32);

        ojJButton.setText("$1");
        beverageButtonGroup.add(ojJButton);
        ojJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ojJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ojJButton);
        ojJButton.setBounds(191, 426, 67, 32);

        pomegranateJButton.setText("$1");
        beverageButtonGroup.add(pomegranateJButton);
        pomegranateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pomegranateJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pomegranateJButton);
        pomegranateJButton.setBounds(112, 426, 67, 32);

        refundJButton.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        refundJButton.setText("Refund");
        refundJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refundJButtonMouseClicked(evt);
            }
        });
        refundJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refundJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(refundJButton);
        refundJButton.setBounds(380, 570, 70, 60);

        jTextPane1.setBackground(new java.awt.Color(51, 102, 255));
        jTextPane1.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jTextPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextPane1FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 740, 410, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dollarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dollarJButtonActionPerformed
        jTextPane1.setText("");
        if (creditsJLabel.getForeground() == Color.red) {
            creditsJLabel.setForeground(Color.BLACK);

        } //LABEL NEVER DISPLAYS RED IF THERE ARE CREDITS ...THIS REASSURES USERS
        if (cashRegister.getNumDollars() >= 0) {
            pepsiJButton.setBackground(Color.green); //BUTTON GROUP MASS EDIT??HOW TO 
            cokeJButton.setBackground(Color.green);
            spriteJButton.setBackground(Color.green); //STATIC VARIABLE ONLY CALL ONCE
            redbullJButton.setBackground(Color.green);
            monsterRedJButton.setBackground(Color.green);
            pomegranateJButton.setBackground(Color.green);
            ojJButton.setBackground(Color.green);
            carrotJButton.setBackground(Color.green);
            propelJButton.setBackground(Color.green);
            waterJButton.setBackground(Color.green);
        }
        System.out.println("dollarJButton got transformed from a String to this..."
                + Double.parseDouble(dollarJButton.getText()));

        //vm.setCredits(Double.parseDouble(dollarJButton.getText()));
        cashRegister.adjustNumDollars(1);

        //if we clicked this, we increment numDollarsJLabel by 1
        amountJLabel.setText("");

        //amountJLabel.setText(Double.toString(vm.getCredits()));
        amountJLabel.setText(Double.toString(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters())));

        numDollarsJLabel.setText("");
        //numDollarsJLabel.setText(Double.toString(vm.getCredits() / 1));
        //vm.setNumDollars(1);

        //numDollarsJLabel.setText(Integer.toString(vm.getNumDollars()));
        numDollarsJLabel.setText(Integer.toString(cashRegister.getNumDollars()));

        System.out.println("Heres the getNumDollars function" + Integer.toString(cashRegister.getNumDollars()));
        System.out.println("Dollar GETTING PRESSED");
    }//GEN-LAST:event_dollarJButtonActionPerformed

    private void dollarJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dollarJButtonMouseClicked

    }//GEN-LAST:event_dollarJButtonMouseClicked

    private void cokeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cokeJButtonActionPerformed

        int requestedBeverageQuantity = vm.beverageMap.get("Coke").getQuantity();

        if (requestedBeverageQuantity > 0) { //if that beverage exists...
            System.out.println("There are " + requestedBeverageQuantity + " of those left ");

            if (v.checkCredit(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters()))) {
                //This says "get pepsi object then set its quantity by subtracting 1 from its current quantity"...this is is how well keep track of how many of type X there are 
                vm.beverageMap.get("Coke").setQuantity(vm.beverageMap.get("Coke").getQuantity() - 1);
                /* //test the above here
                int decrementedQuantity = vm.beverageMap.get("pepsi").getQuantity();
                System.out.println("I just did some crazy code...did the number turn into a 9??" + decrementedQuantity); //holy shit 
                 */
                //
                jTextPane1.setText("Enjoy your Coke");
                System.out.println("Enjoy your Coke");
                //We are decrementing the credits..find out how to say "of any of these buttons are pressed, send a -1 to cashregister
                //if theres 4 quarters, take those first..also the cash register should have a limit on how many quarters and dollars it can hold now that i think about it .....
                if (cashRegister.getNumQuarters() != 0 && cashRegister.getNumQuarters() > 3) {
                    cashRegister.adjustNumQuarters(-1);//TODO: FIGURE OUT RECURSIVE FUNCTIONS....
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    numQuartersJLabel.setText(Integer.toString(cashRegister.getNumQuarters()));
                } else {
                    cashRegister.adjustNumDollars(-1);
                    numDollarsJLabel.setText(Integer.toString(cashRegister.getNumDollars()));
                }
                vm.setTotalNumberOfBeveragesLeft(vm.getNumberOfBeveragesLeft() - 1);
                amountJLabel.setText(Double.toString(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters())));
            } else {
                creditsJLabel.setForeground(Color.red);
                jTextPane1.setText("Error: Not enough credits");
            }
        } else //There's none left of that type
        {
            jTextPane1.setText("There's not any Coke left");
            System.out.println("There's not any Coke left.");
        }
        if (cashRegister.refund() == 0) {
            pepsiJButton.setBackground(Color.lightGray); 
            cokeJButton.setBackground(Color.lightGray);
            spriteJButton.setBackground(Color.lightGray); //STATIC VARIABLE ONLY CALL ONCE
            redbullJButton.setBackground(Color.lightGray);
            monsterRedJButton.setBackground(Color.lightGray);
            pomegranateJButton.setBackground(Color.lightGray);
            ojJButton.setBackground(Color.lightGray);
            carrotJButton.setBackground(Color.lightGray);
            propelJButton.setBackground(Color.lightGray);
            waterJButton.setBackground(Color.lightGray);
        }
    }//GEN-LAST:event_cokeJButtonActionPerformed

    private void pepsiJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pepsiJButtonActionPerformed
        int requestedBeverageQuantity = vm.beverageMap.get("Pepsi").getQuantity();

        if (requestedBeverageQuantity > 0) { //if that beverage exists...
            System.out.println("There are " + requestedBeverageQuantity + " of those left ");

            if (v.checkCredit(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters()))) {
                //This says "get pepsi object then set its quantity by subtracting 1 from its current quantity"...this is is how well keep track of how many of type X there are 
                vm.beverageMap.get("Pepsi").setQuantity(vm.beverageMap.get("Pepsi").getQuantity() - 1);
                /* //test the above here
                int decrementedQuantity = vm.beverageMap.get("pepsi").getQuantity();
                System.out.println("I just did some crazy code...did the number turn into a 9??" + decrementedQuantity); //holy shit 
                 */
                //
                jTextPane1.setText("Enjoy your Pepsi");
                System.out.println("Enjoy your Pepsi");
                //We are decrementing the credits..find out how to say "of any of these buttons are pressed, send a -1 to cashregister
                //if theres 4 quarters, take those first..also the cash register should have a limit on how many quarters and dollars it can hold now that i think about it .....
                if (cashRegister.getNumQuarters() != 0 && cashRegister.getNumQuarters() > 3) {
                    cashRegister.adjustNumQuarters(-1);//TODO: FIGURE OUT RECURSIVE FUNCTIONS....
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    numQuartersJLabel.setText(Integer.toString(cashRegister.getNumQuarters()));
                } else {
                    cashRegister.adjustNumDollars(-1);
                    numDollarsJLabel.setText(Integer.toString(cashRegister.getNumDollars()));
                }
                vm.setTotalNumberOfBeveragesLeft(vm.getNumberOfBeveragesLeft() - 1);
                amountJLabel.setText(Double.toString(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters())));
            } else {
                creditsJLabel.setForeground(Color.red);
                jTextPane1.setText("Error: Not enough credits");
            }
    }//GEN-LAST:event_pepsiJButtonActionPerformed
        else //There's none left of that type
        {
            jTextPane1.setText("There's not any Pepsi left");
            System.out.println("There's not any Pepsi left.");
        }
        if (cashRegister.refund() == 0) {
            pepsiJButton.setBackground(Color.lightGray); 
            cokeJButton.setBackground(Color.lightGray);
            spriteJButton.setBackground(Color.lightGray); //STATIC VARIABLE ONLY CALL ONCE
            redbullJButton.setBackground(Color.lightGray);
            monsterRedJButton.setBackground(Color.lightGray);
            pomegranateJButton.setBackground(Color.lightGray);
            ojJButton.setBackground(Color.lightGray);
            carrotJButton.setBackground(Color.lightGray);
            propelJButton.setBackground(Color.lightGray);
            waterJButton.setBackground(Color.lightGray);
        }
    }
    private void pomegranateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pomegranateJButtonActionPerformed
        int requestedBeverageQuantity = vm.beverageMap.get("Pomegranate Juice").getQuantity();

        if (requestedBeverageQuantity > 0) { //if that beverage exists...
            System.out.println("There are " + requestedBeverageQuantity + " of those left ");

            if (v.checkCredit(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters()))) {
                //This says "get pepsi object then set its quantity by subtracting 1 from its current quantity"...this is is how well keep track of how many of type X there are 
                vm.beverageMap.get("Pomegranate Juice").setQuantity(vm.beverageMap.get("Pomegranate Juice").getQuantity() - 1);
                /* //test the above here
                int decrementedQuantity = vm.beverageMap.get("pepsi").getQuantity();
                System.out.println("I just did some crazy code...did the number turn into a 9??" + decrementedQuantity); //holy shit 
                 */
                //
                jTextPane1.setText("Enjoy your Pomegranate Juice");
                System.out.println("Enjoy your Pomegranate Juice");
                //We are decrementing the credits..find out how to say "of any of these buttons are pressed, send a -1 to cashregister
                //if theres 4 quarters, take those first..also the cash register should have a limit on how many quarters and dollars it can hold now that i think about it .....
                if (cashRegister.getNumQuarters() != 0 && cashRegister.getNumQuarters() > 3) {
                    cashRegister.adjustNumQuarters(-1);//TODO: FIGURE OUT RECURSIVE FUNCTIONS....
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    numQuartersJLabel.setText(Integer.toString(cashRegister.getNumQuarters()));
                } else {
                    cashRegister.adjustNumDollars(-1);
                    numDollarsJLabel.setText(Integer.toString(cashRegister.getNumDollars()));
                }
                vm.setTotalNumberOfBeveragesLeft(vm.getNumberOfBeveragesLeft() - 1);
                amountJLabel.setText(Double.toString(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters())));
            } else {
                creditsJLabel.setForeground(Color.red);
                jTextPane1.setText("Error: Not enough credits");
            }
        } else //There's none left of that type
        {
            jTextPane1.setText("There's not any Pomegranate Juice left");
            System.out.println("There's not any Pomegranate Juice left.");
        }
        if (cashRegister.refund() == 0) {
            pepsiJButton.setBackground(Color.lightGray); 
            cokeJButton.setBackground(Color.lightGray);
            spriteJButton.setBackground(Color.lightGray); //STATIC VARIABLE ONLY CALL ONCE
            redbullJButton.setBackground(Color.lightGray);
            monsterRedJButton.setBackground(Color.lightGray);
            pomegranateJButton.setBackground(Color.lightGray);
            ojJButton.setBackground(Color.lightGray);
            carrotJButton.setBackground(Color.lightGray);
            propelJButton.setBackground(Color.lightGray);
            waterJButton.setBackground(Color.lightGray);
        }
    }//GEN-LAST:event_pomegranateJButtonActionPerformed

    private void propelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propelJButtonActionPerformed
        int requestedBeverageQuantity = vm.beverageMap.get("Propel").getQuantity();

        if (requestedBeverageQuantity > 0) { //if that beverage exists...
            System.out.println("There are " + requestedBeverageQuantity + " of those left ");

            if (v.checkCredit(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters()))) {
                //This says "get pepsi object then set its quantity by subtracting 1 from its current quantity"...this is is how well keep track of how many of type X there are 
                vm.beverageMap.get("Propel").setQuantity(vm.beverageMap.get("Propel").getQuantity() - 1);
                /* //test the above here
                int decrementedQuantity = vm.beverageMap.get("pepsi").getQuantity();
                System.out.println("I just did some crazy code...did the number turn into a 9??" + decrementedQuantity); //holy shit 
                 */
                //
                jTextPane1.setText("Enjoy your Propel");
                System.out.println("Enjoy your Propel");
                //We are decrementing the credits..find out how to say "of any of these buttons are pressed, send a -1 to cashregister
                //if theres 4 quarters, take those first..also the cash register should have a limit on how many quarters and dollars it can hold now that i think about it .....
                if (cashRegister.getNumQuarters() != 0 && cashRegister.getNumQuarters() > 3) {
                    cashRegister.adjustNumQuarters(-1);//TODO: FIGURE OUT RECURSIVE FUNCTIONS....
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    numQuartersJLabel.setText(Integer.toString(cashRegister.getNumQuarters()));
                } else {
                    cashRegister.adjustNumDollars(-1);
                    numDollarsJLabel.setText(Integer.toString(cashRegister.getNumDollars()));
                }
                vm.setTotalNumberOfBeveragesLeft(vm.getNumberOfBeveragesLeft() - 1);
                amountJLabel.setText(Double.toString(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters())));
            } else {
                creditsJLabel.setForeground(Color.red);
                jTextPane1.setText("Error: Not enough credits");
            }
        } else //There's none left of that type
        {
            jTextPane1.setText("There's not any Propel left");
            System.out.println("There's not any Propel left.");
        }
        if (cashRegister.refund() == 0) {
            pepsiJButton.setBackground(Color.lightGray); 
            cokeJButton.setBackground(Color.lightGray);
            spriteJButton.setBackground(Color.lightGray); //STATIC VARIABLE ONLY CALL ONCE
            redbullJButton.setBackground(Color.lightGray);
            monsterRedJButton.setBackground(Color.lightGray);
            pomegranateJButton.setBackground(Color.lightGray);
            ojJButton.setBackground(Color.lightGray);
            carrotJButton.setBackground(Color.lightGray);
            propelJButton.setBackground(Color.lightGray);
            waterJButton.setBackground(Color.lightGray);
        }
    }//GEN-LAST:event_propelJButtonActionPerformed

    private void quarterJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quarterJButtonMouseClicked

    }//GEN-LAST:event_quarterJButtonMouseClicked

    private void refundJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refundJButtonMouseClicked

    }//GEN-LAST:event_refundJButtonMouseClicked

    private void pepsiJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pepsiJButtonMouseClicked

    }//GEN-LAST:event_pepsiJButtonMouseClicked

    private void spriteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spriteJButtonActionPerformed
        int requestedBeverageQuantity = vm.beverageMap.get("Sprite").getQuantity();

        if (requestedBeverageQuantity > 0) { //if that beverage exists...
            System.out.println("There are " + requestedBeverageQuantity + " of those left ");

            if (v.checkCredit(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters()))) {
                //This says "get pepsi object then set its quantity by subtracting 1 from its current quantity"...this is is how well keep track of how many of type X there are 
                vm.beverageMap.get("Sprite").setQuantity(vm.beverageMap.get("Sprite").getQuantity() - 1);
                /* //test the above here
                int decrementedQuantity = vm.beverageMap.get("pepsi").getQuantity();
                System.out.println("I just did some crazy code...did the number turn into a 9??" + decrementedQuantity); //holy shit 
                 */
                //
                jTextPane1.setText("Enjoy your Sprite");
                System.out.println("Enjoy your Sprite");
                //We are decrementing the credits..find out how to say "of any of these buttons are pressed, send a -1 to cashregister
                //if theres 4 quarters, take those first..also the cash register should have a limit on how many quarters and dollars it can hold now that i think about it .....
                if (cashRegister.getNumQuarters() != 0 && cashRegister.getNumQuarters() > 3) {
                    cashRegister.adjustNumQuarters(-1);//TODO: FIGURE OUT RECURSIVE FUNCTIONS....
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    numQuartersJLabel.setText(Integer.toString(cashRegister.getNumQuarters()));
                } else {
                    cashRegister.adjustNumDollars(-1);
                    numDollarsJLabel.setText(Integer.toString(cashRegister.getNumDollars()));
                }
                vm.setTotalNumberOfBeveragesLeft(vm.getNumberOfBeveragesLeft() - 1);
                amountJLabel.setText(Double.toString(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters())));
            } else {
                creditsJLabel.setForeground(Color.red);
                jTextPane1.setText("Error: Not enough credits");
            }
        } else //There's none left of that type
        {
            jTextPane1.setText("There's not any Sprite left");
            System.out.println("There's not any Sprite left.");
        }
        if (cashRegister.refund() == 0) {
            pepsiJButton.setBackground(Color.lightGray); 
            cokeJButton.setBackground(Color.lightGray);
            spriteJButton.setBackground(Color.lightGray); //STATIC VARIABLE ONLY CALL ONCE
            redbullJButton.setBackground(Color.lightGray);
            monsterRedJButton.setBackground(Color.lightGray);
            pomegranateJButton.setBackground(Color.lightGray);
            ojJButton.setBackground(Color.lightGray);
            carrotJButton.setBackground(Color.lightGray);
            propelJButton.setBackground(Color.lightGray);
            waterJButton.setBackground(Color.lightGray);
        }
    }//GEN-LAST:event_spriteJButtonActionPerformed

    private void redbullJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redbullJButtonActionPerformed
        int requestedBeverageQuantity = vm.beverageMap.get("Redbull").getQuantity();

        if (requestedBeverageQuantity > 0) { //if that beverage exists...
            System.out.println("There are " + requestedBeverageQuantity + " of those left ");

            if (v.checkCredit(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters()))) {
                //This says "get pepsi object then set its quantity by subtracting 1 from its current quantity"...this is is how well keep track of how many of type X there are 
                vm.beverageMap.get("Redbull").setQuantity(vm.beverageMap.get("Redbull").getQuantity() - 1);
                /* //test the above here
                int decrementedQuantity = vm.beverageMap.get("pepsi").getQuantity();
                System.out.println("I just did some crazy code...did the number turn into a 9??" + decrementedQuantity); //holy shit 
                 */
                //
                jTextPane1.setText("Enjoy your Redbull");
                System.out.println("Enjoy your Redbull");
                //We are decrementing the credits..find out how to say "of any of these buttons are pressed, send a -1 to cashregister
                //if theres 4 quarters, take those first..also the cash register should have a limit on how many quarters and dollars it can hold now that i think about it .....
                if (cashRegister.getNumQuarters() != 0 && cashRegister.getNumQuarters() > 3) {
                    cashRegister.adjustNumQuarters(-1);//TODO: FIGURE OUT RECURSIVE FUNCTIONS....
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    numQuartersJLabel.setText(Integer.toString(cashRegister.getNumQuarters()));
                } else {
                    cashRegister.adjustNumDollars(-1);
                    numDollarsJLabel.setText(Integer.toString(cashRegister.getNumDollars()));
                }
                vm.setTotalNumberOfBeveragesLeft(vm.getNumberOfBeveragesLeft() - 1);
                amountJLabel.setText(Double.toString(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters())));
            } else {
                creditsJLabel.setForeground(Color.red);
                jTextPane1.setText("Error: Not enough credits");
            }
        } else //There's none left of that type
        {
            jTextPane1.setText("There's not any Redbull left");
            System.out.println("There's not any Redbull left.");
        }
        if (cashRegister.refund() == 0) {
            pepsiJButton.setBackground(Color.lightGray); 
            cokeJButton.setBackground(Color.lightGray);
            spriteJButton.setBackground(Color.lightGray); //STATIC VARIABLE ONLY CALL ONCE
            redbullJButton.setBackground(Color.lightGray);
            monsterRedJButton.setBackground(Color.lightGray);
            pomegranateJButton.setBackground(Color.lightGray);
            ojJButton.setBackground(Color.lightGray);
            carrotJButton.setBackground(Color.lightGray);
            propelJButton.setBackground(Color.lightGray);
            waterJButton.setBackground(Color.lightGray);
        }
    }//GEN-LAST:event_redbullJButtonActionPerformed

    private void monsterRedJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monsterRedJButtonActionPerformed
        int requestedBeverageQuantity = vm.beverageMap.get("MonsterRed").getQuantity();

        if (requestedBeverageQuantity > 0) { //if that beverage exists...
            System.out.println("There are " + requestedBeverageQuantity + " of those left ");

            if (v.checkCredit(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters()))) {
                //This says "get pepsi object then set its quantity by subtracting 1 from its current quantity"...this is is how well keep track of how many of type X there are 
                vm.beverageMap.get("MonsterRed").setQuantity(vm.beverageMap.get("MonsterRed").getQuantity() - 1);
                /* //test the above here
                int decrementedQuantity = vm.beverageMap.get("pepsi").getQuantity();
                System.out.println("I just did some crazy code...did the number turn into a 9??" + decrementedQuantity); //holy shit 
                 */
                //
                jTextPane1.setText("Enjoy your MonsterRed");
                System.out.println("Enjoy your MonsterRed");
                //We are decrementing the credits..find out how to say "of any of these buttons are pressed, send a -1 to cashregister
                //if theres 4 quarters, take those first..also the cash register should have a limit on how many quarters and dollars it can hold now that i think about it .....
                if (cashRegister.getNumQuarters() != 0 && cashRegister.getNumQuarters() > 3) {
                    cashRegister.adjustNumQuarters(-1);//TODO: FIGURE OUT RECURSIVE FUNCTIONS....
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    numQuartersJLabel.setText(Integer.toString(cashRegister.getNumQuarters()));
                } else {
                    cashRegister.adjustNumDollars(-1);
                    numDollarsJLabel.setText(Integer.toString(cashRegister.getNumDollars()));
                }
                vm.setTotalNumberOfBeveragesLeft(vm.getNumberOfBeveragesLeft() - 1);
                amountJLabel.setText(Double.toString(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters())));
            } else {
                creditsJLabel.setForeground(Color.red);
                jTextPane1.setText("Error: Not enough credits");
            }
        } else //There's none left of that type
        {
            jTextPane1.setText("There's not any MonsterRed left");
            System.out.println("There's not any MonsterRed left.");
        }
        if (cashRegister.refund() == 0) {
            pepsiJButton.setBackground(Color.lightGray); 
            cokeJButton.setBackground(Color.lightGray);
            spriteJButton.setBackground(Color.lightGray); //STATIC VARIABLE ONLY CALL ONCE
            redbullJButton.setBackground(Color.lightGray);
            monsterRedJButton.setBackground(Color.lightGray);
            pomegranateJButton.setBackground(Color.lightGray);
            ojJButton.setBackground(Color.lightGray);
            carrotJButton.setBackground(Color.lightGray);
            propelJButton.setBackground(Color.lightGray);
            waterJButton.setBackground(Color.lightGray);
        }
    }//GEN-LAST:event_monsterRedJButtonActionPerformed

    private void ojJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ojJButtonActionPerformed
        int requestedBeverageQuantity = vm.beverageMap.get("Orange Juice").getQuantity();

        if (requestedBeverageQuantity > 0) { //if that beverage exists...
            System.out.println("There are " + requestedBeverageQuantity + " of those left ");

            if (v.checkCredit(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters()))) {
                //This says "get pepsi object then set its quantity by subtracting 1 from its current quantity"...this is is how well keep track of how many of type X there are 
                vm.beverageMap.get("Orange Juice").setQuantity(vm.beverageMap.get("Orange Juice").getQuantity() - 1);
                /* //test the above here
                int decrementedQuantity = vm.beverageMap.get("pepsi").getQuantity();
                System.out.println("I just did some crazy code...did the number turn into a 9??" + decrementedQuantity); //holy shit 
                 */
                //
                jTextPane1.setText("Enjoy your Orange Juice");
                System.out.println("Enjoy your Orange Juice");
                //We are decrementing the credits..find out how to say "of any of these buttons are pressed, send a -1 to cashregister
                //if theres 4 quarters, take those first..also the cash register should have a limit on how many quarters and dollars it can hold now that i think about it .....
                if (cashRegister.getNumQuarters() != 0 && cashRegister.getNumQuarters() > 3) {
                    cashRegister.adjustNumQuarters(-1);//TODO: FIGURE OUT RECURSIVE FUNCTIONS....
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    numQuartersJLabel.setText(Integer.toString(cashRegister.getNumQuarters()));
                } else {
                    cashRegister.adjustNumDollars(-1);
                    numDollarsJLabel.setText(Integer.toString(cashRegister.getNumDollars()));
                }
                vm.setTotalNumberOfBeveragesLeft(vm.getNumberOfBeveragesLeft() - 1);
                amountJLabel.setText(Double.toString(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters())));
            } else {
                creditsJLabel.setForeground(Color.red);
                jTextPane1.setText("Error: Not enough credits");
            }
        } else //There's none left of that type
        {
            jTextPane1.setText("There's not any Orange Juice left");
            System.out.println("There's not any Orange Juice left.");
        }
        if (cashRegister.refund() == 0) {
            pepsiJButton.setBackground(Color.lightGray); 
            cokeJButton.setBackground(Color.lightGray);
            spriteJButton.setBackground(Color.lightGray); //STATIC VARIABLE ONLY CALL ONCE
            redbullJButton.setBackground(Color.lightGray);
            monsterRedJButton.setBackground(Color.lightGray);
            pomegranateJButton.setBackground(Color.lightGray);
            ojJButton.setBackground(Color.lightGray);
            carrotJButton.setBackground(Color.lightGray);
            propelJButton.setBackground(Color.lightGray);
            waterJButton.setBackground(Color.lightGray);
        }
     }//GEN-LAST:event_ojJButtonActionPerformed

    private void carrotJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carrotJButtonActionPerformed
        int requestedBeverageQuantity = vm.beverageMap.get("Carrot Juice").getQuantity();

        if (requestedBeverageQuantity > 0) { //if that beverage exists...
            System.out.println("There are " + requestedBeverageQuantity + " of those left ");

            if (v.checkCredit(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters()))) {
                //This says "get pepsi object then set its quantity by subtracting 1 from its current quantity"...this is is how well keep track of how many of type X there are 
                vm.beverageMap.get("Carrot Juice").setQuantity(vm.beverageMap.get("Carrot Juice").getQuantity() - 1);
                /* //test the above here
                int decrementedQuantity = vm.beverageMap.get("pepsi").getQuantity();
                System.out.println("I just did some crazy code...did the number turn into a 9??" + decrementedQuantity); //holy shit 
                 */
                //
                jTextPane1.setText("Enjoy your Carrot Juice");
                System.out.println("Enjoy your Carrot Juice");
                //We are decrementing the credits..find out how to say "of any of these buttons are pressed, send a -1 to cashregister
                //if theres 4 quarters, take those first..also the cash register should have a limit on how many quarters and dollars it can hold now that i think about it .....
                if (cashRegister.getNumQuarters() != 0 && cashRegister.getNumQuarters() > 3) {
                    cashRegister.adjustNumQuarters(-1);//TODO: FIGURE OUT RECURSIVE FUNCTIONS....
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    numQuartersJLabel.setText(Integer.toString(cashRegister.getNumQuarters()));
                } else {
                    cashRegister.adjustNumDollars(-1);
                    numDollarsJLabel.setText(Integer.toString(cashRegister.getNumDollars()));
                }
                vm.setTotalNumberOfBeveragesLeft(vm.getNumberOfBeveragesLeft() - 1);
                amountJLabel.setText(Double.toString(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters())));
            } else {
                creditsJLabel.setForeground(Color.red);
                jTextPane1.setText("Error: Not enough credits");
            }
        } else //There's none left of that type
        {
            jTextPane1.setText("There's not any Carrot Juice left");
            System.out.println("There's not any Carrot Juice left.");
        }
        if (cashRegister.refund() == 0) {
            pepsiJButton.setBackground(Color.lightGray); 
            cokeJButton.setBackground(Color.lightGray);
            spriteJButton.setBackground(Color.lightGray); //STATIC VARIABLE ONLY CALL ONCE
            redbullJButton.setBackground(Color.lightGray);
            monsterRedJButton.setBackground(Color.lightGray);
            pomegranateJButton.setBackground(Color.lightGray);
            ojJButton.setBackground(Color.lightGray);
            carrotJButton.setBackground(Color.lightGray);
            propelJButton.setBackground(Color.lightGray);
            waterJButton.setBackground(Color.lightGray);
        }
    }//GEN-LAST:event_carrotJButtonActionPerformed

    private void waterJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waterJButtonActionPerformed
        int requestedBeverageQuantity = vm.beverageMap.get("Water").getQuantity();

        if (requestedBeverageQuantity > 0) { //if that beverage exists...
            System.out.println("There are " + requestedBeverageQuantity + " of those left ");

            if (v.checkCredit(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters()))) {
                //This says "get pepsi object then set its quantity by subtracting 1 from its current quantity"...this is is how well keep track of how many of type X there are 
                vm.beverageMap.get("Water").setQuantity(vm.beverageMap.get("Water").getQuantity() - 1);
                /* //test the above here
                int decrementedQuantity = vm.beverageMap.get("pepsi").getQuantity();
                System.out.println("I just did some crazy code...did the number turn into a 9??" + decrementedQuantity); //holy shit 
                 */
                //
                jTextPane1.setText("Enjoy your Water");
                System.out.println("Enjoy your Water");
                //We are decrementing the credits..TODO: find out how to say "of any of these buttons are pressed, send a -1 to cashregister
                //if theres 4 quarters, take those first..also the cash register should have a limit on how many quarters and dollars it can hold now that i think about it .....
                if (cashRegister.getNumQuarters() != 0 && cashRegister.getNumQuarters() > 3) {
                    cashRegister.adjustNumQuarters(-1);//TODO: FIGURE OUT RECURSIVE FUNCTIONS....
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    cashRegister.adjustNumQuarters(-1);
                    numQuartersJLabel.setText(Integer.toString(cashRegister.getNumQuarters()));
                } else {
                    cashRegister.adjustNumDollars(-1);
                    numDollarsJLabel.setText(Integer.toString(cashRegister.getNumDollars()));
                }
                vm.setTotalNumberOfBeveragesLeft(vm.getNumberOfBeveragesLeft() - 1);
                amountJLabel.setText(Double.toString(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters())));
            } else {
                creditsJLabel.setForeground(Color.red);
                jTextPane1.setText("Error: Not enough credits");
            }
        } else //There's none left of that type
        {
            jTextPane1.setText("There's not any Water left");
            System.out.println("There's not any Water left.");
        }
        if (cashRegister.refund() == 0) {
            pepsiJButton.setBackground(Color.lightGray); 
            cokeJButton.setBackground(Color.lightGray);
            spriteJButton.setBackground(Color.lightGray); //STATIC VARIABLE ONLY CALL ONCE
            redbullJButton.setBackground(Color.lightGray);
            monsterRedJButton.setBackground(Color.lightGray);
            pomegranateJButton.setBackground(Color.lightGray);
            ojJButton.setBackground(Color.lightGray);
            carrotJButton.setBackground(Color.lightGray);
            propelJButton.setBackground(Color.lightGray);
            waterJButton.setBackground(Color.lightGray);
        }
    }//GEN-LAST:event_waterJButtonActionPerformed

    private void quarterJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quarterJButtonActionPerformed
        
        if(cashRegister.getNumQuarters() > 2)
            jTextPane1.setText("");
        if (cashRegister.getNumQuarters() > 2) //0 based... 4 quarters is actually 3 =)
        {
            pepsiJButton.setBackground(Color.green);
            cokeJButton.setBackground(Color.green);
            spriteJButton.setBackground(Color.green);
            redbullJButton.setBackground(Color.green);
            monsterRedJButton.setBackground(Color.green);
            pomegranateJButton.setBackground(Color.green);
            ojJButton.setBackground(Color.green);
            carrotJButton.setBackground(Color.green);
            propelJButton.setBackground(Color.green);
            waterJButton.setBackground(Color.green);
        }
        if (creditsJLabel.getForeground() == Color.red) {
            creditsJLabel.setForeground(Color.BLACK);
        } //LABEL NEVER DISPLAYS RED IF THERE ARE CERDITS ...THIS ASSURES USERS

        System.out.println("quarterJButton got transformed from a String to this..."
                + Double.parseDouble(quarterJButton.getText()));

        //vm.setCredits(Double.parseDouble(quarterJButton.getText()));
        cashRegister.adjustNumQuarters(1);

        amountJLabel.setText("");

        //amountJLabel.setText(Double.toString(vm.getCredits()));
        amountJLabel.setText(Double.toString(cashRegister.adjustTotal(cashRegister.getNumDollars(), cashRegister.getNumQuarters())));

        numQuartersJLabel.setText("");
        //numQuartersJLabel.setText(Double.toString(vm.getCredits() % 1));

        //vm.setNumQuarters(1);
        //numQuartersJLabel.setText(Integer.toString(vm.getNumQuarters()));
        numQuartersJLabel.setText(Integer.toString(cashRegister.getNumQuarters()));

        System.out.println("Heres the numQuarters function" + Integer.toString(cashRegister.getNumQuarters()));
        System.out.println("Quarter GETTING PRESSED");
    }//GEN-LAST:event_quarterJButtonActionPerformed

    private void refundJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refundJButtonActionPerformed
        pepsiJButton.setBackground(Color.lightGray); //BUTTON GROUP MASS EDIT??HOW TO 
        cokeJButton.setBackground(Color.lightGray);
        spriteJButton.setBackground(Color.lightGray);
        redbullJButton.setBackground(Color.lightGray);
        monsterRedJButton.setBackground(Color.lightGray);
        pomegranateJButton.setBackground(Color.lightGray);
        ojJButton.setBackground(Color.lightGray);
        carrotJButton.setBackground(Color.lightGray);
        propelJButton.setBackground(Color.lightGray);
        waterJButton.setBackground(Color.lightGray);
        jTextPane1.setText("Please take your refund of \n" + cashRegister.refund());
        cashRegister.emptyTheCashRegister();

        amountJLabel.setText("0.0");
        numQuartersJLabel.setText("0");
        numDollarsJLabel.setText("0");

        //cashing out sound
        //beverage buttons stop lighting up

    }//GEN-LAST:event_refundJButtonActionPerformed

    private void jTextPane1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextPane1FocusLost

    }//GEN-LAST:event_jTextPane1FocusLost

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VendingMachineFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendingMachineFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendingMachineFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendingMachineFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {

            JPanelWithBackground panel = new JPanelWithBackground(new ImageIcon("src/vendingmachine/VendingMachineGraphic.png").getImage());

            VendingMachineFrame frame = new VendingMachineFrame();

            frame.getContentPane().add(panel);
            frame.setLayout(new BorderLayout());
            frame.setSize(620, 1019);
            //frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null); //center the frame  

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountJLabel;
    private javax.swing.ButtonGroup beverageButtonGroup;
    private javax.swing.JButton carrotJButton;
    private javax.swing.JButton cokeJButton;
    private javax.swing.JLabel creditsJLabel;
    private javax.swing.JButton dollarJButton;
    private javax.swing.JLabel dollarsJLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton monsterRedJButton;
    private javax.swing.JLabel numDollarsJLabel;
    private javax.swing.JLabel numQuartersJLabel;
    private javax.swing.JButton ojJButton;
    private javax.swing.JButton pepsiJButton;
    private javax.swing.JButton pomegranateJButton;
    private javax.swing.JButton propelJButton;
    private javax.swing.JButton quarterJButton;
    private javax.swing.JLabel quartersJLabel;
    private javax.swing.JButton redbullJButton;
    private javax.swing.JButton refundJButton;
    private javax.swing.JButton spriteJButton;
    private javax.swing.JButton waterJButton;
    // End of variables declaration//GEN-END:variables
}
