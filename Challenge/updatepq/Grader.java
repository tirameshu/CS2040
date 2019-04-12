import java.io.*;
import java.util.*;

class Grader {
  final private static int BUFFER_SIZE = 1 << 16;
  private static DataInputStream din = new DataInputStream(System.in);
  private static byte[] buffer = new byte[BUFFER_SIZE];
  private static int bufferPointer = 0, bytesRead = 0;
  
  public static void main(String[] args) throws IOException {
    int Q = nextInt();
    PrintWriter pw = new PrintWriter(System.out);
    BinaryHeap h = new BinaryHeap();
    for (int i = 0; i < Q; ++i) {
      byte query = read();
      read();
      if (query == 'I') {
        h.Insert(nextInt());
      } else if (query == 'E') {
        pw.println(h.ExtractMax());
      } else if (query == 'U') {
        h.UpdateKey(nextInt(), nextInt());
      }
    }
    
    while (h.size() > 0) {
      pw.print(h.ExtractMax());
      if (h.size() > 0) {
        pw.print(" ");
      } else {
        pw.println();
      }
    }
    pw.close();
  }

  private static int nextInt() throws IOException {
      int ret = 0;
      byte c = read();
      do {
          ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      return ret;
  }

  private static void fillBuffer() throws IOException {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1) buffer[0] = -1;
  }

  private static byte read() throws IOException {
      if (bufferPointer == bytesRead) fillBuffer();
      return buffer[bufferPointer++];
  }
}
