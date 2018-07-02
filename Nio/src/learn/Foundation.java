package learn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class Foundation {
    public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream=new FileInputStream(new File("D:/备份专用/测试.txt"));
		FileOutputStream fileOutputStream=new FileOutputStream(new File("D:/备份专用/入.txt"));
		ReadableByteChannel readableByteChannel=fileInputStream.getChannel();
		WritableByteChannel writableByteChannel=fileOutputStream.getChannel();
		ByteBuffer x=ByteBuffer.allocateDirect(10*1024);
		if(readableByteChannel.isOpen()) {
			while(readableByteChannel.read(x)!=-1);{
				x.flip();
				writableByteChannel.write(x);	
				x.clear();
				}		
		}
		readableByteChannel.close();
		writableByteChannel.close();
	}
}
