import akka.actor.{Props, ActorSystem}
import akka.cluster.{Cluster => AkkaCluster}
import com.typesafe.config.ConfigFactory

object Cluster {

  val config = ConfigFactory.load()
  val system = ActorSystem("test", config)
  val cluster = AkkaCluster(system)

  system.actorOf(Props[Metric], "metric")

  def main(args: Array[String]) {}
}
