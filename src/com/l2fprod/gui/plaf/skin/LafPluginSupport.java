/**
 * Skin Look And Feel 6.7 License.
 *
 * Copyright 2000-2006 L2FProd.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.l2fprod.gui.plaf.skin;

import javax.swing.UIDefaults;

import org.jvnet.lafplugin.ComponentPluginManager;

/**
 * Implements support for the laf-plugin project.
 * 
 * @see <a href="http://laf-plugin.dev.java.net">Laf-Plugin</a>
 */
public class LafPluginSupport {

  public static final String PLUGIN_XML = "META-INF/skinlf-plugin.xml";

  private static ComponentPluginManager pluginManager = new ComponentPluginManager(
    PLUGIN_XML);

  /**
   * Called by {@link SkinLookAndFeel#initComponentDefaults(UIDefaults)}
   */
  public static void initAllDefaultsEntries(UIDefaults table) {
    pluginManager.processAllDefaultsEntries(table, SkinLookAndFeel.getSkin());
  }

  /**
   * Called by {@link SkinLookAndFeel#initialize()}
   */
  public static void initialize() {
    pluginManager.initializeAll();
  }

}
