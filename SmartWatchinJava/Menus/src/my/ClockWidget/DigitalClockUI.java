/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ClockWidget;


import java.awt.*;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import menus.MainMenu;

/**
 *
 * @author Ak
 */
public class DigitalClockUI extends javax.swing.JFrame {

    int timeRun = 0;
    int xMouse, yMouse;
        
    /**
     * Creates new form DigitalClockUI
     */
    public DigitalClockUI() {
        CustomCursor();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(317, 125);
        initComponents();
        getContentPane().setBackground(Color.BLACK);
        setLocation(950, 30);
        this.setIconImage(new ImageIcon(getClass().getResource("icon2.png")).getImage());

        new Thread() {
            public void run() {
                while (timeRun == 0) {
                    String month = "";
                    String day_of_week;
                    Calendar cal = new GregorianCalendar();
                    int d = cal.get(Calendar.DAY_OF_MONTH);
                    int mo = cal.get(Calendar.MONTH);
                    //<editor-fold defaultstate="collapsed" desc="int MONTH">
                    switch (mo) {
                        case 0:
                            month = "JAN";
                            break;
                        case 1:
                            month = "FEB";
                            break;
                        case 2:
                            month = "MAR";
                            break;
                        case 3:
                            month = "APR";
                            break;
                        case 4:
                            month = "MAY";
                            break;
                        case 5:
                            month = "JUNE";
                            break;
                        case 6:
                            month = "JULY";
                            break;
                        case 7:
                            month = "AUG";
                            break;
                        case 8:
                            month = "SEP";
                            break;
                        case 9:
                            month = "OCT";
                            break;
                        case 10:
                            month = "NOV";
                            break;
                        case 11:
                            month = "DEC";
                            break;
                    }
                    //</editor-fold>
                    int y = cal.get(Calendar.YEAR);

                    int h = ((cal.get(Calendar.HOUR) != 0 ? cal.get(Calendar.HOUR):12));
                    int m = cal.get(Calendar.MINUTE);
                    int s = cal.get(Calendar.SECOND);
                    int AM_PM = cal.get(Calendar.AM_PM);
                    int day_week = cal.get(Calendar.DAY_OF_WEEK);
                    
//"C:\Users\Ak\Documents\NetBeansProjects\ClockWidgetUI\cursor2.png"

                    String dat = d + "";
                    String year = y + "";
                    //<editor-fold defaultstate="collapsed" desc="String day_of_week">
                    switch (day_week){
                        case 1:
                            day_of_week = "Sunday";
                            break;
                        case 2:
                            day_of_week = "Monday";
                            break;
                        case 3:
                            day_of_week = "Tuesday";
                            break;
                        case 4:
                            day_of_week = "Wednesday";
                            break;
                        case 5:
                            day_of_week = "Thursday";
                            break;
                        case 6:
                            day_of_week = "Friday";
                            break;
                        default:
                            day_of_week = "Saturday";
                            break;
                    }
                    //</editor-fold>
                    String date = String.format(" %s %s %s, %s ", dat, month, year, day_of_week);
                    
                    

                    String hour = ((h < 10 ? ("0" + String.valueOf(h)) : String.valueOf(h)));
                    String min = ((m < 10 ? ("0" + String.valueOf(m)) : String.valueOf(m)));
                    String sec = ((s < 10 ? ("0" + String.valueOf(s)) : String.valueOf(s)));
                    String A_P = ((AM_PM == 0 ? "AM" : "PM"));

                    String time = hour + ":" + min + ":" + sec + " " + A_P;
                    clockPanel.setText(time);
                    datePanel.setText(date);

                }
            }
        }.start();
    }

    public void getCustomHandCursor() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("C:\\Users\\Monsur\\Desktop\\CLock\\ClockWidgetUI\\src\\my\\ClockWidget\\cursor2.png");
        Point pt = new Point(0, 0);
        Cursor cursor = tk.createCustomCursor(img, pt, "Hand");
        exitBtn.setCursor(cursor);
    }

    public void CustomCursor() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("C:\\Users\\Monsur\\Desktop\\CLock\\ClockWidgetUI\\src\\my\\ClockWidget\\cursor.png");
        Point pt = new Point(0, 0);
        Cursor cursor = tk.createCustomCursor(img, pt, "cursor");
        setCursor(cursor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePanel = new javax.swing.JLabel();
        clockPanel = new javax.swing.JLabel();
        exitBtn = new javax.swing.JLabel();
        Bg = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datePanel.setFont(new java.awt.Font("LetterOMatic!", 0, 18)); // NOI18N
        datePanel.setForeground(new java.awt.Color(0, 165, 255));
        datePanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datePanel.setToolTipText("");
        datePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                datePanelMousePressed(evt);
            }
        });
        datePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                datePanelMouseDragged(evt);
            }
        });
        getContentPane().add(datePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 280, 20));

        clockPanel.setFont(new java.awt.Font("Gungsuh", 1, 45)); // NOI18N
        clockPanel.setForeground(new java.awt.Color(0, 165, 255));
        clockPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(clockPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 310, 80));

        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitBtnMouseExited(evt);
            }
        });
        getContentPane().add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 3, 40, 30));

        Bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/ClockWidget/Bg.png"))); // NOI18N
        Bg.setMaximumSize(new java.awt.Dimension(318, 125));
        Bg.setOpaque(true);
        Bg.setPreferredSize(new java.awt.Dimension(317, 131));
        Bg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BgMouseDragged(evt);
            }
        });
        Bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BgMousePressed(evt);
            }
        });
        getContentPane().add(Bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 317, 125));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("GulimChe", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitBtnMouseClicked

    private void BgMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BgMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_BgMouseDragged

    private void BgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BgMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_BgMousePressed

    private void datePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datePanelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();        // TODO add your handling code here:
    }//GEN-LAST:event_datePanelMousePressed

    private void datePanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datePanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);        // TODO add your handling code here:
    }//GEN-LAST:event_datePanelMouseDragged

    private void exitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseEntered
        getCustomHandCursor();
    }//GEN-LAST:event_exitBtnMouseEntered

    private void exitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseExited
        CustomCursor();        // TODO add your handling code here:
    }//GEN-LAST:event_exitBtnMouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      dispose();
      MainMenu menu = new MainMenu();
      menu.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

//    public static void main(String args[]) {
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DigitalClockUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DigitalClockUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DigitalClockUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DigitalClockUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DigitalClockUI().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bg;
    private javax.swing.JLabel clockPanel;
    private javax.swing.JLabel datePanel;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
