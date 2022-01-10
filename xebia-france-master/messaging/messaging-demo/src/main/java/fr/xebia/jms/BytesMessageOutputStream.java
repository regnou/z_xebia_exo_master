/*
 * Copyright 2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.xebia.jms;

import java.io.IOException;
import java.io.OutputStream;

import javax.jms.BytesMessage;
import javax.jms.JMSException;

import org.springframework.util.Assert;

/**
 * <p>
 * Small modification on
 * {@link org.springframework.ws.transport.jms.BytesMessageOutputStream} :
 * <ul>
 * <li>make class <code>public</code> instead of <code>protected</code>,</li>
 * </ul>
 * </p>
 * <p>
 * Initial javadoc:
 * </p>
 * <p>
 * Output stream that wraps a {@link BytesMessage}.
 * </p>
 * 
 * @author Arjen Poutsma
 * @since 1.5.0
 */
public class BytesMessageOutputStream extends OutputStream {

    private final BytesMessage message;

    public BytesMessageOutputStream(BytesMessage message) {
        Assert.notNull(message, "'message' must not be null");
        this.message = message;
    }

    public void write(byte b[]) throws IOException {
        try {
            message.writeBytes(b);
        } catch (JMSException ex) {
            throw new IOException(ex);
        }
    }

    public void write(byte b[], int off, int len) throws IOException {
        try {
            message.writeBytes(b, off, len);
        } catch (JMSException ex) {
            throw new IOException(ex);
        }
    }

    public void write(int b) throws IOException {
        try {
            message.writeByte((byte) b);
        } catch (JMSException ex) {
            throw new IOException(ex);
        }
    }
}
