
package openformula.util;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Unzipper
{
	ZipFile zipFile;

	public Unzipper(String path) throws IOException
	{
		this.zipFile = new ZipFile(path);
	}
	
	public byte[] extractToBuf(String entryName) throws IOException
	{
		byte[] buf = null;
		Enumeration<?> entries = zipFile.entries();
		
		while (entries.hasMoreElements())
		{
			ZipEntry entry = (ZipEntry) entries.nextElement();
			
			if (entry.getName().equals(entryName))
			{
				buf = extractEntry(entry);
				break;
			}
		}
		
		if (buf == null)
		{
			throw new FileNotFoundException(entryName);
		}
		
		return buf;
	}

	private byte[] extractEntry(ZipEntry entry) throws IOException
	{
		byte[] buf = null;
		BufferedInputStream input = null;
		
		try
		{
			int len = (int) entry.getSize();
			buf = new byte[len];
			
			input = new BufferedInputStream(this.zipFile.getInputStream(entry));
			
			int totalBytes = 0;
			int bytes = input.read(buf, totalBytes, len);
			
			while (bytes > 0)
			{
				totalBytes += bytes;
				bytes = input.read(buf, totalBytes, len - totalBytes);
			}
		}
		finally
		{
			if (input != null)
			{
				input.close();
			}
		}
		
		return buf;
	}
}
