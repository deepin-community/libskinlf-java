/* ====================================================================
 *
 * Skin Look And Feel 6.7 License.
 *
 * Copyright (c) 2000-2006 L2FProd.com.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by L2FProd.com
 *        (http://www.L2FProd.com/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "Skin Look And Feel", "SkinLF" and "L2FProd.com" must not
 *    be used to endorse or promote products derived from this software
 *    without prior written permission. For written permission, please
 *    contact info@L2FProd.com.
 *
 * 5. Products derived from this software may not be called "SkinLF"
 *    nor may "SkinLF" appear in their names without prior written
 *    permission of L2FProd.com.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL L2FPROD.COM OR ITS CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
 * BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * ====================================================================
 */
package com.l2fprod.gui.plaf.skin;

import java.util.Enumeration;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 * @author    $Author: l2fprod $
 * @created   27 avril 2002
 * @version   $Revision: 1.2 $, $Date: 2003/12/06 21:47:37 $
 */
public final class SkinTableHeaderUI extends BasicTableHeaderUI {

  TableCellRenderer renderer;
  Skin skin = SkinLookAndFeel.getSkin();

  /**
   * Constructor for the SkinTableHeaderUI object
   */
  public SkinTableHeaderUI() {
    super();
    renderer = skin.getPersonality().getTableHeaderRenderer();
  }

  /**
   * Description of the Method
   *
   * @param c  Description of Parameter
   */
  public void installUI(JComponent c) {
    super.installUI(c);

    try {
      // if JDK1.3 or later
      header.getClass().getMethod("setDefaultRenderer", new Class[]{TableCellRenderer.class}).invoke(header, new Object[]{renderer});
    } catch (Exception e) {
      // else do it the old way
      Enumeration enumeration = header.getColumnModel().getColumns();
      while (enumeration.hasMoreElements()) {
        TableColumn aColumn = (TableColumn) enumeration.nextElement();
        aColumn.setHeaderRenderer(renderer);
      }
    }
    // end of else
  }

  /**
   * Description of the Method
   *
   * @param h  Description of Parameter
   * @return   Description of the Returned Value
   */
  public static ComponentUI createUI(JComponent h) {
    return new SkinTableHeaderUI();
  }

}

