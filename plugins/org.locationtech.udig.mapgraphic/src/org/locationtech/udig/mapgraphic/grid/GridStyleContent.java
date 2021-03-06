/* uDig - User Friendly Desktop Internet GIS client
 * http://udig.refractions.net
 * (C) 2004, Refractions Research Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * (http://www.eclipse.org/legal/epl-v10.html), and the Refractions BSD
 * License v1.0 (http://udig.refractions.net/files/bsd3-v10.html).
 */
package org.locationtech.udig.mapgraphic.grid;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;

import org.locationtech.udig.catalog.IGeoResource;
import org.locationtech.udig.mapgraphic.grid.GridStyle.Type;
import org.locationtech.udig.project.StyleContent;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IMemento;

public class GridStyleContent extends StyleContent {
    private static final String LINE_STYLE_ID = "LINE_STYLE_ID"; //$NON-NLS-1$
    private static final String LINE_WIDTH_ID = "LINE_WIDTH_ID"; //$NON-NLS-1$
    private static final String RED_ID = "RED_ID"; //$NON-NLS-1$
    private static final String GREEN_ID = "GREEN_ID"; //$NON-NLS-1$
    private static final String BLUE_ID = "BLUE_ID"; //$NON-NLS-1$
    private static final String ALPHA_ID = "ALPHA_ID"; //$NON-NLS-1$
    private static final String TYPE_ID = "TYPE_ID"; //$NON-NLS-1$
    private static final String DX_ID = "DX_ID"; //$NON-NLS-1$
    private static final String DY_ID = "DY_ID"; //$NON-NLS-1$

    public GridStyleContent( ) {
        super(GridStyle.ID);
    }

    @Override
    public Object createDefaultStyle( IGeoResource resource, Color colour,
            IProgressMonitor monitor ) throws IOException {
        if( resource.canResolve(GridMapGraphic.class))
            return GridStyle.DEFAULT_STYLE;
        
        return null;
    }

    @Override
    public Class<?> getStyleClass() {
        return GridStyle.class;
    }

    @Override
    public Object load( IMemento memento ) {
        int lineStyle = memento.getInteger(LINE_STYLE_ID);
        int lineWidth = memento.getInteger(LINE_WIDTH_ID);
        int red = memento.getInteger(RED_ID);
        int green = memento.getInteger(GREEN_ID);
        int blue = memento.getInteger(BLUE_ID);
        int alpha = memento.getInteger(ALPHA_ID);
        Color color = new Color(red, green, blue, alpha);

        Type type = Type.valueOf(memento.getString(TYPE_ID));
        double dx = Double.parseDouble(memento.getString(DX_ID));
        double dy = Double.parseDouble(memento.getString(DY_ID));
        return new GridStyle(type, dx, dy, color, lineStyle, lineWidth);
    }

    @Override
    public Object load( URL url, IProgressMonitor monitor ) throws IOException {
        return null;
    }

    @Override
    public void save( IMemento memento, Object value ) {
        if (value instanceof GridStyle) {
            GridStyle style = (GridStyle) value;

            memento.putInteger(LINE_STYLE_ID, style.getLineStyle());
            memento.putInteger(LINE_WIDTH_ID, style.getLineWidth());
            memento.putInteger(RED_ID, style.getColor().getRed());
            memento.putInteger(GREEN_ID, style.getColor().getGreen());
            memento.putInteger(BLUE_ID, style.getColor().getBlue());
            memento.putInteger(ALPHA_ID, style.getColor().getAlpha());
            memento.putString(TYPE_ID, style.getType().name());
            memento.putString(DX_ID, String.valueOf(style.getGridSize()[0]));
            memento.putString(DY_ID, String.valueOf(style.getGridSize()[1]));
        }
    }
}
