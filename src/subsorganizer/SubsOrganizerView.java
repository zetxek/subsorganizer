/*
 * SubsOrganizerView.java
 */
package subsorganizer;

import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFrame;
import subsorganizer.tools.subsrenamer;
import subsorganizer.beans.Season;
import subsorganizer.beans.Serie;

/**
 * The application's main frame.
 */
public class SubsOrganizerView extends javax.swing.JFrame {

    public SubsOrganizerView(SingleFrameApplication app) {

        initComponents();

        //Datasource
        for (Serie p : dataSource.getSeries()) {
            System.out.println(p.getName());
            System.out.println(p.getLink());
            System.out.println("Seasons:");

            for (Season l : p.getSeasons()) {
                System.out.println("\t" + l.getName() + " (" + l.getLink() + ")");
            }
        }

    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = SubsOrganizerApp.getApplication().getMainFrame();
            aboutBox = new SubsOrganizerAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        SubsOrganizerApp.getApplication().show(aboutBox);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        mainPanel = new javax.swing.JPanel();
        tabbedPane = new javax.swing.JTabbedPane();
        panelDirectory = new javax.swing.JPanel();
        folderChooser = new javax.swing.JFileChooser();
        lblInfo = new javax.swing.JLabel();
        chkRecursive = new javax.swing.JCheckBox();
        panelOutput = new javax.swing.JPanel();
        txtOutputScrollPane = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        panelSubs = new javax.swing.JPanel();
        cmbSeries = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbSeasons = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        dataSource = new subsorganizer.beans.DataSource();

        mainPanel.setName("mainPanel"); // NOI18N

        tabbedPane.setName("tabbedPane"); // NOI18N
        tabbedPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabbedPaneFocusGained(evt);
            }
        });

        panelDirectory.setName("panelDirectory"); // NOI18N

        folderChooser.setCurrentDirectory(new java.io.File("/"));
        folderChooser.setFileFilter(null);
        folderChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        folderChooser.setName("folderChooser"); // NOI18N
        folderChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folderChooserActionPerformed(evt);
            }
        });

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(subsorganizer.SubsOrganizerApp.class).getContext().getResourceMap(SubsOrganizerView.class);
        lblInfo.setText(resourceMap.getString("lblInfo.text")); // NOI18N
        lblInfo.setName("lblInfo"); // NOI18N

        chkRecursive.setSelected(true);
        chkRecursive.setText(resourceMap.getString("chkRecursive.text")); // NOI18N
        chkRecursive.setName("chkRecursive"); // NOI18N

        javax.swing.GroupLayout panelDirectoryLayout = new javax.swing.GroupLayout(panelDirectory);
        panelDirectory.setLayout(panelDirectoryLayout);
        panelDirectoryLayout.setHorizontalGroup(
            panelDirectoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDirectoryLayout.createSequentialGroup()
                .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkRecursive, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelDirectoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(folderChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE))
        );
        panelDirectoryLayout.setVerticalGroup(
            panelDirectoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDirectoryLayout.createSequentialGroup()
                .addGroup(panelDirectoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInfo)
                    .addComponent(chkRecursive))
                .addContainerGap(372, Short.MAX_VALUE))
            .addGroup(panelDirectoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDirectoryLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(folderChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        tabbedPane.addTab(resourceMap.getString("panelDirectory.TabConstraints.tabTitle"), panelDirectory); // NOI18N

        panelOutput.setName("panelOutput"); // NOI18N

        txtOutputScrollPane.setName("txtOutputScrollPane"); // NOI18N

        txtOutput.setColumns(20);
        txtOutput.setRows(5);
        txtOutput.setToolTipText(resourceMap.getString("txtOutput.toolTipText")); // NOI18N
        txtOutput.setName("txtOutput"); // NOI18N
        txtOutputScrollPane.setViewportView(txtOutput);
        txtOutput.getAccessibleContext().setAccessibleName(resourceMap.getString("txtOutput.AccessibleContext.accessibleName")); // NOI18N

        javax.swing.GroupLayout panelOutputLayout = new javax.swing.GroupLayout(panelOutput);
        panelOutput.setLayout(panelOutputLayout);
        panelOutputLayout.setHorizontalGroup(
            panelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtOutputScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
        );
        panelOutputLayout.setVerticalGroup(
            panelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtOutputScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
        );

        tabbedPane.addTab(resourceMap.getString("panelOutput.TabConstraints.tabTitle"), panelOutput); // NOI18N

        panelSubs.setName("panelSubs"); // NOI18N
        panelSubs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelSubsFocusGained(evt);
            }
        });

        cmbSeries.setName("cmbSeries"); // NOI18N

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${series}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, dataSource, eLProperty, cmbSeries);
        bindingGroup.addBinding(jComboBoxBinding);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        cmbSeasons.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSeasons.setName("cmbSeasons"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setName("jList1"); // NOI18N
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout panelSubsLayout = new javax.swing.GroupLayout(panelSubs);
        panelSubs.setLayout(panelSubsLayout);
        panelSubsLayout.setHorizontalGroup(
            panelSubsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSubsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panelSubsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSubsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbSeasons, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbSeries, javax.swing.GroupLayout.Alignment.LEADING, 0, 210, Short.MAX_VALUE)))
                .addContainerGap(623, Short.MAX_VALUE))
        );
        panelSubsLayout.setVerticalGroup(
            panelSubsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSubsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSubsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbSeasons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSubsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPane.addTab(resourceMap.getString("panelSubs.TabConstraints.tabTitle"), panelSubs); // NOI18N

        tabbedPane.setSelectedComponent(panelDirectory);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tabbedPane.getAccessibleContext().setAccessibleName(resourceMap.getString("jTabbedPane1.AccessibleContext.accessibleName")); // NOI18N

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(subsorganizer.SubsOrganizerApp.class).getContext().getActionMap(SubsOrganizerView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void folderChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folderChooserActionPerformed
        File selected = folderChooser.getSelectedFile();
        tabbedPane.setSelectedIndex(1);
        subsrenamer.readFiles(selected, chkRecursive.isSelected(), txtOutput);
    }//GEN-LAST:event_folderChooserActionPerformed

    private void panelSubsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelSubsFocusGained
    }//GEN-LAST:event_panelSubsFocusGained

    private void tabbedPaneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabbedPaneFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tabbedPaneFocusGained
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkRecursive;
    private javax.swing.JComboBox cmbSeasons;
    private javax.swing.JComboBox cmbSeries;
    private subsorganizer.beans.DataSource dataSource;
    private javax.swing.JFileChooser folderChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panelDirectory;
    private javax.swing.JPanel panelOutput;
    private javax.swing.JPanel panelSubs;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTextArea txtOutput;
    private javax.swing.JScrollPane txtOutputScrollPane;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private JDialog aboutBox;
}
