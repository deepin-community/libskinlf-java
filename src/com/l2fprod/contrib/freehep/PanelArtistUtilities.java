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
package com.l2fprod.contrib.freehep;
// was originally org.freehep.swing.graphics;

import java.awt.geom.AffineTransform;

/**
 * This class is a collection of static methods which are useful for
 * implementations of the PanelArtist interface. Most methods return an
 * AffineTransform which will perform some common operation on a window.
 *
 * @author    Charles Loomis
 * @created   27 avril 2002
 * @version   $Id: PanelArtistUtilities.java,v 1.1 2001/11/04 11:10:27 l2fprod
 *      Exp $
 */
public class PanelArtistUtilities {

  /**
   * This returns an affine transform which will flip the vertical axis around.
   * (NOTE: that this transform should be pre-concatenated with the existing
   * one!) The returned transform will maintain the centerpoint of the window
   * and flip the direction of the y-axis.
   *
   * @param height  Description of Parameter
   * @return        The YFlipTransform value
   */
  public static AffineTransform getYFlipTransform(int height) {
    return new AffineTransform(1., 0., 0., -1., 0., height);
  }

  /**
   * This returns an affine transform which will rotate the contents of the
   * window by 90 degrees. (NOTE: that this transform should be pre-concatenated
   * with the existing one!) The returned transform will rotate the contents of
   * the window by 90 degrees while keeping the centerpoint the same. The x and
   * y-scaling will be adjusted to keep the same area visible.
   *
   * @param width   Description of Parameter
   * @param height  Description of Parameter
   * @return        The CCWRotateTransform value
   */
  public static AffineTransform
      getCCWRotateTransform(int width, int height) {

    return new AffineTransform(0.,
        -((double) height) / width,
        ((double) width) / height,
        0.,
        0.,
        height);
  }

  /**
   * This returns an affine transform which will rotate the contents of the
   * window by -90 degrees. (NOTE: that this transform should be
   * pre-concatenated with the existing one!) The returned transform will rotate
   * the contents of the window by -90 degrees while keeping the centerpoint the
   * same. The x and y-scaling will be adjusted to keep the same area visible.
   *
   * @param width   Description of Parameter
   * @param height  Description of Parameter
   * @return        The CWRotateTransform value
   */
  public static AffineTransform
      getCWRotateTransform(int width, int height) {

    return new AffineTransform(0.,
        ((double) height) / width,
        -((double) width) / height,
        0.,
        (double) width,
        0.);
  }

}
