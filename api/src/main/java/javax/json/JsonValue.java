/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2011-2017 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package javax.json;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/**
 * <code>JsonValue</code> represents an immutable JSON value.
 *
 * 
 * <p>A JSON value is one of the following:
 * an object ({@link JsonObject}), an array ({@link JsonArray}),
 * a number ({@link JsonNumber}), a string ({@link JsonString}),
 * {@code true} ({@link JsonValue#TRUE JsonValue.TRUE}), {@code false} 
 * ({@link JsonValue#FALSE JsonValue.FALSE}),
 * or {@code null} ({@link JsonValue#NULL JsonValue.NULL}).
 */
public interface JsonValue {

    /**
     * The empty (immutable) JSON object.
     * 
     * @since 1.1
     */
    static final JsonObject EMPTY_JSON_OBJECT = new JsonObject() {
        private final Map<String, JsonValue> delegate = Collections.emptyMap();
        @Override
        public Collection<JsonValue> values() {
            return delegate.values();
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public JsonValue remove(Object arg0) {
            return delegate.remove(arg0);
        }

        @Override
        public void putAll(Map<? extends String, ? extends JsonValue> arg0) {
            delegate.putAll(arg0);
        }

        @Override
        public JsonValue put(String arg0, JsonValue arg1) {
            return delegate.put(arg0, arg1);
        }

        @Override
        public Set<String> keySet() {
            return delegate.keySet();
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public JsonValue get(Object arg0) {
            return delegate.get(arg0);
        }

        @Override
        public Set<Entry<String, JsonValue>> entrySet() {
            return delegate.entrySet();
        }

        @Override
        public boolean containsValue(Object arg0) {
            return delegate.containsValue(arg0);
        }

        @Override
        public boolean containsKey(Object arg0) {
            return delegate.containsKey(arg0);
        }

        @Override
        public void clear() { }

        @Override
        public ValueType getValueType() {
            return ValueType.NULL;
        }

        @Override
        public boolean isNull(String arg0) {
            return true;
        }

        @Override
        public String getString(String arg0, String arg1) {
            return null;
        }

        @Override
        public String getString(String arg0) {
            return null;
        }

        @Override
        public JsonString getJsonString(String arg0) {
            return null;
        }

        @Override
        public JsonObject getJsonObject(String arg0) {
            return null;
        }

        @Override
        public JsonNumber getJsonNumber(String arg0) {
            return null;
        }

        @Override
        public JsonArray getJsonArray(String arg0) {
            return null;
        }

        @Override
        public int getInt(String arg0, int arg1) {
            return 0;
        }

        @Override
        public int getInt(String arg0) {
            return 0;
        }

        @Override
        public boolean getBoolean(String arg0, boolean arg1) {
            return false;
        }

        @Override
        public boolean getBoolean(String arg0) {
            return false;
        }
    };

    /**
     * The empty (immutable) JSON array.
     * 
     * @since 1.1
     */
    static final JsonArray EMPTY_JSON_ARRAY = new JsonArray() {
        private final List<JsonValue> delegate = Collections.emptyList();
        @Override
        public <T> T[] toArray(T[] a) {
            return delegate.toArray(a);
        }

        @Override
        public Object[] toArray() {
            return delegate.toArray();
        }

        @Override
        public List<JsonValue> subList(int fromIndex, int toIndex) {
            return delegate.subList(fromIndex, toIndex);
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public JsonValue set(int index, JsonValue element) {
            return delegate.set(index, element);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return delegate.retainAll(c);
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return delegate.removeAll(c);
        }

        @Override
        public JsonValue remove(int index) {
            return delegate.remove(index);
        }

        @Override
        public boolean remove(Object o) {
            return delegate.remove(o);
        }

        @Override
        public ListIterator<JsonValue> listIterator(int index) {
            return Collections.emptyListIterator();
        }

        @Override
        public ListIterator<JsonValue> listIterator() {
            return Collections.emptyListIterator();
        }

        @Override
        public int lastIndexOf(Object o) {
            return delegate.lastIndexOf(o);
        }

        @Override
        public Iterator<JsonValue> iterator() {
            return Collections.emptyIterator();
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public int indexOf(Object o) {
            return delegate.indexOf(o);
        }

        @Override
        public JsonValue get(int index) {
            return delegate.get(index);
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return delegate.containsAll(c);
        }

        @Override
        public boolean contains(Object o) {
            return delegate.contains(o);
        }

        @Override
        public void clear() {
        }

        @Override
        public boolean addAll(int index, Collection<? extends JsonValue> c) {
            return delegate.addAll(index, c);
        }

        @Override
        public boolean addAll(Collection<? extends JsonValue> c) {
            return delegate.addAll(c);
        }

        @Override
        public void add(int index, JsonValue element) {
            delegate.add(index, element);
        }

        @Override
        public boolean add(JsonValue e) {
            return delegate.add(e);
        }

        @Override
        public ValueType getValueType() {
            return ValueType.NULL;
        }

        @Override
        public boolean isNull(int index) {
            return true;
        }

        @Override
        public <T extends JsonValue> List<T> getValuesAs(Class<T> clazz) {
            return Collections.emptyList();
        }

        @Override
        public String getString(int index, String defaultValue) {
            return null;
        }

        @Override
        public String getString(int index) {
            return null;
        }

        @Override
        public JsonString getJsonString(int index) {
            return null;
        }

        @Override
        public JsonObject getJsonObject(int index) {
            return null;
        }

        @Override
        public JsonNumber getJsonNumber(int index) {
            return null;
        }

        @Override
        public JsonArray getJsonArray(int index) {
            return null;
        }

        @Override
        public int getInt(int index, int defaultValue) {
            return 0;
        }

        @Override
        public int getInt(int index) {
            return 0;
        }

        @Override
        public boolean getBoolean(int index, boolean defaultValue) {
            return false;
        }

        @Override
        public boolean getBoolean(int index) {
            return false;
        }
    };

    /**
     * Indicates the type of a {@link JsonValue} object.
     */
    enum ValueType {
        /**
         * JSON array.
         */
        ARRAY,

        /**
         * JSON object.
         */
        OBJECT,

        /**
         * JSON string.
         */
        STRING,

        /**
         * JSON number.
         */
        NUMBER,

        /**
         * JSON true.
         */
        TRUE,

        /**
         * JSON false.
         */
        FALSE,

        /**
         * JSON null.
         */
        NULL
    }

    /**
     * JSON null value.
     */
    static final JsonValue NULL = new JsonValueImpl(ValueType.NULL);

    /**
     * JSON true value.
     */
    static final JsonValue TRUE = new JsonValueImpl(ValueType.TRUE);

    /**
     * JSON false value.
     */
    static final JsonValue FALSE = new JsonValueImpl(ValueType.FALSE);

    /**
     * Returns the value type of this JSON value.
     *
     * @return JSON value type
     */
    ValueType getValueType();

    /**
     * Return the JsonValue as a JsonObject
     *
     * @return the JsonValue as a JsonObject
     * @throws ClassCastException if the JsonValue is not a JsonObject
     *
     * @since 1.1
     */
    default JsonObject asJsonObject() {
        return JsonObject.class.cast(this);
    }

    /**
     * Return the JsonValue as a JsonArray
     *
     * @return the JsonValue as a JsonArray
     * @throws ClassCastException if the JsonValue is not a JsonArray
     *
     * @since 1.1
     */
    default JsonArray asJsonArray() {
        return JsonArray.class.cast(this);
    }

    /**
     * Returns JSON text for this JSON value.
     *
     * @return JSON text
     */
    @Override
    String toString();

}
