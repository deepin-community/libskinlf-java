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

/**
 * @author    $Author: l2fprod $
 * @created   27 avril 2002
 * @version   $Revision: 1.3 $, $Date: 2003/12/06 21:48:36 $
 */
public final class GtkEngine {

  /**
   * Description of the Field
   */
  public GtkStyle style;

  java.util.Vector images = new java.util.Vector();

  /**
   * Gets the Images attribute of the GtkEngine object
   *
   * @return   The Images value
   */
  public java.util.Vector getImages() {
    return images;
  }

  /**
   * Adds a feature to the Image attribute of the GtkEngine object
   *
   * @param image  The feature to be added to the Image attribute
   */
  public void addImage(GtkImage image) {
    images.addElement(image);
    image.style = style;
  }

  /**
   * Description of the Method
   *
   * @param keys    Description of Parameter
   * @param values  Description of Parameter
   * @return        Description of the Returned Value
   */
  public GtkImage findImage(Object[] keys, Object[] values) {
    return findImage(keys, values, false);
  }

  /**
   * Description of the Method
   *
   * @param keys        Description of Parameter
   * @param values      Description of Parameter
   * @param exactMatch  Description of Parameter
   * @return            Description of the Returned Value
   */
  public GtkImage findImage(Object[] keys, Object[] values, boolean exactMatch) {
    GtkImage image = null;
    int imageMatchKeys = 0;

    for (int i = 0, c = images.size(); i < c; i++) {
      GtkImage currentImage = (GtkImage) images.elementAt(i);
      int j = 0;

      while ((j < keys.length) &&
          ((values[j] == null && currentImage.getProperty(keys[j]) == null) ||
          (values[j] != null) && values[j].equals(currentImage.getProperty(keys[j])))) {
        j++;
      }

      if (j == keys.length) {
        image = currentImage;
        imageMatchKeys = j;
        break;
      }
      else if (j>0 && j>= imageMatchKeys) {
        image = currentImage;
        imageMatchKeys = j;
      }
    }

    if (exactMatch) {
      if (imageMatchKeys < keys.length) {
        return null;
      } else {
        return image;
      }
    } else {
      return image;
    }
  }

}
