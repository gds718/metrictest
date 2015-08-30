import akka.actor.{ActorLogging, Actor}
import akka.cluster.ClusterEvent.ClusterMetricsChanged

class Metric extends Actor with ActorLogging {
  Cluster.cluster.subscribe(self, classOf[ClusterMetricsChanged])

  override def receive = {
    case m: ClusterMetricsChanged =>
      m.nodeMetrics.toList.sortBy(_.address.toString).map(nm => nm.address -> nm.metric("processors")).foreach(println)
      println("--------------------------------------")
    case m => log.warning("unhandle message: {}", m)
  }
}
