/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import com.petcare.database.DaBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author avish
 */
public class TreatmentsForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TreatmentsForm.class.getName());

    /**
     * Creates new form TreatmentsForm
     */
    public TreatmentsForm() {
        initComponents();
        txtTreatmentID.setEditable(false);
        loadTreatments();
    }
    
    private void loadTreatments() {

    DefaultTableModel model =
            (DefaultTableModel) tblTreatments.getModel();

    model.setRowCount(0);

    String sql = "SELECT * FROM Treatments ORDER BY TreatmentID";

    try (Connection con = DaBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {

            model.addRow(new Object[]{
                rs.getInt("TreatmentID"),
                rs.getInt("PetID"),
                rs.getInt("VetID"),
                rs.getDate("TreatmentDate"),
                rs.getString("Diagnosis"),
                rs.getString("TreatmentDetails"),
                rs.getString("Medicine"),
                rs.getBigDecimal("Cost")
            });
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(this,
                "Error loading treatments: " + e.getMessage());
    }
}
    
    private boolean validateTreatment() {

    String petID = txtPetID.getText().trim();
    String vetID = txtVetID.getText().trim();
    String date = txtTreatmentDate.getText().trim();
    String diagnosis = txtDiagnosis.getText().trim();
    String details = txtTreatmentDetails.getText().trim();
    String cost = txtCost.getText().trim();

    if (petID.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Please enter Pet ID!");
        txtPetID.requestFocus();
        return false;
    }

    if (!petID.matches("[0-9]+")
            || Integer.parseInt(petID) <= 0) {
        JOptionPane.showMessageDialog(this,
                "Pet ID must be a positive number!");
        txtPetID.requestFocus();
        return false;
    }

    if (vetID.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Please enter Veterinarian ID!");
        txtVetID.requestFocus();
        return false;
    }

    if (!vetID.matches("[0-9]+")
            || Integer.parseInt(vetID) <= 0) {
        JOptionPane.showMessageDialog(this,
                "Veterinarian ID must be a positive number!");
        txtVetID.requestFocus();
        return false;
    }

    if (date.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Please enter Treatment Date!");
        txtTreatmentDate.requestFocus();
        return false;
    }

    try {
        LocalDate.parse(date);
    } catch (DateTimeParseException e) {
        JOptionPane.showMessageDialog(this,
                "Enter date in YYYY-MM-DD format!");
        txtTreatmentDate.requestFocus();
        return false;
    }

    if (diagnosis.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Please enter Diagnosis!");
        txtDiagnosis.requestFocus();
        return false;
    }

    if (details.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Please enter Treatment Details!");
        txtTreatmentDetails.requestFocus();
        return false;
    }

    if (cost.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Please enter Treatment Cost!");
        txtCost.requestFocus();
        return false;
    }

    try {
        BigDecimal amount = new BigDecimal(cost);

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            JOptionPane.showMessageDialog(this,
                    "Treatment Cost cannot be negative!");
            txtCost.requestFocus();
            return false;
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "Please enter a valid Treatment Cost!");
        txtCost.requestFocus();
        return false;
    }

    return true;
}
    
    private void clearFields() {

    txtTreatmentID.setText("");
    txtPetID.setText("");
    txtVetID.setText("");
    txtTreatmentDate.setText("");
    txtDiagnosis.setText("");
    txtTreatmentDetails.setText("");
    txtMedicine.setText("");
    txtCost.setText("");
    txtSearch.setText("");

    tblTreatments.clearSelection();

    txtPetID.requestFocus();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Dashboard = new javax.swing.JButton();
        Pets = new javax.swing.JButton();
        appoint = new javax.swing.JButton();
        Owners = new javax.swing.JButton();
        Vets = new javax.swing.JButton();
        traets = new javax.swing.JButton();
        medi = new javax.swing.JButton();
        pay = new javax.swing.JButton();
        Report = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtTreatmentID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPetID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTreatmentDate = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        txtDiagnosis = new javax.swing.JTextField();
        txtVetID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTreatmentDetails = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMedicine = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTreatments = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(76, 29, 149));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 543));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pet Care");

        Dashboard.setBackground(new java.awt.Color(76, 29, 149));
        Dashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Dashboard.setForeground(new java.awt.Color(255, 255, 255));
        Dashboard.setText("Dashboard");
        Dashboard.setBorder(null);
        Dashboard.setFocusable(false);
        Dashboard.setOpaque(true);
        Dashboard.addActionListener(this::DashboardActionPerformed);

        Pets.setBackground(new java.awt.Color(76, 29, 149));
        Pets.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Pets.setForeground(new java.awt.Color(255, 255, 255));
        Pets.setText("Pets");
        Pets.setBorder(null);
        Pets.setFocusable(false);
        Pets.setOpaque(true);
        Pets.addActionListener(this::PetsActionPerformed);

        appoint.setBackground(new java.awt.Color(76, 29, 149));
        appoint.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        appoint.setForeground(new java.awt.Color(255, 255, 255));
        appoint.setText("Appointments");
        appoint.setBorder(null);
        appoint.setFocusable(false);
        appoint.setOpaque(true);
        appoint.addActionListener(this::appointActionPerformed);

        Owners.setBackground(new java.awt.Color(76, 29, 149));
        Owners.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Owners.setForeground(new java.awt.Color(255, 255, 255));
        Owners.setText("Owners");
        Owners.setBorder(null);
        Owners.setFocusable(false);
        Owners.setOpaque(true);
        Owners.addActionListener(this::OwnersActionPerformed);

        Vets.setBackground(new java.awt.Color(76, 29, 149));
        Vets.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Vets.setForeground(new java.awt.Color(255, 255, 255));
        Vets.setText("Veterinarians");
        Vets.setBorder(null);
        Vets.setFocusable(false);
        Vets.setOpaque(true);
        Vets.addActionListener(this::VetsActionPerformed);

        traets.setBackground(new java.awt.Color(76, 29, 149));
        traets.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        traets.setForeground(new java.awt.Color(255, 255, 255));
        traets.setText("Treatsments");
        traets.setBorder(null);
        traets.setFocusable(false);
        traets.setOpaque(true);
        traets.addActionListener(this::traetsActionPerformed);

        medi.setBackground(new java.awt.Color(76, 29, 149));
        medi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        medi.setForeground(new java.awt.Color(255, 255, 255));
        medi.setText("Medicines");
        medi.setBorder(null);
        medi.setFocusable(false);
        medi.setOpaque(true);
        medi.addActionListener(this::mediActionPerformed);

        pay.setBackground(new java.awt.Color(76, 29, 149));
        pay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pay.setForeground(new java.awt.Color(255, 255, 255));
        pay.setText("Payments");
        pay.setBorder(null);
        pay.setFocusable(false);
        pay.setOpaque(true);
        pay.addActionListener(this::payActionPerformed);

        Report.setBackground(new java.awt.Color(76, 29, 149));
        Report.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Report.setForeground(new java.awt.Color(255, 255, 255));
        Report.setText("Reports");
        Report.setBorder(null);
        Report.setFocusable(false);
        Report.setOpaque(true);
        Report.addActionListener(this::ReportActionPerformed);

        logout.setBackground(new java.awt.Color(76, 29, 149));
        logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("Logout");
        logout.setBorder(null);
        logout.setFocusable(false);
        logout.setOpaque(true);
        logout.addActionListener(this::logoutActionPerformed);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-home-24.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-dog-paw-24.png"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-user-24.png"))); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-stethoscope-30.png"))); // NOI18N

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-15-48.png"))); // NOI18N

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-pills-24.png"))); // NOI18N

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-hospital-24.png"))); // NOI18N

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-wallet-24.png"))); // NOI18N

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-graph-report-24.png"))); // NOI18N

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-logout-24.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addGap(8, 8, 8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pets)
                            .addComponent(Dashboard)
                            .addComponent(Owners)
                            .addComponent(Vets)
                            .addComponent(traets)
                            .addComponent(medi)
                            .addComponent(Report)
                            .addComponent(appoint)
                            .addComponent(pay)
                            .addComponent(logout))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(29, 29, 29)
                                        .addComponent(Dashboard))
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addComponent(Pets))
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addComponent(Owners))
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(Vets))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appoint)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(medi))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(traets)
                        .addComponent(jLabel21)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(pay))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(Report))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(logout))
                .addContainerGap(329, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setForeground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(76, 29, 149));
        jLabel2.setText("Treatment Management");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(100, 80, 160));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-paw-print-100.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(76, 29, 149));
        jLabel4.setText("Treatment Details");

        txtTreatmentID.setBackground(new java.awt.Color(255, 255, 255));
        txtTreatmentID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTreatmentID.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 0, 153)));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-dog-paw-50.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(45, 27, 78));
        jLabel8.setText("Vet ID");

        txtPetID.setBackground(new java.awt.Color(255, 255, 255));
        txtPetID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPetID.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 0, 153)));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(45, 27, 78));
        jLabel9.setText("Pet ID");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(45, 27, 78));
        jLabel10.setText("Treatment Date");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(45, 27, 78));
        jLabel11.setText("Diagnosis");

        txtTreatmentDate.setBackground(new java.awt.Color(255, 255, 255));
        txtTreatmentDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTreatmentDate.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 0, 153)));
        txtTreatmentDate.addActionListener(this::txtTreatmentDateActionPerformed);

        btnSave.setBackground(new java.awt.Color(46, 160, 90));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-save-20.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setFocusable(false);
        btnSave.setOpaque(true);
        btnSave.addActionListener(this::btnSaveActionPerformed);

        btnDelete.setBackground(new java.awt.Color(225, 35, 50));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-delete-20.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setFocusable(false);
        btnDelete.setOpaque(true);
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        btnUpdate.setBackground(new java.awt.Color(105, 65, 240));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-edit-20.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setFocusable(false);
        btnUpdate.setOpaque(true);
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnClear.setBackground(new java.awt.Color(105, 120, 165));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-refresh-20.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.setFocusable(false);
        btnClear.setOpaque(true);
        btnClear.addActionListener(this::btnClearActionPerformed);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(45, 27, 78));
        jLabel27.setText("Treatment ID");

        txtDiagnosis.setBackground(new java.awt.Color(255, 255, 255));
        txtDiagnosis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiagnosis.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 0, 153)));

        txtVetID.setBackground(new java.awt.Color(255, 255, 255));
        txtVetID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtVetID.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 0, 153)));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(45, 27, 78));
        jLabel12.setText("Treatment Details");

        txtTreatmentDetails.setBackground(new java.awt.Color(255, 255, 255));
        txtTreatmentDetails.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTreatmentDetails.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 0, 153)));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(45, 27, 78));
        jLabel13.setText("Medicine");

        txtMedicine.setBackground(new java.awt.Color(255, 255, 255));
        txtMedicine.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMedicine.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 0, 153)));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(45, 27, 78));
        jLabel28.setText("Cost");

        txtCost.setBackground(new java.awt.Color(255, 255, 255));
        txtCost.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCost.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 0, 153)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTreatmentID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiagnosis, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVetID))
                                .addComponent(jLabel13))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel28)
                                .addComponent(jLabel10)
                                .addComponent(txtPetID, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                .addComponent(txtTreatmentDate)
                                .addComponent(jLabel9)
                                .addComponent(jLabel12)
                                .addComponent(txtTreatmentDetails)
                                .addComponent(txtCost))
                            .addContainerGap(144, Short.MAX_VALUE)))
                    .addComponent(txtMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTreatmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPetID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTreatmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVetID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTreatmentDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnClear))
                .addGap(26, 26, 26))
        );

        tblTreatments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Treatment ID ", "Pet ID", "Vet ID", "Treatment Date", "Diagnosis", "Treatment Details", "Medicine", "Cost"
            }
        ));
        jScrollPane2.setViewportView(tblTreatments);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(45, 27, 78));
        jLabel6.setText("Search Treatment");

        txtSearch.setBackground(new java.awt.Color(255, 255, 255));
        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 0, 153)));

        btnsearch.setBackground(new java.awt.Color(153, 204, 255));
        btnsearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsearch.setForeground(new java.awt.Color(255, 255, 255));
        btnsearch.setText("Search");
        btnsearch.addActionListener(this::btnsearchActionPerformed);

        btnRefresh.setBackground(new java.awt.Color(153, 204, 255));
        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(this::btnRefreshActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnsearch))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh)
                        .addGap(78, 78, 78))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardActionPerformed
        DashboardForm dashboard = new DashboardForm();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DashboardActionPerformed

    private void PetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PetsActionPerformed
        new PetsForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PetsActionPerformed

    private void appointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointActionPerformed
        AppointmentsForm appointment = new AppointmentsForm();
        appointment.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_appointActionPerformed

    private void OwnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OwnersActionPerformed
        OwnersForm owner = new OwnersForm();
        owner.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_OwnersActionPerformed

    private void VetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VetsActionPerformed
        VetsForm vets = new VetsForm();
        vets.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VetsActionPerformed

    private void traetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traetsActionPerformed
        TreatmentsForm treat = new TreatmentsForm();
        treat.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_traetsActionPerformed

    private void mediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediActionPerformed
        MedicinesForm medi = new MedicinesForm();
        medi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mediActionPerformed

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        PaymentsForm pay = new PaymentsForm();
        pay.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_payActionPerformed

    private void ReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportActionPerformed
        ReportsForm report = new ReportsForm();
        report.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReportActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        int confirm = JOptionPane.showConfirmDialog( this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION );
        if (confirm == JOptionPane.YES_OPTION) {
            new LoginForm().setVisible(true); this.dispose(); }
    }//GEN-LAST:event_logoutActionPerformed

    private void txtTreatmentDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTreatmentDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTreatmentDateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        

    if (!validateTreatment()) {
        return;
    }

    String sql = "INSERT INTO Treatments "
            + "(PetID, VetID, TreatmentDate, Diagnosis, "
            + "TreatmentDetails, Medicine, Cost) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection con = DaBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1,
                Integer.parseInt(txtPetID.getText().trim()));

        pst.setInt(2,
                Integer.parseInt(txtVetID.getText().trim()));

        pst.setDate(3,
                Date.valueOf(txtTreatmentDate.getText().trim()));

        pst.setString(4, txtDiagnosis.getText().trim());

        pst.setString(5,
                txtTreatmentDetails.getText().trim());

        pst.setString(6, txtMedicine.getText().trim());

        pst.setBigDecimal(7,
                new BigDecimal(txtCost.getText().trim()));

        pst.executeUpdate();

        JOptionPane.showMessageDialog(this,
                "Treatment saved successfully!");

        loadTreatments();
        clearFields();

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(this,
                "Error saving treatment: " + e.getMessage());
    }

            
       
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed


    if (txtTreatmentID.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Please select a treatment to delete!");
        return;
    }

    int treatmentID;

    try {
        treatmentID = Integer.parseInt(
                txtTreatmentID.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "Invalid Treatment ID!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete this treatment?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);

    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    String sql = "DELETE FROM Treatments WHERE TreatmentID=?";

    try (Connection con = DaBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, treatmentID);

        int result = pst.executeUpdate();

        if (result > 0) {

            JOptionPane.showMessageDialog(this,
                    "Treatment deleted successfully!");

            loadTreatments();
            clearFields();

        } else {

            JOptionPane.showMessageDialog(this,
                    "Treatment not found!");
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(this,
                "Error deleting treatment: " + e.getMessage());
    }

       

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        

    if (txtTreatmentID.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Please select a treatment to update!");
        return;
    }

    if (!validateTreatment()) {
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to update this treatment?",
            "Confirm Update",
            JOptionPane.YES_NO_OPTION);

    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    String sql = "UPDATE Treatments SET PetID=?, VetID=?, "
            + "TreatmentDate=?, Diagnosis=?, TreatmentDetails=?, "
            + "Medicine=?, Cost=? WHERE TreatmentID=?";

    try (Connection con = DaBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1,
                Integer.parseInt(txtPetID.getText().trim()));

        pst.setInt(2,
                Integer.parseInt(txtVetID.getText().trim()));

        pst.setDate(3,
                Date.valueOf(txtTreatmentDate.getText().trim()));

        pst.setString(4, txtDiagnosis.getText().trim());

        pst.setString(5,
                txtTreatmentDetails.getText().trim());

        pst.setString(6, txtMedicine.getText().trim());

        pst.setBigDecimal(7,
                new BigDecimal(txtCost.getText().trim()));

        pst.setInt(8,
                Integer.parseInt(txtTreatmentID.getText().trim()));

        int result = pst.executeUpdate();

        if (result > 0) {

            JOptionPane.showMessageDialog(this,
                    "Treatment updated successfully!");

            loadTreatments();
            clearFields();

        } else {

            JOptionPane.showMessageDialog(this,
                    "Treatment not found!");
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(this,
                "Error updating treatment: " + e.getMessage());
    }

      
      
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed


    String search = txtSearch.getText().trim();

    if (search.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Please enter Treatment ID, Pet ID, Diagnosis or Medicine!");
        txtSearch.requestFocus();
        return;
    }

    String sql = "SELECT * FROM Treatments WHERE "
            + "CAST(TreatmentID AS CHAR) LIKE ? "
            + "OR CAST(PetID AS CHAR) LIKE ? "
            + "OR Diagnosis LIKE ? OR Medicine LIKE ?";

    try (Connection con = DaBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        String value = "%" + search + "%";

        pst.setString(1, value);
        pst.setString(2, value);
        pst.setString(3, value);
        pst.setString(4, value);

        try (ResultSet rs = pst.executeQuery()) {

            DefaultTableModel model =
                    (DefaultTableModel) tblTreatments.getModel();

            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("TreatmentID"),
                    rs.getInt("PetID"),
                    rs.getInt("VetID"),
                    rs.getDate("TreatmentDate"),
                    rs.getString("Diagnosis"),
                    rs.getString("TreatmentDetails"),
                    rs.getString("Medicine"),
                    rs.getBigDecimal("Cost")
                });
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this,
                        "No treatments found!");
            }
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(this,
                "Error searching treatments: " + e.getMessage());
    }

        

    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
       

    loadTreatments();
    clearFields();

    JOptionPane.showMessageDialog(this,
            "Treatment list refreshed successfully!");

    }//GEN-LAST:event_btnRefreshActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TreatmentsForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Dashboard;
    private javax.swing.JButton Owners;
    private javax.swing.JButton Pets;
    private javax.swing.JButton Report;
    private javax.swing.JButton Vets;
    private javax.swing.JButton appoint;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logout;
    private javax.swing.JButton medi;
    private javax.swing.JButton pay;
    private javax.swing.JTable tblTreatments;
    private javax.swing.JButton traets;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtDiagnosis;
    private javax.swing.JTextField txtMedicine;
    private javax.swing.JTextField txtPetID;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTreatmentDate;
    private javax.swing.JTextField txtTreatmentDetails;
    private javax.swing.JTextField txtTreatmentID;
    private javax.swing.JTextField txtVetID;
    // End of variables declaration//GEN-END:variables
}
