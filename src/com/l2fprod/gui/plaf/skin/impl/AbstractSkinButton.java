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
package com.l2fprod.gui.plaf.skin.impl;

import java.awt.*;
import javax.swing.*;

import com.l2fprod.gui.plaf.skin.*;

/**
 * @author    $Author: l2fprod $
 * @created   27 avril 2002
 * @version   $Revision: 1.1 $, $Date: 2003/08/01 20:05:29 $
 */
public class AbstractSkinButton extends AbstractSkinComponent implements SkinButton {

  public AbstractSkinButton() {
  }

  public AbstractSkinButton(Skin p_ParentSkin) {
    super(p_ParentSkin);
  }

  /**
   * Gets the CheckBoxIconSize attribute of the AbstractSkinButton object
   *
   * @return   The CheckBoxIconSize value
   */
  public Dimension getCheckBoxIconSize() {
    return null;
  }

  /**
   * Gets the RadioButtonIconSize attribute of the AbstractSkinButton object
   *
   * @return   The RadioButtonIconSize value
   */
  public Dimension getRadioButtonIconSize() {
    return null;
  }

  /**
   * Gets the RadioIcon attribute of the AbstractSkinButton object
   *
   * @param b  Description of Parameter
   * @return   The RadioIcon value
   */
  public Icon getRadioIcon(AbstractButton b) {
    return null;
  }

  /**
   * Description of the Method
   *
   * @return   Description of the Returned Value
   */
  public boolean status() {
    return false;
  }

  /**
   * Description of the Method
   *
   * @param c  Description of Parameter
   * @return   Description of the Returned Value
   */
  public boolean installSkin(JComponent c) {
    return false;
  }

  /**
   * Description of the Method
   *
   * @param g  Description of Parameter
   * @param b  Description of Parameter
   * @return   Description of the Returned Value
   */
  public final boolean paintButton(Graphics g, AbstractButton b) {
    ButtonModel model = b.getModel();

    if (b.isEnabled() == false) {
      return paintDisabledButton(g, b);
    }
    else {
      //PENDING(fred): should handle disabledINButton,
      // when the toggle button is disabled but pressed (armed)
      if (b instanceof JToggleButton) {
        if ((model.isArmed() && model.isPressed()) || model.isSelected()) {
          return paintPressedToggle(g, b);
        }
        else if (model.isRollover()) {
          return paintRolloverToggle(g, b);
        }
        else {
          return paintToggle(g, b);
        }
      }
      else if (b instanceof JButton) {
        if (model.isPressed() && (b.isRolloverEnabled() == false || (b.isRolloverEnabled() && model.isRollover()))) {
          return paintPressedButton(g, b);
        }
        else if (model.isRollover()) {
          return paintRolloverButton(g, b);
        }
        else {
          return paintNormalButton(g, b);
        }
      }
    }

    return false;
  }

  protected boolean paintDisabledButton(Graphics g, AbstractButton b) {
    return false;
  }

  protected boolean paintPressedToggle(Graphics g, AbstractButton b) {
    return false;
  }

  protected boolean paintRolloverToggle(Graphics g, AbstractButton b) {
    return false;
  }

  protected boolean paintToggle(Graphics g, AbstractButton b) {
    return false;
  }

  protected boolean paintPressedButton(Graphics g, AbstractButton b) {
    return false;
  }

  protected boolean paintRolloverButton(Graphics g, AbstractButton b) {
    return false;
  }

  protected boolean paintNormalButton(Graphics g, AbstractButton b) {
    return false;
  }

}
