package com.myjava.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author zzm
 */
public class HeapOOM {

	static class OOMObject {
    }

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		int i=0;
		while (true) {
			i++;
			list.add(new OOMObject());
			System.out.println(i);
		}
	}
}

