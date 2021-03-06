/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.hierarchyviewerlib.actions;

import com.android.ddmuilib.ImageLoader;
import com.android.hierarchyviewerlib.HierarchyViewerDirector;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class DumpDisplayListAction extends SelectedNodeEnabledAction implements ImageAction {

    private static DumpDisplayListAction sAction;

    private Image mImage;

    private DumpDisplayListAction() {
        super("Dump DisplayList");
        ImageLoader imageLoader = ImageLoader.getLoader(HierarchyViewerDirector.class);
        mImage = imageLoader.loadImage("load-view-hierarchy.png", Display.getDefault()); //$NON-NLS-1$
        setImageDescriptor(ImageDescriptor.createFromImage(mImage));
        setToolTipText("Request the view to output its displaylist to logcat");
    }

    public static DumpDisplayListAction getAction() {
        if (sAction == null) {
            sAction = new DumpDisplayListAction();
        }
        return sAction;
    }

    @Override
    public void run() {
        HierarchyViewerDirector.getDirector().dumpDisplayListForCurrentNode();
    }

    @Override
    public Image getImage() {
        return mImage;
    }
}
