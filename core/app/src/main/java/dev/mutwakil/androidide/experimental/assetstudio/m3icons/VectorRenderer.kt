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
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.core.graphics.PathParser
import dev.mutwakil.androidide.R

/**
 * @author Mohammed-baqer-null @ https://github.com/Mohammed-baqer-null
 */

object VectorRenderer {
    fun createBitmapFromXml(
        xmlContent: String,
        size: Int,
        overrideColor: Int? = null,
        context: Context? = null
    ): Bitmap? {
        return try {
            val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)

            val parser = android.util.Xml.newPullParser()
            parser.setInput(xmlContent.byteInputStream(), "UTF-8")

            var viewportWidth = 24f
            var viewportHeight = 24f
            var tintColor: Int? = null
            val paths = mutableListOf<VectorPath>()

            var eventType = parser.eventType
            while (eventType != org.xmlpull.v1.XmlPullParser.END_DOCUMENT) {
                when (eventType) {
                    org.xmlpull.v1.XmlPullParser.START_TAG -> {
                        when (parser.name) {
                            "vector" -> {
                                for (i in 0 until parser.attributeCount) {
                                    when (parser.getAttributeName(i)) {
                                        "viewportWidth" ->
                                            viewportWidth = parser.getAttributeValue(i).toFloatOrNull() ?: 24f
                                        "viewportHeight" ->
                                            viewportHeight = parser.getAttributeValue(i).toFloatOrNull() ?: 24f
                                        "tint" ->
                                            tintColor = ColorUtils.parseColor(parser.getAttributeValue(i), context)
                                    }
                                }
                            }
                            "path" -> {
                                var pathData = ""
                                var fillColor = Color.BLACK
                                var strokeColor = Color.TRANSPARENT
                                var strokeWidth = 0f

                                for (i in 0 until parser.attributeCount) {
                                    when (parser.getAttributeName(i)) {
                                        "pathData" -> pathData = parser.getAttributeValue(i)
                                        "fillColor" ->
                                            fillColor = ColorUtils.parseColor(parser.getAttributeValue(i), context)
                                        "strokeColor" ->
                                            strokeColor = ColorUtils.parseColor(parser.getAttributeValue(i), context)
                                        "strokeWidth" ->
                                            strokeWidth = parser.getAttributeValue(i).toFloatOrNull() ?: 0f
                                    }
                                }

                                if (pathData.isNotEmpty()) {
                                    paths.add(
                                        VectorPath(
                                            pathData,
                                            fillColor,
                                            strokeColor,
                                            strokeWidth
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
                eventType = parser.next()
            }

            canvas.drawColor(Color.TRANSPARENT)

            val scaleX = size.toFloat() / viewportWidth
            val scaleY = size.toFloat() / viewportHeight
            val scale = minOf(scaleX, scaleY)

            canvas.save()
            canvas.scale(scale, scale)
            canvas.translate(
                (size / scale - viewportWidth) / 2f,
                (size / scale - viewportHeight) / 2f
            )

            val finalTint = overrideColor ?: tintColor

            paths.forEach { vectorPath ->
                try {
                    val path = android.graphics.Path()
                    val pathParser = PathParser.createPathFromPathData(vectorPath.pathData)
                    path.set(pathParser)

                    val fillColorToUse = if (finalTint != null) finalTint else vectorPath.fillColor

                    if (fillColorToUse != Color.TRANSPARENT) {
                        val fillPaint = Paint().apply {
                            color = fillColorToUse
                            style = Paint.Style.FILL
                            isAntiAlias = true
                        }
                        canvas.drawPath(path, fillPaint)
                    }

                    if (vectorPath.strokeColor != Color.TRANSPARENT && vectorPath.strokeWidth > 0) {
                        val strokePaint = Paint().apply {
                            color = vectorPath.strokeColor
                            style = Paint.Style.STROKE
                            strokeWidth = vectorPath.strokeWidth
                            isAntiAlias = true
                        }
                        canvas.drawPath(path, strokePaint)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            canvas.restore()
            bitmap
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private data class VectorPath(
        val pathData: String,
        val fillColor: Int,
        val strokeColor: Int,
        val strokeWidth: Float
    )
}