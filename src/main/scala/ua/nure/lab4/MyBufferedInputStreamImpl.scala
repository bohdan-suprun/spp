package ua.nure.lab4

import java.io.{ByteArrayInputStream, InputStream}

/**
  * Class MyBufferedInputStreamImpl implementation. 
  *
  * @author Bohdan_Suprun
  */
class MyBufferedInputStreamImpl(inputStream: InputStream, bufferSize: Int) extends MyBufferedInputStream {

  override def read(): Array[Byte] = {
    val arr = new Array[Byte](bufferSize)
    if (inputStream.read(arr) > 0) arr else Array()
  }
}


object MyBufferedInputStreamImpl {
  def main(args: Array[String]): Unit = {
    val buffer = new MyBufferedInputStreamImpl(new ByteArrayInputStream(Array[Byte](10, 20, 30, 40)), 2)

    println("Expected to be: [10, 20]")
    print("[")
    buffer.read().foreach(x => print(s"$x "))
    print("]\n")

    println("Expected to be: [30, 40]")
    print("[")
    buffer.read().foreach(x => print(s"$x "))
    print("]\n")

    println("Expected to be: []")
    print("[")
    buffer.read().foreach(x => print(s"$x "))
    print("]\n")
  }
}