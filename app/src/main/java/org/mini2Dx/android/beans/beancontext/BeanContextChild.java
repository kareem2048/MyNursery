/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.mini2Dx.android.beans.beancontext;

import org.mini2Dx.android.beans.PropertyChangeListener;
import org.mini2Dx.android.beans.PropertyVetoException;
import org.mini2Dx.android.beans.VetoableChangeListener;
import org.mini2Dx.android.beans.beancontext.BeanContext;

public interface BeanContextChild {

    public void addPropertyChangeListener(String name,
                                          PropertyChangeListener pcl);

    public void addVetoableChangeListener(String name,
                                          VetoableChangeListener vcl);

    public BeanContext getBeanContext();

    public void removePropertyChangeListener(String name,
                                             PropertyChangeListener pcl);

    public void removeVetoableChangeListener(String name,
                                             VetoableChangeListener vcl);

    public void setBeanContext(BeanContext bc) throws PropertyVetoException;
}
