/*
 * This Work is in the public domain and is provided on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * including, without limitation, any warranties or conditions of TITLE,
 * NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE.
 * You are solely responsible for determining the appropriateness of using
 * this Work and assume any risks associated with your use of this Work.
 *
 * This Work includes contributions authored by David E. Jones, not as a
 * "work for hire", who hereby disclaims any copyright to the same.
 */
package org.moqui.context;

import java.nio.charset.Charset;

/** For rendering screens for general use (mostly for things other than web pages or web page snippets). */
public interface ScreenFacade {
    /** Render a screen to an appender using the current context. The screen will run in a sub-context so the original
     * context will not be changed.
     *
     * @param screenLocation Location of the XML Screen file to render.
     * @param appender Textual output of the rendering will be appended to this.
     * @param outputType The type of output. Used to select sub-elements of the <code>platform-specific</code> element.
     *                   If macroTemplateLocation is not specified is also used to determine the default macro template
     *                   based on configuration. Can be anything. Default supported values include: text, html, xsl-fo,
     *                   xml, and csv.
     * @param characterEncoding The MIME character encoding for the text produced. Defaults to <code>UTF-8</code>. Must
     *                          be a valid charset in the java.nio.charset.Charset class.
     * @param macroTemplateLocation Location of an FTL file with macros used to generate output. If not specified macro
     *                              file from the screen configuration will be used depending on the outputType.
     */
    void renderScreenText(String screenLocation, Appendable appender, String outputType, String characterEncoding,
                          String macroTemplateLocation);
}