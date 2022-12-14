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
package com.l2fprod.gui.plaf.skin.impl.gtk;

import com.l2fprod.gui.plaf.skin.DefaultButton;
import com.l2fprod.gui.plaf.skin.SkinTab;
import com.l2fprod.gui.plaf.skin.impl.AbstractSkinTab;
import com.l2fprod.gui.plaf.skin.impl.gtk.parser.GtkParser;
import com.l2fprod.util.ImageUtils;

import javax.swing.JComponent;
import javax.swing.SwingConstants;

/**
 * @author    $Author: l2fprod $
 * @created   27 avril 2002
 * @version   $Revision: 1.5 $, $Date: 2005/11/19 09:18:06 $
 */
final class GtkTab extends AbstractSkinTab implements SkinTab {

  DefaultButton selected_top, unselected_top;
  DefaultButton selected_bottom, unselected_bottom;
  DefaultButton selected_left, unselected_left;
  DefaultButton selected_right, unselected_right;

  DefaultButton border;

  /**
   * Constructor for the GtkTab object
   *
   * @param parser         Description of Parameter
   * @exception Exception  Description of Exception
   */
  public GtkTab(GtkParser parser) throws Exception {
    unselected_top = GtkUtils.newButton(parser, "GtkNotebook",
        new String[]{"function", "state", "gap_side"},
        new String[]{"EXTENSION", "ACTIVE", "BOTTOM"}, false, false, false, false);
    selected_top = GtkUtils.newButton(parser, "GtkNotebook",
        new String[]{"function", "state", "gap_side"},
        new String[]{"EXTENSION", null, "BOTTOM"}, false, true, true, false);

    unselected_bottom = GtkUtils.newButton(parser, "GtkNotebook",
        new String[]{"function", "state", "gap_side"},
        new String[]{"EXTENSION", "ACTIVE", "TOP"}, false, true, false, false);
    selected_bottom = GtkUtils.newButton(parser, "GtkNotebook",
        new String[]{"function", "state", "gap_side"},
        new String[]{"EXTENSION", null, "TOP"}, false, true, false, false);

    unselected_left = GtkUtils.newButton(parser, "GtkNotebook",
        new String[]{"function", "state", "gap_side"},
        new String[]{"EXTENSION", "ACTIVE", "LEFT"}, false, true, false, false);
    selected_left = GtkUtils.newButton(parser, "GtkNotebook",
        new String[]{"function", "state", "gap_side"},
        new String[]{"EXTENSION", null, "LEFT"}, false, true, false, false);

    unselected_right = GtkUtils.newButton(parser, "GtkNotebook",
        new String[]{"function", "state", "gap_side"},
        new String[]{"EXTENSION", "ACTIVE", "RIGHT"}, false, true, false, false);
    selected_right = GtkUtils.newButton(parser, "GtkNotebook",
        new String[]{"function", "state", "gap_side"},
        new String[]{"EXTENSION", null, "RIGHT"}, false, true, false, false);

    if (unselected_bottom == null) {
      unselected_bottom = unselected_top.getTopToBottom();
    }

    if (selected_bottom == null) {
      selected_bottom = selected_top.getTopToBottom();
    }

    if (unselected_left == null) {
      unselected_left = unselected_top.rotateCounterClockWise();
    }

    if (selected_left == null) {
      selected_left = selected_top.rotateCounterClockWise();
    }

    if (unselected_right == null) {
      unselected_right = unselected_top.rotateClockWise();
    }

    if (selected_right == null) {
      selected_right = selected_top.rotateClockWise();
    }

    border = GtkUtils.newButton(parser, "GtkNotebook",
        new String[]{"function", "gap_side"},
        new String[]{"BOX_GAP", "TOP"}, false, true, false, true);
    if (border != null) {
      border.center = null;
    }
  }

  /**
   * Description of the Method
   *
   * @return   Description of the Returned Value
   */
  public boolean status() {
    return selected_top != null;
  }

  /**
   * Description of the Method
   *
   * @param c  Description of Parameter
   * @return   Description of the Returned Value
   */
  public boolean installSkin(JComponent c) {
    return true;
  }

  /**
   * Description of the Method
   *
   * @param g             Description of Parameter
   * @param tabPlacement  Description of Parameter
   * @param isSelected    Description of Parameter
   * @param x             Description of Parameter
   * @param y             Description of Parameter
   * @param w             Description of Parameter
   * @param h             Description of Parameter
   * @return              Description of the Returned Value
   */
  public boolean paintTab(java.awt.Graphics g, int tabPlacement, boolean isSelected, int x, int y, int w, int h) {
      
      if (isSelected) {

      //HACK: set the height smaller, so that the tab is placed exactly on the content border
      h -= 2;

      switch (tabPlacement) {
        case SwingConstants.TOP:
          selected_top.paint(g, x, y, w, h, ImageUtils.producer);
          break;
        case SwingConstants.BOTTOM:
          selected_bottom.paint(g, x, y, w, h, ImageUtils.producer);
          break;
        case SwingConstants.LEFT:
          selected_left.paint(g, x, y, w, h, ImageUtils.producer);
          break;
        case SwingConstants.RIGHT:
          selected_right.paint(g, x, y, w, h, ImageUtils.producer);
          break;
        default:
          selected_top.paint(g, x, y, w, h, ImageUtils.producer);
      }
    }
    else {
        
      // HACK: set the width greater, so that the unselected tabs are placed exactly side by side
      w += 1;
      
      switch (tabPlacement) {
        case SwingConstants.TOP:
          unselected_top.paint(g, x, y, w, h, ImageUtils.producer);
          break;
        case SwingConstants.BOTTOM:
          unselected_bottom.paint(g, x, y, w, h, ImageUtils.producer);
          break;
        case SwingConstants.LEFT:
          unselected_left.paint(g, x, y, w, h, ImageUtils.producer);
          break;
        case SwingConstants.RIGHT:
          unselected_right.paint(g, x, y, w, h, ImageUtils.producer);
          break;
        default:
          unselected_top.paint(g, x, y, w, h, ImageUtils.producer);
      }
    }
    return true;
  }

  /**
   * Description of the Method
   *
   * @param g              Description of Parameter
   * @param tabPlacement   Description of Parameter
   * @param selectedIndex  Description of Parameter
   * @param x              Description of Parameter
   * @param y              Description of Parameter
   * @param w              Description of Parameter
   * @param h              Description of Parameter
   * @return               Description of the Returned Value
   */
  public boolean paintContent(java.awt.Graphics g, int tabPlacement, int selectedIndex,
      int x, int y, int w, int h) {
    if (border != null) {
      border.paint(g, x, y, w, h, ImageUtils.producer);
      return true;
    }
    else {
      return false;
    }
  }
  
  public boolean paintGap(java.awt.Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
    if (border != null) {
      border.paintGap(g, x, y, w, ImageUtils.producer);
      return true;
    }
    else {
      return false;
    }
  }
}
