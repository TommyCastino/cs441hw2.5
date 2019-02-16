import java.rmi.{Naming, Remote}
import java.rmi.server.UnicastRemoteObject

trait RMIClient extends Remote {

}

//the client here just connects to the server and sends 2 of the same string
object RMIClient extends UnicastRemoteObject with RMIClient {

  def main(args: Array[String]): Unit = {
    val server = Naming.lookup("rmi://localhost/RMIFunctionality")

    val message = "this is the sent message"
    val messageCopy = message

    server.receiveMessage(message, messageCopy)
  }
}
