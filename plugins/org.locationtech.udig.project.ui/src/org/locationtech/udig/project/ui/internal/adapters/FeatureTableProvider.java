/*
 *    uDig - User Friendly Desktop Internet GIS client
 *    http://udig.refractions.net
 *    (C) 2004, Refractions Research Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * (http://www.eclipse.org/legal/epl-v10.html), and the Refractions BSD
 * License v1.0 (http://udig.refractions.net/files/bsd3-v10.html).
 *
 */
package org.locationtech.udig.project.ui.internal.adapters;

import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * Provides ...TODO summary sentence
 * <p>
 * TODO Description
 * </p>
 * <p>
 * Responsibilities:
 * <ul>
 * <li>
 * <li>
 * </ul>
 * </p>
 * <p>
 * Example Use:
 * 
 * <pre><code>
 *  FeatureTableContentProvider x = new FeatureTableContentProvider( ... );
 *  TODO code example
 * </code></pre>
 * 
 * </p>
 * 
 * @author jones
 * @since 0.3
 */
public class FeatureTableProvider extends FeatureViewerProvider
        implements
            ITableLabelProvider,
            ITableColorProvider {

    /**
     * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
     */
    public Image getColumnImage( Object element, int columnIndex ) {
        // TODO implement method body
        return null;
    }

    /**
     * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
     */
    public String getColumnText( Object element, int columnIndex ) {
        if (element instanceof FeatureViewerProvider.Databag) {
            FeatureViewerProvider.Databag data = (Databag) element;
            switch( columnIndex ) {
            case 0:
                return data.descriptor.getDisplayName();
            case 1:
                Object value = data.source.getPropertyValue(data.descriptor.getId());
                if (value instanceof String)
                    return (String) value;
                return ""; //$NON-NLS-1$
            }
        }
        return null;
    }

    /**
     * @see org.eclipse.jface.viewers.ITableColorProvider#getForeground(java.lang.Object, int)
     */
    public Color getForeground( Object element, int columnIndex ) {
        // TODO implement method body
        return Display.getDefault().getSystemColor(SWT.COLOR_BLACK);
    }

    /**
     * @see org.eclipse.jface.viewers.ITableColorProvider#getBackground(java.lang.Object, int)
     */
    public Color getBackground( Object element, int columnIndex ) {
        // TODO implement method body
        return Display.getDefault().getSystemColor(SWT.COLOR_WHITE);
    }

}
