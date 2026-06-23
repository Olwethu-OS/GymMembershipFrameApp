/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import za.ac.tut.bl.MembersDB;
import za.ac.tut.entity.Member;



/**
 *
 * @author olwet
 */
public class MembershipFrame extends JFrame {
    
    String dburl="jdbc:derby://localhost:1527/MembershipDB;create=true";
    String username="app";
    String password="123";
    //Panels
    private JPanel headingPnl;
    private JPanel namePnl;
    private JPanel surnamePnl;
    private JPanel idPnl;
    private JPanel genderPnl;
    private JPanel detailsPnl;
    private JPanel radioPnl;
    private JPanel checkboxPnl;
    private JPanel contractsPnl;
    private JPanel textareaPnl;
    private JPanel btnPnl;
    private JPanel mainPnl;
    private JPanel TopPnl;

    //Labels
    
    private JLabel headingLb;
    private JLabel nameLb;
    private JLabel surnameLb;
    private JLabel idLb;
    private JLabel genderLb;
    private JLabel typeContractsLb;
    
    //textfield
    private JTextField nameTField;
    private JTextField surnameTField;
    private JTextField idTField;
    //combobox
    private JComboBox genderBox;
    //buttongroup
    private ButtonGroup btnGrp;
    //radios
    private JRadioButton mtm;
    private JRadioButton sm;
    private JRadioButton annual;
    
    //checkbox
    private JCheckBox trainer;
    
    //textarea
    private JTextArea memberTArea;
    //
    private JScrollPane scrollable;
    //button
    private JButton registerbtn;
    private JButton searchbtn;
    private JButton updatebtn;
    private JButton removebtn;
    private JButton displaybtn;
    private JButton clearbtn;
    private JButton exitbtn;
  
    //private ArrayList<Member> members;
            

