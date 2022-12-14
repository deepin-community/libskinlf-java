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

import com.l2fprod.gui.icon.ArrowIcon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.CellRendererPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 * @author    $Author: l2fprod $
 * @version   $Revision: 1.5 $, $Date: 2005/12/04 15:34:37 $
 */
public final class SkinComboBoxUI extends BasicComboBoxUI {

  private Skin skin = SkinLookAndFeel.getSkin();

  private boolean rollover = false;

  private MouseListener rolloverListener;

  public SkinComboBoxUI() {
    // Install a new renderer for the selected value which will work with
    // both Java 1.4 and 1.5.
    currentValuePane = new CellRendererPane() {
      public void paintComponent(
          Graphics g,
          Component c,
          Container p,
          int x,
          int y,
          int w,
          int h,
          boolean shouldValidate) {
        JComponent jc = (JComponent) c;
        jc.setOpaque(false);
        super.paintComponent(g, c, p, x, y, w, h, shouldValidate);
        // This is a bit hacky, but restoring this property to it's previous
        // value does NOT work on J2SE 1.5.0_05 somehow.
        jc.setOpaque(true);
      }
    };
  }

  /**
   * Gets the PreferredSize attribute of the SkinComboBoxUI object
   *
   * @param c  Description of Parameter
   * @return   The PreferredSize value
   */
  public Dimension getPreferredSize(JComponent c) {
    Dimension prefs = super.getMinimumSize(c);
    Dimension combo = skin.getPersonality().getComboBoxPreferredSize(comboBox);
    prefs.width = Math.max(prefs.width, combo.width);
    prefs.height = Math.max(prefs.height, combo.height);
    return prefs;
  }

  /**
   * Gets the MinimumSize attribute of the SkinComboBoxUI object
   *
   * @param c  Description of Parameter
   * @return   The MinimumSize value
   */
  public Dimension getMinimumSize(JComponent c) {
    return getPreferredSize(c);
  }

  protected void installListeners() {
    super.installListeners();
    rolloverListener = createRolloverListener();
    comboBox.addMouseListener(rolloverListener);
  }

  protected void uninstallListeners() {
    super.uninstallListeners();
    comboBox.removeMouseListener(rolloverListener);
    rolloverListener = null;
  }

  protected MouseListener createRolloverListener() {
    return new RolloverMouseListener();
  }

  public class RolloverMouseListener extends MouseAdapter {
    public void mouseEntered(MouseEvent event) {
      rollover = true;
      comboBox.repaint();
    }
    public void mouseExited(MouseEvent event) {
      rollover = false;
      comboBox.repaint();
    }
  }

  /**
   * Description of the Method
   *
   * @param g  Description of Parameter
   * @param c  Description of Parameter
   */
  public void paint(Graphics g, JComponent c) {
    hasFocus = comboBox.hasFocus();
    Rectangle r = rectangleForCurrentValue();
    skin.getPersonality().paintComboBox(g, comboBox, r, hasFocus, rollover);
    if (!comboBox.isEditable() || editor == null || !editor.isVisible()) {
      paintCurrentValue(g, r, false);
    }
  }
  
  /**
   * Gets the Insets attribute of the SkinComboBoxUI object
   *
   * @return   The Insets value
   */
  protected Insets getInsets() {
    return skin.getPersonality().getComboBoxInsets();
  }

  /**
   * Description of the Method
   *
   * @return   Description of the Returned Value
   */
  protected JButton createArrowButton() {
    JButton button = new JButton(new ArrowIcon(ArrowIcon.SOUTH));
    return button;
  }

  /**
   * Description of the Method
   */
  protected void installComponents() {
    super.installComponents();
    arrowButton.setVisible(false);
  }

  protected void configureEditor() {
    super.configureEditor();
    editor.addMouseListener(rolloverListener);

    if (comboBox.getEditor() != null &&
        comboBox.getEditor() instanceof UIResource &&
        editor instanceof JComponent) {
      ((JComponent)editor).setOpaque(false);
    }
  }

  protected void unconfigureEditor() {
    super.unconfigureEditor();
    editor.removeMouseListener(rolloverListener);
  }

  /**
   * Description of the Method
   *
   * @return   Description of the Returned Value
   */
  protected Rectangle rectangleForCurrentValue() {
    int width = comboBox.getWidth();
    int height = comboBox.getHeight();
    Insets insets = getInsets();
    return new Rectangle(insets.left, insets.top,
                         width - (insets.left + insets.right),
                         height - (insets.top + insets.bottom));
  }

  /**
   * Description of the Method
   *
   * @return   Description of the Returned Value
   */
  protected LayoutManager createLayoutManager() {
    return new SkinComboBoxLayoutManager();
  }

  protected JComboBox comboBox() {
    return comboBox;
  }

