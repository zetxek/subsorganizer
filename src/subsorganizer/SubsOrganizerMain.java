/*
 * SubsOrganizerMain.java
 *
 * Created on 19-oct-2010, 23:26:06
 */
package subsorganizer;

import java.io.File;
import java.util.ArrayList;
import javax.lang.model.util.Elements;
import subsorganizer.beans.Chapter;
import subsorganizer.beans.Season;
import subsorganizer.beans.Serie;
import subsorganizer.beans.Subtitle;
import subsorganizer.tools.subsgetter;
import subsorganizer.tools.subsrenamer;

/**
 *
 * @author zetxek
 */
public class SubsOrganizerMain extends javax.swing.JFrame {

    public SubsOrganizerMain() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        dataSource = new subsorganizer.beans.DataSource();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        listSubtitles = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        cmbChapters = new javax.swing.JComboBox();
        btnDownload = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        mainPanel.setAutoscrolls(true);
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
        folderChooser.setFileHidingEnabled(false);
        folderChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(subsorganizer.SubsOrganizerApp.class).getContext().getResourceMap(SubsOrganizerMain.class);
        folderChooser.setToolTipText(resourceMap.getString("folderChooser.toolTipText")); // NOI18N
        folderChooser.setName("folderChooser"); // NOI18N
        folderChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folderChooserActionPerformed(evt);
            }
        });

        lblInfo.setText(resourceMap.getString("lblInfo.text")); // NOI18N
        lblInfo.setName("lblInfo"); // NOI18N

        chkRecursive.setSelected(true);
        chkRecursive.setText(resourceMap.getString("chkRecursive.text")); // NOI18N
        chkRecursive.setName("chkRecursive"); // NOI18N

        org.jdesktop.layout.GroupLayout panelDirectoryLayout = new org.jdesktop.layout.GroupLayout(panelDirectory);
        panelDirectory.setLayout(panelDirectoryLayout);
        panelDirectoryLayout.setHorizontalGroup(
            panelDirectoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelDirectoryLayout.createSequentialGroup()
                .add(lblInfo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(chkRecursive, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 455, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(panelDirectoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, folderChooser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE))
        );
        panelDirectoryLayout.setVerticalGroup(
            panelDirectoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelDirectoryLayout.createSequentialGroup()
                .add(panelDirectoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblInfo)
                    .add(chkRecursive))
                .addContainerGap(377, Short.MAX_VALUE))
            .add(panelDirectoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, panelDirectoryLayout.createSequentialGroup()
                    .addContainerGap(25, Short.MAX_VALUE)
                    .add(folderChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 355, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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

        org.jdesktop.layout.GroupLayout panelOutputLayout = new org.jdesktop.layout.GroupLayout(panelOutput);
        panelOutput.setLayout(panelOutputLayout);
        panelOutputLayout.setHorizontalGroup(
            panelOutputLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(txtOutputScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        panelOutputLayout.setVerticalGroup(
            panelOutputLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(txtOutputScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
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

        cmbSeries.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSeriesItemStateChanged(evt);
            }
        });
        cmbSeries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSeriesActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        cmbSeasons.setName("cmbSeasons"); // NOI18N

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedItem.seasons}");
        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cmbSeries, eLProperty, cmbSeasons);
        bindingGroup.addBinding(jComboBoxBinding);

        cmbSeasons.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSeasonsItemStateChanged(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        listSubtitles.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listSubtitles.setName("listSubtitles"); // NOI18N

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedItem.subtitles}");
        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cmbChapters, eLProperty, listSubtitles);
        bindingGroup.addBinding(jListBinding);

        jScrollPane2.setViewportView(listSubtitles);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        cmbChapters.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbChapters.setName("cmbChapters"); // NOI18N

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedItem.chapters}");
        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cmbSeasons, eLProperty, cmbChapters);
        bindingGroup.addBinding(jComboBoxBinding);

        cmbChapters.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbChaptersItemStateChanged(evt);
            }
        });

        btnDownload.setText(resourceMap.getString("btnDownload.text")); // NOI18N
        btnDownload.setName("btnDownload"); // NOI18N
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panelSubsLayout = new org.jdesktop.layout.GroupLayout(panelSubs);
        panelSubs.setLayout(panelSubsLayout);
        panelSubsLayout.setHorizontalGroup(
            panelSubsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelSubsLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelSubsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelSubsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelSubsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, cmbChapters, 0, 326, Short.MAX_VALUE)
                    .add(cmbSeasons, 0, 326, Short.MAX_VALUE)
                    .add(cmbSeries, 0, 326, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 103, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(23, 23, 23)
                .add(panelSubsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, btnDownload, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelSubsLayout.setVerticalGroup(
            panelSubsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelSubsLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelSubsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 301, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(panelSubsLayout.createSequentialGroup()
                        .add(panelSubsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(cmbSeries, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1)
                            .add(jLabel4))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(panelSubsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(cmbSeasons, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(panelSubsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(panelSubsLayout.createSequentialGroup()
                                .add(jLabel3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 217, Short.MAX_VALUE))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, cmbChapters, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnDownload)
                .add(50, 50, 50))
        );

        tabbedPane.addTab(resourceMap.getString("panelSubs.TabConstraints.tabTitle"), panelSubs); // NOI18N

        org.jdesktop.layout.GroupLayout mainPanelLayout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, tabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(subsorganizer.SubsOrganizerApp.class).getContext().getActionMap(SubsOrganizerMain.class, this);
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

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 971, Short.MAX_VALUE)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                    .add(0, 0, Short.MAX_VALUE)
                    .add(mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 446, Short.MAX_VALUE)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                    .add(0, 0, Short.MAX_VALUE)
                    .add(mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(0, 0, Short.MAX_VALUE)))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void folderChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folderChooserActionPerformed
        File selected = folderChooser.getSelectedFile();
        tabbedPane.setSelectedIndex(1);
        subsrenamer.readFiles(selected, chkRecursive.isSelected(), txtOutput);
}//GEN-LAST:event_folderChooserActionPerformed

    private void panelSubsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelSubsFocusGained
}//GEN-LAST:event_panelSubsFocusGained

    private void tabbedPaneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabbedPaneFocusGained
}//GEN-LAST:event_tabbedPaneFocusGained

    private void cmbSeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSeriesActionPerformed
    }//GEN-LAST:event_cmbSeriesActionPerformed

    private void cmbSeriesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSeriesItemStateChanged
        if (cmbSeries.getSelectedItem() != null) {
            ((Serie) cmbSeries.getSelectedItem()).setSeasons(
                    subsgetter.getSeasons((Serie) cmbSeries.getSelectedItem()));
        } else {
            System.out.println("null serie");
        }
    }//GEN-LAST:event_cmbSeriesItemStateChanged

    private void cmbSeasonsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSeasonsItemStateChanged
        if (cmbSeasons.getSelectedItem() != null) {

            ((Season) cmbSeasons.getSelectedItem()).setChapters(
                    subsgetter.getChapters(
                    (Serie) cmbSeries.getSelectedItem(),
                    (Season) cmbSeasons.getSelectedItem()));
        } else {
            System.out.println("null serie");
        }
    }//GEN-LAST:event_cmbSeasonsItemStateChanged

    private void cmbChaptersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbChaptersItemStateChanged
        if (cmbChapters.getSelectedItem() != null){
            Chapter chap = (Chapter) cmbChapters.getSelectedItem();
            //TO-DO: recover chapters and show them
            chap.setSubtitles(subsgetter.getSubtitles(chap));

            /*chap.setSubtitles(subsgetter.getChapters((Serie) cmbSeries.getSelectedItem(),
                    (Season) cmbSeasons.getSelectedItem()), chap.getLink());*/
        }else{
            System.out.println("null chapters");
        }
    }//GEN-LAST:event_cmbChaptersItemStateChanged

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        Object[] subtitles = listSubtitles.getSelectedValues();
         for (int i = 0; i < subtitles.length; i++){
             Subtitle sub = (Subtitle) subtitles[i];
             System.out.println("Downloading... " + sub.getLink() + "... for " + sub.getName());
         }


    }//GEN-LAST:event_btnDownloadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SubsOrganizerMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDownload;
    private javax.swing.JCheckBox chkRecursive;
    private javax.swing.JComboBox cmbChapters;
    private javax.swing.JComboBox cmbSeasons;
    private javax.swing.JComboBox cmbSeries;
    private subsorganizer.beans.DataSource dataSource;
    private javax.swing.JFileChooser folderChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JList listSubtitles;
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
}
