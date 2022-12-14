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
 * @version   $Revision: 1.2 $, $Date: 2003/12/06 21:47:23 $
 */
public final class SkinSliderUI extends BasicSliderUI {

  private Skin skin = SkinLookAndFeel.getSkin();

  /**
   * Constructor for the SkinSliderUI object
   *
   * @param b  Description of Parameter
   */
  public SkinSliderUI(JSlider b) {
    super(b);
  }

  public Dimension getPreferredHorizontalSize() {
    return skin.getSlider().getPreferredSize(slider, super.getPreferredHorizontalSize());
  }
  
  public Dimension getPreferredVerticalSize() {
    return skin.getSlider().getPreferredSize(slider, super.getPreferredVerticalSize());
  }
  
  public Dimension getMinimumHorizontalSize() {
    return skin.getSlider().getPreferredSize(slider, super.getMinimumHorizontalSize());
  }
  
  public Dimension getMinimumVerticalSize() {
    return skin.getSlider().getPreferredSize(slider, super.getMinimumVerticalSize());
  }

  /**
   * Description of the Method
   *
   * @param g  Description of Parameter
   */
  public void paintTrack(Graphics g) {
    Rectangle trackBounds = trackRect;

    int cx;

    int cy;
    if (slider.getOrientation() == SwingConstants.HORIZONTAL) {
      cy = (trackBounds.height / 2) - 2;
      g.translate(trackBounds.x, trackBounds.y + cy);
      skin.getSlider().paintTrack(g, slider, trackBounds);
      g.translate(-trackBounds.x, -(trackBounds.y + cy));
    }
    else {
      cx = (trackBounds.width / 2) - 2;
      g.translate(trackBounds.x + cx, trackBounds.y);
      skin.getSlider().paintTrack(g, slider, trackBounds);
      g.translate(-(trackBounds.x + cx), -trackBounds.y);
    }
  }

  /**
   * Description of the Method
   *
   * @param g  Description of Parameter
   */
  public void paintThumb(Graphics g) {
    Rectangle knobBounds = thumbRect;

    g.translate(knobBounds.x, knobBounds.y);

    skin.getSlider().paintThumb(g, slider, knobBounds);

    g.translate(-knobBounds.x, -knobBounds.y);
  }

  /**
   * Description of the Method
   *
   * @param b  Description of Parameter
   */
  protected void installDefaults(JSlider b) {
    super.installDefaults(b);
    skin.getSlider().installSkin(b);
  }

  protected Dimension getThumbSize() {
    Dimension dim = skin.getSlider().getThumbSize(slider);
    return dim==null?super.getThumbSize():dim;
  }

  /**
   * Description of the Method
   *
   * @param x  Description of Parameter
   * @return   Description of the Returned Value
   */
  public static ComponentUI createUI(JComponent x) {
    return new SkinSliderUI((JSlider) x);
  }

}
