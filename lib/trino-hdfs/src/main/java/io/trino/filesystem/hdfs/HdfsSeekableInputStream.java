/*
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
package io.trino.filesystem.hdfs;

import io.trino.filesystem.SeekableInputStream;
import org.apache.hadoop.fs.FSDataInputStream;

import java.io.IOException;

import static java.util.Objects.requireNonNull;

class HdfsSeekableInputStream
        extends SeekableInputStream
{
    private final FSDataInputStream stream;

    HdfsSeekableInputStream(FSDataInputStream stream)
    {
        this.stream = requireNonNull(stream, "stream is null");
    }

    @Override
    public long getPosition()
            throws IOException
    {
        return stream.getPos();
    }

    @Override
    public void seek(long position)
            throws IOException
    {
        stream.seek(position);
    }

    @Override
    public int read()
            throws IOException
    {
        return stream.read();
    }

    @Override
    public int read(byte[] b)
            throws IOException
    {
        return stream.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len)
            throws IOException
    {
        return stream.read(b, off, len);
    }

    @Override
    public void close()
            throws IOException
    {
        stream.close();
    }
}
