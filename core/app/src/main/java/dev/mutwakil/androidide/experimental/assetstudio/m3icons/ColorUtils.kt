/*
 *  This file is part of AndroidCodeStudio.
 *
 *  AndroidCodeStudio is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidCodeStudio is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidCodeStudio.  If not, see <https://www.gnu.org/licenses/>.
*/

package dev.mutwakil.androidide.experimental.assetstudio.m3icons

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import dev.mutwakil.androidide.R

/**
 * @author Mohammed-baqer-null @ https://github.com/Mohammed-baqer-null
 */

object ColorUtils {
    fun extractColorFromXml(xmlContent: String): Int {
        return try {
            val parser = android.util.Xml.newPullParser()
            parser.setInput(xmlContent.byteInputStream(), "UTF-8")

            var eventType = parser.eventType
            while (eventType != org.xmlpull.v1.XmlPullParser.END_DOCUMENT) {
                if (eventType == org.xmlpull.v1.XmlPullParser.START_TAG && parser.name == "vector") {
                    for (i in 0 until parser.attributeCount) {
                        if (parser.getAttributeName(i) == "tint") {
                            return parseColor(parser.getAttributeValue(i))
                        }
                    }
                }
                eventType = parser.next()
            }
            Color.BLACK
        } catch (e: Exception) {
            Color.BLACK
        }
    }

    fun parseColor(colorString: String, context: Context? = null): Int {
        return try {
            when {
                colorString.startsWith("#") -> Color.parseColor(colorString)
                colorString.startsWith("?attr/") && context != null -> {
                    resolveDynamicColor(colorString, context)
                }
                colorString.startsWith("@") -> Color.BLACK
                else -> Color.parseColor("#$colorString")
            }
        } catch (e: Exception) {
            Color.BLACK
        }
    }

    private fun resolveDynamicColor(colorString: String, context: Context): Int {
        val dynamicColors = DynamicColorHelper.getDynamicColors()
        val match = dynamicColors.find { it.first == colorString }
        
        return if (match?.second != null) {
            val typedValue = TypedValue()
            context.theme.resolveAttribute(match.second!!, typedValue, true)
            if (typedValue.type >= TypedValue.TYPE_FIRST_COLOR_INT &&
                typedValue.type <= TypedValue.TYPE_LAST_COLOR_INT) {
                typedValue.data
            } else {
                Color.BLACK
            }
        } else {
            Color.BLACK
        }
    }

    fun modifyXmlColor(xmlContent: String, color: Int?, dynamicColor: String?): String {
        val colorValue = dynamicColor ?: String.format("#%08X", color ?: Color.BLACK)
        
        return if (xmlContent.contains("android:tint=")) {
            xmlContent.replace(Regex("""android:tint="[^"]*""""), """android:tint="$colorValue"""")
        } else {
            xmlContent.replace(
                Regex("""(<vector[^>]*)(>)"""),
                """$1 android:tint="$colorValue"$2"""
            )
        }
    }
}