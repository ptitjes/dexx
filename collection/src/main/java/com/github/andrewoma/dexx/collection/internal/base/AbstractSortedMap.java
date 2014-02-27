/*
 * Copyright (c) 2014 Andrew O'Malley
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.andrewoma.dexx.collection.internal.base;


import com.github.andrewoma.dexx.collection.SortedMap;
import com.github.andrewoma.dexx.collection.internal.adapter.SortedMapAdapter;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractSortedMap<K, V> extends AbstractMap<K, V> implements SortedMap<K, V> {
    @NotNull
    @Override
    public SortedMap<K, V> from(@NotNull K key, boolean inclusive) {
        if (isEmpty()) return this;
        //noinspection ConstantConditions
        return range(key, inclusive, last().component1(), true);
    }

    @NotNull
    @Override
    public SortedMap<K, V> to(@NotNull K key, boolean inclusive) {
        if (isEmpty()) return this;
        //noinspection ConstantConditions
        return range(first().component1(), true, key, inclusive);
    }

    @NotNull
    @Override
    public java.util.SortedMap<K, V> asSortedMap() {
        return new SortedMapAdapter<K, V>(this);
    }
}