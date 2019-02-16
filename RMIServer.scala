import java.rmi._
import java.rmi.server.UnicastRemoteObject


//any methods defined in the trait will be able to be called remotely
trait RMIServer extends Remote{
  def receiveMessage(text: String, text2: String): Unit
}

//this is the RMI server object
//when the client sends the two strings, it will change one and print them both
//since they both point to the same object in memory, both should say asdf
object RMIServer extends UnicastRemoteObject with RMIServer{

  def main(args: Array[String]): Unit = {
    Naming.rebind("RMIFunctionality", this)
  }

  def receiveMessage(text: String, text2: String): Unit = {
    println("Server reads: " + text + " and " + text2)
    println("Changing second variable to asdf")
    text2 = "asdf"
    println("New values are: " + text + " and " + text2)
  }
}
