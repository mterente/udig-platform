/* uDig - User Friendly Desktop Internet GIS client
 * http://udig.refractions.net
 * (C) 2004-2011, Refractions Research Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * (http://www.eclipse.org/legal/epl-v10.html), and the Refractions BSD
 * License v1.0 (http://udig.refractions.net/files/bsd3-v10.html).
 */
package org.locationtech.udig.tool.select.internal;

import org.locationtech.udig.tool.select.SelectPlugin;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This  preference page provides access to all preference relating to selection tools.
 * 
 * @author leviputna
 * @since 1.3.0
 */
public class SelectionToolPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    
    public static final String ZOOM_TO_SELECTION = "aoiZoomToSelection"; //$NON-NLS-1$
    public static final String NAVIGATE_SELECTION = "aoiNavigateSelection"; //$NON-NLS-1$

//    private BooleanFieldEditor zoomToSelection;
    private BooleanFieldEditor navigateSelection;
    
    public SelectionToolPreferencePage() {
        super(GRID);
        IPreferenceStore store = SelectPlugin.getDefault().getPreferenceStore();
        setPreferenceStore(store);
        setTitle(Messages.Select_Title);
        setDescription(Messages.Select_Description);
    }

    @Override
    protected void createFieldEditors() {
        
        Label aoiSelection = new Label (getFieldEditorParent(), SWT.HORIZONTAL | SWT.BOLD | SWT.TITLE);
        aoiSelection.setText(Messages.Group_AOI);
        aoiSelection.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_HORIZONTAL));
        
//        zoomToSelection = new BooleanFieldEditor(ZOOM_TO_SELECTION, Messages.Zoom_To_Selection, getFieldEditorParent());
//        addField(zoomToSelection);
        
        navigateSelection = new BooleanFieldEditor(NAVIGATE_SELECTION, Messages.Navigate_Selection, getFieldEditorParent());
        addField(navigateSelection);
    }
    
    @Override
    public void init( IWorkbench workbench ) {
    }

   
}
