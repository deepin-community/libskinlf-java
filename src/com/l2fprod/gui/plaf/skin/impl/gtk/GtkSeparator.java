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
import com.l2fprod.gui.plaf.skin.impl.AbstractSkinSeparator;
import com.l2fprod.gui.plaf.skin.impl.gtk.parser.GtkParser;

/**
 * Skin Separator. <br>
 *
 *
 * @author    $Author: l2fprod $
 * @created   27 avril 2002
 * @version   $Revision: 1.2 $, $Date: 2003/12/06 21:50:13 $
 */
final class GtkSeparator extends AbstractSkinSeparator {

  DefaultButton hline;
  DefaultButton vline;

  public GtkSeparator(GtkParser parser) throws Exception{
    hline = GtkUtils.newButton(parser, "default",
                               new String[]{"function"},
                               new String[]{"HLINE"});
    vline = GtkUtils.newButton(parser, "default",
                               new String[]{"function"},
                               new String[]{"VLINE"});
  }

  public boolean status() {
    return (hline != null) && (vline != null);
  }

  public boolean paint(java.awt.Graphics g, javax.swing.JSeparator separator) {
    if (javax.swing.JSeparator.HORIZONTAL == separator.getOrientation()) {
      hline.paint(g, separator);
    } else {
      vline.paint(g, separator);
    }
    return true;
  }

  public java.awt.Dimension getPreferredSize(javax.swing.JSeparator separator,
                                             java.awt.Dimension uiPreferredSize) {
    if (javax.swing.JSeparator.HORIZONTAL == separator.getOrientation()) {
      uiPreferredSize.height = hline.getHeight();
    } else {
      uiPreferredSize.width = vline.getWidth();
    }
    return uiPreferredSize;
  }

}
