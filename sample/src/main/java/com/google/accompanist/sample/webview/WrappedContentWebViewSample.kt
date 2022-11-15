/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.accompanist.sample.webview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

class WrappedContentWebViewSample : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    val sheetState = rememberModalBottomSheetState(
                        initialValue = ModalBottomSheetValue.Hidden
                    )
                    ModalBottomSheetLayout(
                        sheetState = sheetState,
                        sheetContent = {
                            WebContent()
                        }
                    ) {
                        val scope = rememberCoroutineScope()
                        Box(Modifier.fillMaxSize()) {
                            Button(onClick = {
                                scope.launch { sheetState.show() }
                            }, Modifier.align(Alignment.Center)) {
                                Text("Open Sheet")
                            }
                        }
                    }
                }
            }
        }
    }
}

/***
 * A sample WebView that is wrapping it's content inside of a bottom sheet.
 * The sheet should be the size of the rendered content and not unbounded.
 */
@Composable
fun WebContent() {
//    val webViewState = rememberWebViewStateWithHTMLData(
//        data = "<html><head>\n" +
//            "<style>\n" +
//            "body {\n" +
//            "  background-color: #f00;\n" +
//            "}\n" +
//            "</style>\n" +
//            "</head><body><p>Hello</p></body></html>"
//    )
//    WebView(
//        state = webViewState,
//        modifier = Modifier.fillMaxWidth()
//            .wrapContentHeight()
//            .heightIn(min = 1.dp) // A bottom sheet can't support content with 0 height.
//    )
}
