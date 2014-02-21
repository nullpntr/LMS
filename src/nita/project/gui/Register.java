
package nita.project.gui;
//
//import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import nita.project.db.BookDB;
import nita.project.db.MemberDB;

/**
 *
 * @author Anil Bhaskar
 */
public class Register extends javax.swing.JDialog {

    /** Creates new form register */
        public Register(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadBranches();
        setLocationRelativeTo(null);
    }
     String msg = "Not required.";



     private void loadBranches(){
         for(String bc : new BookDB().getBranchs()){
             branch.addItem(bc);
         }
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        fac_d = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        join_yr = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        branch = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        pass_yr = new javax.swing.JTextField();
        roll = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pass1 = new javax.swing.JPasswordField();
        pass2 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fac = new javax.swing.JRadioButton();
        admin = new javax.swing.JRadioButton();
        clk = new javax.swing.JRadioButton();
        std = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sec_ans = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cat = new javax.swing.JComboBox();
        sec_ques = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel10.setText("Faculty Designation");

        fac_d.setFont(new java.awt.Font("Verdana", 0, 12));
        fac_d.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ass. Prof", "Prof", "Sen. Prof", "Lab Ass", "HOD" }));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel11.setText("Clerk Join Year");

        join_yr.setFont(new java.awt.Font("Verdana", 0, 12));
        join_yr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                join_yrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fac_d, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(join_yr, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fac_d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(join_yr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        email.setFont(new java.awt.Font("Verdana", 0, 12));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel9.setText("Registration");

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12));
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        branch.setFont(new java.awt.Font("Verdana", 0, 12));
        branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12));
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Email");

        pass_yr.setFont(new java.awt.Font("Verdana", 0, 12));

        roll.setFont(new java.awt.Font("Verdana", 0, 12));

        name.setFont(new java.awt.Font("Verdana", 0, 12));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel5.setText("Retype Password");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel4.setText("Password");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel3.setText("Roll No");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel2.setText("Name");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel7.setText("Passing Year");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel6.setText("Branch");

        pass1.setFont(new java.awt.Font("Verdana", 0, 12));

        pass2.setFont(new java.awt.Font("Verdana", 0, 12));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel1.setText("Register as");

        fac.setBackground(new java.awt.Color(102, 153, 255));
        buttonGroup1.add(fac);
        fac.setFont(new java.awt.Font("Verdana", 0, 12));
        fac.setText("Faculty");
        fac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facActionPerformed(evt);
            }
        });

        admin.setBackground(new java.awt.Color(102, 153, 255));
        buttonGroup1.add(admin);
        admin.setFont(new java.awt.Font("Verdana", 0, 12));
        admin.setText("Administrator");
        admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminActionPerformed(evt);
            }
        });

        clk.setBackground(new java.awt.Color(102, 153, 255));
        buttonGroup1.add(clk);
        clk.setFont(new java.awt.Font("Verdana", 0, 12));
        clk.setText("Clerk");
        clk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clkActionPerformed(evt);
            }
        });

        std.setBackground(new java.awt.Color(102, 153, 255));
        buttonGroup1.add(std);
        std.setFont(new java.awt.Font("Verdana", 0, 12));
        std.setText("Student");
        std.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(admin)
                .addGap(18, 18, 18)
                .addComponent(clk)
                .addGap(12, 12, 12)
                .addComponent(fac)
                .addGap(16, 16, 16)
                .addComponent(std)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(admin)
                    .addComponent(clk)
                    .addComponent(fac)
                    .addComponent(std))
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel12.setText("Security Question");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel13.setText("Security Answer");

        jLabel14.setText("Category");

        cat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gen", "OBC", "SC/ST" }));
        cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catActionPerformed(evt);
            }
        });

        sec_ques.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "what is your name?", "what is your birth day?", "who are you?", "what is you fav color?", "what is my mobile number?", "what is your birth Month?" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                        .addGap(45, 45, 45))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(branch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sec_ans)
                                    .addComponent(pass1)
                                    .addComponent(roll)
                                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                    .addComponent(sec_ques, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pass2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                .addComponent(pass_yr, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cat, 0, 288, Short.MAX_VALUE)
                                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(pass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sec_ques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sec_ans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(pass_yr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String s1=name.getText();
        String s2=pass1.getText();
        String s4=pass2.getText();
        String s3=email.getText();
        String ques=(String)sec_ques.getSelectedItem();
        String ans=sec_ans.getText();
        if(!admin.isSelected() && !fac.isSelected() && !clk.isSelected() && !std.isSelected())
        {
        JOptionPane.showMessageDialog(this, "please select you mode of registration!");
        }
        else{

if(admin.isSelected()){
if(s1.isEmpty()|| s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || ques.isEmpty() || ans.isEmpty())
{
    JOptionPane.showMessageDialog(this,"Essential fields need to be filled.");
}
else
{
if(s2.compareToIgnoreCase(s4)==0)
{
    boolean q=new MemberDB().save_admin(s1,s2,s3,ques,ans);
    if(q)
    {
    JOptionPane.showMessageDialog(this,"admin registered");
    }
    else
    {
    JOptionPane.showMessageDialog(this,"Something is wrong here");
    }
}
else
    JOptionPane.showMessageDialog(this,"password do not match");
}
} //      }



else if(std.isSelected())
{
  try
{
int i = Integer.parseInt(join_yr.getText());
   String j=roll.getText();
       String k=(String) branch.getSelectedItem();
      
       String category=(String)cat.getSelectedItem();

       
       
       ArrayList<String> ar = new MemberDB().getStuRoll();
       if(ar.contains(j))
       {
       JOptionPane.showMessageDialog(this,"student already registered!");
       roll.setText("");
       name.setText("");
       }
       else{

   if(s1.isEmpty()|| s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || ques.isEmpty() || ans.isEmpty() )
{
    JOptionPane.showMessageDialog(this,"essential fields need to be filled");
}
   else
       if(s2.equals(s4))

{
    boolean q=new MemberDB().save_stu(s1,j,s2,i,s3,k,ques,ans,category);
    if(q)
    {
    JOptionPane.showMessageDialog(this,"request has been sent to admin for verification");
    }
    else
    {
    JOptionPane.showMessageDialog(this,"Something is wrong here");
    }
}
else
    JOptionPane.showMessageDialog(this,"password do not match");
}}catch(Exception e)
{
JOptionPane.showMessageDialog(this, "Passing Year should be an Integer.");
}

}


else if(clk.isSelected())
{
  try
{
int y = Integer.parseInt(join_yr.getText());


  if(s1.isEmpty()|| s2.isEmpty() || s3.isEmpty() || s4.isEmpty()|| ques.isEmpty() || ans.isEmpty() )
{
    JOptionPane.showMessageDialog(this,"essential fields need to be filled");
}
  else{


       if(s2.compareToIgnoreCase(s4)==0)
{
    boolean q=new MemberDB().save_clr(s1,s3,s2,y,ques,ans);
    if(q)
    {
    JOptionPane.showMessageDialog(this,"request has been sent to admin for verification");
    }
    else
    {
        JOptionPane.showMessageDialog(this,"something is wrong here");

    }
}
  else
    JOptionPane.showMessageDialog(this,"password do not match");

}}catch(Exception e)
{
JOptionPane.showMessageDialog(this, "Join Year should be an Integer.");
}

}


        else if(fac.isSelected())
{
       String k=(String) branch.getSelectedItem();
       String l=(String) fac_d.getSelectedItem();
       if(s1.isEmpty()|| s2.isEmpty() || s3.isEmpty() || s4.isEmpty() ||l.isEmpty() || ques.isEmpty() || ans.isEmpty())
{
    JOptionPane.showMessageDialog(this,"essential fields need to be filled");
}
       else
       {
       if(s2.compareToIgnoreCase(s4)==0)
{
    boolean q=new MemberDB().save_fac(s1, s2,s3, k, l,ques,ans);
    if(q)
    {
    JOptionPane.showMessageDialog(this,"request has been sent to admin for verification");
    }
    else
    {
    JOptionPane.showMessageDialog(this,"something is wrong here");
    }
}
       else
    JOptionPane.showMessageDialog(this,"password do not match");

}}
        }
//int k=branch.getSelectedIndex();



       // setVisible(false);
}//GEN-LAST:event_jButton1ActionPerformed

    private void adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminActionPerformed
        // TODO add your handling code here:
cat.disable();

        roll.disable();
        branch.disable();
        pass_yr.disable();
        fac_d.disable();
        join_yr.disable();
        roll.setText(msg);
        pass_yr.setText(msg);


        join_yr.setText(msg);
    }//GEN-LAST:event_adminActionPerformed

    private void clkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clkActionPerformed
        // TODO add your handling code here:
cat.disable();

        roll.disable();
        branch.disable();
        pass_yr.disable();
        fac_d.disable();
         roll.setText(msg);
        pass_yr.setText(msg);
        join_yr.setEnabled(true);
        join_yr.setText("");

    }//GEN-LAST:event_clkActionPerformed

    private void facActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facActionPerformed
