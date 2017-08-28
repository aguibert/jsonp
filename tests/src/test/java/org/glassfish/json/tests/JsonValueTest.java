/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2016-2017 Oracle and/or its affiliates. All rights reserved.
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

package org.glassfish.json.tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.json.JsonValue;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Lukas Jungmann
 */
public class JsonValueTest {

    @Test(expected = UnsupportedOperationException.class)
    public void ensureImmutableArray() {
        JsonValue.EMPTY_JSON_ARRAY.add(JsonValue.TRUE);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void ensureImmutableObject() {
        JsonValue.EMPTY_JSON_OBJECT.put("test", JsonValue.TRUE);
    }

    @Test
    public void serialization() {
        byte[] data = serialize(JsonValue.TRUE);
        JsonValue value = deserialize(JsonValue.class, data);
        Assert.assertEquals(JsonValue.TRUE, value);

        data = serialize(JsonValue.FALSE);
        value = deserialize(JsonValue.class, data);
        Assert.assertEquals(JsonValue.FALSE, value);

        data = serialize(JsonValue.NULL);
        value = deserialize(JsonValue.class, data);
        Assert.assertEquals(JsonValue.NULL, value);
    }

    private byte[] serialize(Object o) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(o);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
        return baos.toByteArray();
    }

    private <T> T deserialize(Class<T> type, byte[] data) {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
