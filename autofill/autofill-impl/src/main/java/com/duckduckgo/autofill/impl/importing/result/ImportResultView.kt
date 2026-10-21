/*
 * Copyright (c) 2026 DuckDuckGo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duckduckgo.autofill.impl.importing.result

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.view.isVisible
import com.duckduckgo.autofill.impl.databinding.ViewImportResultBinding
import com.duckduckgo.common.ui.viewbinding.viewBinding

class ImportResultView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : FrameLayout(context, attrs, defStyle) {

    private val binding: ViewImportResultBinding by viewBinding()

    fun setImportedText(text: CharSequence) {
        binding.importedRow.setPrimaryText(text)
    }

    fun setFailedText(text: CharSequence?) {
        binding.failedRow.isVisible = text != null
        text?.let { binding.failedRow.setPrimaryText(it) }
    }

    fun setOnDoneClickListener(listener: () -> Unit) {
        binding.doneButton.setOnClickListener { listener() }
    }
}