  /**
   * Description of the Method
   */
  protected void installKeyboardActions() {
    super.installKeyboardActions();

    ActionListener downAction =
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (comboBox().isEnabled()) {
            if (isPopupVisible()) {
              selectNextPossibleValue();
            }
            else {
              setPopupVisible(comboBox(), true);
            }
          }
        }
      };

    comboBox.registerKeyboardAction(downAction,
        KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0),
        JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    comboBox.registerKeyboardAction(downAction,
        KeyStroke.getKeyStroke("KP_DOWN"),
        JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    ActionListener altAction =
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (comboBox().isEnabled() && isPopupVisible()) {
            togglePopup();
          }
        }
      };

    comboBox.registerKeyboardAction(altAction,
        KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.ALT_MASK),
        JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    comboBox.registerKeyboardAction(altAction,
        KeyStroke.getKeyStroke("alt KP_DOWN"),
        JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    comboBox.registerKeyboardAction(altAction,
        KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.ALT_MASK),
        JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    comboBox.registerKeyboardAction(altAction,
        KeyStroke.getKeyStroke("alt KP_UP"),
        JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    ActionListener upAction =
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (comboBox().isEnabled() && isPopupVisible()) {
            selectPreviousPossibleValue();
          }
        }
      };

    comboBox.registerKeyboardAction(upAction,
        KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0),
        JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    comboBox.registerKeyboardAction(upAction,
        KeyStroke.getKeyStroke("KP_UP"),
        JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
  }

  /**
   * Description of the Method
   */
  protected void uninstallKeyboardActions() {
    super.uninstallKeyboardActions();
    comboBox.unregisterKeyboardAction(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0));
    comboBox.unregisterKeyboardAction(KeyStroke.getKeyStroke("KP_DOWN"));

    comboBox.unregisterKeyboardAction(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.ALT_MASK));
    comboBox.unregisterKeyboardAction(KeyStroke.getKeyStroke("alt KP_DOWN"));

    comboBox.unregisterKeyboardAction(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0));
    comboBox.unregisterKeyboardAction(KeyStroke.getKeyStroke("KP_UP"));

    comboBox.unregisterKeyboardAction(KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.ALT_MASK));
    comboBox.unregisterKeyboardAction(KeyStroke.getKeyStroke("alt KP_UP"));
  }

  /**
   * Description of the Method
   *
   * @return   Description of the Returned Value
   */
  protected Component editor() {
    return editor;
  }

  /**
   * Gets the PopupVisible attribute of the SkinComboBoxUI object
   *
   * @return   The PopupVisible value
   */
  boolean isPopupVisible() {
    return super.isPopupVisible(comboBox);
  }

  /**
   * Description of the Method
   */
  void togglePopup() {
    toggleOpenClose();
  }

  /**
   * Description of the Method
   *
   * @param c  Description of Parameter
   * @return   Description of the Returned Value
   */
  public static ComponentUI createUI(JComponent c) {
    return new SkinComboBoxUI();
  }

  public PropertyChangeListener createPropertyChangeListener() {
    return new SkinPropertyChangeListener();
  }

  /**
   * This inner class is marked &quot;public&quot; due to a compiler bug. This
   * class should be treated as a &quot;protected&quot; inner class. Instantiate
   * it only within subclasses of <FooUI>.
   */
  public class SkinPropertyChangeListener extends
    BasicComboBoxUI.PropertyChangeHandler {
    public void propertyChange(PropertyChangeEvent e) {
      super.propertyChange(e);
      String propertyName = e.getPropertyName();

      if (propertyName.equals("background")) {
        Color color = (Color)e.getNewValue();
        arrowButton.setBackground(color);
        listBox.setBackground(color);

      } else if (propertyName.equals("foreground")) {
        Color color = (Color)e.getNewValue();
        arrowButton.setForeground(color);
        listBox.setForeground(color);
      }
    }
  }

  /**
   * Description of the Class
   * 
   * @author fred
   */
  public class SkinComboBoxLayoutManager implements LayoutManager {
    /**
     * Adds a feature to the LayoutComponent attribute of the
     * SkinComboBoxLayoutManager object
     *
     * @param name  The feature to be added to the LayoutComponent attribute
     * @param comp  The feature to be added to the LayoutComponent attribute
     */
    public void addLayoutComponent(String name, Component comp) {
    }

    /**
     * Description of the Method
     *
     * @param comp  Description of Parameter
     */
    public void removeLayoutComponent(Component comp) {
    }

    /**
     * Description of the Method
     *
     * @param parent  Description of Parameter
     * @return        Description of the Returned Value
     */
    public Dimension preferredLayoutSize(Container parent) {
      return parent.getPreferredSize();
    }

    /**
     * Description of the Method
     *
     * @param parent  Description of Parameter
     * @return        Description of the Returned Value
     */
    public Dimension minimumLayoutSize(Container parent) {
      return parent.getMinimumSize();
    }

    /**
     * Description of the Method
     *
     * @param parent  Description of Parameter
     */
    public void layoutContainer(Container parent) {
      Rectangle cvb;
      if (SkinComboBoxUI.this.editor() != null) {
        cvb = rectangleForCurrentValue();
        SkinComboBoxUI.this.editor().setBounds(cvb);
      }
    }
  }

}