cat.disable();

        // TODO add your handling code here:
         roll.disable();
        branch.setEnabled(true);
        pass_yr.disable();
        roll.setText(msg);
        pass_yr.setText(msg);
        join_yr.setText(msg);
        fac_d.setEnabled(true);
        join_yr.setEnabled(true);
        join_yr.disable();
    }//GEN-LAST:event_facActionPerformed

    private void stdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdActionPerformed
        // TODO add your handling code here:
         fac_d.disable();
        join_yr.disable();
        join_yr.setText(msg);
        branch.setEnabled(true);
        pass_yr.setEnabled(true);
        roll.setEnabled(true);
        roll.setText("");
        pass_yr.setText("");
    }//GEN-LAST:event_stdActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
sec_ans.setText("");
        name.setText("");
email.setText("");
pass_yr.setText("");
roll.setText("");
pass1.setText("");
pass2.setText("");
//done.setText("");
join_yr.setText("");



// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchActionPerformed

    private void join_yrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_join_yrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_join_yrActionPerformed

    private void catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Register dialog = new Register(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton admin;
    private javax.swing.JComboBox branch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cat;
    private javax.swing.JRadioButton clk;
    private javax.swing.JTextField email;
    private javax.swing.JRadioButton fac;
    private javax.swing.JComboBox fac_d;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField join_yr;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JTextField pass_yr;
    private javax.swing.JTextField roll;
    private javax.swing.JTextField sec_ans;
    private javax.swing.JComboBox sec_ques;
    private javax.swing.JRadioButton std;
    // End of variables declaration//GEN-END:variables





}
