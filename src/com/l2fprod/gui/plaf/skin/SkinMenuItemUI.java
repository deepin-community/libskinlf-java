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

import javax.swing.plaf.basic.*;
import javax.swing.plaf.*;
import javax.swing.*;

import java.awt.*;

/**
 * @author    $Author: l2fprod $
 * @created   27 avril 2002
 * @version   $Revision: 1.3 $, $Date: 2005/11/19 09:22:37 $
 */
public class SkinMenuItemUI extends BasicMenuItemUI {

  private Skin skin = SkinLookAndFeel.getSkin();

  protected void paintBackground(Graphics g, JMenuItem menuItem, Color bgColor) {
    Graphics2D g2d = (Graphics2D)g;
    AlphaComposite alpha = (AlphaComposite)((JComponent)menuItem.getParent())
      .getClientProperty("alpha");
    Composite oldComposite = g2d.getComposite();
    if (alpha != null) {
      g2d.setComposite(alpha);
    }
    // end of if (alpha == null)

    skin.getPersonality().paintMenuItem(g, menuItem);

    if (alpha != null) {
      g2d.setComposite(oldComposite);
    }
  }

  /**
   * Description of the Method
   */
  protected void installDefaults() {
    super.installDefaults();
    menuItem.setOpaque(false);
  }

  /**
   * Description of the Method
   */
  protected void uninstallDefaults() {
    super.uninstallDefaults();
    menuItem.setOpaque(true);
  }

  /**
   * Description of the Method
   *
   * @param c  Description of Parameter
   * @return   Description of the Returned Value
   */
  public static ComponentUI createUI(JComponent c) {
    return new SkinMenuItemUI();
  }

}
