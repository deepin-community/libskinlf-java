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

/**
 * Thrown when a Theme Pack requires a SkinLF version greater than the current.
 * <br>
 *
 *
 * @author    $Author: l2fprod $
 * @created   27 avril 2002
 * @version   $Revision: 1.4 $, $Date: 2005/11/19 09:25:05 $
 */
public final class IncorrectVersionException extends Exception {

  /**
   * Constructor for the IncorrectVersionException object
   *
   * @param required  Description of Parameter
   * @param current   Description of Parameter
   */
  public IncorrectVersionException(String required, String current) {
    super("Incorrect Skin Look And Feel version, " +
        "current version is " + current + ", required version is " + required);
  }

  /**
   * Check if the current version is bigger or equals to the required
   * version. If this is not the case an
   * <code>IncorrectVersionException</code> is thrown.
   * 
   * @param current Description of Parameter
   * @param required Description of Parameter
   * @exception IncorrectVersionException if the current version does not fit
   */
  public static void checkRequiredVersion(String current, String required)
    throws IncorrectVersionException {
    if ("6.7".equals(current)) {
      return;
    }
    
    java.util.StringTokenizer currentToken =
      new java.util.StringTokenizer(current, ".");
    java.util.StringTokenizer requiredToken =
      new java.util.StringTokenizer(required, ".");

    int currentCount = currentToken.countTokens();
    int requiredCount = requiredToken.countTokens();

    int min = Math.min(currentCount, requiredCount);

    for (int i = 0; i < min; i++) {
      String cTok = currentToken.nextToken();
      String rTok = requiredToken.nextToken();
      
      int cValue = Integer.parseInt(cTok);
      int rValue = Integer.parseInt(rTok);
      
      // the current version is bigger than the required
      if (cValue > rValue) {
        break;
      }
      if (cValue < rValue) {
        throw new IncorrectVersionException(required, current);
      }
      if ((i == min - 1) && (currentCount < requiredCount)) {
        throw new IncorrectVersionException(required, current);
      }
    }

  }
  
}
