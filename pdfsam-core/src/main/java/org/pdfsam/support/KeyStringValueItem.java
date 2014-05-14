/* 
 * This file is part of the PDF Split And Merge source code
 * Created on 13/apr/2012
 * Copyright 2012 by Andrea Vacondio (andrea.vacondio@gmail.com).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as 
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pdfsam.support;

import static org.pdfsam.support.RequireUtils.require;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Contains a pair of Strings, usually a key and a display value. Two items with the same key are considered equals.
 * 
 * @author Andrea Vacondio
 * @param <K>
 *            type for the key
 */
public class KeyStringValueItem<K> implements KeyValueItem<K, String> {

    private K key;
    private String value;

    public KeyStringValueItem(K key, String value) {
        require(key != null, "Key cannot be null");
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(key).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyStringValueItem)) {
            return false;
        }
        KeyStringValueItem<?> item = (KeyStringValueItem<?>) other;
        return new EqualsBuilder().append(key, item.getKey()).isEquals();
    }

}