    public MembershipFrame() {
        setLayout(new BorderLayout());
        setTitle("Membership");
        setSize(800,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
     
        
        //create panels
        
     headingPnl=new JPanel(new FlowLayout(FlowLayout.CENTER));
     headingPnl.setBorder(new BevelBorder(BevelBorder.RAISED));
     namePnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
     surnamePnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
     idPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
     genderPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
    mainPnl=new JPanel(new BorderLayout());
     detailsPnl=new JPanel(new GridLayout(4,1));
     detailsPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1),"Client details"));
     radioPnl=new JPanel(new FlowLayout());
     checkboxPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
     contractsPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
     contractsPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1),"Contract options"));
     textareaPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
      textareaPnl.setBorder(new BevelBorder(BevelBorder.RAISED));
     btnPnl=new JPanel(new FlowLayout());
      TopPnl=new JPanel(new GridLayout(2,1));
     
     //create labels
     headingLb=new JLabel("Membership Form");
    headingLb.setFont(new Font(Font.SANS_SERIF,Font.ITALIC + Font.BOLD,20));
    headingLb.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
     nameLb= new JLabel("Name: ");
     surnameLb= new JLabel("Surname: ");
     idLb= new JLabel("Id no: ");
     genderLb= new JLabel("Gender: ");
     typeContractsLb= new JLabel("Type of contract: ");
     
     //create textfields
     nameTField=new JTextField(20);
     surnameTField=new JTextField(20);
     idTField=new JTextField(20);
    
      //create text area
    memberTArea= new JTextArea(20,30);
    memberTArea.setEditable(false);
    memberTArea.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1),"Member(s) details"));
    
    scrollable=new JScrollPane(memberTArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
     
     //create radios and checkbox
     mtm=new JRadioButton("Month-to-month");
     sm=new JRadioButton("Six months");
     annual=new JRadioButton("Annual");
     trainer=new JCheckBox("Select the checkbox if you need a persornal trainer");
   
     //create combobox
     genderBox=new JComboBox();
     genderBox.addItem("Male");
     genderBox.addItem("Female");
     
     //create button grup
     btnGrp=new ButtonGroup();
     btnGrp.add(mtm);
     btnGrp.add(sm);
     btnGrp.add(annual);
     
     //create buttons
     registerbtn=new JButton("Register");
     registerbtn.addActionListener(new RegisterBtnListener());
     searchbtn=new JButton("Search");
     searchbtn.addActionListener(new SearchBtnListener());
     updatebtn=new JButton("Update");
     updatebtn.addActionListener(new UpdateBtnListener());
     removebtn=new JButton("Remove");
     removebtn.addActionListener(new RemoveBtnListener());
     displaybtn=new JButton("Display All");
     displaybtn.addActionListener(new GetAllBtnListener());
     clearbtn=new JButton("Clear");
     clearbtn.addActionListener(new ClearBtnListener());
     exitbtn=new JButton("Exit");
    exitbtn.addActionListener(new ExitBtnListener());
    
     //add to panels
     headingPnl.add(headingLb);
     namePnl.add(nameLb);
     namePnl.add(nameTField);
     surnamePnl.add(surnameLb);
     surnamePnl.add(surnameTField);
     idPnl.add(idLb);
     idPnl.add(idTField);
     genderPnl.add(genderLb);
     genderPnl.add(genderBox);
     detailsPnl.add(namePnl);
     detailsPnl.add(surnamePnl);
     detailsPnl.add(idPnl);
     detailsPnl.add(genderPnl);
     
     radioPnl.add(typeContractsLb);
   radioPnl.add(mtm);
     radioPnl.add(sm);
     radioPnl.add(annual);
     checkboxPnl.add(trainer);
     contractsPnl.add(radioPnl);
     contractsPnl.add(checkboxPnl);
     TopPnl.add(detailsPnl);
     TopPnl.add(contractsPnl);
     
     textareaPnl.add(scrollable);
     btnPnl.add(registerbtn);
     btnPnl.add(searchbtn);
     btnPnl.add(updatebtn);
     btnPnl.add(removebtn);
     btnPnl.add(displaybtn);
     btnPnl.add(clearbtn);
     btnPnl.add(exitbtn);
   
     mainPnl.add(TopPnl,BorderLayout.NORTH);
     mainPnl.add(textareaPnl,BorderLayout.CENTER);
     mainPnl.add(btnPnl,BorderLayout.SOUTH);
     add(headingPnl,BorderLayout.NORTH);
     add(mainPnl,BorderLayout.CENTER);
        
     pack();
    
     setVisible(true);
        
        
    }
    private class RegisterBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //read data
            String name=nameTField.getText();
            String surname=surnameTField.getText();
            String id=idTField.getText();
            String gender=(String)genderBox.getSelectedItem();
            Boolean isTrainerSelected=trainer.isSelected();
            String contractType="Month-to_month";
            
            if(sm.isSelected())
            {
                contractType="Six months";
            }
            else if(annual.isSelected())
            {
                contractType="Annual";
            }
            
            
            
            
                if(name.isEmpty() || surname.isEmpty() || id.isEmpty()) {
                memberTArea.setText("Please fill in all required fields.");
                }
                else if(checkIdValidity(id)==true ){
                    try {
       
                        Member member=new Member(name,surname,gender,id,contractType,isTrainerSelected);
                        MembersDB memberdb=new MembersDB(dburl,username,username);
                        memberdb.add(member);
                        memberTArea.setText("The member has been sucessfully registered ");

                    } catch (SQLException ex) {
                        memberTArea.setText(ex.getMessage());
                    }
                 }
                else{
                    memberTArea.setText("Invalid Id number");
                }
        }
    }
    private class ClearBtnListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
        
          nameTField.setText("");
          nameTField.setFocusable(true);
          surnameTField.setText("");
          idTField.setText("");
          memberTArea.setText("");
          trainer.setSelected(false);
          btnGrp.clearSelection();
        
        }
    }
    private class SearchBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           String id=idTField.getText();
            boolean ans=checkId(id);
            if(ans==false)
            {
             memberTArea.setText("The member does not exist");
            }
            else
            {   
                try {



                    MembersDB memberdb=new MembersDB(dburl,username,password);
                    Member member=memberdb.get(id);
                    memberTArea.setText("Name: "+member.getName()+" \nSurname: "+member.getSurname()+"\nID: "+member.getIdno()+" \nGender: "+member.getGender()+" \nContract Type: "+member.getContractsType()+"\nPersonal Trainer: "+ member.getTrainer() );
                } catch (SQLException ex) {
                    Logger.getLogger(MembershipFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
          
        }
        
    } 
    private class ExitBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           System.exit(1);
        }
    }
    private class UpdateBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name=nameTField.getText();
            String surname=surnameTField.getText();
            String id=idTField.getText();
            String gender=(String)genderBox.getSelectedItem();
            Boolean isTrainerSelected=trainer.isSelected();
            String contractType="Month to month";
             if(sm.isSelected())
            {
                contractType="Six months";
            }
            else if(annual.isSelected())
            {
                contractType="Annual";
            }
            boolean ans=checkId(id);
            if(ans==false)
            {
             memberTArea.setText("The member does not exist");
            }
            else
            {   
                try {
                    Member member=new Member(name,surname,gender,id,contractType,isTrainerSelected);
                    MembersDB memberdb=new MembersDB(dburl,username,password);
                    memberdb.update(member);
                    memberTArea.setText("The member has been sucessfully updated ");
                } catch (SQLException ex) {
                    Logger.getLogger(MembershipFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
     private class RemoveBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
         
     
            String idnum=idTField.getText();
           
             boolean ans=checkId(idnum);
            if(ans==false)
            {
             memberTArea.setText("The member does not exist");
            }
            else
            {   
                try {
                    

                   MembersDB memberdb=new MembersDB(dburl,username,password);
                   memberdb.remove(idnum);
                   memberTArea.setText("Member with id "+idnum +" has been removed" );
               } catch (SQLException ex) {
                   Logger.getLogger(MembershipFrame.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        }
    }
     private class GetAllBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             try {
                 
                MembersDB memberdb=new MembersDB(dburl,username,password);
               List<Member> members= memberdb.getAll();
               
                   
             
               
               for(int i=0;i<members.size();i++)
               {
                   memberTArea.append(i+" "+members.get(i).getIdno()+" "+members.get(i).getName()+" "+ members.get(i).getSurname()+" "+members.get(i).getGender()+" "+members.get(i).getContractsType()+" "+members.get(i).getTrainer()+"\n");
               }
               
                
            } catch (SQLException ex) {
                Logger.getLogger(MembershipFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     private boolean checkId(String id){
         int present=0;
          try {
                 
                MembersDB memberdb=new MembersDB(dburl,username,password);
               List<Member> members= memberdb.getAll();
               
                   
             
               
               for(int i=0;i<members.size();i++)
               {
                   if(id.equalsIgnoreCase(members.get(i).getIdno())){
                      present++;  
                   }
                   
                   
               }
               if(present==0){
                    return false;
               }
               else{
                    return true;
               }
                   
                
            } catch (SQLException ex) {
                Logger.getLogger(MembershipFrame.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
     
     }
     private Boolean checkIdValidity(String id)
    {
        boolean isValid=true;
        Integer prod;
         Integer total=0;
         for(int i=0;i<id.length();i++)
        {
         Character temp=id.charAt(i);
         Integer num=Integer.parseInt(temp.toString());
        
         int pos=i+1;
          
         if(pos%2==0)
         {
              prod=num*2;
               
               if(prod>9)
            {
                  prod=prod%9;
                  
            }
         }
         else
         {
             prod=num;
            
         }
         total+=prod;
        
      
        }
       
        if(total%10==0)
        {
            isValid=true;
        }
        else{
            isValid=false;
        }
        return isValid;
    }
    
}
