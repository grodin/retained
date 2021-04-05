package dev.marcellogalhardo.retained.core

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.CoroutineScope
import kotlin.reflect.KClass

/**
 * Representation of an retained object entry in a [androidx.lifecycle.LifecycleOwner] and hosted
 * in a [androidx.lifecycle.ViewModel].
 *
 * If the host is terminated (e.g., pop back stack) [onClearedListeners] will be called.
 */
interface RetainedEntry {

    /**
     * @see [androidx.lifecycle.AbstractSavedStateViewModelFactory.create]
     */
    val key: String

    /**
     * @see [androidx.lifecycle.AbstractSavedStateViewModelFactory.create]
     */
    val classRef: KClass<out Any>

    /**
     * @see [androidx.lifecycle.viewModelScope]
     */
    val scope: CoroutineScope

    /**
     * @see [androidx.lifecycle.AbstractSavedStateViewModelFactory]
     */
    val savedStateHandle: SavedStateHandle

    /**
     * @see [androidx.lifecycle.ViewModel.onCleared]
     */
    val onClearedListeners: MutableCollection<OnClearedListener>
}