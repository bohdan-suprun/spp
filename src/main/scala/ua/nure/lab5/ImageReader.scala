package ua.nure.lab5

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

import akka.actor.{Actor, ActorSystem, Props, Terminated}

/**
  * Class ImageReader implementation. 
  *
  * @author Bohdan_Suprun
  */
object ImageReader {

  def readImage(image: String): BufferedImage = {
    ImageIO.read(getClass.getResourceAsStream(s"/$image"))
  }

  def main(args: Array[String]): Unit = {
    readImage("image.jpg")
  }
}

class InvertorActor extends Actor {
  def receive: PartialFunction[Any, Unit] = {
    case task: Task =>
      for (x <- 0 until task.bufferedImage.getWidth()) {
        val old: Int = task.bufferedImage.getRGB(x, task.row)
        task.bufferedImage.setRGB(x, task.row, ~old)
      }

      context.stop(self)
  }
}

class MainActor extends Actor {
  private var image: BufferedImage = _
  private var actorsTerminated: Int = 0
  private var outputFile: String = _

  def receive: PartialFunction[Any, Unit] = {
    case (input: String, output: String) =>

      outputFile = output
      image = ImageReader.readImage(input)

      for (y <- 0 until image.getHeight) {
        val actor = context.actorOf(Props[InvertorActor])
        context.watch(actor)
        actor ! Task(y, image)
      }
    case Terminated(x) =>
      actorsTerminated += 1
      if (actorsTerminated == image.getHeight) {
        context.stop(self)
        context.system.shutdown()

        ImageIO.write(image, "jpg", new File(outputFile))
      }
  }
}

case class Task(row: Int, bufferedImage: BufferedImage)

object ImageReaderObject {
  def main(args: Array[String]): Unit = {
    val system: ActorSystem = ActorSystem()

    val actor = system.actorOf(Props[MainActor])
    actor ! ("image.jpg", "src/main/resources/image_out.jpg")
  }
}
