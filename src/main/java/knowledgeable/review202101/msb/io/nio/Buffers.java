package knowledgeable.review202101.msb.io.nio;

import java.nio.ByteBuffer;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-02-25 Time: 09:57:52
 * Description:
 */
public class Buffers {
	ByteBuffer readBuffer;
	ByteBuffer writeBuffer;

	public Buffers(int readCapacity, int writeCapacity) {
		readBuffer = ByteBuffer.allocate(readCapacity);
		writeBuffer = ByteBuffer.allocate(writeCapacity);
	}

	public ByteBuffer getReadBuffer() {
		return readBuffer;
	}

	public ByteBuffer gerWriteBuffer() {
		return writeBuffer;
	}
}
