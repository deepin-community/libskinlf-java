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

import javax.swing.UIDefaults;

/**
 * Skin Entry Class. <br>
 *
 *
 * @author    $Author: l2fprod $
 * @created   27 avril 2002
 * @version   $Revision: 1.1 $, $Date: 2003/08/01 20:09:07 $
 */
public interface Skin {

  /**
   * Gets the Personality attribute of the Skin object
   *
   * @return   The Personality value
   */
  public SkinPersonality getPersonality();

  /**
   * Gets the Button attribute of the Skin object
   *
   * @return   The Button value
   */
  public SkinButton getButton();

  /**
   * Gets the Frame attribute of the Skin object
   *
   * @return   The Frame value
   */
  public SkinFrame getFrame();

  /**
   * Gets the Tab attribute of the Skin object
   *
   * @return   The Tab value
   */
  public SkinTab getTab();

  /**
   * Gets the Progress attribute of the Skin object
   *
   * @return   The Progress value
   */
  public SkinProgress getProgress();

  /**
   * Gets the Colors attribute of the Skin object
   *
   * @return   The Colors value
   */
  public String[] getColors();

  /**
   * Gets the Scrollbar attribute of the Skin object
   *
   * @return   The Scrollbar value
   */
  public SkinScrollbar getScrollbar();

  /**
   * Gets the SplitPane attribute of the Skin object
   *
   * @return   The SplitPane value
   */
  public SkinSplitPane getSplitPane();

  /**
   * Gets the Slider attribute of the Skin object
   *
   * @return   The Slider value
   */
  public SkinSlider getSlider();

  /**
   * Gets the Separator attribute of the Skin object
   *
   * @return   The Separator value
   */
  public SkinSeparator getSeparator();

  /**
   * Description of the Method
   */
  public void unload();

  /**
   * Gets the Resource attribute of the Skin object
   *
   * @param key  Description of Parameter
   * @return     The Resource value
   */
  public Object getResource(Object key);

  public void initComponentDefaults(UIDefaults table);
}
