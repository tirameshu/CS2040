import java.io.*;
import java.util.*;

class Grader {
  final private static int BUFFER_SIZE = 1 << 16;
  private static DataInputStream din = new DataInputStream(System.in);
  private static byte[] buffer = new byte[BUFFER_SIZE];
  private static int bufferPointer = 0, bytesRead = 0;
  
  public static void main(String[] args) throws IOException {
    PrintWriter pw = new PrintWriter(System.out);
    int Q = nextInt();
    BST bst = new BST();
    for (int i = 0; i < Q; ++i) {
      byte query = read();
      read();
      if (query == 'I') { //insert
        bst.insert(nextInt());
      } else if (query == 'S') {  //successor
        pw.println(bst.successor(nextInt()));
      } else if (query == 'P') { //predecessor
        pw.println(bst.predecessor(nextInt()));
      }
    }
    pw.flush();
    bst.inorder();
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
